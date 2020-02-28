package lab3.chainOfResponsibility;

import lab1.factory.interfaces.Vehicle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class RowPrinter implements Printer {

    private Printer nextPrinter;
    private File file;

    public RowPrinter(File file) {
        this.file = file;
    }

    @Override
    public void print(Vehicle vehicle) {
        try (PrintWriter writer = new PrintWriter(file)) {
            if (vehicle.getModelsSize() <= 3) {
                String[] models = vehicle.getModelNames();
                double[] prices = vehicle.getModelPrices();
                for (int i = 0; i < vehicle.getModelsSize(); i++) {
                    writer.print(models[i] + ": " + prices[i] + "; ");
                }
            } else {
                nextPrinter.print(vehicle);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setNext(Printer printer) {
        this.nextPrinter = printer;
    }

}
