package lab3.chainOfResponsibility;

import lab1.factory.interfaces.Vehicle;

public class ColumnPrinter implements Printer {

    private Printer nextPrinter;

    @Override
    public void print(Vehicle vehicle) {
        if (vehicle.getModelsSize() > 3) {
            String[] models = vehicle.getModelNames();
            double[] prices = vehicle.getModelPrices();
            for (int i = 0; i < vehicle.getModelsSize(); i++) {
                System.out.println(models[i] + ": " + prices[i] + " ");
            }
        } else {
            nextPrinter.print(vehicle);
        }
    }

    @Override
    public void setNext(Printer printer) {
        this.nextPrinter = printer;
    }

}
