package lab1.factory;

import lab1.factory.exceptions.DuplicateModelNameException;
import lab1.factory.exceptions.ModelPriceOutOfBoundsException;
import lab1.factory.exceptions.NoSuchModelNameException;
import lab1.factory.interfaces.Vehicle;

import java.util.Arrays;

public class Car implements Vehicle, Cloneable {

    private String mark;
    private Model[] models;

    public Car(String mark, int modelCapacity) {
        this.mark = mark;
        models = new Model[modelCapacity];
        for (int i = 0; i < models.length; i++) {
            models[i] = new Model("default model " + i, 0);
        }
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public void setModelName(String oldName, String newName) throws DuplicateModelNameException, NoSuchModelNameException {
        int index = getModelIndexByName(newName);
        if (index == -1) {
            index = getModelIndexByName(oldName);
            if (index != -1) {
                models[index].name = newName;
            } else {
                throw new NoSuchModelNameException(oldName);
            }
        } else {
            throw new DuplicateModelNameException(newName);
        }
        /*int index = getModelIndexByName(oldName);
        if (index != -1) {
            if (getModelIndexByName(name) == -1) {
                models[index].name = name;
            } else {
                throw new DuplicateModelNameException();
            }
        }*/
    }

    public String[] getModelNames() {
        String[] array = new String[models.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = models[i].name;
        }
        return array;
    }

    public double getPriceByName(String name) throws NoSuchModelNameException {
        int modelIndex = getModelIndexByName(name);
        if (modelIndex != -1) {
            return models[modelIndex].price;
        } else {
            throw new NoSuchModelNameException(name);
        }
    }

    public void setPriceByName(String name, double price) throws NoSuchModelNameException {
        int modelIndex = getModelIndexByName(name);
        if (modelIndex != -1) {
            if (0 < price && price < Double.MAX_VALUE) {
                models[modelIndex].price = price;
            } else {
                throw new ModelPriceOutOfBoundsException();
            }
        } else {
            throw new NoSuchModelNameException(name);
        }
    }

    public double[] getModelPrices() {
        double[] array = new double[models.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = models[i].price;
        }
        return array;
    }

    public void addModel(String name, double price) throws DuplicateModelNameException {
        if (getModelIndexByName(name) == -1) {
            if (0 < price && price <= Double.MAX_VALUE) {
                models = Arrays.copyOf(models, models.length + 1);
                models[models.length - 1] = new Model(name, price);
            } else {
                throw new ModelPriceOutOfBoundsException();
            }
        } else {
            throw new DuplicateModelNameException(name);
        }
    }

    public void deleteModel(String name) throws NoSuchModelNameException {
        int modelIndex = getModelIndexByName(name);
        if (modelIndex != -1) {
            System.arraycopy(models, modelIndex + 1, models, modelIndex, models.length - modelIndex - 1);
            models = Arrays.copyOf(models, models.length - 1);
        } else {
            throw new NoSuchModelNameException(name);
        }
    }

    private int getModelIndexByName(String name) {
        for (int i = 0; i < models.length; i++) {
            if (models[i].name.equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public int getModelsSize() {
        return models.length;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Car clone = (Car) super.clone();
        clone.models = this.models.clone();
        for (int i = 0; i < models.length; i++) {
            clone.models[i] = (Model) this.models[i].clone();
        }
        return clone;
    }

    private class Model implements Cloneable {

        String name;
        double price;

        Model(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public Model() {
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
}
