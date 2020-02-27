package lab2.decorator;

import lab1.factory.Car;
import lab1.factory.Motorcycle;
import lab1.factory.exceptions.DuplicateModelNameException;
import lab1.factory.exceptions.NoSuchModelNameException;
import lab1.factory.interfaces.Vehicle;
import lab3.visitor.Visitor;

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
    public synchronized void setModelName(String oldName, String newName) throws DuplicateModelNameException, NoSuchModelNameException {
        vehicle.setModelName(oldName, newName);
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

    @Override
    public synchronized void accept(Visitor visitor) {
        if (vehicle instanceof Car) {
            visitor.visit((Car) vehicle);
        } else {
            visitor.visit((Motorcycle) vehicle);
        }
    }

}
