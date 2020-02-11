package lab1.factory;

import lab1.factory.exceptions.DuplicateModelNameException;
import lab1.factory.exceptions.ModelPriceOutOfBoundsException;
import lab1.factory.exceptions.NoSuchModelNameException;
import lab1.factory.interfaces.Vehicle;

import java.util.Arrays;

public class Car implements Vehicle {

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

    public void setModelName(int index, String name) throws DuplicateModelNameException {
        if (0 <= index && index < models.length) {
            if (getModelIndexByName(name) == -1) {
                models[index].name = name;
            } else {
                throw new DuplicateModelNameException();
            }
        }
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
            throw new NoSuchModelNameException();
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
            throw new NoSuchModelNameException();
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
            throw new DuplicateModelNameException();
        }
    }

    public void deleteModel(String name) throws NoSuchModelNameException {
        int modelIndex = getModelIndexByName(name);
        if (modelIndex != -1) {
            System.arraycopy(models, modelIndex + 1, models, modelIndex, models.length - modelIndex - 1);
            models = Arrays.copyOf(models, models.length - 1);
        } else {
            throw new NoSuchModelNameException();
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

    private class Model {

        String name;
        double price;

        Model(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public Model() {
        }
    }
}
