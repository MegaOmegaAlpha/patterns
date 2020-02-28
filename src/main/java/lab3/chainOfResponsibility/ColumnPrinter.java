package lab3.chainOfResponsibility;

import lab1.factory.interfaces.Vehicle;

import java.io.*;

public class ColumnPrinter implements Printer {

    private Printer nextPrinter;
    private File file;

    public ColumnPrinter(File file) {
        this.file = file;
    }

    @Override
    public void print(Vehicle vehicle) {
        try (PrintWriter writer = new PrintWriter(file)) {
            if (vehicle.getModelsSize() > 3) {
                String[] models = vehicle.getModelNames();
                double[] prices = vehicle.getModelPrices();
                for (int i = 0; i < vehicle.getModelsSize(); i++) {
                    writer.println(models[i] + ": " + prices[i] + " ");
                }
            } else {
                nextPrinter.print(vehicle);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setNext(Printer printer) {
        this.nextPrinter = printer;
    }

}
