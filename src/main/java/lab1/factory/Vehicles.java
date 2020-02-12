package lab1.factory;

import lab1.factory.interfaces.Vehicle;
import lab1.factory.interfaces.VehicleFactory;

import java.util.Arrays;

public class Vehicles {

    private static VehicleFactory factory = new AutoFactory();

    public static double averagePrice(Vehicle vehicle) {
        double[] prices = vehicle.getModelPrices();
        double result = 0;
        for (double price : prices) {
            result += price;
        }
        return result / prices.length;
    }

    public static void printModels(Vehicle vehicle) {
        Arrays.stream(vehicle.getModelNames()).forEach(System.out::println);
    }

    public static void printPrices(Vehicle vehicle) {
        Arrays.stream(vehicle.getModelPrices()).forEach(System.out::println);
    }

    public static void setFactory(VehicleFactory vehicleFactory) {
        factory = vehicleFactory;
    }

    public static Vehicle createInstance(String mark, int modelCapacity) {
        return factory.createInstance(mark, modelCapacity);
    }

}
