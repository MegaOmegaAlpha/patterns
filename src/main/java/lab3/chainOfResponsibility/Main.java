package lab3.chainOfResponsibility;

import lab1.factory.Vehicles;
import lab1.factory.interfaces.Vehicle;

public class Main {

    public static void main(String[] args) {
        Printer rowPrinter = new RowPrinter();
        rowPrinter.setNext(new ColumnPrinter());

        Vehicle vehicle = Vehicles.createInstance("vaz", 4);
        rowPrinter.print(vehicle);
    }

}
