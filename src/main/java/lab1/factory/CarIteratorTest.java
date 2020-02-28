package lab1.factory;

import java.util.Iterator;

public class CarIteratorTest {

    public static void main(String[] args) {
        Car car = new Car("new", 5);
        Iterator<Car.Model> iterator = car.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
