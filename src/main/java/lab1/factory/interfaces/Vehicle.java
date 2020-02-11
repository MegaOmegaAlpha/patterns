package lab1.factory.interfaces;

import lab1.factory.exceptions.DuplicateModelNameException;
import lab1.factory.exceptions.NoSuchModelNameException;

public interface Vehicle {

    String getMark();
    void setMark(String mark);
    void setModelName(int index, String name) throws DuplicateModelNameException;
    String[] getModelNames();
    double getPriceByName(String name) throws NoSuchModelNameException;
    void setPriceByName(String name, double price) throws NoSuchModelNameException;
    double[] getModelPrices();
    void addModel(String name, double price) throws DuplicateModelNameException;
    void deleteModel(String name) throws NoSuchModelNameException;
    int getModelsSize();

}
