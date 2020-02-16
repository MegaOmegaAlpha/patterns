package lab1.main;

import lab1.factory.Car;
import lab1.factory.MotoFactory;
import lab1.factory.Motorcycle;
import lab1.factory.Vehicles;
import lab1.factory.exceptions.DuplicateModelNameException;
import lab1.factory.exceptions.NoSuchModelNameException;
import lab1.factory.interfaces.Vehicle;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws DuplicateModelNameException, NoSuchModelNameException, CloneNotSupportedException {

        /*Properties properties = SingletonImpl.getProperties();
        for (Object key : properties.keySet()) {
            System.out.println(key + " = " + properties.get(key));
        }*/

        /*
        Vehicle car = new Car("big car", 5);
        car.setModelName("default model 1", "wetweg");
        car.setPriceByName("wetweg", 124.125);
        car.addModel("w34", 1000_000);
        car.deleteModel("default model 0");

        Arrays.stream(car.getModelNames()).forEach(System.out::println);
        System.out.println();
        Arrays.stream(car.getModelPrices()).forEach(System.out::println);
        System.out.println();
        System.out.println(car.getPriceByName("wetweg"));
        */

        /*
        Vehicle motorcycle = new Motorcycle("honda", 5);
        motorcycle.setModelName("default model 1", "best model");
        motorcycle.setPriceByName("best model", 124.51);
        motorcycle.addModel("new model", 45.5);
        motorcycle.deleteModel("default model 2");

        Arrays.stream(motorcycle.getModelNames()).forEach(System.out::println);
        System.out.println();
        Arrays.stream(motorcycle.getModelPrices()).forEach(System.out::println);
        System.out.println();
        System.out.println(motorcycle.getModelsSize());
        */

        /*
        Vehicle vehicle = Vehicles.createInstance("lovely car", 5);
        System.out.println(vehicle.getClass().getName());
        Vehicles.setFactory(new MotoFactory());
        vehicle = Vehicles.createInstance("lovely moto", 5);
        System.out.println(vehicle.getClass().getName());
        */

        /*
        Car car = new Car("mark1", 5);
        Vehicle clone = (Vehicle) car.clone();
        car.setModelName("default model 2", "big model");
        car.setPriceByName("big model", 123.123);


        Vehicles.printModels(car);
        Vehicles.printPrices(car);
        System.out.println();
        Vehicles.printModels(clone);
        Vehicles.printPrices(clone);
        */


        Motorcycle moto = new Motorcycle("moto mark", 5);
        Motorcycle clone = (Motorcycle) moto.clone();

        moto.setModelName("default model 3", "other name");
        moto.deleteModel("default model 4");

        clone.setModelName("default model 0", "some name");
        clone.addModel("new", 123.124);
        clone.deleteModel("some name");

        Vehicles.printModels(moto);
        Vehicles.printPrices(moto);
        System.out.println();
        Vehicles.printModels(clone);
        Vehicles.printPrices(clone);

    }

}
