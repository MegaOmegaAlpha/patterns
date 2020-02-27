package lab3.visitor;

import lab1.factory.Car;
import lab1.factory.Motorcycle;

public class PrintVisitor implements Visitor {

    @Override
    public void visit(Car car) {
        String[] models = car.getModelNames();
        double[] prices = car.getModelPrices();
        for (int i = 0; i < car.getModelsSize(); i++) {
            System.out.print(models[i] + ": " + prices[i] + "; ");
        }
        System.out.println();
    }

    @Override
    public void visit(Motorcycle motorcycle) {
        String[] models = motorcycle.getModelNames();
        double[] prices = motorcycle.getModelPrices();
        for (int i = 0; i < motorcycle.getModelsSize(); i++) {
            System.out.println(models[i] + ": " + prices[i] + "; ");
        }
    }

}
