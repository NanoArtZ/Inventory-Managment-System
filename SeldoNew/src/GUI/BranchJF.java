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
public class BranchJF extends javax.swing.JFrame {

    /**
     * Creates new form BranchJF
     */
    public BranchJF() {
        initComponents();
        ButtonBehaviorMethod();
        
        showDate();
        showTime();
        FullScreenMethod();
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
            Logger.getLogger(BranchJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    //Full Screen Method END
    
//    Date&Time=Aloka------//

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
//    Date&Time Method END ----// Aloka
    
//----- Button Behavior Method Start -----//
    public void ButtonBehaviorMethod() {
        try {
            SPExitBtn.setOpaque(false);
            SPExitBtn.setContentAreaFilled(false);
            SPExitBtn.setBorderPainted(false);

            SPMinimizeBtn.setOpaque(false);
            SPMinimizeBtn.setContentAreaFilled(false);
            SPMinimizeBtn.setBorderPainted(false);

            SPSalesBtn.setOpaque(false);
            SPSalesBtn.setContentAreaFilled(false);
            SPSalesBtn.setBorderPainted(false);

            SPFinishedItemsBtn.setOpaque(false);
            SPFinishedItemsBtn.setContentAreaFilled(false);
            SPFinishedItemsBtn.setBorderPainted(false);

            SPRawItemBtn.setOpaque(false);
            SPRawItemBtn.setContentAreaFilled(false);
            SPRawItemBtn.setBorderPainted(false);

            SPCustomersBtn.setOpaque(false);
            SPCustomersBtn.setContentAreaFilled(false);
            SPCustomersBtn.setBorderPainted(false);

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

            SPReportBtn.setOpaque(false);
            SPReportBtn.setContentAreaFilled(false);
            SPReportBtn.setBorderPainted(false);

            SPBranchersBtn.setOpaque(false);
            SPBranchersBtn.setContentAreaFilled(false);
            SPBranchersBtn.setBorderPainted(false);

        } catch (Exception e) {
            Logger.getLogger(BranchJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }
//----- Button Behavior Method END -----//   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
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
        CPBranchPanel = new javax.swing.JPanel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        BIDTF = new javax.swing.JTextField();
        BCityTF = new javax.swing.JTextField();
        BNOTF = new javax.swing.JTextField();
        BEmailTF = new javax.swing.JTextField();
        jLabel80 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        BAddressTA = new javax.swing.JTextArea();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jLabel173 = new javax.swing.JLabel();
        BEmailTF1 = new javax.swing.JTextField();
        jLabel174 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        BracnchTable = new javax.swing.JTable();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(new java.awt.Dimension(1366, 768));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(1366, 768));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        CPBranchPanel.setBackground(new java.awt.Color(0, 0, 0));
        CPBranchPanel.setMinimumSize(new java.awt.Dimension(1140, 710));
        CPBranchPanel.setOpaque(false);
        CPBranchPanel.setPreferredSize(new java.awt.Dimension(1140, 710));
        CPBranchPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel75.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(255, 255, 255));
        jLabel75.setText("Branch Address");
        CPBranchPanel.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 130, -1));

        jLabel76.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(255, 255, 255));
        jLabel76.setText("Branch Email");
        CPBranchPanel.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 100, -1));

        jLabel77.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(255, 255, 255));
        jLabel77.setText("Branch Manager Name");
        CPBranchPanel.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 160, -1));

        jLabel78.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(255, 255, 255));
        jLabel78.setText("Branch City");
        CPBranchPanel.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 90, 20));

        jLabel79.setBackground(new java.awt.Color(255, 255, 255));
        jLabel79.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(255, 255, 255));
        jLabel79.setText("Branch ID");
        CPBranchPanel.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, -1));

        BIDTF.setBackground(new java.awt.Color(102, 102, 102));
        BIDTF.setMinimumSize(new java.awt.Dimension(6, 24));
        BIDTF.setPreferredSize(new java.awt.Dimension(6, 24));
        CPBranchPanel.add(BIDTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, 260, -1));

        BCityTF.setBackground(new java.awt.Color(102, 102, 102));
        BCityTF.setMinimumSize(new java.awt.Dimension(6, 24));
        BCityTF.setPreferredSize(new java.awt.Dimension(6, 24));
        CPBranchPanel.add(BCityTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 260, -1));

        BNOTF.setBackground(new java.awt.Color(102, 102, 102));
        BNOTF.setMinimumSize(new java.awt.Dimension(6, 24));
        BNOTF.setPreferredSize(new java.awt.Dimension(6, 24));
        CPBranchPanel.add(BNOTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, 260, -1));

        BEmailTF.setBackground(new java.awt.Color(102, 102, 102));
        BEmailTF.setMinimumSize(new java.awt.Dimension(6, 24));
        BEmailTF.setPreferredSize(new java.awt.Dimension(6, 24));
        CPBranchPanel.add(BEmailTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 210, 260, -1));

        jLabel80.setBackground(new java.awt.Color(255, 255, 255));
        jLabel80.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 24)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(255, 255, 255));
        jLabel80.setText("Branch");
        CPBranchPanel.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        BAddressTA.setBackground(new java.awt.Color(102, 102, 102));
        BAddressTA.setColumns(20);
        BAddressTA.setRows(5);
        jScrollPane4.setViewportView(BAddressTA);

        CPBranchPanel.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, 260, -1));

        jButton13.setBackground(new java.awt.Color(0, 0, 0));
        jButton13.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 16)); // NOI18N
        jButton13.setForeground(new java.awt.Color(255, 255, 255));
        jButton13.setText("Add New Branch");
        jButton13.setPreferredSize(new java.awt.Dimension(171, 25));
        CPBranchPanel.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 190, 40));

        jButton14.setBackground(new java.awt.Color(0, 0, 0));
        jButton14.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 16)); // NOI18N
        jButton14.setForeground(new java.awt.Color(255, 255, 255));
        jButton14.setText("Edit Branch");
        jButton14.setPreferredSize(new java.awt.Dimension(171, 25));
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        CPBranchPanel.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 410, 190, 40));

        jButton15.setBackground(new java.awt.Color(0, 0, 0));
        jButton15.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 16)); // NOI18N
        jButton15.setForeground(new java.awt.Color(255, 255, 255));
        jButton15.setText("Update Branch");
        jButton15.setPreferredSize(new java.awt.Dimension(171, 25));
        CPBranchPanel.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 410, 190, 40));

        jLabel173.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel173.setForeground(new java.awt.Color(255, 255, 255));
        jLabel173.setText("Contact Number");
        CPBranchPanel.add(jLabel173, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 360, 130, -1));

        BEmailTF1.setBackground(new java.awt.Color(102, 102, 102));
        BEmailTF1.setMinimumSize(new java.awt.Dimension(6, 24));
        BEmailTF1.setPreferredSize(new java.awt.Dimension(6, 24));
        CPBranchPanel.add(BEmailTF1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 360, 260, -1));

        jLabel174.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel174.setForeground(new java.awt.Color(255, 255, 255));
        jLabel174.setText("Recent Activity");
        CPBranchPanel.add(jLabel174, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, 120, -1));

        BracnchTable.setBackground(new java.awt.Color(102, 102, 102));
        BracnchTable.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 11)); // NOI18N
        BracnchTable.setForeground(new java.awt.Color(255, 255, 255));
        BracnchTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Branch ID", "Branch City", "Manager Name", "Branch Email", "Address", "Contact Number", "Recent Activity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        BracnchTable.setMaximumSize(new java.awt.Dimension(1300, 1000));
        BracnchTable.setMinimumSize(new java.awt.Dimension(1300, 160));
        BracnchTable.setPreferredSize(new java.awt.Dimension(1300, 1000));
        jScrollPane11.setViewportView(BracnchTable);

        CPBranchPanel.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, 1080, 190));

        jPanel1.add(CPBranchPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, -1, -1));

        TopicPanel.setBackground(new java.awt.Color(102, 102, 102));
        TopicPanel.setOpaque(false);
        TopicPanel.setPreferredSize(new java.awt.Dimension(230, 710));
        TopicPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SPArrowLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/ArrowSingleBlue.png"))); // NOI18N
        TopicPanel.add(SPArrowLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 560, -1, -1));

        SPSalesBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/SalesLableIMG01.png"))); // NOI18N
        SPSalesBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/SalesLableIMG02.png"))); // NOI18N
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
        TopicPanel.add(SPFinishedItemsBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, -1, -1));

        SPRawItemBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/RawItemsLableIMG01.png"))); // NOI18N
        SPRawItemBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/RawItemsLableIMG02.png"))); // NOI18N
        SPRawItemBtn.setMaximumSize(new java.awt.Dimension(200, 40));
        SPRawItemBtn.setMinimumSize(new java.awt.Dimension(200, 40));
        SPRawItemBtn.setName(""); // NOI18N
        SPRawItemBtn.setPreferredSize(new java.awt.Dimension(200, 40));
        SPRawItemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SPRawItemBtnActionPerformed(evt);
            }
        });
        TopicPanel.add(SPRawItemBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, -1, -1));

        SPCustomersBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/CustomersLableIMG01.png"))); // NOI18N
        SPCustomersBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/CustomersLableIMG02.png"))); // NOI18N
        SPCustomersBtn.setMaximumSize(new java.awt.Dimension(200, 40));
        SPCustomersBtn.setMinimumSize(new java.awt.Dimension(200, 40));
        SPCustomersBtn.setName(""); // NOI18N
        SPCustomersBtn.setPreferredSize(new java.awt.Dimension(200, 40));
        SPCustomersBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SPCustomersBtnActionPerformed(evt);
            }
        });
        TopicPanel.add(SPCustomersBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, -1, -1));

        SPEmployeeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/EmployeesLableIMG01.png"))); // NOI18N
        SPEmployeeBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/EmployeesLableIMG02.png"))); // NOI18N
        SPEmployeeBtn.setMaximumSize(new java.awt.Dimension(200, 40));
        SPEmployeeBtn.setMinimumSize(new java.awt.Dimension(200, 40));
        SPEmployeeBtn.setName(""); // NOI18N
        SPEmployeeBtn.setPreferredSize(new java.awt.Dimension(200, 40));
        SPEmployeeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SPEmployeeBtnActionPerformed(evt);
            }
        });
        TopicPanel.add(SPEmployeeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 200, -1));

        SPSupplierBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/SupplierLableIMG01.png"))); // NOI18N
        SPSupplierBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/SupplierLableIMG02.png"))); // NOI18N
        SPSupplierBtn.setMaximumSize(new java.awt.Dimension(200, 40));
        SPSupplierBtn.setMinimumSize(new java.awt.Dimension(200, 40));
        SPSupplierBtn.setName(""); // NOI18N
        SPSupplierBtn.setPreferredSize(new java.awt.Dimension(200, 40));
        SPSupplierBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SPSupplierBtnActionPerformed(evt);
            }
        });
        TopicPanel.add(SPSupplierBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, -1, -1));

        SPVehicleBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/VehiclesLableIMG01.png"))); // NOI18N
        SPVehicleBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/VehiclesLableIMG02.png"))); // NOI18N
        SPVehicleBtn.setMaximumSize(new java.awt.Dimension(200, 40));
        SPVehicleBtn.setMinimumSize(new java.awt.Dimension(200, 40));
        SPVehicleBtn.setName(""); // NOI18N
        SPVehicleBtn.setPreferredSize(new java.awt.Dimension(200, 40));
        SPVehicleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SPVehicleBtnActionPerformed(evt);
            }
        });
        TopicPanel.add(SPVehicleBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, -1, -1));

        SPSettingsBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/SettingsLableIMG01.png"))); // NOI18N
        SPSettingsBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/SettingsLableIMG02.png"))); // NOI18N
        SPSettingsBtn.setMaximumSize(new java.awt.Dimension(200, 40));
        SPSettingsBtn.setMinimumSize(new java.awt.Dimension(200, 40));
        SPSettingsBtn.setName(""); // NOI18N
        SPSettingsBtn.setPreferredSize(new java.awt.Dimension(200, 40));
        SPSettingsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SPSettingsBtnActionPerformed(evt);
            }
        });
        TopicPanel.add(SPSettingsBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 650, 200, -1));

        SPPaymentsBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/PaymentsLableIMG01.png"))); // NOI18N
        SPPaymentsBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/PaymentsLableIMG02.png"))); // NOI18N
        SPPaymentsBtn.setMaximumSize(new java.awt.Dimension(200, 40));
        SPPaymentsBtn.setMinimumSize(new java.awt.Dimension(200, 40));
        SPPaymentsBtn.setName(""); // NOI18N
        SPPaymentsBtn.setPreferredSize(new java.awt.Dimension(200, 40));
        SPPaymentsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SPPaymentsBtnActionPerformed(evt);
            }
        });
        TopicPanel.add(SPPaymentsBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, -1, -1));

        SPReportBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/ReportLableIMG01.png"))); // NOI18N
        SPReportBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/ReportLableIMG02.png"))); // NOI18N
        SPReportBtn.setMaximumSize(new java.awt.Dimension(200, 40));
        SPReportBtn.setMinimumSize(new java.awt.Dimension(200, 40));
        SPReportBtn.setName(""); // NOI18N
        SPReportBtn.setPreferredSize(new java.awt.Dimension(200, 40));
        SPReportBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SPReportBtnActionPerformed(evt);
            }
        });
        TopicPanel.add(SPReportBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, -1, -1));

        SPBranchersBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/BranchesLableIMG01.png"))); // NOI18N
        SPBranchersBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/BranchesLableIMG02.png"))); // NOI18N
        SPBranchersBtn.setMaximumSize(new java.awt.Dimension(200, 40));
        SPBranchersBtn.setMinimumSize(new java.awt.Dimension(200, 40));
        SPBranchersBtn.setName(""); // NOI18N
        SPBranchersBtn.setPreferredSize(new java.awt.Dimension(200, 40));
        SPBranchersBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SPBranchersBtnActionPerformed(evt);
            }
        });
        TopicPanel.add(SPBranchersBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 560, -1, -1));

        jPanel1.add(TopicPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 230, 710));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1370, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE)
        );

        jPanel1.getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton14ActionPerformed

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

    private void SPSettingsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPSettingsBtnActionPerformed
        try {
            SettingJF NewSettingJF = new SettingJF();
            NewSettingJF.setVisible(true);
            this.setVisible(false);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_SPSettingsBtnActionPerformed

    private void SPPaymentsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPPaymentsBtnActionPerformed
        try {
            PaymentJF NewSalesJF = new PaymentJF();
            NewSalesJF.setVisible(true);
            this.setVisible(false);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_SPPaymentsBtnActionPerformed

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
            java.util.logging.Logger.getLogger(BranchJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BranchJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BranchJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BranchJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BranchJF().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea BAddressTA;
    private javax.swing.JTextField BCityTF;
    private javax.swing.JTextField BEmailTF;
    private javax.swing.JTextField BEmailTF1;
    private javax.swing.JTextField BIDTF;
    private javax.swing.JTextField BNOTF;
    private javax.swing.JTable BracnchTable;
    private javax.swing.JPanel CPBranchPanel;
    private javax.swing.JLabel Datelbl;
    private javax.swing.JLabel Datelbl1;
    private javax.swing.JLabel MainPanelBranchIDLable;
    private javax.swing.JLabel MainPanelBranchNameLable;
    private javax.swing.JLabel SPArrowLbl;
    private javax.swing.JLabel SPBraIDLabel;
    private javax.swing.JLabel SPBraNameLabel;
    private javax.swing.JButton SPBranchersBtn;
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
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JLabel jLabel173;
    private javax.swing.JLabel jLabel174;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables
}
