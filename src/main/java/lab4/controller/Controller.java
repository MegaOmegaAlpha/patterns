package lab4.controller;

import lab4.model.PowerFunction;
import lab4.view.FunctionWindow;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private PowerFunction function;
    private FunctionWindow window;

    public Controller(PowerFunction function, FunctionWindow window) {
        this.function = function;
        this.window = window;
        initListeners();
        draw();
    }

    private void initListeners() {
        window.getButtonAdd().addActionListener(actionEvent -> addNewRow());
        window.getButtonRemove().addActionListener(actionEvent -> removeSelectedRow());
        window.getButtonUpdate().addActionListener(actionEvent -> updateChart());
    }

    private void addNewRow() {
        DefaultTableModel model = (DefaultTableModel) window.getTable1().getModel();
        model.addRow(new Object[]{""});
    }

    private void removeSelectedRow() {
        int selectedRowIndex = window.getTable1().getSelectedRow();
        if (selectedRowIndex != -1) {
            DefaultTableModel model = (DefaultTableModel) window.getTable1().getModel();
            model.removeRow(window.getTable1().getSelectedRow());
        }
    }

    private void updateChart() {
        scanForChangedValues();
        draw();
    }

    private void draw() {
        JPanel panel = window.getPanel1();
        panel.removeAll();
        panel.updateUI();
        panel.add(createNewChart(scanForChangedValues()));
    }

    private List<Double> scanForChangedValues() {
        List<Double> values = new ArrayList<>();
        TableModel model = window.getTable1().getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            values.add(Double.parseDouble((String) model.getValueAt(i, 0)));
        }
        return values;
    }

    private ChartPanel createNewChart(List<Double> values) {
        XYSeries series = new XYSeries("", false);
        for (double value : values) {
            series.add(value, function.calculateValueY(value));
        }
        XYDataset dataset = new XYSeriesCollection(series);
        return new ChartPanel(ChartFactory.createXYLineChart(
                "power function", "x", "y", dataset
        ));
    }

}