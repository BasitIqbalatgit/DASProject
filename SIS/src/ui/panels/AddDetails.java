/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.panels;

import common.Student;
import controller.SISController;
import dsa.linklist.LinkedList;

/**
 *
 * @author fatim
 */
public class AddDetails extends javax.swing.JPanel {

    /**
     * Creates new form AddDetails
     */
    public AddDetails() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        menuPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jTextField6 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(0, 204, 153));
        jPanel1.setLayout(new java.awt.BorderLayout());

        menuPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 36)); // NOI18N
        jLabel3.setText("Add Details");

        nameLabel.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 18)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(0, 204, 153));
        nameLabel.setText("Name:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 204, 153));
        jLabel4.setText("Father Name:");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 204, 153));
        jLabel5.setText("CNIC:");

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 204, 153));
        jLabel6.setText("FSC Marks:");

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 204, 153));
        jLabel7.setText("SSC Marks:");

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 204, 153));
        jButton1.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 14)); // NOI18N
        jButton1.setText("ADD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 204, 153));
        jLabel8.setText("Reg NO:");

        jLabel9.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 204, 153));
        jLabel9.setText("Program:");

        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuPanelLayout.createSequentialGroup()
                        .addComponent(jTextField7)
                        .addGap(195, 195, 195))
                    .addGroup(menuPanelLayout.createSequentialGroup()
                        .addComponent(jTextField4)
                        .addGap(195, 195, 195))
                    .addGroup(menuPanelLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                        .addGap(270, 270, 270))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuPanelLayout.createSequentialGroup()
                        .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(195, 195, 195))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuPanelLayout.createSequentialGroup()
                        .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField5))
                        .addGap(195, 195, 195))))
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(44, 44, 44)
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuPanelLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addGroup(menuPanelLayout.createSequentialGroup()
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuPanelLayout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                        .addGap(36, 36, 36))
                    .addGroup(menuPanelLayout.createSequentialGroup()
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addGap(27, 27, 27))
        );

        jPanel1.add(menuPanel, java.awt.BorderLayout.CENTER);

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Student std = new Student();
        std.setName(jTextField2.getText());
        std.setFatherName(jTextField1.getText());
        std.setCnic(jTextField3.getText());
        std.setFscMarks(Double.parseDouble(jTextField4.getText()));
        
        std.setFscMarks(Double.parseDouble(jTextField5.getText()));
        std.setRegNo(jTextField6.getText());
        std.setProg(jTextField7.getText());
        
        
        
        LinkedList<Student> list = new LinkedList<>();
//        list.add(std);
        
        SISController.writeStudentToExcel(std);
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JLabel nameLabel;
    // End of variables declaration//GEN-END:variables
}
