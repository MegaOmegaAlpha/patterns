package lab1.factory;

import java.util.Iterator;

public class CarIteratorTest {

    public static void main(String[] args) {
        Car car = new Car("new", 5);
        for (Car.Model model : car) {
            System.out.println(model);
        }
    }

}
