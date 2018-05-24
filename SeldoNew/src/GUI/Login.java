/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DBConnection.SeldoDB;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Nano ArtZ
 */
public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
        Close_Btn_LP.setOpaque(false);
        Close_Btn_LP.setContentAreaFilled(false);
        Close_Btn_LP.setBorderPainted(false);
    }

    //Methods Start Login Page//
    private void LoginBtnMethod() {
        try {
            Statement s = (Statement) SeldoDB.GetMyConnection().createStatement();
            ResultSet RS = s.executeQuery("Select * From useraccount WHERE UserName = '" + UserNameTF.getText() + "' ");

            if (RS.next()) {
                String Passwrd = RS.getString("Password");
                String PassEntered = PasswordFld.getText();

                if (Passwrd.equals(PassEntered)) {
//                    String UserNameString = UserNameTF.getText();
                    this.setVisible(false);
                    new DashBoardJF().setVisible(true); // Passing Values to Home frame

                } else {
                    //Incorrect Password
                    JOptionPane.showMessageDialog(null, "Entered password is incorrect! Please try again !!!");
                }
            } else {
                //Incorrect User Name
                JOptionPane.showMessageDialog(null, "Please Check Your User Name & Try Again");
            }
        } catch (Exception e) {
            System.out.println(e);
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    //Methods End Login Page//
    public void MakeTrialMethod() {
        try {
            SimpleDateFormat SDFMonth = new SimpleDateFormat("MM");
            SimpleDateFormat SDFDay = new SimpleDateFormat("dd");
            Date dateObject = new Date();
            String monthNow = SDFMonth.format(dateObject);
            String dayNow = SDFDay.format(dateObject);

            int monthNowInt = Integer.parseInt(monthNow);
            int dayNowInt = Integer.parseInt(dayNow);
            
            int expireDayInt = 1;
            int expireMonthInt = 7;

            if (expireDayInt < dayNowInt && expireMonthInt <=monthNowInt) {
                TrialVersionMsgJF trialJF = new TrialVersionMsgJF();
                trialJF.setVisible(true);
            } else {
                LoginBtnMethod();
            }

        } catch (Exception e) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LoggingPanel = new javax.swing.JPanel();
        PanelTwo = new javax.swing.JPanel();
        LogoLbl = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        UserNameTF = new javax.swing.JTextField();
        PasswordFld = new javax.swing.JPasswordField();
        LoggingBtn = new javax.swing.JButton();
        Close_Btn_LP = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 500));
        setUndecorated(true);

        LoggingPanel.setBackground(new java.awt.Color(36, 47, 65));
        LoggingPanel.setMaximumSize(new java.awt.Dimension(700, 500));
        LoggingPanel.setMinimumSize(new java.awt.Dimension(700, 500));
        LoggingPanel.setPreferredSize(new java.awt.Dimension(700, 500));
        LoggingPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelTwo.setBackground(new java.awt.Color(255, 255, 255));
        PanelTwo.setMaximumSize(new java.awt.Dimension(350, 500));
        PanelTwo.setMinimumSize(new java.awt.Dimension(350, 500));
        PanelTwo.setPreferredSize(new java.awt.Dimension(350, 500));
        PanelTwo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LogoLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LogoLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Logo/Seldo_loginPnlImg.png"))); // NOI18N
        PanelTwo.add(LogoLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 330, 70));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/GIF/Square.gif"))); // NOI18N
        PanelTwo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 220, 180));

        LoggingPanel.add(PanelTwo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Login");
        LoggingPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, -1, -1));

        jLabel3.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("User Name");
        LoggingPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 160, -1, -1));

        jLabel4.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Password");
        LoggingPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 260, -1, -1));
        LoggingPanel.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 220, 240, -1));
        LoggingPanel.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 320, 240, -1));

        UserNameTF.setBackground(new java.awt.Color(36, 47, 65));
        UserNameTF.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        UserNameTF.setForeground(new java.awt.Color(255, 255, 255));
        UserNameTF.setText("Enter User Name");
        UserNameTF.setBorder(null);
        UserNameTF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UserNameTFMouseClicked(evt);
            }
        });
        LoggingPanel.add(UserNameTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, 240, 30));

        PasswordFld.setBackground(new java.awt.Color(36, 47, 65));
        PasswordFld.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        PasswordFld.setForeground(new java.awt.Color(255, 255, 255));
        PasswordFld.setText("Enter Your Password");
        PasswordFld.setBorder(null);
        PasswordFld.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PasswordFldMouseClicked(evt);
            }
        });
        LoggingPanel.add(PasswordFld, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 290, 240, 30));

        LoggingBtn.setBackground(new java.awt.Color(36, 47, 65));
        LoggingBtn.setForeground(new java.awt.Color(255, 255, 255));
        LoggingBtn.setText("Sign In");
        LoggingBtn.setBorder(null);
        LoggingBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoggingBtnActionPerformed(evt);
            }
        });
        LoggingPanel.add(LoggingBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 380, 130, 30));

        Close_Btn_LP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/ExitButton1.png"))); // NOI18N
        Close_Btn_LP.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/ExitButton2.png")));
        Close_Btn_LP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Close_Btn_LPActionPerformed(evt);
            }
        });
        LoggingPanel.add(Close_Btn_LP, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 0, 60, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(LoggingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(LoggingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void UserNameTFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UserNameTFMouseClicked
        UserNameTF.setText("");
    }//GEN-LAST:event_UserNameTFMouseClicked

    private void PasswordFldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PasswordFldMouseClicked
        PasswordFld.setText("");
    }//GEN-LAST:event_PasswordFldMouseClicked

    private void LoggingBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoggingBtnActionPerformed

        MakeTrialMethod();


    }//GEN-LAST:event_LoggingBtnActionPerformed

    private void Close_Btn_LPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Close_Btn_LPActionPerformed
        try {
            System.exit(0);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_Close_Btn_LPActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Close_Btn_LP;
    private javax.swing.JButton LoggingBtn;
    private javax.swing.JPanel LoggingPanel;
    private javax.swing.JLabel LogoLbl;
    private javax.swing.JPanel PanelTwo;
    private javax.swing.JPasswordField PasswordFld;
    private javax.swing.JTextField UserNameTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
