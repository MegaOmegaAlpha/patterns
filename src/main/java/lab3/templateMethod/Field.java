/*
 * Created by JFormDesigner on Thu Mar 12 23:44:17 GMT+04:00 2020
 */

package lab3.templateMethod;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Vladimir
 */
public class Field extends JFrame {

    private AnimatedLayer screen;
    private String[] arguments = {
          "RECTANGLE", "CIRCLE"
    };

    public Field() {
        initComponents();
        screen = new AnimatedLayer();
        panel1.add(screen);
    }

    private void button1ActionPerformed(ActionEvent e) {
        String selectedName = (String) comboBox1.getSelectedItem();
        if (selectedName != null && !selectedName.isEmpty()) {
            screen.run(selectedName);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Vladimir
        button1 = new JButton();
        panel1 = new JPanel();
        comboBox1 = new JComboBox(arguments);

        //======== this ========
        Container contentPane = getContentPane();

        //---- button1 ----
        button1.setText("text");
        button1.addActionListener(e -> button1ActionPerformed(e));

        //======== panel1 ========
        {
            panel1.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing.
            border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frmDes\u0069gner \u0045valua\u0074ion" , javax. swing .border . TitledBorder. CENTER
            ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .Font ( "D\u0069alog", java .awt . Font
            . BOLD ,12 ) ,java . awt. Color .red ) ,panel1. getBorder () ) ); panel1. addPropertyChangeListener(
            new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062order"
            .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } );
            panel1.setLayout(new GridLayout());
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(button1, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboBox1))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(panel1, GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel1, GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(button1, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 348, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Vladimir
    private JButton button1;
    private JPanel panel1;
    private JComboBox comboBox1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
