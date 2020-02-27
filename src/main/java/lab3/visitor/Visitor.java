package lab3.visitor;

import lab1.factory.Car;
import lab1.factory.Motorcycle;

public interface Visitor {

    void visit(Car car);
    void visit(Motorcycle motorcycle);

}
