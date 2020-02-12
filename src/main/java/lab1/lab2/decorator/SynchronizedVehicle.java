package lab1.lab2.decorator;

import lab1.factory.exceptions.DuplicateModelNameException;
import lab1.factory.exceptions.NoSuchModelNameException;
import lab1.factory.interfaces.Vehicle;

public class SynchronizedVehicle implements Vehicle {

    private Vehicle vehicle;

    public SynchronizedVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public synchronized String getMark() {
        return vehicle.getMark();
    }

    @Override
    public synchronized void setMark(String mark) {
        vehicle.setMark(mark);
    }

    @Override
    public synchronized void setModelName(int index, String name) throws DuplicateModelNameException {
        vehicle.setModelName(index, name);
    }

    @Override
    public synchronized String[] getModelNames() {
        return vehicle.getModelNames();
    }

    @Override
    public synchronized double getPriceByName(String name) throws NoSuchModelNameException {
        return vehicle.getPriceByName(name);
    }

    @Override
    public synchronized void setPriceByName(String name, double price) throws NoSuchModelNameException {
        vehicle.setPriceByName(name, price);
    }

    @Override
    public synchronized double[] getModelPrices() {
        return vehicle.getModelPrices();
    }

    @Override
    public synchronized void addModel(String name, double price) throws DuplicateModelNameException {
        vehicle.addModel(name, price);
    }

    @Override
    public synchronized void deleteModel(String name) throws NoSuchModelNameException {
        vehicle.deleteModel(name);
    }

    @Override
    public synchronized int getModelsSize() {
        return vehicle.getModelsSize();
    }

}
