package lab1.factory;

import lab1.factory.exceptions.DuplicateModelNameException;
import lab1.factory.exceptions.ModelPriceOutOfBoundsException;
import lab1.factory.exceptions.NoSuchModelNameException;
import lab1.factory.interfaces.Vehicle;

public class Motorcycle implements Vehicle {

    private class Model {

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
    }

    private Model head = new Model();
    private String mark;
    private int size;

    {
        head.prev = head;
        head.next = head;
    }

    public Motorcycle(String mark, int modelCapacity) throws DuplicateModelNameException {
        this.mark = mark;
        while (size < modelCapacity) {
            addModel("default name", 0);
        }
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public void setModelName(int index, String name) throws DuplicateModelNameException {
        if (0 <= index && index < size) {
            Model model = getModelByName(name);
            if (model != null) {
                model = getModelByIndex(index);
                model.name = name;
            } else {
                throw new DuplicateModelNameException();
            }
        }
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
            throw new NoSuchModelNameException();
        }
    }

    @Override
    public void setPriceByName(String name, double price) throws NoSuchModelNameException {
        Model model = getModelByName(name);
        if (0 < price && price < Double.MAX_VALUE) {
            if (model != null) {
                model.price = price;
            } else {
                throw new NoSuchModelNameException();
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
                throw new DuplicateModelNameException();
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
            //todo!!!
        } else {
            throw new NoSuchModelNameException();
        }
    }

    @Override
    public int getModelsSize() {
        return size;
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
