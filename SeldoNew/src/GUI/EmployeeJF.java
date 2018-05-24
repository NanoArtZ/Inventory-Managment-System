/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.DashBoardJF;
import GUI.PaymentJF;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

/**
 *
 * @author Nano ArtZ
 */
public class EmployeeJF extends javax.swing.JFrame {

    /**
     * Creates new form Employee
     */
    public EmployeeJF() {
        initComponents();
        showDate();
        showTime();
        FullScreenMethod();
        TransparantButtonMethod();
    }

    //Date&Time=Start
    void showDate(){
        Datelbl.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
    }
    void showTime(){
        new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Timelbl.setText(new SimpleDateFormat("hh:mm:ss").format(new Date()));
            }
        }).start();
    }//Date&Time=End
    
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
            Logger.getLogger(EmployeeJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    //Full Screen Method END
    
    //Button Panel Methods Start

    public void TransparantButtonMethod() {
        try {
            
            SPSalesBtn.setOpaque(false);
            SPSalesBtn.setContentAreaFilled(false);
            SPSalesBtn.setBorderPainted(false);

            SPCustomersBtn.setOpaque(false);
            SPCustomersBtn.setContentAreaFilled(false);
            SPCustomersBtn.setBorderPainted(false);

            SPBranchersBtn.setOpaque(false);
            SPBranchersBtn.setContentAreaFilled(false);
            SPBranchersBtn.setBorderPainted(false);

            SPEmployeeBtn.setOpaque(false);
            SPEmployeeBtn.setContentAreaFilled(false);
            SPEmployeeBtn.setBorderPainted(false);

            SPSupplierBtn.setOpaque(false);
            SPSupplierBtn.setContentAreaFilled(false);
            SPSupplierBtn.setBorderPainted(false);

            SPVehicleBtn.setOpaque(false);
            SPVehicleBtn.setContentAreaFilled(false);
            SPVehicleBtn.setBorderPainted(false);

            SPSettingsBtn.setOpaque(false);
            SPSettingsBtn.setContentAreaFilled(false);
            SPSettingsBtn.setBorderPainted(false);

            SPPaymentsBtn.setOpaque(false);
            SPPaymentsBtn.setContentAreaFilled(false);
            SPPaymentsBtn.setBorderPainted(false);

            SPFinishedItemsBtn.setOpaque(false);
            SPFinishedItemsBtn.setContentAreaFilled(false);
            SPFinishedItemsBtn.setBorderPainted(false);

            SPRawItemBtn.setOpaque(false);
            SPRawItemBtn.setContentAreaFilled(false);
            SPRawItemBtn.setBorderPainted(false);

            SPExitBtn.setOpaque(false);
            SPExitBtn.setContentAreaFilled(false);
            SPExitBtn.setBorderPainted(false);
            
            SPMinimizeBtn.setOpaque(false);
            SPMinimizeBtn.setContentAreaFilled(false);
            SPMinimizeBtn.setBorderPainted(false);
            
            SPReportBtn.setOpaque(false);
            SPReportBtn.setContentAreaFilled(false);
            SPReportBtn.setBorderPainted(false);

        } catch (Exception e) {
            Logger.getLogger(EmployeeJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    //Button Panel Methods END
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        TopicPanel = new javax.swing.JPanel();
        SPArrowLbl = new javax.swing.JLabel();
        SPSalesBtn = new javax.swing.JButton();
        SPFinishedItemsBtn = new javax.swing.JButton();
        SPRawItemBtn = new javax.swing.JButton();
        SPCustomersBtn = new javax.swing.JButton();
        SPEmployeeBtn = new javax.swing.JButton();
        SPSupplierBtn = new javax.swing.JButton();
        SPVehicleBtn = new javax.swing.JButton();
        SPSettingsBtn = new javax.swing.JButton();
        SPPaymentsBtn = new javax.swing.JButton();
        SPReportBtn = new javax.swing.JButton();
        SPBranchersBtn = new javax.swing.JButton();
        SPChequesBtn = new javax.swing.JButton();
        TopPanel = new javax.swing.JPanel();
        Timelbl = new javax.swing.JLabel();
        Datelbl = new javax.swing.JLabel();
        Datelbl1 = new javax.swing.JLabel();
        Timelbl1 = new javax.swing.JLabel();
        UserNameDisplayLabel = new javax.swing.JLabel();
        SPUserNameLbl = new javax.swing.JLabel();
        SPBraIDLabel = new javax.swing.JLabel();
        SPBraNameLabel = new javax.swing.JLabel();
        MainPanelBranchIDLable = new javax.swing.JLabel();
        MainPanelBranchNameLable = new javax.swing.JLabel();
        SeldoLogo = new javax.swing.JLabel();
        SPExitBtn = new javax.swing.JButton();
        SPMinimizeBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        CPEmployeePanel = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jTextField18 = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jTextField19 = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jTextField20 = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jTextField21 = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jTextField22 = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jTextField23 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jTextField25 = new javax.swing.JTextField();
        jTextField26 = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jTextField27 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jTextField24 = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        jTextField28 = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jTextField29 = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        jTextField30 = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jTextField31 = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        jTextField32 = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        jTextField33 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(1366, 768));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TopicPanel.setBackground(new java.awt.Color(102, 102, 102));
        TopicPanel.setOpaque(false);
        TopicPanel.setPreferredSize(new java.awt.Dimension(230, 710));
        TopicPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SPArrowLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/ArrowSingleBlue.png"))); // NOI18N
        TopicPanel.add(SPArrowLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, -1, -1));

        SPSalesBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/SalesLableIMG01.png"))); // NOI18N
        SPSalesBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/SalesLableIMG02.png")));
        SPSalesBtn.setMaximumSize(new java.awt.Dimension(150, 40));
        SPSalesBtn.setMinimumSize(new java.awt.Dimension(150, 40));
        SPSalesBtn.setName(""); // NOI18N
        SPSalesBtn.setPreferredSize(new java.awt.Dimension(150, 40));
        SPSalesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SPSalesBtnActionPerformed(evt);
            }
        });
        TopicPanel.add(SPSalesBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 200, -1));

        SPFinishedItemsBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/FinishedItemsLableIMG01.png"))); // NOI18N
        SPFinishedItemsBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/FinishedItemsLableIMG02.png"))); // NOI18N
        SPFinishedItemsBtn.setMaximumSize(new java.awt.Dimension(200, 40));
        SPFinishedItemsBtn.setMinimumSize(new java.awt.Dimension(200, 40));
        SPFinishedItemsBtn.setName(""); // NOI18N
        SPFinishedItemsBtn.setPreferredSize(new java.awt.Dimension(200, 40));
        SPFinishedItemsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SPFinishedItemsBtnActionPerformed(evt);
            }
        });
        TopicPanel.add(SPFinishedItemsBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, -1, -1));

        SPRawItemBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/RawItemsLableIMG01.png"))); // NOI18N
        SPRawItemBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/RawItemsLableIMG02.png")));
        SPRawItemBtn.setMaximumSize(new java.awt.Dimension(200, 40));
        SPRawItemBtn.setMinimumSize(new java.awt.Dimension(200, 40));
        SPRawItemBtn.setName(""); // NOI18N
        SPRawItemBtn.setPreferredSize(new java.awt.Dimension(200, 40));
        SPRawItemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SPRawItemBtnActionPerformed(evt);
            }
        });
        TopicPanel.add(SPRawItemBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, -1, -1));

        SPCustomersBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/CustomersLableIMG01.png"))); // NOI18N
        SPCustomersBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/CustomersLableIMG02.png")));
        SPCustomersBtn.setMaximumSize(new java.awt.Dimension(200, 40));
        SPCustomersBtn.setMinimumSize(new java.awt.Dimension(200, 40));
        SPCustomersBtn.setName(""); // NOI18N
        SPCustomersBtn.setPreferredSize(new java.awt.Dimension(200, 40));
        SPCustomersBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SPCustomersBtnActionPerformed(evt);
            }
        });
        TopicPanel.add(SPCustomersBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, -1, -1));

        SPEmployeeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/EmployeesLableIMG01.png"))); // NOI18N
        SPEmployeeBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/EmployeesLableIMG02.png")));
        SPEmployeeBtn.setMaximumSize(new java.awt.Dimension(200, 40));
        SPEmployeeBtn.setMinimumSize(new java.awt.Dimension(200, 40));
        SPEmployeeBtn.setName(""); // NOI18N
        SPEmployeeBtn.setPreferredSize(new java.awt.Dimension(200, 40));
        TopicPanel.add(SPEmployeeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 200, -1));

        SPSupplierBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/SupplierLableIMG01.png"))); // NOI18N
        SPSupplierBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/SupplierLableIMG02.png")));
        SPSupplierBtn.setMaximumSize(new java.awt.Dimension(200, 40));
        SPSupplierBtn.setMinimumSize(new java.awt.Dimension(200, 40));
        SPSupplierBtn.setName(""); // NOI18N
        SPSupplierBtn.setPreferredSize(new java.awt.Dimension(200, 40));
        SPSupplierBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SPSupplierBtnActionPerformed(evt);
            }
        });
        TopicPanel.add(SPSupplierBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, -1, -1));

        SPVehicleBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/VehiclesLableIMG01.png"))); // NOI18N
        SPVehicleBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/VehiclesLableIMG02.png")));
        SPVehicleBtn.setMaximumSize(new java.awt.Dimension(200, 40));
        SPVehicleBtn.setMinimumSize(new java.awt.Dimension(200, 40));
        SPVehicleBtn.setName(""); // NOI18N
        SPVehicleBtn.setPreferredSize(new java.awt.Dimension(200, 40));
        SPVehicleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SPVehicleBtnActionPerformed(evt);
            }
        });
        TopicPanel.add(SPVehicleBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, -1, -1));

        SPSettingsBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/SettingsLableIMG01.png"))); // NOI18N
        SPSettingsBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/SettingsLableIMG02.png")));
        SPSettingsBtn.setMaximumSize(new java.awt.Dimension(200, 40));
        SPSettingsBtn.setMinimumSize(new java.awt.Dimension(200, 40));
        SPSettingsBtn.setName(""); // NOI18N
        SPSettingsBtn.setPreferredSize(new java.awt.Dimension(200, 40));
        SPSettingsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SPSettingsBtnActionPerformed(evt);
            }
        });
        TopicPanel.add(SPSettingsBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 570, 200, -1));

        SPPaymentsBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/PaymentsLableIMG01.png"))); // NOI18N
        SPPaymentsBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/PaymentsLableIMG02.png")));
        SPPaymentsBtn.setMaximumSize(new java.awt.Dimension(200, 40));
        SPPaymentsBtn.setMinimumSize(new java.awt.Dimension(200, 40));
        SPPaymentsBtn.setName(""); // NOI18N
        SPPaymentsBtn.setPreferredSize(new java.awt.Dimension(200, 40));
        SPPaymentsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SPPaymentsBtnActionPerformed(evt);
            }
        });
        TopicPanel.add(SPPaymentsBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, -1, -1));

        SPReportBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/ReportLableIMG01.png"))); // NOI18N
        SPReportBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/ReportLableIMG02.png")));
        SPReportBtn.setMaximumSize(new java.awt.Dimension(200, 40));
        SPReportBtn.setMinimumSize(new java.awt.Dimension(200, 40));
        SPReportBtn.setName(""); // NOI18N
        SPReportBtn.setPreferredSize(new java.awt.Dimension(200, 40));
        SPReportBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SPReportBtnActionPerformed(evt);
            }
        });
        TopicPanel.add(SPReportBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, -1, -1));

        SPBranchersBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/BranchesLableIMG01.png"))); // NOI18N
        SPBranchersBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/BranchesLableIMG02.png")));
        SPBranchersBtn.setMaximumSize(new java.awt.Dimension(200, 40));
        SPBranchersBtn.setMinimumSize(new java.awt.Dimension(200, 40));
        SPBranchersBtn.setName(""); // NOI18N
        SPBranchersBtn.setPreferredSize(new java.awt.Dimension(200, 40));
        SPBranchersBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SPBranchersBtnActionPerformed(evt);
            }
        });
        TopicPanel.add(SPBranchersBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 470, -1, -1));

        SPChequesBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/ChequeLableIMG01.png"))); // NOI18N
        SPChequesBtn.setBorderPainted(false);
        SPChequesBtn.setContentAreaFilled(false);
        SPChequesBtn.setMaximumSize(new java.awt.Dimension(200, 40));
        SPChequesBtn.setMinimumSize(new java.awt.Dimension(200, 40));
        SPChequesBtn.setName(""); // NOI18N
        SPChequesBtn.setPreferredSize(new java.awt.Dimension(200, 40));
        SPChequesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SPChequesBtnActionPerformed(evt);
            }
        });
        TopicPanel.add(SPChequesBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, -1, -1));

        jPanel1.add(TopicPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 230, 710));

        TopPanel.setBackground(new java.awt.Color(102, 102, 102));
        TopPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TopPanel.setOpaque(false);
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

        SPUserNameLbl.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        SPUserNameLbl.setForeground(new java.awt.Color(255, 255, 255));
        SPUserNameLbl.setText("User Name :");
        TopPanel.add(SPUserNameLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 80, 20));

        SPBraIDLabel.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        SPBraIDLabel.setForeground(new java.awt.Color(255, 255, 255));
        SPBraIDLabel.setText("Branch Name :");
        TopPanel.add(SPBraIDLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 10, 100, 20));

        SPBraNameLabel.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        SPBraNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        SPBraNameLabel.setText("Branch ID       :");
        TopPanel.add(SPBraNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 30, 100, -1));

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

        SPExitBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/ExitButton1.png"))); // NOI18N
        SPExitBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/ExitButton2.png")));
        SPExitBtn.setPreferredSize(new java.awt.Dimension(50, 40));
        SPExitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SPExitBtnActionPerformed(evt);
            }
        });
        TopPanel.add(SPExitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 10, -1, -1));

        SPMinimizeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/MinimizeButtonPNG0.png"))); // NOI18N
        SPMinimizeBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/MinimizeButtonPNG1.png")));
        SPMinimizeBtn.setPreferredSize(new java.awt.Dimension(50, 40));
        SPMinimizeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SPMinimizeBtnActionPerformed(evt);
            }
        });
        TopPanel.add(SPMinimizeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 10, -1, -1));

        jPanel1.add(TopPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 60));

        jPanel2.setPreferredSize(new java.awt.Dimension(1140, 710));
        jPanel2.setLayout(new java.awt.CardLayout());

        CPEmployeePanel.setBackground(new java.awt.Color(102, 102, 102));
        CPEmployeePanel.setMinimumSize(new java.awt.Dimension(1140, 710));
        CPEmployeePanel.setPreferredSize(new java.awt.Dimension(1140, 710));
        CPEmployeePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel34.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 24)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Employees Details");
        CPEmployeePanel.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jLabel36.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Search Employee");
        CPEmployeePanel.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, 30));

        jTextField10.setBackground(new java.awt.Color(51, 51, 51));
        jTextField10.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jTextField10.setMinimumSize(new java.awt.Dimension(200, 24));
        jTextField10.setPreferredSize(new java.awt.Dimension(200, 24));
        CPEmployeePanel.add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, -1, -1));

        jLabel37.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Employee ID");
        CPEmployeePanel.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, 30));

        jTextField18.setBackground(new java.awt.Color(51, 51, 51));
        jTextField18.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jTextField18.setMinimumSize(new java.awt.Dimension(200, 24));
        jTextField18.setPreferredSize(new java.awt.Dimension(200, 24));
        CPEmployeePanel.add(jTextField18, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, -1, -1));

        jLabel38.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("N.I.C. Number");
        CPEmployeePanel.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, 30));

        jTextField19.setBackground(new java.awt.Color(51, 51, 51));
        jTextField19.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jTextField19.setMinimumSize(new java.awt.Dimension(200, 24));
        jTextField19.setPreferredSize(new java.awt.Dimension(200, 24));
        CPEmployeePanel.add(jTextField19, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, -1, -1));

        jLabel39.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("First Name");
        CPEmployeePanel.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, -1, 30));

        jTextField20.setBackground(new java.awt.Color(51, 51, 51));
        jTextField20.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jTextField20.setMinimumSize(new java.awt.Dimension(200, 24));
        jTextField20.setPreferredSize(new java.awt.Dimension(200, 24));
        CPEmployeePanel.add(jTextField20, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 100, -1, -1));

        jLabel40.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Last Name");
        CPEmployeePanel.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 140, -1, 30));

        jTextField21.setBackground(new java.awt.Color(51, 51, 51));
        jTextField21.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jTextField21.setMinimumSize(new java.awt.Dimension(200, 24));
        jTextField21.setPreferredSize(new java.awt.Dimension(200, 24));
        CPEmployeePanel.add(jTextField21, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 140, -1, -1));

        jLabel41.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("Designation");
        CPEmployeePanel.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, 30));

        jTextField22.setBackground(new java.awt.Color(51, 51, 51));
        jTextField22.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jTextField22.setMinimumSize(new java.awt.Dimension(200, 24));
        jTextField22.setPreferredSize(new java.awt.Dimension(200, 24));
        CPEmployeePanel.add(jTextField22, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, -1, -1));

        jLabel42.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("Salary");
        CPEmployeePanel.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, 30));

        jTextField23.setBackground(new java.awt.Color(51, 51, 51));
        jTextField23.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jTextField23.setMinimumSize(new java.awt.Dimension(200, 24));
        jTextField23.setPreferredSize(new java.awt.Dimension(200, 24));
        CPEmployeePanel.add(jTextField23, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, -1, -1));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Emergency Contact Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("MS Reference Sans Serif", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jPanel3.setOpaque(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel44.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("Contact Name");
        jPanel3.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, 30));

        jTextField25.setBackground(new java.awt.Color(51, 51, 51));
        jTextField25.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jTextField25.setMinimumSize(new java.awt.Dimension(200, 24));
        jTextField25.setPreferredSize(new java.awt.Dimension(200, 24));
        jPanel3.add(jTextField25, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, -1, -1));

        jTextField26.setBackground(new java.awt.Color(51, 51, 51));
        jTextField26.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jTextField26.setMinimumSize(new java.awt.Dimension(200, 24));
        jTextField26.setPreferredSize(new java.awt.Dimension(200, 24));
        jPanel3.add(jTextField26, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, -1, -1));

        jLabel45.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("Contact Number");
        jPanel3.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, 30));

        CPEmployeePanel.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 320, 380, 120));

        jLabel46.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("Date of Birth");
        CPEmployeePanel.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, -1, 30));

        jTextField27.setBackground(new java.awt.Color(51, 51, 51));
        jTextField27.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jTextField27.setMinimumSize(new java.awt.Dimension(200, 24));
        jTextField27.setPreferredSize(new java.awt.Dimension(200, 24));
        CPEmployeePanel.add(jTextField27, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, -1, -1));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Contact Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("MS Reference Sans Serif", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.setOpaque(false);
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel43.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("Home Number");
        jPanel4.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, 30));

        jTextField24.setBackground(new java.awt.Color(51, 51, 51));
        jTextField24.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jTextField24.setMinimumSize(new java.awt.Dimension(200, 24));
        jTextField24.setPreferredSize(new java.awt.Dimension(200, 24));
        jPanel4.add(jTextField24, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, -1, -1));

        jLabel47.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("Mobile Number");
        jPanel4.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, 30));

        jTextField28.setBackground(new java.awt.Color(51, 51, 51));
        jTextField28.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jTextField28.setMinimumSize(new java.awt.Dimension(200, 24));
        jTextField28.setPreferredSize(new java.awt.Dimension(200, 24));
        jPanel4.add(jTextField28, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, -1, -1));

        CPEmployeePanel.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 180, 380, 120));

        jLabel48.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("Age");
        CPEmployeePanel.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, -1, 30));

        jTextField29.setBackground(new java.awt.Color(51, 51, 51));
        jTextField29.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jTextField29.setMinimumSize(new java.awt.Dimension(200, 24));
        jTextField29.setPreferredSize(new java.awt.Dimension(200, 24));
        CPEmployeePanel.add(jTextField29, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 340, -1, -1));

        jLabel49.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("Address");
        CPEmployeePanel.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, -1, 30));

        jTextField30.setBackground(new java.awt.Color(51, 51, 51));
        jTextField30.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jTextField30.setMinimumSize(new java.awt.Dimension(200, 24));
        jTextField30.setPreferredSize(new java.awt.Dimension(200, 24));
        CPEmployeePanel.add(jTextField30, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 380, -1, -1));

        jLabel50.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("Branch");
        CPEmployeePanel.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 500, -1, 30));

        jTextField31.setBackground(new java.awt.Color(51, 51, 51));
        jTextField31.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jTextField31.setMinimumSize(new java.awt.Dimension(200, 24));
        jTextField31.setPreferredSize(new java.awt.Dimension(200, 24));
        CPEmployeePanel.add(jTextField31, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 500, -1, -1));

        jLabel51.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setText("Blood Group");
        CPEmployeePanel.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, -1, 30));

        jTextField32.setBackground(new java.awt.Color(51, 51, 51));
        jTextField32.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jTextField32.setMinimumSize(new java.awt.Dimension(200, 24));
        jTextField32.setPreferredSize(new java.awt.Dimension(200, 24));
        CPEmployeePanel.add(jTextField32, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 420, -1, -1));

        jLabel52.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setText("E-mail Address");
        CPEmployeePanel.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, -1, 30));

        jTextField33.setBackground(new java.awt.Color(51, 51, 51));
        jTextField33.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jTextField33.setMinimumSize(new java.awt.Dimension(200, 24));
        jTextField33.setPreferredSize(new java.awt.Dimension(200, 24));
        CPEmployeePanel.add(jTextField33, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 460, -1, -1));

        jButton6.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jButton6.setText("Add Employee");
        CPEmployeePanel.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 630, 150, 40));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Special Note", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("MS Reference Sans Serif", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel6.setOpaque(false);
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setOpaque(false);
        jScrollPane3.setViewportView(jTextArea2);

        jPanel6.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 460, 100));

        CPEmployeePanel.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 470, 480, 140));

        jButton7.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jButton7.setText("Edit Details");
        CPEmployeePanel.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 630, 150, 40));

        jButton8.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jButton8.setText("Update");
        CPEmployeePanel.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 630, 150, 40));

        jButton9.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jButton9.setText("Delete");
        CPEmployeePanel.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 630, 150, 40));

        jPanel2.add(CPEmployeePanel, "card7");

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, -1, -1));

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
    
    
    
    private void SPSalesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPSalesBtnActionPerformed
        try {
            SalesJF NewwSalesJF = new SalesJF();
            NewwSalesJF.setVisible(true);
            this.setVisible(false);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_SPSalesBtnActionPerformed

    private void SPFinishedItemsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPFinishedItemsBtnActionPerformed
        try {
            FinishedItemsJF NewSalesJF = new FinishedItemsJF();
            NewSalesJF.setVisible(true);
            this.setVisible(false);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_SPFinishedItemsBtnActionPerformed

    private void SPPaymentsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPPaymentsBtnActionPerformed
        try {
            PaymentJF NewSalesJF = new PaymentJF();
            NewSalesJF.setVisible(true);
            this.setVisible(false);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_SPPaymentsBtnActionPerformed

    private void SPExitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPExitBtnActionPerformed
        try {
            DashBoardJF NewDashBoard = new DashBoardJF();
            NewDashBoard.setVisible(true);
            this.setVisible(false);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_SPExitBtnActionPerformed

    private void SPMinimizeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPMinimizeBtnActionPerformed
        this.setState(ICONIFIED);        // TODO add your handling code here:
    }//GEN-LAST:event_SPMinimizeBtnActionPerformed

    private void SPRawItemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPRawItemBtnActionPerformed
        try {
            RawItemsJF NewRawItemsJF = new RawItemsJF();
            NewRawItemsJF.setVisible(true);
            this.setVisible(false);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_SPRawItemBtnActionPerformed

    private void SPCustomersBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPCustomersBtnActionPerformed
        try {
            CustomerJF NewCustomerJF1 = new CustomerJF();
            NewCustomerJF1.setVisible(true);
            this.setVisible(false);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_SPCustomersBtnActionPerformed

    private void SPSupplierBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPSupplierBtnActionPerformed
        try {
            SupplierJF NewSupplierJF = new SupplierJF();
            NewSupplierJF.setVisible(true);
            this.setVisible(false);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_SPSupplierBtnActionPerformed

    private void SPVehicleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPVehicleBtnActionPerformed
        try {
            VehicleJF NewVehicleJF = new VehicleJF();
            NewVehicleJF.setVisible(true);
            this.setVisible(false);
        } catch (Exception e) {
             System.out.println(e);
        }
    }//GEN-LAST:event_SPVehicleBtnActionPerformed

    private void SPReportBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPReportBtnActionPerformed
         try {
            ReportsJF NewReportsJF = new ReportsJF();
            NewReportsJF.setVisible(true);
            this.setVisible(false);
        } catch (Exception e) {
              System.out.println(e);
        }
    }//GEN-LAST:event_SPReportBtnActionPerformed

    private void SPBranchersBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPBranchersBtnActionPerformed
       try {
            BranchJF NewBranchJF = new BranchJF();
            NewBranchJF.setVisible(true);
            this.setVisible(false);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_SPBranchersBtnActionPerformed

    private void SPSettingsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPSettingsBtnActionPerformed
         try {
            SettingJF NewSettingJF = new SettingJF();
            NewSettingJF.setVisible(true);
            this.setVisible(false);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_SPSettingsBtnActionPerformed

    private void SPChequesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPChequesBtnActionPerformed
        try {
            BranchJF NewBranchJF = new BranchJF();
            NewBranchJF.setVisible(true);
            this.setVisible(false);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_SPChequesBtnActionPerformed

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
            java.util.logging.Logger.getLogger(EmployeeJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeJF().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CPEmployeePanel;
    private javax.swing.JLabel Datelbl;
    private javax.swing.JLabel Datelbl1;
    private javax.swing.JLabel MainPanelBranchIDLable;
    private javax.swing.JLabel MainPanelBranchNameLable;
    private javax.swing.JLabel SPArrowLbl;
    private javax.swing.JLabel SPBraIDLabel;
    private javax.swing.JLabel SPBraNameLabel;
    private javax.swing.JButton SPBranchersBtn;
    private javax.swing.JButton SPChequesBtn;
    private javax.swing.JButton SPCustomersBtn;
    private javax.swing.JButton SPEmployeeBtn;
    private javax.swing.JButton SPExitBtn;
    private javax.swing.JButton SPFinishedItemsBtn;
    private javax.swing.JButton SPMinimizeBtn;
    private javax.swing.JButton SPPaymentsBtn;
    private javax.swing.JButton SPRawItemBtn;
    private javax.swing.JButton SPReportBtn;
    private javax.swing.JButton SPSalesBtn;
    private javax.swing.JButton SPSettingsBtn;
    private javax.swing.JButton SPSupplierBtn;
    private javax.swing.JLabel SPUserNameLbl;
    private javax.swing.JButton SPVehicleBtn;
    private javax.swing.JLabel SeldoLogo;
    private javax.swing.JLabel Timelbl;
    private javax.swing.JLabel Timelbl1;
    private javax.swing.JPanel TopPanel;
    private javax.swing.JPanel TopicPanel;
    private javax.swing.JLabel UserNameDisplayLabel;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField32;
    private javax.swing.JTextField jTextField33;
    // End of variables declaration//GEN-END:variables
}
