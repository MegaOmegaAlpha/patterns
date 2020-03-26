package lab4.dao;

import lab1.factory.AutoFactory;
import lab1.factory.MotoFactory;
import lab1.factory.Vehicles;
import lab1.factory.exceptions.DuplicateModelNameException;
import lab1.factory.interfaces.Vehicle;
import lab1.factory.interfaces.VehicleFactory;

import java.io.*;

public class VehicleWriter implements VehicleDao {

    private File file;

    public VehicleWriter(File file) {
        this.file = file;
    }

    @Override
    public Vehicle readVehicle() {
        Vehicle vehicle = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String className = reader.readLine().split(" ")[1];
            Vehicles.setFactory(getFactoryByVehicleClassName(className));
            String mark = reader.readLine();
            int modelsCounter = Integer.parseInt(reader.readLine());
            vehicle = Vehicles.createInstance(mark, 0);
            for (int i = 0; i < modelsCounter; i++) {
                vehicle.addModel(reader.readLine(), Double.parseDouble(reader.readLine()));
            }
        } catch (IOException | DuplicateModelNameException e) {
            e.printStackTrace();
        }
        return vehicle;
    }

    @Override
    public void writeVehicle(Vehicle vehicle) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            writer.println(vehicle.getClass());
            writer.println(vehicle.getMark());
            int modelsCounter = vehicle.getModelsSize();
            writer.println(modelsCounter);
            String[] modelNames = vehicle.getModelNames();
            double[] modelPrices = vehicle.getModelPrices();
            for (int i = 0; i < modelsCounter; i++) {
                writer.println(modelNames[i]);
                writer.println(modelPrices[i]);
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private VehicleFactory getFactoryByVehicleClassName(String className) {
        if (className.contains("Car")) {
            return new AutoFactory();
        } else if (className.contains("Motorcycle")) {
            return new MotoFactory();
        }
        return null;
    }
}
