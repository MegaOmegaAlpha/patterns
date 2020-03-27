package lab4.mvc.model;

import org.jfree.data.xy.XYSeries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PowerFunction {

    private static final int PREFERABLE_NUMBER_DEGREE = 3;

    private List<Double> xValues;

    public PowerFunction(double... xValues) {
        this.xValues = new ArrayList<>();
        Arrays.stream(xValues).forEach(this.xValues::add);
    }

    public List<Double> calculateValuesY() {
        List<Double> result = new ArrayList<>(this.xValues.size());
        for (Double value : xValues) {
            result.add(Math.pow(value, PREFERABLE_NUMBER_DEGREE));
        }
        return result;
    }

    public List<Double> calculateValuesY(List<Double> xValues) {
        List<Double> result = new ArrayList<>(xValues.size());
        for (Double value : xValues) {
            result.add(Math.pow(value, PREFERABLE_NUMBER_DEGREE));
        }
        return result;
    }

    public double calculateValueY(double x) {
        return Math.pow(x, PREFERABLE_NUMBER_DEGREE);
    }

    public XYSeries getXYSeries(List<Double> xValues) {
        XYSeries series = new XYSeries("", false);
        for (double value : xValues) {
            series.add(value, calculateValueY(value));
        }
        return series;
    }

}
