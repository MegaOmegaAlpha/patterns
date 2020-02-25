package lab3.command;

import lab1.factory.Car;

import java.io.IOException;
import java.io.Writer;

public class RowWriter implements Command {

    @Override
    public void performCommand(Car car, Writer writer) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            String[] models = car.getModelNames();
            double[] prices = car.getModelPrices();
            for (int i = 0; i < car.getModelsSize() - 1; i++) {
                stringBuilder.append(models[i]).append(": ").append(prices[i]).append("; ");
            }
            stringBuilder.append(models[models.length - 1]).append(": ").append(prices[prices.length - 1]);
            writer.write(String.valueOf(stringBuilder));
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
