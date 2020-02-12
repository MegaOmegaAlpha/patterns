package lab1.factory;

import lab1.factory.exceptions.DuplicateModelNameException;
import lab1.factory.interfaces.VehicleFactory;
import lab1.factory.interfaces.Vehicle;

public class MotoFactory implements VehicleFactory {

    @Override
    public Vehicle createInstance(String mark, int modelCapacity) {
        Motorcycle instance = null;
        try {
            instance = new Motorcycle(mark, modelCapacity);
        } catch (DuplicateModelNameException e) {
            e.printStackTrace();
        }
        return instance;
    }

}
