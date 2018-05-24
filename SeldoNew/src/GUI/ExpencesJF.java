/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DBConnection.SeldoDB;
import com.mysql.jdbc.Statement;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nano ArtZ Tech
 */
public class ExpencesJF extends javax.swing.JFrame {

    /**
     * Creates new form ExpencesJF
     */
    public ExpencesJF() {
        initComponents();

        showDate();
        showTime();
        FullScreenMethod();
        ButtonBehaviourMethod();
        AutoGenPID();
        CalTotalExpence();
        AddDataToTable();
    }

    //Full Screen Method Start
    public void FullScreenMethod() {

        try {
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

            setBounds(0, 0, screenSize.width, screenSize.height);
            setVisible(true);
            Toolkit tk = Toolkit.getDefaultToolkit();

            int xsize = (int) tk.getScreenSize().getWidth();
            int ysize = (int) tk.getScreenSize().getHeight();

            this.setSize(xsize, ysize);
            this.setExtendedState(this.MAXIMIZED_BOTH);

        } catch (HeadlessException e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    //Full Screen Method END

    //    Date&Time  //
    void showDate() {
        Datelbl.setText(new SimpleDateFormat("MM-dd-yyyy").format(new Date()));
    }

    void showTime() {
        new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Timelbl.setText(new SimpleDateFormat("hh:mm:ss").format(new Date()));
            }
        }).start();
    }
//    Date&Time Method END // 

    //Button Behaviour Method Start
    public void ButtonBehaviourMethod() {

        try {
            PPMinimizeBtn.setOpaque(false);
            PPMinimizeBtn.setContentAreaFilled(false);
            PPMinimizeBtn.setBorderPainted(false);

            PPExitBtn.setOpaque(false);
            PPExitBtn.setContentAreaFilled(false);
            PPExitBtn.setBorderPainted(false);

        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    //Button Behaviour Mehod END
    public void SaveExDetails() {
        try {
            Statement s = (Statement) SeldoDB.GetMyConnection().createStatement();
            String PayID = ExPaymentID.getText();

            Date PayDate = ExPaymentDate.getDate();
            SimpleDateFormat MyDateFormat = new SimpleDateFormat("MMM-dd-Y");
            String MyDateString = MyDateFormat.format(PayDate);

            String PayMethod;
            if (PayChequeRadioBtn.isSelected()) {
                PayMethod = "Cheque";
            } else {
                PayMethod = "Cash";
            }
            String ChequeNo = PayChequeNoTF.getText();
            String PaidTo = ExPaidTo.getText();
            String Description = ExDescription.getText();
            String Remark = EXRemarkTF.getText();
            Double AmountPaid = Double.valueOf(ExAmountPaidTF.getText());

            s.executeUpdate("INSERT into expense (PaymentID, DateTime, PaymentMethod, ChequeNo, PaidTo, Description, Remark, AmountPaid) Values "
                    + "('" + PayID + "' , '" + MyDateString + "' , '" + PayMethod + "' , '" + ChequeNo + "' , '" + PaidTo + "' , '" + Description + "' , ' " + Remark + " ' , '" + AmountPaid + "') ");

        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    //Auto Genarate Next sales orde number - Method Start
    public void AutoGenPID() {
        try {
            Statement st = (Statement) SeldoDB.GetMyConnection().createStatement();
            ResultSet RS = st.executeQuery("SELECT MAX(PaymentID) FROM expense");
            if (RS.next()) {
                String MaxPIDString = RS.getString("MAX(PaymentID)");
                if (MaxPIDString == null) {
                    ExPaymentID.setText("PO00000001");
                } else {
                    MaxPIDString = MaxPIDString.substring(2, 10);
                    int MaxSoNumberInt = Integer.parseInt(MaxPIDString);
                    MaxSoNumberInt++;
                    MaxPIDString = Integer.toString(MaxSoNumberInt);
                    while (MaxPIDString.length() < 8) {
                        MaxPIDString = "0" + MaxPIDString;
                    }
                    MaxPIDString = "PO" + MaxPIDString;
                    ExPaymentID.setText(MaxPIDString);
                }
            } else {
                ExPaymentID.setText("PO00000001");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    //Auto Genarate Next sales orde number - Method END
    //Clear All Feild
    public void ClearFeilds() {
        try {
            ExDescription.setText(null);
            ExAmountPaidTF.setText(null);
            ExPaymentDate.setDate(null);
            EXRemarkTF.setText(null);
            ExDescription.setText(null);
            ExPaymentID.setText(null);
            ExPaidTo.setText(null);
            PayChequeNoTF.setText(null);

        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }
//Clear All Feild Method END

    //Add Data to Table From Data Base - Method Start
    public void AddDataToTable() {
        try {
            Statement s = (Statement) SeldoDB.GetMyConnection().createStatement();
            ResultSet rs = s.executeQuery("SELECT * From expense");

            while (rs.next()) {

                DefaultTableModel dtm = (DefaultTableModel) ExDetailsTable.getModel();
                Vector v1 = new Vector();

                v1.add(rs.getString("PaymentId"));
                v1.add(rs.getString("DateTime"));
                v1.add(rs.getString("PaymentMethod"));
                v1.add(rs.getString("Chequeno"));
                v1.add(rs.getString("PaidTo"));
                v1.add(rs.getString("Description"));
                v1.add(rs.getString("Remark"));
                v1.add(rs.getString("AmountPaid"));

                dtm.addRow(v1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    //Add Data to Table From Data Base - Method END

    //Calculate Total Expences - Method Start
    public void CalTotalExpence(){
        try {
            Statement s = (Statement) SeldoDB.GetMyConnection().createStatement();
            ResultSet rs = s.executeQuery("SELECT SUM(AmountPaid) From expense");
            rs.next();
            String TotalExpence = rs.getString("SUM(AmountPaid)");
            ExTotalExpenceTF.setText(TotalExpence);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    //Calculate Total Expences - Method End
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ExpMainPanel = new javax.swing.JPanel();
        TopPanel = new javax.swing.JPanel();
        Timelbl = new javax.swing.JLabel();
        Datelbl = new javax.swing.JLabel();
        Datelbl1 = new javax.swing.JLabel();
        Timelbl1 = new javax.swing.JLabel();
        UserNameDisplayLabel = new javax.swing.JLabel();
        PPUserNameLbl = new javax.swing.JLabel();
        PPBraIDLabel = new javax.swing.JLabel();
        PPBraNameLabel = new javax.swing.JLabel();
        MainPanelBranchIDLable = new javax.swing.JLabel();
        MainPanelBranchNameLable = new javax.swing.JLabel();
        SeldoLogo = new javax.swing.JLabel();
        PPExitBtn = new javax.swing.JButton();
        PPMinimizeBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        INSCusNameOrNIC_TF_Label = new javax.swing.JLabel();
        ExAmountPaidTF = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        ExDescription = new javax.swing.JTextArea();
        INSCusNameOrNIC_TF_Label1 = new javax.swing.JLabel();
        INSCusNameOrNIC_TF_Label2 = new javax.swing.JLabel();
        ExPaidTo = new javax.swing.JTextField();
        ExPaymentDate = new com.toedter.calendar.JDateChooser();
        INSCusNameOrNIC_TF_Label3 = new javax.swing.JLabel();
        INSCusNameOrNIC_TF_Label4 = new javax.swing.JLabel();
        ExPaymentID = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        ExDetailsTable = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        EXRemarkTF = new javax.swing.JTextArea();
        INSCusNameOrNIC_TF_Label5 = new javax.swing.JLabel();
        INSCusNameOrNIC_TF_Label7 = new javax.swing.JLabel();
        ExTotalExpenceTF = new javax.swing.JLabel();
        INSCusNameOrNIC_TF_Label9 = new javax.swing.JLabel();
        PayChequeRadioBtn = new javax.swing.JRadioButton();
        jLabel18 = new javax.swing.JLabel();
        PayChequeNoTF = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1366, 768));

        ExpMainPanel.setBackground(new java.awt.Color(51, 51, 51));
        ExpMainPanel.setPreferredSize(new java.awt.Dimension(1366, 768));

        TopPanel.setBackground(new java.awt.Color(102, 102, 102));
        TopPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TopPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Timelbl.setBackground(new java.awt.Color(255, 255, 255));
        Timelbl.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        Timelbl.setForeground(new java.awt.Color(255, 255, 255));
        Timelbl.setText("Time");
        TopPanel.add(Timelbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 30, -1, -1));

        Datelbl.setBackground(new java.awt.Color(255, 255, 255));
        Datelbl.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        Datelbl.setForeground(new java.awt.Color(255, 255, 255));
        Datelbl.setText("Date");
        TopPanel.add(Datelbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 10, -1, -1));

        Datelbl1.setBackground(new java.awt.Color(255, 255, 255));
        Datelbl1.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        Datelbl1.setForeground(new java.awt.Color(255, 255, 255));
        Datelbl1.setText("Date");
        TopPanel.add(Datelbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 10, -1, -1));

        Timelbl1.setBackground(new java.awt.Color(255, 255, 255));
        Timelbl1.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        Timelbl1.setForeground(new java.awt.Color(255, 255, 255));
        Timelbl1.setText("Time");
        TopPanel.add(Timelbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 30, -1, -1));

        UserNameDisplayLabel.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        UserNameDisplayLabel.setForeground(new java.awt.Color(255, 255, 255));
        UserNameDisplayLabel.setText("User Name Display");
        TopPanel.add(UserNameDisplayLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, 220, 20));

        PPUserNameLbl.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        PPUserNameLbl.setForeground(new java.awt.Color(255, 255, 255));
        PPUserNameLbl.setText("User Name :");
        TopPanel.add(PPUserNameLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 80, 20));

        PPBraIDLabel.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        PPBraIDLabel.setForeground(new java.awt.Color(255, 255, 255));
        PPBraIDLabel.setText("Branch Name :");
        TopPanel.add(PPBraIDLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 10, 100, 20));

        PPBraNameLabel.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        PPBraNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        PPBraNameLabel.setText("Branch ID       :");
        TopPanel.add(PPBraNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 30, 100, -1));

        MainPanelBranchIDLable.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        MainPanelBranchIDLable.setForeground(new java.awt.Color(255, 255, 255));
        MainPanelBranchIDLable.setText("BR00000001");
        TopPanel.add(MainPanelBranchIDLable, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 30, 150, -1));

        MainPanelBranchNameLable.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        MainPanelBranchNameLable.setForeground(new java.awt.Color(255, 255, 255));
        MainPanelBranchNameLable.setText("Mahiyangana");
        TopPanel.add(MainPanelBranchNameLable, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 10, 150, 20));

        SeldoLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SeldoLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Logo/SeldoLogo.png"))); // NOI18N
        SeldoLogo.setToolTipText("");
        TopPanel.add(SeldoLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 220, 40));

        PPExitBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/ExitButton1.png"))); // NOI18N
        PPExitBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/ExitButton2.png"))); // NOI18N
        PPExitBtn.setPreferredSize(new java.awt.Dimension(50, 40));
        PPExitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PPExitBtnActionPerformed(evt);
            }
        });
        TopPanel.add(PPExitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 10, -1, -1));

        PPMinimizeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/MinimizeButtonPNG0.png"))); // NOI18N
        PPMinimizeBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/MinimizeButtonPNG1.png"))); // NOI18N
        PPMinimizeBtn.setPreferredSize(new java.awt.Dimension(50, 40));
        PPMinimizeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PPMinimizeBtnActionPerformed(evt);
            }
        });
        TopPanel.add(PPMinimizeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 10, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semilight", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Expenses Details");

        INSCusNameOrNIC_TF_Label.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        INSCusNameOrNIC_TF_Label.setForeground(new java.awt.Color(255, 255, 255));
        INSCusNameOrNIC_TF_Label.setText("Payment Description");

        ExAmountPaidTF.setBackground(new java.awt.Color(51, 51, 51));
        ExAmountPaidTF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ExAmountPaidTF.setForeground(new java.awt.Color(255, 255, 255));
        ExAmountPaidTF.setMinimumSize(new java.awt.Dimension(280, 28));
        ExAmountPaidTF.setPreferredSize(new java.awt.Dimension(280, 28));
        ExAmountPaidTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExAmountPaidTFActionPerformed(evt);
            }
        });

        ExDescription.setBackground(new java.awt.Color(51, 51, 51));
        ExDescription.setColumns(20);
        ExDescription.setForeground(new java.awt.Color(255, 255, 255));
        ExDescription.setRows(5);
        jScrollPane5.setViewportView(ExDescription);

        INSCusNameOrNIC_TF_Label1.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        INSCusNameOrNIC_TF_Label1.setForeground(new java.awt.Color(255, 255, 255));
        INSCusNameOrNIC_TF_Label1.setText("Amount Paid");

        INSCusNameOrNIC_TF_Label2.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        INSCusNameOrNIC_TF_Label2.setForeground(new java.awt.Color(255, 255, 255));
        INSCusNameOrNIC_TF_Label2.setText("Date of Payment");

        ExPaidTo.setBackground(new java.awt.Color(51, 51, 51));
        ExPaidTo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ExPaidTo.setForeground(new java.awt.Color(255, 255, 255));
        ExPaidTo.setMinimumSize(new java.awt.Dimension(280, 28));
        ExPaidTo.setPreferredSize(new java.awt.Dimension(280, 28));

        ExPaymentDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        INSCusNameOrNIC_TF_Label3.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        INSCusNameOrNIC_TF_Label3.setForeground(new java.awt.Color(255, 255, 255));
        INSCusNameOrNIC_TF_Label3.setText("Paid To");

        INSCusNameOrNIC_TF_Label4.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        INSCusNameOrNIC_TF_Label4.setForeground(new java.awt.Color(255, 255, 255));
        INSCusNameOrNIC_TF_Label4.setText("Payment ID");

        ExPaymentID.setEditable(false);
        ExPaymentID.setBackground(new java.awt.Color(51, 51, 51));
        ExPaymentID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ExPaymentID.setForeground(new java.awt.Color(255, 255, 255));
        ExPaymentID.setMinimumSize(new java.awt.Dimension(280, 28));
        ExPaymentID.setPreferredSize(new java.awt.Dimension(280, 28));

        jButton3.setBackground(new java.awt.Color(51, 51, 51));
        jButton3.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 16)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Save Details");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        ExDetailsTable.setBackground(new java.awt.Color(51, 51, 51));
        ExDetailsTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ExDetailsTable.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        ExDetailsTable.setForeground(new java.awt.Color(255, 255, 255));
        ExDetailsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Payment ID", "Date", "Payment Method", "Cheque No.", "Paid To", "Description", "Remark", "Amount Paid"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ExDetailsTable.setFillsViewportHeight(true);
        ExDetailsTable.setPreferredSize(new java.awt.Dimension(525, 1000));
        jScrollPane10.setViewportView(ExDetailsTable);

        EXRemarkTF.setBackground(new java.awt.Color(51, 51, 51));
        EXRemarkTF.setColumns(20);
        EXRemarkTF.setForeground(new java.awt.Color(255, 255, 255));
        EXRemarkTF.setRows(5);
        jScrollPane6.setViewportView(EXRemarkTF);

        INSCusNameOrNIC_TF_Label5.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        INSCusNameOrNIC_TF_Label5.setForeground(new java.awt.Color(255, 255, 255));
        INSCusNameOrNIC_TF_Label5.setText("Remarks");

        INSCusNameOrNIC_TF_Label7.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        INSCusNameOrNIC_TF_Label7.setForeground(new java.awt.Color(255, 255, 255));
        INSCusNameOrNIC_TF_Label7.setText("Rs.");

        ExTotalExpenceTF.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        ExTotalExpenceTF.setForeground(new java.awt.Color(255, 255, 255));
        ExTotalExpenceTF.setText("Display Sub Total");

        INSCusNameOrNIC_TF_Label9.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        INSCusNameOrNIC_TF_Label9.setForeground(new java.awt.Color(255, 255, 255));
        INSCusNameOrNIC_TF_Label9.setText("Total Expensive");

        PayChequeRadioBtn.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        PayChequeRadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        PayChequeRadioBtn.setText("If Cheque");
        PayChequeRadioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PayChequeRadioBtnActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Cheque Number");

        PayChequeNoTF.setBackground(new java.awt.Color(51, 51, 51));
        PayChequeNoTF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        PayChequeNoTF.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout ExpMainPanelLayout = new javax.swing.GroupLayout(ExpMainPanel);
        ExpMainPanel.setLayout(ExpMainPanelLayout);
        ExpMainPanelLayout.setHorizontalGroup(
            ExpMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ExpMainPanelLayout.createSequentialGroup()
                .addGroup(ExpMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TopPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1370, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ExpMainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ExpMainPanelLayout.createSequentialGroup()
                .addGroup(ExpMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ExpMainPanelLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(ExpMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ExpMainPanelLayout.createSequentialGroup()
                                .addGroup(ExpMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(INSCusNameOrNIC_TF_Label)
                                    .addComponent(INSCusNameOrNIC_TF_Label1)
                                    .addComponent(INSCusNameOrNIC_TF_Label2))
                                .addGap(18, 18, 18)
                                .addGroup(ExpMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ExpMainPanelLayout.createSequentialGroup()
                                        .addGroup(ExpMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jScrollPane5)
                                            .addComponent(ExPaymentDate, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(ExpMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(INSCusNameOrNIC_TF_Label5)
                                            .addComponent(INSCusNameOrNIC_TF_Label3)))
                                    .addGroup(ExpMainPanelLayout.createSequentialGroup()
                                        .addComponent(ExAmountPaidTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(INSCusNameOrNIC_TF_Label4)))
                                .addGap(18, 18, 18)
                                .addGroup(ExpMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ExpMainPanelLayout.createSequentialGroup()
                                        .addGroup(ExpMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(ExPaidTo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(ExPaymentID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(20, 20, 20))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ExpMainPanelLayout.createSequentialGroup()
                                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)))
                                .addComponent(PayChequeRadioBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel18)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(ExpMainPanelLayout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(INSCusNameOrNIC_TF_Label7)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ExpMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ExpMainPanelLayout.createSequentialGroup()
                                .addComponent(PayChequeNoTF, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(ExTotalExpenceTF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ExpMainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane10)))
                .addGap(20, 20, 20))
            .addGroup(ExpMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ExpMainPanelLayout.createSequentialGroup()
                    .addContainerGap(932, Short.MAX_VALUE)
                    .addComponent(INSCusNameOrNIC_TF_Label9)
                    .addGap(317, 317, 317)))
        );
        ExpMainPanelLayout.setVerticalGroup(
            ExpMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ExpMainPanelLayout.createSequentialGroup()
                .addComponent(TopPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(ExpMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ExpMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ExTotalExpenceTF, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(INSCusNameOrNIC_TF_Label7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(ExpMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ExpMainPanelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(INSCusNameOrNIC_TF_Label)
                        .addGap(99, 99, 99)
                        .addComponent(INSCusNameOrNIC_TF_Label1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(ExpMainPanelLayout.createSequentialGroup()
                        .addGroup(ExpMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ExpMainPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(ExpMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(PayChequeRadioBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(ExpMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(PayChequeNoTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(INSCusNameOrNIC_TF_Label5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(79, 79, 79))
                            .addGroup(ExpMainPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(ExpMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(ExpMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ExAmountPaidTF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(INSCusNameOrNIC_TF_Label4)
                            .addComponent(ExPaymentID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ExpMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ExPaymentDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(ExpMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(INSCusNameOrNIC_TF_Label3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ExPaidTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(INSCusNameOrNIC_TF_Label2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(ExpMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ExpMainPanelLayout.createSequentialGroup()
                    .addGap(81, 81, 81)
                    .addComponent(INSCusNameOrNIC_TF_Label9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(674, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ExpMainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1370, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ExpMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 786, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void PPExitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PPExitBtnActionPerformed
        try {
            DashBoardJF NewDashBoard = new DashBoardJF();
            NewDashBoard.setVisible(true);
            this.dispose();
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_PPExitBtnActionPerformed

    private void PPMinimizeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PPMinimizeBtnActionPerformed
        this.setState(ICONIFIED);        // TODO add your handling code here:
    }//GEN-LAST:event_PPMinimizeBtnActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        SaveExDetails();
        CalTotalExpence();
        DefaultTableModel dtm = (DefaultTableModel) ExDetailsTable.getModel();
        dtm.setRowCount(0);
        AddDataToTable();
        ClearFeilds();
        AutoGenPID();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void PayChequeRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PayChequeRadioBtnActionPerformed
        try {

            if (PayChequeRadioBtn.isSelected()) {
                PayChequeNoTF.setEditable(true);

            } else {
                PayChequeNoTF.setEditable(false);
                PayChequeNoTF.setText(null);

            }

        } catch (Exception e) {
            Logger.getLogger(PaymentJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_PayChequeRadioBtnActionPerformed

    private void ExAmountPaidTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExAmountPaidTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ExAmountPaidTFActionPerformed

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
            java.util.logging.Logger.getLogger(ExpencesJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExpencesJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExpencesJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExpencesJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExpencesJF().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Datelbl;
    private javax.swing.JLabel Datelbl1;
    private javax.swing.JTextArea EXRemarkTF;
    private javax.swing.JTextField ExAmountPaidTF;
    private javax.swing.JTextArea ExDescription;
    private javax.swing.JTable ExDetailsTable;
    private javax.swing.JTextField ExPaidTo;
    private com.toedter.calendar.JDateChooser ExPaymentDate;
    private javax.swing.JTextField ExPaymentID;
    private javax.swing.JLabel ExTotalExpenceTF;
    private javax.swing.JPanel ExpMainPanel;
    private javax.swing.JLabel INSCusNameOrNIC_TF_Label;
    private javax.swing.JLabel INSCusNameOrNIC_TF_Label1;
    private javax.swing.JLabel INSCusNameOrNIC_TF_Label2;
    private javax.swing.JLabel INSCusNameOrNIC_TF_Label3;
    private javax.swing.JLabel INSCusNameOrNIC_TF_Label4;
    private javax.swing.JLabel INSCusNameOrNIC_TF_Label5;
    private javax.swing.JLabel INSCusNameOrNIC_TF_Label7;
    private javax.swing.JLabel INSCusNameOrNIC_TF_Label9;
    private javax.swing.JLabel MainPanelBranchIDLable;
    private javax.swing.JLabel MainPanelBranchNameLable;
    private javax.swing.JLabel PPBraIDLabel;
    private javax.swing.JLabel PPBraNameLabel;
    private javax.swing.JButton PPExitBtn;
    private javax.swing.JButton PPMinimizeBtn;
    private javax.swing.JLabel PPUserNameLbl;
    private javax.swing.JTextField PayChequeNoTF;
    private javax.swing.JRadioButton PayChequeRadioBtn;
    private javax.swing.JLabel SeldoLogo;
    private javax.swing.JLabel Timelbl;
    private javax.swing.JLabel Timelbl1;
    private javax.swing.JPanel TopPanel;
    private javax.swing.JLabel UserNameDisplayLabel;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    // End of variables declaration//GEN-END:variables
}
