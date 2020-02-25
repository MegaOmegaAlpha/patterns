package lab3.chainOfResponsibility;

import lab1.factory.interfaces.Vehicle;

public class RowPrinter implements Printer {

    private Printer nextPrinter;

    @Override
    public void print(Vehicle vehicle) {
        if (vehicle.getModelsSize() <= 3) {
            String[] models = vehicle.getModelNames();
            double[] prices = vehicle.getModelPrices();
            for (int i = 0; i < vehicle.getModelsSize() - 1; i++) {
                System.out.print(models[i] + ": " + prices[i] + "; ");
            }
            System.out.print(models[models.length - 1] + ": " + prices[prices.length - 1]);
            System.out.println();
        } else {
            nextPrinter.print(vehicle);
        }
    }

    @Override
    public void setNext(Printer printer) {
        this.nextPrinter = printer;
    }

}
