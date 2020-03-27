package lab4.dao;

import lab1.factory.interfaces.Vehicle;

import java.io.*;

public class VehicleSerializer implements VehicleDao {

    private File file;

    public VehicleSerializer(File file) {
        this.file = file;
    }

    @Override
    public Vehicle readVehicle() {
        Vehicle vehicle = null;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))) {
            vehicle = (Vehicle) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return vehicle;
    }

    @Override
    public void writeVehicle(Vehicle vehicle) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            outputStream.writeObject(vehicle);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
