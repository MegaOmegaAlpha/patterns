/*
 * Created by JFormDesigner on Thu Mar 26 12:42:07 GMT+04:00 2020
 */

package lab4.mvc.view;

import javax.swing.table.*;

import lab4.mvc.controller.Controller;
import lab4.mvc.model.PowerFunction;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Vladimir
 */
public class FunctionWindow extends JFrame {

    public static void main(String[] args) {
        FunctionWindow window = new FunctionWindow();
        PowerFunction function = new PowerFunction();
        Controller controller = new Controller(function, window);

        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public FunctionWindow() {
        initComponents();
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public JScrollPane getScrollPane1() {
        return scrollPane1;
    }

    public JTable getTable1() {
        return table1;
    }

    public JButton getButtonAdd() {
        return buttonAdd;
    }

    public JButton getButtonRemove() {
        return buttonRemove;
    }

    public JButton getButtonUpdate() {
        return buttonUpdate;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Vladimir
        panel1 = new JPanel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        buttonAdd = new JButton();
        buttonRemove = new JButton();
        buttonUpdate = new JButton();

        //======== this ========
        Container contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing
            . border. EmptyBorder( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border. TitledBorder
            . CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .
            awt .Font .BOLD ,12 ), java. awt. Color. red) ,panel1. getBorder( )) )
            ; panel1. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
            ) {if ("bord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} )
            ;
            panel1.setLayout(new BorderLayout());
        }

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                    {"-10"},
                    {"-9 "},
                    {"-8"},
                    {"-7"},
                    {"-6"},
                    {"-5"},
                    {"-4"},
                    {"-3"},
                    {"-2"},
                    {"-1"},
                    {"0"},
                    {"1"},
                    {"2"},
                    {"3"},
                    {"4"},
                    {"5"},
                    {"6"},
                    {"7"},
                    {"8"},
                    {"9"},
                    {"10"},
                },
                new String[] {
                    "X values"
                }
            ));
            scrollPane1.setViewportView(table1);
        }

        //---- buttonAdd ----
        buttonAdd.setText("+");

        //---- buttonRemove ----
        buttonRemove.setText("-");

        //---- buttonUpdate ----
        buttonUpdate.setText("Update");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(buttonAdd, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(buttonRemove, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
                                .addComponent(buttonUpdate, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, 784, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(buttonAdd)
                                .addComponent(buttonRemove))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(buttonUpdate)))
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Vladimir
    private JPanel panel1;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton buttonAdd;
    private JButton buttonRemove;
    private JButton buttonUpdate;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
