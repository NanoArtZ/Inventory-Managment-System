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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Nano ArtZ
 */
public final class PaymentJF extends javax.swing.JFrame {

    /**
     * Creates new form PaymentJF
     */
    public PaymentJF() {
        initComponents();

        showDate();
        showTime();
        FullScreenMethod();
        ButtonBehaviourMethod();
        LoadCustomerNameOrIDToSalesPanel();

        PayChequeNoTF.setEditable(false);
        PayBankNameTF.setEditable(false);

    }
    //----- Payments Frame Methods Start ------//

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

    public void ButtonBehaviourMethod() {
        try {
            PPPaymentsBtn.setOpaque(false);
            PPPaymentsBtn.setContentAreaFilled(false);
            PPPaymentsBtn.setBorderPainted(false);

            PPExitBtn.setOpaque(false);
            PPExitBtn.setContentAreaFilled(false);
            PPExitBtn.setBorderPainted(false);

            PPMinimizeBtn.setOpaque(false);
            PPMinimizeBtn.setContentAreaFilled(false);
            PPMinimizeBtn.setBorderPainted(false);

            PPSalesBtn.setOpaque(false);
            PPSalesBtn.setContentAreaFilled(false);
            PPSalesBtn.setBorderPainted(false);

            PPFinishedItemsBtn.setOpaque(false);
            PPFinishedItemsBtn.setContentAreaFilled(false);
            PPFinishedItemsBtn.setBorderPainted(false);

            PPRawItemBtn.setOpaque(false);
            PPRawItemBtn.setContentAreaFilled(false);
            PPRawItemBtn.setBorderPainted(false);

            PPCustomersBtn.setOpaque(false);
            PPCustomersBtn.setContentAreaFilled(false);
            PPCustomersBtn.setBorderPainted(false);

            PPBranchersBtn.setOpaque(false);
            PPBranchersBtn.setContentAreaFilled(false);
            PPBranchersBtn.setBorderPainted(false);

            PPSupplierBtn.setOpaque(false);
            PPSupplierBtn.setContentAreaFilled(false);
            PPSupplierBtn.setBorderPainted(false);

            PPVehicleBtn.setOpaque(false);
            PPVehicleBtn.setContentAreaFilled(false);
            PPVehicleBtn.setBorderPainted(false);

            PPSettingsBtn.setOpaque(false);
            PPSettingsBtn.setContentAreaFilled(false);
            PPSettingsBtn.setBorderPainted(false);

            PPReportBtn.setOpaque(false);
            PPReportBtn.setContentAreaFilled(false);
            PPReportBtn.setBorderPainted(false);

            PPEmployeeBtn.setOpaque(false);
            PPEmployeeBtn.setContentAreaFilled(false);
            PPEmployeeBtn.setBorderPainted(false);

        } catch (Exception e) {
            Logger.getLogger(PaymentJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    //Auto Load Customer Name or NIC to Payments Panel Combo Box - Payments Panel Method Start
    public void LoadCustomerNameOrIDToSalesPanel() {
        try {
            InsSearchCustomerCombo.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {

                    if (e.getKeyCode() != KeyEvent.VK_ENTER && e.getKeyCode() != KeyEvent.VK_UP && e.getKeyCode() != KeyEvent.VK_DOWN && e.getKeyCode() != KeyEvent.VK_SHIFT) {

                        String TypedTxt = InsSearchCustomerCombo.getEditor().getItem().toString();

                        if (!TypedTxt.isEmpty()) {

                            try {
                                InsSearchCustomerCombo.removeAllItems();
                                int st = 0;

                                Statement s = (Statement) SeldoDB.GetMyConnection().createStatement();
                                ResultSet rs = s.executeQuery("SELECT NIC FROM customer WHERE NIC LIKE '%" + TypedTxt + "%' ");

                                Vector StoreCBData = new Vector();

                                while (rs.next()) {
                                    if (rs.getString("NIC").toLowerCase().contains(TypedTxt.toLowerCase())) {
                                        StoreCBData.add(rs.getString("NIC"));
                                        st++;
                                    }
                                }

                                rs = s.executeQuery("SELECT CusName FROM customer WHERE CusName LIKE '%" + TypedTxt + "%'");

                                while (rs.next()) {
                                    if (rs.getString("CusName").toLowerCase().contains(TypedTxt.toLowerCase())) {
                                        StoreCBData.add(rs.getString("CusName"));
                                        st++;
                                    }
                                }

                                rs.close();
                                s.close();

                                DefaultComboBoxModel dcm = new DefaultComboBoxModel(StoreCBData);
                                InsSearchCustomerCombo.setModel(dcm);

                                InsSearchCustomerCombo.getEditor().setItem(TypedTxt);
                                InsSearchCustomerCombo.setSelectedItem(TypedTxt);
                                JTextField TextField = (JTextField) e.getSource();
                                TextField.setCaretPosition(TextField.getDocument().getLength());

                                if (st != 0) {
                                    InsSearchCustomerCombo.showPopup();

                                    if (st > 10) {
                                        InsSearchCustomerCombo.setMaximumRowCount(10);
                                    } else {
                                        InsSearchCustomerCombo.setMaximumRowCount(st);
                                    }
                                } else {
                                    InsSearchCustomerCombo.hidePopup();
                                }

                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(null, ex);
                            }
                        } else {
                            InsSearchCustomerCombo.hidePopup();
                            InsSearchCustomerCombo.removeAllItems();
                        }
                    }
                }
            });
        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    //Auto Load Customer Name or NIC to Payments Panel Combo Box - Payments Panel Method END
    //Load Payments details To Table and other feilds - payments Panel Method Start
    public void LoadIinstalmentsDetailsToTable() {
        try {
            if (InsSearchCustomerCombo.getSelectedIndex() != -1) {
                String TypedText = InsSearchCustomerCombo.getSelectedItem().toString();
                Statement s1 = (Statement) SeldoDB.GetMyConnection().createStatement();
                ResultSet rs1 = s1.executeQuery("Select * From customer WHERE CusName = '" + TypedText + "' || NIC = '" + TypedText + "' ");

                if (rs1.next()) {      //Load Payments Details to Payments Details Table via Customer Name//

                    String CustomerID = rs1.getString("CusID");
                    INSCusIDTF.setText(CustomerID);
                    INSContactNoTF.setText(rs1.getString("ContactNo"));
                    INSAddressTA.setText(rs1.getString("Address"));

                    ResultSet rsCusNAmeOrID = s1.executeQuery("SELECT * From customer WHERE CusID = '" + CustomerID + "' ");
                    rsCusNAmeOrID.next();
                    if (TypedText.equals(rsCusNAmeOrID.getString("CusName"))) {
                        INSCusNameorNICNoTF.setText(rsCusNAmeOrID.getString("NIC"));
                        INSCusNameOrNIC_CB_Label.setText("Customer Name");
                        INSCusNameOrNIC_TF_Label.setText("N.I.C. No.");

                    } else if (TypedText.equals(rsCusNAmeOrID.getString("NIC"))) {
                        INSCusNameorNICNoTF.setText(rsCusNAmeOrID.getString("CusName"));
                        INSCusNameOrNIC_CB_Label.setText("N.I.C. No.");
                        INSCusNameOrNIC_TF_Label.setText("Customer Name");
                    }

                    ResultSet rs2 = s1.executeQuery("Select * from payment WHERE CusID = '" + CustomerID + "' ");
                    if (rs2.next()) {
                        INSSalesOrderNoTF.setText(rs2.getString("SONumber"));
                        INSTotalAmountTF.setText(rs2.getString("TotalAmount"));

                        ResultSet rs3 = s1.executeQuery("Select * from payment WHERE CusID = '" + CustomerID + "' ");

                        while (rs3.next()) {
                            Double TotalAmount = Double.valueOf(rs3.getString("TotalAmount"));
                            Double SumOfIns = Double.valueOf(rs3.getString("SumOfInstalment"));
                            Double DueBal = TotalAmount - SumOfIns;
                            
                            DecimalFormat df = new DecimalFormat("#.##");
                            DueBal = Double.valueOf(df.format(DueBal));
                            String DueBalString = String.valueOf(DueBal);

                            DefaultTableModel PaymentsDetailsTable = (DefaultTableModel) PFPaymentsDetailsTable.getModel();
                            Vector v1 = new Vector();

                            v1.add(rs3.getString("LineNo"));
                            v1.add(rs3.getString("DateTime"));
                            v1.add(rs3.getString("Instalment"));
                            v1.add(rs3.getString("SumOfInstalment"));
                            v1.add(DueBalString);
                            v1.add(rs3.getString("ChequeNo"));

                            PaymentsDetailsTable.addRow(v1);

                            INSSumOfInstalments.setText(rs3.getString("SumOfInstalment"));
                            INSDueBalanceTF.setText(DueBalString);

                        }

                        LoadItemDetailsToItemsTable();  //Load Items Details to Items table in UI.

                    } else {
                        JOptionPane.showMessageDialog(null, "This Customer has no Pending Payments");
                    }
                }
            } else {                          //Clear All Feilds if no Search results

                INSCusIDTF.setText(null);
                INSContactNoTF.setText(null);
                INSAddressTA.setText(null);
                INSSalesOrderNoTF.setText(null);
                INSDueBalanceTF.setText(null);
                INSTotalAmountTF.setText(null);
                INSSumOfInstalments.setText(null);
                INSCusNameorNICNoTF.setText(null);

                DefaultTableModel dtm = (DefaultTableModel) PFPaymentsDetailsTable.getModel();
                dtm.setRowCount(0);
            }
        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    //Load Paymments details To Table and other feilds - payments Panel Method END

    //Load Item Details to Items Table via Customer ID or Name - Payment panel method Start
    public void LoadItemDetailsToItemsTable() {
        try {
            DefaultTableModel dtm1 = (DefaultTableModel) InsItemDetailsTable.getModel();
            dtm1.setRowCount(0);
            if (InsSearchCustomerCombo.getSelectedIndex() != -1) {
                String TypedText = InsSearchCustomerCombo.getSelectedItem().toString();
                Statement s = (Statement) SeldoDB.GetMyConnection().createStatement();
                ResultSet rs1 = s.executeQuery("SELECT CusID FROM customer WHERE CusName = '" + TypedText + "' || NIC = '" + TypedText + "' ");
                rs1.next();
                String CusIDString = rs1.getString("CusID");

                ResultSet rs2 = s.executeQuery("SELECT MAX(SONumber) From sale WHERE customer_CusID = '" + CusIDString + "' ");
                rs2.next();
                String MaxSONumberString = rs2.getString("MAX(SONumber)");

                ResultSet rs3 = s.executeQuery("SELECT * FROM sale WHERE SONumber = '" + MaxSONumberString + "' ");

                while (rs3.next()) {
                    DefaultTableModel dtm = (DefaultTableModel) InsItemDetailsTable.getModel();
                    Vector v = new Vector();

                    v.add(rs3.getString("ItemName"));
                    v.add(rs3.getString("Amount"));

                    dtm.addRow(v);
                }
            } else {
                DefaultTableModel dtm = (DefaultTableModel) InsItemDetailsTable.getModel();
                dtm.setRowCount(0);
            }

        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    //Load Item Details to Items Table via Customer ID or Name - Payment panel method END

    //Add New Payment to Instalments Table - Mathod Start
    public void AddInstalmentsDetailstoTable() {
        try {
            String DateAndTime = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(Calendar.getInstance().getTime());
            if (InsInstalmentsTF.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "please add instalment amount");
            } else {

                String InstalmentString = InsInstalmentsTF.getText();
                String ChequeNo = PayChequeNoTF.getText();
                DefaultTableModel dtm = (DefaultTableModel) PFPaymentsDetailsTable.getModel();

                Vector v = new Vector();
                int LineNo = 1;
                int Rawcount = dtm.getRowCount();

                if (Rawcount != 0) {                //Create Next Raw Number//
                    LineNo = Rawcount + 1;
                }

                v.add(LineNo);
                v.add(DateAndTime);
                v.add(InstalmentString);

                int RC = Rawcount - 1;      //Get Last Line / Above Line Raw Number to integer//

                String LastInstalmentS = PFPaymentsDetailsTable.getValueAt(RC, 3).toString();        //get Last Line /Above Line instalment SUM to String//
                double LastInstalmentI = Double.parseDouble(LastInstalmentS);                    //Convert Last Line /Above Line instalment to Integer//

                String NewInstalmentS = InstalmentString;                     //get New Instalment to String//
                double NewInstalmentI = Double.parseDouble(NewInstalmentS);                        //Convert New Instalment to Integer//

                double Sum = LastInstalmentI + NewInstalmentI;                                    //SUM of Above Line Instalment and New Instalment//
                v.add(Sum);

                String LastDueBalance = PFPaymentsDetailsTable.getValueAt(RC, 4).toString();        //Update Latest Due balance//
                double LastDueBalInt = Double.parseDouble(LastDueBalance);
                double NewDuebal = LastDueBalInt - NewInstalmentI;

                v.add(NewDuebal);
                v.add(ChequeNo);

                dtm.addRow(v);
                
                INSDueBalanceTF.setText(String.valueOf(NewDuebal));

            }

        } catch (Exception e) {
            Logger.getLogger(PaymentJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    //Add New Payment to Instalments Table - Mathod END

    //Save Instalments Details to Instalments Table in data Base - Method Start//
    private void SaveInstalmentsToDB() {
        try {

            String CustomerID = INSCusIDTF.getText();
            Statement s = (Statement) SeldoDB.GetMyConnection().createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM payment WHERE CusID = '" + CustomerID + "' ");

            if (rs.next()) {
                DefaultTableModel DTM = (DefaultTableModel) PFPaymentsDetailsTable.getModel();
                int RawCount = DTM.getRowCount();
                int RC = RawCount - 1;

                String LineNoT = DTM.getValueAt(RC, 0).toString();
                String DateAndTime = DTM.getValueAt(RC, 1).toString();
                String Instalments = DTM.getValueAt(RC, 2).toString();
                String SUMOfIns = DTM.getValueAt(RC, 3).toString();

                if (!"1".equals(LineNoT)) {
                    s.executeUpdate("INSERT into payment (LineNo , DateTime , CusID , SONumber, NICNo, TotalAmount, Instalment, SumOfInstalment, ChequeNo)"
                            + "VALUES ('" + LineNoT + "' , '" + DateAndTime + "' , '" + INSCusIDTF.getText() + "' , '" + INSSalesOrderNoTF.getText() + "',  '" + "" + "', '" + INSTotalAmountTF.getText() + "', '" + Instalments + "' , '" + SUMOfIns + "' , '" + PayChequeNoTF.getText() + "' )");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Instalment Already Added");
//            Logger.getLogger(PaymentJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    //Save Instalments Details to Instalments Table in data Base - Method END//
    // Save Cheque Details to cheque table in Database - Method Start
    public void SaveChequeDetails() {
        try {
            if (PayChequeRadioBtn.isSelected()) {
                String ChequeNo = PayChequeNoTF.getText();
                String Bank = PayBankNameTF.getText();
                String CusID = INSCusIDTF.getText();
                SimpleDateFormat sdf = new SimpleDateFormat("EEEEE / dd / MMMMM / yyyy");
                String selectedDate = sdf.format(PayChequeDateDC.getDate());

                Statement s = (Statement) SeldoDB.GetMyConnection().createStatement();
                s.executeUpdate("INSERT into cheque (ChequeNo , Bank, Date , customer_CusID) Values ('" + ChequeNo + "' , '" + Bank + "' , '" + selectedDate + "' , '" + CusID + "' ) ");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "This Cheque number is already used !!!");
            Logger.getLogger(PaymentJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    // Save Cheque Details to cheque table in Database - Method End.
    // Delete Paymnets completed customer from payment table and save them to paymnet completed table. Method Start//
    public void DeleteZeroCustomers() {
        try {
            Statement st = (Statement) SeldoDB.GetMyConnection().createStatement();
            Double DueBalance = Double.valueOf(INSDueBalanceTF.getText());

            if (DueBalance <= 0.00) {
                //Save Data to Payment completed tabel
                for (int i = 0; i < PFPaymentsDetailsTable.getRowCount(); i++) {
                    Integer Lineno = Integer.valueOf(PFPaymentsDetailsTable.getValueAt(i, 0).toString());
                    String DateTime = PFPaymentsDetailsTable.getValueAt(i, 1).toString();
                    Double Instalment = Double.valueOf(PFPaymentsDetailsTable.getValueAt(i, 2).toString());
                    String CusID = INSCusIDTF.getText();
                    String SoNumber = INSSalesOrderNoTF.getText();
                    Double TotalAmount = Double.valueOf(INSTotalAmountTF.getText());
                    Double SumOFIns = Double.valueOf(PFPaymentsDetailsTable.getValueAt(i, 3).toString());
                    String ChequeNo = PFPaymentsDetailsTable.getValueAt(i, 5).toString();

                    st.executeUpdate("INSERT into completedpayment (LineNo , DateTime , CusID , SONumber , NICNo , TotalAmount , Instalment , SumOfInstalment , ChequeNo) "
                            + " Values ('" + Lineno + "' , '" + DateTime + "' , '" + CusID + "' , '" + SoNumber + "' , '" + "" + "' , '" + TotalAmount + "' , '" + Instalment + "' , '" + SumOFIns + "' , '" + ChequeNo + "') ");

                }
                st.executeUpdate("Delete from payment where CusID = '" + INSCusIDTF.getText() + "' ");
            }
        } catch (Exception e) {
            Logger.getLogger(PaymentJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    // Delete Paymnets completed customer from payment table and save them to paymnet completed table. Method END//
    //Block Cheque Numbers which already in database Mathod Start.
    public void ValidationANDAddData() {
        try {
            Statement st = (Statement) SeldoDB.GetMyConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT * from cheque where ChequeNO = '" + PayChequeNoTF.getText() + "' ");
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "This Cheque is already added !!!");
            } else {
                AddInstalmentsDetailstoTable();
                AddInstalmentsBtn.setEnabled(false);
                PPRemoveLastRawBtn.setEnabled(true);
            }
        } catch (Exception e) {
            Logger.getLogger(PaymentJF.class.getName()).log(Level.SEVERE, null, e);
        }

    }
    //Block Cheque Numbers which already in database Method END.

    //Print Instalment Details Report. Method Start.
    public void PrintInstalmentDetails() {

        try {
            String ReportSource = "C:\\SELDO\\Reports_V_01\\SeldoReports\\Payments_V_1.jrxml";
            Map<String, Object> params = new HashMap<>();

            params.put("SONumberPara", INSSalesOrderNoTF.getText());
            params.put("CusIDPara", INSCusIDTF.getText());
            params.put("DueBalPara", INSDueBalanceTF.getText());

            if (PayChequeRadioBtn.isSelected()) {
                params.put("ChequeNoPara", PayChequeNoTF.getText());
                params.put("CBank", PayBankNameTF.getText());
                
                String pattern  = "MMMM-dd-yyyy";
                DateFormat formatter = new SimpleDateFormat(pattern);
                params.put("CDatePara", formatter.format(PayChequeDateDC.getDate()));
                
               // System.out.println(formatter.format(PayChequeDateDC.getDate()));

            } else {
                params.put("ChequeNoPara", "-");
                params.put("CBankPara", "-");
                params.put("CDatePara", "-");
            }

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

    //Print Instalment Details Report. Method END.
    //-----Payments Frame Methods END------//
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PaymentMainPanel = new javax.swing.JPanel();
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
        TopicPanel = new javax.swing.JPanel();
        PPArrowLbl = new javax.swing.JLabel();
        PPSalesBtn = new javax.swing.JButton();
        PPFinishedItemsBtn = new javax.swing.JButton();
        PPRawItemBtn = new javax.swing.JButton();
        PPCustomersBtn = new javax.swing.JButton();
        PPEmployeeBtn = new javax.swing.JButton();
        PPSupplierBtn = new javax.swing.JButton();
        PPVehicleBtn = new javax.swing.JButton();
        PPSettingsBtn = new javax.swing.JButton();
        PPPaymentsBtn = new javax.swing.JButton();
        PPReportBtn = new javax.swing.JButton();
        PPBranchersBtn = new javax.swing.JButton();
        SPChequesBtn = new javax.swing.JButton();
        SPExpensesBtn = new javax.swing.JButton();
        InstalmentsPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        INSDueBalanceTF = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        INSTotalAmountTF = new javax.swing.JTextField();
        INSSumOfInstalments = new javax.swing.JTextField();
        jScrollPane9 = new javax.swing.JScrollPane();
        InsItemDetailsTable = new javax.swing.JTable();
        InsSearchCustomerCombo = new javax.swing.JComboBox<>();
        INSCusNameOrNIC_TF_Label = new javax.swing.JLabel();
        INSCusNameorNICNoTF = new javax.swing.JTextField();
        INSCusNameOrNIC_CB_Label = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        INSCusIDTF = new javax.swing.JTextField();
        jScrollPane10 = new javax.swing.JScrollPane();
        PFPaymentsDetailsTable = new javax.swing.JTable();
        InsInstalmentsTF = new javax.swing.JTextField();
        AddInstalmentsBtn = new javax.swing.JButton();
        PFConfirmBtn = new javax.swing.JButton();
        PPRemoveLastRawBtn = new javax.swing.JButton();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        INSSalesOrderNoTF = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        INSContactNoTF = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        INSAddressTA = new javax.swing.JTextArea();
        jLabel82 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        PaymentChequeDetailsPnl = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        PayChequeNoTF = new javax.swing.JTextField();
        PayBankNameTF = new javax.swing.JTextField();
        PayChequeDateDC = new com.toedter.calendar.JDateChooser();
        PayChequeRadioBtn = new javax.swing.JRadioButton();
        PPMainBGLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        PaymentMainPanel.setPreferredSize(new java.awt.Dimension(1366, 768));
        PaymentMainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        PaymentMainPanel.add(TopPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 60));

        TopicPanel.setBackground(new java.awt.Color(102, 102, 102));
        TopicPanel.setOpaque(false);
        TopicPanel.setPreferredSize(new java.awt.Dimension(230, 710));
        TopicPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PPArrowLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/ArrowSingleBlue.png"))); // NOI18N
        TopicPanel.add(PPArrowLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, -1, -1));

        PPSalesBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/SalesLableIMG01.png"))); // NOI18N
        PPSalesBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/SalesLableIMG02.png"))); // NOI18N
        PPSalesBtn.setBorderPainted(false);
        PPSalesBtn.setContentAreaFilled(false);
        PPSalesBtn.setMaximumSize(new java.awt.Dimension(150, 40));
        PPSalesBtn.setMinimumSize(new java.awt.Dimension(150, 40));
        PPSalesBtn.setName(""); // NOI18N
        PPSalesBtn.setPreferredSize(new java.awt.Dimension(150, 40));
        PPSalesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PPSalesBtnActionPerformed(evt);
            }
        });
        TopicPanel.add(PPSalesBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 200, -1));

        PPFinishedItemsBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/FinishedItemsLableIMG01.png"))); // NOI18N
        PPFinishedItemsBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/FinishedItemsLableIMG02.png"))); // NOI18N
        PPFinishedItemsBtn.setBorderPainted(false);
        PPFinishedItemsBtn.setContentAreaFilled(false);
        PPFinishedItemsBtn.setMaximumSize(new java.awt.Dimension(200, 40));
        PPFinishedItemsBtn.setMinimumSize(new java.awt.Dimension(200, 40));
        PPFinishedItemsBtn.setName(""); // NOI18N
        PPFinishedItemsBtn.setPreferredSize(new java.awt.Dimension(200, 40));
        PPFinishedItemsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PPFinishedItemsBtnActionPerformed(evt);
            }
        });
        TopicPanel.add(PPFinishedItemsBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, -1, -1));

        PPRawItemBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/RawItemsLableIMG01.png"))); // NOI18N
        PPRawItemBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/RawItemsLableIMG02.png"))); // NOI18N
        PPRawItemBtn.setBorderPainted(false);
        PPRawItemBtn.setContentAreaFilled(false);
        PPRawItemBtn.setMaximumSize(new java.awt.Dimension(200, 40));
        PPRawItemBtn.setMinimumSize(new java.awt.Dimension(200, 40));
        PPRawItemBtn.setName(""); // NOI18N
        PPRawItemBtn.setPreferredSize(new java.awt.Dimension(200, 40));
        PPRawItemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PPRawItemBtnActionPerformed(evt);
            }
        });
        TopicPanel.add(PPRawItemBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, -1, -1));

        PPCustomersBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/CustomersLableIMG01.png"))); // NOI18N
        PPCustomersBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/CustomersLableIMG02.png"))); // NOI18N
        PPCustomersBtn.setBorderPainted(false);
        PPCustomersBtn.setContentAreaFilled(false);
        PPCustomersBtn.setMaximumSize(new java.awt.Dimension(200, 40));
        PPCustomersBtn.setMinimumSize(new java.awt.Dimension(200, 40));
        PPCustomersBtn.setName(""); // NOI18N
        PPCustomersBtn.setPreferredSize(new java.awt.Dimension(200, 40));
        PPCustomersBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PPCustomersBtnActionPerformed(evt);
            }
        });
        TopicPanel.add(PPCustomersBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, -1, -1));

        PPEmployeeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/EmployeesLableIMG01.png"))); // NOI18N
        PPEmployeeBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/EmployeesLableIMG02.png"))); // NOI18N
        PPEmployeeBtn.setBorderPainted(false);
        PPEmployeeBtn.setContentAreaFilled(false);
        PPEmployeeBtn.setMaximumSize(new java.awt.Dimension(200, 40));
        PPEmployeeBtn.setMinimumSize(new java.awt.Dimension(200, 40));
        PPEmployeeBtn.setName(""); // NOI18N
        PPEmployeeBtn.setPreferredSize(new java.awt.Dimension(200, 40));
        PPEmployeeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PPEmployeeBtnActionPerformed(evt);
            }
        });
        TopicPanel.add(PPEmployeeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 200, -1));

        PPSupplierBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/SupplierLableIMG01.png"))); // NOI18N
        PPSupplierBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/SupplierLableIMG02.png"))); // NOI18N
        PPSupplierBtn.setBorderPainted(false);
        PPSupplierBtn.setContentAreaFilled(false);
        PPSupplierBtn.setMaximumSize(new java.awt.Dimension(200, 40));
        PPSupplierBtn.setMinimumSize(new java.awt.Dimension(200, 40));
        PPSupplierBtn.setName(""); // NOI18N
        PPSupplierBtn.setPreferredSize(new java.awt.Dimension(200, 40));
        PPSupplierBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PPSupplierBtnActionPerformed(evt);
            }
        });
        TopicPanel.add(PPSupplierBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, -1, -1));

        PPVehicleBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/VehiclesLableIMG01.png"))); // NOI18N
        PPVehicleBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/VehiclesLableIMG02.png"))); // NOI18N
        PPVehicleBtn.setBorderPainted(false);
        PPVehicleBtn.setContentAreaFilled(false);
        PPVehicleBtn.setMaximumSize(new java.awt.Dimension(200, 40));
        PPVehicleBtn.setMinimumSize(new java.awt.Dimension(200, 40));
        PPVehicleBtn.setName(""); // NOI18N
        PPVehicleBtn.setPreferredSize(new java.awt.Dimension(200, 40));
        PPVehicleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PPVehicleBtnActionPerformed(evt);
            }
        });
        TopicPanel.add(PPVehicleBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, -1, -1));

        PPSettingsBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/SettingsLableIMG01.png"))); // NOI18N
        PPSettingsBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/SettingsLableIMG02.png"))); // NOI18N
        PPSettingsBtn.setBorderPainted(false);
        PPSettingsBtn.setContentAreaFilled(false);
        PPSettingsBtn.setMaximumSize(new java.awt.Dimension(200, 40));
        PPSettingsBtn.setMinimumSize(new java.awt.Dimension(200, 40));
        PPSettingsBtn.setName(""); // NOI18N
        PPSettingsBtn.setPreferredSize(new java.awt.Dimension(200, 40));
        PPSettingsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PPSettingsBtnActionPerformed(evt);
            }
        });
        TopicPanel.add(PPSettingsBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 620, 200, -1));

        PPPaymentsBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/PaymentsLableIMG01.png"))); // NOI18N
        PPPaymentsBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/PaymentsLableIMG02.png"))); // NOI18N
        PPPaymentsBtn.setBorderPainted(false);
        PPPaymentsBtn.setContentAreaFilled(false);
        PPPaymentsBtn.setMaximumSize(new java.awt.Dimension(200, 40));
        PPPaymentsBtn.setMinimumSize(new java.awt.Dimension(200, 40));
        PPPaymentsBtn.setName(""); // NOI18N
        PPPaymentsBtn.setPreferredSize(new java.awt.Dimension(200, 40));
        PPPaymentsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PPPaymentsBtnActionPerformed(evt);
            }
        });
        TopicPanel.add(PPPaymentsBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, -1, -1));

        PPReportBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/ReportLableIMG01.png"))); // NOI18N
        PPReportBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/ReportLableIMG02.png"))); // NOI18N
        PPReportBtn.setBorderPainted(false);
        PPReportBtn.setContentAreaFilled(false);
        PPReportBtn.setMaximumSize(new java.awt.Dimension(200, 40));
        PPReportBtn.setMinimumSize(new java.awt.Dimension(200, 40));
        PPReportBtn.setName(""); // NOI18N
        PPReportBtn.setPreferredSize(new java.awt.Dimension(200, 40));
        PPReportBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PPReportBtnActionPerformed(evt);
            }
        });
        TopicPanel.add(PPReportBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, -1, -1));

        PPBranchersBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/BranchesLableIMG01.png"))); // NOI18N
        PPBranchersBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/BranchesLableIMG02.png"))); // NOI18N
        PPBranchersBtn.setBorderPainted(false);
        PPBranchersBtn.setContentAreaFilled(false);
        PPBranchersBtn.setMaximumSize(new java.awt.Dimension(200, 40));
        PPBranchersBtn.setMinimumSize(new java.awt.Dimension(200, 40));
        PPBranchersBtn.setName(""); // NOI18N
        PPBranchersBtn.setPreferredSize(new java.awt.Dimension(200, 40));
        PPBranchersBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PPBranchersBtnActionPerformed(evt);
            }
        });
        TopicPanel.add(PPBranchersBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, -1, -1));

        SPChequesBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/ChequeLableIMG01.png"))); // NOI18N
        SPChequesBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/ChequeLableIMG02.png"))); // NOI18N
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
        TopicPanel.add(SPChequesBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 470, -1, -1));

        SPExpensesBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/ExpencesIMG1.png"))); // NOI18N
        SPExpensesBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/ExpencesIMG2.png"))); // NOI18N
        SPExpensesBtn.setBorderPainted(false);
        SPExpensesBtn.setContentAreaFilled(false);
        SPExpensesBtn.setMaximumSize(new java.awt.Dimension(200, 40));
        SPExpensesBtn.setMinimumSize(new java.awt.Dimension(200, 40));
        SPExpensesBtn.setName(""); // NOI18N
        SPExpensesBtn.setPreferredSize(new java.awt.Dimension(200, 40));
        SPExpensesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SPExpensesBtnActionPerformed(evt);
            }
        });
        TopicPanel.add(SPExpensesBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 570, 200, -1));

        PaymentMainPanel.add(TopicPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 230, 710));

        InstalmentsPanel.setMaximumSize(new java.awt.Dimension(1350, 660));
        InstalmentsPanel.setMinimumSize(new java.awt.Dimension(1350, 660));
        InstalmentsPanel.setOpaque(false);
        InstalmentsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Total Amount");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        INSDueBalanceTF.setEditable(false);
        INSDueBalanceTF.setBackground(new java.awt.Color(51, 51, 51));
        INSDueBalanceTF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        INSDueBalanceTF.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(INSDueBalanceTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 170, -1));

        jLabel52.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setText("Total Payments");
        jPanel1.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel55.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText("Due Balance");
        jPanel1.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        INSTotalAmountTF.setEditable(false);
        INSTotalAmountTF.setBackground(new java.awt.Color(51, 51, 51));
        INSTotalAmountTF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        INSTotalAmountTF.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(INSTotalAmountTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 170, -1));

        INSSumOfInstalments.setEditable(false);
        INSSumOfInstalments.setBackground(new java.awt.Color(51, 51, 51));
        INSSumOfInstalments.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        INSSumOfInstalments.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(INSSumOfInstalments, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 170, -1));

        InstalmentsPanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 350, 120));

        InsItemDetailsTable.setBackground(new java.awt.Color(0, 102, 153));
        InsItemDetailsTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        InsItemDetailsTable.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        InsItemDetailsTable.setForeground(new java.awt.Color(255, 255, 255));
        InsItemDetailsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Name", "Total Amount of Item"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        InsItemDetailsTable.setFillsViewportHeight(true);
        jScrollPane9.setViewportView(InsItemDetailsTable);
        if (InsItemDetailsTable.getColumnModel().getColumnCount() > 0) {
            InsItemDetailsTable.getColumnModel().getColumn(1).setMinWidth(100);
            InsItemDetailsTable.getColumnModel().getColumn(1).setPreferredWidth(180);
            InsItemDetailsTable.getColumnModel().getColumn(1).setMaxWidth(200);
        }

        InstalmentsPanel.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 430, 470, 270));

        InsSearchCustomerCombo.setEditable(true);
        InsSearchCustomerCombo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        InsSearchCustomerCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Please Enter Customer Name or NIC No" }));
        InsSearchCustomerCombo.setMaximumSize(new java.awt.Dimension(300, 25));
        InsSearchCustomerCombo.setMinimumSize(new java.awt.Dimension(300, 25));
        InsSearchCustomerCombo.setPreferredSize(new java.awt.Dimension(300, 25));
        InsSearchCustomerCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsSearchCustomerComboActionPerformed(evt);
            }
        });
        InstalmentsPanel.add(InsSearchCustomerCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 280, -1));

        INSCusNameOrNIC_TF_Label.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        INSCusNameOrNIC_TF_Label.setForeground(new java.awt.Color(255, 255, 255));
        INSCusNameOrNIC_TF_Label.setText("Name / NIC No.");
        InstalmentsPanel.add(INSCusNameOrNIC_TF_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        INSCusNameorNICNoTF.setEditable(false);
        INSCusNameorNICNoTF.setBackground(new java.awt.Color(51, 51, 51));
        INSCusNameorNICNoTF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        INSCusNameorNICNoTF.setForeground(new java.awt.Color(255, 255, 255));
        INSCusNameorNICNoTF.setMinimumSize(new java.awt.Dimension(280, 28));
        INSCusNameorNICNoTF.setPreferredSize(new java.awt.Dimension(280, 28));
        InstalmentsPanel.add(INSCusNameorNICNoTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, -1, 30));

        INSCusNameOrNIC_CB_Label.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        INSCusNameOrNIC_CB_Label.setForeground(new java.awt.Color(255, 255, 255));
        INSCusNameOrNIC_CB_Label.setText("Name / NIC No.");
        InstalmentsPanel.add(INSCusNameOrNIC_CB_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel45.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("Customer ID");
        InstalmentsPanel.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, -1, -1));

        INSCusIDTF.setEditable(false);
        INSCusIDTF.setBackground(new java.awt.Color(51, 51, 51));
        INSCusIDTF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        INSCusIDTF.setForeground(new java.awt.Color(255, 255, 255));
        InstalmentsPanel.add(INSCusIDTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 60, 170, -1));

        PFPaymentsDetailsTable.setBackground(new java.awt.Color(51, 51, 51));
        PFPaymentsDetailsTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PFPaymentsDetailsTable.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        PFPaymentsDetailsTable.setForeground(new java.awt.Color(255, 255, 255));
        PFPaymentsDetailsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Date & Time", "Instalments", "SUM of Instalments", "Due Balance", "Cheque No."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        PFPaymentsDetailsTable.setFillsViewportHeight(true);
        jScrollPane10.setViewportView(PFPaymentsDetailsTable);
        if (PFPaymentsDetailsTable.getColumnModel().getColumnCount() > 0) {
            PFPaymentsDetailsTable.getColumnModel().getColumn(0).setMinWidth(50);
            PFPaymentsDetailsTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            PFPaymentsDetailsTable.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        InstalmentsPanel.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 640, 270));

        InsInstalmentsTF.setBackground(new java.awt.Color(51, 51, 51));
        InsInstalmentsTF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        InsInstalmentsTF.setForeground(new java.awt.Color(255, 204, 102));
        InsInstalmentsTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                InsInstalmentsTFKeyTyped(evt);
            }
        });
        InstalmentsPanel.add(InsInstalmentsTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 170, -1));

        AddInstalmentsBtn.setBackground(new java.awt.Color(51, 51, 51));
        AddInstalmentsBtn.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        AddInstalmentsBtn.setForeground(new java.awt.Color(255, 255, 255));
        AddInstalmentsBtn.setText("Add Instalment");
        AddInstalmentsBtn.setMaximumSize(new java.awt.Dimension(141, 33));
        AddInstalmentsBtn.setMinimumSize(new java.awt.Dimension(141, 33));
        AddInstalmentsBtn.setPreferredSize(new java.awt.Dimension(141, 33));
        AddInstalmentsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddInstalmentsBtnActionPerformed(evt);
            }
        });
        InstalmentsPanel.add(AddInstalmentsBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 190, 40));

        PFConfirmBtn.setBackground(new java.awt.Color(51, 51, 51));
        PFConfirmBtn.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        PFConfirmBtn.setForeground(new java.awt.Color(255, 255, 255));
        PFConfirmBtn.setText("Confirm & Save");
        PFConfirmBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PFConfirmBtnActionPerformed(evt);
            }
        });
        InstalmentsPanel.add(PFConfirmBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 350, 190, 40));

        PPRemoveLastRawBtn.setBackground(new java.awt.Color(51, 51, 51));
        PPRemoveLastRawBtn.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        PPRemoveLastRawBtn.setForeground(new java.awt.Color(255, 255, 255));
        PPRemoveLastRawBtn.setText("Remove Unsaved Raw");
        PPRemoveLastRawBtn.setEnabled(false);
        PPRemoveLastRawBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PPRemoveLastRawBtnActionPerformed(evt);
            }
        });
        InstalmentsPanel.add(PPRemoveLastRawBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 350, 190, 40));

        jLabel48.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 16)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("Items Details");
        InstalmentsPanel.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 400, -1, -1));

        jLabel49.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("Sales Order Number");
        InstalmentsPanel.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 100, -1, -1));

        INSSalesOrderNoTF.setEditable(false);
        INSSalesOrderNoTF.setBackground(new java.awt.Color(51, 51, 51));
        INSSalesOrderNoTF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        INSSalesOrderNoTF.setForeground(new java.awt.Color(255, 255, 255));
        InstalmentsPanel.add(INSSalesOrderNoTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 100, 170, -1));

        jLabel50.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("Contact Number");
        InstalmentsPanel.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 60, -1, -1));

        INSContactNoTF.setEditable(false);
        INSContactNoTF.setBackground(new java.awt.Color(51, 51, 51));
        INSContactNoTF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        INSContactNoTF.setForeground(new java.awt.Color(255, 255, 255));
        InstalmentsPanel.add(INSContactNoTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 60, 180, -1));

        jLabel51.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setText("Address");
        InstalmentsPanel.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 100, -1, -1));

        INSAddressTA.setEditable(false);
        INSAddressTA.setBackground(new java.awt.Color(51, 51, 51));
        INSAddressTA.setColumns(20);
        INSAddressTA.setForeground(new java.awt.Color(255, 255, 255));
        INSAddressTA.setRows(5);
        jScrollPane5.setViewportView(INSAddressTA);

        InstalmentsPanel.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 100, 180, -1));

        jLabel82.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 16)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(255, 255, 255));
        jLabel82.setText("Instalments Details");
        InstalmentsPanel.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semilight", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Payments Details");
        InstalmentsPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 210, 40));

        jLabel47.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("Instalment");
        InstalmentsPanel.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 100, -1));

        PaymentChequeDetailsPnl.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Cheque Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("MS Reference Sans Serif", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        PaymentChequeDetailsPnl.setOpaque(false);
        PaymentChequeDetailsPnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Date of Cheque");
        PaymentChequeDetailsPnl.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, 40));

        jLabel18.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Cheque Number");
        PaymentChequeDetailsPnl.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 30));

        jLabel19.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Bank");
        PaymentChequeDetailsPnl.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, 40));

        PayChequeNoTF.setBackground(new java.awt.Color(51, 51, 51));
        PayChequeNoTF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        PayChequeNoTF.setForeground(new java.awt.Color(255, 255, 255));
        PaymentChequeDetailsPnl.add(PayChequeNoTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 170, -1));

        PayBankNameTF.setBackground(new java.awt.Color(51, 51, 51));
        PayBankNameTF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        PayBankNameTF.setForeground(new java.awt.Color(255, 255, 255));
        PayBankNameTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PayBankNameTFActionPerformed(evt);
            }
        });
        PaymentChequeDetailsPnl.add(PayBankNameTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 170, -1));

        PayChequeDateDC.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        PaymentChequeDetailsPnl.add(PayChequeDateDC, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 170, -1));

        InstalmentsPanel.add(PaymentChequeDetailsPnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, 360, 150));

        PayChequeRadioBtn.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        PayChequeRadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        PayChequeRadioBtn.setText("If Cheque");
        PayChequeRadioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PayChequeRadioBtnActionPerformed(evt);
            }
        });
        InstalmentsPanel.add(PayChequeRadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, 100, 30));

        PaymentMainPanel.add(InstalmentsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 1140, 710));

        PPMainBGLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Background/MainPanelBGIMG.jpg"))); // NOI18N
        PaymentMainPanel.add(PPMainBGLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PaymentMainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PaymentMainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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

    private void PPSalesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PPSalesBtnActionPerformed
        try {
            SalesJF NewSalesJF = new SalesJF();
            NewSalesJF.setVisible(true);
            this.dispose();

        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_PPSalesBtnActionPerformed

    private void PPFinishedItemsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PPFinishedItemsBtnActionPerformed
        FinishedItemsJF NewFinishedItemsJF = new FinishedItemsJF();
        NewFinishedItemsJF.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_PPFinishedItemsBtnActionPerformed

    private void PPPaymentsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PPPaymentsBtnActionPerformed
        try {

        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_PPPaymentsBtnActionPerformed

    private void PPRawItemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PPRawItemBtnActionPerformed
        try {
            RawItemsJF NewRawItemsJF = new RawItemsJF();
            NewRawItemsJF.setVisible(true);
            this.dispose();
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_PPRawItemBtnActionPerformed

    private void PPCustomersBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PPCustomersBtnActionPerformed
        try {
            CustomerJF NewCustomerJF = new CustomerJF();
            NewCustomerJF.setVisible(true);
            this.dispose();
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_PPCustomersBtnActionPerformed

    private void PPEmployeeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PPEmployeeBtnActionPerformed
        try {
            EmployeeJF NewempEmployeeJF = new EmployeeJF();
            NewempEmployeeJF.setVisible(true);
            this.dispose();
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_PPEmployeeBtnActionPerformed

    private void PPSupplierBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PPSupplierBtnActionPerformed
        try {
            SupplierJF NewSupplierJF = new SupplierJF();
            NewSupplierJF.setVisible(true);
            this.dispose();
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_PPSupplierBtnActionPerformed

    private void PPVehicleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PPVehicleBtnActionPerformed
        try {
            VehicleJF NewVehicleJF = new VehicleJF();
            NewVehicleJF.setVisible(true);
            this.dispose();
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_PPVehicleBtnActionPerformed

    private void PPReportBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PPReportBtnActionPerformed
        try {
            ReportsJF NewReportsJF = new ReportsJF();
            NewReportsJF.setVisible(true);
            this.dispose();
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_PPReportBtnActionPerformed

    private void PPBranchersBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PPBranchersBtnActionPerformed
        try {
            BranchJF NewBranchJF = new BranchJF();
            NewBranchJF.setVisible(true);
            this.dispose();
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_PPBranchersBtnActionPerformed

    private void PPSettingsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PPSettingsBtnActionPerformed
        try {
            SettingJF NewSettingJF = new SettingJF();
            NewSettingJF.setVisible(true);
            this.dispose();
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_PPSettingsBtnActionPerformed

    private void InsSearchCustomerComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsSearchCustomerComboActionPerformed
        LoadIinstalmentsDetailsToTable();   //Load Iinstalments and Item details to tables in UI
        if (InsSearchCustomerCombo.getSelectedIndex() == -1) {
            DefaultTableModel dtm = (DefaultTableModel) InsItemDetailsTable.getModel();
            dtm.setRowCount(0);
        }
    }//GEN-LAST:event_InsSearchCustomerComboActionPerformed

    private void AddInstalmentsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddInstalmentsBtnActionPerformed
        ValidationANDAddData();     //check cheque no is used or not and add instalments details to instalments table in UI

    }//GEN-LAST:event_AddInstalmentsBtnActionPerformed

    private void PFConfirmBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PFConfirmBtnActionPerformed
        SaveInstalmentsToDB();
        SaveChequeDetails();
        PrintInstalmentDetails();
        DeleteZeroCustomers();  //Delete Zero Payments from payments table and save them to payments completed Table in DB

        
        AddInstalmentsBtn.setEnabled(true);
        //JOptionPane.showMessageDialog(null, "Instalments Details Successfully added !!!");
        //        SaveZeroCustomers();        //Save Zero Pending Paymetns customers to payments complete table (After above Delete process) //

        DefaultTableModel dtm1 = (DefaultTableModel) PFPaymentsDetailsTable.getModel();
        dtm1.setRowCount(0);
        DefaultTableModel dtm2 = (DefaultTableModel) InsItemDetailsTable.getModel();
        dtm2.setRowCount(0);
        LoadIinstalmentsDetailsToTable();
        LoadItemDetailsToItemsTable();

        DeleteZeroCustomers();      //Delete Zero Pending Payments Customers (After that , save their details to Payments complete table)//
    }//GEN-LAST:event_PFConfirmBtnActionPerformed

    private void InsInstalmentsTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_InsInstalmentsTFKeyTyped
        // Method For only Accept Numbers in Text Feild
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE || c == KeyEvent.VK_PERIOD)) {
            getToolkit().beep();
            evt.consume();
        }

    }//GEN-LAST:event_InsInstalmentsTFKeyTyped

    private void PayChequeRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PayChequeRadioBtnActionPerformed
        try {

            if (PayChequeRadioBtn.isSelected()) {
                PayChequeNoTF.setEditable(true);
                PayBankNameTF.setEditable(true);

                PaymentChequeDetailsPnl.setForeground(Color.red);

            } else {
                PayChequeNoTF.setEditable(false);
                PayBankNameTF.setEditable(false);

                PayChequeNoTF.setText(null);
                PayBankNameTF.setText(null);
                PayChequeDateDC.setDate(null);

            }
        } catch (Exception e) {
            Logger.getLogger(PaymentJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_PayChequeRadioBtnActionPerformed

    private void PayBankNameTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PayBankNameTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PayBankNameTFActionPerformed

    private void SPChequesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPChequesBtnActionPerformed
        try {
            ChequeDetailsJF newChequeDetailsJF = new ChequeDetailsJF();
            newChequeDetailsJF.setVisible(true);
            this.setVisible(false);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_SPChequesBtnActionPerformed

    private void SPExpensesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPExpensesBtnActionPerformed
        try {
            ExpencesJF newExpencesJF = new ExpencesJF();
            newExpencesJF.setVisible(true);
            this.setVisible(false);
        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null,e);
        }
    }//GEN-LAST:event_SPExpensesBtnActionPerformed

    private void PPRemoveLastRawBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PPRemoveLastRawBtnActionPerformed
        try {
            //RE Load Iinstalments and Item details to tables in UI
            DefaultTableModel dtm = (DefaultTableModel) PFPaymentsDetailsTable.getModel();
            dtm.setRowCount(0);
             LoadIinstalmentsDetailsToTable();   
             AddInstalmentsBtn.setEnabled(true);
        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null,e);
        }
    }//GEN-LAST:event_PPRemoveLastRawBtnActionPerformed

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
            java.util.logging.Logger.getLogger(PaymentJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaymentJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaymentJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaymentJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PaymentJF().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddInstalmentsBtn;
    private javax.swing.JLabel Datelbl;
    private javax.swing.JLabel Datelbl1;
    private javax.swing.JTextArea INSAddressTA;
    private javax.swing.JTextField INSContactNoTF;
    private javax.swing.JTextField INSCusIDTF;
    private javax.swing.JLabel INSCusNameOrNIC_CB_Label;
    private javax.swing.JLabel INSCusNameOrNIC_TF_Label;
    private javax.swing.JTextField INSCusNameorNICNoTF;
    private javax.swing.JTextField INSDueBalanceTF;
    private javax.swing.JTextField INSSalesOrderNoTF;
    private javax.swing.JTextField INSSumOfInstalments;
    private javax.swing.JTextField INSTotalAmountTF;
    private javax.swing.JTextField InsInstalmentsTF;
    private javax.swing.JTable InsItemDetailsTable;
    private javax.swing.JComboBox<String> InsSearchCustomerCombo;
    private javax.swing.JPanel InstalmentsPanel;
    private javax.swing.JLabel MainPanelBranchIDLable;
    private javax.swing.JLabel MainPanelBranchNameLable;
    private javax.swing.JButton PFConfirmBtn;
    private javax.swing.JTable PFPaymentsDetailsTable;
    private javax.swing.JLabel PPArrowLbl;
    private javax.swing.JLabel PPBraIDLabel;
    private javax.swing.JLabel PPBraNameLabel;
    private javax.swing.JButton PPBranchersBtn;
    private javax.swing.JButton PPCustomersBtn;
    private javax.swing.JButton PPEmployeeBtn;
    private javax.swing.JButton PPExitBtn;
    private javax.swing.JButton PPFinishedItemsBtn;
    private javax.swing.JLabel PPMainBGLbl;
    private javax.swing.JButton PPMinimizeBtn;
    private javax.swing.JButton PPPaymentsBtn;
    private javax.swing.JButton PPRawItemBtn;
    private javax.swing.JButton PPRemoveLastRawBtn;
    private javax.swing.JButton PPReportBtn;
    private javax.swing.JButton PPSalesBtn;
    private javax.swing.JButton PPSettingsBtn;
    private javax.swing.JButton PPSupplierBtn;
    private javax.swing.JLabel PPUserNameLbl;
    private javax.swing.JButton PPVehicleBtn;
    private javax.swing.JTextField PayBankNameTF;
    private com.toedter.calendar.JDateChooser PayChequeDateDC;
    private javax.swing.JTextField PayChequeNoTF;
    private javax.swing.JRadioButton PayChequeRadioBtn;
    private javax.swing.JPanel PaymentChequeDetailsPnl;
    private javax.swing.JPanel PaymentMainPanel;
    private javax.swing.JButton SPChequesBtn;
    private javax.swing.JButton SPExpensesBtn;
    private javax.swing.JLabel SeldoLogo;
    private javax.swing.JLabel Timelbl;
    private javax.swing.JLabel Timelbl1;
    private javax.swing.JPanel TopPanel;
    private javax.swing.JPanel TopicPanel;
    private javax.swing.JLabel UserNameDisplayLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane9;
    // End of variables declaration//GEN-END:variables
}
