/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DBConnection.SeldoDB;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;

/**
 *
 * @author Nano ArtZ
 */
public final class FinishedItemsJF extends javax.swing.JFrame {

    /**
     * Creates new form FinishedItemsJF
     */
    public FinishedItemsJF() {
        initComponents();
        moreDetailsPanel.setVisible(false);
        ButtonBehaviorMethod();

        showDate();
        showTime();

        FullScreenMethod();

        LoadItemNameOrCodeToSalesPanelCB();

        AutoGenFIcode();
    }
// Finished Item Methods Start //
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
            Logger.getLogger(DashBoardJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }
//----- Button Behavior Method END -----//   

    //__________Finished Item Catagory Changer Method Start_________//
    void changeFinishedItemCat(String getCat) {
        try {
            switch (getCat) {
                case "Roofing Sheets":
                    FIRollerDoorsPanel.setVisible(false);
                    FIRollerShutterPanel.setVisible(false);
                    FIGatesPanel.setVisible(false);
                    FIPurlingPanel.setVisible(false);
                    FIGuttersPanel.setVisible(false);
                    FIPlainSheetPanel.setVisible(false);
                    FIRoofingSheetsPanel.setVisible(true);
                    FINameLbl.setText("Item Name");
                    break;
                case "Roller Doors":
                    FIRoofingSheetsPanel.setVisible(false);
                    FIRollerShutterPanel.setVisible(false);
                    FIGatesPanel.setVisible(false);
                    FIPurlingPanel.setVisible(false);
                    FIGuttersPanel.setVisible(false);
                    FIPlainSheetPanel.setVisible(false);
                    FIRollerDoorsPanel.setVisible(true);
                    FINameLbl.setText("Door Type");
                    break;
                case "Roller Shutter":
                    FIRoofingSheetsPanel.setVisible(false);
                    FIRollerDoorsPanel.setVisible(false);
                    FIGatesPanel.setVisible(false);
                    FIPurlingPanel.setVisible(false);
                    FIGuttersPanel.setVisible(false);
                    FIPlainSheetPanel.setVisible(false);
                    FIRollerShutterPanel.setVisible(true);
                    break;
                case "Gates":
                    FIRoofingSheetsPanel.setVisible(false);
                    FIRollerDoorsPanel.setVisible(false);
                    FIRollerShutterPanel.setVisible(false);
                    FIPurlingPanel.setVisible(false);
                    FIGuttersPanel.setVisible(false);
                    FIPlainSheetPanel.setVisible(false);
                    FIGatesPanel.setVisible(true);
                    FINameLbl.setText("Gate Type");
                    break;
                case "CPurling":
                    FIRoofingSheetsPanel.setVisible(false);
                    FIRollerDoorsPanel.setVisible(false);
                    FIRollerShutterPanel.setVisible(false);
                    FIGatesPanel.setVisible(false);
                    FIGuttersPanel.setVisible(false);
                    FIPlainSheetPanel.setVisible(false);
                    FIPurlingPanel.setVisible(true);
                    break;
                case "Gutters":
                    FIRoofingSheetsPanel.setVisible(false);
                    FIRollerDoorsPanel.setVisible(false);
                    FIRollerShutterPanel.setVisible(false);
                    FIGatesPanel.setVisible(false);
                    FIPurlingPanel.setVisible(false);
                    FIPlainSheetPanel.setVisible(false);
                    FIGuttersPanel.setVisible(true);
                    break;
                case "Plain Sheet":
                    FIRoofingSheetsPanel.setVisible(false);
                    FIRollerDoorsPanel.setVisible(false);
                    FIRollerShutterPanel.setVisible(false);
                    FIGatesPanel.setVisible(false);
                    FIPurlingPanel.setVisible(false);
                    FIGuttersPanel.setVisible(false);
                    FIPlainSheetPanel.setVisible(true);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//__________Finished Item Catagory Changer Method END_________//
//___________Finished Item Add Button___________//
    void AddFinishedItemCat(String getCat) {
        try {
            java.sql.Statement s = SeldoDB.GetMyConnection().createStatement();
            String path;
            switch (getCat) {
                case "Roofing Sheets":
                    path = "insert into finisheditem "
                            + "(ItemCode,ItemName,ItemCat,Length,LengthUnit,Width,WidthUnit,Height,HeightUnit,Color,Thickness,Price,QtyOnHand,ThicknessUnit) values "
                            + "('" + FICodeTF.getText() + "','" + FINameCB.getSelectedItem() + "',"
                            + "'" + getCat + "','" + Double.parseDouble(FIRoofingSheetLength.getText()) + "','" + Double.parseDouble(FIRoofingSheetWidth.getText()) + "',"
                            + "'" + Double.parseDouble(FIRoofingSheetHeight.getText()) + "','" + FIRoofingSheetColour.getText() + "',"
                            + "'" + Double.parseDouble(FIRoofingSheetThickness.getText()) + "','" + Double.parseDouble(FIRoofingSheetPrice.getText()) + "',"
                            + "'" + FIRoofingSheetOnHandQty.getText() + "','" + FIRoofingSheetLengthUnit.getSelectedItem().toString() + "',"
                            + "'" + FIRoofingSheetWidthUnit.getSelectedItem().toString() + "','" + FIRoofingSheetHeightUnit.getSelectedItem().toString() + "',"
                            + "'" + FIRoofingSheetThicknessUnit.getSelectedItem().toString() + "')";
                    s.executeUpdate(path);
                    break;
                case "Roller Doors":
                    path = "insert into finisheditem "
                            + "(ItemCode,ItemName,ItemCat,Width,Height,squirefeet,Color,Thickness,Price,QtyOnHand,WidthUnit,HeightUnit,ThicknessUnit) values "
                            + "('" + FICodeTF.getText() + "','" + FINameCB.getSelectedItem() + "',"
                            + "'" + getCat + "','" + Double.parseDouble(FIRollerDoorWidth.getText()) + "','" + Double.parseDouble(FIRollerDoorHeight.getText()) + "',"
                            + "'" + Double.parseDouble(FIRollerDoorSqFeet.getText()) + "','" + FIRollerDoorColour.getText() + "','" + Double.parseDouble(FIRollerDoorThickness.getText()) + "',"
                            + "'" + Double.parseDouble(FIRollerDoorPrice.getText()) + "','" + FIRollerDoorOnHandQty.getText() + "','" + FIRollerDoorWidthUnit.getSelectedItem().toString() + "',"
                            + "'" + FIRollerDoorHeightUnit.getSelectedItem().toString() + "','" + FIRollerDoorThicknessUnit.getSelectedItem().toString() + "')";
                    s.executeUpdate(path);
                    break;
                case "Roller Shutter":
                    path = "insert into finisheditem "
                            + "(ItemCode,ItemName,ItemCat,length,Width,Height,Color,Thickness,Price,QtyOnHand,LengthUnit,WidthUnit,HeightUnit,ThicknessUnit) values "
                            + "('" + FICodeTF.getText() + "','" + FINameCB.getSelectedItem() + "',"
                            + "'" + getCat + "','" + Double.parseDouble(FIRollerShutterLength.getText()) + "','" + Double.parseDouble(FIRollerShutterWidth.getText()) + "',"
                            + "'" + Double.parseDouble(FIRollerShutterHeight.getText()) + "','" + FIRollerShutterColour.getText() + "',"
                            + "'" + Double.parseDouble(FIRollerShutterThickness.getText()) + "','" + Double.parseDouble(FIRollerShutterPrice.getText()) + "','" + FIRollerShutterOnHandQty.getText() + "',"
                            + "'" + FIRollerShutterLengthUnit.getSelectedItem().toString() + "','" + FIRollerShutterWidthUnit.getSelectedItem().toString() + "',"
                            + "'" + FIRollerShutterHeightUnit.getSelectedItem().toString() + "','" + FIRollerShutterThicknessUnit.getSelectedItem().toString() + "')";
                    s.executeUpdate(path);
                    break;
                case "Gates":
                    path = "insert into finisheditem "
                            + "(ItemCode,ItemName,ItemCat,length,Width,Height,Color,Price,QtyOnHand,WidthUnit,HeightUnit,LengthUnit) values "
                            + "('" + FICodeTF.getText() + "','" + FINameCB.getSelectedItem() + "','" + getCat + "',"
                            + "'" + Double.parseDouble(FIGatesLength.getText()) + "','" + Double.parseDouble(FIGatesWidth.getText()) + "','" + Double.parseDouble(FIGatesHeight.getText()) + "',"
                            + "'" + FIGatesColour.getText() + "','" + Double.parseDouble(FIGatesPrice.getText()) + "','" + FIGatesOnHandQty.getText() + "',"
                            + "'" + FIGatesWidthUnit.getSelectedItem().toString() + "','" + FIGatesHeightUnit.getSelectedItem().toString() + "',"
                            + "'" + FIGatesLengthUnit.getSelectedItem().toString() + "')";
                    s.executeUpdate(path);
                    break;
                case "CPurling":
                    path = "insert into finisheditem "
                            + "(ItemCode,ItemName,ItemCat,length,Width,Height,Thickness,Price,QtyOnHand,LengthUnit,WidthUnit,HeightUnit,ThicknessUnit) values "
                            + "('" + FICodeTF.getText() + "','" + FINameCB.getSelectedItem() + "','" + getCat + "',"
                            + "'" + Double.parseDouble(FIPurlingLength.getText()) + "','" + Double.parseDouble(FIPurlingWidth.getText()) + "','" + Double.parseDouble(FIPurlingHeight.getText()) + "',"
                            + "'" + Double.parseDouble(FIPurlingThickness.getText()) + "','" + Double.parseDouble(FIPurlingPrice.getText()) + "','" + FIPurlingOnHandQty.getText() + "',"
                            + "'" + FIPurlingLengthUnit.getSelectedItem().toString() + "','" + FIPurlingWidthUnit.getSelectedItem().toString() + "',"
                            + "'" + FIPurlingHeightUnit.getSelectedItem().toString() + "','" + FIPurlingThicknessUnit.getSelectedItem().toString() + "')";
                    s.executeUpdate(path);
                    break;
                case "Gutters":
                    path = "insert into finisheditem "
                            + "(ItemCode,ItemName,ItemCat,length,Width,Height,Color,Thickness,Price,QtyOnHand,LengthUnit,WidthUnit,HeightUnit,ThicknessUnit) values "
                            + "('" + FICodeTF.getText() + "','" + FINameCB.getSelectedItem() + "',"
                            + "'" + getCat + "','" + Double.parseDouble(FIGutterLength.getText()) + "','" + Double.parseDouble(FIGutterWidth.getText()) + "',"
                            + "'" + Double.parseDouble(FIGutterHeight.getText()) + "','" + FIGutterColour.getText() + "','" + Double.parseDouble(FIGutterThickness.getText()) + "',"
                            + "'" + Double.parseDouble(FIGutterPrice.getText()) + "','" + FIGutterOnHandQty.getText() + "',"
                            + "'" + FIGutterLengthUnit.getSelectedItem().toString() + "','" + FIGutterWidthUnit.getSelectedItem().toString() + "',"
                            + "'" + FIGutterHeightUnit.getSelectedItem().toString() + "','" + FIGutterThicknessUnit.getSelectedItem().toString() + "')";
                    s.executeUpdate(path);
                    break;
                case "Plain Sheet":
                    path = "insert into finisheditem "
                            + "(ItemCode,ItemName,ItemCat,length,Width,Height,squirefeet,Color,Thickness,Price,QtyOnHand,LengthUnit,WidthUnit,HeightUnit,ThicknessUnit) values "
                            + "('" + FICodeTF.getText() + "','" + FINameCB.getSelectedItem() + "',"
                            + "'" + getCat + "','" + Double.parseDouble(FIPlainSheetLength.getText()) + "','" + Double.parseDouble(FIPlainSheetWidth.getText()) + "',"
                            + "'" + Double.parseDouble(FIPlainSheetHeight.getText()) + "','" + Double.parseDouble(FIPlainSheetSqfeet.getText()) + "','" + FIPlainSheetColour.getText() + "',"
                            + "'" + Double.parseDouble(FIPlainSheetThickness.getText()) + "','" + Double.parseDouble(FIPlainSheetPrice.getText()) + "','" + FIPlainSheetOnHandQty.getText() + "',"
                            + "'" + FIPlainSheetLengthUnit.getSelectedItem().toString() + "','" + FIPlainSheetWidthUnit.getSelectedItem().toString() + "',"
                            + "'" + FIPlainSheetHeightUnit.getSelectedItem().toString() + "','" + FIPlainSheetThicknessUnit.getSelectedItem().toString() + "')";
                    s.executeUpdate(path);
                    break;
                default:
                    break;
            }
        } catch (Exception ex) {
            Logger.getLogger(FinishedItemsJF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //___________Finished Item Add Button Method END___________//
//_______________Clear Text Fields_______________//.
    void finishedItemClearTextFields(String getCat) {
        switch (getCat) {
            case "Roofing Sheets":
                //FINameCB.setSelectedItem("");
                FIRoofingSheetLength.setText("");
                FIRoofingSheetWidth.setText("");
                FIRoofingSheetHeight.setText("");
                FIRoofingSheetColour.setText("");
                FIRoofingSheetThickness.setText("");
                FIRoofingSheetPrice.setText("");
                FIRoofingSheetOnHandQty.setText("");
                FICodeTF.setText("");
                break;
            case "Roller Doors":
                //FINameCB.setSelectedItem("");
                FIRollerDoorWidth.setText("");
                FIRollerDoorHeight.setText("");
                FIRollerDoorSqFeet.setText("");
                FIRollerDoorColour.setText("");
                FIRollerDoorThickness.setText("");
                FIRollerDoorPrice.setText("");
                FIRollerDoorOnHandQty.setText("");
                FICodeTF.setText("");
                break;
            case "Roller Shutter":
                //FINameCB.setSelectedItem("");
                FIRollerShutterLength.setText("");
                FIRollerShutterWidth.setText("");
                FIRollerShutterHeight.setText("");
                FIRollerShutterColour.setText("");
                FIRollerShutterThickness.setText("");
                FIRollerShutterPrice.setText("");
                FIRollerShutterOnHandQty.setText("");
                FICodeTF.setText("");
                break;
            case "Gates":
                FIGatesLength.setText("");
                // FINameCB.setSelectedItem("");
                FIGatesWidth.setText("");
                FIGatesHeight.setText("");
                FIGatesColour.setText("");
                FIGatesPrice.setText("");
                FIGatesOnHandQty.setText("");
                FICodeTF.setText("");
                break;
            case "CPurling":
                FIPurlingLength.setText("");
                //FINameCB.setSelectedItem("");
                FIPurlingWidth.setText("");
                FIPurlingHeight.setText("");
                FIPurlingThickness.setText("");
                FIPurlingPrice.setText("");
                FIPurlingOnHandQty.setText("");
                FICodeTF.setText("");
                break;
            case "Gutters":
                //FINameCB.setSelectedItem("");
                FIGutterLength.setText("");
                FIGutterWidth.setText("");
                FIGutterHeight.setText("");
                FIGutterColour.setText("");
                FIGutterThickness.setText("");
                FIGutterPrice.setText("");
                FIGutterOnHandQty.setText("");
                FICodeTF.setText("");
                break;
            case "Plain Sheet":
                FIPlainSheetSqfeet.setText("");
                //FINameCB.setSelectedItem("");
                FIPlainSheetLength.setText("");
                FIPlainSheetWidth.setText("");
                FIPlainSheetHeight.setText("");
                FIPlainSheetColour.setText("");
                FIPlainSheetThickness.setText("");
                FIPlainSheetPrice.setText("");
                FIPlainSheetOnHandQty.setText("");
                FICodeTF.setText("");
                break;
            default:
                break;
        }
    }
//_______________Clear Text Fields Method END_______________//

    //___________Set FI Editable true/false____________//
    void finishedItemSetEditableFields(JComboBox getItem, String fuck) {
        String getCat = getItem.getSelectedItem().toString();
        Boolean x = Boolean.valueOf(fuck);
        switch (getCat) {
            case "Roofing Sheets":
                FIRoofingSheetLength.setEditable(x);
                FIRoofingSheetWidth.setEditable(x);
                FIRoofingSheetHeight.setEditable(x);
                FIRoofingSheetColour.setEditable(x);
                FIRoofingSheetThickness.setEditable(x);
                FIRoofingSheetPrice.setEditable(x);
                FIRoofingSheetOnHandQty.setEditable(x);
                FICodeTF.setEditable(x);
                break;
            case "Roller Doors":
                FIRollerDoorWidth.setEditable(x);
                FIRollerDoorHeight.setEditable(x);
                FIRollerDoorSqFeet.setEditable(x);
                FIRollerDoorColour.setEditable(x);
                FIRollerDoorThickness.setEditable(x);
                FIRollerDoorPrice.setEditable(x);
                FIRollerDoorOnHandQty.setEditable(x);
                FICodeTF.setEditable(x);
                break;
            case "Roller Shutter":
                FIRollerShutterLength.setEditable(x);
                FIRollerShutterWidth.setEditable(x);
                FIRollerShutterHeight.setEditable(x);
                FIRollerShutterColour.setEditable(x);
                FIRollerShutterThickness.setEditable(x);
                FIRollerShutterPrice.setEditable(x);
                FIRollerShutterOnHandQty.setEditable(x);
                FICodeTF.setEditable(x);
                break;
            case "Gates":
                FIGatesLength.setEditable(x);
                FIGatesWidth.setEditable(x);
                FIGatesHeight.setEditable(x);
                FIGatesColour.setEditable(x);
                FIGatesPrice.setEditable(x);
                FIGatesOnHandQty.setEditable(x);
                FICodeTF.setEditable(x);
                break;
            case "CPurling":
                FIPurlingLength.setEditable(x);
                FIPurlingWidth.setEditable(x);
                FIPurlingHeight.setEditable(x);
                FIPurlingThickness.setEditable(x);
                FIPurlingPrice.setEditable(x);
                FIPurlingOnHandQty.setEditable(x);
                FICodeTF.setEditable(x);
                break;
            case "Gutters":
                FIGutterLength.setEditable(x);
                FIGutterWidth.setEditable(x);
                FIGutterHeight.setEditable(x);
                FIGutterColour.setEditable(x);
                FIGutterThickness.setEditable(x);
                FIGutterPrice.setEditable(x);
                FIGutterOnHandQty.setEditable(x);
                FICodeTF.setEditable(x);
                break;
            case "Plain Sheet":
                FIPlainSheetSqfeet.setEditable(x);
                FIPlainSheetLength.setEditable(x);
                FIPlainSheetWidth.setEditable(x);
                FIPlainSheetHeight.setEditable(x);
                FIPlainSheetColour.setEditable(x);
                FIPlainSheetThickness.setEditable(x);
                FIPlainSheetPrice.setEditable(x);
                FIPlainSheetOnHandQty.setEditable(x);
                FICodeTF.setEditable(x);
                break;
            default:
                break;
        }
    }
//___________Set FI Editable true/false - Method END____________//    

    //__________Finished Item Update Button_________//
    void updateFinishedItemCat(String getCat) {
        try {
            java.sql.Statement s = SeldoDB.GetMyConnection().createStatement();
            String path;
            switch (getCat) {
                case "Roofing Sheets":
                    path = "update finisheditem set "
                            + "ItemName='" + FINameCB.getSelectedItem() + "',"
                            + "ItemCat='" + getCat + "',"
                            + "length='" + Double.parseDouble(FIRoofingSheetLength.getText()) + "',"
                            + "Width='" + Double.parseDouble(FIRoofingSheetWidth.getText()) + "',"
                            + "Height='" + Double.parseDouble(FIRoofingSheetHeight.getText()) + "',"
                            + "Color='" + FIRoofingSheetColour.getText() + "',"
                            + "Thickness='" + Double.parseDouble(FIRoofingSheetThickness.getText()) + "',"
                            + "Price='" + Double.parseDouble(FIRoofingSheetPrice.getText()) + "',"
                            + "QtyOnHand='" + FIRoofingSheetOnHandQty.getText() + "',"
                            + "LengthUnit='" + FIRoofingSheetLengthUnit.getSelectedItem().toString() + "',"
                            + "WidthUnit='" + FIRoofingSheetWidthUnit.getSelectedItem().toString() + "',"
                            + "HeightUnit='" + FIRoofingSheetHeightUnit.getSelectedItem().toString() + "',"
                            + "ThicknessUnit='" + FIRoofingSheetThicknessUnit.getSelectedItem().toString() + "' "
                            + "where ItemCode='" + FICodeTF.getText() + "'";
                    s.executeUpdate(path);
                    break;
                case "Roller Doors":
                    path = "update finisheditem set"
                            + "ItemName='" + FINameCB.getSelectedItem() + "',"
                            + "ItemCat='" + getCat + "',"
                            + "Width='" + Double.parseDouble(FIRollerDoorWidth.getText()) + "',"
                            + "Height='" + Double.parseDouble(FIRollerDoorHeight.getText()) + "'"
                            + ",squirefeet='" + Double.parseDouble(FIRollerDoorSqFeet.getText()) + "',"
                            + "Color='" + FIRollerDoorColour.getText() + "',"
                            + "Thickness='" + Double.parseDouble(FIRollerDoorThickness.getText()) + "',"
                            + "Price='" + Double.parseDouble(FIRollerDoorPrice.getText()) + "',"
                            + "QtyOnHand='" + FIRollerDoorOnHandQty.getText() + "',"
                            + "WidthUnit='" + FIRollerDoorWidthUnit.getSelectedItem().toString() + "',"
                            + "HeightUnit='" + FIRollerDoorHeightUnit.getSelectedItem().toString() + "',"
                            + "ThicknessUnit='" + FIRollerDoorThicknessUnit.getSelectedItem().toString() + "' "
                            + "where ItemCode='" + FICodeTF.getText() + "'";
                    s.executeUpdate(path);

                    break;
                case "Roller Shutter":
                    path = "update finisheditem set "
                            + "ItemName='" + FINameCB.getSelectedItem() + "',"
                            + "ItemCat='" + getCat + "',"
                            + "length='" + Double.parseDouble(FIRollerShutterLength.getText()) + "',"
                            + "Width='" + Double.parseDouble(FIRollerShutterWidth.getText()) + "',"
                            + "Height='" + Double.parseDouble(FIRollerShutterHeight.getText()) + "',"
                            + "Color='" + FIRollerShutterColour.getText() + "',"
                            + "Thickness='" + Double.parseDouble(FIRollerShutterThickness.getText()) + "',"
                            + "Price='" + Double.parseDouble(FIRollerShutterPrice.getText()) + "',"
                            + "QtyOnHand='" + FIRollerShutterOnHandQty.getText() + "',"
                            + "LengthUnit='" + FIRollerShutterLengthUnit.getSelectedItem().toString() + "',"
                            + "WidthUnit='" + FIRollerShutterWidthUnit.getSelectedItem().toString() + "',"
                            + "HeightUnit='" + FIRollerShutterHeightUnit.getSelectedItem().toString() + "',"
                            + "ThicknessUnit='" + FIRollerShutterThicknessUnit.getSelectedItem().toString() + "' "
                            + "where ItemCode='" + FICodeTF.getText() + "'";
                    s.executeUpdate(path);
                    break;
                case "Gates":
                    path = "update finisheditem set "
                            + "length='" + Double.parseDouble(FIGatesLength.getText()) + "',"
                            + "ItemName='" + FINameCB.getSelectedItem() + "',"
                            + "ItemCat='" + getCat + "',"
                            + "Width='" + Double.parseDouble(FIGatesWidth.getText()) + "',"
                            + "Height='" + Double.parseDouble(FIGatesHeight.getText()) + "',"
                            + "Color='" + FIGatesColour.getText() + "',"
                            + "Price='" + Double.parseDouble(FIGatesPrice.getText()) + "',"
                            + "QtyOnHand='" + FIGatesOnHandQty.getText() + "',"
                            + "LengthUnit='" + FIGatesLengthUnit.getSelectedItem().toString() + "',"
                            + "WidthUnit='" + FIGatesWidthUnit.getSelectedItem().toString() + "',"
                            + "HeightUnit='" + FIGatesHeightUnit.getSelectedItem().toString() + "' "
                            + "where ItemCode='" + FICodeTF.getText() + "'";
                    s.executeUpdate(path);
                    break;
                case "CPurling":
                    path = "update finisheditem set "
                            + "length='" + Double.parseDouble(FIPurlingLength.getText()) + "',"
                            + "ItemName='" + FINameCB.getSelectedItem() + "',"
                            + "ItemCat='" + getCat + "',"
                            + "Width='" + Double.parseDouble(FIPurlingWidth.getText()) + "',"
                            + "Height='" + Double.parseDouble(FIPurlingHeight.getText()) + "',"
                            + "Thickness='" + Double.parseDouble(FIPurlingThickness.getText()) + "',"
                            + "Price='" + Double.parseDouble(FIPurlingPrice.getText()) + "',"
                            + "QtyOnHand='" + FIPurlingOnHandQty.getText() + "',"
                            + "LengthUnit='" + FIPurlingLengthUnit.getSelectedItem().toString() + "',"
                            + "WidthUnit='" + FIPurlingWidthUnit.getSelectedItem().toString() + "',"
                            + "HeightUnit='" + FIPurlingHeightUnit.getSelectedItem().toString() + "',"
                            + "ThicknessUnit='" + FIPurlingThicknessUnit.getSelectedItem().toString() + "' "
                            + "where ItemCode='" + FICodeTF.getText() + "'";
                    s.executeUpdate(path);
                    break;
                case "Gutters":
                    path = "update finisheditem set "
                            + "ItemName='" + FINameCB.getSelectedItem() + "',"
                            + "ItemCat='" + getCat + "',"
                            + "length='" + Double.parseDouble(FIGutterLength.getText()) + "',"
                            + "Width='" + Double.parseDouble(FIGutterWidth.getText()) + "',"
                            + "Height='" + Double.parseDouble(FIGutterHeight.getText()) + "',"
                            + "Color='" + FIGutterColour.getText() + "',"
                            + "Thickness='" + Double.parseDouble(FIGutterThickness.getText()) + "',"
                            + "Price='" + Double.parseDouble(FIGutterPrice.getText()) + "',"
                            + "QtyOnHand='" + FIGutterOnHandQty.getText() + "',"
                            + "LengthUnit='" + FIGutterLengthUnit.getSelectedItem().toString() + "',"
                            + "WidthUnit='" + FIGutterWidthUnit.getSelectedItem().toString() + "',"
                            + "HeightUnit='" + FIGutterHeightUnit.getSelectedItem().toString() + "',"
                            + "ThicknessUnit='" + FIGutterThicknessUnit.getSelectedItem().toString() + "' "
                            + "where ItemCode='" + FICodeTF.getText() + "'";
                    s.executeUpdate(path);
                    break;
                case "Plain Sheet":
                    path = "update finisheditem set "
                            + "squirefeet='" + Double.parseDouble(FIRollerDoorSqFeet.getText()) + "',"
                            + "ItemName='" + FINameCB.getSelectedItem() + "',"
                            + "ItemCat='" + getCat + "',"
                            + "length='" + Double.parseDouble(FIPlainSheetLength.getText()) + "',"
                            + "Width='" + Double.parseDouble(FIPlainSheetWidth.getText()) + "',"
                            + "Height='" + Double.parseDouble(FIPlainSheetHeight.getText()) + "',"
                            + "Color='" + FIPlainSheetColour.getText() + "',"
                            + "Thickness='" + Double.parseDouble(FIPlainSheetThickness.getText()) + "',"
                            + "Price='" + Double.parseDouble(FIPlainSheetPrice.getText()) + "',"
                            + "QtyOnHand='" + FIPlainSheetOnHandQty.getText() + "',"
                            + "LengthUnit='" + FIPlainSheetLengthUnit.getSelectedItem().toString() + "',"
                            + "WidthUnit='" + FIPlainSheetWidthUnit.getSelectedItem().toString() + "',"
                            + "HeightUnit='" + FIPlainSheetHeightUnit.getSelectedItem().toString() + "',"
                            + "ThicknessUnit='" + FIPlainSheetThicknessUnit.getSelectedItem().toString() + "' "
                            + "where ItemCode='" + FICodeTF.getText() + "'";
                    s.executeUpdate(path);
                    break;
                default:
                    break;
            }
        } catch (Exception ex) {
            Logger.getLogger(FinishedItemsJF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //__________Finished Item Update Button - Method END_________//
    // Load Finished ItemDetails From Combo Method Start  //
    void LoadFinishedItemDetailsFromDB() { // must call from inside the combo box
        String txt = FINameCB.getSelectedItem().toString();
        try {
            if (FINameCB.getSelectedIndex() != -1) {
                java.sql.Statement s = SeldoDB.GetMyConnection().createStatement();
                ResultSet rs = s.executeQuery("select * from finisheditem where ItemCode like '%" + txt + "%'");

                if (rs.next()) {
                    rs = s.executeQuery("select * from finisheditem where ItemCode = '" + txt + "'");
                    rs.next();
                    FinishedItemCatCB.setSelectedItem(rs.getString("ItemCat"));
                    FINameCB.setSelectedItem(rs.getString("ItemName"));
                    FICodeTF.setText(rs.getString("ItemCode"));
                    getFIData(txt, rs);

                } else {
                    rs = s.executeQuery("select * from finisheditem where ItemName = '" + txt + "'");
                    rs.next();
                    FinishedItemCatCB.setSelectedItem(rs.getString("ItemCat"));
                    FINameCB.setSelectedItem(rs.getString("ItemName"));
                    FICodeTF.setText(rs.getString("ItemCode"));
                    getFIData(txt, rs);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Load Finished ItemDetails From Combo Method END - Aloka //   

    //Aloka - Get Finished Item Data
    void getFIData(String txt, ResultSet rs) { // must call from inside the LoadFinishedItemDetailsFromDB() method
        try {
            switch (FinishedItemCatCB.getSelectedItem().toString()) {
                case "Roofing Sheets":
                    FIRoofingSheetLength.setText(rs.getString(String.valueOf("Lenght")));
                    FIRoofingSheetWidth.setText(rs.getString("Width"));
                    FIRoofingSheetHeight.setText(rs.getString("Height"));
                    FIRoofingSheetColour.setText(rs.getString("Color"));
                    FIRoofingSheetThickness.setText(rs.getString("Thickness"));
                    FIRoofingSheetPrice.setText(rs.getString("Price"));
                    FIRoofingSheetOnHandQty.setText(rs.getString("QtyOnHand"));
                    FIRoofingSheetLengthUnit.setSelectedItem(rs.getString("LenghtUnit"));
                    FIRoofingSheetWidthUnit.setSelectedItem(rs.getString("WidthUnit"));
                    FIRoofingSheetHeightUnit.setSelectedItem(rs.getString("HeightUnit"));
                    FIRoofingSheetThicknessUnit.setSelectedItem(rs.getString("ThicknessUnit"));
                    break;
                case "Roller Doors":
                    FIRollerDoorWidth.setText(rs.getString("Width"));
                    FIRollerDoorHeight.setText(rs.getString("Height"));
                    FIRollerDoorSqFeet.setText(rs.getString("SquareFeet"));
                    FIRollerDoorColour.setText(rs.getString("Color"));
                    FIRollerDoorThickness.setText(rs.getString("Thickness"));
                    FIRollerDoorPrice.setText(rs.getString("Price"));
                    FIRollerDoorOnHandQty.setText(rs.getString("QtyOnHand"));
                    FIRollerDoorWidthUnit.setSelectedItem(rs.getString("WidthUnit"));
                    FIRollerDoorHeightUnit.setSelectedItem(rs.getString("HeightUnit"));
                    FIRollerDoorThicknessUnit.setSelectedItem(rs.getString("ThicknessUnit"));
                    break;
                case "Roller Shutter":
                    FIRollerShutterLength.setText(rs.getString("Length"));
                    FIRollerShutterWidth.setText(rs.getString("Width"));
                    FIRollerShutterHeight.setText(rs.getString("Height"));
                    FIRollerShutterColour.setText(rs.getString("Color"));
                    FIRollerShutterThickness.setText(rs.getString("Thickness"));
                    FIRollerShutterPrice.setText(rs.getString("Price"));
                    FIRollerShutterOnHandQty.setText(rs.getString("QtyOnHand"));
                    FIRollerShutterLengthUnit.setSelectedItem(rs.getString("LengthUnit"));
                    FIRollerShutterWidthUnit.setSelectedItem(rs.getString("WidthUnit"));
                    FIRollerShutterHeightUnit.setSelectedItem(rs.getString("HeightUnit"));
                    FIRollerShutterThicknessUnit.setSelectedItem(rs.getString("ThicknessUnit"));
                    break;
                case "Gates":
                    FIGatesLength.setText(rs.getString("Length"));
                    FIGatesWidth.setText(rs.getString("Width"));
                    FIGatesHeight.setText(rs.getString("Height"));
                    FIGatesColour.setText(rs.getString("Color"));
                    FIGatesPrice.setText(rs.getString("Price"));
                    FIGatesOnHandQty.setText(rs.getString("QtyOnHand"));
                    FIGatesLengthUnit.setSelectedItem(rs.getString("LengthUnit"));
                    FIGatesWidthUnit.setSelectedItem(rs.getString("WidthUnit"));
                    FIGatesHeightUnit.setSelectedItem(rs.getString("HeightUnit"));
                    break;
                case "CPurling":
                    FIPurlingLength.setText(rs.getString("Length"));
                    FIPurlingWidth.setText(rs.getString("Width"));
                    FIPurlingHeight.setText(rs.getString("Height"));
                    FIPurlingThickness.setText(rs.getString("Thickness"));
                    FIPurlingPrice.setText(rs.getString("Price"));
                    FIPurlingOnHandQty.setText(rs.getString("QtyOnHand"));
                    FIPurlingLengthUnit.setSelectedItem(rs.getString("LengthUnit"));
                    FIPurlingWidthUnit.setSelectedItem(rs.getString("WidthUnit"));
                    FIPurlingHeightUnit.setSelectedItem(rs.getString("HeightUnit"));
                    FIPurlingThicknessUnit.setSelectedItem(rs.getString("ThicknessUnit"));
                    break;
                case "Gutters":
                    FIGutterLength.setText(rs.getString("Length"));
                    FIGutterWidth.setText(rs.getString("Width"));
                    FIGutterHeight.setText(rs.getString("Height"));
                    FIGutterColour.setText(rs.getString("Color"));
                    FIGutterThickness.setText(rs.getString("Thickness"));
                    FIGutterPrice.setText(rs.getString("Price"));
                    FIGutterOnHandQty.setText(rs.getString("QtyOnHand"));
                    FIGutterLengthUnit.setSelectedItem(rs.getString("LengthUnit"));
                    FIGutterWidthUnit.setSelectedItem(rs.getString("WidthUnit"));
                    FIGutterHeightUnit.setSelectedItem(rs.getString("HeightUnit"));
                    FIGutterThicknessUnit.setSelectedItem(rs.getString("ThicknessUnit"));
                    break;
                case "Plain Sheet":
                    FIPlainSheetSqfeet.setText(rs.getString("squirefeet"));
                    FIPlainSheetLength.setText(rs.getString("Length"));
                    FIPlainSheetWidth.setText(rs.getString("Width"));
                    FIPlainSheetHeight.setText(rs.getString("Height"));
                    FIPlainSheetColour.setText(rs.getString("Color"));
                    FIPlainSheetThickness.setText(rs.getString("Thickness"));
                    FIPlainSheetPrice.setText(rs.getString("Price"));
                    FIPlainSheetOnHandQty.setText(rs.getString("QtyOnHand"));
                    FIPlainSheetLengthUnit.setSelectedItem(rs.getString("LengthUnit"));
                    FIPlainSheetWidthUnit.setSelectedItem(rs.getString("WidthUnit"));
                    FIPlainSheetHeightUnit.setSelectedItem(rs.getString("HeightUnit"));
                    FIPlainSheetThicknessUnit.setSelectedItem(rs.getString("ThicknessUnit"));
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //Aloka - Get Finished Item Data Method END 

    //____________Search Finished Item Method Start_____________//
    void LoadItemCodeAndNameToFinishedItemPanel() { // must call from inside the constructor
        JComboBox iCode = FINameCB;
        iCode.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent x) {
                if (x.getKeyCode() != KeyEvent.VK_ENTER && x.getKeyCode() != KeyEvent.VK_UP && x.getKeyCode() != KeyEvent.VK_DOWN && x.getKeyCode() != KeyEvent.VK_SHIFT) {
                    String txt = iCode.getEditor().getItem().toString();
                    if (txt.isEmpty()) {
                        iCode.hidePopup();
                        iCode.removeAllItems();
                    } else {
                        try {
                            iCode.removeAllItems();
                            int i = 0;
                            java.sql.Statement s = SeldoDB.GetMyConnection().createStatement();
                            ResultSet rs = s.executeQuery("select ItemCode from finisheditem where ItemCode like '%" + txt + "%'");

                            Vector v = new Vector();
                            while (rs.next()) {
                                if (rs.getString("ItemCode").toLowerCase().contains(txt.toLowerCase())) {
                                    v.add(rs.getString("ItemCode"));
                                    i++;
                                }
                            }
                            rs = s.executeQuery("select ItemName from finisheditem where ItemName like '%" + txt + "%'");
                            while (rs.next()) {
                                if (rs.getString("ItemName").toLowerCase().contains(txt.toLowerCase())) {
                                    v.add(rs.getString("ItemName"));
                                    i++;
                                }
                            }
                            rs.close();
                            s.close();

                            DefaultComboBoxModel dcm = new DefaultComboBoxModel(v);
                            iCode.setModel(dcm);
                            iCode.getEditor().setItem(txt);
                            iCode.setSelectedItem(txt);
                            JTextField TextField = (JTextField) x.getSource();
                            TextField.setCaretPosition(TextField.getDocument().getLength());

                            if (i != 0) {
                                iCode.showPopup();
                                if (i > 10) {
                                    iCode.setMaximumRowCount(10);
                                } else {
                                    iCode.setMaximumRowCount(i);
                                }
                            } else {
                                iCode.hidePopup();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
    }
    //____________Search Finished Item Method END_____________//

    //____________Auto gen Finished Item Code Method Start_____________//
    void AutoGenFIcode() {
        try {
            java.sql.Statement s = SeldoDB.GetMyConnection().createStatement();
            ResultSet rs = s.executeQuery("select max(ItemCode) from finisheditem");
            if (rs.next()) {
                String MxFIcodeString = rs.getString("max(ItemCode)");
                if (MxFIcodeString == null) {
                    FICodeTF.setText("IC00000001");
                } else {
                    MxFIcodeString = MxFIcodeString.substring(2, 10);
                    int MxFIcodeInt = Integer.parseInt(MxFIcodeString);
                    MxFIcodeInt++;
                    MxFIcodeString = Integer.toString(MxFIcodeInt);
                    while (MxFIcodeString.length() < 8) {
                        MxFIcodeString = "0" + MxFIcodeString;
                    }
                    MxFIcodeString = "IC" + MxFIcodeString;
                    FICodeTF.setText(MxFIcodeString);
                }
            } else {
                FICodeTF.setText("FI00000001");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //____________Auto gen Finished Item Code Method END_____________//

    // Show And Hide more details of Finished Items - Method Start
    public void ShowHideData() {
        try {
            if (ShowHideDataBtn.getText().equals("More Details")) {
                ShowHideDataBtn.setText("Less Details");
                moreDetailsPanel.setVisible(true);
            } else {
                ShowHideDataBtn.setText("More Details");
                moreDetailsPanel.setVisible(false);
            }
        } catch (Exception e) {
            Logger.getLogger(FinishedItemsJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    // Show And Hide more details of Finished Items - Method End

    //Save Data To DB - Natz Method Start
    public void AddData() {
        try {
            Statement s = SeldoDB.GetMyConnection().createStatement();
            s.executeUpdate("Insert into finisheditem (ItemCode, ItemName, ItemCat) values ('" + FICodeTF.getText() + "' , '" + FINameCB.getSelectedItem().toString() + "' , '" + FinishedItemCatCB.getSelectedItem().toString() + "' ) ");
        } catch (Exception e) {
            Logger.getLogger(FinishedItemsJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    //Save Data To DB - Natz Method END
    //Clear Feilds
    public void ClearFeilds() {
        try {
            FinishedItemCatCB.setSelectedIndex(0);
            FINameCB.setSelectedItem(null);

        } catch (Exception e) {
            Logger.getLogger(FinishedItemsJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    //Clear feilds - Method end
    //Update Data Method Start
    public void UpdateData() {
        try {
            Statement s = SeldoDB.GetMyConnection().createStatement();
            s.executeUpdate("UPDATE finisheditem SET ItemName = '" + FINameCB.getSelectedItem().toString() + "' , ItemCat = '" + FinishedItemCatCB.getSelectedItem().toString() + "' where ItemCode = '" + FICodeTF.getText() + "' ");
        } catch (Exception e) {
            Logger.getLogger(FinishedItemsJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    //Update Data - Method END
    //Load Item code or Item name to Sales Panel Combo box Method Start
    public void LoadItemNameOrCodeToSalesPanelCB() {
        FINameCB.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {

                if (e.getKeyCode() != KeyEvent.VK_ENTER && e.getKeyCode() != KeyEvent.VK_UP && e.getKeyCode() != KeyEvent.VK_DOWN && e.getKeyCode() != KeyEvent.VK_SHIFT) {

                    String TypedTxt = FINameCB.getEditor().getItem().toString();

                    if (!TypedTxt.isEmpty()) {

                        try {
                            FINameCB.removeAllItems();
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
                            FINameCB.setModel(dcm);

                            FINameCB.getEditor().setItem(TypedTxt);
                            FINameCB.setSelectedItem(TypedTxt);
                            JTextField TextField = (JTextField) e.getSource();
                            TextField.setCaretPosition(TextField.getDocument().getLength());

                            if (st != 0) {
                                FINameCB.showPopup();

                                if (st > 10) {
                                    FINameCB.setMaximumRowCount(10);
                                } else {
                                    FINameCB.setMaximumRowCount(st);
                                }

                            } else {
                                FINameCB.hidePopup();
                            }

                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, ex);
                        }
                    } else {
                        FINameCB.hidePopup();
                        FINameCB.removeAllItems();
                    }
                }
            }
        });
    }
    //Load Item code or Item name to Sales Panel Combo box Method END

    //Set Selected Data in to feilds - Method Start
    
    public void SearchAndSetMethod() {

        try {
            if (FINameCB.getSelectedIndex() != -1) {
                String TypedText = FINameCB.getSelectedItem().toString();
                Statement s = SeldoDB.GetMyConnection().createStatement();
                ResultSet RS = s.executeQuery("SELECT * FROM finisheditem WHERE ItemCode = '" + TypedText + "' ");

                if (RS.next()) {                                 //if Item code equels to typed text in combo box
                    String ItemCode = TypedText;
                    RS = s.executeQuery("SELECT * FROM finisheditem WHERE ItemCode = '" + ItemCode + "' ");
                    RS.next();

                    String ItemName = RS.getString("ItemName");
                    String ItemCodeDB = RS.getString("ItemCode");
                    String ItemCatogary = RS.getString("ItemCat");
                    
                    FICodeTF.setText(ItemCodeDB);
                    FINameCB.setSelectedItem(ItemName);
                    FinishedItemCatCB.setSelectedItem(ItemCatogary);

                } else {
                    String ItemName = TypedText;
                    RS = s.executeQuery("SELECT * FROM finisheditem WHERE ItemName= '" + ItemName + "' ");
                    RS.next();
                    String ItemNameDB = RS.getString("ItemName");
                    String ItemCodeDB = RS.getString("ItemCode");
                    String ItemCatogary = RS.getString("ItemCat");
                    
                    FICodeTF.setText(ItemCodeDB);
                    FINameCB.setSelectedItem(ItemNameDB);
                    FinishedItemCatCB.setSelectedItem(ItemCatogary);

                }
            } else {
//                FICodeTF.setText(null);
//                FINameCB.setSelectedItem(null);
            }
        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null, e);
        }

    }
//Set Selected Data in to feilds - Method END
    
    
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
        TopicPanel = new javax.swing.JPanel();
        SPSalesBtn = new javax.swing.JButton();
        SPPaymentsBtn = new javax.swing.JButton();
        SPFinishedItemsBtn = new javax.swing.JButton();
        SPRawItemBtn = new javax.swing.JButton();
        SPCustomersBtn = new javax.swing.JButton();
        SPEmployeeBtn = new javax.swing.JButton();
        SPSupplierBtn = new javax.swing.JButton();
        SPVehicleBtn = new javax.swing.JButton();
        SPReportBtn = new javax.swing.JButton();
        SPBranchersBtn = new javax.swing.JButton();
        SPSettingsBtn = new javax.swing.JButton();
        SPArrowLbl = new javax.swing.JLabel();
        SPChequesBtn = new javax.swing.JButton();
        SPSettingsBtn1 = new javax.swing.JButton();
        ContentsPanel = new javax.swing.JPanel();
        CPFinishedItemsPanel = new javax.swing.JPanel();
        moreDetailsPanel = new javax.swing.JPanel();
        FIRoofingSheetsPanel = new javax.swing.JPanel();
        jLabel122 = new javax.swing.JLabel();
        jLabel123 = new javax.swing.JLabel();
        jLabel124 = new javax.swing.JLabel();
        jLabel125 = new javax.swing.JLabel();
        jLabel126 = new javax.swing.JLabel();
        FIRoofingSheetColour = new javax.swing.JTextField();
        FIRoofingSheetOnHandQty = new javax.swing.JTextField();
        FIRoofingSheetWidth = new javax.swing.JTextField();
        FIRoofingSheetHeight = new javax.swing.JTextField();
        FIRoofingSheetThickness = new javax.swing.JTextField();
        jLabel128 = new javax.swing.JLabel();
        FIRoofingSheetLength = new javax.swing.JTextField();
        jLabel148 = new javax.swing.JLabel();
        jLabel329 = new javax.swing.JLabel();
        jLabel330 = new javax.swing.JLabel();
        jLabel332 = new javax.swing.JLabel();
        FIRoofingSheetThicknessUnit = new javax.swing.JComboBox<>();
        FIRoofingSheetLengthUnit = new javax.swing.JComboBox<>();
        FIRoofingSheetWidthUnit = new javax.swing.JComboBox<>();
        FIRoofingSheetHeightUnit = new javax.swing.JComboBox<>();
        jLabel131 = new javax.swing.JLabel();
        FIRoofingSheetPrice = new javax.swing.JTextField();
        FIRollerDoorsPanel = new javax.swing.JPanel();
        jLabel129 = new javax.swing.JLabel();
        jLabel130 = new javax.swing.JLabel();
        jLabel333 = new javax.swing.JLabel();
        jLabel334 = new javax.swing.JLabel();
        jLabel338 = new javax.swing.JLabel();
        FIRollerDoorColour = new javax.swing.JTextField();
        FIRollerDoorOnHandQty = new javax.swing.JTextField();
        FIRollerDoorWidth = new javax.swing.JTextField();
        FIRollerDoorHeight = new javax.swing.JTextField();
        FIRollerDoorThickness = new javax.swing.JTextField();
        jLabel341 = new javax.swing.JLabel();
        jLabel344 = new javax.swing.JLabel();
        jLabel345 = new javax.swing.JLabel();
        FIRollerDoorThicknessUnit = new javax.swing.JComboBox<>();
        FIRollerDoorWidthUnit = new javax.swing.JComboBox<>();
        FIRollerDoorHeightUnit = new javax.swing.JComboBox<>();
        FIRollerDoorSqFeet = new javax.swing.JTextField();
        jLabel342 = new javax.swing.JLabel();
        jLabel132 = new javax.swing.JLabel();
        FIRollerDoorPrice = new javax.swing.JTextField();
        FIRollerShutterPanel = new javax.swing.JPanel();
        jLabel390 = new javax.swing.JLabel();
        jLabel391 = new javax.swing.JLabel();
        jLabel392 = new javax.swing.JLabel();
        jLabel393 = new javax.swing.JLabel();
        jLabel394 = new javax.swing.JLabel();
        FIRollerShutterColour = new javax.swing.JTextField();
        FIRollerShutterOnHandQty = new javax.swing.JTextField();
        FIRollerShutterWidth = new javax.swing.JTextField();
        FIRollerShutterHeight = new javax.swing.JTextField();
        FIRollerShutterThickness = new javax.swing.JTextField();
        jLabel396 = new javax.swing.JLabel();
        FIRollerShutterLength = new javax.swing.JTextField();
        jLabel397 = new javax.swing.JLabel();
        jLabel398 = new javax.swing.JLabel();
        jLabel399 = new javax.swing.JLabel();
        jLabel400 = new javax.swing.JLabel();
        FIRollerShutterThicknessUnit = new javax.swing.JComboBox<>();
        FIRollerShutterLengthUnit = new javax.swing.JComboBox<>();
        FIRollerShutterWidthUnit = new javax.swing.JComboBox<>();
        FIRollerShutterHeightUnit = new javax.swing.JComboBox<>();
        jLabel133 = new javax.swing.JLabel();
        FIRollerShutterPrice = new javax.swing.JTextField();
        FIGatesPanel = new javax.swing.JPanel();
        jLabel346 = new javax.swing.JLabel();
        jLabel348 = new javax.swing.JLabel();
        jLabel349 = new javax.swing.JLabel();
        jLabel350 = new javax.swing.JLabel();
        FIGatesColour = new javax.swing.JTextField();
        FIGatesOnHandQty = new javax.swing.JTextField();
        FIGatesWidth = new javax.swing.JTextField();
        FIGatesHeight = new javax.swing.JTextField();
        FIGatesLength = new javax.swing.JTextField();
        jLabel353 = new javax.swing.JLabel();
        jLabel354 = new javax.swing.JLabel();
        jLabel355 = new javax.swing.JLabel();
        jLabel356 = new javax.swing.JLabel();
        FIGatesLengthUnit = new javax.swing.JComboBox<>();
        FIGatesWidthUnit = new javax.swing.JComboBox<>();
        FIGatesHeightUnit = new javax.swing.JComboBox<>();
        jLabel134 = new javax.swing.JLabel();
        FIGatesPrice = new javax.swing.JTextField();
        FIPurlingPanel = new javax.swing.JPanel();
        jLabel358 = new javax.swing.JLabel();
        jLabel359 = new javax.swing.JLabel();
        jLabel360 = new javax.swing.JLabel();
        jLabel361 = new javax.swing.JLabel();
        FIPurlingOnHandQty = new javax.swing.JTextField();
        FIPurlingWidth = new javax.swing.JTextField();
        FIPurlingHeight = new javax.swing.JTextField();
        FIPurlingThickness = new javax.swing.JTextField();
        jLabel363 = new javax.swing.JLabel();
        FIPurlingLength = new javax.swing.JTextField();
        jLabel364 = new javax.swing.JLabel();
        jLabel365 = new javax.swing.JLabel();
        jLabel366 = new javax.swing.JLabel();
        jLabel367 = new javax.swing.JLabel();
        FIPurlingThicknessUnit = new javax.swing.JComboBox<>();
        FIPurlingLengthUnit = new javax.swing.JComboBox<>();
        FIPurlingWidthUnit = new javax.swing.JComboBox<>();
        FIPurlingHeightUnit = new javax.swing.JComboBox<>();
        jLabel135 = new javax.swing.JLabel();
        FIPurlingPrice = new javax.swing.JTextField();
        FIGuttersPanel = new javax.swing.JPanel();
        jLabel368 = new javax.swing.JLabel();
        jLabel369 = new javax.swing.JLabel();
        jLabel370 = new javax.swing.JLabel();
        jLabel371 = new javax.swing.JLabel();
        jLabel372 = new javax.swing.JLabel();
        FIGutterColour = new javax.swing.JTextField();
        FIGutterOnHandQty = new javax.swing.JTextField();
        FIGutterWidth = new javax.swing.JTextField();
        FIGutterHeight = new javax.swing.JTextField();
        FIGutterThickness = new javax.swing.JTextField();
        jLabel374 = new javax.swing.JLabel();
        FIGutterLength = new javax.swing.JTextField();
        jLabel375 = new javax.swing.JLabel();
        jLabel376 = new javax.swing.JLabel();
        jLabel377 = new javax.swing.JLabel();
        jLabel378 = new javax.swing.JLabel();
        FIGutterThicknessUnit = new javax.swing.JComboBox<>();
        FIGutterLengthUnit = new javax.swing.JComboBox<>();
        FIGutterWidthUnit = new javax.swing.JComboBox<>();
        FIGutterHeightUnit = new javax.swing.JComboBox<>();
        jLabel136 = new javax.swing.JLabel();
        FIGutterPrice = new javax.swing.JTextField();
        FIPlainSheetPanel = new javax.swing.JPanel();
        jLabel379 = new javax.swing.JLabel();
        jLabel380 = new javax.swing.JLabel();
        jLabel381 = new javax.swing.JLabel();
        jLabel382 = new javax.swing.JLabel();
        jLabel383 = new javax.swing.JLabel();
        FIPlainSheetColour = new javax.swing.JTextField();
        FIPlainSheetOnHandQty = new javax.swing.JTextField();
        FIPlainSheetWidth = new javax.swing.JTextField();
        FIPlainSheetHeight = new javax.swing.JTextField();
        FIPlainSheetThickness = new javax.swing.JTextField();
        jLabel385 = new javax.swing.JLabel();
        FIPlainSheetLength = new javax.swing.JTextField();
        jLabel386 = new javax.swing.JLabel();
        jLabel387 = new javax.swing.JLabel();
        jLabel388 = new javax.swing.JLabel();
        jLabel389 = new javax.swing.JLabel();
        FIPlainSheetThicknessUnit = new javax.swing.JComboBox<>();
        FIPlainSheetLengthUnit = new javax.swing.JComboBox<>();
        FIPlainSheetWidthUnit = new javax.swing.JComboBox<>();
        FIPlainSheetHeightUnit = new javax.swing.JComboBox<>();
        jLabel401 = new javax.swing.JLabel();
        FIPlainSheetSqfeet = new javax.swing.JTextField();
        jLabel137 = new javax.swing.JLabel();
        FIPlainSheetPrice = new javax.swing.JTextField();
        FinishedItemCatCB = new javax.swing.JComboBox<>();
        jLabel25 = new javax.swing.JLabel();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        FINameCB = new javax.swing.JComboBox<>();
        FINameLbl = new javax.swing.JLabel();
        jLabel340 = new javax.swing.JLabel();
        FICodeTF = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        ShowHideDataBtn = new javax.swing.JButton();

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

        TopicPanel.setBackground(new java.awt.Color(102, 102, 102));
        TopicPanel.setOpaque(false);
        TopicPanel.setPreferredSize(new java.awt.Dimension(230, 710));
        TopicPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        SPReportBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/ReportLableIMG01.png"))); // NOI18N
        SPReportBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/ReportLableIMG02.png"))); // NOI18N
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

        SPArrowLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SPArrowLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/ArrowSingleBlue.png"))); // NOI18N
        TopicPanel.add(SPArrowLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 40, -1));

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
        TopicPanel.add(SPChequesBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 470, -1, -1));

        SPSettingsBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/ExpencesIMG1.png"))); // NOI18N
        SPSettingsBtn1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/ExpencesIMG2.png"))); // NOI18N
        SPSettingsBtn1.setBorderPainted(false);
        SPSettingsBtn1.setContentAreaFilled(false);
        SPSettingsBtn1.setMaximumSize(new java.awt.Dimension(200, 40));
        SPSettingsBtn1.setMinimumSize(new java.awt.Dimension(200, 40));
        SPSettingsBtn1.setName(""); // NOI18N
        SPSettingsBtn1.setPreferredSize(new java.awt.Dimension(200, 40));
        SPSettingsBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SPSettingsBtn1ActionPerformed(evt);
            }
        });
        TopicPanel.add(SPSettingsBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 570, 200, -1));

        jPanel1.add(TopicPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 240, 710));

        ContentsPanel.setMinimumSize(new java.awt.Dimension(1010, 710));
        ContentsPanel.setOpaque(false);
        ContentsPanel.setLayout(new java.awt.CardLayout());

        CPFinishedItemsPanel.setBackground(new java.awt.Color(0, 51, 51));
        CPFinishedItemsPanel.setMinimumSize(new java.awt.Dimension(1140, 710));
        CPFinishedItemsPanel.setOpaque(false);
        CPFinishedItemsPanel.setPreferredSize(new java.awt.Dimension(1140, 710));
        CPFinishedItemsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        moreDetailsPanel.setBackground(new java.awt.Color(153, 153, 255));
        moreDetailsPanel.setForeground(new java.awt.Color(153, 153, 255));
        moreDetailsPanel.setOpaque(false);
        moreDetailsPanel.setLayout(new java.awt.CardLayout());

        FIRoofingSheetsPanel.setBackground(new java.awt.Color(0, 102, 102));
        FIRoofingSheetsPanel.setOpaque(false);
        FIRoofingSheetsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel122.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel122.setForeground(new java.awt.Color(255, 255, 255));
        jLabel122.setText("Colour");
        FIRoofingSheetsPanel.add(jLabel122, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel123.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel123.setForeground(new java.awt.Color(255, 255, 255));
        jLabel123.setText("Thickness");
        FIRoofingSheetsPanel.add(jLabel123, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jLabel124.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel124.setForeground(new java.awt.Color(255, 255, 255));
        jLabel124.setText("Height");
        FIRoofingSheetsPanel.add(jLabel124, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel125.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel125.setForeground(new java.awt.Color(255, 255, 255));
        jLabel125.setText("Width");
        FIRoofingSheetsPanel.add(jLabel125, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel126.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel126.setForeground(new java.awt.Color(255, 255, 255));
        jLabel126.setText("On Hand Quantity");
        FIRoofingSheetsPanel.add(jLabel126, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        FIRoofingSheetColour.setBackground(new java.awt.Color(102, 102, 102));
        FIRoofingSheetColour.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIRoofingSheetColour.setForeground(new java.awt.Color(255, 255, 255));
        FIRoofingSheetsPanel.add(FIRoofingSheetColour, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 260, -1));

        FIRoofingSheetOnHandQty.setBackground(new java.awt.Color(102, 102, 102));
        FIRoofingSheetOnHandQty.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIRoofingSheetOnHandQty.setForeground(new java.awt.Color(255, 255, 255));
        FIRoofingSheetsPanel.add(FIRoofingSheetOnHandQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 260, -1));

        FIRoofingSheetWidth.setBackground(new java.awt.Color(102, 102, 102));
        FIRoofingSheetWidth.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIRoofingSheetWidth.setForeground(new java.awt.Color(255, 255, 255));
        FIRoofingSheetsPanel.add(FIRoofingSheetWidth, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 260, -1));

        FIRoofingSheetHeight.setBackground(new java.awt.Color(102, 102, 102));
        FIRoofingSheetHeight.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIRoofingSheetHeight.setForeground(new java.awt.Color(255, 255, 255));
        FIRoofingSheetsPanel.add(FIRoofingSheetHeight, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 260, -1));

        FIRoofingSheetThickness.setBackground(new java.awt.Color(102, 102, 102));
        FIRoofingSheetThickness.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIRoofingSheetThickness.setForeground(new java.awt.Color(255, 255, 255));
        FIRoofingSheetThickness.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FIRoofingSheetThicknessActionPerformed(evt);
            }
        });
        FIRoofingSheetsPanel.add(FIRoofingSheetThickness, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 260, -1));

        jLabel128.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel128.setForeground(new java.awt.Color(255, 255, 255));
        jLabel128.setText("Unit");
        FIRoofingSheetsPanel.add(jLabel128, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 130, -1, -1));

        FIRoofingSheetLength.setBackground(new java.awt.Color(102, 102, 102));
        FIRoofingSheetLength.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIRoofingSheetLength.setForeground(new java.awt.Color(255, 255, 255));
        FIRoofingSheetsPanel.add(FIRoofingSheetLength, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 260, -1));

        jLabel148.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel148.setForeground(new java.awt.Color(255, 255, 255));
        jLabel148.setText("Length");
        FIRoofingSheetsPanel.add(jLabel148, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel329.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel329.setForeground(new java.awt.Color(255, 255, 255));
        jLabel329.setText("Unit");
        FIRoofingSheetsPanel.add(jLabel329, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, -1, -1));

        jLabel330.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel330.setForeground(new java.awt.Color(255, 255, 255));
        jLabel330.setText("Unit");
        FIRoofingSheetsPanel.add(jLabel330, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, -1, -1));

        jLabel332.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel332.setForeground(new java.awt.Color(255, 255, 255));
        jLabel332.setText("Unit");
        FIRoofingSheetsPanel.add(jLabel332, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, -1, -1));

        FIRoofingSheetThicknessUnit.setBackground(new java.awt.Color(102, 102, 102));
        FIRoofingSheetThicknessUnit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIRoofingSheetThicknessUnit.setForeground(new java.awt.Color(255, 255, 255));
        FIRoofingSheetThicknessUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Meters", "Centimeters", "Millimeters", "Inches", "Feet" }));
        FIRoofingSheetsPanel.add(FIRoofingSheetThicknessUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 130, 130, -1));

        FIRoofingSheetLengthUnit.setBackground(new java.awt.Color(102, 102, 102));
        FIRoofingSheetLengthUnit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIRoofingSheetLengthUnit.setForeground(new java.awt.Color(255, 255, 255));
        FIRoofingSheetLengthUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Meters", "Centimeters", "Millimeters", "Inches", "Feet" }));
        FIRoofingSheetLengthUnit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FIRoofingSheetLengthUnitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                FIRoofingSheetLengthUnitMouseEntered(evt);
            }
        });
        FIRoofingSheetLengthUnit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FIRoofingSheetLengthUnitActionPerformed(evt);
            }
        });
        FIRoofingSheetLengthUnit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                FIRoofingSheetLengthUnitKeyPressed(evt);
            }
        });
        FIRoofingSheetsPanel.add(FIRoofingSheetLengthUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, 130, -1));

        FIRoofingSheetWidthUnit.setBackground(new java.awt.Color(102, 102, 102));
        FIRoofingSheetWidthUnit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIRoofingSheetWidthUnit.setForeground(new java.awt.Color(255, 255, 255));
        FIRoofingSheetWidthUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Meters", "Centimeters", "Millimeters", "Inches", "Feet" }));
        FIRoofingSheetsPanel.add(FIRoofingSheetWidthUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 50, 130, -1));

        FIRoofingSheetHeightUnit.setBackground(new java.awt.Color(102, 102, 102));
        FIRoofingSheetHeightUnit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIRoofingSheetHeightUnit.setForeground(new java.awt.Color(255, 255, 255));
        FIRoofingSheetHeightUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Meters", "Centimeters", "Millimeters", "Inches", "Feet" }));
        FIRoofingSheetsPanel.add(FIRoofingSheetHeightUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 90, 130, -1));

        jLabel131.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel131.setForeground(new java.awt.Color(255, 255, 255));
        jLabel131.setText("Price");
        FIRoofingSheetsPanel.add(jLabel131, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 60, -1));

        FIRoofingSheetPrice.setBackground(new java.awt.Color(102, 102, 102));
        FIRoofingSheetPrice.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIRoofingSheetPrice.setForeground(new java.awt.Color(255, 255, 255));
        FIRoofingSheetsPanel.add(FIRoofingSheetPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, 260, -1));

        moreDetailsPanel.add(FIRoofingSheetsPanel, "card3");

        FIRollerDoorsPanel.setBackground(new java.awt.Color(0, 102, 102));
        FIRollerDoorsPanel.setOpaque(false);
        FIRollerDoorsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel129.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel129.setForeground(new java.awt.Color(255, 255, 255));
        jLabel129.setText("Colour");
        FIRollerDoorsPanel.add(jLabel129, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel130.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel130.setForeground(new java.awt.Color(255, 255, 255));
        jLabel130.setText("Thickness");
        FIRollerDoorsPanel.add(jLabel130, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jLabel333.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel333.setForeground(new java.awt.Color(255, 255, 255));
        jLabel333.setText("Height");
        FIRollerDoorsPanel.add(jLabel333, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel334.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel334.setForeground(new java.awt.Color(255, 255, 255));
        jLabel334.setText("Width");
        FIRollerDoorsPanel.add(jLabel334, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel338.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel338.setForeground(new java.awt.Color(255, 255, 255));
        jLabel338.setText("On Hand Quantity");
        FIRollerDoorsPanel.add(jLabel338, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        FIRollerDoorColour.setBackground(new java.awt.Color(102, 102, 102));
        FIRollerDoorColour.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIRollerDoorColour.setForeground(new java.awt.Color(255, 255, 255));
        FIRollerDoorsPanel.add(FIRollerDoorColour, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 260, -1));

        FIRollerDoorOnHandQty.setBackground(new java.awt.Color(102, 102, 102));
        FIRollerDoorOnHandQty.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIRollerDoorOnHandQty.setForeground(new java.awt.Color(255, 255, 255));
        FIRollerDoorsPanel.add(FIRollerDoorOnHandQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 260, -1));

        FIRollerDoorWidth.setBackground(new java.awt.Color(102, 102, 102));
        FIRollerDoorWidth.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIRollerDoorWidth.setForeground(new java.awt.Color(255, 255, 255));
        FIRollerDoorsPanel.add(FIRollerDoorWidth, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 260, -1));

        FIRollerDoorHeight.setBackground(new java.awt.Color(102, 102, 102));
        FIRollerDoorHeight.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIRollerDoorHeight.setForeground(new java.awt.Color(255, 255, 255));
        FIRollerDoorsPanel.add(FIRollerDoorHeight, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 260, -1));

        FIRollerDoorThickness.setBackground(new java.awt.Color(102, 102, 102));
        FIRollerDoorThickness.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIRollerDoorThickness.setForeground(new java.awt.Color(255, 255, 255));
        FIRollerDoorsPanel.add(FIRollerDoorThickness, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 260, -1));

        jLabel341.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel341.setForeground(new java.awt.Color(255, 255, 255));
        jLabel341.setText("Unit");
        FIRollerDoorsPanel.add(jLabel341, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 130, -1, -1));

        jLabel344.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel344.setForeground(new java.awt.Color(255, 255, 255));
        jLabel344.setText("Unit");
        FIRollerDoorsPanel.add(jLabel344, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, -1, -1));

        jLabel345.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel345.setForeground(new java.awt.Color(255, 255, 255));
        jLabel345.setText("Unit");
        FIRollerDoorsPanel.add(jLabel345, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, -1, -1));

        FIRollerDoorThicknessUnit.setBackground(new java.awt.Color(102, 102, 102));
        FIRollerDoorThicknessUnit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIRollerDoorThicknessUnit.setForeground(new java.awt.Color(255, 255, 255));
        FIRollerDoorThicknessUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Meters", "Centimeters", "Millimeters", "Inches", "Feets" }));
        FIRollerDoorsPanel.add(FIRollerDoorThicknessUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 130, 100, -1));

        FIRollerDoorWidthUnit.setBackground(new java.awt.Color(102, 102, 102));
        FIRollerDoorWidthUnit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIRollerDoorWidthUnit.setForeground(new java.awt.Color(255, 255, 255));
        FIRollerDoorWidthUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Meters", "Centimeters", "Millimeters", "Inches", "Feets" }));
        FIRollerDoorsPanel.add(FIRollerDoorWidthUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, 100, -1));

        FIRollerDoorHeightUnit.setBackground(new java.awt.Color(102, 102, 102));
        FIRollerDoorHeightUnit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIRollerDoorHeightUnit.setForeground(new java.awt.Color(255, 255, 255));
        FIRollerDoorHeightUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Meters", "Centimeters", "Millimeters", "Inches", "Feets" }));
        FIRollerDoorsPanel.add(FIRollerDoorHeightUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 50, 100, -1));

        FIRollerDoorSqFeet.setBackground(new java.awt.Color(102, 102, 102));
        FIRollerDoorSqFeet.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIRollerDoorSqFeet.setForeground(new java.awt.Color(255, 255, 255));
        FIRollerDoorsPanel.add(FIRollerDoorSqFeet, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 260, -1));

        jLabel342.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel342.setForeground(new java.awt.Color(255, 255, 255));
        jLabel342.setText("Square feets");
        FIRollerDoorsPanel.add(jLabel342, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel132.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel132.setForeground(new java.awt.Color(255, 255, 255));
        jLabel132.setText("Price");
        FIRollerDoorsPanel.add(jLabel132, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 60, -1));

        FIRollerDoorPrice.setBackground(new java.awt.Color(102, 102, 102));
        FIRollerDoorPrice.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIRollerDoorPrice.setForeground(new java.awt.Color(255, 255, 255));
        FIRollerDoorsPanel.add(FIRollerDoorPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, 260, -1));

        moreDetailsPanel.add(FIRollerDoorsPanel, "card2");

        FIRollerShutterPanel.setBackground(new java.awt.Color(0, 102, 102));
        FIRollerShutterPanel.setOpaque(false);
        FIRollerShutterPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel390.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel390.setForeground(new java.awt.Color(255, 255, 255));
        jLabel390.setText("Colour");
        FIRollerShutterPanel.add(jLabel390, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel391.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel391.setForeground(new java.awt.Color(255, 255, 255));
        jLabel391.setText("Thickness");
        FIRollerShutterPanel.add(jLabel391, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jLabel392.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel392.setForeground(new java.awt.Color(255, 255, 255));
        jLabel392.setText("Height");
        FIRollerShutterPanel.add(jLabel392, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel393.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel393.setForeground(new java.awt.Color(255, 255, 255));
        jLabel393.setText("Width");
        FIRollerShutterPanel.add(jLabel393, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel394.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel394.setForeground(new java.awt.Color(255, 255, 255));
        jLabel394.setText("On Hand Quantity");
        FIRollerShutterPanel.add(jLabel394, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        FIRollerShutterColour.setBackground(new java.awt.Color(102, 102, 102));
        FIRollerShutterColour.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIRollerShutterColour.setForeground(new java.awt.Color(255, 255, 255));
        FIRollerShutterPanel.add(FIRollerShutterColour, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 260, -1));

        FIRollerShutterOnHandQty.setBackground(new java.awt.Color(102, 102, 102));
        FIRollerShutterOnHandQty.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIRollerShutterOnHandQty.setForeground(new java.awt.Color(255, 255, 255));
        FIRollerShutterPanel.add(FIRollerShutterOnHandQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 260, -1));

        FIRollerShutterWidth.setBackground(new java.awt.Color(102, 102, 102));
        FIRollerShutterWidth.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIRollerShutterWidth.setForeground(new java.awt.Color(255, 255, 255));
        FIRollerShutterPanel.add(FIRollerShutterWidth, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 260, -1));

        FIRollerShutterHeight.setBackground(new java.awt.Color(102, 102, 102));
        FIRollerShutterHeight.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIRollerShutterHeight.setForeground(new java.awt.Color(255, 255, 255));
        FIRollerShutterPanel.add(FIRollerShutterHeight, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 260, -1));

        FIRollerShutterThickness.setBackground(new java.awt.Color(102, 102, 102));
        FIRollerShutterThickness.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIRollerShutterThickness.setForeground(new java.awt.Color(255, 255, 255));
        FIRollerShutterPanel.add(FIRollerShutterThickness, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 260, -1));

        jLabel396.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel396.setForeground(new java.awt.Color(255, 255, 255));
        jLabel396.setText("Unit");
        FIRollerShutterPanel.add(jLabel396, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 130, -1, -1));

        FIRollerShutterLength.setBackground(new java.awt.Color(102, 102, 102));
        FIRollerShutterLength.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIRollerShutterLength.setForeground(new java.awt.Color(255, 255, 255));
        FIRollerShutterPanel.add(FIRollerShutterLength, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 260, -1));

        jLabel397.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel397.setForeground(new java.awt.Color(255, 255, 255));
        jLabel397.setText("Length");
        FIRollerShutterPanel.add(jLabel397, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel398.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel398.setForeground(new java.awt.Color(255, 255, 255));
        jLabel398.setText("Unit");
        FIRollerShutterPanel.add(jLabel398, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, -1, -1));

        jLabel399.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel399.setForeground(new java.awt.Color(255, 255, 255));
        jLabel399.setText("Unit");
        FIRollerShutterPanel.add(jLabel399, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, -1, -1));

        jLabel400.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel400.setForeground(new java.awt.Color(255, 255, 255));
        jLabel400.setText("Unit");
        FIRollerShutterPanel.add(jLabel400, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, -1, -1));

        FIRollerShutterThicknessUnit.setBackground(new java.awt.Color(102, 102, 102));
        FIRollerShutterThicknessUnit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIRollerShutterThicknessUnit.setForeground(new java.awt.Color(255, 255, 255));
        FIRollerShutterThicknessUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Meters", "Centimeters", "Millimeters", "Inches", "Feets" }));
        FIRollerShutterPanel.add(FIRollerShutterThicknessUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 130, 100, -1));

        FIRollerShutterLengthUnit.setBackground(new java.awt.Color(102, 102, 102));
        FIRollerShutterLengthUnit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIRollerShutterLengthUnit.setForeground(new java.awt.Color(255, 255, 255));
        FIRollerShutterLengthUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Meters", "Centimeters", "Millimeters", "Inches", "Feets" }));
        FIRollerShutterPanel.add(FIRollerShutterLengthUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, 100, -1));

        FIRollerShutterWidthUnit.setBackground(new java.awt.Color(102, 102, 102));
        FIRollerShutterWidthUnit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIRollerShutterWidthUnit.setForeground(new java.awt.Color(255, 255, 255));
        FIRollerShutterWidthUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Meters", "Centimeters", "Millimeters", "Inches", "Feets" }));
        FIRollerShutterPanel.add(FIRollerShutterWidthUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 50, 100, -1));

        FIRollerShutterHeightUnit.setBackground(new java.awt.Color(102, 102, 102));
        FIRollerShutterHeightUnit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIRollerShutterHeightUnit.setForeground(new java.awt.Color(255, 255, 255));
        FIRollerShutterHeightUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Meters", "Centimeters", "Millimeters", "Inches", "Feets" }));
        FIRollerShutterPanel.add(FIRollerShutterHeightUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 90, 100, -1));

        jLabel133.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel133.setForeground(new java.awt.Color(255, 255, 255));
        jLabel133.setText("Price");
        FIRollerShutterPanel.add(jLabel133, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 60, -1));

        FIRollerShutterPrice.setBackground(new java.awt.Color(102, 102, 102));
        FIRollerShutterPrice.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIRollerShutterPrice.setForeground(new java.awt.Color(255, 255, 255));
        FIRollerShutterPanel.add(FIRollerShutterPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 330, 260, -1));

        moreDetailsPanel.add(FIRollerShutterPanel, "card8");

        FIGatesPanel.setBackground(new java.awt.Color(0, 102, 102));
        FIGatesPanel.setOpaque(false);
        FIGatesPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel346.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel346.setForeground(new java.awt.Color(255, 255, 255));
        jLabel346.setText("Colour");
        FIGatesPanel.add(jLabel346, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jLabel348.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel348.setForeground(new java.awt.Color(255, 255, 255));
        jLabel348.setText("Height");
        FIGatesPanel.add(jLabel348, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel349.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel349.setForeground(new java.awt.Color(255, 255, 255));
        jLabel349.setText("Width");
        FIGatesPanel.add(jLabel349, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel350.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel350.setForeground(new java.awt.Color(255, 255, 255));
        jLabel350.setText("On Hand Quantity");
        FIGatesPanel.add(jLabel350, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        FIGatesColour.setBackground(new java.awt.Color(102, 102, 102));
        FIGatesColour.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIGatesColour.setForeground(new java.awt.Color(255, 255, 255));
        FIGatesPanel.add(FIGatesColour, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 260, -1));

        FIGatesOnHandQty.setBackground(new java.awt.Color(102, 102, 102));
        FIGatesOnHandQty.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIGatesOnHandQty.setForeground(new java.awt.Color(255, 255, 255));
        FIGatesPanel.add(FIGatesOnHandQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 260, -1));

        FIGatesWidth.setBackground(new java.awt.Color(102, 102, 102));
        FIGatesWidth.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIGatesWidth.setForeground(new java.awt.Color(255, 255, 255));
        FIGatesPanel.add(FIGatesWidth, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 260, -1));

        FIGatesHeight.setBackground(new java.awt.Color(102, 102, 102));
        FIGatesHeight.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIGatesHeight.setForeground(new java.awt.Color(255, 255, 255));
        FIGatesPanel.add(FIGatesHeight, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 260, -1));

        FIGatesLength.setBackground(new java.awt.Color(102, 102, 102));
        FIGatesLength.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIGatesLength.setForeground(new java.awt.Color(255, 255, 255));
        FIGatesPanel.add(FIGatesLength, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 260, -1));

        jLabel353.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel353.setForeground(new java.awt.Color(255, 255, 255));
        jLabel353.setText("Length");
        FIGatesPanel.add(jLabel353, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel354.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel354.setForeground(new java.awt.Color(255, 255, 255));
        jLabel354.setText("Unit");
        FIGatesPanel.add(jLabel354, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, -1, -1));

        jLabel355.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel355.setForeground(new java.awt.Color(255, 255, 255));
        jLabel355.setText("Unit");
        FIGatesPanel.add(jLabel355, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, -1, -1));

        jLabel356.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel356.setForeground(new java.awt.Color(255, 255, 255));
        jLabel356.setText("Unit");
        FIGatesPanel.add(jLabel356, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, -1, -1));

        FIGatesLengthUnit.setBackground(new java.awt.Color(102, 102, 102));
        FIGatesLengthUnit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIGatesLengthUnit.setForeground(new java.awt.Color(255, 255, 255));
        FIGatesLengthUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Meters", "Centimeters", "Millimeters", "Inches", "Feets" }));
        FIGatesPanel.add(FIGatesLengthUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, 100, -1));

        FIGatesWidthUnit.setBackground(new java.awt.Color(102, 102, 102));
        FIGatesWidthUnit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIGatesWidthUnit.setForeground(new java.awt.Color(255, 255, 255));
        FIGatesWidthUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Meters", "Centimeters", "Millimeters", "Inches", "Feets" }));
        FIGatesPanel.add(FIGatesWidthUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 50, 100, -1));

        FIGatesHeightUnit.setBackground(new java.awt.Color(102, 102, 102));
        FIGatesHeightUnit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIGatesHeightUnit.setForeground(new java.awt.Color(255, 255, 255));
        FIGatesHeightUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Meters", "Centimeters", "Millimeters", "Inches", "Feets" }));
        FIGatesPanel.add(FIGatesHeightUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 90, 100, -1));

        jLabel134.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel134.setForeground(new java.awt.Color(255, 255, 255));
        jLabel134.setText("Price");
        FIGatesPanel.add(jLabel134, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 60, -1));

        FIGatesPrice.setBackground(new java.awt.Color(102, 102, 102));
        FIGatesPrice.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIGatesPrice.setForeground(new java.awt.Color(255, 255, 255));
        FIGatesPanel.add(FIGatesPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 260, -1));

        moreDetailsPanel.add(FIGatesPanel, "card4");

        FIPurlingPanel.setBackground(new java.awt.Color(0, 102, 102));
        FIPurlingPanel.setOpaque(false);
        FIPurlingPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel358.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel358.setForeground(new java.awt.Color(255, 255, 255));
        jLabel358.setText("Thickness");
        FIPurlingPanel.add(jLabel358, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jLabel359.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel359.setForeground(new java.awt.Color(255, 255, 255));
        jLabel359.setText("Height");
        FIPurlingPanel.add(jLabel359, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel360.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel360.setForeground(new java.awt.Color(255, 255, 255));
        jLabel360.setText("Width");
        FIPurlingPanel.add(jLabel360, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel361.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel361.setForeground(new java.awt.Color(255, 255, 255));
        jLabel361.setText("On Hand Quantity");
        FIPurlingPanel.add(jLabel361, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        FIPurlingOnHandQty.setBackground(new java.awt.Color(102, 102, 102));
        FIPurlingOnHandQty.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIPurlingOnHandQty.setForeground(new java.awt.Color(255, 255, 255));
        FIPurlingPanel.add(FIPurlingOnHandQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 260, -1));

        FIPurlingWidth.setBackground(new java.awt.Color(102, 102, 102));
        FIPurlingWidth.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIPurlingWidth.setForeground(new java.awt.Color(255, 255, 255));
        FIPurlingPanel.add(FIPurlingWidth, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 260, -1));

        FIPurlingHeight.setBackground(new java.awt.Color(102, 102, 102));
        FIPurlingHeight.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIPurlingHeight.setForeground(new java.awt.Color(255, 255, 255));
        FIPurlingPanel.add(FIPurlingHeight, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 260, -1));

        FIPurlingThickness.setBackground(new java.awt.Color(102, 102, 102));
        FIPurlingThickness.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIPurlingThickness.setForeground(new java.awt.Color(255, 255, 255));
        FIPurlingPanel.add(FIPurlingThickness, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 260, -1));

        jLabel363.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel363.setForeground(new java.awt.Color(255, 255, 255));
        jLabel363.setText("Unit");
        FIPurlingPanel.add(jLabel363, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 130, -1, -1));

        FIPurlingLength.setBackground(new java.awt.Color(102, 102, 102));
        FIPurlingLength.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIPurlingLength.setForeground(new java.awt.Color(255, 255, 255));
        FIPurlingPanel.add(FIPurlingLength, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 260, -1));

        jLabel364.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel364.setForeground(new java.awt.Color(255, 255, 255));
        jLabel364.setText("Length");
        FIPurlingPanel.add(jLabel364, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel365.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel365.setForeground(new java.awt.Color(255, 255, 255));
        jLabel365.setText("Unit");
        FIPurlingPanel.add(jLabel365, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, -1, -1));

        jLabel366.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel366.setForeground(new java.awt.Color(255, 255, 255));
        jLabel366.setText("Unit");
        FIPurlingPanel.add(jLabel366, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, -1, -1));

        jLabel367.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel367.setForeground(new java.awt.Color(255, 255, 255));
        jLabel367.setText("Unit");
        FIPurlingPanel.add(jLabel367, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, -1, -1));

        FIPurlingThicknessUnit.setBackground(new java.awt.Color(102, 102, 102));
        FIPurlingThicknessUnit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIPurlingThicknessUnit.setForeground(new java.awt.Color(255, 255, 255));
        FIPurlingThicknessUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Meters", "Centimeters", "Millimeters", "Inches", "Feets" }));
        FIPurlingPanel.add(FIPurlingThicknessUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 130, 100, -1));

        FIPurlingLengthUnit.setBackground(new java.awt.Color(102, 102, 102));
        FIPurlingLengthUnit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIPurlingLengthUnit.setForeground(new java.awt.Color(255, 255, 255));
        FIPurlingLengthUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Meters", "Centimeters", "Millimeters", "Inches", "Feets" }));
        FIPurlingPanel.add(FIPurlingLengthUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, 100, -1));

        FIPurlingWidthUnit.setBackground(new java.awt.Color(102, 102, 102));
        FIPurlingWidthUnit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIPurlingWidthUnit.setForeground(new java.awt.Color(255, 255, 255));
        FIPurlingWidthUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Meters", "Centimeters", "Millimeters", "Inches", "Feets" }));
        FIPurlingPanel.add(FIPurlingWidthUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 50, 100, -1));

        FIPurlingHeightUnit.setBackground(new java.awt.Color(102, 102, 102));
        FIPurlingHeightUnit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIPurlingHeightUnit.setForeground(new java.awt.Color(255, 255, 255));
        FIPurlingHeightUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Meters", "Centimeters", "Millimeters", "Inches", "Feets" }));
        FIPurlingPanel.add(FIPurlingHeightUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 90, 100, -1));

        jLabel135.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel135.setForeground(new java.awt.Color(255, 255, 255));
        jLabel135.setText("Price");
        FIPurlingPanel.add(jLabel135, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 60, -1));

        FIPurlingPrice.setBackground(new java.awt.Color(102, 102, 102));
        FIPurlingPrice.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIPurlingPrice.setForeground(new java.awt.Color(255, 255, 255));
        FIPurlingPanel.add(FIPurlingPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 260, -1));

        moreDetailsPanel.add(FIPurlingPanel, "card5");

        FIGuttersPanel.setBackground(new java.awt.Color(0, 102, 102));
        FIGuttersPanel.setOpaque(false);
        FIGuttersPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel368.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel368.setForeground(new java.awt.Color(255, 255, 255));
        jLabel368.setText("Colour");
        FIGuttersPanel.add(jLabel368, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel369.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel369.setForeground(new java.awt.Color(255, 255, 255));
        jLabel369.setText("Thickness");
        FIGuttersPanel.add(jLabel369, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jLabel370.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel370.setForeground(new java.awt.Color(255, 255, 255));
        jLabel370.setText("Height");
        FIGuttersPanel.add(jLabel370, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel371.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel371.setForeground(new java.awt.Color(255, 255, 255));
        jLabel371.setText("Width");
        FIGuttersPanel.add(jLabel371, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel372.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel372.setForeground(new java.awt.Color(255, 255, 255));
        jLabel372.setText("On Hand Quantity");
        FIGuttersPanel.add(jLabel372, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        FIGutterColour.setBackground(new java.awt.Color(102, 102, 102));
        FIGutterColour.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIGutterColour.setForeground(new java.awt.Color(255, 255, 255));
        FIGuttersPanel.add(FIGutterColour, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 260, -1));

        FIGutterOnHandQty.setBackground(new java.awt.Color(102, 102, 102));
        FIGutterOnHandQty.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIGutterOnHandQty.setForeground(new java.awt.Color(255, 255, 255));
        FIGuttersPanel.add(FIGutterOnHandQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 260, -1));

        FIGutterWidth.setBackground(new java.awt.Color(102, 102, 102));
        FIGutterWidth.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIGutterWidth.setForeground(new java.awt.Color(255, 255, 255));
        FIGuttersPanel.add(FIGutterWidth, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 260, -1));

        FIGutterHeight.setBackground(new java.awt.Color(102, 102, 102));
        FIGutterHeight.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIGutterHeight.setForeground(new java.awt.Color(255, 255, 255));
        FIGuttersPanel.add(FIGutterHeight, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 260, -1));

        FIGutterThickness.setBackground(new java.awt.Color(102, 102, 102));
        FIGutterThickness.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIGutterThickness.setForeground(new java.awt.Color(255, 255, 255));
        FIGuttersPanel.add(FIGutterThickness, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 260, -1));

        jLabel374.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel374.setForeground(new java.awt.Color(255, 255, 255));
        jLabel374.setText("Unit");
        FIGuttersPanel.add(jLabel374, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 130, -1, -1));

        FIGutterLength.setBackground(new java.awt.Color(102, 102, 102));
        FIGutterLength.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIGutterLength.setForeground(new java.awt.Color(255, 255, 255));
        FIGuttersPanel.add(FIGutterLength, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 260, -1));

        jLabel375.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel375.setForeground(new java.awt.Color(255, 255, 255));
        jLabel375.setText("Length");
        FIGuttersPanel.add(jLabel375, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel376.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel376.setForeground(new java.awt.Color(255, 255, 255));
        jLabel376.setText("Unit");
        FIGuttersPanel.add(jLabel376, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, -1, -1));

        jLabel377.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel377.setForeground(new java.awt.Color(255, 255, 255));
        jLabel377.setText("Unit");
        FIGuttersPanel.add(jLabel377, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, -1, -1));

        jLabel378.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel378.setForeground(new java.awt.Color(255, 255, 255));
        jLabel378.setText("Unit");
        FIGuttersPanel.add(jLabel378, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, -1, -1));

        FIGutterThicknessUnit.setBackground(new java.awt.Color(102, 102, 102));
        FIGutterThicknessUnit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIGutterThicknessUnit.setForeground(new java.awt.Color(255, 255, 255));
        FIGutterThicknessUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Meters", "Centimeters", "Millimeters", "Inches", "Feets" }));
        FIGuttersPanel.add(FIGutterThicknessUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 130, 260, -1));

        FIGutterLengthUnit.setBackground(new java.awt.Color(102, 102, 102));
        FIGutterLengthUnit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIGutterLengthUnit.setForeground(new java.awt.Color(255, 255, 255));
        FIGutterLengthUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Meters", "Centimeters", "Millimeters", "Inches", "Feets" }));
        FIGuttersPanel.add(FIGutterLengthUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, 260, -1));

        FIGutterWidthUnit.setBackground(new java.awt.Color(102, 102, 102));
        FIGutterWidthUnit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIGutterWidthUnit.setForeground(new java.awt.Color(255, 255, 255));
        FIGutterWidthUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Meters", "Centimeters", "Millimeters", "Inches", "Feets" }));
        FIGuttersPanel.add(FIGutterWidthUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 50, 260, -1));

        FIGutterHeightUnit.setBackground(new java.awt.Color(102, 102, 102));
        FIGutterHeightUnit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIGutterHeightUnit.setForeground(new java.awt.Color(255, 255, 255));
        FIGutterHeightUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Meters", "Centimeters", "Millimeters", "Inches", "Feets" }));
        FIGuttersPanel.add(FIGutterHeightUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 90, 260, -1));

        jLabel136.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel136.setForeground(new java.awt.Color(255, 255, 255));
        jLabel136.setText("Price");
        FIGuttersPanel.add(jLabel136, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 60, -1));

        FIGutterPrice.setBackground(new java.awt.Color(102, 102, 102));
        FIGutterPrice.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIGutterPrice.setForeground(new java.awt.Color(255, 255, 255));
        FIGuttersPanel.add(FIGutterPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, 260, -1));

        moreDetailsPanel.add(FIGuttersPanel, "card6");

        FIPlainSheetPanel.setBackground(new java.awt.Color(0, 102, 102));
        FIPlainSheetPanel.setOpaque(false);
        FIPlainSheetPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel379.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel379.setForeground(new java.awt.Color(255, 255, 255));
        jLabel379.setText("Colour");
        FIPlainSheetPanel.add(jLabel379, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        jLabel380.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel380.setForeground(new java.awt.Color(255, 255, 255));
        jLabel380.setText("Thickness");
        FIPlainSheetPanel.add(jLabel380, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel381.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel381.setForeground(new java.awt.Color(255, 255, 255));
        jLabel381.setText("Height");
        FIPlainSheetPanel.add(jLabel381, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel382.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel382.setForeground(new java.awt.Color(255, 255, 255));
        jLabel382.setText("Width");
        FIPlainSheetPanel.add(jLabel382, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel383.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel383.setForeground(new java.awt.Color(255, 255, 255));
        jLabel383.setText("On Hand Quantity");
        FIPlainSheetPanel.add(jLabel383, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        FIPlainSheetColour.setBackground(new java.awt.Color(102, 102, 102));
        FIPlainSheetColour.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIPlainSheetColour.setForeground(new java.awt.Color(255, 255, 255));
        FIPlainSheetPanel.add(FIPlainSheetColour, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 260, -1));

        FIPlainSheetOnHandQty.setBackground(new java.awt.Color(102, 102, 102));
        FIPlainSheetOnHandQty.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIPlainSheetOnHandQty.setForeground(new java.awt.Color(255, 255, 255));
        FIPlainSheetPanel.add(FIPlainSheetOnHandQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, 260, -1));

        FIPlainSheetWidth.setBackground(new java.awt.Color(102, 102, 102));
        FIPlainSheetWidth.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIPlainSheetWidth.setForeground(new java.awt.Color(255, 255, 255));
        FIPlainSheetPanel.add(FIPlainSheetWidth, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 260, -1));

        FIPlainSheetHeight.setBackground(new java.awt.Color(102, 102, 102));
        FIPlainSheetHeight.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIPlainSheetHeight.setForeground(new java.awt.Color(255, 255, 255));
        FIPlainSheetPanel.add(FIPlainSheetHeight, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 260, -1));

        FIPlainSheetThickness.setBackground(new java.awt.Color(102, 102, 102));
        FIPlainSheetThickness.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIPlainSheetThickness.setForeground(new java.awt.Color(255, 255, 255));
        FIPlainSheetPanel.add(FIPlainSheetThickness, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 260, -1));

        jLabel385.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel385.setForeground(new java.awt.Color(255, 255, 255));
        jLabel385.setText("Unit");
        FIPlainSheetPanel.add(jLabel385, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 170, -1, -1));

        FIPlainSheetLength.setBackground(new java.awt.Color(102, 102, 102));
        FIPlainSheetLength.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIPlainSheetLength.setForeground(new java.awt.Color(255, 255, 255));
        FIPlainSheetPanel.add(FIPlainSheetLength, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 260, -1));

        jLabel386.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel386.setForeground(new java.awt.Color(255, 255, 255));
        jLabel386.setText("Length");
        FIPlainSheetPanel.add(jLabel386, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel387.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel387.setForeground(new java.awt.Color(255, 255, 255));
        jLabel387.setText("Unit");
        FIPlainSheetPanel.add(jLabel387, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, -1, -1));

        jLabel388.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel388.setForeground(new java.awt.Color(255, 255, 255));
        jLabel388.setText("Unit");
        FIPlainSheetPanel.add(jLabel388, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, -1, -1));

        jLabel389.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel389.setForeground(new java.awt.Color(255, 255, 255));
        jLabel389.setText("Unit");
        FIPlainSheetPanel.add(jLabel389, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, -1, -1));

        FIPlainSheetThicknessUnit.setBackground(new java.awt.Color(102, 102, 102));
        FIPlainSheetThicknessUnit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIPlainSheetThicknessUnit.setForeground(new java.awt.Color(255, 255, 255));
        FIPlainSheetThicknessUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Meters", "Centimeters", "Millimeters", "Inches", "Feets" }));
        FIPlainSheetPanel.add(FIPlainSheetThicknessUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 170, 260, -1));

        FIPlainSheetLengthUnit.setBackground(new java.awt.Color(102, 102, 102));
        FIPlainSheetLengthUnit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIPlainSheetLengthUnit.setForeground(new java.awt.Color(255, 255, 255));
        FIPlainSheetLengthUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Meters", "Centimeters", "Millimeters", "Inches", "Feets" }));
        FIPlainSheetPanel.add(FIPlainSheetLengthUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, 260, -1));

        FIPlainSheetWidthUnit.setBackground(new java.awt.Color(102, 102, 102));
        FIPlainSheetWidthUnit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIPlainSheetWidthUnit.setForeground(new java.awt.Color(255, 255, 255));
        FIPlainSheetWidthUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Meters", "Centimeters", "Millimeters", "Inches", "Feets" }));
        FIPlainSheetPanel.add(FIPlainSheetWidthUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 50, 260, -1));

        FIPlainSheetHeightUnit.setBackground(new java.awt.Color(102, 102, 102));
        FIPlainSheetHeightUnit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIPlainSheetHeightUnit.setForeground(new java.awt.Color(255, 255, 255));
        FIPlainSheetHeightUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Meters", "Centimeters", "Millimeters", "Inches", "Feets" }));
        FIPlainSheetPanel.add(FIPlainSheetHeightUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 90, 260, -1));

        jLabel401.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel401.setForeground(new java.awt.Color(255, 255, 255));
        jLabel401.setText("Squirefeet");
        FIPlainSheetPanel.add(jLabel401, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        FIPlainSheetSqfeet.setBackground(new java.awt.Color(102, 102, 102));
        FIPlainSheetSqfeet.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIPlainSheetSqfeet.setForeground(new java.awt.Color(255, 255, 255));
        FIPlainSheetPanel.add(FIPlainSheetSqfeet, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 260, -1));

        jLabel137.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel137.setForeground(new java.awt.Color(255, 255, 255));
        jLabel137.setText("Price");
        FIPlainSheetPanel.add(jLabel137, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 60, -1));

        FIPlainSheetPrice.setBackground(new java.awt.Color(102, 102, 102));
        FIPlainSheetPrice.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FIPlainSheetPrice.setForeground(new java.awt.Color(255, 255, 255));
        FIPlainSheetPanel.add(FIPlainSheetPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, 260, -1));

        moreDetailsPanel.add(FIPlainSheetPanel, "card7");

        CPFinishedItemsPanel.add(moreDetailsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 830, 290));

        FinishedItemCatCB.setBackground(new java.awt.Color(102, 102, 102));
        FinishedItemCatCB.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FinishedItemCatCB.setForeground(new java.awt.Color(255, 255, 255));
        FinishedItemCatCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Roofing Sheets", "Roller Doors", "Roller Shutter", "Gates", "CPurling", "Gutters", "Plain Sheet" }));
        FinishedItemCatCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FinishedItemCatCBActionPerformed(evt);
            }
        });
        CPFinishedItemsPanel.add(FinishedItemCatCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 260, -1));

        jLabel25.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Please Type Item Name or Item Code Here To Search");
        CPFinishedItemsPanel.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 150, -1, -1));

        jButton20.setBackground(new java.awt.Color(0, 0, 0));
        jButton20.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jButton20.setForeground(new java.awt.Color(255, 255, 255));
        jButton20.setText("Add Item ");
        jButton20.setMaximumSize(new java.awt.Dimension(171, 25));
        jButton20.setMinimumSize(new java.awt.Dimension(171, 25));
        jButton20.setPreferredSize(new java.awt.Dimension(171, 25));
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });
        CPFinishedItemsPanel.add(jButton20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 640, 190, 40));

        jButton21.setBackground(new java.awt.Color(0, 0, 0));
        jButton21.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jButton21.setForeground(new java.awt.Color(255, 255, 255));
        jButton21.setText("Clear Fields");
        jButton21.setMaximumSize(new java.awt.Dimension(171, 25));
        jButton21.setMinimumSize(new java.awt.Dimension(171, 25));
        jButton21.setPreferredSize(new java.awt.Dimension(171, 25));
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });
        CPFinishedItemsPanel.add(jButton21, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 640, 190, 40));

        jButton19.setBackground(new java.awt.Color(0, 0, 0));
        jButton19.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jButton19.setForeground(new java.awt.Color(255, 255, 255));
        jButton19.setText("Update Item");
        jButton19.setMaximumSize(new java.awt.Dimension(171, 25));
        jButton19.setMinimumSize(new java.awt.Dimension(171, 25));
        jButton19.setPreferredSize(new java.awt.Dimension(171, 25));
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        CPFinishedItemsPanel.add(jButton19, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 640, 190, 40));

        jButton22.setBackground(new java.awt.Color(0, 0, 0));
        jButton22.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jButton22.setForeground(new java.awt.Color(255, 255, 255));
        jButton22.setText("Edit Item");
        jButton22.setEnabled(false);
        jButton22.setMaximumSize(new java.awt.Dimension(171, 25));
        jButton22.setMinimumSize(new java.awt.Dimension(171, 25));
        jButton22.setPreferredSize(new java.awt.Dimension(171, 25));
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });
        CPFinishedItemsPanel.add(jButton22, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 640, 190, 40));

        FINameCB.setBackground(new java.awt.Color(102, 102, 102));
        FINameCB.setEditable(true);
        FINameCB.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FINameCB.setForeground(new java.awt.Color(255, 255, 255));
        FINameCB.setToolTipText("Please Type Item Name or Item Code Here To Search");
        FINameCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FINameCBActionPerformed(evt);
            }
        });
        CPFinishedItemsPanel.add(FINameCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 260, -1));

        FINameLbl.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FINameLbl.setForeground(new java.awt.Color(255, 255, 255));
        FINameLbl.setText("Item Name");
        CPFinishedItemsPanel.add(FINameLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, -1));

        jLabel340.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel340.setForeground(new java.awt.Color(255, 255, 255));
        jLabel340.setText("Item Code");
        CPFinishedItemsPanel.add(jLabel340, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));

        FICodeTF.setEditable(false);
        FICodeTF.setBackground(new java.awt.Color(102, 102, 102));
        FICodeTF.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        FICodeTF.setForeground(new java.awt.Color(255, 255, 255));
        CPFinishedItemsPanel.add(FICodeTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 260, -1));

        jLabel26.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Item Catogary");
        CPFinishedItemsPanel.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        jLabel27.setFont(new java.awt.Font("Segoe UI Semilight", 1, 24)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Finished Item");
        CPFinishedItemsPanel.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 160, 40));

        ShowHideDataBtn.setBackground(new java.awt.Color(0, 0, 0));
        ShowHideDataBtn.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        ShowHideDataBtn.setForeground(new java.awt.Color(255, 255, 255));
        ShowHideDataBtn.setText("More Details");
        ShowHideDataBtn.setMaximumSize(new java.awt.Dimension(171, 25));
        ShowHideDataBtn.setMinimumSize(new java.awt.Dimension(171, 25));
        ShowHideDataBtn.setPreferredSize(new java.awt.Dimension(171, 25));
        ShowHideDataBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowHideDataBtnActionPerformed(evt);
            }
        });
        CPFinishedItemsPanel.add(ShowHideDataBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 190, 40));

        ContentsPanel.add(CPFinishedItemsPanel, "card5");

        jPanel1.add(ContentsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, -1, -1));

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
        // TODO add your handling code here:
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

    private void FIRoofingSheetThicknessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FIRoofingSheetThicknessActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FIRoofingSheetThicknessActionPerformed

    private void FIRoofingSheetLengthUnitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FIRoofingSheetLengthUnitMouseClicked

    }//GEN-LAST:event_FIRoofingSheetLengthUnitMouseClicked

    private void FIRoofingSheetLengthUnitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FIRoofingSheetLengthUnitMouseEntered

    }//GEN-LAST:event_FIRoofingSheetLengthUnitMouseEntered

    private void FIRoofingSheetLengthUnitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FIRoofingSheetLengthUnitActionPerformed

    }//GEN-LAST:event_FIRoofingSheetLengthUnitActionPerformed

    private void FIRoofingSheetLengthUnitKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FIRoofingSheetLengthUnitKeyPressed

    }//GEN-LAST:event_FIRoofingSheetLengthUnitKeyPressed

    private void FinishedItemCatCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FinishedItemCatCBActionPerformed
        changeFinishedItemCat(FinishedItemCatCB.getSelectedItem().toString());
    }//GEN-LAST:event_FinishedItemCatCBActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
//        AddFinishedItemCat(FinishedItemCat.getSelectedItem().toString());
//        finishedItemClearTextFields(FinishedItemCat.getSelectedItem().toString());
//        AutoGenFIcode();

        AddData();
        ClearFeilds();
        AutoGenFIcode();
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        finishedItemClearTextFields(FinishedItemCatCB.getSelectedItem().toString());
        finishedItemSetEditableFields(FinishedItemCatCB, "true");
        AutoGenFIcode();
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
//        updateFinishedItemCat(FinishedItemCat.getSelectedItem().toString());
//        finishedItemClearTextFields(FinishedItemCat.getSelectedItem().toString());
//        AutoGenFIcode();

        UpdateData();
        ClearFeilds();
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        finishedItemSetEditableFields(FinishedItemCatCB, "true");
    }//GEN-LAST:event_jButton22ActionPerformed

    private void FINameCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FINameCBActionPerformed
        SearchAndSetMethod();

    }//GEN-LAST:event_FINameCBActionPerformed

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

    private void ShowHideDataBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowHideDataBtnActionPerformed
        ShowHideData();
    }//GEN-LAST:event_ShowHideDataBtnActionPerformed

    private void SPSettingsBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPSettingsBtn1ActionPerformed
        try {
            ExpencesJF newExpencesJF = new ExpencesJF();
            newExpencesJF.setVisible(true);
            this.setVisible(false);
        } catch (Exception e) {
            Logger.getLogger(SalesJF.class.getName()).log(Level.SEVERE, null,e);
        }
    }//GEN-LAST:event_SPSettingsBtn1ActionPerformed

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
            java.util.logging.Logger.getLogger(FinishedItemsJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FinishedItemsJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FinishedItemsJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FinishedItemsJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FinishedItemsJF().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CPFinishedItemsPanel;
    private javax.swing.JPanel ContentsPanel;
    private javax.swing.JLabel Datelbl;
    private javax.swing.JLabel Datelbl1;
    private javax.swing.JTextField FICodeTF;
    private javax.swing.JTextField FIGatesColour;
    private javax.swing.JTextField FIGatesHeight;
    private javax.swing.JComboBox<String> FIGatesHeightUnit;
    private javax.swing.JTextField FIGatesLength;
    private javax.swing.JComboBox<String> FIGatesLengthUnit;
    private javax.swing.JTextField FIGatesOnHandQty;
    private javax.swing.JPanel FIGatesPanel;
    private javax.swing.JTextField FIGatesPrice;
    private javax.swing.JTextField FIGatesWidth;
    private javax.swing.JComboBox<String> FIGatesWidthUnit;
    private javax.swing.JTextField FIGutterColour;
    private javax.swing.JTextField FIGutterHeight;
    private javax.swing.JComboBox<String> FIGutterHeightUnit;
    private javax.swing.JTextField FIGutterLength;
    private javax.swing.JComboBox<String> FIGutterLengthUnit;
    private javax.swing.JTextField FIGutterOnHandQty;
    private javax.swing.JTextField FIGutterPrice;
    private javax.swing.JTextField FIGutterThickness;
    private javax.swing.JComboBox<String> FIGutterThicknessUnit;
    private javax.swing.JTextField FIGutterWidth;
    private javax.swing.JComboBox<String> FIGutterWidthUnit;
    private javax.swing.JPanel FIGuttersPanel;
    private javax.swing.JComboBox<String> FINameCB;
    private javax.swing.JLabel FINameLbl;
    private javax.swing.JTextField FIPlainSheetColour;
    private javax.swing.JTextField FIPlainSheetHeight;
    private javax.swing.JComboBox<String> FIPlainSheetHeightUnit;
    private javax.swing.JTextField FIPlainSheetLength;
    private javax.swing.JComboBox<String> FIPlainSheetLengthUnit;
    private javax.swing.JTextField FIPlainSheetOnHandQty;
    private javax.swing.JPanel FIPlainSheetPanel;
    private javax.swing.JTextField FIPlainSheetPrice;
    private javax.swing.JTextField FIPlainSheetSqfeet;
    private javax.swing.JTextField FIPlainSheetThickness;
    private javax.swing.JComboBox<String> FIPlainSheetThicknessUnit;
    private javax.swing.JTextField FIPlainSheetWidth;
    private javax.swing.JComboBox<String> FIPlainSheetWidthUnit;
    private javax.swing.JTextField FIPurlingHeight;
    private javax.swing.JComboBox<String> FIPurlingHeightUnit;
    private javax.swing.JTextField FIPurlingLength;
    private javax.swing.JComboBox<String> FIPurlingLengthUnit;
    private javax.swing.JTextField FIPurlingOnHandQty;
    private javax.swing.JPanel FIPurlingPanel;
    private javax.swing.JTextField FIPurlingPrice;
    private javax.swing.JTextField FIPurlingThickness;
    private javax.swing.JComboBox<String> FIPurlingThicknessUnit;
    private javax.swing.JTextField FIPurlingWidth;
    private javax.swing.JComboBox<String> FIPurlingWidthUnit;
    private javax.swing.JTextField FIRollerDoorColour;
    private javax.swing.JTextField FIRollerDoorHeight;
    private javax.swing.JComboBox<String> FIRollerDoorHeightUnit;
    private javax.swing.JTextField FIRollerDoorOnHandQty;
    private javax.swing.JTextField FIRollerDoorPrice;
    private javax.swing.JTextField FIRollerDoorSqFeet;
    private javax.swing.JTextField FIRollerDoorThickness;
    private javax.swing.JComboBox<String> FIRollerDoorThicknessUnit;
    private javax.swing.JTextField FIRollerDoorWidth;
    private javax.swing.JComboBox<String> FIRollerDoorWidthUnit;
    private javax.swing.JPanel FIRollerDoorsPanel;
    private javax.swing.JTextField FIRollerShutterColour;
    private javax.swing.JTextField FIRollerShutterHeight;
    private javax.swing.JComboBox<String> FIRollerShutterHeightUnit;
    private javax.swing.JTextField FIRollerShutterLength;
    private javax.swing.JComboBox<String> FIRollerShutterLengthUnit;
    private javax.swing.JTextField FIRollerShutterOnHandQty;
    private javax.swing.JPanel FIRollerShutterPanel;
    private javax.swing.JTextField FIRollerShutterPrice;
    private javax.swing.JTextField FIRollerShutterThickness;
    private javax.swing.JComboBox<String> FIRollerShutterThicknessUnit;
    private javax.swing.JTextField FIRollerShutterWidth;
    private javax.swing.JComboBox<String> FIRollerShutterWidthUnit;
    private javax.swing.JTextField FIRoofingSheetColour;
    private javax.swing.JTextField FIRoofingSheetHeight;
    private javax.swing.JComboBox<String> FIRoofingSheetHeightUnit;
    private javax.swing.JTextField FIRoofingSheetLength;
    private javax.swing.JComboBox<String> FIRoofingSheetLengthUnit;
    private javax.swing.JTextField FIRoofingSheetOnHandQty;
    private javax.swing.JTextField FIRoofingSheetPrice;
    private javax.swing.JTextField FIRoofingSheetThickness;
    private javax.swing.JComboBox<String> FIRoofingSheetThicknessUnit;
    private javax.swing.JTextField FIRoofingSheetWidth;
    private javax.swing.JComboBox<String> FIRoofingSheetWidthUnit;
    private javax.swing.JPanel FIRoofingSheetsPanel;
    private javax.swing.JComboBox<String> FinishedItemCatCB;
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
    private javax.swing.JButton SPSettingsBtn1;
    private javax.swing.JButton SPSupplierBtn;
    private javax.swing.JLabel SPUserNameLbl;
    private javax.swing.JButton SPVehicleBtn;
    private javax.swing.JLabel SeldoLogo;
    private javax.swing.JButton ShowHideDataBtn;
    private javax.swing.JLabel Timelbl;
    private javax.swing.JLabel Timelbl1;
    private javax.swing.JPanel TopPanel;
    private javax.swing.JPanel TopicPanel;
    private javax.swing.JLabel UserNameDisplayLabel;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel329;
    private javax.swing.JLabel jLabel330;
    private javax.swing.JLabel jLabel332;
    private javax.swing.JLabel jLabel333;
    private javax.swing.JLabel jLabel334;
    private javax.swing.JLabel jLabel338;
    private javax.swing.JLabel jLabel340;
    private javax.swing.JLabel jLabel341;
    private javax.swing.JLabel jLabel342;
    private javax.swing.JLabel jLabel344;
    private javax.swing.JLabel jLabel345;
    private javax.swing.JLabel jLabel346;
    private javax.swing.JLabel jLabel348;
    private javax.swing.JLabel jLabel349;
    private javax.swing.JLabel jLabel350;
    private javax.swing.JLabel jLabel353;
    private javax.swing.JLabel jLabel354;
    private javax.swing.JLabel jLabel355;
    private javax.swing.JLabel jLabel356;
    private javax.swing.JLabel jLabel358;
    private javax.swing.JLabel jLabel359;
    private javax.swing.JLabel jLabel360;
    private javax.swing.JLabel jLabel361;
    private javax.swing.JLabel jLabel363;
    private javax.swing.JLabel jLabel364;
    private javax.swing.JLabel jLabel365;
    private javax.swing.JLabel jLabel366;
    private javax.swing.JLabel jLabel367;
    private javax.swing.JLabel jLabel368;
    private javax.swing.JLabel jLabel369;
    private javax.swing.JLabel jLabel370;
    private javax.swing.JLabel jLabel371;
    private javax.swing.JLabel jLabel372;
    private javax.swing.JLabel jLabel374;
    private javax.swing.JLabel jLabel375;
    private javax.swing.JLabel jLabel376;
    private javax.swing.JLabel jLabel377;
    private javax.swing.JLabel jLabel378;
    private javax.swing.JLabel jLabel379;
    private javax.swing.JLabel jLabel380;
    private javax.swing.JLabel jLabel381;
    private javax.swing.JLabel jLabel382;
    private javax.swing.JLabel jLabel383;
    private javax.swing.JLabel jLabel385;
    private javax.swing.JLabel jLabel386;
    private javax.swing.JLabel jLabel387;
    private javax.swing.JLabel jLabel388;
    private javax.swing.JLabel jLabel389;
    private javax.swing.JLabel jLabel390;
    private javax.swing.JLabel jLabel391;
    private javax.swing.JLabel jLabel392;
    private javax.swing.JLabel jLabel393;
    private javax.swing.JLabel jLabel394;
    private javax.swing.JLabel jLabel396;
    private javax.swing.JLabel jLabel397;
    private javax.swing.JLabel jLabel398;
    private javax.swing.JLabel jLabel399;
    private javax.swing.JLabel jLabel400;
    private javax.swing.JLabel jLabel401;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel moreDetailsPanel;
    // End of variables declaration//GEN-END:variables
}
