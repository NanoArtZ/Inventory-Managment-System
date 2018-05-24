/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nano ArtZ
 */
public class DashBoardJF extends javax.swing.JFrame {

    /**
     * Creates new form DashBoardJF
     */
    public DashBoardJF() {
        initComponents();
        ButtonBehaviorMethod();

    }

//----- Dash Board Methos Start ----- //
//----- Button Behavior Method Start -----//
    public void ButtonBehaviorMethod(){
        try {
            DBSalesOrderBtn.setOpaque(false);
            DBSalesOrderBtn.setContentAreaFilled(false);
            DBSalesOrderBtn.setBorderPainted(false);
        } catch (Exception e) {
            Logger.getLogger(DashBoardJF.class.getName()).log(Level.SEVERE, null,e);
        }
    }
//----- Button Behavior Method END -----//
//----- Dash Board Methos END ----- //
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        DBSalesOrderBtn = new javax.swing.JButton();
        DBPaymentsBtn = new javax.swing.JButton();
        DBPaymentsBtn1 = new javax.swing.JButton();
        DBPaymentsBtn2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setPreferredSize(new java.awt.Dimension(1366, 768));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Exit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 10, -1, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Dash Board");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 200, -1));

        DBSalesOrderBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/Dashboard Buttons/DBSalesBtn1.png"))); // NOI18N
        DBSalesOrderBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/DBSalesBtn3.png")));
        DBSalesOrderBtn.setPreferredSize(new java.awt.Dimension(150, 130));
        DBSalesOrderBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DBSalesOrderBtnActionPerformed(evt);
            }
        });
        jPanel1.add(DBSalesOrderBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, -1, -1));

        DBPaymentsBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/Dashboard Buttons/DBPaymentBtn1.png"))); // NOI18N
        DBPaymentsBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/Dashboard Buttons/DBPaymentBtn2.png"))); // NOI18N
        DBPaymentsBtn.setPreferredSize(new java.awt.Dimension(150, 130));
        DBPaymentsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DBPaymentsBtnActionPerformed(evt);
            }
        });
        jPanel1.add(DBPaymentsBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, -1, -1));

        DBPaymentsBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/Dashboard Buttons/ExpensivesItemsBtn1.png"))); // NOI18N
        DBPaymentsBtn1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/Dashboard Buttons/ExpensivesItemsBtn2.png"))); // NOI18N
        DBPaymentsBtn1.setPreferredSize(new java.awt.Dimension(150, 130));
        DBPaymentsBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DBPaymentsBtn1ActionPerformed(evt);
            }
        });
        jPanel1.add(DBPaymentsBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 110, -1, -1));

        DBPaymentsBtn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/Dashboard Buttons/DBFinishedItemsBtn1.png"))); // NOI18N
        DBPaymentsBtn2.setPreferredSize(new java.awt.Dimension(150, 130));
        DBPaymentsBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DBPaymentsBtn2ActionPerformed(evt);
            }
        });
        jPanel1.add(DBPaymentsBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 110, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Background/MainPanelBGIMG.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void DBSalesOrderBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DBSalesOrderBtnActionPerformed
        try {
            this.setVisible(false);
            SalesJF NewsalesJF = new SalesJF();
            NewsalesJF.setVisible(true);
        } catch (Exception e) {
            Logger.getLogger(DashBoardJF.class.getName()).log(Level.SEVERE, null,e);
        }
    }//GEN-LAST:event_DBSalesOrderBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            System.exit(0);
        } catch (Exception e) {
            Logger.getLogger(DashBoardJF.class.getName()).log(Level.SEVERE, null, e);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void DBPaymentsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DBPaymentsBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DBPaymentsBtnActionPerformed

    private void DBPaymentsBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DBPaymentsBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DBPaymentsBtn1ActionPerformed

    private void DBPaymentsBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DBPaymentsBtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DBPaymentsBtn2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DashBoardJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashBoardJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashBoardJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashBoardJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashBoardJF().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DBPaymentsBtn;
    private javax.swing.JButton DBPaymentsBtn1;
    private javax.swing.JButton DBPaymentsBtn2;
    private javax.swing.JButton DBSalesOrderBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
