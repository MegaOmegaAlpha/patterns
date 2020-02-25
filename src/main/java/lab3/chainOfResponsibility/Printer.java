package lab3.chainOfResponsibility;

import lab1.factory.interfaces.Vehicle;

public interface Printer {

    void print(Vehicle vehicle);
    void setNext(Printer printer);

}
