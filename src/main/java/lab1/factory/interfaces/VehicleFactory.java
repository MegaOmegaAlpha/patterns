package lab1.factory.interfaces;

import lab1.factory.exceptions.DuplicateModelNameException;

public interface VehicleFactory {

    Vehicle createInstance(String mark, int modelCapacity);

}
