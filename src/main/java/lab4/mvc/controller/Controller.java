package lab4.mvc.controller;

import lab4.mvc.model.PowerFunction;
import lab4.mvc.view.FunctionWindow;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Controller {

    private PowerFunction function;
    private FunctionWindow window;

    public Controller(PowerFunction function, FunctionWindow window) {
        this.function = function;
        this.window = window;
        initListeners();
        updateChart();
        this.window.setVisible(true);
        this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        try {
            window.drawChart(function.getXYSeries(window.scanForXValues()));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(window, "Invalid number detected", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
