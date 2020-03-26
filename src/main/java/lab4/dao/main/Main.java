package lab4.dao.main;

import lab1.factory.Car;
import lab1.factory.Motorcycle;
import lab1.factory.Vehicles;
import lab1.factory.interfaces.Vehicle;
import lab4.dao.VehicleDao;
import lab4.dao.VehicleWriter;

import java.io.File;

public class Main {

    public static void main(String[] args) {

        Vehicle vehicle = new Motorcycle("TOYOTA", 5);
        VehicleDao vehicleDao = new VehicleWriter(new File("daoWriter.txt"));
        vehicleDao.writeVehicle(vehicle);

        Vehicle vehicle1 = vehicleDao.readVehicle();
        System.out.println(vehicle1.getMark());
        Vehicles.printModels(vehicle1);
        Vehicles.printPrices(vehicle1);




    }

}
