package lab1.factory;

import lab1.factory.exceptions.DuplicateModelNameException;
import lab1.factory.exceptions.ModelPriceOutOfBoundsException;
import lab1.factory.exceptions.NoSuchModelNameException;
import lab1.factory.interfaces.Vehicle;

public class Motorcycle implements Vehicle, Cloneable {

    private class Model implements Cloneable{

        String name;
        double price;
        Model next;
        Model prev;

        public Model(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public Model() {
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

    }

    private Model head = new Model();
    private String mark;
    private int size;

    {
        head.prev = head;
        head.next = head;
    }

    public Motorcycle(String mark, int modelCapacity) {
        this.mark = mark;
        while (size < modelCapacity) {
            try {
                addModel("Car model " + size, size + 1);
            } catch (DuplicateModelNameException e) {
                e.printStackTrace();
            }
        }
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public void setModelName(String oldName, String newName) throws DuplicateModelNameException, NoSuchModelNameException {
        Model model = getModelByName(newName);
        if (model == null) {
            model = getModelByName(oldName);
            if (model != null) {
                model.name = newName;
            } else {
                throw new NoSuchModelNameException(oldName);
            }
        } else {
            throw new DuplicateModelNameException(newName);
        }
        /*
        if (0 <= index && index < size) {
            Model model = getModelByName(name);
            if (model == null) {
                model = getModelByIndex(index);
                model.name = name;
            } else {
                throw new DuplicateModelNameException();
            }
        }

         */
    }

    @Override
    public String[] getModelNames() {
        String[] array = new String[size];
        Model model = head.next;
        for (int i = 0; i < array.length; i++, model = model.next) {
            array[i] = model.name;
        }
        return array;
    }

    @Override
    public double getPriceByName(String name) throws NoSuchModelNameException {
        Model model = getModelByName(name);
        if (model != null) {
            return model.price;
        } else {
            throw new NoSuchModelNameException(name);
        }
    }

    @Override
    public void setPriceByName(String name, double price) throws NoSuchModelNameException {
        Model model = getModelByName(name);
        if (0 < price && price < Double.MAX_VALUE) {
            if (model != null) {
                model.price = price;
            } else {
                throw new NoSuchModelNameException(name);
            }
        } else {
            throw new ModelPriceOutOfBoundsException();
        }
    }

    @Override
    public double[] getModelPrices() {
        double[] prices = new double[size];
        Model model = head.next;
        for (int i = 0; i < prices.length; i++, model = model.next) {
            prices[i] = model.price;
        }
        return prices;
    }

    @Override
    public void addModel(String name, double price) throws DuplicateModelNameException {
        if (0 < price && price < Double.MAX_VALUE) {
            if (getModelByName(name) == null) {
                Model newModel = new Model(name, price);
                Model lastModel = head.prev;
                lastModel.next = newModel;
                newModel.prev = lastModel;
                newModel.next = head;
                head.prev = newModel;
                size++;
            } else {
                throw new DuplicateModelNameException(name);
            }
        } else {
            throw new ModelPriceOutOfBoundsException();
        }
    }

    @Override
    public void deleteModel(String name) throws NoSuchModelNameException {
        Model toDelete = getModelByName(name);
        if (toDelete != null) {
            Model nodeBefore = toDelete.prev;
            Model nodeAfter = toDelete.next;
            nodeBefore.next = nodeAfter;
            nodeAfter.prev = nodeBefore;
            toDelete = null;
            size--;
            //todo:complete linking
        } else {
            throw new NoSuchModelNameException(name);
        }
    }

    @Override
    public int getModelsSize() {
        return size;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Motorcycle clone = (Motorcycle) super.clone();
        clone.head = (Model) this.head.clone();
        Model clonedModel = clone.head;
        Model toClone = this.head.next;
        Model currentModelToClone = clone.head;
        while (toClone != this.head) {
            currentModelToClone = (Model) toClone.clone();
            clonedModel.next = currentModelToClone;
            currentModelToClone.prev = clonedModel;
            clonedModel = clonedModel.next;
            toClone = toClone.next;
        }
        currentModelToClone.next = clone.head;
        clone.head.prev = currentModelToClone;

        return clone;

        /*Motorcycle clone = null;
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
             ObjectOutput objectOutput = new ObjectOutputStream(byteArrayOutputStream);
             ObjectInput objectInput = new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()))) {

            objectOutput.writeObject(this);
            clone = (Motorcycle) objectInput.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return clone;

         */
    }

    private Model getModelByName(String name) {
        Model model = head.next;
        while (model != head) {
            if (model.name.equals(name)) {
                return model;
            }
            model = model.next;
        }
        return null;
    }

    private Model getModelByIndex(int index) {
        int counter = 0;
        Model model = head.next;
        while (counter != index) {
            model = model.next;
            counter++;
        }
        return model;
    }

}
