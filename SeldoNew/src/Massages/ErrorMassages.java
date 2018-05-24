/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Massages;

/**
 *
 * @author Nano ArtZ
 */
public final class ErrorMassages extends javax.swing.JFrame {

    /**
     * Creates new form ErrorMassages
     */
    public ErrorMassages() {
        initComponents();
        Close_Btn_WarMsg.setOpaque(false);
        Close_Btn_WarMsg.setContentAreaFilled(false);
        Close_Btn_WarMsg.setBorderPainted(false);
        
        OK_Btn.setOpaque(false);
        OK_Btn.setContentAreaFilled(false);
        OK_Btn.setBorderPainted(false);
        Decorations();
    }

   //Look and feel methods//
    public void Decorations(){
        try {
            OK_Btn.setToolTipText("<html>"
                    + "<style>"
                    + "h1{"
                    + "color : white; background: #49bfd0; border: 2px solid #49bfd0;}"
                    + "</style>"
                    + "<h1>asdfghjkl</h1>"
                    + "</html>");
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Close_Btn_WarMsg = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        OK_Btn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(450, 200));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Close_Btn_WarMsg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Massages/CloseBtn.png"))); // NOI18N
        Close_Btn_WarMsg.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Massages/CloseBtn2.png")));
        Close_Btn_WarMsg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Close_Btn_WarMsgActionPerformed(evt);
            }
        });
        jPanel1.add(Close_Btn_WarMsg, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 30, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semilight", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 51));
        jLabel1.setText("Warning");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 90, 50));

        jLabel2.setFont(new java.awt.Font("Segoe UI Semilight", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("\" This Customer has pending payments \"");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 450, 40));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        OK_Btn.setBackground(new java.awt.Color(102, 102, 102));
        OK_Btn.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        OK_Btn.setForeground(new java.awt.Color(255, 255, 255));
        OK_Btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Massages/OK_Button1.png"))); // NOI18N
        OK_Btn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Massages/OK_Button2.png")));
        OK_Btn.setPreferredSize(new java.awt.Dimension(150, 40));
        OK_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OK_BtnActionPerformed(evt);
            }
        });
        jPanel2.add(OK_Btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 20, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 450, 70));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/GIF/Loading.gif"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 70));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Close_Btn_WarMsgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Close_Btn_WarMsgActionPerformed
        try {
            this.dispose();
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_Close_Btn_WarMsgActionPerformed

    private void OK_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OK_BtnActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_OK_BtnActionPerformed

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
            java.util.logging.Logger.getLogger(ErrorMassages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ErrorMassages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ErrorMassages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ErrorMassages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ErrorMassages().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Close_Btn_WarMsg;
    private javax.swing.JButton OK_Btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
