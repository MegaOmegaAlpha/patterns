package lab3.main;

import lab1.factory.Car;
import lab1.factory.Vehicles;
import lab1.factory.exceptions.DuplicateModelNameException;

public class Main {

    public static void main(String[] args) throws DuplicateModelNameException {
        /*
        Printer rowPrinter = new RowPrinter();
        rowPrinter.setNext(new ColumnPrinter());

        Vehicle vehicle = Vehicles.createInstance("vaz", 4);
        rowPrinter.print(vehicle);

         */
        /*
        try (Writer writer = new FileWriter(new File("file.txt"))) {
            Car car = new Car("rrr", 5);

            car.setCommand(new ColumnWriter());
            car.print(writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

         */

        Car carOrig = new Car("zil", 5);

        Car.Memento memento = carOrig.createMemento();

        carOrig.addModel("zzz", 555);
        Vehicles.printModels(carOrig);
        System.out.println();

        Car carMem = carOrig.readMemento(memento);
        Vehicles.printModels(carMem);

    }

}
