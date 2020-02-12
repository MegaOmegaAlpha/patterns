package lab1.factory;

import lab1.factory.interfaces.VehicleFactory;
import lab1.factory.interfaces.Vehicle;

public class AutoFactory implements VehicleFactory {

    @Override
    public Vehicle createInstance(String mark, int modelCapacity) {
        return new Car(mark, modelCapacity);
    }

}
