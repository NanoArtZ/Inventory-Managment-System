/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DBConnection.SeldoDB;
import GUI.DashBoardJF;
import GUI.PaymentJF;
import com.mysql.jdbc.Statement;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Nano ArtZ
 */
public class ReportsJF extends javax.swing.JFrame {

    /**
     * Creates new form ReportsJF
     */
    public ReportsJF() {
        initComponents();
        showDate();
        showTime();
        FullScreenMethod();
        TransparantButtonMethod();
    }

//View Selected Report - Method Start
    public void ViewSelectedReport() {
        try {
            DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) ReportTree.getSelectionPath().getLastPathComponent();
            String selectedReportName = selectedNode.getUserObject().toString();

            if (selectedReportName.equals("Profit statement")) {
                viewProfitStatementReport();
            }
        } catch (Exception e) {
            Logger.getLogger(ReportsJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }
//View Selected Report - Method END 

//View Profit Statement Report - Method Start
    public void viewProfitStatementReport() {
        try {
            Statement s = (Statement) SeldoDB.GetMyConnection().createStatement();
            String ReportSource = "C:\\SELDO\\Reports_V_01\\SeldoReports\\ProfitStatement.jrxml";
            Map<String, Object> params = new HashMap<>();

            String pattern = "yyyy-MM-dd";
            DateFormat formatter = new SimpleDateFormat(pattern);

            String FromDate = formatter.format(RepFromDateDC.getDate());
            String ToDate = formatter.format(RepToDateDC.getDate());

            String FromTime = RepFromTimeTC.getFormatedTime();
            String ToTime = RepToTimeTC.getFormatedTime();

            String FromDateTimeStamp = FromDate + " " + FromTime;
            String ToDateTimeStamp = ToDate + " " + ToTime;

            ResultSet rs = s.executeQuery("SELECT SUM(Amount) FROM sale WHERE DateTime BETWEEN '" + FromDateTimeStamp + "' AND '" + ToDateTimeStamp + "' ");
            rs.next();
            String TotalAmount = rs.getString("SUM(Amount)");

            params.put("FromDateTimePara", FromDateTimeStamp);
            params.put("ToDateTimePara", ToDateTimeStamp);
            params.put("TotalAmountPara", TotalAmount);
            
            JasperReport jasperReport = JasperCompileManager.compileReport(ReportSource);

            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.1.1:3306/seldo?useseldo=true&characterEncoding=UTF-8", "root", "123");

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, conn);
            JasperViewer.viewReport(jasperPrint, false); // with print preview

            //JasperPrintManager.printReport(jasperPrint, false); // Direct print without preview
        } catch (Exception e) {
            Logger.getLogger(PaymentJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }
//View Profit Statement Report - Method END

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
        CPReportPanel = new javax.swing.JPanel();
        jLabel169 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        ReportTree = new javax.swing.JTree();
        jLabel170 = new javax.swing.JLabel();
        RepViewReportBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        RepFromDateDC = new com.toedter.calendar.JDateChooser();
        jLabel172 = new javax.swing.JLabel();
        jLabel173 = new javax.swing.JLabel();
        RepToDateDC = new com.toedter.calendar.JDateChooser();
        jLabel174 = new javax.swing.JLabel();
        jLabel175 = new javax.swing.JLabel();
        RepFromTimeTC = new lu.tudor.santec.jtimechooser.JTimeChooser();
        RepToTimeTC = new lu.tudor.santec.jtimechooser.JTimeChooser();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

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

        CPReportPanel.setBackground(new java.awt.Color(0, 0, 0));
        CPReportPanel.setForeground(new java.awt.Color(255, 255, 255));
        CPReportPanel.setMinimumSize(new java.awt.Dimension(1140, 710));
        CPReportPanel.setOpaque(false);
        CPReportPanel.setPreferredSize(new java.awt.Dimension(1140, 710));
        CPReportPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel169.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 24)); // NOI18N
        jLabel169.setForeground(new java.awt.Color(204, 204, 204));
        jLabel169.setText("Reports");
        CPReportPanel.add(jLabel169, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 190, 38));

        jScrollPane8.setBackground(new java.awt.Color(102, 102, 102));
        jScrollPane8.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane8.setOpaque(false);

        ReportTree.setBackground(new java.awt.Color(153, 153, 153));
        ReportTree.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        ReportTree.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        ReportTree.setForeground(new java.awt.Color(255, 255, 255));
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Reports");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Payments");
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Sales report");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Purchases report");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Raw Item");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Raw Item Invetory");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Re Order Level");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Finished Item");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Finished Item Invetory");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Financial");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Profit statement");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Expenses report");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        ReportTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        ReportTree.setToolTipText("");
        ReportTree.setOpaque(false);
        jScrollPane8.setViewportView(ReportTree);

        CPReportPanel.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 440, 340));

        jLabel170.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel170.setForeground(new java.awt.Color(255, 255, 255));
        jLabel170.setText("Please Select a Report");
        CPReportPanel.add(jLabel170, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        RepViewReportBtn.setBackground(new java.awt.Color(0, 0, 0));
        RepViewReportBtn.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RepViewReportBtn.setForeground(new java.awt.Color(255, 255, 255));
        RepViewReportBtn.setText("View Report");
        RepViewReportBtn.setMaximumSize(new java.awt.Dimension(171, 25));
        RepViewReportBtn.setMinimumSize(new java.awt.Dimension(171, 25));
        RepViewReportBtn.setPreferredSize(new java.awt.Dimension(171, 25));
        RepViewReportBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RepViewReportBtnActionPerformed(evt);
            }
        });
        CPReportPanel.add(RepViewReportBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 630, 190, 40));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)), "Filter Report", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 16), new java.awt.Color(255, 153, 0))); // NOI18N
        jPanel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jPanel2.setOpaque(false);

        jLabel172.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel172.setForeground(new java.awt.Color(255, 255, 255));
        jLabel172.setText("Dated From :");

        jLabel173.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel173.setForeground(new java.awt.Color(255, 255, 255));
        jLabel173.setText("To :");

        jLabel174.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel174.setForeground(new java.awt.Color(255, 255, 255));
        jLabel174.setText("From Time :");

        jLabel175.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel175.setForeground(new java.awt.Color(255, 255, 255));
        jLabel175.setText("To Time :");

        RepFromTimeTC.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        RepToTimeTC.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel172)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(RepFromDateDC, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel174))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLabel173)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(RepToDateDC, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel175)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RepFromTimeTC, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                    .addComponent(RepToTimeTC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RepFromDateDC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel172)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel174, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(RepFromTimeTC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RepToDateDC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel173)
                    .addComponent(RepToTimeTC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel175, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        CPReportPanel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 470, 550, 140));

        jPanel1.add(CPReportPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, -1, -1));

        TopicPanel.setBackground(new java.awt.Color(102, 102, 102));
        TopicPanel.setOpaque(false);
        TopicPanel.setPreferredSize(new java.awt.Dimension(230, 710));
        TopicPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SPArrowLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/ArrowSingleBlue.png"))); // NOI18N
        TopicPanel.add(SPArrowLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 420, -1, -1));

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
        TopicPanel.add(SPFinishedItemsBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, -1, -1));

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
        TopicPanel.add(SPRawItemBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, -1, -1));

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
        TopicPanel.add(SPCustomersBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, -1, -1));

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
        TopicPanel.add(SPEmployeeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 200, -1));

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
        TopicPanel.add(SPSupplierBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, -1, -1));

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
        TopicPanel.add(SPVehicleBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, -1, -1));

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
        TopicPanel.add(SPSettingsBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 570, 200, -1));

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
        TopicPanel.add(SPPaymentsBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, -1, -1));

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
        TopicPanel.add(SPReportBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, -1, -1));

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

    //Date&Time=Start
    void showDate() {
        Datelbl.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
    }

    void showTime() {
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
            Logger.getLogger(ReportsJF.class.getName()).log(Level.SEVERE, null, e);
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
            Logger.getLogger(ReportsJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }

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

    private void SPChequesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPChequesBtnActionPerformed
        try {
            BranchJF NewBranchJF = new BranchJF();
            NewBranchJF.setVisible(true);
            this.setVisible(false);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_SPChequesBtnActionPerformed

    private void RepViewReportBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RepViewReportBtnActionPerformed
        ViewSelectedReport();
    }//GEN-LAST:event_RepViewReportBtnActionPerformed

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
            java.util.logging.Logger.getLogger(ReportsJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReportsJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReportsJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReportsJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReportsJF().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CPReportPanel;
    private javax.swing.JLabel Datelbl;
    private javax.swing.JLabel Datelbl1;
    private javax.swing.JLabel MainPanelBranchIDLable;
    private javax.swing.JLabel MainPanelBranchNameLable;
    private com.toedter.calendar.JDateChooser RepFromDateDC;
    private lu.tudor.santec.jtimechooser.JTimeChooser RepFromTimeTC;
    private com.toedter.calendar.JDateChooser RepToDateDC;
    private lu.tudor.santec.jtimechooser.JTimeChooser RepToTimeTC;
    private javax.swing.JButton RepViewReportBtn;
    private javax.swing.JTree ReportTree;
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
    private javax.swing.JLabel jLabel169;
    private javax.swing.JLabel jLabel170;
    private javax.swing.JLabel jLabel172;
    private javax.swing.JLabel jLabel173;
    private javax.swing.JLabel jLabel174;
    private javax.swing.JLabel jLabel175;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane8;
    // End of variables declaration//GEN-END:variables
}
