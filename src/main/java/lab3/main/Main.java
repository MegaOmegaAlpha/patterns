package lab3.main;

import lab1.factory.Car;
import lab1.factory.Vehicles;
import lab1.factory.interfaces.Vehicle;
import lab3.command.ColumnWriter;
import lab3.command.RowWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Main {

    public static void main(String[] args) throws IOException {
        /*
        Printer rowPrinter = new RowPrinter();
        rowPrinter.setNext(new ColumnPrinter());

        Vehicle vehicle = Vehicles.createInstance("vaz", 4);
        rowPrinter.print(vehicle);

         */

        Car car = new Car("rrr", 5);
        Writer writer = new FileWriter(new File("file.txt"));
        car.setCommand(new ColumnWriter());
        car.print(writer);
    }

}
