package lab4.dao;

import lab1.factory.interfaces.Vehicle;

public interface VehicleDao {

    Vehicle readVehicle();
    void writeVehicle(Vehicle vehicle);

}
