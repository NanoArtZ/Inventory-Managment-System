/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DBConnection.SeldoDB;
import Massages.ErrorMassages;
import com.mysql.jdbc.Statement;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
import javax.swing.table.TableColumn;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.design.*;

/**
 *
 * @author Nano ArtZ
 */
public final class SalesJF extends javax.swing.JFrame {

    /**
     * Creates new form SalesJF
     */
    public SalesJF() {
        initComponents();
        ButtonBehaviorMethod();

        showDate();
        showTime();
        SPPaymentMethodsPnl.setVisible(false);
        setLocationRelativeTo(null);
        this.setState(MAXIMIZED_BOTH);
        FullScreenMethod();
        AutoGenSalesOrderNo();

        LoadItemNameOrCodeToSalesPanelCB();         //Auto Load Item Name or Code - Sales Panel Method
        LoadCustomerNameOrIDToSalesPanel();         //Auto Load Customer Name or ID - Sales Panel Method

        SalesTableWidth();

    }

//----- Sales Frame Methods Start ------//
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

//    Date&Time --- Aloka------//
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

//Sales tabe Width adjusting method Start
    private void SalesTableWidth() {
        try {
            TableColumn LineNo = SPCustomerOrderTable.getColumnModel().getColumn(0);
            LineNo.setPreferredWidth(50);

            TableColumn ItemName = SPCustomerOrderTable.getColumnModel().getColumn(1);
            ItemName.setPreferredWidth(300);

            TableColumn ItemCode = SPCustomerOrderTable.getColumnModel().getColumn(2);
            ItemCode.setPreferredWidth(180);

            TableColumn Thikness = SPCustomerOrderTable.getColumnModel().getColumn(3);
            Thikness.setPreferredWidth(120);

            TableColumn Colour = SPCustomerOrderTable.getColumnModel().getColumn(4);
            Colour.setPreferredWidth(100);

            TableColumn EnteredUnit = SPCustomerOrderTable.getColumnModel().getColumn(5);
            EnteredUnit.setPreferredWidth(150);

            TableColumn ESize = SPCustomerOrderTable.getColumnModel().getColumn(6);
            ESize.setPreferredWidth(120);

            TableColumn SelectedUnit = SPCustomerOrderTable.getColumnModel().getColumn(7);
            SelectedUnit.setPreferredWidth(150);

            TableColumn SSize = SPCustomerOrderTable.getColumnModel().getColumn(8);
            SSize.setPreferredWidth(120);

            TableColumn CurvedWidth = SPCustomerOrderTable.getColumnModel().getColumn(9);
            CurvedWidth.setPreferredWidth(150);

            TableColumn Width = SPCustomerOrderTable.getColumnModel().getColumn(10);
            Width.setPreferredWidth(120);

            TableColumn Height = SPCustomerOrderTable.getColumnModel().getColumn(11);
            Height.setPreferredWidth(120);

            TableColumn Unit = SPCustomerOrderTable.getColumnModel().getColumn(12);
            Unit.setPreferredWidth(120);

            TableColumn Qty = SPCustomerOrderTable.getColumnModel().getColumn(13);
            Qty.setPreferredWidth(100);

            TableColumn Rate = SPCustomerOrderTable.getColumnModel().getColumn(14);
            Rate.setPreferredWidth(100);

            TableColumn Amount = SPCustomerOrderTable.getColumnModel().getColumn(15);
            Amount.setPreferredWidth(180);
        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    //Sales tabe Width adjusting method END

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

            SPChequesBtn.setOpaque(false);
            SPChequesBtn.setContentAreaFilled(false);
            SPChequesBtn.setBorderPainted(false);

        } catch (Exception e) {
            Logger.getLogger(DashBoardJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }
//----- Button Behavior Method END -----//   

    //Sales Panel - Changing Item Catogaries - with Combo Box - Panel Switching Method Start
    private void ItemCatPanelsSwitching(int trueVar, int falseVar) {
        try {
            switch (trueVar) {
                case 1:
                    IDPRoofingSheetPanel.setVisible(true);
                    break;
                case 2:
                    IDPCurvedRoofingSheetPanel.setVisible(true);
                    String RFSheetSelectedUnit01 = SPRFSheetUnit01CB.getSelectedItem().toString();
                    String RFSheetSelectedUnit02 = SPRFSheetUnit02CB.getSelectedItem().toString();
                    SPCurveRFShtUnit01CB.setSelectedItem(RFSheetSelectedUnit01);
                    SPCurveRFShtUnit02CB.setSelectedItem(RFSheetSelectedUnit02);

                    break;
                case 3:
                    IDPRollerDoorPanel.setVisible(true);
                    break;
                case 4:
                    IDPRollerShutterPanel.setVisible(true);
                    break;
                case 5:
                    IDPPurlingPanel.setVisible(true);
                    break;
                case 6:
                    IDPGutterPanel.setVisible(true);
                    break;
                case 7:
                    IDPGatePanel.setVisible(true);
                    break;
                case 8:
                    IDPPlainSheetPanel.setVisible(true);
                    break;
                case 9:
                    IDPCladdingPanel.setVisible(true);
                    break;
            }
            switch (falseVar) {
                case 1:
                    IDPRoofingSheetPanel.setVisible(false);
                    break;
                case 2:
                    IDPCurvedRoofingSheetPanel.setVisible(false);
                    break;
                case 3:
                    IDPRollerDoorPanel.setVisible(false);
                    break;
                case 4:
                    IDPRollerShutterPanel.setVisible(false);
                    break;
                case 5:
                    IDPPurlingPanel.setVisible(false);
                    break;
                case 6:
                    IDPGutterPanel.setVisible(false);
                    break;
                case 7:
                    IDPGatePanel.setVisible(false);
                    break;
                case 8:
                    IDPPlainSheetPanel.setVisible(false);
                    break;
                case 9:
                    IDPCladdingPanel.setVisible(false);
                    break;

            }
        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    //Sales Panel - Changing Item Catogaries - with Combo Box - Panel Switching Method END

    //Sales Panel - Changing Item Catogaries - Combo Box Method Start
    private void ItemCatComboBox() {
        try {

            if (SPItemCatComboBox.getSelectedItem().equals("Roofing Sheet")) {
                for (int i = 1; i < 20; i++) {
                    ItemCatPanelsSwitching(1, i);
                }
            } else if (SPItemCatComboBox.getSelectedItem().equals("Curved Roofing Sheet")) {
                for (int i = 1; i < 20; i++) {
                    ItemCatPanelsSwitching(2, i);
                }
            } else if (SPItemCatComboBox.getSelectedItem().equals("Roller Door")) {
                for (int i = 1; i < 20; i++) {
                    ItemCatPanelsSwitching(3, i);
                }
            } else if (SPItemCatComboBox.getSelectedItem().equals("Roller Shutter")) {
                for (int i = 1; i < 20; i++) {
                    ItemCatPanelsSwitching(4, i);
                }
            } else if (SPItemCatComboBox.getSelectedItem().equals("Purlin")) {
                for (int i = 1; i < 20; i++) {
                    ItemCatPanelsSwitching(5, i);
                }
            } else if (SPItemCatComboBox.getSelectedItem().equals("Gutter")) {
                for (int i = 1; i < 20; i++) {
                    ItemCatPanelsSwitching(6, i);
                }
            } else if (SPItemCatComboBox.getSelectedItem().equals("Gate")) {
                for (int i = 1; i < 20; i++) {
                    ItemCatPanelsSwitching(7, i);
                }

            } else if (SPItemCatComboBox.getSelectedItem().equals("Plain Sheet")) {
                for (int i = 1; i < 20; i++) {
                    ItemCatPanelsSwitching(8, i);
                }
            } else if (SPItemCatComboBox.getSelectedItem().equals("Cladding")) {
                for (int i = 1; i < 20; i++) {
                    ItemCatPanelsSwitching(9, i);
                }
            }

        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    //Sales Panel - Changing Item Catogaries - Combo Box Method END

    //Auto Genarate Next sales orde number - Method Start
    public void AutoGenSalesOrderNo() {
        try {
            Statement st = (Statement) SeldoDB.GetMyConnection().createStatement();
            ResultSet RS = st.executeQuery("SELECT MAX(SONumber) FROM sale");
            if (RS.next()) {
                String MaxSOnumberString = RS.getString("MAX(SONumber)");
                if (MaxSOnumberString == null) {
                    SPSalesOrderNo.setText("SO00000001");
                } else {
                    MaxSOnumberString = MaxSOnumberString.substring(2, 10);
                    int MaxSoNumberInt = Integer.parseInt(MaxSOnumberString);
                    MaxSoNumberInt++;
                    MaxSOnumberString = Integer.toString(MaxSoNumberInt);
                    while (MaxSOnumberString.length() < 8) {
                        MaxSOnumberString = "0" + MaxSOnumberString;
                    }
                    MaxSOnumberString = "SO" + MaxSOnumberString;
                    SPSalesOrderNo.setText(MaxSOnumberString);
                }
            } else {
                SPSalesOrderNo.setText("SO00000001");
            }
        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    //Auto Genarate Next sales orde number - Method END

//Load Item code or Item name to Sales Panel Combo box Method Start
    public void LoadItemNameOrCodeToSalesPanelCB() {
        SPSearchItemNameORCodeCB.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {

                if (e.getKeyCode() != KeyEvent.VK_ENTER && e.getKeyCode() != KeyEvent.VK_UP && e.getKeyCode() != KeyEvent.VK_DOWN && e.getKeyCode() != KeyEvent.VK_SHIFT) {

                    String TypedTxt = SPSearchItemNameORCodeCB.getEditor().getItem().toString();

                    if (!TypedTxt.isEmpty()) {

                        try {
                            SPSearchItemNameORCodeCB.removeAllItems();
                            int st = 0;

                            java.sql.Statement s = SeldoDB.GetMyConnection().createStatement();
                            ResultSet rs = s.executeQuery("SELECT ItemCode FROM finisheditem WHERE ItemCode LIKE '%" + TypedTxt + "%' ");

                            Vector StoreCBData = new Vector();

                            while (rs.next()) {
                                if (rs.getString("ItemCode").toLowerCase().contains(TypedTxt.toLowerCase())) {
                                    StoreCBData.add(rs.getString("ItemCode"));
                                    st++;
                                }
                            }

                            rs = s.executeQuery("SELECT ItemName FROM finisheditem WHERE ItemName LIKE '%" + TypedTxt + "%'");

                            while (rs.next()) {
                                if (rs.getString("ItemName").toLowerCase().contains(TypedTxt.toLowerCase())) {
                                    StoreCBData.add(rs.getString("ItemName"));
                                    st++;
                                }
                            }

                            rs.close();
                            s.close();

                            DefaultComboBoxModel dcm = new DefaultComboBoxModel(StoreCBData);
                            SPSearchItemNameORCodeCB.setModel(dcm);

                            SPSearchItemNameORCodeCB.getEditor().setItem(TypedTxt);
                            SPSearchItemNameORCodeCB.setSelectedItem(TypedTxt);
                            JTextField TextField = (JTextField) e.getSource();
                            TextField.setCaretPosition(TextField.getDocument().getLength());

                            if (st != 0) {
                                SPSearchItemNameORCodeCB.showPopup();

                                if (st > 10) {
                                    SPSearchItemNameORCodeCB.setMaximumRowCount(10);
                                } else {
                                    SPSearchItemNameORCodeCB.setMaximumRowCount(st);
                                }

                            } else {
                                SPSearchItemNameORCodeCB.hidePopup();
                            }

                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, ex);
                        }
                    } else {
                        SPSearchItemNameORCodeCB.hidePopup();
                        SPSearchItemNameORCodeCB.removeAllItems();
                    }
                }
            }
        });
    }
    //Load Item code or Item name to Sales Panel Combo box Method END

    // Load Selected Item Details to relevant feilds - Sales Order Panel- Method Start
    public void LoadItemDetailsToSalesPanel() {
        try {
            if (SPSearchItemNameORCodeCB.getSelectedIndex() != -1) {
                String TypedText = SPSearchItemNameORCodeCB.getSelectedItem().toString();
                Statement s = (Statement) SeldoDB.GetMyConnection().createStatement();
                ResultSet RS = s.executeQuery("SELECT * FROM finisheditem WHERE ItemCode = '" + TypedText + "' ");

                if (RS.next()) {                                 //if Item code equels to typed text in combo box
                    String ItemCode = TypedText;
                    RS = s.executeQuery("SELECT * FROM finisheditem WHERE ItemCode = '" + ItemCode + "' ");
                    RS.next();

                    String ItemName = RS.getString("ItemName");
                    SPItemNameOrCodeTF.setText(ItemName);
                    SPItemNameORCodeLable.setText("Item Name");
                    SPSearchItemLable.setText("Item Code");

                } else {
                    String ItemName = TypedText;
                    RS = s.executeQuery("SELECT * FROM finisheditem WHERE ItemName= '" + ItemName + "' ");
                    RS.next();
                    String ItemCode = RS.getString("ItemCode");
                    SPItemNameOrCodeTF.setText(ItemCode);
                    SPItemNameORCodeLable.setText("Item Code");
                    SPSearchItemLable.setText("Item Name");
                }
            } else {
                SPItemNameORCodeLable.setText("Item Name/Code");
                SPSearchItemLable.setText("Search Item");
                SPItemNameOrCodeTF.setText(null);
            }
        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    // Load Selected Item Details to relevant feilds - Sales Order Panel- Method END

    //Unit Converters for Sales Panel Method Start
    public void UnitConverter4RoofingSheet() {
        try {
            String Unit01 = SPRFSheetUnit01CB.getSelectedItem().toString();
            String Unit02 = SPRFSheetUnit02CB.getSelectedItem().toString();

            if (SPRFSheetSizeTF.getText() == null || SPRFSheetSizeTF.getText().isEmpty()) {

                double EnteredUnit = 0.00;

                switch (Unit01) {
                    case "Millimeters":
                        //Consider Any Unit with Millimter
                        switch (Unit02) {
                            case "Millimeters": {
                                DecimalFormat df = new DecimalFormat("#.##");
                                EnteredUnit = Double.valueOf(df.format(EnteredUnit));
                                String ResultString = String.valueOf(EnteredUnit);
                                SPRFSheetSizeConvertedTF.setText(ResultString);
                                break;
                            }
                            case "Inches": {
                                double ResultDbl = EnteredUnit / 25.40;
                                DecimalFormat df = new DecimalFormat("#.##");
                                ResultDbl = Double.valueOf(df.format(ResultDbl));
                                String ResultString = String.valueOf(ResultDbl);
                                SPRFSheetSizeConvertedTF.setText(ResultString);
                                break;
                            }
                            case "Feet": {
                                double ResultDbl = EnteredUnit / 304.80;
                                DecimalFormat df = new DecimalFormat("#.##");
                                ResultDbl = Double.valueOf(df.format(ResultDbl));
                                String ResultString = String.valueOf(ResultDbl);
                                SPRFSheetSizeConvertedTF.setText(ResultString);
                                break;
                            }
                            default:
                                break;
                        }
                        break;
                    case "Inches":
                        //Consider Any Unit with Inches
                        switch (Unit02) {
                            case "Inches": {
                                DecimalFormat df = new DecimalFormat("#.##");
                                EnteredUnit = Double.valueOf(df.format(EnteredUnit));
                                String ResultString = String.valueOf(EnteredUnit);
                                SPRFSheetSizeConvertedTF.setText(ResultString);
                                break;
                            }
                            case "Millimeters": {
                                double ResultDbl = EnteredUnit * 25.40;
                                DecimalFormat df = new DecimalFormat("#.##");
                                ResultDbl = Double.valueOf(df.format(ResultDbl));
                                String ResultString = String.valueOf(ResultDbl);
                                SPRFSheetSizeConvertedTF.setText(ResultString);
                                break;
                            }
                            case "Feet": {
                                double ResultDbl = EnteredUnit / 12;
                                DecimalFormat df = new DecimalFormat("#.##");
                                ResultDbl = Double.valueOf(df.format(ResultDbl));
                                String ResultString = String.valueOf(ResultDbl);
                                SPRFSheetSizeConvertedTF.setText(ResultString);
                                break;
                            }
                            default:
                                break;
                        }
                        break;
                    case "Feet":
                        //Consider Any Unit with Feets
                        switch (Unit02) {
                            case "Feet": {
                                DecimalFormat df = new DecimalFormat("#.##");
                                EnteredUnit = Double.valueOf(df.format(EnteredUnit));
                                String ResultString = String.valueOf(EnteredUnit);
                                SPRFSheetSizeConvertedTF.setText(ResultString);
                                break;
                            }
                            case "Millimeters": {
                                double ResultDbl = EnteredUnit * 304.80;
                                DecimalFormat df = new DecimalFormat("#.##");
                                ResultDbl = Double.valueOf(df.format(ResultDbl));
                                String ResultString = String.valueOf(ResultDbl);
                                SPRFSheetSizeConvertedTF.setText(ResultString);
                                break;
                            }
                            case "Inches": {
                                double ResultDbl = EnteredUnit * 12;
                                DecimalFormat df = new DecimalFormat("#.##");
                                ResultDbl = Double.valueOf(df.format(ResultDbl));
                                String ResultString = String.valueOf(ResultDbl);
                                SPRFSheetSizeConvertedTF.setText(ResultString);
                                break;
                            }
                            default:
                                break;
                        }
                        break;
                    default:
                        break;
                }
            } else {

                double EnteredUnit = Double.parseDouble(SPRFSheetSizeTF.getText());

                switch (Unit01) {
                    case "Millimeters":
                        //Consider Any Unit with Millimter
                        switch (Unit02) {
                            case "Millimeters": {
                                DecimalFormat df = new DecimalFormat("#.##");
                                EnteredUnit = Double.valueOf(df.format(EnteredUnit));
                                String ResultString = String.valueOf(EnteredUnit);
                                SPRFSheetSizeConvertedTF.setText(ResultString);
                                break;
                            }
                            case "Inches": {
                                double ResultDbl = EnteredUnit / 25.40;
                                DecimalFormat df = new DecimalFormat("#.##");
                                ResultDbl = Double.valueOf(df.format(ResultDbl));
                                String ResultString = String.valueOf(ResultDbl);
                                SPRFSheetSizeConvertedTF.setText(ResultString);
                                break;
                            }
                            case "Feet": {
                                double ResultDbl = EnteredUnit / 304.80;
                                DecimalFormat df = new DecimalFormat("#.##");
                                ResultDbl = Double.valueOf(df.format(ResultDbl));
                                String ResultString = String.valueOf(ResultDbl);
                                SPRFSheetSizeConvertedTF.setText(ResultString);
                                break;
                            }
                            default:
                                break;
                        }
                        break;
                    case "Inches":
                        //Consider Any Unit with Inches
                        switch (Unit02) {
                            case "Inches": {
                                DecimalFormat df = new DecimalFormat("#.##");
                                EnteredUnit = Double.valueOf(df.format(EnteredUnit));
                                String ResultString = String.valueOf(EnteredUnit);
                                SPRFSheetSizeConvertedTF.setText(ResultString);
                                break;
                            }
                            case "Millimeters": {
                                double ResultDbl = EnteredUnit * 25.40;
                                DecimalFormat df = new DecimalFormat("#.##");
                                ResultDbl = Double.valueOf(df.format(ResultDbl));
                                String ResultString = String.valueOf(ResultDbl);
                                SPRFSheetSizeConvertedTF.setText(ResultString);
                                break;
                            }
                            case "Feet": {
                                double ResultDbl = EnteredUnit / 12;
                                DecimalFormat df = new DecimalFormat("#.##");
                                ResultDbl = Double.valueOf(df.format(ResultDbl));
                                String ResultString = String.valueOf(ResultDbl);
                                SPRFSheetSizeConvertedTF.setText(ResultString);
                                break;
                            }
                            default:
                                break;
                        }
                        break;
                    case "Feet":
                        //Consider Any Unit with Feets
                        switch (Unit02) {
                            case "Feet": {
                                DecimalFormat df = new DecimalFormat("#.##");
                                EnteredUnit = Double.valueOf(df.format(EnteredUnit));
                                String ResultString = String.valueOf(EnteredUnit);
                                SPRFSheetSizeConvertedTF.setText(ResultString);
                                break;
                            }
                            case "Millimeters": {
                                double ResultDbl = EnteredUnit * 304.80;
                                DecimalFormat df = new DecimalFormat("#.##");
                                ResultDbl = Double.valueOf(df.format(ResultDbl));
                                String ResultString = String.valueOf(ResultDbl);
                                SPRFSheetSizeConvertedTF.setText(ResultString);
                                break;
                            }
                            case "Inches": {
                                double ResultDbl = EnteredUnit * 12;
                                DecimalFormat df = new DecimalFormat("#.##");
                                ResultDbl = Double.valueOf(df.format(ResultDbl));
                                String ResultString = String.valueOf(ResultDbl);
                                SPRFSheetSizeConvertedTF.setText(ResultString);
                                break;
                            }
                            default:
                                break;
                        }
                        break;
                    default:
                        break;
                }
            }
        } catch (NumberFormatException e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void UnitConverter4CurveSheet() {
        try {
            String Unit01 = SPCurveRFShtUnit01CB.getSelectedItem().toString();
            String Unit02 = SPCurveRFShtUnit02CB.getSelectedItem().toString();

            if (SPCurveRFShtSizeCB.getText() == null || SPCurveRFShtSizeCB.getText().isEmpty()) {

                double EnteredUnit = 0.00;

                switch (Unit01) {
                    case "Millimeters":
                        //Consider Any Unit with Millimter
                        switch (Unit02) {
                            case "Millimeters": {
                                DecimalFormat df = new DecimalFormat("#.##");
                                EnteredUnit = Double.valueOf(df.format(EnteredUnit));
                                String ResultString = String.valueOf(EnteredUnit);
                                SPCurveRFConvertedSizeTF.setText(ResultString);
                                break;
                            }
                            case "Inches": {
                                double ResultDbl = EnteredUnit / 25.40;
                                DecimalFormat df = new DecimalFormat("#.##");
                                ResultDbl = Double.valueOf(df.format(ResultDbl));
                                String ResultString = String.valueOf(ResultDbl);
                                SPCurveRFConvertedSizeTF.setText(ResultString);
                                break;
                            }
                            case "Feet": {
                                double ResultDbl = EnteredUnit / 304.80;
                                DecimalFormat df = new DecimalFormat("#.##");
                                ResultDbl = Double.valueOf(df.format(ResultDbl));
                                String ResultString = String.valueOf(ResultDbl);
                                SPCurveRFConvertedSizeTF.setText(ResultString);
                                break;
                            }
                            default:
                                break;
                        }
                        break;
                    case "Inches":
                        //Consider Any Unit with Inches
                        switch (Unit02) {
                            case "Inches": {
                                DecimalFormat df = new DecimalFormat("#.##");
                                EnteredUnit = Double.valueOf(df.format(EnteredUnit));
                                String ResultString = String.valueOf(EnteredUnit);
                                SPCurveRFConvertedSizeTF.setText(ResultString);
                                break;
                            }
                            case "Millimeters": {
                                double ResultDbl = EnteredUnit * 25.40;
                                DecimalFormat df = new DecimalFormat("#.##");
                                ResultDbl = Double.valueOf(df.format(ResultDbl));
                                String ResultString = String.valueOf(ResultDbl);
                                SPCurveRFConvertedSizeTF.setText(ResultString);
                                break;
                            }
                            case "Feet": {
                                double ResultDbl = EnteredUnit / 12;
                                DecimalFormat df = new DecimalFormat("#.##");
                                ResultDbl = Double.valueOf(df.format(ResultDbl));
                                String ResultString = String.valueOf(ResultDbl);
                                SPCurveRFConvertedSizeTF.setText(ResultString);
                                break;
                            }
                            default:
                                break;
                        }
                        break;
                    case "Feet":
                        //Consider Any Unit with Feets
                        switch (Unit02) {
                            case "Feet": {
                                DecimalFormat df = new DecimalFormat("#.##");
                                EnteredUnit = Double.valueOf(df.format(EnteredUnit));
                                String ResultString = String.valueOf(EnteredUnit);
                                SPCurveRFConvertedSizeTF.setText(ResultString);
                                break;
                            }
                            case "Millimeters": {
                                double ResultDbl = EnteredUnit * 304.80;
                                DecimalFormat df = new DecimalFormat("#.##");
                                ResultDbl = Double.valueOf(df.format(ResultDbl));
                                String ResultString = String.valueOf(ResultDbl);
                                SPCurveRFConvertedSizeTF.setText(ResultString);
                                break;
                            }
                            case "Inches": {
                                double ResultDbl = EnteredUnit * 12;
                                DecimalFormat df = new DecimalFormat("#.##");
                                ResultDbl = Double.valueOf(df.format(ResultDbl));
                                String ResultString = String.valueOf(ResultDbl);
                                SPCurveRFConvertedSizeTF.setText(ResultString);
                                break;
                            }
                            default:
                                break;
                        }
                        break;
                    default:
                        break;
                }
            } else {

                double EnteredUnit = Double.parseDouble(SPCurveRFShtSizeCB.getText());

                switch (Unit01) {
                    case "Millimeters":
                        //Consider Any Unit with Millimter
                        switch (Unit02) {
                            case "Millimeters": {
                                DecimalFormat df = new DecimalFormat("#.##");
                                EnteredUnit = Double.valueOf(df.format(EnteredUnit));
                                String ResultString = String.valueOf(EnteredUnit);
                                SPCurveRFConvertedSizeTF.setText(ResultString);
                                break;
                            }
                            case "Inches": {
                                double ResultDbl = EnteredUnit / 25.40;
                                DecimalFormat df = new DecimalFormat("#.##");
                                ResultDbl = Double.valueOf(df.format(ResultDbl));
                                String ResultString = String.valueOf(ResultDbl);
                                SPCurveRFConvertedSizeTF.setText(ResultString);
                                break;
                            }
                            case "Feet": {
                                double ResultDbl = EnteredUnit / 304.80;
                                DecimalFormat df = new DecimalFormat("#.##");
                                ResultDbl = Double.valueOf(df.format(ResultDbl));
                                String ResultString = String.valueOf(ResultDbl);
                                SPCurveRFConvertedSizeTF.setText(ResultString);
                                break;
                            }
                            default:
                                break;
                        }
                        break;
                    case "Inches":
                        //Consider Any Unit with Inches
                        switch (Unit02) {
                            case "Inches": {
                                DecimalFormat df = new DecimalFormat("#.##");
                                EnteredUnit = Double.valueOf(df.format(EnteredUnit));
                                String ResultString = String.valueOf(EnteredUnit);
                                SPCurveRFConvertedSizeTF.setText(ResultString);
                                break;
                            }
                            case "Millimeters": {
                                double ResultDbl = EnteredUnit * 25.40;
                                DecimalFormat df = new DecimalFormat("#.##");
                                ResultDbl = Double.valueOf(df.format(ResultDbl));
                                String ResultString = String.valueOf(ResultDbl);
                                SPCurveRFConvertedSizeTF.setText(ResultString);
                                break;
                            }
                            case "Feet": {
                                double ResultDbl = EnteredUnit / 12;
                                DecimalFormat df = new DecimalFormat("#.##");
                                ResultDbl = Double.valueOf(df.format(ResultDbl));
                                String ResultString = String.valueOf(ResultDbl);
                                SPCurveRFConvertedSizeTF.setText(ResultString);
                                break;
                            }
                            default:
                                break;
                        }
                        break;
                    case "Feet":
                        //Consider Any Unit with Feets
                        switch (Unit02) {
                            case "Feet": {
                                DecimalFormat df = new DecimalFormat("#.##");
                                EnteredUnit = Double.valueOf(df.format(EnteredUnit));
                                String ResultString = String.valueOf(EnteredUnit);
                                SPCurveRFConvertedSizeTF.setText(ResultString);
                                break;
                            }
                            case "Millimeters": {
                                double ResultDbl = EnteredUnit * 304.80;
                                DecimalFormat df = new DecimalFormat("#.##");
                                ResultDbl = Double.valueOf(df.format(ResultDbl));
                                String ResultString = String.valueOf(ResultDbl);
                                SPCurveRFConvertedSizeTF.setText(ResultString);
                                break;
                            }
                            case "Inches": {
                                double ResultDbl = EnteredUnit * 12;
                                DecimalFormat df = new DecimalFormat("#.##");
                                ResultDbl = Double.valueOf(df.format(ResultDbl));
                                String ResultString = String.valueOf(ResultDbl);
                                SPCurveRFConvertedSizeTF.setText(ResultString);
                                break;
                            }
                            default:
                                break;
                        }
                        break;
                    default:
                        break;
                }
            }
        } catch (NumberFormatException e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void UnitConverter4PlainSheet() {
        try {
            String Unit01 = SPPlainSheetUnit01CB.getSelectedItem().toString();
            String Unit02 = SPPlainSheetUnit02CB.getSelectedItem().toString();

            if (SPPlainSheetSizeTF.getText() == null || SPPlainSheetSizeTF.getText().isEmpty()) {

                double EnteredUnit = 0.00;

                switch (Unit01) {
                    case "Millimeters":
                        //Consider Any Unit with Millimter
                        switch (Unit02) {
                            case "Millimeters": {
                                DecimalFormat df = new DecimalFormat("#.##");
                                EnteredUnit = Double.valueOf(df.format(EnteredUnit));
                                String ResultString = String.valueOf(EnteredUnit);
                                SPPlainSheetConvertedTF.setText(ResultString);
                                break;
                            }
                            case "Inches": {
                                double ResultDbl = EnteredUnit / 25.40;
                                DecimalFormat df = new DecimalFormat("#.##");
                                ResultDbl = Double.valueOf(df.format(ResultDbl));
                                String ResultString = String.valueOf(ResultDbl);
                                SPPlainSheetConvertedTF.setText(ResultString);
                                break;
                            }
                            case "Feet": {
                                double ResultDbl = EnteredUnit / 304.80;
                                DecimalFormat df = new DecimalFormat("#.##");
                                ResultDbl = Double.valueOf(df.format(ResultDbl));
                                String ResultString = String.valueOf(ResultDbl);
                                SPPlainSheetConvertedTF.setText(ResultString);
                                break;
                            }
                            default:
                                break;
                        }
                        break;
                    case "Inches":
                        //Consider Any Unit with Inches
                        switch (Unit02) {
                            case "Inches": {
                                DecimalFormat df = new DecimalFormat("#.##");
                                EnteredUnit = Double.valueOf(df.format(EnteredUnit));
                                String ResultString = String.valueOf(EnteredUnit);
                                SPPlainSheetConvertedTF.setText(ResultString);
                                break;
                            }
                            case "Millimeters": {
                                double ResultDbl = EnteredUnit * 25.40;
                                DecimalFormat df = new DecimalFormat("#.##");
                                ResultDbl = Double.valueOf(df.format(ResultDbl));
                                String ResultString = String.valueOf(ResultDbl);
                                SPPlainSheetConvertedTF.setText(ResultString);
                                break;
                            }
                            case "Feet": {
                                double ResultDbl = EnteredUnit / 12;
                                DecimalFormat df = new DecimalFormat("#.##");
                                ResultDbl = Double.valueOf(df.format(ResultDbl));
                                String ResultString = String.valueOf(ResultDbl);
                                SPPlainSheetConvertedTF.setText(ResultString);
                                break;
                            }
                            default:
                                break;
                        }
                        break;
                    case "Feet":
                        //Consider Any Unit with Feets
                        switch (Unit02) {
                            case "Feet": {
                                DecimalFormat df = new DecimalFormat("#.##");
                                EnteredUnit = Double.valueOf(df.format(EnteredUnit));
                                String ResultString = String.valueOf(EnteredUnit);
                                SPPlainSheetConvertedTF.setText(ResultString);
                                break;
                            }
                            case "Millimeters": {
                                double ResultDbl = EnteredUnit * 304.80;
                                DecimalFormat df = new DecimalFormat("#.##");
                                ResultDbl = Double.valueOf(df.format(ResultDbl));
                                String ResultString = String.valueOf(ResultDbl);
                                SPPlainSheetConvertedTF.setText(ResultString);
                                break;
                            }
                            case "Inches": {
                                double ResultDbl = EnteredUnit * 12;
                                DecimalFormat df = new DecimalFormat("#.##");
                                ResultDbl = Double.valueOf(df.format(ResultDbl));
                                String ResultString = String.valueOf(ResultDbl);
                                SPPlainSheetConvertedTF.setText(ResultString);
                                break;
                            }
                            default:
                                break;
                        }
                        break;
                    default:
                        break;
                }
            } else {

                double EnteredUnit = Double.parseDouble(SPPlainSheetSizeTF.getText());

                switch (Unit01) {
                    case "Millimeters":
                        //Consider Any Unit with Millimter
                        switch (Unit02) {
                            case "Millimeters": {
                                DecimalFormat df = new DecimalFormat("#.##");
                                EnteredUnit = Double.valueOf(df.format(EnteredUnit));
                                String ResultString = String.valueOf(EnteredUnit);
                                SPPlainSheetConvertedTF.setText(ResultString);
                                break;
                            }
                            case "Inches": {
                                double ResultDbl = EnteredUnit / 25.40;
                                DecimalFormat df = new DecimalFormat("#.##");
                                ResultDbl = Double.valueOf(df.format(ResultDbl));
                                String ResultString = String.valueOf(ResultDbl);
                                SPPlainSheetConvertedTF.setText(ResultString);
                                break;
                            }
                            case "Feet": {
                                double ResultDbl = EnteredUnit / 304.80;
                                DecimalFormat df = new DecimalFormat("#.##");
                                ResultDbl = Double.valueOf(df.format(ResultDbl));
                                String ResultString = String.valueOf(ResultDbl);
                                SPPlainSheetConvertedTF.setText(ResultString);
                                break;
                            }
                            default:
                                break;
                        }
                        break;
                    case "Inches":
                        //Consider Any Unit with Inches
                        switch (Unit02) {
                            case "Inches": {
                                DecimalFormat df = new DecimalFormat("#.##");
                                EnteredUnit = Double.valueOf(df.format(EnteredUnit));
                                String ResultString = String.valueOf(EnteredUnit);
                                SPPlainSheetConvertedTF.setText(ResultString);
                                break;
                            }
                            case "Millimeters": {
                                double ResultDbl = EnteredUnit * 25.40;
                                DecimalFormat df = new DecimalFormat("#.##");
                                ResultDbl = Double.valueOf(df.format(ResultDbl));
                                String ResultString = String.valueOf(ResultDbl);
                                SPPlainSheetConvertedTF.setText(ResultString);
                                break;
                            }
                            case "Feet": {
                                double ResultDbl = EnteredUnit / 12;
                                DecimalFormat df = new DecimalFormat("#.##");
                                ResultDbl = Double.valueOf(df.format(ResultDbl));
                                String ResultString = String.valueOf(ResultDbl);
                                SPPlainSheetConvertedTF.setText(ResultString);
                                break;
                            }
                            default:
                                break;
                        }
                        break;
                    case "Feet":
                        //Consider Any Unit with Feets
                        switch (Unit02) {
                            case "Feet": {
                                DecimalFormat df = new DecimalFormat("#.##");
                                EnteredUnit = Double.valueOf(df.format(EnteredUnit));
                                String ResultString = String.valueOf(EnteredUnit);
                                SPPlainSheetConvertedTF.setText(ResultString);
                                break;
                            }
                            case "Millimeters": {
                                double ResultDbl = EnteredUnit * 304.80;
                                DecimalFormat df = new DecimalFormat("#.##");
                                ResultDbl = Double.valueOf(df.format(ResultDbl));
                                String ResultString = String.valueOf(ResultDbl);
                                SPPlainSheetConvertedTF.setText(ResultString);
                                break;
                            }
                            case "Inches": {
                                double ResultDbl = EnteredUnit * 12;
                                DecimalFormat df = new DecimalFormat("#.##");
                                ResultDbl = Double.valueOf(df.format(ResultDbl));
                                String ResultString = String.valueOf(ResultDbl);
                                SPPlainSheetConvertedTF.setText(ResultString);
                                break;
                            }
                            default:
                                break;
                        }
                        break;
                    default:
                        break;
                }
            }
        } catch (NumberFormatException e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    //Unt Converter For Sales Panel - Cladding
    public void UnitConverter4Cladding() {
        try {
            String Unit01 = SPCladdingUnit01CB.getSelectedItem().toString();
            String Unit02 = SPCladdingUnit02CB.getSelectedItem().toString();

            if (SPCladdingSizeTF.getText() == null || SPCladdingSizeTF.getText().isEmpty()) {

                double EnteredUnit = 0.00;

                switch (Unit01) {
                    case "Millimeters":
                        //Consider Any Unit with Millimter
                        switch (Unit02) {
                            case "Millimeters": {
                                DecimalFormat df = new DecimalFormat("#.##");
                                EnteredUnit = Double.valueOf(df.format(EnteredUnit));
                                String ResultString = String.valueOf(EnteredUnit);
                                SPCladdingConvertedTF.setText(ResultString);
                                break;
                            }
                            case "Inches": {
                                double ResultDbl = EnteredUnit / 25.40;
                                DecimalFormat df = new DecimalFormat("#.##");
                                ResultDbl = Double.valueOf(df.format(ResultDbl));
                                String ResultString = String.valueOf(ResultDbl);
                                SPCladdingConvertedTF.setText(ResultString);
                                break;
                            }
                            case "Feet": {
                                double ResultDbl = EnteredUnit / 304.80;
                                DecimalFormat df = new DecimalFormat("#.##");
                                ResultDbl = Double.valueOf(df.format(ResultDbl));
                                String ResultString = String.valueOf(ResultDbl);
                                SPCladdingConvertedTF.setText(ResultString);
                                break;
                            }
                            default:
                                break;
                        }
                        break;
                    case "Inches":
                        //Consider Any Unit with Inches
                        switch (Unit02) {
                            case "Inches": {
                                DecimalFormat df = new DecimalFormat("#.##");
                                EnteredUnit = Double.valueOf(df.format(EnteredUnit));
                                String ResultString = String.valueOf(EnteredUnit);
                                SPCladdingConvertedTF.setText(ResultString);
                                break;
                            }
                            case "Millimeters": {
                                double ResultDbl = EnteredUnit * 25.40;
                                DecimalFormat df = new DecimalFormat("#.##");
                                ResultDbl = Double.valueOf(df.format(ResultDbl));
                                String ResultString = String.valueOf(ResultDbl);
                                SPCladdingConvertedTF.setText(ResultString);
                                break;
                            }
                            case "Feet": {
                                double ResultDbl = EnteredUnit / 12;
                                DecimalFormat df = new DecimalFormat("#.##");
                                ResultDbl = Double.valueOf(df.format(ResultDbl));
                                String ResultString = String.valueOf(ResultDbl);
                                SPCladdingConvertedTF.setText(ResultString);
                                break;
                            }
                            default:
                                break;
                        }
                        break;
                    case "Feet":
                        //Consider Any Unit with Feets
                        switch (Unit02) {
                            case "Feet": {
                                DecimalFormat df = new DecimalFormat("#.##");
                                EnteredUnit = Double.valueOf(df.format(EnteredUnit));
                                String ResultString = String.valueOf(EnteredUnit);
                                SPCladdingConvertedTF.setText(ResultString);
                                break;
                            }
                            case "Millimeters": {
                                double ResultDbl = EnteredUnit * 304.80;
                                DecimalFormat df = new DecimalFormat("#.##");
                                ResultDbl = Double.valueOf(df.format(ResultDbl));
                                String ResultString = String.valueOf(ResultDbl);
                                SPCladdingConvertedTF.setText(ResultString);
                                break;
                            }
                            case "Inches": {
                                double ResultDbl = EnteredUnit * 12;
                                DecimalFormat df = new DecimalFormat("#.##");
                                ResultDbl = Double.valueOf(df.format(ResultDbl));
                                String ResultString = String.valueOf(ResultDbl);
                                SPCladdingConvertedTF.setText(ResultString);
                                break;
                            }
                            default:
                                break;
                        }
                        break;
                    default:
                        break;
                }
            } else {

                double EnteredUnit = Double.parseDouble(SPCladdingSizeTF.getText());

                switch (Unit01) {
                    case "Millimeters":
                        //Consider Any Unit with Millimter
                        switch (Unit02) {
                            case "Millimeters": {
                                DecimalFormat df = new DecimalFormat("#.##");
                                EnteredUnit = Double.valueOf(df.format(EnteredUnit));
                                String ResultString = String.valueOf(EnteredUnit);
                                SPCladdingConvertedTF.setText(ResultString);
                                break;
                            }
                            case "Inches": {
                                double ResultDbl = EnteredUnit / 25.40;
                                DecimalFormat df = new DecimalFormat("#.##");
                                ResultDbl = Double.valueOf(df.format(ResultDbl));
                                String ResultString = String.valueOf(ResultDbl);
                                SPCladdingConvertedTF.setText(ResultString);
                                break;
                            }
                            case "Feet": {
                                double ResultDbl = EnteredUnit / 304.80;
                                DecimalFormat df = new DecimalFormat("#.##");
                                ResultDbl = Double.valueOf(df.format(ResultDbl));
                                String ResultString = String.valueOf(ResultDbl);
                                SPCladdingConvertedTF.setText(ResultString);
                                break;
                            }
                            default:
                                break;
                        }
                        break;
                    case "Inches":
                        //Consider Any Unit with Inches
                        switch (Unit02) {
                            case "Inches": {
                                DecimalFormat df = new DecimalFormat("#.##");
                                EnteredUnit = Double.valueOf(df.format(EnteredUnit));
                                String ResultString = String.valueOf(EnteredUnit);
                                SPCladdingConvertedTF.setText(ResultString);
                                break;
                            }
                            case "Millimeters": {
                                double ResultDbl = EnteredUnit * 25.40;
                                DecimalFormat df = new DecimalFormat("#.##");
                                ResultDbl = Double.valueOf(df.format(ResultDbl));
                                String ResultString = String.valueOf(ResultDbl);
                                SPCladdingConvertedTF.setText(ResultString);
                                break;
                            }
                            case "Feet": {
                                double ResultDbl = EnteredUnit / 12;
                                DecimalFormat df = new DecimalFormat("#.##");
                                ResultDbl = Double.valueOf(df.format(ResultDbl));
                                String ResultString = String.valueOf(ResultDbl);
                                SPCladdingConvertedTF.setText(ResultString);
                                break;
                            }
                            default:
                                break;
                        }
                        break;
                    case "Feet":
                        //Consider Any Unit with Feets
                        switch (Unit02) {
                            case "Feet": {
                                DecimalFormat df = new DecimalFormat("#.##");
                                EnteredUnit = Double.valueOf(df.format(EnteredUnit));
                                String ResultString = String.valueOf(EnteredUnit);
                                SPCladdingConvertedTF.setText(ResultString);
                                break;
                            }
                            case "Millimeters": {
                                double ResultDbl = EnteredUnit * 304.80;
                                DecimalFormat df = new DecimalFormat("#.##");
                                ResultDbl = Double.valueOf(df.format(ResultDbl));
                                String ResultString = String.valueOf(ResultDbl);
                                SPCladdingConvertedTF.setText(ResultString);
                                break;
                            }
                            case "Inches": {
                                double ResultDbl = EnteredUnit * 12;
                                DecimalFormat df = new DecimalFormat("#.##");
                                ResultDbl = Double.valueOf(df.format(ResultDbl));
                                String ResultString = String.valueOf(ResultDbl);
                                SPCladdingConvertedTF.setText(ResultString);
                                break;
                            }
                            default:
                                break;
                        }
                        break;
                    default:
                        break;
                }
            }
        } catch (NumberFormatException e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    //Unit Converters for Sales Panel Method END
    //Calculate Amount of sales order - Sales Panel Method Start
    public Double CalculateAmount(String SizeConveted, String Qty, String Rate, String Unit2) {

        try {
            if (Rate.isEmpty() || Rate == null) {
                double emptyDbl = 00.00;
                //SPRFSheetAmountTF.setText("00.00");
                Double ReturnDoubleValue = emptyDbl;
                return ReturnDoubleValue;
            } else {
                double Size = new Double(SizeConveted);
                double QtyDbl = new Double(Qty);
                double RateDbl = new Double(Rate);

                DecimalFormat df = new DecimalFormat("#.##");

                if (Unit2.equals("Millimeters")) {
                    double LinearFeetDbl = Size / 304.80;
                    double AmountDbl = (LinearFeetDbl * RateDbl) * QtyDbl;

                    AmountDbl = Double.valueOf(df.format(AmountDbl));
                    Double ReturnDoubleValue = AmountDbl;
                    return ReturnDoubleValue;

                } else if (Unit2.equals("Inches")) {
                    double LinearFeetDbl = Size / 12.00;
                    double AmountDbl = (LinearFeetDbl * RateDbl) * QtyDbl;

                    AmountDbl = Double.valueOf(df.format(AmountDbl));
                    Double ReturnDoubleValue = AmountDbl;
                    return ReturnDoubleValue;

                } else if (Unit2.equals("Feet")) {
                    double AmountDbl = (Size * RateDbl) * QtyDbl;
                    AmountDbl = Double.valueOf(df.format(AmountDbl));
                    //SPRFSheetAmountTF.setText(Double.toString(AmountDbl));
                    Double ReturnDoubleValue = AmountDbl;
                    return ReturnDoubleValue;

                } else if (Unit2.equals("Meters")) {
                    double LinearFeetDbl = Size / 0.3048;
                    double AmountDbl = (LinearFeetDbl * RateDbl) * QtyDbl;

                    AmountDbl = Double.valueOf(df.format(AmountDbl));
                    Double ReturnDoubleValue = AmountDbl;
                    return ReturnDoubleValue;
                }
            }

        } catch (NumberFormatException e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    //Calculate Amount of sales order - Sales Panel Method END

    //Calculate Amount of Roller Doors & Gates Panel mathod - (Sales table) - Method Start
    public String RollerDoorCalculateAmount(String RDHeight, String RDHeightUnit, String RDWidth, String RDQty, String RDRate) {
        try {

            if (null == RDHeight || RDHeight == null || RDHeight.equals("")
                    || null == RDWidth || RDWidth == null || RDWidth.equals("")
                    || null == RDQty || RDQty == null || RDQty.equals("")
                    || null == RDRate || RDRate == null || RDRate.equals("")) {

                JOptionPane.showMessageDialog(rootPane, "Please Fill All Feilds");

            } else {
                Double RDHeightDouble = Double.valueOf(RDHeight);
                Double RDWidthDouble = Double.valueOf(RDWidth);
                Double RDQtyDouble = Double.valueOf(RDQty);
                Double RDRateDouble = Double.valueOf(RDRate);

                if (RDHeightUnit.equals("Feet")) {

                    Double RDAmount = RDHeightDouble * RDWidthDouble * RDRateDouble * RDQtyDouble;
                    DecimalFormat df = new DecimalFormat("#.##");
                    RDAmount = Double.valueOf(df.format(RDAmount));
                    String ReturnRDAmount = String.valueOf(RDAmount);
                    return ReturnRDAmount;

                } else if (RDHeightUnit.equals("Inches")) {
                    Double HeightByFeets = RDHeightDouble / 12;
                    Double WidthByFeets = RDWidthDouble / 12;

                    Double RDAmount = HeightByFeets * WidthByFeets * RDRateDouble * RDQtyDouble;
                    DecimalFormat df = new DecimalFormat("#.##");
                    RDAmount = Double.valueOf(df.format(RDAmount));
                    String ReturnRDAmount = String.valueOf(RDAmount);
                    return ReturnRDAmount;

                } else if (RDHeightUnit.equals("Meters")) {
                    Double HeightByFeets = RDHeightDouble / 3.281;
                    Double WidthByFeets = RDWidthDouble / 3.281;

                    Double RDAmount = HeightByFeets * WidthByFeets * RDRateDouble * RDQtyDouble;
                    DecimalFormat df = new DecimalFormat("#.##");
                    RDAmount = Double.valueOf(df.format(RDAmount));
                    String ReturnRDAmount = String.valueOf(RDAmount);
                    return ReturnRDAmount;
                }
            }
        } catch (HeadlessException | NumberFormatException e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    //Calculate Amount of Roller Doors Panel mathod - (Sales table) - Method END

    //Add items to Table - Sales Panel Method Start
    public void AddItemsToSalesTable() {
        try {
            if (SPSearchItemNameORCodeCB.getSelectedItem() == ("Please Select an Item") || SPSearchItemNameORCodeCB.getSelectedItem() == ("Please Select your next Item")) {
                JOptionPane.showMessageDialog(null, "Please select a valied item before adding");
            } else {
                DefaultTableModel DTM = (DefaultTableModel) SPCustomerOrderTable.getModel();
                String ItemCat = SPItemCatComboBox.getSelectedItem().toString();
                Vector v = new Vector();
                int Index = 1;

                int Rawcount = SPCustomerOrderTable.getRowCount();
                if (Rawcount != 0) {
                    Index = Rawcount + 1;
                }

                if (SPItemNameORCodeLable.getText().equals("Item Code")) {
                    v.add(Index);
                    v.add(SPSearchItemNameORCodeCB.getSelectedItem());
                    v.add(SPItemNameOrCodeTF.getText());
                } else if (SPItemNameORCodeLable.getText().equals("Item Name")) {
                    v.add(Index);
                    v.add(SPItemNameOrCodeTF.getText());
                    v.add(SPSearchItemNameORCodeCB.getSelectedItem());
                }

                if (ItemCat.equals("Roofing Sheet")) {

                    if (SPRFSheetQtyTF.getText().isEmpty() || SPRFSheetQtyTF.getText().equals("0")) {
                        JOptionPane.showMessageDialog(null, "Please Enter Ordered Item Quantity");

                    } else {

                        v.add("-");
                        v.add(SPRFSheetColourCombo.getSelectedItem().toString());
                        v.add(SPRFSheetUnit01CB.getSelectedItem().toString());
                        v.add(SPRFSheetSizeTF.getText());
                        v.add(SPRFSheetUnit02CB.getSelectedItem().toString());
                        v.add(SPRFSheetSizeConvertedTF.getText());
                        v.add("-");
                        v.add("-");
                        v.add("-");
                        v.add("-");
                        v.add(SPRFSheetQtyTF.getText());
                        v.add(SPRFSheetRateTF.getText());
                        v.add(SPRFSheetAmountTF.getText());

                        SPCurveRFShtUnit01CB.setSelectedItem(SPRFSheetUnit01CB.getSelectedItem().toString());
                        SPCurveRFShtUnit02CB.setSelectedItem(SPRFSheetUnit02CB.getSelectedItem().toString());

                        SPRFSheetUnit01CB.setEnabled(false);
                        SPRFSheetUnit02CB.setEnabled(false);
                        SPCurveRFShtUnit01CB.setEnabled(false);
                        SPCurveRFShtUnit02CB.setEnabled(false);
                    }
                } else if (ItemCat.equals("Curved Roofing Sheet")) {

                    if (SPCurveRFShtQtyTF.getText().isEmpty() || SPCurveRFShtQtyTF.getText().equals("0")) {
                        JOptionPane.showMessageDialog(null, "Please Enter Ordered Item Quantity");

                    } else {

                        v.add("-");
                        v.add(SPCurveRFShtColourCombo.getSelectedItem().toString());
                        v.add(SPCurveRFShtUnit01CB.getSelectedItem().toString());
                        v.add(SPCurveRFShtSizeCB.getText());
                        v.add(SPCurveRFShtUnit02CB.getSelectedItem().toString());
                        v.add(SPCurveRFConvertedSizeTF.getText());
                        v.add(SPCurveRFShtCurveWidthTF.getText());
                        v.add("-");
                        v.add("-");
                        v.add("-");
                        v.add(SPCurveRFShtQtyTF.getText());
                        v.add(SPCurveRFShtRateTF.getText());
                        v.add(SPCurveRFShtAmountTF.getText());

                        SPRFSheetUnit01CB.setSelectedItem(SPCurveRFShtUnit01CB.getSelectedItem().toString());
                        SPRFSheetUnit02CB.setSelectedItem(SPCurveRFShtUnit02CB.getSelectedItem().toString());

                        SPRFSheetUnit01CB.setEnabled(false);
                        SPRFSheetUnit02CB.setEnabled(false);
                        SPCurveRFShtUnit01CB.setEnabled(false);
                        SPCurveRFShtUnit02CB.setEnabled(false);

                    }
                } else if (ItemCat.equals("Roller Door")) {
                    v.add("-");
                    v.add(SPRollerDoorColourCombo.getSelectedItem().toString());
                    v.add("-");
                    v.add("-");
                    v.add("-");
                    v.add("-");
                    v.add("-");
                    v.add(SPRollerDoorHeightTF.getText());
                    v.add(SPRollerDoorWidthTF.getText());
                    v.add(SPRollerDoorWidthHeightUnitCB.getSelectedItem().toString());
                    v.add(SPRollerDoorQtyTF.getText());
                    v.add(SPRollerDoorRateTF.getText());
                    v.add(SPRollerDoorAmountTF.getText());

                } else if (ItemCat.equals("Roller Shutter")) {
                    v.add("-");
                    v.add(SPRollerShutterColourCombo.getSelectedItem().toString());
                    v.add("-");
                    v.add("-");
                    v.add("-");
                    v.add("-");
                    v.add("-");
                    v.add(SPRollerShutterHeightTF.getText());
                    v.add(SPRollerShutterWidthTF.getText());
                    v.add(SPRollerShutterWidthHeightUnitCB.getSelectedItem().toString());
                    v.add(SPRollerShutterQtyTF.getText());
                    v.add(SPRollerShutterRateTF.getText());
                    v.add(SPRollerShutterAmountTF.getText());

                } else if (ItemCat.equals("Purlin")) {
                    v.add(SPPurlinThiknessTF.getText());
                    v.add(SPPurlinColourCB.getSelectedItem().toString());
                    v.add(SPPurlinUnitCB.getSelectedItem().toString());
                    v.add(SPPurlinLengthTF.getText());
                    v.add("-");
                    v.add("-");
                    v.add("-");
                    v.add("-");
                    v.add("-");
                    v.add("-");
                    v.add(SPPurlinQtyTF.getText());
                    v.add(SPPurlinRateTF.getText());
                    v.add(SPPurlinAmountTF.getText());

                } else if (ItemCat.equals("Gutter")) {
                    v.add(SPGutterThiknessTF.getText());
                    v.add(SPGutterColourCB.getSelectedItem().toString());
                    v.add(SPGutterUnitCB.getSelectedItem().toString());
                    v.add(SPGutterLengthTF.getText());
                    v.add("-");
                    v.add("-");
                    v.add("-");
                    v.add("-");
                    v.add("-");
                    v.add("-");
                    v.add(SPGutterQtyTF.getText());
                    v.add(SPGutterRateTF.getText());
                    v.add(SPGutterAmountTF.getText());

                } else if (ItemCat.equals("Gate")) {
                    v.add("-");
                    v.add(SPRFSheetColourCombo.getSelectedItem().toString());
                    v.add(SPRFSheetUnit01CB.getSelectedItem().toString());
                    v.add(SPRFSheetSizeTF.getText());
                    v.add(SPRFSheetUnit02CB.getSelectedItem().toString());
                    v.add(SPRFSheetSizeConvertedTF.getText());
                    v.add("-");
                    v.add("-");
                    v.add("-");
                    v.add("-");
                    v.add(SPRFSheetQtyTF.getText());
                    v.add(SPRFSheetRateTF.getText());
                    v.add(SPRFSheetAmountTF.getText());

                } else if (ItemCat.equals("Plain Sheet")) {
                    v.add("-");
                    v.add(SPPlainSheetColourCB.getSelectedItem().toString());
                    v.add(SPPlainSheetUnit01CB.getSelectedItem().toString());
                    v.add(SPPlainSheetSizeTF.getText());
                    v.add(SPPlainSheetUnit02CB.getSelectedItem().toString());
                    v.add(SPPlainSheetConvertedTF.getText());
                    v.add("-");
                    v.add("-");
                    v.add("-");
                    v.add("-");
                    v.add(SPPlainSheetQtyTF.getText());
                    v.add(SPPlainSheetRateTF.getText());
                    v.add(SPPlainSheetAmountTF.getText());

                } else if (ItemCat.equals("Cladding")) {
                    v.add("-");
                    v.add(SPCladdingColourCB.getSelectedItem().toString());
                    v.add(SPCladdingUnit01CB.getSelectedItem().toString());
                    v.add(SPCladdingSizeTF.getText());
                    v.add(SPCladdingUnit02CB.getSelectedItem().toString());
                    v.add(SPCladdingConvertedTF.getText());
                    v.add("-");
                    v.add("-");
                    v.add("-");
                    v.add("-");
                    v.add(SPCladdingQtyTF.getText());
                    v.add(SPCladdingRateTF.getText());
                    v.add(SPCladdingAmountTF.getText());
                }

                DTM.addRow(v);
            }

            SalesTotalAmountTF.setText(Double.toString(TotalAmount()));
            CalculateTax();

            SPPayMethodCashTotalPayTF.setText(SPNetAmountTF.getText());

        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }

    }
    //Add items to Table - Sales Panel Method END

    //Add Items To Table - Sales Panel Switch Case Method Start
//    public void AddDataToSalesTable() {
//        try {
//            DefaultTableModel DTM = (DefaultTableModel) SPCustomerOrderTable.getModel();
//
//            Vector v = new Vector();
//            int Index = 1;
//
//            int Rawcount = SPCustomerOrderTable.getRowCount();
//            
//            if (Rawcount != 0) {
//                        Index = Rawcount + 1;
//                    }
//            
//            if (SPItemNameORCodeLable.getText().equals("Item Code")) {
//                switch (0) {
//                    case 0:
//                        v.add(Index);
//                        break;
//
//                    case 1:
//                        v.add(SPSearchItemNameORCodeCB.getSelectedItem());
//                        break;
//
//                    case 2:
//                        v.add("");
//                        break;
//
//                    case 3:
//                        v.add(SPRFSheetColourCombo.getSelectedItem().toString());
//                        break;
//
//                    case 4:
//                        v.add(SPRFSheetUnit01CB.getSelectedItem().toString());
//                        break;
//
//                    case 5:
//                        v.add(SPRFSheetSizeTF.getText());
//                        break;
//
//                    case 6:
//                        v.add(SPRFSheetUnit02CB.getSelectedItem().toString());
//                        break;
//
//                    case 7:
//                        v.add(SPRFSheetSizeConvertedTF.getText());
//                        break;
//
//                    case 8:
//                        v.add("");
//                        break;
//
//                    case 9:
//                        v.add("");
//                        break;
//
//                    case 10:
//                        v.add("");
//                        break;
//
//                    case 11:
//                        v.add("");
//                        break;
//
//                    case 12:
//                        v.add(SPRFSheetQtyTF.getText());
//                        break;
//
//                    case 13:
//                        v.add(SPRFSheetRateTF.getText());
//                        break;
//                    case 14:
//                        v.add(SPRFSheetAmountTF.getText());
//                        break;
//                    case 15:
//                        v.add("");
//                        break;
//                    case 16:
//                        v.add("");
//                        break;
//
//                }
//            }
//        } catch (Exception e) {
//            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
//        }
//    }
    //Add Items To Table - Sales Panel Switch Case Method END
    //Remove Selected raw deatails only from table - Sales Panel Method Start
    public void RemoveSelectedRawMethod() {
        try {
            int i = SPCustomerOrderTable.getSelectedRow();
            DefaultTableModel dtm = (DefaultTableModel) SPCustomerOrderTable.getModel();

            if (SPCustomerOrderTable.getSelectedRowCount() == 0) {

                JOptionPane.showMessageDialog(null, "Please Select a raw which you want to Delete.");

            } else {

                dtm.removeRow(i);
            }
        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    //Remove Selected raw deatails only from table - Sales Panel Method END
    //Remove All Details From Table- Sales Panel Method Start
    public void RemoveAllFromTable() {
        try {
            if (SPCustomerOrderTable.getRowCount() == 0) {

                JOptionPane.showMessageDialog(null, "Please Add one or more items");

            } else {
                DefaultTableModel dtm = (DefaultTableModel) SPCustomerOrderTable.getModel();
                dtm.setRowCount(0);
            }
        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    //Remove All Details From Table- Sales Panel Method END
    //Calculate total Amount of Customer order - Sales Panel Method Start
    public double TotalAmount() {

        double rawcount = SPCustomerOrderTable.getRowCount();
        double sum = 0;
        for (int i = 0; i < rawcount; i++) {

            sum = sum + Double.parseDouble(SPCustomerOrderTable.getValueAt(i, 15).toString());
        }
        DecimalFormat df = new DecimalFormat("#.##");
        sum = Double.valueOf(df.format(sum));

        return sum;
    }
    //Calculate total Amount of Customer order - Sales Panel Method END

    //Auto Load Customer Name or ID to Customer Details Combo box Sales Panel Method Start
    public void LoadCustomerNameOrIDToSalesPanel() {
        try {
            SPCustomerSearchCB.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {

                    if (e.getKeyCode() != KeyEvent.VK_ENTER && e.getKeyCode() != KeyEvent.VK_UP && e.getKeyCode() != KeyEvent.VK_DOWN && e.getKeyCode() != KeyEvent.VK_SHIFT) {

                        String TypedTxt = SPCustomerSearchCB.getEditor().getItem().toString();

                        if (!TypedTxt.isEmpty()) {

                            try {
                                SPCustomerSearchCB.removeAllItems();
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
                                SPCustomerSearchCB.setModel(dcm);

                                SPCustomerSearchCB.getEditor().setItem(TypedTxt);
                                SPCustomerSearchCB.setSelectedItem(TypedTxt);
                                JTextField TextField = (JTextField) e.getSource();
                                TextField.setCaretPosition(TextField.getDocument().getLength());

                                if (st != 0) {
                                    SPCustomerSearchCB.showPopup();

                                    if (st > 10) {
                                        SPCustomerSearchCB.setMaximumRowCount(10);
                                    } else {
                                        SPCustomerSearchCB.setMaximumRowCount(st);
                                    }
                                } else {
                                    SPCustomerSearchCB.hidePopup();
                                }

                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(null, ex);
                            }
                        } else {
                            SPCustomerSearchCB.hidePopup();
                            SPCustomerSearchCB.removeAllItems();
                        }
                    }
                }
            });
        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    //Auto Load Customer Name or ID to Customer Details Combo box Sales Panel Method END

    //Load Customer Details to Relavant Feilds in Sales Panel - Method Start
    public void LoadCustomerDetailsToSalesPanel() {
        try {

            if (SPCustomerSearchCB.getSelectedIndex() != -1) {
                //Cheking if any item is selected.
                String TypedText = SPCustomerSearchCB.getSelectedItem().toString();

                Statement s = (Statement) SeldoDB.GetMyConnection().createStatement();
                ResultSet rs = s.executeQuery("SELECT * FROM customer WHERE NIC = '" + TypedText + "' ");

                if (rs.next()) {

                    rs = s.executeQuery("SELECT * FROM customer WHERE NIC = '" + TypedText + "' ");
                    if (rs.next()) {

                        String CusID = rs.getString("CusID");
                        String CusName = rs.getString("CusName");
                        String ContactNo = rs.getString("ContactNo");
                        String Address = rs.getString("Address");

                        SPCustomerIDTF.setText(CusID);
                        SPCustomerNameorNICNoTF.setText(CusName);
                        SPContactNoTF.setText(ContactNo);
                        SPAddresTA.setText(Address);
                        SPCustomerNameorNICNoLabel.setText("Customer Name"); //set Label >>> Name or NIC No. to Customer Name.
                        SPCustomerNameLable.setText("Customer NIC No.");
                    }
                } else {

                    String CusName = TypedText;
                    ResultSet RS = s.executeQuery("SELECT * FROM customer WHERE CusName='" + CusName + "' ");

                    if (RS.next()) {

                        String CusID = RS.getString("CusID");
                        String NICNo = RS.getString("NIC");
                        String ContactcNo = RS.getString("ContactNo");
                        String Address = RS.getString("Address");

                        SPCustomerIDTF.setText(CusID);
                        SPCustomerNameorNICNoTF.setText(NICNo);
                        SPContactNoTF.setText(ContactcNo);
                        SPAddresTA.setText(Address);
                        SPCustomerNameorNICNoLabel.setText("Customer NIC No."); //set Label >>> Name or NIC No. to Customer NIC No..
                    }
                }
            } else {    //if no item selected in combo box
                SPCustomerNameorNICNoLabel.setText("Customer NIC No.");
                SPCustomerNameLable.setText("Customer Name");
                SPCustomerNameorNICNoTF.setText(null);
                SPContactNoTF.setText(null);
                SPAddresTA.setText(null);
                SPCustomerIDTF.setText(null);
            }
        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    //Load Customer Details to Relavant Feilds in Sales Panel - Method END
    //Payment Method Combo box Code for Changing relevant Panel (Cash Credit Cheque) - Method Start
    public void PaymentMethods() {

        try {
            if (SPPaymentMethodsCB.getSelectedItem().equals("Cash")) {
                SPPaymentMethodsPnl.setVisible(true);
                CashDetailsPnl.setVisible(true);
                SPChequeDetailsPnl.setVisible(false);
                SPCreditDetailsPnl.setVisible(false);

                SPChequeNoTF.setText(null);
                SPChequeAmountTF.setText(null);
                SPBankNameTF.setText(null);
                SPChequeDateDC.setDate(null);

            } else if (SPPaymentMethodsCB.getSelectedItem().equals("Credit")) {
                SPPaymentMethodsPnl.setVisible(true);
                CashDetailsPnl.setVisible(false);
                SPChequeDetailsPnl.setVisible(false);
                SPCreditDetailsPnl.setVisible(true);

                SPPaymentMethodCreditContactTF.setText(SPContactNoTF.getText());

                if (SPCustomerNameLable.getText().equals("Customer Name")) {
                    SPPaymentMethodCreditNICTF.setText(SPCustomerNameorNICNoTF.getText());
                } else {
                    SPPaymentMethodCreditNICTF.setText(SPCustomerSearchCB.getSelectedItem().toString());
                }

                SPChequeNoTF.setText(null);
                SPChequeAmountTF.setText(null);
                SPBankNameTF.setText(null);
                SPChequeDateDC.setDate(null);

            } else if (SPPaymentMethodsCB.getSelectedItem().equals("Cheque")) {
                SPPaymentMethodsPnl.setVisible(true);
                CashDetailsPnl.setVisible(false);
                SPCreditDetailsPnl.setVisible(false);
                SPChequeDetailsPnl.setVisible(true);

                SPChequeNoTF.setText(null);
                SPChequeAmountTF.setText(null);
                SPBankNameTF.setText(null);
                SPChequeDateDC.setDate(null);
            }
        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }
//Payment Method Combo box Code for Changing relevant Panel (Cash Credit Cheque) - Method END
//Add Sales Details To Data Base - Sales table Method Start

    public void AddDataToSalesDB() {
        try {
            Statement st = (Statement) SeldoDB.GetMyConnection().createStatement();

            for (int i = 0; i < SPCustomerOrderTable.getRowCount(); i++) {
                String LineNo = SPCustomerOrderTable.getValueAt(i, 0).toString();
                String IName = SPCustomerOrderTable.getValueAt(i, 1).toString();
                String ICode = SPCustomerOrderTable.getValueAt(i, 2).toString();
                String Thikness = SPCustomerOrderTable.getValueAt(i, 3).toString();
                String Colour = SPCustomerOrderTable.getValueAt(i, 4).toString();
                String EntUnit = SPCustomerOrderTable.getValueAt(i, 5).toString();
                String EntSize = SPCustomerOrderTable.getValueAt(i, 6).toString();
                String SelUnit = SPCustomerOrderTable.getValueAt(i, 7).toString();
                String SelSize = SPCustomerOrderTable.getValueAt(i, 8).toString();
                String CurveWidth = SPCustomerOrderTable.getValueAt(i, 9).toString();
                String Height = SPCustomerOrderTable.getValueAt(i, 10).toString();
                String Width = SPCustomerOrderTable.getValueAt(i, 11).toString();
                String UnitOfHeightWidth = SPCustomerOrderTable.getValueAt(i, 12).toString();
                String Qty = SPCustomerOrderTable.getValueAt(i, 13).toString();
                String Rate = SPCustomerOrderTable.getValueAt(i, 14).toString();
                String Amount = SPCustomerOrderTable.getValueAt(i, 15).toString();

                String DateAndTime = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(Calendar.getInstance().getTime());

                String SONumber = SPSalesOrderNo.getText();
                String PayMethod = SPPaymentMethodsCB.getSelectedItem().toString();
                String TotAmount = SPNetAmountTF.getText();
                String ChequeNo = SPChequeNoTF.getText();
                String CusID = SPCustomerIDTF.getText();
                String TaxAmount = SPTaxAmountTF.getText();

                String UserName = UserNameDisplayLabel.getText(); //System User Details
                ResultSet rs = st.executeQuery("SELECT * From employee Where userAccount_UserName = '" + UserName + "' ");
                rs.next();
                String BranchIDString = MainPanelBranchIDLable.getText();

                st.executeUpdate("INSERT INTO sale (SONumber, LineNo, PayMethod, ItemCode, ItemName,"
                        + " ItemColor, Quantity, Unit01, SizeOfUnit01, Unit02,"
                        + " SizeOfUnit02, Rate, Amount, TotAmount, TaxAmount,"
                        + " ChequeNo, DateTime, customer_CusID, branch_BraID ,Thikness,"
                        + " CurveWidth,Height,Width, UnitOfHeightWidth ) "
                        + " Values ('" + SONumber + "' , '" + LineNo + "' , '" + PayMethod + "' , '" + ICode + "' ,'" + IName + "' ,"
                        + " '" + Colour + "', '" + Qty + "', '" + EntUnit + "', '" + EntSize + "', '" + SelUnit + "',"
                        + " '" + SelSize + "', '" + Rate + "', '" + Amount + "' , '" + TotAmount + "','" + TaxAmount + "',"
                        + " '" + ChequeNo + "','" + DateAndTime + "', '" + CusID + "' , '" + BranchIDString + "' ,"
                        + " '" + Thikness + "' , '" + CurveWidth + "' , '" + Height + "' , '" + Width + "' , '" + UnitOfHeightWidth + "')");
            }
        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }
//Add Sales Details To Data Base - Sales table Method END
//Add Customer Details To Database - Sales Panel Method Start

    public void AddDataToCustomerDB() {
// Take Code from Tharindu (pending..)
        try {

            String TypedCusDetail = SPCustomerSearchCB.getSelectedItem().toString();

            Statement s = (Statement) SeldoDB.GetMyConnection().createStatement();
            ResultSet RS = s.executeQuery("Select * from customer Where NIC='" + TypedCusDetail + "' || CusName='" + TypedCusDetail + "' ");

            if (RS.next()) {

            } else {
                String CusName = SPCustomerSearchCB.getSelectedItem().toString();
                String CusNIC = SPCustomerNameorNICNoTF.getText();
                String CusID = SPCustomerIDTF.getText();
                String CusContact = SPContactNoTF.getText();
                String CusAddress = SPAddresTA.getText();

                s.executeUpdate("INSERT into customer (CusID, NIC, CusName, ContactNo, Address) values ('" + CusID + "' , '" + CusNIC + "' , '" + CusName + "' , '" + CusContact + "' , '" + CusAddress + "') ");
            }

        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }
//Add Customer Details To Database - Sales Panel Method END    

//Auto Genarate customer ID - Sales panel Method Start
    public void AutoGenCusID() {
        try {
            Statement s = (Statement) SeldoDB.GetMyConnection().createStatement();
            ResultSet RS = s.executeQuery("SELECT MAX(CusID) from customer");
            if (RS.next()) {
                String MAXCusID = RS.getString("MAX(CusID)");

                if (MAXCusID == null) {
                    SPCustomerIDTF.setText("CUSID0000000001");
                } else {

                    MAXCusID = MAXCusID.substring(5, 15);
                    int MAXCusIDInt = Integer.parseInt(MAXCusID);
                    MAXCusIDInt++;
                    MAXCusID = Integer.toString(MAXCusIDInt);
                    while (MAXCusID.length() < 10) {
                        MAXCusID = "0" + MAXCusID;
                    }
                    MAXCusID = "CUSID" + MAXCusID;
                    SPCustomerIDTF.setText(MAXCusID);
                }
            } else {
                SPCustomerIDTF.setText("CUSID0000000001");
            }
        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }
//Auto Genarate customer ID - Sales panel Method END
// Add data to Cheque data base - Sales Pane Method start

    public void AddDataToChequeDB() {
        try {

            if (SPPaymentMethodsCB.getSelectedItem().toString().equals("Cheque")) {

                SimpleDateFormat sdf = new SimpleDateFormat("EEEEE / dd / MMMMM / yyyy");
                String selectedDate = sdf.format(SPChequeDateDC.getDate());

                Statement s = (Statement) SeldoDB.GetMyConnection().createStatement();
                s.executeUpdate("INSERT into cheque (ChequeNO , Bank , Date , customer_CusID) values ('" + SPChequeNoTF.getText() + "' , '" + SPBankNameTF.getText() + "' , '" + selectedDate + "' , '" + SPCustomerIDTF.getText() + "')");
            }
        } catch (Exception e) {

            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }

    }
// Add data to Cheque data base - Sales Panel Method END   

//Add Details To Payment Table in data base - Sales Panel Method Start 
    public void AddDataToPayment() {
        try {
            String DateAndTime = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(Calendar.getInstance().getTime());
            String PaymentMethod = SPPaymentMethodsCB.getSelectedItem().toString();
            if (PaymentMethod.equals("Credit")) {

                String CusID = SPCustomerIDTF.getText();
                String SONo = SPSalesOrderNo.getText();
                String NICNo = SPPaymentMethodCreditNICTF.getText();
                Double Total = Double.parseDouble(SPNetAmountTF.getText());
                Double FirstPayment = Double.parseDouble(SPPaymentMethodFirstPaymentTF.getText());

                Statement s = (Statement) SeldoDB.GetMyConnection().createStatement();
                s.executeUpdate("INSERT into Payment (LineNo, DateTime, CusID, SONumber, NICNo, TotalAmount, Instalment, SumOfInstalment, ChequeNO)"
                        + "Values ('" + "1" + "' , '" + DateAndTime + "' , '" + CusID + "' , '" + SONo + "' , '" + NICNo + "' , '" + Total + "' , '" + FirstPayment + "' , '" + FirstPayment + "' , '" + "" + "') ");

            } else if (PaymentMethod.equals("Cheque")) {

                String CusID = SPCustomerIDTF.getText();
                String SONo = SPSalesOrderNo.getText();
                Double Total = Double.parseDouble(SPNetAmountTF.getText());
                Double ChequeAmount = Double.parseDouble(SPChequeAmountTF.getText());
                String ChequeNo = SPChequeNoTF.getText();

                if (SPCustomerNameorNICNoLabel.getText().equals("Customer Name")) {
                    String NICNo = SPCustomerSearchCB.getSelectedItem().toString();
                    Statement s = (Statement) SeldoDB.GetMyConnection().createStatement();
                    s.executeUpdate("INSERT into Payment (LineNo, DateTime, CusID, SONumber, NICNo, TotalAmount, Instalment, SumOfInstalment, ChequeNO)"
                            + "Values ('" + "1" + "' , '" + DateAndTime + "' , '" + CusID + "' , '" + SONo + "' , '" + NICNo + "' , '" + Total + "' , '" + ChequeAmount + "' , '" + ChequeAmount + "' , '" + ChequeNo + "') ");

                } else {
                    String NICNo = SPCustomerNameorNICNoTF.getText();

                    Statement s = (Statement) SeldoDB.GetMyConnection().createStatement();
                    s.executeUpdate("INSERT into Payment (LineNo, DateTime, CusID, SONumber, NICNo, TotalAmount, Instalment, SumOfInstalment, ChequeNO)"
                            + "Values ('" + "1" + "' , '" + DateAndTime + "' , '" + CusID + "' , '" + SONo + "' , '" + NICNo + "' , '" + Total + "' , '" + ChequeAmount + "' , '" + ChequeAmount + "' , '" + ChequeNo + "') ");
                }
            }
        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }
//Add Details To Payment Table in data base - Sales Panel Method END

// Calculate TAX - Sales Panel Method Start
    public void CalculateTax() {
        try {

            if (SPTaxPercentageTF.getText().isEmpty() || SPTaxPercentageTF.getText() == null) {
                SPTaxPercentageTF.setText("0");
            }

            Double TotalDouble = Double.valueOf(SalesTotalAmountTF.getText());
            Double TaxPercentageDouble = Double.valueOf(SPTaxPercentageTF.getText());
            Double TaxAmountDouble = TotalDouble * TaxPercentageDouble / 100;
            Double NetAmount = TaxAmountDouble + TotalDouble;

            DecimalFormat df = new DecimalFormat("#.##");
            TaxAmountDouble = Double.valueOf(df.format(TaxAmountDouble));
            NetAmount = Double.valueOf(df.format(NetAmount));

            SPTaxAmountTF.setText(String.valueOf(TaxAmountDouble));
            SPNetAmountTF.setText(String.valueOf(NetAmount));

        } catch (NumberFormatException e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }
// Calculate TAX - Sales Panel Method END

    //Print Customer Bill Code Roofing Sheet Catogary - Start//
    private void Printcode() {
        try {
            String ReportSource = "C:\\SELDO\\Reports_V_01\\SeldoReports\\SalesReportNew.jrxml";
            Map<String, Object> params = new HashMap<>();

            params.put("Unit01Para", SPRFSheetUnit01CB.getSelectedItem().toString());
            params.put("Unit02Para", SPRFSheetUnit02CB.getSelectedItem().toString());
            params.put("SONumberPara", SPSalesOrderNo.getText());
            params.put("CusIDPara", SPCustomerIDTF.getText());
            params.put("TaxRate", SPTaxPercentageTF.getText());

            String PayMethod = SPPaymentMethodsCB.getSelectedItem().toString();

            switch (PayMethod) {
                case "Credit": {
                    Double PaymentAmount = Double.valueOf(SPPaymentMethodFirstPaymentTF.getText());
                    Double TotalAmount = Double.valueOf(SPNetAmountTF.getText());
                    Double DueBal = TotalAmount - PaymentAmount;
                    params.put("PaymentsPara", PaymentAmount);
                    params.put("DueBalancePara", DueBal);
                    break;
                }
                case "Cheque": {
                    Double PaymentAmount = Double.valueOf(SPChequeAmountTF.getText());
                    Double TotalAmount = Double.valueOf(SPNetAmountTF.getText());
                    Double DueBal = TotalAmount - PaymentAmount;
                    params.put("PaymentsPara", PaymentAmount);
                    params.put("DueBalancePara", DueBal);
                    break;
                }
                case "Cash": {
                    double duebalanceZero = 0.00;
                    Double PaymentAmount = Double.valueOf(SPPayMethodCashTotalPayTF.getText());
                    params.put("PaymentsPara", PaymentAmount);
                    params.put("DueBalancePara", duebalanceZero);
                    break;
                }
                default:
                    break;
            }

            try {
                if (SPPaymentMethodsCB.getSelectedItem().equals("Cheque")) {
                    params.put("ChequeNoPara", SPChequeNoTF.getText());
                } else {
                    params.put("ChequeNoPara", "-");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Add Cheque details");
                Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
            }

            JasperReport jasperReport = JasperCompileManager.compileReport(ReportSource);

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.1.1:3306/seldo?useseldo=true&characterEncoding=UTF-8", "root", "123")) {
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, conn);
                JasperViewer.viewReport(jasperPrint, false); // with print preview

//                JasperPrintManager.printReport(jasperPrint, false); // Direct print without preview
            }
        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    //Print Customer Bill Code Roofing Sheet Catogary - END//
    
    //Print Customer Bill Code Door  -Door Report- Start//
    private void AccessoriesPrint() {
        try {
            String ReportSource = "C:\\SELDO\\Reports_V_01\\SeldoReports\\Accessories.jrxml";
            Map<String, Object> params = new HashMap<>();

            params.put("Unit01Para", SPRFSheetUnit01CB.getSelectedItem().toString());
            params.put("Unit02Para", SPRFSheetUnit02CB.getSelectedItem().toString());
            params.put("SONumberPara", SPSalesOrderNo.getText());
            params.put("CusIDPara", SPCustomerIDTF.getText());
            params.put("TaxRate", SPTaxPercentageTF.getText());

            String PayMethod = SPPaymentMethodsCB.getSelectedItem().toString();

            switch (PayMethod) {
                case "Credit": {
                    Double PaymentAmount = Double.valueOf(SPPaymentMethodFirstPaymentTF.getText());
                    Double TotalAmount = Double.valueOf(SPNetAmountTF.getText());
                    Double DueBal = TotalAmount - PaymentAmount;
                    params.put("PaymentsPara", PaymentAmount);
                    params.put("DueBalancePara", DueBal);
                    break;
                }
                case "Cheque": {
                    Double PaymentAmount = Double.valueOf(SPChequeAmountTF.getText());
                    Double TotalAmount = Double.valueOf(SPNetAmountTF.getText());
                    Double DueBal = TotalAmount - PaymentAmount;
                    params.put("PaymentsPara", PaymentAmount);
                    params.put("DueBalancePara", DueBal);
                    break;
                }
                case "Cash": {
                    double duebalanceZero = 0.00;
                    Double PaymentAmount = Double.valueOf(SPPayMethodCashTotalPayTF.getText());
                    params.put("PaymentsPara", PaymentAmount);
                    params.put("DueBalancePara", duebalanceZero);
                    break;
                }
                default:
                    break;
            }

            try {
                if (SPPaymentMethodsCB.getSelectedItem().equals("Cheque")) {
                    params.put("ChequeNoPara", SPChequeNoTF.getText());
                } else {
                    params.put("ChequeNoPara", "-");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Add Cheque details");
                Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
            }

            JasperReport jasperReport = JasperCompileManager.compileReport(ReportSource);

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.1.1:3306/seldo?useseldo=true&characterEncoding=UTF-8", "root", "123")) {
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, conn);
                JasperViewer.viewReport(jasperPrint, false); // with print preview

//                JasperPrintManager.printReport(jasperPrint, false); // Direct print without preview
            }
        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    //Print Customer Bill Code Door  -Door Report- END//
    
    //Print Customer Bill Code Roller Doors And Shutters - Start//
    private void PrintRollerDoorsAndShutters() {
        try {
            String ReportSource = "C:\\SELDO\\Reports_V_01\\SeldoReports\\RollerDoors.jrxml";
            Map<String, Object> params = new HashMap<>();

            params.put("SONumberPara", SPSalesOrderNo.getText());
            params.put("CusIDPara", SPCustomerIDTF.getText());
            params.put("TaxRate", SPTaxPercentageTF.getText());

            String PayMethod = SPPaymentMethodsCB.getSelectedItem().toString();

            switch (PayMethod) {
                case "Credit": {
                    Double PaymentAmount = Double.valueOf(SPPaymentMethodFirstPaymentTF.getText());
                    Double TotalAmount = Double.valueOf(SPNetAmountTF.getText());
                    Double DueBal = TotalAmount - PaymentAmount;
                    params.put("PaymentsPara", PaymentAmount);
                    params.put("DueBalancePara", DueBal);
                    break;
                }
                case "Cheque": {
                    Double PaymentAmount = Double.valueOf(SPChequeAmountTF.getText());
                    Double TotalAmount = Double.valueOf(SPNetAmountTF.getText());
                    Double DueBal = TotalAmount - PaymentAmount;
                    params.put("PaymentsPara", PaymentAmount);
                    params.put("DueBalancePara", DueBal);
                    break;
                }
                case "Cash": {
                    double duebalanceZero = 0.00;
                    Double PaymentAmount = Double.valueOf(SPPayMethodCashTotalPayTF.getText());
                    params.put("PaymentsPara", PaymentAmount);
                    params.put("DueBalancePara", duebalanceZero);
                    break;
                }
                default:
                    break;
            }

            try {
                if (SPPaymentMethodsCB.getSelectedItem().equals("Cheque")) {
                    params.put("ChequeNoPara", SPChequeNoTF.getText());
                } else {
                    params.put("ChequeNoPara", "-");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Add Cheque details");
                Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
            }

            JasperReport jasperReport = JasperCompileManager.compileReport(ReportSource);

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.1.1:3306/seldo?useseldo=true&characterEncoding=UTF-8", "root", "123")) {
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, conn);
                JasperViewer.viewReport(jasperPrint, false); // with print preview

//                JasperPrintManager.printReport(jasperPrint, false); // Direct print without preview
            }
        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    //Print Customer Bill Code Roller Doors And Shutters - END//
    
    //Print Button in Sales Panel All Methods Start//
    public void PrintButtonActions() {
        try {
            Statement s = (Statement) SeldoDB.GetMyConnection().createStatement();
            ResultSet rs = s.executeQuery("SELECT ChequeNO from cheque where ChequeNO = '" + SPChequeNoTF.getText() + "' ");
            if (rs.next()) {
                JOptionPane.showConfirmDialog(rootPane, "This Cheque Number is already used");
            } else {
                String SelectedCustomer = SPCustomerIDTF.getText();
                ResultSet rs2 = s.executeQuery("SELECT * FROM payment Where CusID = '" + SelectedCustomer + "' ");
                String PaymentMethod = SPPaymentMethodsCB.getSelectedItem().toString();
                if ((PaymentMethod.equals("Cheque") || PaymentMethod.equals("Credit")) && rs2.next()) {
                    new ErrorMassages().setVisible(true);
                } 
                else {

                    AddDataToCustomerDB();
                    AddDataToChequeDB();
                    AddDataToPayment();
                    AddDataToSalesDB();

                    //Print Data to jasper reports By Item catogary . Method Start   
                    String SelectedCat = SPItemCatComboBox.getSelectedItem().toString();
                    if (SelectedCat.equals("Roofing Sheet") || SelectedCat.equals("Curved Roofing Sheet") || SelectedCat.equals("Plain Sheet") || SelectedCat.equals("Cladding")) {

                        Printcode();

                    } else if (SelectedCat.equals("Purlin") || SelectedCat.equals("Gutter")) {
                        
                        AccessoriesPrint();
                        
                    } else if(SelectedCat.equals("Roller Door") || SelectedCat.equals("Roller Shutter")){
                        //Print code for Roller Shutters and Doors.
                        PrintRollerDoorsAndShutters();
                        
                    }

                    //Print Data to jasper reports By Item catogary . Method END
                    RemoveAllFromTable();
                    SalesTotalAmountTF.setText("0");
                    SPNetAmountTF.setText("0");
                    SPTaxPercentageTF.setText("0");
                    SPTaxAmountTF.setText("0");
                    SPTaxPercentageTF.setText("0");

                    SPCustomerSearchCB.setSelectedItem("Please Type Customer Name");
                    SPPaymentMethodFirstPaymentTF.setText(null);
                    SPSearchItemNameORCodeCB.setSelectedItem("Please type Item Name or Code");
                    AutoGenSalesOrderNo();
                }
            }
        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    //Print Button in Sales Panel All Methods END//
    // Customer Details Search combo box Methood Start
    public void CustomerComboBox() {
        try {
            if (SPCustomerSearchCB.getSelectedItem() != null) {
                String TypedTextOnCB = SPCustomerSearchCB.getSelectedItem().toString();
                Statement st = (Statement) SeldoDB.GetMyConnection().createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM customer where NIC = '" + TypedTextOnCB + "' || CusName = '" + TypedTextOnCB + "' ");
                if (rs.next()) {
                    LoadCustomerDetailsToSalesPanel();
                } else {
                    AutoGenCusID();
                    SPCustomerNameorNICNoTF.setText(null);
                    SPContactNoTF.setText(null);
                    SPAddresTA.setText(null);
                    SPCustomerNameLable.setText("Customer Name");
                    SPCustomerNameorNICNoLabel.setText("Customer NIC No.");
                }
            }

            PaymentMethods();

        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }
// Customer Details Search combo box Methood END
// Check Selected customer has or not pending payments - Method Start.

    public void CheckPendingPayment() {
        try {
            String SelectedCustomer = SPCustomerIDTF.getText();
            Statement s = (Statement) SeldoDB.GetMyConnection().createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM payment Where CusID = '" + SelectedCustomer + "' ");
            if (rs.next()) {
                new ErrorMassages().setVisible(true);
                //JOptionPane.showMessageDialog(rootPane, "This Customer has pending payments");
            }

        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }
// Check Selected customer has or not pending payments - Method END.
// Edit Colours in Sales panel - Method Start

    public void
            EditColours() {
        try {

        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }

//----- Sales Frame Methods END ------//
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SalesMainPanel = new javax.swing.JPanel();
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
        SPExpensesBtn = new javax.swing.JButton();
        SalesContentPanel = new javax.swing.JPanel();
        CPSalesPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        SPItemsDetailsPanel = new javax.swing.JPanel();
        IDPRoofingSheetPanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        SPRFSheetSizeTF = new javax.swing.JTextField();
        SPRFSheetSizeConvertedTF = new javax.swing.JTextField();
        SPRFSheetQtyTF = new javax.swing.JTextField();
        SPRFSheetRateTF = new javax.swing.JTextField();
        SPRFSheetAmountTF = new javax.swing.JTextField();
        SPRFSheetUnit02CB = new javax.swing.JComboBox<>();
        SPRFSheetUnit01CB = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        SPRFSheetColourCombo = new javax.swing.JComboBox<>();
        IDPCurvedRoofingSheetPanel = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        SPCurveRFShtSizeCB = new javax.swing.JTextField();
        SPCurveRFConvertedSizeTF = new javax.swing.JTextField();
        SPCurveRFShtCurveWidthTF = new javax.swing.JTextField();
        SPCurveRFShtRateTF = new javax.swing.JTextField();
        SPCurveRFShtAmountTF = new javax.swing.JTextField();
        SPCurveRFShtUnit02CB = new javax.swing.JComboBox<>();
        SPCurveRFShtUnit01CB = new javax.swing.JComboBox<>();
        jLabel56 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        SPCurveRFShtColourCombo = new javax.swing.JComboBox<>();
        jLabel68 = new javax.swing.JLabel();
        SPCurveRFShtQtyTF = new javax.swing.JTextField();
        jLabel71 = new javax.swing.JLabel();
        IDPRollerDoorPanel = new javax.swing.JPanel();
        jLabel86 = new javax.swing.JLabel();
        SPRollerDoorWidthTF = new javax.swing.JTextField();
        SPRollerDoorQtyTF = new javax.swing.JTextField();
        SPRollerDoorRateTF = new javax.swing.JTextField();
        SPRollerDoorAmountTF = new javax.swing.JTextField();
        jLabel111 = new javax.swing.JLabel();
        jLabel206 = new javax.swing.JLabel();
        jLabel216 = new javax.swing.JLabel();
        SPRollerDoorColourCombo = new javax.swing.JComboBox<>();
        jLabel236 = new javax.swing.JLabel();
        jLabel246 = new javax.swing.JLabel();
        SPRollerDoorHeightTF = new javax.swing.JTextField();
        SPRollerDoorWidthHeightUnitCB = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        IDPRollerShutterPanel = new javax.swing.JPanel();
        jLabel266 = new javax.swing.JLabel();
        SPRollerShutterWidthTF = new javax.swing.JTextField();
        SPRollerShutterQtyTF = new javax.swing.JTextField();
        SPRollerShutterRateTF = new javax.swing.JTextField();
        SPRollerShutterAmountTF = new javax.swing.JTextField();
        jLabel268 = new javax.swing.JLabel();
        jLabel269 = new javax.swing.JLabel();
        jLabel270 = new javax.swing.JLabel();
        SPRollerShutterColourCombo = new javax.swing.JComboBox<>();
        jLabel272 = new javax.swing.JLabel();
        jLabel273 = new javax.swing.JLabel();
        SPRollerShutterHeightTF = new javax.swing.JTextField();
        SPRollerShutterWidthHeightUnitCB = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        IDPPurlingPanel = new javax.swing.JPanel();
        jLabel275 = new javax.swing.JLabel();
        SPPurlinThiknessTF = new javax.swing.JTextField();
        SPPurlinQtyTF = new javax.swing.JTextField();
        SPPurlinRateTF = new javax.swing.JTextField();
        SPPurlinAmountTF = new javax.swing.JTextField();
        jLabel276 = new javax.swing.JLabel();
        jLabel277 = new javax.swing.JLabel();
        jLabel278 = new javax.swing.JLabel();
        jLabel279 = new javax.swing.JLabel();
        SPPurlinColourCB = new javax.swing.JComboBox<>();
        jLabel280 = new javax.swing.JLabel();
        jLabel282 = new javax.swing.JLabel();
        SPPurlinLengthTF = new javax.swing.JTextField();
        SPPurlinUnitCB = new javax.swing.JComboBox<>();
        IDPGutterPanel = new javax.swing.JPanel();
        jLabel283 = new javax.swing.JLabel();
        SPGutterThiknessTF = new javax.swing.JTextField();
        SPGutterQtyTF = new javax.swing.JTextField();
        SPGutterRateTF = new javax.swing.JTextField();
        SPGutterAmountTF = new javax.swing.JTextField();
        jLabel284 = new javax.swing.JLabel();
        jLabel285 = new javax.swing.JLabel();
        jLabel286 = new javax.swing.JLabel();
        jLabel287 = new javax.swing.JLabel();
        SPGutterColourCB = new javax.swing.JComboBox<>();
        jLabel288 = new javax.swing.JLabel();
        jLabel289 = new javax.swing.JLabel();
        SPGutterLengthTF = new javax.swing.JTextField();
        SPGutterUnitCB = new javax.swing.JComboBox<>();
        IDPGatePanel = new javax.swing.JPanel();
        jLabel291 = new javax.swing.JLabel();
        SPGatesWidthTF = new javax.swing.JTextField();
        SPGatesQtyTF = new javax.swing.JTextField();
        SPGatesRateTF = new javax.swing.JTextField();
        SPGatesAmountTF = new javax.swing.JTextField();
        jLabel292 = new javax.swing.JLabel();
        jLabel293 = new javax.swing.JLabel();
        jLabel294 = new javax.swing.JLabel();
        jLabel295 = new javax.swing.JLabel();
        SPRFSheetColourCombo6 = new javax.swing.JComboBox<>();
        jLabel297 = new javax.swing.JLabel();
        SPGatesHeightTF = new javax.swing.JTextField();
        SPGatesWidthHeightCB = new javax.swing.JComboBox<>();
        IDPPlainSheetPanel = new javax.swing.JPanel();
        jLabel298 = new javax.swing.JLabel();
        SPPlainSheetSizeTF = new javax.swing.JTextField();
        SPPlainSheetConvertedTF = new javax.swing.JTextField();
        SPPlainSheetQtyTF = new javax.swing.JTextField();
        SPPlainSheetRateTF = new javax.swing.JTextField();
        SPPlainSheetAmountTF = new javax.swing.JTextField();
        SPPlainSheetUnit02CB = new javax.swing.JComboBox<>();
        SPPlainSheetUnit01CB = new javax.swing.JComboBox<>();
        jLabel299 = new javax.swing.JLabel();
        jLabel300 = new javax.swing.JLabel();
        jLabel301 = new javax.swing.JLabel();
        jLabel302 = new javax.swing.JLabel();
        SPPlainSheetColourCB = new javax.swing.JComboBox<>();
        IDPCladdingPanel = new javax.swing.JPanel();
        jLabel318 = new javax.swing.JLabel();
        SPCladdingSizeTF = new javax.swing.JTextField();
        SPCladdingConvertedTF = new javax.swing.JTextField();
        SPCladdingQtyTF = new javax.swing.JTextField();
        SPCladdingRateTF = new javax.swing.JTextField();
        SPCladdingAmountTF = new javax.swing.JTextField();
        SPCladdingUnit02CB = new javax.swing.JComboBox<>();
        SPCladdingUnit01CB = new javax.swing.JComboBox<>();
        jLabel319 = new javax.swing.JLabel();
        jLabel320 = new javax.swing.JLabel();
        jLabel321 = new javax.swing.JLabel();
        jLabel322 = new javax.swing.JLabel();
        SPCladdingColourCB = new javax.swing.JComboBox<>();
        IDPOtherPanel = new javax.swing.JPanel();
        jLabel311 = new javax.swing.JLabel();
        SPRFSheetSizeTF9 = new javax.swing.JTextField();
        SPRFSheetSizeConvertedTF11 = new javax.swing.JTextField();
        SPRFSheetQtyTF10 = new javax.swing.JTextField();
        SPRFSheetRateTF9 = new javax.swing.JTextField();
        SPRFSheetAmountTF9 = new javax.swing.JTextField();
        SPRFSheetUnit02CB4 = new javax.swing.JComboBox<>();
        SPRFSheetUnit01CB12 = new javax.swing.JComboBox<>();
        jLabel312 = new javax.swing.JLabel();
        jLabel313 = new javax.swing.JLabel();
        jLabel314 = new javax.swing.JLabel();
        jLabel315 = new javax.swing.JLabel();
        SPRFSheetColourCombo9 = new javax.swing.JComboBox<>();
        jLabel316 = new javax.swing.JLabel();
        SPTotalTaxLable = new javax.swing.JLabel();
        SPNetAmountTF = new javax.swing.JTextField();
        SPPresentageMarkTF = new javax.swing.JLabel();
        SPTaxLable = new javax.swing.JLabel();
        SPTaxPercentageTF = new javax.swing.JTextField();
        SPTaxLable1 = new javax.swing.JLabel();
        SPTaxAmountTF = new javax.swing.JTextField();
        SPPrintBill = new javax.swing.JButton();
        AddItemToTableBtn = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        SPCustomerOrderTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        SPCustomerNameLable = new javax.swing.JLabel();
        SPCustomerNameorNICNoLabel = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        SPCustomerNameorNICNoTF = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        SPAddresTA = new javax.swing.JTextArea();
        SPCustomerSearchCB = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        SPContactNoTF = new javax.swing.JTextField();
        SPCustomerIDLable = new javax.swing.JLabel();
        SPCustomerIDTF = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        SPPaymentMethodsCB = new javax.swing.JComboBox<>();
        SPPaymentMethodsPnl = new javax.swing.JPanel();
        SPChequeDetailsPnl = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        SPChequeNoTF = new javax.swing.JTextField();
        SPBankNameTF = new javax.swing.JTextField();
        SPChequeDateDC = new com.toedter.calendar.JDateChooser();
        jLabel25 = new javax.swing.JLabel();
        SPChequeAmountTF = new javax.swing.JTextField();
        SPCreditDetailsPnl = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        SPPaymentMethodCreditContactTF = new javax.swing.JTextField();
        SPPaymentMethodFirstPaymentTF = new javax.swing.JTextField();
        SPPaymentMethodCreditNICTF = new javax.swing.JTextField();
        CashDetailsPnl = new javax.swing.JPanel();
        SPPayMethodCashTotalPayTF = new javax.swing.JTextField();
        SPCustomerNameorNICNoLabel1 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        SalesTotalAmountTF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        SPItemCatComboBox = new javax.swing.JComboBox<>();
        SPSearchItemLable = new javax.swing.JLabel();
        SPSearchItemNameORCodeCB = new javax.swing.JComboBox<>();
        SPItemNameORCodeLable = new javax.swing.JLabel();
        SPItemNameOrCodeTF = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        SPSalesOrderNo = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        SPMainBGLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(new java.awt.Dimension(1366, 768));

        SalesMainPanel.setMinimumSize(new java.awt.Dimension(1366, 728));
        SalesMainPanel.setPreferredSize(new java.awt.Dimension(1366, 768));
        SalesMainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        SalesMainPanel.add(TopPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 60));

        TopicPanel.setBackground(new java.awt.Color(102, 102, 102));
        TopicPanel.setOpaque(false);
        TopicPanel.setPreferredSize(new java.awt.Dimension(230, 710));
        TopicPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SPArrowLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/ArrowSingleBlue.png"))); // NOI18N
        TopicPanel.add(SPArrowLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, -1, -1));

        SPSalesBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/SalesLableIMG01.png"))); // NOI18N
        SPSalesBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/SalesLableIMG02.png")));
        SPSalesBtn.setBorderPainted(false);
        SPSalesBtn.setContentAreaFilled(false);
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
        SPFinishedItemsBtn.setBorderPainted(false);
        SPFinishedItemsBtn.setContentAreaFilled(false);
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
        SPRawItemBtn.setBorderPainted(false);
        SPRawItemBtn.setContentAreaFilled(false);
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
        SPCustomersBtn.setBorderPainted(false);
        SPCustomersBtn.setContentAreaFilled(false);
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
        SPEmployeeBtn.setBorderPainted(false);
        SPEmployeeBtn.setContentAreaFilled(false);
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
        SPSupplierBtn.setBorderPainted(false);
        SPSupplierBtn.setContentAreaFilled(false);
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
        SPVehicleBtn.setBorderPainted(false);
        SPVehicleBtn.setContentAreaFilled(false);
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
        SPSettingsBtn.setBorderPainted(false);
        SPSettingsBtn.setContentAreaFilled(false);
        SPSettingsBtn.setMaximumSize(new java.awt.Dimension(200, 40));
        SPSettingsBtn.setMinimumSize(new java.awt.Dimension(200, 40));
        SPSettingsBtn.setName(""); // NOI18N
        SPSettingsBtn.setPreferredSize(new java.awt.Dimension(200, 40));
        SPSettingsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SPSettingsBtnActionPerformed(evt);
            }
        });
        TopicPanel.add(SPSettingsBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 620, 200, -1));

        SPPaymentsBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/PaymentsLableIMG01.png"))); // NOI18N
        SPPaymentsBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/PaymentsLableIMG02.png")));
        SPPaymentsBtn.setBorderPainted(false);
        SPPaymentsBtn.setContentAreaFilled(false);
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
        SPReportBtn.setBorderPainted(false);
        SPReportBtn.setContentAreaFilled(false);
        SPReportBtn.setMaximumSize(new java.awt.Dimension(200, 40));
        SPReportBtn.setMinimumSize(new java.awt.Dimension(200, 40));
        SPReportBtn.setName(""); // NOI18N
        SPReportBtn.setPreferredSize(new java.awt.Dimension(200, 40));
        SPReportBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SPReportBtnActionPerformed(evt);
            }
        });
        TopicPanel.add(SPReportBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, -1, -1));

        SPBranchersBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/BranchesLableIMG01.png"))); // NOI18N
        SPBranchersBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/BranchesLableIMG02.png")));
        SPBranchersBtn.setBorderPainted(false);
        SPBranchersBtn.setContentAreaFilled(false);
        SPBranchersBtn.setMaximumSize(new java.awt.Dimension(200, 40));
        SPBranchersBtn.setMinimumSize(new java.awt.Dimension(200, 40));
        SPBranchersBtn.setName(""); // NOI18N
        SPBranchersBtn.setPreferredSize(new java.awt.Dimension(200, 40));
        SPBranchersBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SPBranchersBtnActionPerformed(evt);
            }
        });
        TopicPanel.add(SPBranchersBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, -1, -1));

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

        SalesMainPanel.add(TopicPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 230, 710));

        SalesContentPanel.setPreferredSize(new java.awt.Dimension(1140, 710));
        SalesContentPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CPSalesPanel.setBackground(new java.awt.Color(51, 51, 51));
        CPSalesPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Semilight", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Sales Panel");
        CPSalesPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 140, 40));

        SPItemsDetailsPanel.setMinimumSize(new java.awt.Dimension(470, 250));
        SPItemsDetailsPanel.setOpaque(false);
        SPItemsDetailsPanel.setLayout(new java.awt.CardLayout());

        IDPRoofingSheetPanel.setOpaque(false);
        IDPRoofingSheetPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Colour");
        IDPRoofingSheetPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 30));

        SPRFSheetSizeTF.setBackground(new java.awt.Color(102, 102, 102));
        SPRFSheetSizeTF.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPRFSheetSizeTF.setForeground(new java.awt.Color(255, 255, 255));
        SPRFSheetSizeTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SPRFSheetSizeTFKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SPRFSheetSizeTFKeyTyped(evt);
            }
        });
        IDPRoofingSheetPanel.add(SPRFSheetSizeTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 90, -1));

        SPRFSheetSizeConvertedTF.setEditable(false);
        SPRFSheetSizeConvertedTF.setBackground(new java.awt.Color(102, 102, 102));
        SPRFSheetSizeConvertedTF.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPRFSheetSizeConvertedTF.setForeground(new java.awt.Color(255, 255, 255));
        IDPRoofingSheetPanel.add(SPRFSheetSizeConvertedTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 90, -1));

        SPRFSheetQtyTF.setBackground(new java.awt.Color(102, 102, 102));
        SPRFSheetQtyTF.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPRFSheetQtyTF.setForeground(new java.awt.Color(255, 255, 255));
        SPRFSheetQtyTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SPRFSheetQtyTFKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SPRFSheetQtyTFKeyTyped(evt);
            }
        });
        IDPRoofingSheetPanel.add(SPRFSheetQtyTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 90, -1));

        SPRFSheetRateTF.setBackground(new java.awt.Color(102, 102, 102));
        SPRFSheetRateTF.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPRFSheetRateTF.setForeground(new java.awt.Color(255, 255, 255));
        SPRFSheetRateTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SPRFSheetRateTFKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SPRFSheetRateTFKeyTyped(evt);
            }
        });
        IDPRoofingSheetPanel.add(SPRFSheetRateTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 90, -1));

        SPRFSheetAmountTF.setEditable(false);
        SPRFSheetAmountTF.setBackground(new java.awt.Color(102, 102, 102));
        SPRFSheetAmountTF.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPRFSheetAmountTF.setForeground(new java.awt.Color(255, 255, 255));
        IDPRoofingSheetPanel.add(SPRFSheetAmountTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 220, -1));

        SPRFSheetUnit02CB.setBackground(new java.awt.Color(51, 51, 51));
        SPRFSheetUnit02CB.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPRFSheetUnit02CB.setForeground(new java.awt.Color(255, 255, 255));
        SPRFSheetUnit02CB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Feet", "Inches", "Millimeters" }));
        SPRFSheetUnit02CB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SPRFSheetUnit02CBActionPerformed(evt);
            }
        });
        IDPRoofingSheetPanel.add(SPRFSheetUnit02CB, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 120, -1));

        SPRFSheetUnit01CB.setBackground(new java.awt.Color(51, 51, 51));
        SPRFSheetUnit01CB.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPRFSheetUnit01CB.setForeground(new java.awt.Color(255, 255, 255));
        SPRFSheetUnit01CB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Feet", "Inches", "Millimeters" }));
        SPRFSheetUnit01CB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SPRFSheetUnit01CBActionPerformed(evt);
            }
        });
        IDPRoofingSheetPanel.add(SPRFSheetUnit01CB, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, 120, -1));

        jLabel8.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Size");
        IDPRoofingSheetPanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, 20));

        jLabel9.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Quantity");
        IDPRoofingSheetPanel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, 20));

        jLabel10.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Linear Feet Rate");
        IDPRoofingSheetPanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        jLabel11.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Amount");
        IDPRoofingSheetPanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        SPRFSheetColourCombo.setBackground(new java.awt.Color(51, 51, 51));
        SPRFSheetColourCombo.setEditable(true);
        SPRFSheetColourCombo.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPRFSheetColourCombo.setForeground(new java.awt.Color(255, 255, 255));
        SPRFSheetColourCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select or Type Colour", "Autom Red", "Magenta", "Maroon", "Lazurite Blue", "Beige", "Pearl Brown", "Mist Green", "Dark Green", "Ocean Green", "Galvenize" }));
        IDPRoofingSheetPanel.add(SPRFSheetColourCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 220, -1));

        SPItemsDetailsPanel.add(IDPRoofingSheetPanel, "card2");

        IDPCurvedRoofingSheetPanel.setBackground(new java.awt.Color(0, 204, 102));
        IDPCurvedRoofingSheetPanel.setOpaque(false);
        IDPCurvedRoofingSheetPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Colour");
        IDPCurvedRoofingSheetPanel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 30));

        SPCurveRFShtSizeCB.setBackground(new java.awt.Color(102, 102, 102));
        SPCurveRFShtSizeCB.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPCurveRFShtSizeCB.setForeground(new java.awt.Color(255, 255, 255));
        SPCurveRFShtSizeCB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SPCurveRFShtSizeCBKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SPCurveRFShtSizeCBKeyTyped(evt);
            }
        });
        IDPCurvedRoofingSheetPanel.add(SPCurveRFShtSizeCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 90, -1));

        SPCurveRFConvertedSizeTF.setEditable(false);
        SPCurveRFConvertedSizeTF.setBackground(new java.awt.Color(102, 102, 102));
        SPCurveRFConvertedSizeTF.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPCurveRFConvertedSizeTF.setForeground(new java.awt.Color(255, 255, 255));
        IDPCurvedRoofingSheetPanel.add(SPCurveRFConvertedSizeTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 90, -1));

        SPCurveRFShtCurveWidthTF.setBackground(new java.awt.Color(102, 102, 102));
        SPCurveRFShtCurveWidthTF.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPCurveRFShtCurveWidthTF.setForeground(new java.awt.Color(255, 255, 255));
        SPCurveRFShtCurveWidthTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SPCurveRFShtCurveWidthTFKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SPCurveRFShtCurveWidthTFKeyTyped(evt);
            }
        });
        IDPCurvedRoofingSheetPanel.add(SPCurveRFShtCurveWidthTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 90, -1));

        SPCurveRFShtRateTF.setBackground(new java.awt.Color(102, 102, 102));
        SPCurveRFShtRateTF.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPCurveRFShtRateTF.setForeground(new java.awt.Color(255, 255, 255));
        SPCurveRFShtRateTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SPCurveRFShtRateTFKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SPCurveRFShtRateTFKeyTyped(evt);
            }
        });
        IDPCurvedRoofingSheetPanel.add(SPCurveRFShtRateTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 90, -1));

        SPCurveRFShtAmountTF.setEditable(false);
        SPCurveRFShtAmountTF.setBackground(new java.awt.Color(102, 102, 102));
        SPCurveRFShtAmountTF.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPCurveRFShtAmountTF.setForeground(new java.awt.Color(255, 255, 255));
        IDPCurvedRoofingSheetPanel.add(SPCurveRFShtAmountTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 210, 170, -1));

        SPCurveRFShtUnit02CB.setBackground(new java.awt.Color(51, 51, 51));
        SPCurveRFShtUnit02CB.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPCurveRFShtUnit02CB.setForeground(new java.awt.Color(255, 255, 255));
        SPCurveRFShtUnit02CB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Feet", "Inches", "Millimeters" }));
        SPCurveRFShtUnit02CB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SPCurveRFShtUnit02CBActionPerformed(evt);
            }
        });
        IDPCurvedRoofingSheetPanel.add(SPCurveRFShtUnit02CB, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 120, -1));

        SPCurveRFShtUnit01CB.setBackground(new java.awt.Color(51, 51, 51));
        SPCurveRFShtUnit01CB.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPCurveRFShtUnit01CB.setForeground(new java.awt.Color(255, 255, 255));
        SPCurveRFShtUnit01CB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Feet", "Inches", "Millimeters" }));
        SPCurveRFShtUnit01CB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SPCurveRFShtUnit01CBActionPerformed(evt);
            }
        });
        IDPCurvedRoofingSheetPanel.add(SPCurveRFShtUnit01CB, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, 120, -1));

        jLabel56.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setText("Size");
        IDPCurvedRoofingSheetPanel.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, 20));

        jLabel63.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(255, 255, 255));
        jLabel63.setText("Curve Width");
        IDPCurvedRoofingSheetPanel.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, 30));

        jLabel64.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(255, 255, 255));
        jLabel64.setText("Linear Feet Rate");
        IDPCurvedRoofingSheetPanel.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, 30));

        jLabel65.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(255, 255, 255));
        jLabel65.setText("Amount");
        IDPCurvedRoofingSheetPanel.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, -1, 30));

        SPCurveRFShtColourCombo.setBackground(new java.awt.Color(51, 51, 51));
        SPCurveRFShtColourCombo.setEditable(true);
        SPCurveRFShtColourCombo.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPCurveRFShtColourCombo.setForeground(new java.awt.Color(255, 255, 255));
        SPCurveRFShtColourCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select or Type Colour", "Autom Red", "Magenta", "Maroon", "Lazurite Blue", "Beige", "Pearl Brown", "Mist Green", "Dark Green", "Ocean Green", "Galvenize" }));
        IDPCurvedRoofingSheetPanel.add(SPCurveRFShtColourCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 220, -1));

        jLabel68.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(255, 255, 255));
        jLabel68.setText("Quantity");
        IDPCurvedRoofingSheetPanel.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, 30));

        SPCurveRFShtQtyTF.setBackground(new java.awt.Color(102, 102, 102));
        SPCurveRFShtQtyTF.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPCurveRFShtQtyTF.setForeground(new java.awt.Color(255, 255, 255));
        SPCurveRFShtQtyTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SPCurveRFShtQtyTFKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SPCurveRFShtQtyTFKeyTyped(evt);
            }
        });
        IDPCurvedRoofingSheetPanel.add(SPCurveRFShtQtyTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 90, -1));

        jLabel71.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(255, 255, 255));
        jLabel71.setText("Feets");
        IDPCurvedRoofingSheetPanel.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, 50, 30));

        SPItemsDetailsPanel.add(IDPCurvedRoofingSheetPanel, "card3");

        IDPRollerDoorPanel.setBackground(new java.awt.Color(0, 153, 153));
        IDPRollerDoorPanel.setMinimumSize(new java.awt.Dimension(470, 250));
        IDPRollerDoorPanel.setOpaque(false);
        IDPRollerDoorPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel86.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(255, 255, 255));
        jLabel86.setText("Colour");
        IDPRollerDoorPanel.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        SPRollerDoorWidthTF.setBackground(new java.awt.Color(102, 102, 102));
        SPRollerDoorWidthTF.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPRollerDoorWidthTF.setForeground(new java.awt.Color(255, 255, 255));
        SPRollerDoorWidthTF.setText("0");
        SPRollerDoorWidthTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SPRollerDoorWidthTFKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SPRollerDoorWidthTFKeyTyped(evt);
            }
        });
        IDPRollerDoorPanel.add(SPRollerDoorWidthTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 90, -1));

        SPRollerDoorQtyTF.setBackground(new java.awt.Color(102, 102, 102));
        SPRollerDoorQtyTF.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPRollerDoorQtyTF.setForeground(new java.awt.Color(255, 255, 255));
        SPRollerDoorQtyTF.setText("0");
        SPRollerDoorQtyTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SPRollerDoorQtyTFKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SPRollerDoorQtyTFKeyTyped(evt);
            }
        });
        IDPRollerDoorPanel.add(SPRollerDoorQtyTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 90, -1));

        SPRollerDoorRateTF.setBackground(new java.awt.Color(102, 102, 102));
        SPRollerDoorRateTF.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPRollerDoorRateTF.setForeground(new java.awt.Color(255, 255, 255));
        SPRollerDoorRateTF.setText("0");
        SPRollerDoorRateTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SPRollerDoorRateTFKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SPRollerDoorRateTFKeyTyped(evt);
            }
        });
        IDPRollerDoorPanel.add(SPRollerDoorRateTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 90, -1));

        SPRollerDoorAmountTF.setEditable(false);
        SPRollerDoorAmountTF.setBackground(new java.awt.Color(102, 102, 102));
        SPRollerDoorAmountTF.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPRollerDoorAmountTF.setForeground(new java.awt.Color(255, 255, 255));
        IDPRollerDoorPanel.add(SPRollerDoorAmountTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 220, -1));

        jLabel111.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel111.setForeground(new java.awt.Color(255, 255, 255));
        jLabel111.setText("Quantity");
        IDPRollerDoorPanel.add(jLabel111, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jLabel206.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel206.setForeground(new java.awt.Color(255, 255, 255));
        jLabel206.setText("Square Feet Rate");
        IDPRollerDoorPanel.add(jLabel206, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        jLabel216.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel216.setForeground(new java.awt.Color(255, 255, 255));
        jLabel216.setText("Amount");
        IDPRollerDoorPanel.add(jLabel216, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, 20));

        SPRollerDoorColourCombo.setBackground(new java.awt.Color(51, 51, 51));
        SPRollerDoorColourCombo.setEditable(true);
        SPRollerDoorColourCombo.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPRollerDoorColourCombo.setForeground(new java.awt.Color(255, 255, 255));
        SPRollerDoorColourCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Colour", "Autom Red", "Magenta" }));
        IDPRollerDoorPanel.add(SPRollerDoorColourCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 220, -1));

        jLabel236.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel236.setForeground(new java.awt.Color(255, 255, 255));
        jLabel236.setText("Height");
        IDPRollerDoorPanel.add(jLabel236, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel246.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel246.setForeground(new java.awt.Color(255, 255, 255));
        jLabel246.setText("Width");
        IDPRollerDoorPanel.add(jLabel246, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        SPRollerDoorHeightTF.setBackground(new java.awt.Color(102, 102, 102));
        SPRollerDoorHeightTF.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPRollerDoorHeightTF.setForeground(new java.awt.Color(255, 255, 255));
        SPRollerDoorHeightTF.setText("0");
        SPRollerDoorHeightTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SPRollerDoorHeightTFKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SPRollerDoorHeightTFKeyTyped(evt);
            }
        });
        IDPRollerDoorPanel.add(SPRollerDoorHeightTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 90, -1));

        SPRollerDoorWidthHeightUnitCB.setBackground(new java.awt.Color(51, 51, 51));
        SPRollerDoorWidthHeightUnitCB.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPRollerDoorWidthHeightUnitCB.setForeground(new java.awt.Color(255, 255, 255));
        SPRollerDoorWidthHeightUnitCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Feet", "Inches", "Meters" }));
        SPRollerDoorWidthHeightUnitCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SPRollerDoorWidthHeightUnitCBActionPerformed(evt);
            }
        });
        IDPRollerDoorPanel.add(SPRollerDoorWidthHeightUnitCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 110, -1));

        jLabel4.setToolTipText("");
        jLabel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 2, true));
        jLabel4.setPreferredSize(new java.awt.Dimension(100, 50));
        IDPRollerDoorPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 100, -1));

        SPItemsDetailsPanel.add(IDPRollerDoorPanel, "card4");

        IDPRollerShutterPanel.setBackground(new java.awt.Color(0, 153, 153));
        IDPRollerShutterPanel.setOpaque(false);
        IDPRollerShutterPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel266.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel266.setForeground(new java.awt.Color(255, 255, 255));
        jLabel266.setText("Colour");
        IDPRollerShutterPanel.add(jLabel266, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        SPRollerShutterWidthTF.setBackground(new java.awt.Color(102, 102, 102));
        SPRollerShutterWidthTF.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPRollerShutterWidthTF.setForeground(new java.awt.Color(255, 255, 255));
        SPRollerShutterWidthTF.setText("0");
        SPRollerShutterWidthTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SPRollerShutterWidthTFKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SPRollerShutterWidthTFKeyTyped(evt);
            }
        });
        IDPRollerShutterPanel.add(SPRollerShutterWidthTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 90, -1));

        SPRollerShutterQtyTF.setBackground(new java.awt.Color(102, 102, 102));
        SPRollerShutterQtyTF.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPRollerShutterQtyTF.setForeground(new java.awt.Color(255, 255, 255));
        SPRollerShutterQtyTF.setText("0");
        SPRollerShutterQtyTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SPRollerShutterQtyTFKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SPRollerShutterQtyTFKeyTyped(evt);
            }
        });
        IDPRollerShutterPanel.add(SPRollerShutterQtyTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 90, -1));

        SPRollerShutterRateTF.setBackground(new java.awt.Color(102, 102, 102));
        SPRollerShutterRateTF.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPRollerShutterRateTF.setForeground(new java.awt.Color(255, 255, 255));
        SPRollerShutterRateTF.setText("0");
        SPRollerShutterRateTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SPRollerShutterRateTFKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SPRollerShutterRateTFKeyTyped(evt);
            }
        });
        IDPRollerShutterPanel.add(SPRollerShutterRateTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 90, -1));

        SPRollerShutterAmountTF.setEditable(false);
        SPRollerShutterAmountTF.setBackground(new java.awt.Color(102, 102, 102));
        SPRollerShutterAmountTF.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPRollerShutterAmountTF.setForeground(new java.awt.Color(255, 255, 255));
        IDPRollerShutterPanel.add(SPRollerShutterAmountTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 220, -1));

        jLabel268.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel268.setForeground(new java.awt.Color(255, 255, 255));
        jLabel268.setText("Quantity");
        IDPRollerShutterPanel.add(jLabel268, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jLabel269.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel269.setForeground(new java.awt.Color(255, 255, 255));
        jLabel269.setText("Square Feet Rate");
        IDPRollerShutterPanel.add(jLabel269, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        jLabel270.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel270.setForeground(new java.awt.Color(255, 255, 255));
        jLabel270.setText("Amount");
        IDPRollerShutterPanel.add(jLabel270, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, 20));

        SPRollerShutterColourCombo.setBackground(new java.awt.Color(51, 51, 51));
        SPRollerShutterColourCombo.setEditable(true);
        SPRollerShutterColourCombo.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPRollerShutterColourCombo.setForeground(new java.awt.Color(255, 255, 255));
        SPRollerShutterColourCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Colour", "Autom Red", "Magenta" }));
        IDPRollerShutterPanel.add(SPRollerShutterColourCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 220, -1));

        jLabel272.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel272.setForeground(new java.awt.Color(255, 255, 255));
        jLabel272.setText("Height");
        IDPRollerShutterPanel.add(jLabel272, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel273.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel273.setForeground(new java.awt.Color(255, 255, 255));
        jLabel273.setText("Width");
        IDPRollerShutterPanel.add(jLabel273, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        SPRollerShutterHeightTF.setBackground(new java.awt.Color(102, 102, 102));
        SPRollerShutterHeightTF.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPRollerShutterHeightTF.setForeground(new java.awt.Color(255, 255, 255));
        SPRollerShutterHeightTF.setText("0");
        SPRollerShutterHeightTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SPRollerShutterHeightTFKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SPRollerShutterHeightTFKeyTyped(evt);
            }
        });
        IDPRollerShutterPanel.add(SPRollerShutterHeightTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 90, -1));

        SPRollerShutterWidthHeightUnitCB.setBackground(new java.awt.Color(51, 51, 51));
        SPRollerShutterWidthHeightUnitCB.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPRollerShutterWidthHeightUnitCB.setForeground(new java.awt.Color(255, 255, 255));
        SPRollerShutterWidthHeightUnitCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Feet", "Inches", "Meters" }));
        SPRollerShutterWidthHeightUnitCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SPRollerShutterWidthHeightUnitCBActionPerformed(evt);
            }
        });
        IDPRollerShutterPanel.add(SPRollerShutterWidthHeightUnitCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 110, -1));

        jLabel24.setToolTipText("");
        jLabel24.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 2, true));
        jLabel24.setPreferredSize(new java.awt.Dimension(100, 50));
        IDPRollerShutterPanel.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 100, -1));

        SPItemsDetailsPanel.add(IDPRollerShutterPanel, "card9");

        IDPPurlingPanel.setBackground(new java.awt.Color(0, 153, 153));
        IDPPurlingPanel.setOpaque(false);
        IDPPurlingPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel275.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel275.setForeground(new java.awt.Color(255, 255, 255));
        jLabel275.setText("Colour");
        IDPPurlingPanel.add(jLabel275, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        SPPurlinThiknessTF.setBackground(new java.awt.Color(102, 102, 102));
        SPPurlinThiknessTF.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPPurlinThiknessTF.setForeground(new java.awt.Color(255, 255, 255));
        SPPurlinThiknessTF.setText("0");
        SPPurlinThiknessTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SPPurlinThiknessTFKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SPPurlinThiknessTFKeyTyped(evt);
            }
        });
        IDPPurlingPanel.add(SPPurlinThiknessTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 90, -1));

        SPPurlinQtyTF.setBackground(new java.awt.Color(102, 102, 102));
        SPPurlinQtyTF.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPPurlinQtyTF.setForeground(new java.awt.Color(255, 255, 255));
        SPPurlinQtyTF.setText("0");
        SPPurlinQtyTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SPPurlinQtyTFKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SPPurlinQtyTFKeyTyped(evt);
            }
        });
        IDPPurlingPanel.add(SPPurlinQtyTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 90, -1));

        SPPurlinRateTF.setBackground(new java.awt.Color(102, 102, 102));
        SPPurlinRateTF.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPPurlinRateTF.setForeground(new java.awt.Color(255, 255, 255));
        SPPurlinRateTF.setText("0");
        SPPurlinRateTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SPPurlinRateTFKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SPPurlinRateTFKeyTyped(evt);
            }
        });
        IDPPurlingPanel.add(SPPurlinRateTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 90, -1));

        SPPurlinAmountTF.setEditable(false);
        SPPurlinAmountTF.setBackground(new java.awt.Color(102, 102, 102));
        SPPurlinAmountTF.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPPurlinAmountTF.setForeground(new java.awt.Color(255, 255, 255));
        IDPPurlingPanel.add(SPPurlinAmountTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 220, -1));

        jLabel276.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel276.setForeground(new java.awt.Color(255, 255, 255));
        jLabel276.setText("Thikness");
        IDPPurlingPanel.add(jLabel276, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel277.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel277.setForeground(new java.awt.Color(255, 255, 255));
        jLabel277.setText("Quantity");
        IDPPurlingPanel.add(jLabel277, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jLabel278.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel278.setForeground(new java.awt.Color(255, 255, 255));
        jLabel278.setText("Rate of Foot");
        IDPPurlingPanel.add(jLabel278, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        jLabel279.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel279.setForeground(new java.awt.Color(255, 255, 255));
        jLabel279.setText("Amount");
        IDPPurlingPanel.add(jLabel279, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        SPPurlinColourCB.setBackground(new java.awt.Color(51, 51, 51));
        SPPurlinColourCB.setEditable(true);
        SPPurlinColourCB.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPPurlinColourCB.setForeground(new java.awt.Color(255, 255, 255));
        SPPurlinColourCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Colour", "Gray", "Autom Red", "Magenta" }));
        IDPPurlingPanel.add(SPPurlinColourCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 220, -1));

        jLabel280.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel280.setForeground(new java.awt.Color(255, 255, 255));
        jLabel280.setText("Millimeters");
        IDPPurlingPanel.add(jLabel280, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, -1, 20));

        jLabel282.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel282.setForeground(new java.awt.Color(255, 255, 255));
        jLabel282.setText("Length");
        IDPPurlingPanel.add(jLabel282, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        SPPurlinLengthTF.setBackground(new java.awt.Color(102, 102, 102));
        SPPurlinLengthTF.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPPurlinLengthTF.setForeground(new java.awt.Color(255, 255, 255));
        SPPurlinLengthTF.setText("0");
        SPPurlinLengthTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SPPurlinLengthTFKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SPPurlinLengthTFKeyTyped(evt);
            }
        });
        IDPPurlingPanel.add(SPPurlinLengthTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 90, -1));

        SPPurlinUnitCB.setBackground(new java.awt.Color(51, 51, 51));
        SPPurlinUnitCB.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPPurlinUnitCB.setForeground(new java.awt.Color(255, 255, 255));
        SPPurlinUnitCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Feet", "Inches", "Meters" }));
        SPPurlinUnitCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SPPurlinUnitCBActionPerformed(evt);
            }
        });
        IDPPurlingPanel.add(SPPurlinUnitCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 120, -1));

        SPItemsDetailsPanel.add(IDPPurlingPanel, "card5");

        IDPGutterPanel.setOpaque(false);
        IDPGutterPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel283.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel283.setForeground(new java.awt.Color(255, 255, 255));
        jLabel283.setText("Colour");
        IDPGutterPanel.add(jLabel283, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        SPGutterThiknessTF.setBackground(new java.awt.Color(102, 102, 102));
        SPGutterThiknessTF.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPGutterThiknessTF.setForeground(new java.awt.Color(255, 255, 255));
        SPGutterThiknessTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SPGutterThiknessTFActionPerformed(evt);
            }
        });
        SPGutterThiknessTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SPGutterThiknessTFKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SPGutterThiknessTFKeyTyped(evt);
            }
        });
        IDPGutterPanel.add(SPGutterThiknessTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 90, -1));

        SPGutterQtyTF.setBackground(new java.awt.Color(102, 102, 102));
        SPGutterQtyTF.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPGutterQtyTF.setForeground(new java.awt.Color(255, 255, 255));
        SPGutterQtyTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SPGutterQtyTFKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SPGutterQtyTFKeyTyped(evt);
            }
        });
        IDPGutterPanel.add(SPGutterQtyTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 90, -1));

        SPGutterRateTF.setBackground(new java.awt.Color(102, 102, 102));
        SPGutterRateTF.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPGutterRateTF.setForeground(new java.awt.Color(255, 255, 255));
        SPGutterRateTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SPGutterRateTFKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SPGutterRateTFKeyTyped(evt);
            }
        });
        IDPGutterPanel.add(SPGutterRateTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 90, -1));

        SPGutterAmountTF.setEditable(false);
        SPGutterAmountTF.setBackground(new java.awt.Color(102, 102, 102));
        SPGutterAmountTF.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPGutterAmountTF.setForeground(new java.awt.Color(255, 255, 255));
        IDPGutterPanel.add(SPGutterAmountTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 220, -1));

        jLabel284.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel284.setForeground(new java.awt.Color(255, 255, 255));
        jLabel284.setText("Thikness");
        IDPGutterPanel.add(jLabel284, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel285.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel285.setForeground(new java.awt.Color(255, 255, 255));
        jLabel285.setText("Quantity");
        IDPGutterPanel.add(jLabel285, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jLabel286.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel286.setForeground(new java.awt.Color(255, 255, 255));
        jLabel286.setText("Rate of Foot");
        IDPGutterPanel.add(jLabel286, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        jLabel287.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel287.setForeground(new java.awt.Color(255, 255, 255));
        jLabel287.setText("Amount");
        IDPGutterPanel.add(jLabel287, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        SPGutterColourCB.setBackground(new java.awt.Color(51, 51, 51));
        SPGutterColourCB.setEditable(true);
        SPGutterColourCB.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPGutterColourCB.setForeground(new java.awt.Color(255, 255, 255));
        SPGutterColourCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Colour", "Autom Red", "Magenta" }));
        IDPGutterPanel.add(SPGutterColourCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 220, -1));

        jLabel288.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel288.setForeground(new java.awt.Color(255, 255, 255));
        jLabel288.setText("Millimeters");
        IDPGutterPanel.add(jLabel288, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, -1, 20));

        jLabel289.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel289.setForeground(new java.awt.Color(255, 255, 255));
        jLabel289.setText("Length");
        IDPGutterPanel.add(jLabel289, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        SPGutterLengthTF.setBackground(new java.awt.Color(102, 102, 102));
        SPGutterLengthTF.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPGutterLengthTF.setForeground(new java.awt.Color(255, 255, 255));
        SPGutterLengthTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SPGutterLengthTFKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SPGutterLengthTFKeyTyped(evt);
            }
        });
        IDPGutterPanel.add(SPGutterLengthTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 90, -1));

        SPGutterUnitCB.setBackground(new java.awt.Color(51, 51, 51));
        SPGutterUnitCB.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPGutterUnitCB.setForeground(new java.awt.Color(255, 255, 255));
        SPGutterUnitCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Feet", "Inches", "Meters" }));
        SPGutterUnitCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SPGutterUnitCBActionPerformed(evt);
            }
        });
        IDPGutterPanel.add(SPGutterUnitCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 120, -1));

        SPItemsDetailsPanel.add(IDPGutterPanel, "card6");

        IDPGatePanel.setOpaque(false);
        IDPGatePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel291.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel291.setForeground(new java.awt.Color(255, 255, 255));
        jLabel291.setText("Colour");
        IDPGatePanel.add(jLabel291, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        SPGatesWidthTF.setBackground(new java.awt.Color(102, 102, 102));
        SPGatesWidthTF.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPGatesWidthTF.setForeground(new java.awt.Color(255, 255, 255));
        SPGatesWidthTF.setText("0");
        SPGatesWidthTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SPGatesWidthTFKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SPGatesWidthTFKeyTyped(evt);
            }
        });
        IDPGatePanel.add(SPGatesWidthTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 90, -1));

        SPGatesQtyTF.setBackground(new java.awt.Color(102, 102, 102));
        SPGatesQtyTF.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPGatesQtyTF.setForeground(new java.awt.Color(255, 255, 255));
        SPGatesQtyTF.setText("0");
        SPGatesQtyTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SPGatesQtyTFKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SPGatesQtyTFKeyTyped(evt);
            }
        });
        IDPGatePanel.add(SPGatesQtyTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 90, -1));

        SPGatesRateTF.setBackground(new java.awt.Color(102, 102, 102));
        SPGatesRateTF.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPGatesRateTF.setForeground(new java.awt.Color(255, 255, 255));
        SPGatesRateTF.setText("0");
        SPGatesRateTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SPGatesRateTFKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SPGatesRateTFKeyTyped(evt);
            }
        });
        IDPGatePanel.add(SPGatesRateTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 90, -1));

        SPGatesAmountTF.setEditable(false);
        SPGatesAmountTF.setBackground(new java.awt.Color(102, 102, 102));
        SPGatesAmountTF.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPGatesAmountTF.setForeground(new java.awt.Color(255, 255, 255));
        SPGatesAmountTF.setText("0");
        IDPGatePanel.add(SPGatesAmountTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 220, -1));

        jLabel292.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel292.setForeground(new java.awt.Color(255, 255, 255));
        jLabel292.setText("Width");
        IDPGatePanel.add(jLabel292, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel293.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel293.setForeground(new java.awt.Color(255, 255, 255));
        jLabel293.setText("Quantity");
        IDPGatePanel.add(jLabel293, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jLabel294.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel294.setForeground(new java.awt.Color(255, 255, 255));
        jLabel294.setText("Rate");
        IDPGatePanel.add(jLabel294, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        jLabel295.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel295.setForeground(new java.awt.Color(255, 255, 255));
        jLabel295.setText("Amount");
        IDPGatePanel.add(jLabel295, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        SPRFSheetColourCombo6.setBackground(new java.awt.Color(51, 51, 51));
        SPRFSheetColourCombo6.setEditable(true);
        SPRFSheetColourCombo6.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPRFSheetColourCombo6.setForeground(new java.awt.Color(255, 255, 255));
        SPRFSheetColourCombo6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Colour", "Autom Red", "Magenta" }));
        IDPGatePanel.add(SPRFSheetColourCombo6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 220, -1));

        jLabel297.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel297.setForeground(new java.awt.Color(255, 255, 255));
        jLabel297.setText("Height");
        IDPGatePanel.add(jLabel297, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        SPGatesHeightTF.setBackground(new java.awt.Color(102, 102, 102));
        SPGatesHeightTF.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPGatesHeightTF.setForeground(new java.awt.Color(255, 255, 255));
        SPGatesHeightTF.setText("0");
        SPGatesHeightTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SPGatesHeightTFKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SPGatesHeightTFKeyTyped(evt);
            }
        });
        IDPGatePanel.add(SPGatesHeightTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 90, -1));

        SPGatesWidthHeightCB.setBackground(new java.awt.Color(51, 51, 51));
        SPGatesWidthHeightCB.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPGatesWidthHeightCB.setForeground(new java.awt.Color(255, 255, 255));
        SPGatesWidthHeightCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Feet", "Inches", "Meters" }));
        SPGatesWidthHeightCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SPGatesWidthHeightCBActionPerformed(evt);
            }
        });
        IDPGatePanel.add(SPGatesWidthHeightCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 110, -1));

        SPItemsDetailsPanel.add(IDPGatePanel, "card7");

        IDPPlainSheetPanel.setOpaque(false);
        IDPPlainSheetPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel298.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel298.setForeground(new java.awt.Color(255, 255, 255));
        jLabel298.setText("Colour");
        IDPPlainSheetPanel.add(jLabel298, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        SPPlainSheetSizeTF.setBackground(new java.awt.Color(102, 102, 102));
        SPPlainSheetSizeTF.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPPlainSheetSizeTF.setForeground(new java.awt.Color(255, 255, 255));
        SPPlainSheetSizeTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SPPlainSheetSizeTFKeyReleased(evt);
            }
        });
        IDPPlainSheetPanel.add(SPPlainSheetSizeTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 90, -1));

        SPPlainSheetConvertedTF.setEditable(false);
        SPPlainSheetConvertedTF.setBackground(new java.awt.Color(102, 102, 102));
        SPPlainSheetConvertedTF.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPPlainSheetConvertedTF.setForeground(new java.awt.Color(255, 255, 255));
        IDPPlainSheetPanel.add(SPPlainSheetConvertedTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 90, -1));

        SPPlainSheetQtyTF.setBackground(new java.awt.Color(102, 102, 102));
        SPPlainSheetQtyTF.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPPlainSheetQtyTF.setForeground(new java.awt.Color(255, 255, 255));
        SPPlainSheetQtyTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SPPlainSheetQtyTFKeyReleased(evt);
            }
        });
        IDPPlainSheetPanel.add(SPPlainSheetQtyTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 90, -1));

        SPPlainSheetRateTF.setBackground(new java.awt.Color(102, 102, 102));
        SPPlainSheetRateTF.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPPlainSheetRateTF.setForeground(new java.awt.Color(255, 255, 255));
        SPPlainSheetRateTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SPPlainSheetRateTFKeyReleased(evt);
            }
        });
        IDPPlainSheetPanel.add(SPPlainSheetRateTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 90, -1));

        SPPlainSheetAmountTF.setEditable(false);
        SPPlainSheetAmountTF.setBackground(new java.awt.Color(102, 102, 102));
        SPPlainSheetAmountTF.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPPlainSheetAmountTF.setForeground(new java.awt.Color(255, 255, 255));
        IDPPlainSheetPanel.add(SPPlainSheetAmountTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 220, -1));

        SPPlainSheetUnit02CB.setBackground(new java.awt.Color(51, 51, 51));
        SPPlainSheetUnit02CB.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPPlainSheetUnit02CB.setForeground(new java.awt.Color(255, 255, 255));
        SPPlainSheetUnit02CB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Feet", "Inches", "Millimeters" }));
        SPPlainSheetUnit02CB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SPPlainSheetUnit02CBActionPerformed(evt);
            }
        });
        IDPPlainSheetPanel.add(SPPlainSheetUnit02CB, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 120, -1));

        SPPlainSheetUnit01CB.setBackground(new java.awt.Color(51, 51, 51));
        SPPlainSheetUnit01CB.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPPlainSheetUnit01CB.setForeground(new java.awt.Color(255, 255, 255));
        SPPlainSheetUnit01CB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Feet", "Inches", "Millimeters" }));
        SPPlainSheetUnit01CB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SPPlainSheetUnit01CBActionPerformed(evt);
            }
        });
        IDPPlainSheetPanel.add(SPPlainSheetUnit01CB, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, 120, -1));

        jLabel299.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel299.setForeground(new java.awt.Color(255, 255, 255));
        jLabel299.setText("Size");
        IDPPlainSheetPanel.add(jLabel299, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel300.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel300.setForeground(new java.awt.Color(255, 255, 255));
        jLabel300.setText("Quantity");
        IDPPlainSheetPanel.add(jLabel300, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jLabel301.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel301.setForeground(new java.awt.Color(255, 255, 255));
        jLabel301.setText("Linear Feet Rate");
        IDPPlainSheetPanel.add(jLabel301, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        jLabel302.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel302.setForeground(new java.awt.Color(255, 255, 255));
        jLabel302.setText("Amount");
        IDPPlainSheetPanel.add(jLabel302, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        SPPlainSheetColourCB.setBackground(new java.awt.Color(51, 51, 51));
        SPPlainSheetColourCB.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPPlainSheetColourCB.setForeground(new java.awt.Color(255, 255, 255));
        SPPlainSheetColourCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Colour", "Autom Red", "Magenta" }));
        IDPPlainSheetPanel.add(SPPlainSheetColourCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 220, -1));

        SPItemsDetailsPanel.add(IDPPlainSheetPanel, "card8");

        IDPCladdingPanel.setOpaque(false);
        IDPCladdingPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel318.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel318.setForeground(new java.awt.Color(255, 255, 255));
        jLabel318.setText("Colour");
        IDPCladdingPanel.add(jLabel318, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        SPCladdingSizeTF.setBackground(new java.awt.Color(102, 102, 102));
        SPCladdingSizeTF.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPCladdingSizeTF.setForeground(new java.awt.Color(255, 255, 255));
        SPCladdingSizeTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SPCladdingSizeTFKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SPCladdingSizeTFKeyTyped(evt);
            }
        });
        IDPCladdingPanel.add(SPCladdingSizeTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 90, -1));

        SPCladdingConvertedTF.setEditable(false);
        SPCladdingConvertedTF.setBackground(new java.awt.Color(102, 102, 102));
        SPCladdingConvertedTF.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPCladdingConvertedTF.setForeground(new java.awt.Color(255, 255, 255));
        IDPCladdingPanel.add(SPCladdingConvertedTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 90, -1));

        SPCladdingQtyTF.setBackground(new java.awt.Color(102, 102, 102));
        SPCladdingQtyTF.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPCladdingQtyTF.setForeground(new java.awt.Color(255, 255, 255));
        SPCladdingQtyTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SPCladdingQtyTFKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SPCladdingQtyTFKeyTyped(evt);
            }
        });
        IDPCladdingPanel.add(SPCladdingQtyTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 90, -1));

        SPCladdingRateTF.setBackground(new java.awt.Color(102, 102, 102));
        SPCladdingRateTF.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPCladdingRateTF.setForeground(new java.awt.Color(255, 255, 255));
        SPCladdingRateTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SPCladdingRateTFKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SPCladdingRateTFKeyTyped(evt);
            }
        });
        IDPCladdingPanel.add(SPCladdingRateTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 90, -1));

        SPCladdingAmountTF.setEditable(false);
        SPCladdingAmountTF.setBackground(new java.awt.Color(102, 102, 102));
        SPCladdingAmountTF.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPCladdingAmountTF.setForeground(new java.awt.Color(255, 255, 255));
        IDPCladdingPanel.add(SPCladdingAmountTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 220, -1));

        SPCladdingUnit02CB.setBackground(new java.awt.Color(51, 51, 51));
        SPCladdingUnit02CB.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPCladdingUnit02CB.setForeground(new java.awt.Color(255, 255, 255));
        SPCladdingUnit02CB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Feet", "Inches", "Millimeters" }));
        SPCladdingUnit02CB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SPCladdingUnit02CBActionPerformed(evt);
            }
        });
        IDPCladdingPanel.add(SPCladdingUnit02CB, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 120, -1));

        SPCladdingUnit01CB.setBackground(new java.awt.Color(51, 51, 51));
        SPCladdingUnit01CB.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPCladdingUnit01CB.setForeground(new java.awt.Color(255, 255, 255));
        SPCladdingUnit01CB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Feet", "Inches", "Millimeters" }));
        SPCladdingUnit01CB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SPCladdingUnit01CBActionPerformed(evt);
            }
        });
        IDPCladdingPanel.add(SPCladdingUnit01CB, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, 120, -1));

        jLabel319.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel319.setForeground(new java.awt.Color(255, 255, 255));
        jLabel319.setText("Size");
        IDPCladdingPanel.add(jLabel319, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel320.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel320.setForeground(new java.awt.Color(255, 255, 255));
        jLabel320.setText("Quantity");
        IDPCladdingPanel.add(jLabel320, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jLabel321.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel321.setForeground(new java.awt.Color(255, 255, 255));
        jLabel321.setText("Linear Feet Rate");
        IDPCladdingPanel.add(jLabel321, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        jLabel322.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel322.setForeground(new java.awt.Color(255, 255, 255));
        jLabel322.setText("Amount");
        IDPCladdingPanel.add(jLabel322, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        SPCladdingColourCB.setBackground(new java.awt.Color(51, 51, 51));
        SPCladdingColourCB.setEditable(true);
        SPCladdingColourCB.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPCladdingColourCB.setForeground(new java.awt.Color(255, 255, 255));
        SPCladdingColourCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select or Type Colour", "Autom Red", "Magenta", "Maroon", "Lazurite Blue", "Beige", "Pearl Brown", "Mist Green", "Dark Green", "Ocean Green", "Galvenize" }));
        IDPCladdingPanel.add(SPCladdingColourCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 220, -1));

        SPItemsDetailsPanel.add(IDPCladdingPanel, "card8");

        IDPOtherPanel.setEnabled(false);
        IDPOtherPanel.setOpaque(false);
        IDPOtherPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel311.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel311.setForeground(new java.awt.Color(255, 255, 255));
        jLabel311.setText("Colour");
        IDPOtherPanel.add(jLabel311, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        SPRFSheetSizeTF9.setBackground(new java.awt.Color(102, 102, 102));
        SPRFSheetSizeTF9.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPRFSheetSizeTF9.setForeground(new java.awt.Color(255, 255, 255));
        SPRFSheetSizeTF9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SPRFSheetSizeTF9KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SPRFSheetSizeTF9KeyTyped(evt);
            }
        });
        IDPOtherPanel.add(SPRFSheetSizeTF9, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 90, -1));

        SPRFSheetSizeConvertedTF11.setEditable(false);
        SPRFSheetSizeConvertedTF11.setBackground(new java.awt.Color(102, 102, 102));
        SPRFSheetSizeConvertedTF11.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPRFSheetSizeConvertedTF11.setForeground(new java.awt.Color(255, 255, 255));
        SPRFSheetSizeConvertedTF11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SPRFSheetSizeConvertedTF11KeyTyped(evt);
            }
        });
        IDPOtherPanel.add(SPRFSheetSizeConvertedTF11, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 90, -1));

        SPRFSheetQtyTF10.setBackground(new java.awt.Color(102, 102, 102));
        SPRFSheetQtyTF10.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPRFSheetQtyTF10.setForeground(new java.awt.Color(255, 255, 255));
        SPRFSheetQtyTF10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SPRFSheetQtyTF10KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SPRFSheetQtyTF10KeyTyped(evt);
            }
        });
        IDPOtherPanel.add(SPRFSheetQtyTF10, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 90, -1));

        SPRFSheetRateTF9.setBackground(new java.awt.Color(102, 102, 102));
        SPRFSheetRateTF9.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPRFSheetRateTF9.setForeground(new java.awt.Color(255, 255, 255));
        SPRFSheetRateTF9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SPRFSheetRateTF9KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SPRFSheetRateTF9KeyTyped(evt);
            }
        });
        IDPOtherPanel.add(SPRFSheetRateTF9, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 90, -1));

        SPRFSheetAmountTF9.setEditable(false);
        SPRFSheetAmountTF9.setBackground(new java.awt.Color(102, 102, 102));
        SPRFSheetAmountTF9.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPRFSheetAmountTF9.setForeground(new java.awt.Color(255, 255, 255));
        IDPOtherPanel.add(SPRFSheetAmountTF9, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 220, -1));

        SPRFSheetUnit02CB4.setBackground(new java.awt.Color(51, 51, 51));
        SPRFSheetUnit02CB4.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPRFSheetUnit02CB4.setForeground(new java.awt.Color(255, 255, 255));
        SPRFSheetUnit02CB4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Feets", "Inches", "Millimeters" }));
        SPRFSheetUnit02CB4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SPRFSheetUnit02CB4ActionPerformed(evt);
            }
        });
        IDPOtherPanel.add(SPRFSheetUnit02CB4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 120, -1));

        SPRFSheetUnit01CB12.setBackground(new java.awt.Color(51, 51, 51));
        SPRFSheetUnit01CB12.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPRFSheetUnit01CB12.setForeground(new java.awt.Color(255, 255, 255));
        SPRFSheetUnit01CB12.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Feets", "Inches", "Millimeters" }));
        IDPOtherPanel.add(SPRFSheetUnit01CB12, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, 120, -1));

        jLabel312.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel312.setForeground(new java.awt.Color(255, 255, 255));
        jLabel312.setText("Width");
        IDPOtherPanel.add(jLabel312, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jLabel313.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel313.setForeground(new java.awt.Color(255, 255, 255));
        jLabel313.setText("Quantity");
        IDPOtherPanel.add(jLabel313, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jLabel314.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel314.setForeground(new java.awt.Color(255, 255, 255));
        jLabel314.setText("Rate");
        IDPOtherPanel.add(jLabel314, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        jLabel315.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel315.setForeground(new java.awt.Color(255, 255, 255));
        jLabel315.setText("Amount");
        IDPOtherPanel.add(jLabel315, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        SPRFSheetColourCombo9.setBackground(new java.awt.Color(51, 51, 51));
        SPRFSheetColourCombo9.setEditable(true);
        SPRFSheetColourCombo9.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPRFSheetColourCombo9.setForeground(new java.awt.Color(255, 255, 255));
        SPRFSheetColourCombo9.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select or Type Colour", "Autom Red", "Magenta", "Maroon", "Lazurite Blue", "Beige", "Pearl Brown", "Mist Green", "Dark Green", "Ocean Green", "Galvenize" }));
        IDPOtherPanel.add(SPRFSheetColourCombo9, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 220, -1));

        jLabel316.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel316.setForeground(new java.awt.Color(255, 255, 255));
        jLabel316.setText("Height");
        IDPOtherPanel.add(jLabel316, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        SPItemsDetailsPanel.add(IDPOtherPanel, "card10");

        CPSalesPanel.add(SPItemsDetailsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 550, 240));

        SPTotalTaxLable.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPTotalTaxLable.setForeground(new java.awt.Color(255, 255, 255));
        SPTotalTaxLable.setText("Net Amount");
        CPSalesPanel.add(SPTotalTaxLable, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 670, -1, 30));

        SPNetAmountTF.setEditable(false);
        SPNetAmountTF.setBackground(new java.awt.Color(102, 102, 102));
        SPNetAmountTF.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPNetAmountTF.setForeground(new java.awt.Color(255, 255, 255));
        SPNetAmountTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CPSalesPanel.add(SPNetAmountTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 670, 180, 30));

        SPPresentageMarkTF.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        SPPresentageMarkTF.setForeground(new java.awt.Color(255, 255, 255));
        SPPresentageMarkTF.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SPPresentageMarkTF.setText("%");
        CPSalesPanel.add(SPPresentageMarkTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 670, 30, 30));

        SPTaxLable.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPTaxLable.setForeground(new java.awt.Color(255, 255, 255));
        SPTaxLable.setText("Tax");
        CPSalesPanel.add(SPTaxLable, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 670, -1, 30));

        SPTaxPercentageTF.setBackground(new java.awt.Color(102, 102, 102));
        SPTaxPercentageTF.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPTaxPercentageTF.setForeground(new java.awt.Color(255, 255, 255));
        SPTaxPercentageTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        SPTaxPercentageTF.setText("0");
        SPTaxPercentageTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SPTaxPercentageTFKeyReleased(evt);
            }
        });
        CPSalesPanel.add(SPTaxPercentageTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 670, 80, 30));

        SPTaxLable1.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPTaxLable1.setForeground(new java.awt.Color(255, 255, 255));
        SPTaxLable1.setText("Tax Amount");
        CPSalesPanel.add(SPTaxLable1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 670, -1, 30));

        SPTaxAmountTF.setEditable(false);
        SPTaxAmountTF.setBackground(new java.awt.Color(102, 102, 102));
        SPTaxAmountTF.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPTaxAmountTF.setForeground(new java.awt.Color(255, 255, 255));
        SPTaxAmountTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        SPTaxAmountTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SPTaxAmountTFKeyReleased(evt);
            }
        });
        CPSalesPanel.add(SPTaxAmountTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 670, 150, 30));

        SPPrintBill.setBackground(new java.awt.Color(51, 51, 51));
        SPPrintBill.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        SPPrintBill.setForeground(new java.awt.Color(255, 255, 255));
        SPPrintBill.setText("Print Bill");
        SPPrintBill.setMaximumSize(new java.awt.Dimension(171, 25));
        SPPrintBill.setMinimumSize(new java.awt.Dimension(171, 25));
        SPPrintBill.setPreferredSize(new java.awt.Dimension(171, 25));
        SPPrintBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SPPrintBillActionPerformed(evt);
            }
        });
        CPSalesPanel.add(SPPrintBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 660, 120, 40));

        AddItemToTableBtn.setBackground(new java.awt.Color(51, 51, 51));
        AddItemToTableBtn.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        AddItemToTableBtn.setForeground(new java.awt.Color(255, 255, 255));
        AddItemToTableBtn.setText("Add Item to Table");
        AddItemToTableBtn.setMaximumSize(new java.awt.Dimension(171, 25));
        AddItemToTableBtn.setMinimumSize(new java.awt.Dimension(171, 25));
        AddItemToTableBtn.setPreferredSize(new java.awt.Dimension(171, 25));
        AddItemToTableBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddItemToTableBtnActionPerformed(evt);
            }
        });
        CPSalesPanel.add(AddItemToTableBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, -1, 40));

        jButton3.setBackground(new java.awt.Color(51, 51, 51));
        jButton3.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Remove Selected Raw");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        CPSalesPanel.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 480, -1, 40));

        jButton4.setBackground(new java.awt.Color(51, 51, 51));
        jButton4.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Remove All");
        jButton4.setMaximumSize(new java.awt.Dimension(171, 25));
        jButton4.setMinimumSize(new java.awt.Dimension(171, 25));
        jButton4.setPreferredSize(new java.awt.Dimension(171, 25));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        CPSalesPanel.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 480, -1, 40));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        SPCustomerOrderTable.setBackground(new java.awt.Color(51, 51, 51));
        SPCustomerOrderTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        SPCustomerOrderTable.setForeground(new java.awt.Color(255, 255, 255));
        SPCustomerOrderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Name", "Code", "Thikness", "Colour", "Ent. Unit", "Size", "Sel. Unit", "Size", "Curve Width", "Height", "Width", "Unit", "Quantity", "Rate", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        SPCustomerOrderTable.setFillsViewportHeight(true);
        SPCustomerOrderTable.setFocusable(false);
        SPCustomerOrderTable.setMaximumSize(new java.awt.Dimension(1300, 1000));
        SPCustomerOrderTable.setMinimumSize(new java.awt.Dimension(1300, 160));
        SPCustomerOrderTable.setPreferredSize(new java.awt.Dimension(1300, 1000));
        jScrollPane1.setViewportView(SPCustomerOrderTable);

        CPSalesPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, 1120, 130));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Customer Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("MS Reference Sans Serif", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel3.setOpaque(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SPCustomerNameLable.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPCustomerNameLable.setForeground(new java.awt.Color(255, 255, 255));
        SPCustomerNameLable.setText("Customer Name");
        jPanel3.add(SPCustomerNameLable, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        SPCustomerNameorNICNoLabel.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPCustomerNameorNICNoLabel.setForeground(new java.awt.Color(255, 255, 255));
        SPCustomerNameorNICNoLabel.setText("Customer Name/NIC No.");
        jPanel3.add(SPCustomerNameorNICNoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel14.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Contact Number");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        SPCustomerNameorNICNoTF.setBackground(new java.awt.Color(102, 102, 102));
        SPCustomerNameorNICNoTF.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPCustomerNameorNICNoTF.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(SPCustomerNameorNICNoTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 280, -1));

        SPAddresTA.setBackground(new java.awt.Color(102, 102, 102));
        SPAddresTA.setColumns(20);
        SPAddresTA.setForeground(new java.awt.Color(255, 255, 255));
        SPAddresTA.setRows(5);
        jScrollPane2.setViewportView(SPAddresTA);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 280, 70));

        SPCustomerSearchCB.setEditable(true);
        SPCustomerSearchCB.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPCustomerSearchCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Please Type Customer Name" }));
        SPCustomerSearchCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SPCustomerSearchCBActionPerformed(evt);
            }
        });
        jPanel3.add(SPCustomerSearchCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 280, -1));

        jLabel17.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Address");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        SPContactNoTF.setBackground(new java.awt.Color(102, 102, 102));
        SPContactNoTF.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPContactNoTF.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(SPContactNoTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 280, -1));

        SPCustomerIDLable.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPCustomerIDLable.setForeground(new java.awt.Color(255, 255, 255));
        SPCustomerIDLable.setText("Customer ID");
        jPanel3.add(SPCustomerIDLable, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        SPCustomerIDTF.setEditable(false);
        SPCustomerIDTF.setBackground(new java.awt.Color(102, 102, 102));
        SPCustomerIDTF.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPCustomerIDTF.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(SPCustomerIDTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 280, -1));

        CPSalesPanel.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 10, 490, 280));

        jLabel15.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Payment Method");
        CPSalesPanel.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 300, -1, 30));

        SPPaymentMethodsCB.setBackground(new java.awt.Color(51, 51, 51));
        SPPaymentMethodsCB.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPPaymentMethodsCB.setForeground(new java.awt.Color(255, 255, 255));
        SPPaymentMethodsCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cash", "Credit", "Cheque" }));
        SPPaymentMethodsCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SPPaymentMethodsCBActionPerformed(evt);
            }
        });
        CPSalesPanel.add(SPPaymentMethodsCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 300, 280, -1));

        SPPaymentMethodsPnl.setOpaque(false);
        SPPaymentMethodsPnl.setLayout(new java.awt.CardLayout());

        SPChequeDetailsPnl.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Cheque Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("MS Reference Sans Serif", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        SPChequeDetailsPnl.setOpaque(false);
        SPChequeDetailsPnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Date of Cheque");
        SPChequeDetailsPnl.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, 40));

        jLabel18.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Cheque Number");
        SPChequeDetailsPnl.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 30));

        jLabel19.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Bank");
        SPChequeDetailsPnl.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, 40));

        SPChequeNoTF.setBackground(new java.awt.Color(102, 102, 102));
        SPChequeNoTF.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPChequeNoTF.setForeground(new java.awt.Color(255, 255, 255));
        SPChequeDetailsPnl.add(SPChequeNoTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 260, -1));

        SPBankNameTF.setBackground(new java.awt.Color(102, 102, 102));
        SPBankNameTF.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPBankNameTF.setForeground(new java.awt.Color(255, 255, 255));
        SPChequeDetailsPnl.add(SPBankNameTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 260, -1));

        SPChequeDateDC.setToolTipText("Year - Month - Date");
        SPChequeDateDC.setDateFormatString("yyyy-MM-dd");
        SPChequeDateDC.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        SPChequeDetailsPnl.add(SPChequeDateDC, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 260, -1));

        jLabel25.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Cheque Amount");
        SPChequeDetailsPnl.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, 30));

        SPChequeAmountTF.setBackground(new java.awt.Color(102, 102, 102));
        SPChequeAmountTF.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPChequeAmountTF.setForeground(new java.awt.Color(255, 255, 255));
        SPChequeAmountTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SPChequeAmountTFKeyTyped(evt);
            }
        });
        SPChequeDetailsPnl.add(SPChequeAmountTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 260, -1));

        SPPaymentMethodsPnl.add(SPChequeDetailsPnl, "card2");

        SPCreditDetailsPnl.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Credit Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("MS Reference Sans Serif", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        SPCreditDetailsPnl.setOpaque(false);
        SPCreditDetailsPnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("First payment");
        SPCreditDetailsPnl.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, 30));

        jLabel22.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("NIC Number");
        SPCreditDetailsPnl.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, 30));

        jLabel23.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Contact Number");
        SPCreditDetailsPnl.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 130, 30));

        SPPaymentMethodCreditContactTF.setBackground(new java.awt.Color(102, 102, 102));
        SPPaymentMethodCreditContactTF.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPPaymentMethodCreditContactTF.setForeground(new java.awt.Color(255, 255, 255));
        SPCreditDetailsPnl.add(SPPaymentMethodCreditContactTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 220, -1));

        SPPaymentMethodFirstPaymentTF.setBackground(new java.awt.Color(102, 102, 102));
        SPPaymentMethodFirstPaymentTF.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPPaymentMethodFirstPaymentTF.setForeground(new java.awt.Color(255, 255, 255));
        SPPaymentMethodFirstPaymentTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SPPaymentMethodFirstPaymentTFKeyTyped(evt);
            }
        });
        SPCreditDetailsPnl.add(SPPaymentMethodFirstPaymentTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 220, -1));

        SPPaymentMethodCreditNICTF.setBackground(new java.awt.Color(102, 102, 102));
        SPPaymentMethodCreditNICTF.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPPaymentMethodCreditNICTF.setForeground(new java.awt.Color(255, 255, 255));
        SPCreditDetailsPnl.add(SPPaymentMethodCreditNICTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 220, -1));

        SPPaymentMethodsPnl.add(SPCreditDetailsPnl, "card3");

        CashDetailsPnl.setOpaque(false);
        CashDetailsPnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SPPayMethodCashTotalPayTF.setBackground(new java.awt.Color(102, 102, 102));
        SPPayMethodCashTotalPayTF.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPPayMethodCashTotalPayTF.setForeground(new java.awt.Color(255, 255, 255));
        CashDetailsPnl.add(SPPayMethodCashTotalPayTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 210, -1));

        SPCustomerNameorNICNoLabel1.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPCustomerNameorNICNoLabel1.setForeground(new java.awt.Color(255, 255, 255));
        SPCustomerNameorNICNoLabel1.setText("Total Payment");
        CashDetailsPnl.add(SPCustomerNameorNICNoLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 120, 30));

        SPPaymentMethodsPnl.add(CashDetailsPnl, "card4");

        CPSalesPanel.add(SPPaymentMethodsPnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 330, 490, -1));

        jLabel20.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Total Amount");
        CPSalesPanel.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 670, -1, 30));

        SalesTotalAmountTF.setEditable(false);
        SalesTotalAmountTF.setBackground(new java.awt.Color(102, 102, 102));
        SalesTotalAmountTF.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SalesTotalAmountTF.setForeground(new java.awt.Color(255, 255, 255));
        SalesTotalAmountTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CPSalesPanel.add(SalesTotalAmountTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 670, 190, 30));

        jLabel3.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Item Catogary");
        CPSalesPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, 30));

        SPItemCatComboBox.setBackground(new java.awt.Color(51, 51, 51));
        SPItemCatComboBox.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPItemCatComboBox.setForeground(new java.awt.Color(255, 255, 255));
        SPItemCatComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Roofing Sheet", "Curved Roofing Sheet", "Roller Door", "Roller Shutter", "Purlin", "Gutter", "Gate", "Plain Sheet", "Cladding" }));
        SPItemCatComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SPItemCatComboBoxActionPerformed(evt);
            }
        });
        CPSalesPanel.add(SPItemCatComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 310, -1));

        SPSearchItemLable.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPSearchItemLable.setForeground(new java.awt.Color(255, 255, 255));
        SPSearchItemLable.setText("Search Item");
        CPSalesPanel.add(SPSearchItemLable, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, 30));

        SPSearchItemNameORCodeCB.setBackground(new java.awt.Color(51, 51, 51));
        SPSearchItemNameORCodeCB.setEditable(true);
        SPSearchItemNameORCodeCB.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPSearchItemNameORCodeCB.setForeground(new java.awt.Color(255, 255, 255));
        SPSearchItemNameORCodeCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Please type Item Name or Code" }));
        SPSearchItemNameORCodeCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SPSearchItemNameORCodeCBActionPerformed(evt);
            }
        });
        CPSalesPanel.add(SPSearchItemNameORCodeCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 310, -1));

        SPItemNameORCodeLable.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPItemNameORCodeLable.setForeground(new java.awt.Color(255, 255, 255));
        SPItemNameORCodeLable.setText("Item Name/Code");
        CPSalesPanel.add(SPItemNameORCodeLable, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, 30));

        SPItemNameOrCodeTF.setEditable(false);
        SPItemNameOrCodeTF.setBackground(new java.awt.Color(102, 102, 102));
        SPItemNameOrCodeTF.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPItemNameOrCodeTF.setForeground(new java.awt.Color(255, 255, 255));
        CPSalesPanel.add(SPItemNameOrCodeTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 310, -1));

        jLabel12.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Sales Order No.");
        CPSalesPanel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, 30));

        SPSalesOrderNo.setEditable(false);
        SPSalesOrderNo.setBackground(new java.awt.Color(102, 102, 102));
        SPSalesOrderNo.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        SPSalesOrderNo.setForeground(new java.awt.Color(255, 255, 255));
        SPSalesOrderNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SPSalesOrderNoActionPerformed(evt);
            }
        });
        CPSalesPanel.add(SPSalesOrderNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 220, -1));

        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel33.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel33.setMaximumSize(new java.awt.Dimension(1140, 710));
        jLabel33.setMinimumSize(new java.awt.Dimension(1140, 710));
        jLabel33.setPreferredSize(new java.awt.Dimension(1140, 710));
        CPSalesPanel.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, -1));

        SalesContentPanel.add(CPSalesPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        SalesMainPanel.add(SalesContentPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, -1, -1));

        SPMainBGLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Background/MainPanelBGIMG.jpg"))); // NOI18N
        SalesMainPanel.add(SPMainBGLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SalesMainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(SalesMainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void SPPaymentsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPPaymentsBtnActionPerformed
        try {
            PaymentJF NewSalesJF = new PaymentJF();
            NewSalesJF.setVisible(true);
            this.dispose();
        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_SPPaymentsBtnActionPerformed

    private void SPExitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPExitBtnActionPerformed
        try {
            DashBoardJF NewDashBoard = new DashBoardJF();
            NewDashBoard.setVisible(true);
            this.dispose();
        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_SPExitBtnActionPerformed

    private void SPSalesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPSalesBtnActionPerformed
        try {

        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_SPSalesBtnActionPerformed

    private void SPMinimizeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPMinimizeBtnActionPerformed
        this.setState(ICONIFIED);        // TODO add your handling code here:
    }//GEN-LAST:event_SPMinimizeBtnActionPerformed

    private void SPFinishedItemsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPFinishedItemsBtnActionPerformed
        try {
            FinishedItemsJF NewSalesJF = new FinishedItemsJF();
            NewSalesJF.setVisible(true);
            this.dispose();
        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_SPFinishedItemsBtnActionPerformed

    private void SPRFSheetSizeTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPRFSheetSizeTFKeyReleased
        try {

            UnitConverter4RoofingSheet();

            String Size = SPRFSheetSizeConvertedTF.getText();
            String Qty = SPRFSheetQtyTF.getText();
            String RateTF = SPRFSheetRateTF.getText();
            String Unit2 = SPRFSheetUnit02CB.getSelectedItem().toString();
            CalculateAmount(Size, Qty, RateTF, Unit2);

            Double getDoubleValue = CalculateAmount(Size, Qty, RateTF, Unit2);
            String DoubleValueString = Double.toString(getDoubleValue);
            SPRFSheetAmountTF.setText(DoubleValueString);
        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_SPRFSheetSizeTFKeyReleased

    private void SPRFSheetQtyTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPRFSheetQtyTFKeyReleased
        try {
            String Size = SPRFSheetSizeConvertedTF.getText();
            String Qty = SPRFSheetQtyTF.getText();
            String RateTF = SPRFSheetRateTF.getText();
            String Unit2 = SPRFSheetUnit02CB.getSelectedItem().toString();
            CalculateAmount(Size, Qty, RateTF, Unit2);

            Double getDoubleValue = CalculateAmount(Size, Qty, RateTF, Unit2);
            String DoubleValueString = Double.toString(getDoubleValue);
            SPRFSheetAmountTF.setText(DoubleValueString);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please Enter Valied Number");
        }
    }//GEN-LAST:event_SPRFSheetQtyTFKeyReleased

    private void SPRFSheetRateTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPRFSheetRateTFKeyReleased
        try {
            String Size = SPRFSheetSizeConvertedTF.getText();
            String Qty = SPRFSheetQtyTF.getText();
            String RateTF = SPRFSheetRateTF.getText();
            String Unit2 = SPRFSheetUnit02CB.getSelectedItem().toString();
            CalculateAmount(Size, Qty, RateTF, Unit2);

            Double getDoubleValue = CalculateAmount(Size, Qty, RateTF, Unit2);
            String DoubleValueString = Double.toString(getDoubleValue);
            SPRFSheetAmountTF.setText(DoubleValueString);
        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_SPRFSheetRateTFKeyReleased

    private void SPRFSheetUnit02CBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPRFSheetUnit02CBActionPerformed
        try {
            UnitConverter4RoofingSheet();

            String Size = SPRFSheetSizeConvertedTF.getText();
            String Qty = SPRFSheetQtyTF.getText();
            String RateTF = SPRFSheetRateTF.getText();
            String Unit2 = SPRFSheetUnit02CB.getSelectedItem().toString();
            CalculateAmount(Size, Qty, RateTF, Unit2);

            Double getDoubleValue = CalculateAmount(Size, Qty, RateTF, Unit2);
            String DoubleValueString = Double.toString(getDoubleValue);
            SPRFSheetAmountTF.setText(DoubleValueString);
        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_SPRFSheetUnit02CBActionPerformed

    private void SPRFSheetUnit01CBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPRFSheetUnit01CBActionPerformed
        try {
            UnitConverter4RoofingSheet();
            //           CalculateAmount();
        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_SPRFSheetUnit01CBActionPerformed

    private void SPCurveRFShtSizeCBKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPCurveRFShtSizeCBKeyReleased
        UnitConverter4CurveSheet();

        String Size = SPCurveRFConvertedSizeTF.getText();
        String Qty = SPCurveRFShtQtyTF.getText();
        String RateTF = SPCurveRFShtRateTF.getText();
        String Unit2 = SPCurveRFShtUnit02CB.getSelectedItem().toString();
        CalculateAmount(Size, Qty, RateTF, Unit2);

        Double getDoubleValue = CalculateAmount(Size, Qty, RateTF, Unit2);
        String DoubleValueString = Double.toString(getDoubleValue);
        SPCurveRFShtAmountTF.setText(DoubleValueString);
    }//GEN-LAST:event_SPCurveRFShtSizeCBKeyReleased

    private void SPCurveRFShtCurveWidthTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPCurveRFShtCurveWidthTFKeyReleased
        String Size = SPCurveRFConvertedSizeTF.getText();
        String Qty = SPCurveRFShtQtyTF.getText();
        String RateTF = SPCurveRFShtRateTF.getText();
        String Unit2 = SPCurveRFShtUnit02CB.getSelectedItem().toString();
        CalculateAmount(Size, Qty, RateTF, Unit2);

        Double getDoubleValue = CalculateAmount(Size, Qty, RateTF, Unit2);
        String DoubleValueString = Double.toString(getDoubleValue);
        SPCurveRFShtAmountTF.setText(DoubleValueString);
    }//GEN-LAST:event_SPCurveRFShtCurveWidthTFKeyReleased

    private void SPCurveRFShtRateTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPCurveRFShtRateTFKeyReleased

        String Size = SPCurveRFConvertedSizeTF.getText();
        String Qty = SPCurveRFShtQtyTF.getText();
        String RateTF = SPCurveRFShtRateTF.getText();
        String Unit2 = SPCurveRFShtUnit02CB.getSelectedItem().toString();
        CalculateAmount(Size, Qty, RateTF, Unit2);

        Double getDoubleValue = CalculateAmount(Size, Qty, RateTF, Unit2);
        String DoubleValueString = Double.toString(getDoubleValue);
        SPCurveRFShtAmountTF.setText(DoubleValueString);
    }//GEN-LAST:event_SPCurveRFShtRateTFKeyReleased

    private void SPCurveRFShtUnit02CBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPCurveRFShtUnit02CBActionPerformed
        UnitConverter4CurveSheet();

        String Size = SPCurveRFConvertedSizeTF.getText();
        String Qty = SPCurveRFShtQtyTF.getText();
        String RateTF = SPCurveRFShtRateTF.getText();
        String Unit2 = SPCurveRFShtUnit02CB.getSelectedItem().toString();
        CalculateAmount(Size, Qty, RateTF, Unit2);

        Double getDoubleValue = CalculateAmount(Size, Qty, RateTF, Unit2);
        String DoubleValueString = Double.toString(getDoubleValue);
        SPCurveRFShtAmountTF.setText(DoubleValueString);
    }//GEN-LAST:event_SPCurveRFShtUnit02CBActionPerformed

    private void SPCurveRFShtUnit01CBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPCurveRFShtUnit01CBActionPerformed
        UnitConverter4CurveSheet();

        String Size = SPCurveRFConvertedSizeTF.getText();
        String Qty = SPCurveRFShtQtyTF.getText();
        String RateTF = SPCurveRFShtRateTF.getText();
        String Unit2 = SPCurveRFShtUnit02CB.getSelectedItem().toString();
        CalculateAmount(Size, Qty, RateTF, Unit2);

        Double getDoubleValue = CalculateAmount(Size, Qty, RateTF, Unit2);
        String DoubleValueString = Double.toString(getDoubleValue);
        SPCurveRFShtAmountTF.setText(DoubleValueString);
    }//GEN-LAST:event_SPCurveRFShtUnit01CBActionPerformed

    private void SPCurveRFShtQtyTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPCurveRFShtQtyTFKeyReleased

        String Size = SPCurveRFConvertedSizeTF.getText();
        String Qty = SPCurveRFShtQtyTF.getText();
        String RateTF = SPCurveRFShtRateTF.getText();
        String Unit2 = SPCurveRFShtUnit02CB.getSelectedItem().toString();
        CalculateAmount(Size, Qty, RateTF, Unit2);

        Double getDoubleValue = CalculateAmount(Size, Qty, RateTF, Unit2);
        String DoubleValueString = Double.toString(getDoubleValue);
        SPCurveRFShtAmountTF.setText(DoubleValueString);
    }//GEN-LAST:event_SPCurveRFShtQtyTFKeyReleased

    private void SPRollerDoorWidthTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPRollerDoorWidthTFKeyReleased
        String RDHeight = SPRollerDoorHeightTF.getText();
        String RDHeightUnit = SPRollerDoorWidthHeightUnitCB.getSelectedItem().toString();
        String RDWidth = SPRollerDoorWidthTF.getText();
        String RDQty = SPRollerDoorQtyTF.getText();
        String RDRate = SPRollerDoorRateTF.getText();

        RollerDoorCalculateAmount(RDHeight, RDHeightUnit, RDWidth, RDQty, RDRate);
        String GetReturnedValue = RollerDoorCalculateAmount(RDHeight, RDHeightUnit, RDWidth, RDQty, RDRate);
        SPRollerDoorAmountTF.setText(GetReturnedValue);
    }//GEN-LAST:event_SPRollerDoorWidthTFKeyReleased

    private void SPRollerDoorQtyTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPRollerDoorQtyTFKeyReleased
        String RDHeight = SPRollerDoorHeightTF.getText();
        String RDHeightUnit = SPRollerDoorWidthHeightUnitCB.getSelectedItem().toString();
        String RDWidth = SPRollerDoorWidthTF.getText();
        String RDQty = SPRollerDoorQtyTF.getText();
        String RDRate = SPRollerDoorRateTF.getText();

        RollerDoorCalculateAmount(RDHeight, RDHeightUnit, RDWidth, RDQty, RDRate);
        String GetReturnedValue = RollerDoorCalculateAmount(RDHeight, RDHeightUnit, RDWidth, RDQty, RDRate);
        SPRollerDoorAmountTF.setText(GetReturnedValue);
    }//GEN-LAST:event_SPRollerDoorQtyTFKeyReleased

    private void SPRollerDoorRateTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPRollerDoorRateTFKeyReleased

        String RDHeight = SPRollerDoorHeightTF.getText();
        String RDHeightUnit = SPRollerDoorWidthHeightUnitCB.getSelectedItem().toString();
        String RDWidth = SPRollerDoorWidthTF.getText();
        String RDQty = SPRollerDoorQtyTF.getText();
        String RDRate = SPRollerDoorRateTF.getText();

        RollerDoorCalculateAmount(RDHeight, RDHeightUnit, RDWidth, RDQty, RDRate);
        String GetReturnedValue = RollerDoorCalculateAmount(RDHeight, RDHeightUnit, RDWidth, RDQty, RDRate);
        SPRollerDoorAmountTF.setText(GetReturnedValue);
    }//GEN-LAST:event_SPRollerDoorRateTFKeyReleased

    private void SPRollerDoorHeightTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPRollerDoorHeightTFKeyReleased
        String RDHeight = SPRollerDoorHeightTF.getText();
        String RDHeightUnit = SPRollerDoorWidthHeightUnitCB.getSelectedItem().toString();
        String RDWidth = SPRollerDoorWidthTF.getText();
        String RDQty = SPRollerDoorQtyTF.getText();
        String RDRate = SPRollerDoorRateTF.getText();

        RollerDoorCalculateAmount(RDHeight, RDHeightUnit, RDWidth, RDQty, RDRate);
        String GetReturnedValue = RollerDoorCalculateAmount(RDHeight, RDHeightUnit, RDWidth, RDQty, RDRate);
        SPRollerDoorAmountTF.setText(GetReturnedValue);
    }//GEN-LAST:event_SPRollerDoorHeightTFKeyReleased

    private void SPRollerDoorWidthHeightUnitCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPRollerDoorWidthHeightUnitCBActionPerformed
        try {
            String RDHeight = SPRollerDoorHeightTF.getText();
            String RDHeightUnit = SPRollerDoorWidthHeightUnitCB.getSelectedItem().toString();
            String RDWidth = SPRollerDoorWidthTF.getText();
            String RDQty = SPRollerDoorQtyTF.getText();
            String RDRate = SPRollerDoorRateTF.getText();

            RollerDoorCalculateAmount(RDHeight, RDHeightUnit, RDWidth, RDQty, RDRate);
            String GetReturnedValue = RollerDoorCalculateAmount(RDHeight, RDHeightUnit, RDWidth, RDQty, RDRate);
            SPRollerDoorAmountTF.setText(GetReturnedValue);

        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_SPRollerDoorWidthHeightUnitCBActionPerformed

    private void SPRollerShutterWidthTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPRollerShutterWidthTFKeyReleased
        String RDHeight = SPRollerShutterHeightTF.getText();
        String RDHeightUnit = SPRollerShutterWidthHeightUnitCB.getSelectedItem().toString();
        String RDWidth = SPRollerShutterWidthTF.getText();
        String RDQty = SPRollerShutterQtyTF.getText();
        String RDRate = SPRollerShutterRateTF.getText();

        RollerDoorCalculateAmount(RDHeight, RDHeightUnit, RDWidth, RDQty, RDRate);
        String GetReturnedValue = RollerDoorCalculateAmount(RDHeight, RDHeightUnit, RDWidth, RDQty, RDRate);
        SPRollerShutterAmountTF.setText(GetReturnedValue);
    }//GEN-LAST:event_SPRollerShutterWidthTFKeyReleased

    private void SPRollerShutterQtyTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPRollerShutterQtyTFKeyReleased
        String RDHeight = SPRollerShutterHeightTF.getText();
        String RDHeightUnit = SPRollerShutterWidthHeightUnitCB.getSelectedItem().toString();
        String RDWidth = SPRollerShutterWidthTF.getText();
        String RDQty = SPRollerShutterQtyTF.getText();
        String RDRate = SPRollerShutterRateTF.getText();

        RollerDoorCalculateAmount(RDHeight, RDHeightUnit, RDWidth, RDQty, RDRate);
        String GetReturnedValue = RollerDoorCalculateAmount(RDHeight, RDHeightUnit, RDWidth, RDQty, RDRate);
        SPRollerShutterAmountTF.setText(GetReturnedValue);
    }//GEN-LAST:event_SPRollerShutterQtyTFKeyReleased

    private void SPRollerShutterRateTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPRollerShutterRateTFKeyReleased

        String RDHeight = SPRollerShutterHeightTF.getText();
        String RDHeightUnit = SPRollerShutterWidthHeightUnitCB.getSelectedItem().toString();
        String RDWidth = SPRollerShutterWidthTF.getText();
        String RDQty = SPRollerShutterQtyTF.getText();
        String RDRate = SPRollerShutterRateTF.getText();

        RollerDoorCalculateAmount(RDHeight, RDHeightUnit, RDWidth, RDQty, RDRate);
        String GetReturnedValue = RollerDoorCalculateAmount(RDHeight, RDHeightUnit, RDWidth, RDQty, RDRate);
        SPRollerShutterAmountTF.setText(GetReturnedValue);
    }//GEN-LAST:event_SPRollerShutterRateTFKeyReleased

    private void SPRollerShutterHeightTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPRollerShutterHeightTFKeyReleased
        String RDHeight = SPRollerShutterHeightTF.getText();
        String RDHeightUnit = SPRollerShutterWidthHeightUnitCB.getSelectedItem().toString();
        String RDWidth = SPRollerShutterWidthTF.getText();
        String RDQty = SPRollerShutterQtyTF.getText();
        String RDRate = SPRollerShutterRateTF.getText();

        RollerDoorCalculateAmount(RDHeight, RDHeightUnit, RDWidth, RDQty, RDRate);
        String GetReturnedValue = RollerDoorCalculateAmount(RDHeight, RDHeightUnit, RDWidth, RDQty, RDRate);
        SPRollerShutterAmountTF.setText(GetReturnedValue);
    }//GEN-LAST:event_SPRollerShutterHeightTFKeyReleased

    private void SPRollerShutterWidthHeightUnitCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPRollerShutterWidthHeightUnitCBActionPerformed
        String RDHeight = SPRollerShutterHeightTF.getText();
        String RDHeightUnit = SPRollerShutterWidthHeightUnitCB.getSelectedItem().toString();
        String RDWidth = SPRollerShutterWidthTF.getText();
        String RDQty = SPRollerShutterQtyTF.getText();
        String RDRate = SPRollerShutterRateTF.getText();

        RollerDoorCalculateAmount(RDHeight, RDHeightUnit, RDWidth, RDQty, RDRate);
        String GetReturnedValue = RollerDoorCalculateAmount(RDHeight, RDHeightUnit, RDWidth, RDQty, RDRate);
        SPRollerShutterAmountTF.setText(GetReturnedValue);
    }//GEN-LAST:event_SPRollerShutterWidthHeightUnitCBActionPerformed

    private void SPPurlinThiknessTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPPurlinThiknessTFKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_SPPurlinThiknessTFKeyReleased

    private void SPPurlinQtyTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPPurlinQtyTFKeyReleased
        try {
            String Size = SPPurlinLengthTF.getText();
            String Qty = SPPurlinQtyTF.getText();
            String RateTF = SPPurlinRateTF.getText();
            String Unit2 = SPPurlinUnitCB.getSelectedItem().toString();
            CalculateAmount(Size, Qty, RateTF, Unit2);

            Double getDoubleValue = CalculateAmount(Size, Qty, RateTF, Unit2);
            String DoubleValueString = Double.toString(getDoubleValue);
            SPPurlinAmountTF.setText(DoubleValueString);
        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_SPPurlinQtyTFKeyReleased

    private void SPPurlinRateTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPPurlinRateTFKeyReleased
        try {
            String Size = SPPurlinLengthTF.getText();
            String Qty = SPPurlinQtyTF.getText();
            String RateTF = SPPurlinRateTF.getText();
            String Unit2 = SPPurlinUnitCB.getSelectedItem().toString();
            CalculateAmount(Size, Qty, RateTF, Unit2);

            Double getDoubleValue = CalculateAmount(Size, Qty, RateTF, Unit2);
            String DoubleValueString = Double.toString(getDoubleValue);
            SPPurlinAmountTF.setText(DoubleValueString);
        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_SPPurlinRateTFKeyReleased

    private void SPPurlinLengthTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPPurlinLengthTFKeyReleased
        try {
            String Size = SPPurlinLengthTF.getText();
            String Qty = SPPurlinQtyTF.getText();
            String RateTF = SPPurlinRateTF.getText();
            String Unit2 = SPPurlinUnitCB.getSelectedItem().toString();
            CalculateAmount(Size, Qty, RateTF, Unit2);

            Double getDoubleValue = CalculateAmount(Size, Qty, RateTF, Unit2);
            String DoubleValueString = Double.toString(getDoubleValue);
            SPPurlinAmountTF.setText(DoubleValueString);
        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_SPPurlinLengthTFKeyReleased

    private void SPPurlinUnitCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPPurlinUnitCBActionPerformed
        try {
            String Size = SPPurlinLengthTF.getText();
            String Qty = SPPurlinQtyTF.getText();
            String RateTF = SPPurlinRateTF.getText();
            String Unit2 = SPPurlinUnitCB.getSelectedItem().toString();
            CalculateAmount(Size, Qty, RateTF, Unit2);

            Double getDoubleValue = CalculateAmount(Size, Qty, RateTF, Unit2);
            String DoubleValueString = Double.toString(getDoubleValue);
            SPPurlinAmountTF.setText(DoubleValueString);
        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_SPPurlinUnitCBActionPerformed

    private void SPGutterThiknessTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPGutterThiknessTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SPGutterThiknessTFActionPerformed

    private void SPGutterThiknessTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPGutterThiknessTFKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_SPGutterThiknessTFKeyReleased

    private void SPGutterQtyTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPGutterQtyTFKeyReleased
        try {
            String Size = SPGutterLengthTF.getText();
            String Qty = SPGutterQtyTF.getText();
            String RateTF = SPGutterRateTF.getText();
            String Unit2 = SPGutterUnitCB.getSelectedItem().toString();
            CalculateAmount(Size, Qty, RateTF, Unit2);

            Double getDoubleValue = CalculateAmount(Size, Qty, RateTF, Unit2);
            String DoubleValueString = Double.toString(getDoubleValue);
            SPGutterAmountTF.setText(DoubleValueString);

        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_SPGutterQtyTFKeyReleased

    private void SPGutterRateTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPGutterRateTFKeyReleased
        try {
            String Size = SPGutterLengthTF.getText();
            String Qty = SPGutterQtyTF.getText();
            String RateTF = SPGutterRateTF.getText();
            String Unit2 = SPGutterUnitCB.getSelectedItem().toString();
            CalculateAmount(Size, Qty, RateTF, Unit2);

            Double getDoubleValue = CalculateAmount(Size, Qty, RateTF, Unit2);
            String DoubleValueString = Double.toString(getDoubleValue);
            SPGutterAmountTF.setText(DoubleValueString);

        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_SPGutterRateTFKeyReleased

    private void SPGutterLengthTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPGutterLengthTFKeyReleased
        try {
            String Size = SPGutterLengthTF.getText();
            String Qty = SPGutterQtyTF.getText();
            String RateTF = SPGutterRateTF.getText();
            String Unit2 = SPGutterUnitCB.getSelectedItem().toString();
            CalculateAmount(Size, Qty, RateTF, Unit2);

            Double getDoubleValue = CalculateAmount(Size, Qty, RateTF, Unit2);
            String DoubleValueString = Double.toString(getDoubleValue);
            SPGutterAmountTF.setText(DoubleValueString);

        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_SPGutterLengthTFKeyReleased

    private void SPGutterUnitCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPGutterUnitCBActionPerformed
        try {
            String Size = SPGutterLengthTF.getText();
            String Qty = SPGutterQtyTF.getText();
            String RateTF = SPGutterRateTF.getText();
            String Unit2 = SPGutterUnitCB.getSelectedItem().toString();
            CalculateAmount(Size, Qty, RateTF, Unit2);

            Double getDoubleValue = CalculateAmount(Size, Qty, RateTF, Unit2);
            String DoubleValueString = Double.toString(getDoubleValue);
            SPGutterAmountTF.setText(DoubleValueString);

        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_SPGutterUnitCBActionPerformed

    private void SPGatesWidthTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPGatesWidthTFKeyReleased
        try {
            String RDHeight = SPGatesHeightTF.getText();
            String RDHeightUnit = SPGatesWidthHeightCB.getSelectedItem().toString();
            String RDWidth = SPGatesWidthTF.getText();
            String RDQty = SPGatesQtyTF.getText();
            String RDRate = SPGatesRateTF.getText();

            RollerDoorCalculateAmount(RDHeight, RDHeightUnit, RDWidth, RDQty, RDRate);
            String GetReturnedValue = RollerDoorCalculateAmount(RDHeight, RDHeightUnit, RDWidth, RDQty, RDRate);
            SPGatesAmountTF.setText(GetReturnedValue);
        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_SPGatesWidthTFKeyReleased

    private void SPGatesQtyTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPGatesQtyTFKeyReleased
        try {
            String RDHeight = SPGatesHeightTF.getText();
            String RDHeightUnit = SPGatesWidthHeightCB.getSelectedItem().toString();
            String RDWidth = SPGatesWidthTF.getText();
            String RDQty = SPGatesQtyTF.getText();
            String RDRate = SPGatesRateTF.getText();

            RollerDoorCalculateAmount(RDHeight, RDHeightUnit, RDWidth, RDQty, RDRate);
            String GetReturnedValue = RollerDoorCalculateAmount(RDHeight, RDHeightUnit, RDWidth, RDQty, RDRate);
            SPGatesAmountTF.setText(GetReturnedValue);
        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_SPGatesQtyTFKeyReleased

    private void SPGatesRateTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPGatesRateTFKeyReleased
        try {
            String RDHeight = SPGatesHeightTF.getText();
            String RDHeightUnit = SPGatesWidthHeightCB.getSelectedItem().toString();
            String RDWidth = SPGatesWidthTF.getText();
            String RDQty = SPGatesQtyTF.getText();
            String RDRate = SPGatesRateTF.getText();

            RollerDoorCalculateAmount(RDHeight, RDHeightUnit, RDWidth, RDQty, RDRate);
            String GetReturnedValue = RollerDoorCalculateAmount(RDHeight, RDHeightUnit, RDWidth, RDQty, RDRate);
            SPGatesAmountTF.setText(GetReturnedValue);
        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_SPGatesRateTFKeyReleased

    private void SPPlainSheetSizeTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPPlainSheetSizeTFKeyReleased
        try {
            UnitConverter4PlainSheet();

            String Size = SPPlainSheetConvertedTF.getText();
            String Qty = SPPlainSheetQtyTF.getText();
            String RateTF = SPPlainSheetRateTF.getText();
            String Unit2 = SPPlainSheetUnit02CB.getSelectedItem().toString();
            CalculateAmount(Size, Qty, RateTF, Unit2);

            Double getDoubleValue = CalculateAmount(Size, Qty, RateTF, Unit2);
            String DoubleValueString = Double.toString(getDoubleValue);
            SPPlainSheetAmountTF.setText(DoubleValueString);
        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_SPPlainSheetSizeTFKeyReleased

    private void SPPlainSheetQtyTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPPlainSheetQtyTFKeyReleased
        try {
            String Size = SPRFSheetSizeConvertedTF.getText();
            String Qty = SPRFSheetQtyTF.getText();
            String RateTF = SPRFSheetRateTF.getText();
            String Unit2 = SPRFSheetUnit02CB.getSelectedItem().toString();
            CalculateAmount(Size, Qty, RateTF, Unit2);

            Double getDoubleValue = CalculateAmount(Size, Qty, RateTF, Unit2);
            String DoubleValueString = Double.toString(getDoubleValue);
            SPRFSheetAmountTF.setText(DoubleValueString);
        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_SPPlainSheetQtyTFKeyReleased

    private void SPPlainSheetRateTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPPlainSheetRateTFKeyReleased
        try {
            String Size = SPPlainSheetConvertedTF.getText();
            String Qty = SPPlainSheetQtyTF.getText();
            String RateTF = SPPlainSheetRateTF.getText();
            String Unit2 = SPPlainSheetUnit02CB.getSelectedItem().toString();
            CalculateAmount(Size, Qty, RateTF, Unit2);

            Double getDoubleValue = CalculateAmount(Size, Qty, RateTF, Unit2);
            String DoubleValueString = Double.toString(getDoubleValue);
            SPPlainSheetAmountTF.setText(DoubleValueString);
        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_SPPlainSheetRateTFKeyReleased

    private void SPPlainSheetUnit02CBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPPlainSheetUnit02CBActionPerformed
        try {
            UnitConverter4PlainSheet();

            String Size = SPPlainSheetConvertedTF.getText();
            String Qty = SPPlainSheetQtyTF.getText();
            String RateTF = SPPlainSheetRateTF.getText();
            String Unit2 = SPPlainSheetUnit02CB.getSelectedItem().toString();
            CalculateAmount(Size, Qty, RateTF, Unit2);

            Double getDoubleValue = CalculateAmount(Size, Qty, RateTF, Unit2);
            String DoubleValueString = Double.toString(getDoubleValue);
            SPPlainSheetAmountTF.setText(DoubleValueString);
        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_SPPlainSheetUnit02CBActionPerformed

    private void SPPlainSheetUnit01CBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPPlainSheetUnit01CBActionPerformed
        try {
            UnitConverter4PlainSheet();

            String Size = SPPlainSheetConvertedTF.getText();
            String Qty = SPPlainSheetQtyTF.getText();
            String RateTF = SPPlainSheetRateTF.getText();
            String Unit2 = SPPlainSheetUnit02CB.getSelectedItem().toString();
            CalculateAmount(Size, Qty, RateTF, Unit2);

            Double getDoubleValue = CalculateAmount(Size, Qty, RateTF, Unit2);
            String DoubleValueString = Double.toString(getDoubleValue);
            SPPlainSheetAmountTF.setText(DoubleValueString);
        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_SPPlainSheetUnit01CBActionPerformed

    private void SPCladdingSizeTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPCladdingSizeTFKeyReleased
        try {
            UnitConverter4Cladding();

            String Size = SPCladdingConvertedTF.getText();
            String Qty = SPCladdingQtyTF.getText();
            String RateTF = SPCladdingRateTF.getText();
            String Unit2 = SPCladdingUnit02CB.getSelectedItem().toString();
            CalculateAmount(Size, Qty, RateTF, Unit2);

            Double getDoubleValue = CalculateAmount(Size, Qty, RateTF, Unit2);
            String DoubleValueString = Double.toString(getDoubleValue);
            SPCladdingAmountTF.setText(DoubleValueString);
        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_SPCladdingSizeTFKeyReleased

    private void SPCladdingQtyTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPCladdingQtyTFKeyReleased
        try {

            String Size = SPCladdingConvertedTF.getText();
            String Qty = SPCladdingQtyTF.getText();
            String RateTF = SPCladdingRateTF.getText();
            String Unit2 = SPCladdingUnit02CB.getSelectedItem().toString();
            CalculateAmount(Size, Qty, RateTF, Unit2);

            Double getDoubleValue = CalculateAmount(Size, Qty, RateTF, Unit2);
            String DoubleValueString = Double.toString(getDoubleValue);
            SPCladdingAmountTF.setText(DoubleValueString);
        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_SPCladdingQtyTFKeyReleased

    private void SPCladdingRateTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPCladdingRateTFKeyReleased
        try {

            String Size = SPCladdingConvertedTF.getText();
            String Qty = SPCladdingQtyTF.getText();
            String RateTF = SPCladdingRateTF.getText();
            String Unit2 = SPCladdingUnit02CB.getSelectedItem().toString();
            CalculateAmount(Size, Qty, RateTF, Unit2);

            Double getDoubleValue = CalculateAmount(Size, Qty, RateTF, Unit2);
            String DoubleValueString = Double.toString(getDoubleValue);
            SPCladdingAmountTF.setText(DoubleValueString);
        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_SPCladdingRateTFKeyReleased

    private void SPCladdingUnit02CBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPCladdingUnit02CBActionPerformed
        try {
            UnitConverter4Cladding();

            String Size = SPCladdingConvertedTF.getText();
            String Qty = SPCladdingQtyTF.getText();
            String RateTF = SPCladdingRateTF.getText();
            String Unit2 = SPCladdingUnit02CB.getSelectedItem().toString();
            CalculateAmount(Size, Qty, RateTF, Unit2);

            Double getDoubleValue = CalculateAmount(Size, Qty, RateTF, Unit2);
            String DoubleValueString = Double.toString(getDoubleValue);
            SPCladdingAmountTF.setText(DoubleValueString);
        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_SPCladdingUnit02CBActionPerformed

    private void SPCladdingUnit01CBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPCladdingUnit01CBActionPerformed
        try {
            UnitConverter4Cladding();

            String Size = SPCladdingConvertedTF.getText();
            String Qty = SPCladdingQtyTF.getText();
            String RateTF = SPCladdingRateTF.getText();
            String Unit2 = SPCladdingUnit02CB.getSelectedItem().toString();
            CalculateAmount(Size, Qty, RateTF, Unit2);

            Double getDoubleValue = CalculateAmount(Size, Qty, RateTF, Unit2);
            String DoubleValueString = Double.toString(getDoubleValue);
            SPCladdingAmountTF.setText(DoubleValueString);
        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_SPCladdingUnit01CBActionPerformed

    private void SPRFSheetSizeTF9KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPRFSheetSizeTF9KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_SPRFSheetSizeTF9KeyReleased

    private void SPRFSheetQtyTF10KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPRFSheetQtyTF10KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_SPRFSheetQtyTF10KeyReleased

    private void SPRFSheetRateTF9KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPRFSheetRateTF9KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_SPRFSheetRateTF9KeyReleased

    private void SPRFSheetUnit02CB4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPRFSheetUnit02CB4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SPRFSheetUnit02CB4ActionPerformed

    private void SPTaxPercentageTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPTaxPercentageTFKeyReleased
        CalculateTax();
        SPPayMethodCashTotalPayTF.setText(SPNetAmountTF.getText());
    }//GEN-LAST:event_SPTaxPercentageTFKeyReleased

    private void SPTaxAmountTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPTaxAmountTFKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_SPTaxAmountTFKeyReleased

    private void SPPrintBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPPrintBillActionPerformed
        PrintButtonActions();
        SPRFSheetUnit01CB.setEnabled(true);
        SPRFSheetUnit02CB.setEnabled(true);
        SPCurveRFShtUnit01CB.setEnabled(true);
        SPCurveRFShtUnit02CB.setEnabled(true);
    }//GEN-LAST:event_SPPrintBillActionPerformed

    private void AddItemToTableBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddItemToTableBtnActionPerformed
        try {
            if (SPItemNameOrCodeTF.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please Select a Item");

            } else {
                AddItemsToSalesTable();

            }

        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_AddItemToTableBtnActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            RemoveSelectedRawMethod();
            SalesTotalAmountTF.setText(Double.toString(TotalAmount()));
            CalculateTax();

        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            RemoveAllFromTable();
            SalesTotalAmountTF.setText("0");
            SPNetAmountTF.setText("0");
            SPTaxPercentageTF.setText("0");
            SPTaxAmountTF.setText("0");
            SPRFSheetUnit01CB.setEnabled(true);
            SPRFSheetUnit02CB.setEnabled(true);
            SPCurveRFShtUnit01CB.setEnabled(true);
            SPCurveRFShtUnit02CB.setEnabled(true);

        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void SPCustomerSearchCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPCustomerSearchCBActionPerformed
        CustomerComboBox();
        CheckPendingPayment();
    }//GEN-LAST:event_SPCustomerSearchCBActionPerformed

    private void SPPaymentMethodsCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPPaymentMethodsCBActionPerformed
        try {
            PaymentMethods();
        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_SPPaymentMethodsCBActionPerformed

    private void SPItemCatComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPItemCatComboBoxActionPerformed

        ItemCatComboBox();
    }//GEN-LAST:event_SPItemCatComboBoxActionPerformed

    private void SPSearchItemNameORCodeCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPSearchItemNameORCodeCBActionPerformed
        LoadItemDetailsToSalesPanel();
    }//GEN-LAST:event_SPSearchItemNameORCodeCBActionPerformed

    private void SPSalesOrderNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPSalesOrderNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SPSalesOrderNoActionPerformed

    private void SPCustomersBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPCustomersBtnActionPerformed
        try {
            CustomerJF NewCustomerJF1 = new CustomerJF();
            NewCustomerJF1.setVisible(true);
            this.dispose();
        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_SPCustomersBtnActionPerformed

    private void SPEmployeeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPEmployeeBtnActionPerformed
        try {
            EmployeeJF NewEmployeeJF = new EmployeeJF();
            NewEmployeeJF.setVisible(true);
            this.dispose();
        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_SPEmployeeBtnActionPerformed

    private void SPSupplierBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPSupplierBtnActionPerformed
        try {
            SupplierJF NewSupplierJF = new SupplierJF();
            NewSupplierJF.setVisible(true);
            this.dispose();
        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_SPSupplierBtnActionPerformed

    private void SPVehicleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPVehicleBtnActionPerformed
        try {
            VehicleJF NewVehicleJF = new VehicleJF();
            NewVehicleJF.setVisible(true);
            this.dispose();
        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_SPVehicleBtnActionPerformed

    private void SPReportBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPReportBtnActionPerformed
        try {
            ReportsJF NewReportsJF = new ReportsJF();
            NewReportsJF.setVisible(true);
            this.dispose();
        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_SPReportBtnActionPerformed

    private void SPBranchersBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPBranchersBtnActionPerformed
        try {
            BranchJF NewBranchJF = new BranchJF();
            NewBranchJF.setVisible(true);
            this.dispose();
        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_SPBranchersBtnActionPerformed

    private void SPSettingsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPSettingsBtnActionPerformed
        try {
            SettingJF NewSettingJF = new SettingJF();
            NewSettingJF.setVisible(true);
            this.dispose();
        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_SPSettingsBtnActionPerformed

    private void SPGatesHeightTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPGatesHeightTFKeyReleased
        try {
            String RDHeight = SPGatesHeightTF.getText();
            String RDHeightUnit = SPGatesWidthHeightCB.getSelectedItem().toString();
            String RDWidth = SPGatesWidthTF.getText();
            String RDQty = SPGatesQtyTF.getText();
            String RDRate = SPGatesRateTF.getText();

            RollerDoorCalculateAmount(RDHeight, RDHeightUnit, RDWidth, RDQty, RDRate);
            String GetReturnedValue = RollerDoorCalculateAmount(RDHeight, RDHeightUnit, RDWidth, RDQty, RDRate);
            SPGatesAmountTF.setText(GetReturnedValue);
        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }      // TODO add your handling code here:
    }//GEN-LAST:event_SPGatesHeightTFKeyReleased

    private void SPGatesWidthHeightCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPGatesWidthHeightCBActionPerformed
        try {
            String RDHeight = SPGatesHeightTF.getText();
            String RDHeightUnit = SPGatesWidthHeightCB.getSelectedItem().toString();
            String RDWidth = SPGatesWidthTF.getText();
            String RDQty = SPGatesQtyTF.getText();
            String RDRate = SPGatesRateTF.getText();

            RollerDoorCalculateAmount(RDHeight, RDHeightUnit, RDWidth, RDQty, RDRate);
            String GetReturnedValue = RollerDoorCalculateAmount(RDHeight, RDHeightUnit, RDWidth, RDQty, RDRate);
            SPGatesAmountTF.setText(GetReturnedValue);
        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_SPGatesWidthHeightCBActionPerformed

    private void SPRFSheetQtyTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPRFSheetQtyTFKeyTyped
        // Method For only Accept Numbers in Text Feild
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_SPRFSheetQtyTFKeyTyped

    private void SPRFSheetSizeTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPRFSheetSizeTFKeyTyped
        // Method For only Accept Numbers in Text Feild
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE || c == KeyEvent.VK_PERIOD)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_SPRFSheetSizeTFKeyTyped

    private void SPRFSheetRateTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPRFSheetRateTFKeyTyped
        // Method For only Accept Numbers in Text Feild
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE || c == KeyEvent.VK_PERIOD)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_SPRFSheetRateTFKeyTyped

    private void SPChequeAmountTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPChequeAmountTFKeyTyped
        // Method For only Accept Numbers in Text Feild
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE || c == KeyEvent.VK_PERIOD)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_SPChequeAmountTFKeyTyped

    private void SPPaymentMethodFirstPaymentTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPPaymentMethodFirstPaymentTFKeyTyped
        // Method For only Accept Numbers in Text Feild
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE || c == KeyEvent.VK_PERIOD)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_SPPaymentMethodFirstPaymentTFKeyTyped

    private void SPCurveRFShtSizeCBKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPCurveRFShtSizeCBKeyTyped
        // Method For only Accept Numbers in Text Feild
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE || c == KeyEvent.VK_PERIOD)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_SPCurveRFShtSizeCBKeyTyped

    private void SPCurveRFShtCurveWidthTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPCurveRFShtCurveWidthTFKeyTyped
// Method For only Accept Numbers in Text Feild
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE || c == KeyEvent.VK_PERIOD)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_SPCurveRFShtCurveWidthTFKeyTyped

    private void SPCurveRFShtQtyTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPCurveRFShtQtyTFKeyTyped
// Method For only Accept Numbers in Text Feild
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE || c == KeyEvent.VK_PERIOD)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_SPCurveRFShtQtyTFKeyTyped

    private void SPCurveRFShtRateTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPCurveRFShtRateTFKeyTyped
// Method For only Accept Numbers in Text Feild
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE || c == KeyEvent.VK_PERIOD)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_SPCurveRFShtRateTFKeyTyped

    private void SPRollerDoorHeightTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPRollerDoorHeightTFKeyTyped
// Method For only Accept Numbers in Text Feild
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE || c == KeyEvent.VK_PERIOD)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_SPRollerDoorHeightTFKeyTyped

    private void SPRollerDoorWidthTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPRollerDoorWidthTFKeyTyped
// Method For only Accept Numbers in Text Feild
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE || c == KeyEvent.VK_PERIOD)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_SPRollerDoorWidthTFKeyTyped

    private void SPRollerDoorQtyTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPRollerDoorQtyTFKeyTyped
// Method For only Accept Numbers in Text Feild
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE || c == KeyEvent.VK_PERIOD)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_SPRollerDoorQtyTFKeyTyped

    private void SPRollerDoorRateTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPRollerDoorRateTFKeyTyped
// Method For only Accept Numbers in Text Feild
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE || c == KeyEvent.VK_PERIOD)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_SPRollerDoorRateTFKeyTyped

    private void SPRollerShutterHeightTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPRollerShutterHeightTFKeyTyped
// Method For only Accept Numbers in Text Feild
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE || c == KeyEvent.VK_PERIOD)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_SPRollerShutterHeightTFKeyTyped

    private void SPRollerShutterWidthTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPRollerShutterWidthTFKeyTyped
// Method For only Accept Numbers in Text Feild
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE || c == KeyEvent.VK_PERIOD)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_SPRollerShutterWidthTFKeyTyped

    private void SPRollerShutterQtyTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPRollerShutterQtyTFKeyTyped
// Method For only Accept Numbers in Text Feild
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE || c == KeyEvent.VK_PERIOD)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_SPRollerShutterQtyTFKeyTyped

    private void SPRollerShutterRateTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPRollerShutterRateTFKeyTyped
// Method For only Accept Numbers in Text Feild
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE || c == KeyEvent.VK_PERIOD)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_SPRollerShutterRateTFKeyTyped

    private void SPPurlinThiknessTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPPurlinThiknessTFKeyTyped
// Method For only Accept Numbers in Text Feild
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE || c == KeyEvent.VK_PERIOD)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_SPPurlinThiknessTFKeyTyped

    private void SPPurlinLengthTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPPurlinLengthTFKeyTyped
// Method For only Accept Numbers in Text Feild
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE || c == KeyEvent.VK_PERIOD)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_SPPurlinLengthTFKeyTyped

    private void SPPurlinQtyTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPPurlinQtyTFKeyTyped
// Method For only Accept Numbers in Text Feild
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE || c == KeyEvent.VK_PERIOD)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_SPPurlinQtyTFKeyTyped

    private void SPPurlinRateTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPPurlinRateTFKeyTyped
// Method For only Accept Numbers in Text Feild
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE || c == KeyEvent.VK_PERIOD)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_SPPurlinRateTFKeyTyped

    private void SPGutterThiknessTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPGutterThiknessTFKeyTyped
// Method For only Accept Numbers in Text Feild
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE || c == KeyEvent.VK_PERIOD)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_SPGutterThiknessTFKeyTyped

    private void SPGutterLengthTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPGutterLengthTFKeyTyped
// Method For only Accept Numbers in Text Feild
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE || c == KeyEvent.VK_PERIOD)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_SPGutterLengthTFKeyTyped

    private void SPGutterQtyTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPGutterQtyTFKeyTyped
// Method For only Accept Numbers in Text Feild
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE || c == KeyEvent.VK_PERIOD)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_SPGutterQtyTFKeyTyped

    private void SPGutterRateTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPGutterRateTFKeyTyped
// Method For only Accept Numbers in Text Feild
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE || c == KeyEvent.VK_PERIOD)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_SPGutterRateTFKeyTyped

    private void SPGatesWidthTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPGatesWidthTFKeyTyped
// Method For only Accept Numbers in Text Feild
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE || c == KeyEvent.VK_PERIOD)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_SPGatesWidthTFKeyTyped

    private void SPGatesHeightTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPGatesHeightTFKeyTyped
// Method For only Accept Numbers in Text Feild
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE || c == KeyEvent.VK_PERIOD)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_SPGatesHeightTFKeyTyped

    private void SPGatesQtyTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPGatesQtyTFKeyTyped
// Method For only Accept Numbers in Text Feild
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE || c == KeyEvent.VK_PERIOD)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_SPGatesQtyTFKeyTyped

    private void SPGatesRateTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPGatesRateTFKeyTyped
// Method For only Accept Numbers in Text Feild
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE || c == KeyEvent.VK_PERIOD)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_SPGatesRateTFKeyTyped

    private void SPCladdingSizeTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPCladdingSizeTFKeyTyped
// Method For only Accept Numbers in Text Feild
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE || c == KeyEvent.VK_PERIOD)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_SPCladdingSizeTFKeyTyped

    private void SPCladdingQtyTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPCladdingQtyTFKeyTyped
// Method For only Accept Numbers in Text Feild
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE || c == KeyEvent.VK_PERIOD)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_SPCladdingQtyTFKeyTyped

    private void SPCladdingRateTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPCladdingRateTFKeyTyped
// Method For only Accept Numbers in Text Feild
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE || c == KeyEvent.VK_PERIOD)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_SPCladdingRateTFKeyTyped

    private void SPRFSheetSizeTF9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPRFSheetSizeTF9KeyTyped
// Method For only Accept Numbers in Text Feild
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE || c == KeyEvent.VK_PERIOD)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_SPRFSheetSizeTF9KeyTyped

    private void SPRFSheetSizeConvertedTF11KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPRFSheetSizeConvertedTF11KeyTyped
// Method For only Accept Numbers in Text Feild
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE || c == KeyEvent.VK_PERIOD)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_SPRFSheetSizeConvertedTF11KeyTyped

    private void SPRFSheetQtyTF10KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPRFSheetQtyTF10KeyTyped
// Method For only Accept Numbers in Text Feild
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE || c == KeyEvent.VK_PERIOD)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_SPRFSheetQtyTF10KeyTyped

    private void SPRFSheetRateTF9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SPRFSheetRateTF9KeyTyped
// Method For only Accept Numbers in Text Feild
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE || c == KeyEvent.VK_PERIOD)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_SPRFSheetRateTF9KeyTyped

    private void SPChequesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPChequesBtnActionPerformed
        try {
            ChequeDetailsJF NewChequeDetailsJF = new ChequeDetailsJF();
            NewChequeDetailsJF.setVisible(true);
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

    private void SPRawItemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPRawItemBtnActionPerformed
         try {
            RawItemsJF newRawItemJF = new RawItemsJF();
            newRawItemJF.setVisible(true);
            this.setVisible(false);
        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null,e);
        }
    }//GEN-LAST:event_SPRawItemBtnActionPerformed

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
            java.util.logging.Logger.getLogger(SalesJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SalesJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SalesJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SalesJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SalesJF().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddItemToTableBtn;
    private javax.swing.JPanel CPSalesPanel;
    private javax.swing.JPanel CashDetailsPnl;
    private javax.swing.JLabel Datelbl;
    private javax.swing.JLabel Datelbl1;
    private javax.swing.JPanel IDPCladdingPanel;
    private javax.swing.JPanel IDPCurvedRoofingSheetPanel;
    private javax.swing.JPanel IDPGatePanel;
    private javax.swing.JPanel IDPGutterPanel;
    private javax.swing.JPanel IDPOtherPanel;
    private javax.swing.JPanel IDPPlainSheetPanel;
    private javax.swing.JPanel IDPPurlingPanel;
    private javax.swing.JPanel IDPRollerDoorPanel;
    private javax.swing.JPanel IDPRollerShutterPanel;
    private javax.swing.JPanel IDPRoofingSheetPanel;
    private javax.swing.JLabel MainPanelBranchIDLable;
    private javax.swing.JLabel MainPanelBranchNameLable;
    private javax.swing.JTextArea SPAddresTA;
    private javax.swing.JLabel SPArrowLbl;
    private javax.swing.JTextField SPBankNameTF;
    private javax.swing.JLabel SPBraIDLabel;
    private javax.swing.JLabel SPBraNameLabel;
    private javax.swing.JButton SPBranchersBtn;
    private javax.swing.JTextField SPChequeAmountTF;
    private com.toedter.calendar.JDateChooser SPChequeDateDC;
    private javax.swing.JPanel SPChequeDetailsPnl;
    private javax.swing.JTextField SPChequeNoTF;
    private javax.swing.JButton SPChequesBtn;
    private javax.swing.JTextField SPCladdingAmountTF;
    private javax.swing.JComboBox<String> SPCladdingColourCB;
    private javax.swing.JTextField SPCladdingConvertedTF;
    private javax.swing.JTextField SPCladdingQtyTF;
    private javax.swing.JTextField SPCladdingRateTF;
    private javax.swing.JTextField SPCladdingSizeTF;
    private javax.swing.JComboBox<String> SPCladdingUnit01CB;
    private javax.swing.JComboBox<String> SPCladdingUnit02CB;
    private javax.swing.JTextField SPContactNoTF;
    private javax.swing.JPanel SPCreditDetailsPnl;
    private javax.swing.JTextField SPCurveRFConvertedSizeTF;
    private javax.swing.JTextField SPCurveRFShtAmountTF;
    private javax.swing.JComboBox<String> SPCurveRFShtColourCombo;
    private javax.swing.JTextField SPCurveRFShtCurveWidthTF;
    private javax.swing.JTextField SPCurveRFShtQtyTF;
    private javax.swing.JTextField SPCurveRFShtRateTF;
    private javax.swing.JTextField SPCurveRFShtSizeCB;
    private javax.swing.JComboBox<String> SPCurveRFShtUnit01CB;
    private javax.swing.JComboBox<String> SPCurveRFShtUnit02CB;
    private javax.swing.JLabel SPCustomerIDLable;
    private javax.swing.JTextField SPCustomerIDTF;
    private javax.swing.JLabel SPCustomerNameLable;
    private javax.swing.JLabel SPCustomerNameorNICNoLabel;
    private javax.swing.JLabel SPCustomerNameorNICNoLabel1;
    private javax.swing.JTextField SPCustomerNameorNICNoTF;
    private javax.swing.JTable SPCustomerOrderTable;
    private javax.swing.JComboBox<String> SPCustomerSearchCB;
    private javax.swing.JButton SPCustomersBtn;
    private javax.swing.JButton SPEmployeeBtn;
    private javax.swing.JButton SPExitBtn;
    private javax.swing.JButton SPExpensesBtn;
    private javax.swing.JButton SPFinishedItemsBtn;
    private javax.swing.JTextField SPGatesAmountTF;
    private javax.swing.JTextField SPGatesHeightTF;
    private javax.swing.JTextField SPGatesQtyTF;
    private javax.swing.JTextField SPGatesRateTF;
    private javax.swing.JComboBox<String> SPGatesWidthHeightCB;
    private javax.swing.JTextField SPGatesWidthTF;
    private javax.swing.JTextField SPGutterAmountTF;
    private javax.swing.JComboBox<String> SPGutterColourCB;
    private javax.swing.JTextField SPGutterLengthTF;
    private javax.swing.JTextField SPGutterQtyTF;
    private javax.swing.JTextField SPGutterRateTF;
    private javax.swing.JTextField SPGutterThiknessTF;
    private javax.swing.JComboBox<String> SPGutterUnitCB;
    private javax.swing.JComboBox<String> SPItemCatComboBox;
    private javax.swing.JLabel SPItemNameORCodeLable;
    private javax.swing.JTextField SPItemNameOrCodeTF;
    private javax.swing.JPanel SPItemsDetailsPanel;
    private javax.swing.JLabel SPMainBGLbl;
    private javax.swing.JButton SPMinimizeBtn;
    private javax.swing.JTextField SPNetAmountTF;
    private javax.swing.JTextField SPPayMethodCashTotalPayTF;
    private javax.swing.JTextField SPPaymentMethodCreditContactTF;
    private javax.swing.JTextField SPPaymentMethodCreditNICTF;
    private javax.swing.JTextField SPPaymentMethodFirstPaymentTF;
    private javax.swing.JComboBox<String> SPPaymentMethodsCB;
    private javax.swing.JPanel SPPaymentMethodsPnl;
    private javax.swing.JButton SPPaymentsBtn;
    private javax.swing.JTextField SPPlainSheetAmountTF;
    private javax.swing.JComboBox<String> SPPlainSheetColourCB;
    private javax.swing.JTextField SPPlainSheetConvertedTF;
    private javax.swing.JTextField SPPlainSheetQtyTF;
    private javax.swing.JTextField SPPlainSheetRateTF;
    private javax.swing.JTextField SPPlainSheetSizeTF;
    private javax.swing.JComboBox<String> SPPlainSheetUnit01CB;
    private javax.swing.JComboBox<String> SPPlainSheetUnit02CB;
    private javax.swing.JLabel SPPresentageMarkTF;
    private javax.swing.JButton SPPrintBill;
    private javax.swing.JTextField SPPurlinAmountTF;
    private javax.swing.JComboBox<String> SPPurlinColourCB;
    private javax.swing.JTextField SPPurlinLengthTF;
    private javax.swing.JTextField SPPurlinQtyTF;
    private javax.swing.JTextField SPPurlinRateTF;
    private javax.swing.JTextField SPPurlinThiknessTF;
    private javax.swing.JComboBox<String> SPPurlinUnitCB;
    private javax.swing.JTextField SPRFSheetAmountTF;
    private javax.swing.JTextField SPRFSheetAmountTF9;
    private javax.swing.JComboBox<String> SPRFSheetColourCombo;
    private javax.swing.JComboBox<String> SPRFSheetColourCombo6;
    private javax.swing.JComboBox<String> SPRFSheetColourCombo9;
    private javax.swing.JTextField SPRFSheetQtyTF;
    private javax.swing.JTextField SPRFSheetQtyTF10;
    private javax.swing.JTextField SPRFSheetRateTF;
    private javax.swing.JTextField SPRFSheetRateTF9;
    private javax.swing.JTextField SPRFSheetSizeConvertedTF;
    private javax.swing.JTextField SPRFSheetSizeConvertedTF11;
    private javax.swing.JTextField SPRFSheetSizeTF;
    private javax.swing.JTextField SPRFSheetSizeTF9;
    private javax.swing.JComboBox<String> SPRFSheetUnit01CB;
    private javax.swing.JComboBox<String> SPRFSheetUnit01CB12;
    private javax.swing.JComboBox<String> SPRFSheetUnit02CB;
    private javax.swing.JComboBox<String> SPRFSheetUnit02CB4;
    private javax.swing.JButton SPRawItemBtn;
    private javax.swing.JButton SPReportBtn;
    private javax.swing.JTextField SPRollerDoorAmountTF;
    private javax.swing.JComboBox<String> SPRollerDoorColourCombo;
    private javax.swing.JTextField SPRollerDoorHeightTF;
    private javax.swing.JTextField SPRollerDoorQtyTF;
    private javax.swing.JTextField SPRollerDoorRateTF;
    private javax.swing.JComboBox<String> SPRollerDoorWidthHeightUnitCB;
    private javax.swing.JTextField SPRollerDoorWidthTF;
    private javax.swing.JTextField SPRollerShutterAmountTF;
    private javax.swing.JComboBox<String> SPRollerShutterColourCombo;
    private javax.swing.JTextField SPRollerShutterHeightTF;
    private javax.swing.JTextField SPRollerShutterQtyTF;
    private javax.swing.JTextField SPRollerShutterRateTF;
    private javax.swing.JComboBox<String> SPRollerShutterWidthHeightUnitCB;
    private javax.swing.JTextField SPRollerShutterWidthTF;
    private javax.swing.JButton SPSalesBtn;
    private javax.swing.JTextField SPSalesOrderNo;
    private javax.swing.JLabel SPSearchItemLable;
    private javax.swing.JComboBox<String> SPSearchItemNameORCodeCB;
    private javax.swing.JButton SPSettingsBtn;
    private javax.swing.JButton SPSupplierBtn;
    private javax.swing.JTextField SPTaxAmountTF;
    private javax.swing.JLabel SPTaxLable;
    private javax.swing.JLabel SPTaxLable1;
    private javax.swing.JTextField SPTaxPercentageTF;
    private javax.swing.JLabel SPTotalTaxLable;
    private javax.swing.JLabel SPUserNameLbl;
    private javax.swing.JButton SPVehicleBtn;
    private javax.swing.JPanel SalesContentPanel;
    private javax.swing.JPanel SalesMainPanel;
    private javax.swing.JTextField SalesTotalAmountTF;
    private javax.swing.JLabel SeldoLogo;
    private javax.swing.JLabel Timelbl;
    private javax.swing.JLabel Timelbl1;
    private javax.swing.JPanel TopPanel;
    private javax.swing.JPanel TopicPanel;
    private javax.swing.JLabel UserNameDisplayLabel;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel206;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel216;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel236;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel246;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel266;
    private javax.swing.JLabel jLabel268;
    private javax.swing.JLabel jLabel269;
    private javax.swing.JLabel jLabel270;
    private javax.swing.JLabel jLabel272;
    private javax.swing.JLabel jLabel273;
    private javax.swing.JLabel jLabel275;
    private javax.swing.JLabel jLabel276;
    private javax.swing.JLabel jLabel277;
    private javax.swing.JLabel jLabel278;
    private javax.swing.JLabel jLabel279;
    private javax.swing.JLabel jLabel280;
    private javax.swing.JLabel jLabel282;
    private javax.swing.JLabel jLabel283;
    private javax.swing.JLabel jLabel284;
    private javax.swing.JLabel jLabel285;
    private javax.swing.JLabel jLabel286;
    private javax.swing.JLabel jLabel287;
    private javax.swing.JLabel jLabel288;
    private javax.swing.JLabel jLabel289;
    private javax.swing.JLabel jLabel291;
    private javax.swing.JLabel jLabel292;
    private javax.swing.JLabel jLabel293;
    private javax.swing.JLabel jLabel294;
    private javax.swing.JLabel jLabel295;
    private javax.swing.JLabel jLabel297;
    private javax.swing.JLabel jLabel298;
    private javax.swing.JLabel jLabel299;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel300;
    private javax.swing.JLabel jLabel301;
    private javax.swing.JLabel jLabel302;
    private javax.swing.JLabel jLabel311;
    private javax.swing.JLabel jLabel312;
    private javax.swing.JLabel jLabel313;
    private javax.swing.JLabel jLabel314;
    private javax.swing.JLabel jLabel315;
    private javax.swing.JLabel jLabel316;
    private javax.swing.JLabel jLabel318;
    private javax.swing.JLabel jLabel319;
    private javax.swing.JLabel jLabel320;
    private javax.swing.JLabel jLabel321;
    private javax.swing.JLabel jLabel322;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
