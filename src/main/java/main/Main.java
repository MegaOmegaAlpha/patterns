package main;

import lab1.factory.Car;
import lab1.factory.Motorcycle;
import lab1.factory.exceptions.DuplicateModelNameException;
import lab1.factory.exceptions.NoSuchModelNameException;
import lab1.factory.interfaces.Vehicle;
import lab1.singleton.SingletonImpl;

import java.util.Arrays;
import java.util.Properties;

public class Main {

    public static void main(String[] args) throws DuplicateModelNameException, NoSuchModelNameException {

        /*Properties properties = SingletonImpl.getProperties();
        for (Object key : properties.keySet()) {
            System.out.println(key + " = " + properties.get(key));
        }*/


        Vehicle car = new Car("big car", 5);
        car.setModelName(2, "wetweg");
        car.setPriceByName("wetweg", 124.125);
        car.addModel("w34", 1000_000);
        car.deleteModel("default model 0");

        Arrays.stream(car.getModelNames()).forEach(System.out::println);
        System.out.println();
        Arrays.stream(car.getModelPrices()).forEach(System.out::println);
        System.out.println();
        System.out.println(car.getPriceByName("wetweg"));
        /*
        Motorcycle motorcycle = new Motorcycle("honda", 5);
         */

    }

}
