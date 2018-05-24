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
public class CustomerJF extends javax.swing.JFrame {

    /**
     * Creates new form CustomerJF
     */
    public CustomerJF() {
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
            Logger.getLogger(CustomerJF.class.getName()).log(Level.SEVERE, null, e);
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
            Logger.getLogger(CustomerJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    //Button Panel Methods END
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CustomerMainPanel = new javax.swing.JPanel();
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
        CUSContentPanel = new javax.swing.JPanel();
        CPCustomerPanel = new javax.swing.JPanel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        FNameTF = new javax.swing.JTextField();
        LNameTF = new javax.swing.JTextField();
        CNoTF = new javax.swing.JTextField();
        CusIDTF = new javax.swing.JTextField();
        NICNoTF = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        AddressTA = new javax.swing.JTextArea();
        Delete = new javax.swing.JButton();
        Edit = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        jLabel175 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        CustomerTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        CustomerMainPanel.setBackground(new java.awt.Color(51, 51, 51));
        CustomerMainPanel.setPreferredSize(new java.awt.Dimension(1366, 768));
        CustomerMainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TopicPanel.setBackground(new java.awt.Color(102, 102, 102));
        TopicPanel.setOpaque(false);
        TopicPanel.setPreferredSize(new java.awt.Dimension(230, 710));
        TopicPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SPArrowLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/ArrowSingleBlue.png"))); // NOI18N
        TopicPanel.add(SPArrowLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, -1, -1));

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
        SPFinishedItemsBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/FinishedItemsLableIMG02.png")));
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
        TopicPanel.add(SPCustomersBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, -1, -1));

        SPEmployeeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/EmployeesLableIMG01.png"))); // NOI18N
        SPEmployeeBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/EmployeesLableIMG02.png")));
        SPEmployeeBtn.setMaximumSize(new java.awt.Dimension(200, 40));
        SPEmployeeBtn.setMinimumSize(new java.awt.Dimension(200, 40));
        SPEmployeeBtn.setName(""); // NOI18N
        SPEmployeeBtn.setPreferredSize(new java.awt.Dimension(200, 40));
        SPEmployeeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SPEmployeeBtnActionPerformed(evt);
            }
        });
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

        CustomerMainPanel.add(TopicPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 230, 710));

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

        CustomerMainPanel.add(TopPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 60));

        CUSContentPanel.setBackground(new java.awt.Color(51, 51, 51));
        CUSContentPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CPCustomerPanel.setMinimumSize(new java.awt.Dimension(1140, 710));
        CPCustomerPanel.setOpaque(false);
        CPCustomerPanel.setPreferredSize(new java.awt.Dimension(1140, 710));
        CPCustomerPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel81.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 24)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(255, 255, 255));
        jLabel81.setText("Customer Details");
        CPCustomerPanel.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 220, 80));

        jLabel82.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(255, 255, 255));
        jLabel82.setText("Cus ID");
        CPCustomerPanel.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, -1, -1));

        jLabel83.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(255, 255, 255));
        jLabel83.setText("NIC No");
        CPCustomerPanel.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, -1, -1));

        jLabel84.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(255, 255, 255));
        jLabel84.setText("First Name");
        CPCustomerPanel.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, -1, -1));

        jLabel87.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(255, 255, 255));
        jLabel87.setText("Last Name");
        CPCustomerPanel.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, -1, -1));

        jLabel88.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(255, 255, 255));
        jLabel88.setText("Contact No");
        CPCustomerPanel.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, -1, -1));

        jLabel89.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel89.setForeground(new java.awt.Color(255, 255, 255));
        jLabel89.setText("Address");
        CPCustomerPanel.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, -1, -1));

        FNameTF.setBackground(new java.awt.Color(102, 102, 102));
        FNameTF.setForeground(new java.awt.Color(255, 255, 255));
        FNameTF.setPreferredSize(new java.awt.Dimension(200, 24));
        CPCustomerPanel.add(FNameTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 280, -1));

        LNameTF.setBackground(new java.awt.Color(102, 102, 102));
        LNameTF.setForeground(new java.awt.Color(255, 255, 255));
        LNameTF.setPreferredSize(new java.awt.Dimension(200, 24));
        CPCustomerPanel.add(LNameTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 280, -1));

        CNoTF.setBackground(new java.awt.Color(102, 102, 102));
        CNoTF.setForeground(new java.awt.Color(255, 255, 255));
        CNoTF.setPreferredSize(new java.awt.Dimension(200, 24));
        CPCustomerPanel.add(CNoTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, 280, -1));

        CusIDTF.setBackground(new java.awt.Color(102, 102, 102));
        CusIDTF.setForeground(new java.awt.Color(255, 255, 255));
        CusIDTF.setPreferredSize(new java.awt.Dimension(200, 24));
        CPCustomerPanel.add(CusIDTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 280, -1));

        NICNoTF.setBackground(new java.awt.Color(102, 102, 102));
        NICNoTF.setForeground(new java.awt.Color(255, 255, 255));
        NICNoTF.setPreferredSize(new java.awt.Dimension(200, 24));
        CPCustomerPanel.add(NICNoTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, 280, -1));

        AddressTA.setBackground(new java.awt.Color(102, 102, 102));
        AddressTA.setColumns(20);
        AddressTA.setForeground(new java.awt.Color(255, 255, 255));
        AddressTA.setRows(5);
        jScrollPane5.setViewportView(AddressTA);

        CPCustomerPanel.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, 280, 100));

        Delete.setBackground(new java.awt.Color(0, 0, 0));
        Delete.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 16)); // NOI18N
        Delete.setForeground(new java.awt.Color(255, 255, 255));
        Delete.setText("Delete");
        Delete.setPreferredSize(new java.awt.Dimension(171, 25));
        CPCustomerPanel.add(Delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 420, 190, 40));

        Edit.setBackground(new java.awt.Color(0, 0, 0));
        Edit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 16)); // NOI18N
        Edit.setForeground(new java.awt.Color(255, 255, 255));
        Edit.setText("Edit");
        Edit.setPreferredSize(new java.awt.Dimension(171, 25));
        CPCustomerPanel.add(Edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 190, 40));

        Update.setBackground(new java.awt.Color(0, 0, 0));
        Update.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 16)); // NOI18N
        Update.setForeground(new java.awt.Color(255, 255, 255));
        Update.setText("Update");
        Update.setPreferredSize(new java.awt.Dimension(171, 25));
        CPCustomerPanel.add(Update, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 420, 190, 40));

        jLabel175.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel175.setForeground(new java.awt.Color(255, 255, 255));
        jLabel175.setText("Recent Activity");
        CPCustomerPanel.add(jLabel175, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, 120, -1));

        CustomerTable.setBackground(new java.awt.Color(102, 102, 102));
        CustomerTable.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 11)); // NOI18N
        CustomerTable.setForeground(new java.awt.Color(255, 255, 255));
        CustomerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer ID", "NIC No", "First Name", "Last Email", "Contact No", "Address", "Recent Activity", "User Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        CustomerTable.setMaximumSize(new java.awt.Dimension(1300, 1000));
        CustomerTable.setMinimumSize(new java.awt.Dimension(1300, 160));
        CustomerTable.setPreferredSize(new java.awt.Dimension(1300, 1000));
        jScrollPane12.setViewportView(CustomerTable);

        CPCustomerPanel.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, 1080, 190));

        CUSContentPanel.add(CPCustomerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, -1, -1));

        CustomerMainPanel.add(CUSContentPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(CustomerMainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(CustomerMainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void SPSalesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPSalesBtnActionPerformed
        try {
            SalesJF NewSalesJF = new SalesJF();
            NewSalesJF.setVisible(true);
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

    private void SPEmployeeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPEmployeeBtnActionPerformed
        try {
            EmployeeJF NewEmployeeJF = new EmployeeJF();
            NewEmployeeJF.setVisible(true);
            this.setVisible(false);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_SPEmployeeBtnActionPerformed

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
            java.util.logging.Logger.getLogger(CustomerJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerJF().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea AddressTA;
    private javax.swing.JTextField CNoTF;
    private javax.swing.JPanel CPCustomerPanel;
    private javax.swing.JPanel CUSContentPanel;
    private javax.swing.JTextField CusIDTF;
    private javax.swing.JPanel CustomerMainPanel;
    private javax.swing.JTable CustomerTable;
    private javax.swing.JLabel Datelbl;
    private javax.swing.JLabel Datelbl1;
    private javax.swing.JButton Delete;
    private javax.swing.JButton Edit;
    private javax.swing.JTextField FNameTF;
    private javax.swing.JTextField LNameTF;
    private javax.swing.JLabel MainPanelBranchIDLable;
    private javax.swing.JLabel MainPanelBranchNameLable;
    private javax.swing.JTextField NICNoTF;
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
    private javax.swing.JButton Update;
    private javax.swing.JLabel UserNameDisplayLabel;
    private javax.swing.JLabel jLabel175;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane5;
    // End of variables declaration//GEN-END:variables
}
