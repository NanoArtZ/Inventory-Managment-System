
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
import javax.swing.JTextField;
import javax.swing.Timer;

/**
 *
 * @author Nano ArtZ
 */
public final class RawItemsJF extends javax.swing.JFrame {

    /**
     * Creates new form RawItemsJF
     */
    public RawItemsJF() {
        initComponents();
        ButtonBehaviorMethod();
        
        showDate();
        showTime();

        FullScreenMethod();

    }
    
    // Raw Item Methods Start //
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

     //____________Auto gen Raw Item Code_____________//
    void AutoGenRIcode() {
        try {
            Statement s = SeldoDB.GetMyConnection().createStatement();
            ResultSet rs = s.executeQuery("select max(RawItemCode) from rawitem");
            if (rs.next()) {
                String MxRIcodeString = rs.getString("max(RawItemCode)");
                if (MxRIcodeString == null) {
                    RawItemCodeCB.setSelectedItem("RI00000001");
                } else {
                    MxRIcodeString = MxRIcodeString.substring(2, 10);
                    int MxRIcodeInt = Integer.parseInt(MxRIcodeString);
                    MxRIcodeInt++;
                    MxRIcodeString = Integer.toString(MxRIcodeInt);
                    while (MxRIcodeString.length() < 8) {
                        MxRIcodeString = "0" + MxRIcodeString;
                    }
                    MxRIcodeString = "RI" + MxRIcodeString;
                    RawItemCodeCB.setSelectedItem(MxRIcodeString);
                }
            } else {
                RawItemCodeCB.setSelectedItem("RI00000001");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //__________Raw Item Add Button___________//
    
    void AddRawItem(String SelectedCat){
            
        try {
            Statement s=SeldoDB.GetMyConnection().createStatement();
            String path;
            
            switch (SelectedCat) {
                case "Plain Sheet":
                    path="insert into rawitem "
                            + "(RawItemName,RawItemCode,RawItemColour,RawItemCost,RawItemQuantity,RawItemWeight,RawItemWidth,RawItemHeight,RawItemLength,RawItemThickness,ROL,grn_grnNo,WeightUnit,WidthUnit,HeightUnit,LengthUnit,ThicknessUnit) values "
                            + "('"+SelectedCat+"','"+RawItemCodeCB.getSelectedItem().toString()+"','"+RawItemPlainSheetColour.getText()+"','"+Double.parseDouble(RawItemPlainSheetCost.getText())+"','"+RawItemPlainSheetQty.getText()+"',"
                            + "'"+Double.parseDouble(RawItemPlainSheetWeight.getText())+"','"+Double.parseDouble(RawItemPlainSheetWidth.getText())+"','"+Double.parseDouble(RawItemPlainSheetHeight.getText())+"',"
                            + "'"+Double.parseDouble(RawItemPlainSheetLength.getText())+"','"+Double.parseDouble(RawItemPlainSheetThickness.getText())+"','"+RawItemPlainSheetROL.getText()+"','"+RawItemPlainSheetGRN.getText()+"',"
                            + "'"+RawItemPlainSheetWeightUnit.getSelectedItem().toString()+"','"+RawItemPlainSheetWidthUnit.getSelectedItem().toString()+"',"
                            + "'"+RawItemPlainSheetHeightUnit.getSelectedItem().toString()+"','"+RawItemPlainSheetLengthUnit.getSelectedItem().toString()+"',"
                            + "'"+RawItemPlainSheetThicknessUnit.getSelectedItem().toString()+"')";
                    s.executeUpdate(path);
                case "U Bar":
                    path="insert into rawitem "
                            + "(RawItemName,RawItemCode,RawItemCost,RawItemQuantity,RawItemWeight,RawItemWidth,RawItemHeight,RawItemLength,RawItemThickness,ROL,grn_grnNo,WeightUnit,WidthUnit,HeightUnit,LengthUnit,ThicknessUnit) values "
                            + "('"+SelectedCat+"','"+RawItemCodeCB.getSelectedItem().toString()+"','"+Double.parseDouble(RawItemUbarCost.getText())+"','"+RawItemUbarQty.getText()+"',"
                            + "'"+Double.parseDouble(RawItemUbarWeight.getText())+"','"+Double.parseDouble(RawItemUbarWidth.getText())+"','"+Double.parseDouble(RawItemUbarHeight.getText())+"','"+Double.parseDouble(RawItemUbarLength.getText())+"',"
                            + "'"+Double.parseDouble(RawItemUbarThickness.getText())+"','"+RawItemUbarROL.getText()+"','"+RawItemUbarGRN.getText()+"',"
                            + "'"+RawItemUbarWeightUnit.getSelectedItem().toString()+"','"+RawItemUbarWidthUnit.getSelectedItem().toString()+"',"
                            + "'"+RawItemUbarHeightUnit.getSelectedItem().toString()+"','"+RawItemUbarLengthUnit.getSelectedItem().toString()+"',"
                            + "'"+RawItemUbarThicknessUnit.getSelectedItem().toString()+"')";
                    s.executeUpdate(path);
                    break;
                case "J Bar":
                    path="insert into rawitem "
                            + "(RawItemName,RawItemCode,RawItemCost,RawItemQuantity,RawItemWeight,RawItemWidth,RawItemHeight,RawItemLength,RawItemThickness,ROL,grn_grnNo,WeightUnit,WidthUnit,HeightUnit,LengthUnit,ThicknessUnit) values "
                            + "('"+SelectedCat+"','"+RawItemCodeCB.getSelectedItem().toString()+"','"+Double.parseDouble(RawItemJbarCost.getText())+"','"+RawItemJbarQty.getText()+"',"
                            + "'"+Double.parseDouble(RawItemJbarWeight.getText())+"','"+Double.parseDouble(RawItemJbarWidth.getText())+"','"+Double.parseDouble(RawItemJbarHeight.getText())+"','"+Double.parseDouble(RawItemJbarLength.getText())+"',"
                            + "'"+Double.parseDouble(RawItemJbarThickness.getText())+"','"+RawItemJbarROL.getText()+"','"+RawItemJbarGRN.getText()+"',"
                            + "'"+RawItemJbarWeightUnit.getSelectedItem().toString()+"','"+RawItemJbarWidthUnit.getSelectedItem().toString()+"',"
                            + "'"+RawItemJbarHeightUnit.getSelectedItem().toString()+"','"+RawItemJbarLengthUnit.getSelectedItem().toString()+"',"
                            + "'"+RawItemJbarThicknessUnit.getSelectedItem().toString()+"')";
                    s.executeUpdate(path);
                    break;
                case "U Channel Beading":
                    path="insert into rawitem (RawItemName,RawItemCode,RawItemCost,RawItemQuantity,RawItemLength,ROL,grn_grnNo,LengthUnit) values "
                            + "('"+SelectedCat+"','"+RawItemCodeCB.getSelectedItem().toString()+"','"+Double.parseDouble(RawItemUCBCost.getText())+"','"+RawItemUCBQty.getText()+"',"
                            + "'"+Double.parseDouble(RawItemUCBLength.getText())+"','"+RawItemUCBROL.getText()+"','"+RawItemUCBGRN.getText()+"','"+RawItemJbarLengthUnit.getSelectedItem().toString()+"')";
                    s.executeUpdate(path);
                    break;
                case "Bottom Beading":
                    path="insert into rawitem (RawItemName,RawItemCode,RawItemCost,RawItemQuantity,RawItemLength,ROL,grn_grnNo,LengthUnit) values "
                            + "('"+SelectedCat+"','"+RawItemCodeCB.getSelectedItem().toString()+"','"+Double.parseDouble(RawItemBottomBleedingCost.getText())+"','"+RawItemBottomBleedingQty.getText()+"',"
                            + "'"+Double.parseDouble(RawItemBottomBleedingLength.getText())+"','"+RawItemBottomBleedingROL.getText()+"','"+RawItemBottomBleedingGRN.getText()+"','"+RawItemJbarLengthUnit.getSelectedItem().toString()+"')";
                    s.executeUpdate(path);
                    break;
                case "Side Beading":
                    path="insert into rawitem (RawItemName,RawItemCode,RawItemCost,RawItemQuantity,RawItemLength,ROL,grn_grnNo,LengthUnit) values "
                            + "('"+SelectedCat+"','"+RawItemCodeCB.getSelectedItem().toString()+"','"+Double.parseDouble(RawItemSideBleedingCost.getText())+"','"+RawItemSideBleedingQty.getText()+"',"
                            + "'"+Double.parseDouble(RawItemSideBleedingLength.getText())+"','"+RawItemSideBleedingROL.getText()+"','"+RawItemSideBleedingGRN.getText()+"','"+RawItemJbarLengthUnit.getSelectedItem().toString()+"')";
                    s.executeUpdate(path);
                    break;
                case "Aluminium Bottom Bar":
                    path="insert into rawitem (RawItemName,RawItemCode,RawItemCost,RawItemQuantity,RawItemWidth,RawItemHeight,RawItemLength,RawItemThickness,ROL,grn_grnNo,WidthUnit,HeightUnit,LengthUnit,ThicknessUnit) values "
                            + "('"+SelectedCat+"','"+RawItemCodeCB.getSelectedItem().toString()+"','"+Double.parseDouble(RawItemABBarCost.getText())+"','"+RawItemABBarQty.getText()+"','"+Double.parseDouble(RawItemABBarWidth.getText())+"',"
                            + "'"+Double.parseDouble(RawItemABBarHeight.getText())+"','"+Double.parseDouble(RawItemABBarLength.getText())+"','"+Double.parseDouble(RawItemABBarThickness.getText())+"','"+RawItemABBarROL.getText()+"',"
                            + "'"+RawItemABBarGRN.getText()+"','"+RawItemABBarWidthUnit.getSelectedItem().toString()+"','"+RawItemABBarHeightUnit.getSelectedItem().toString()+"','"+RawItemABBarLengthUnit.getSelectedItem().toString()+"',"
                            + "'"+RawItemABBarThicknessUnit.getSelectedItem().toString()+"')";
                    s.executeUpdate(path);
                    break;
                case "Pulley":
                    path="insert into rawitem (RawItemName,RawItemCode,RawItemCost,RawItemQuantity,RawItemWidth,RawItemHeight,RawItemLength,RawItemThickness,ROL,grn_grnNo,WidthUnit,HeightUnit,LengthUnit,ThicknessUnit) values "
                            + "('"+SelectedCat+"','"+RawItemCodeCB.getSelectedItem().toString()+"','"+Double.parseDouble(RawItemPulleyCost.getText())+"','"+RawItemPulleyQty.getText()+"','"+Double.parseDouble(RawItemPulleyWidth.getText())+"',"
                            + "'"+Double.parseDouble(RawItemPulleyHeight.getText())+"','"+Double.parseDouble(RawItemPulleyLength.getText())+"','"+Double.parseDouble(RawItemPulleyThickness.getText())+"','"+RawItemPulleyROL.getText()+"',"
                            + "'"+RawItemPulleyGRN.getText()+"','"+RawItemPulleyWidthUnit.getSelectedItem().toString()+"','"+RawItemPulleyHeightUnit.getSelectedItem().toString()+"','"+RawItemPulleyLengthUnit.getSelectedItem().toString()+"',"
                            + "'"+RawItemPulleyThicknessUnit.getSelectedItem().toString()+"')";
                    s.executeUpdate(path);
                    break;
                case "Spring":
                    path="insert into rawitem (RawItemName,RawItemCode,RawItemCost,RawItemQuantity,RawItemLength,RawItemThickness,ROL,grn_grnNo,LengthUnit) values "
                            + "('"+SelectedCat+"','"+RawItemCodeCB.getSelectedItem().toString()+"','"+Double.parseDouble(RawItemSpirngCost.getText())+"','"+RawItemSpirngQty.getText()+"',"
                            + "'"+Double.parseDouble(RawItemSpirngLength.getText())+"','"+Double.parseDouble(RawItemSpirngThickenss.getText())+"','"+RawItemSpirngROL.getText()+"','"+RawItemSpirngGRN.getText()+"',"
                            + "'"+RawItemSpirngLengthUnit.getSelectedItem().toString()+"')";
                    s.executeUpdate(path);
                    break;
                case "Down Lock":
                    path="insert into rawitem "
                            + "(RawItemName,RawItemCode,RawItemCost,RawItemQuantity,RawItemWidth,RawItemHeight,RawItemLength,ROL,grn_grnNo,LengthUnit) values "
                            + "('"+SelectedCat+"','"+RawItemCodeCB.getSelectedItem().toString()+"','"+Double.parseDouble(RawItemDownLockCost.getText())+"','"+RawItemDownLockQty.getText()+"',"
                            + "'"+Double.parseDouble(RawItemDownLockWidth.getText())+"','"+Double.parseDouble(RawItemDownLockHeight.getText())+"','"+Double.parseDouble(RawItemDownLockLength.getText())+"',"
                            + "'"+RawItemDownLockROL.getText()+"','"+RawItemDownLockGRN.getText()+"','"+RawItemDownLockLengthUnit.getSelectedItem().toString()+"')";
                    s.executeUpdate(path);
                    break;
                case "Side Lock":
                    path="insert into rawitem "
                            + "(RawItemName,RawItemCode,RawItemCost,RawItemQuantity,RawItemWidth,RawItemHeight,RawItemLength,ROL,grn_grnNo,LengthUnit) values "
                            + "('"+SelectedCat+"','"+RawItemCodeCB.getSelectedItem().toString()+"','"+Double.parseDouble(RawItemSideLockCost.getText())+"','"+RawItemSideLockQty.getText()+"',"
                            + "'"+Double.parseDouble(RawItemSideLockWidth.getText())+"','"+Double.parseDouble(RawItemSideLockHeight.getText())+"','"+Double.parseDouble(RawItemSideLockLength.getText())+"',"
                            + "'"+RawItemSideLockROL.getText()+"','"+RawItemSideLockGRN.getText()+"','"+RawItemSideLockLengthUnit.getSelectedItem().toString()+"')";
                    s.executeUpdate(path);
                    break;
                case "Center Lock":
                    path="insert into rawitem "
                            + "(RawItemName,RawItemCode,RawItemCost,RawItemQuantity,RawItemWidth,RawItemHeight,RawItemLength,ROL,grn_grnNo,LengthUnit) values "
                            + "('"+SelectedCat+"','"+RawItemCodeCB.getSelectedItem().toString()+"','"+Double.parseDouble(RawItemCenterLockCost.getText())+"','"+RawItemCenterLockQty.getText()+"',"
                            + "'"+Double.parseDouble(RawItemCenterLockWidth.getText())+"','"+Double.parseDouble(RawItemCenterLockHeight.getText())+"','"+Double.parseDouble(RawItemCenterLockLength.getText())+"',"
                            + "'"+RawItemCenterLockROL.getText()+"','"+RawItemCenterLockGRN.getText()+"','"+RawItemCenterLockLengthUnit.getSelectedItem().toString()+"')";
                    s.executeUpdate(path);
                    break;
                case "C Perling Coils":
                    path="insert into rawitem "
                            + "(RawItemName,RawItemCode,RawItemCost,RawItemQuantity,RawItemWeight,RawItemWidth,RawItemHeight,RawItemLength,RawItemThickness,ROL,grn_grnNo,LengthUnit) values "
                            + "('"+SelectedCat+"','"+RawItemCodeCB.getSelectedItem().toString()+"','"+Double.parseDouble(RawItemCPerlingCost.getText())+"','"+RawItemCPerlingQty.getText()+"',"
                            + "'"+Double.parseDouble(RawItemCPerlingWeight.getText())+"','"+Double.parseDouble(RawItemCPerlingWidth.getText())+"','"+Double.parseDouble(RawItemCPerlingHeight.getText())+"',"
                            + "'"+Double.parseDouble(RawItemCPerlingLength.getText())+"','"+Double.parseDouble(RawItemCPerlingThickness.getText())+"','"+RawItemCPerlingROL.getText()+"',"
                            + "'"+RawItemCPerlingGRN.getText()+"','"+RawItemCPerlingLengthUnit.getSelectedItem().toString()+"')";
                    s.executeUpdate(path);
                    break;
                case "Roller Shutter Belt":
                    path="insert into rawitem (RawItemName,RawItemCode,RawItemCost,RawItemQuantity,RawItemLength,ROL,grn_grnNo,LengthUnit) values "
                            + "('"+SelectedCat+"','"+RawItemCodeCB.getSelectedItem().toString()+"','"+Double.parseDouble(RawItemRSBeltCost.getText())+"','"+RawItemRSBeltQty.getText()+"',"
                            + "'"+Double.parseDouble(RawItemRSBeltLength.getText())+"','"+RawItemRSBeltROL.getText()+"','"+RawItemRSBeltGRN.getText()+"','"+RawItemRSBeltLengthUnit.getSelectedItem().toString()+"')";
                    s.executeUpdate(path);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //__________Raw Item Update Button___________//
    
    void UpdateRawItem(String SelectedCat){
            
        try {
            Statement s=SeldoDB.GetMyConnection().createStatement();
            String path;
            
            switch (SelectedCat) {
                case "Plain Sheet":
                    path="update rawitem set "
                            + "RawItemName='"+SelectedCat+"',"
                            + "RawItemColour='"+RawItemPlainSheetColour.getText()+"',"
                            + "RawItemCost='"+Double.parseDouble(RawItemPlainSheetCost.getText())+"',"
                            + "RawItemQuantity='"+RawItemPlainSheetQty.getText()+"',"
                            + "RawItemWeight='"+Double.parseDouble(RawItemPlainSheetWeight.getText())+"',"
                            + "RawItemWidth='"+Double.parseDouble(RawItemPlainSheetWidth.getText())+"',"
                            + "RawItemHeight='"+Double.parseDouble(RawItemPlainSheetHeight.getText())+"',"
                            + "RawItemLength='"+Double.parseDouble(RawItemPlainSheetLength.getText())+"',"
                            + "RawItemThickness='"+Double.parseDouble(RawItemPlainSheetThickness.getText())+"',"
                            + "ROL='"+RawItemPlainSheetROL.getText()+"',"
                            + "grn_grnNo='"+RawItemPlainSheetGRN.getText()+"',"
                            + "WeightUnit='"+RawItemPlainSheetWeightUnit.getSelectedItem().toString()+"',"
                            + "WidthUnit='"+RawItemPlainSheetWidthUnit.getSelectedItem().toString()+"',"
                            + "HeightUnit='"+RawItemPlainSheetHeightUnit.getSelectedItem().toString()+"',"
                            + "LengthUnit='"+RawItemPlainSheetLengthUnit.getSelectedItem().toString()+"',"
                            + "ThicknessUnit='"+RawItemPlainSheetThicknessUnit.getSelectedItem().toString()+"' "
                            + "where RawItemCode='"+RawItemCodeCB.getSelectedItem().toString()+"'";
                    s.executeUpdate(path);
                    break;
                case "U Bar":
                    path="update rawitem set "
                            + "RawItemName='"+SelectedCat+"',"
                            + "RawItemCost='"+Double.parseDouble(RawItemUbarCost.getText())+"',"
                            + "RawItemQuantity='"+RawItemUbarQty.getText()+"',"
                            + "RawItemWeight='"+Double.parseDouble(RawItemUbarWeight.getText())+"',"
                            + "RawItemWidth='"+Double.parseDouble(RawItemUbarWidth.getText())+"',"
                            + "RawItemHeight='"+Double.parseDouble(RawItemUbarHeight.getText())+"',"
                            + "RawItemLength='"+Double.parseDouble(RawItemUbarLength.getText())+"',"
                            + "RawItemThickness='"+Double.parseDouble(RawItemUbarThickness.getText())+"',"
                            + "ROL='"+RawItemUbarROL.getText()+"',"
                            + "grn_grnNo='"+RawItemUbarGRN.getText()+"'"
                            + "WeightUnit='"+RawItemUbarWeightUnit.getSelectedItem().toString()+"',"
                            + "WidthUnit='"+RawItemUbarWidthUnit.getSelectedItem().toString()+"',"
                            + "HeightUnit='"+RawItemUbarHeightUnit.getSelectedItem().toString()+"',"
                            + "LengthUnit='"+RawItemUbarLengthUnit.getSelectedItem().toString()+"',"
                            + "ThicknessUnit='"+RawItemUbarThicknessUnit.getSelectedItem().toString()+"' "
                            + "where RawItemCode='"+RawItemCodeCB.getSelectedItem().toString()+"'";
                    s.executeUpdate(path);
                    break;
                case "J Bar":
                    path="update rawitem set "
                            + "RawItemName='"+SelectedCat+"',"
                            + "RawItemCost='"+Double.parseDouble(RawItemJbarCost.getText())+"',"
                            + "RawItemWidth='"+RawItemJbarQty.getText()+"',"
                            + "RawItemQuantity='"+Double.parseDouble(RawItemJbarWeight.getText())+"',"
                            + "RawItemHeight='"+Double.parseDouble(RawItemJbarWidth.getText())+"',"
                            + "RawItemWeight='"+Double.parseDouble(RawItemJbarHeight.getText())+"',"
                            + "RawItemLength='"+Double.parseDouble(RawItemJbarLength.getText())+"',"
                            + "RawItemThickness='"+Double.parseDouble(RawItemJbarThickness.getText())+"',"
                            + "ROL='"+RawItemJbarROL.getText()+"',"
                            + "grn_grnNo='"+RawItemJbarGRN.getText()+"'"
                            + "WeightUnit='"+RawItemJbarWeightUnit.getSelectedItem().toString()+"',"
                            + "WidthUnit='"+RawItemJbarWidthUnit.getSelectedItem().toString()+"',"
                            + "HeightUnit='"+RawItemJbarHeightUnit.getSelectedItem().toString()+"',"
                            + "LengthUnit='"+RawItemJbarLengthUnit.getSelectedItem().toString()+"',"
                            + "ThicknessUnit='"+RawItemJbarThicknessUnit.getSelectedItem().toString()+"' "
                            + "where RawItemCode='"+RawItemCodeCB.getSelectedItem().toString()+"'";
                    s.executeUpdate(path);
                    break;
                case "U Channel Beading":
                    path="update rawitem set "
                            + "RawItemName='"+SelectedCat+"',"
                            + "RawItemCost='"+Double.parseDouble(RawItemUCBCost.getText())+"',"
                            + "RawItemQuantity='"+RawItemUCBQty.getText()+"',"
                            + "RawItemLength='"+Double.parseDouble(RawItemUCBLength.getText())+"',"
                            + "ROL='"+RawItemUCBROL.getText()+"',"
                            + "grn_grnNo='"+RawItemUCBGRN.getText()+"',"
                            + "LengthUnit='"+RawItemUCBLengthUnit.getSelectedItem().toString()+"' "
                            + "where RawItemCode='"+RawItemCodeCB.getSelectedItem().toString()+"'";
                    s.executeUpdate(path);
                    break;
                case "Bottom Beading":
                    path="update rawitem set "
                            + "RawItemName='"+SelectedCat+"',"
                            + "RawItemCost='"+Double.parseDouble(RawItemBottomBleedingCost.getText())+"',"
                            + "RawItemQuantity='"+RawItemBottomBleedingQty.getText()+"',"
                            + "RawItemLength='"+Double.parseDouble(RawItemBottomBleedingLength.getText())+"',"
                            + "ROL='"+RawItemBottomBleedingROL.getText()+"',"
                            + "grn_grnNo='"+RawItemBottomBleedingGRN.getText()+"',"
                            + "LengthUnit='"+RawItemBottomBleedingLengthUnit.getSelectedItem().toString()+"' "
                            + "where RawItemCode='"+RawItemCodeCB.getSelectedItem().toString()+"'";
                    s.executeUpdate(path);
                    break;
                case "Side Beading":
                    path="update rawitem set "
                            + "RawItemName='"+SelectedCat+"',"
                            + "RawItemCost='"+Double.parseDouble(RawItemSideBleedingCost.getText())+"',"
                            + "RawItemQuantity='"+RawItemSideBleedingQty.getText()+"',"
                            + "RawItemLength='"+Double.parseDouble(RawItemSideBleedingLength.getText())+"',"
                            + "ROL='"+RawItemSideBleedingROL.getText()+"',"
                            + "grn_grnNo='"+RawItemSideBleedingGRN.getText()+"',"
                            + "LengthUnit='"+RawItemSideBleedingLengthUnit.getSelectedItem().toString()+"' "
                            + "where RawItemCode='"+RawItemCodeCB.getSelectedItem().toString()+"'";
                    s.executeUpdate(path);
                    break;
                case "Aluminium Bottom Bar":
                    path="update rawitem set "
                            + "RawItemName='"+SelectedCat+"',"
                            + "RawItemCost='"+Double.parseDouble(RawItemABBarCost.getText()+"',"
                            + "RawItemQuantity='"+RawItemABBarQty.getText())+"',"
                            + "RawItemWidth='"+Double.parseDouble(RawItemABBarWidth.getText())+"',"
                            + "RawItemHeight='"+Double.parseDouble(RawItemABBarHeight.getText())+"',"
                            + "RawItemLength='"+Double.parseDouble(RawItemABBarLength.getText())+"',"
                            + "RawItemThickness='"+Double.parseDouble(RawItemABBarThickness.getText())+"',"
                            + "ROL='"+RawItemABBarROL.getText()+"',"
                            + "grn_grnNo='"+RawItemABBarGRN.getText()+"'"
                            + "WidthUnit='"+RawItemABBarWidthUnit.getSelectedItem().toString()+"',"
                            + "HeightUnit='"+RawItemABBarHeightUnit.getSelectedItem().toString()+"',"
                            + "LengthUnit='"+RawItemABBarLengthUnit.getSelectedItem().toString()+"',"
                            + "ThicknessUnit='"+RawItemABBarThicknessUnit.getSelectedItem().toString()+"'"
                            + "where RawItemCode='"+RawItemCodeCB.getSelectedItem().toString()+"'";
                    s.executeUpdate(path);
                    break;
                case "Pulley":
                    path="update rawitem set "
                            + "RawItemName='"+SelectedCat+"',"
                            + "RawItemCost='"+Double.parseDouble(RawItemPulleyCost.getText())+"',"
                            + "RawItemQuantity='"+RawItemPulleyQty.getText()+"',"
                            + "RawItemWidth='"+Double.parseDouble(RawItemPulleyWidth.getText())+"',"
                            + "RawItemHeight='"+Double.parseDouble(RawItemPulleyHeight.getText())+"',"
                            + "RawItemLength='"+Double.parseDouble(RawItemPulleyLength.getText())+"',"
                            + "RawItemThickness='"+Double.parseDouble(RawItemPulleyThickness.getText())+"',"
                            + "ROL='"+RawItemPulleyROL.getText()+"',"
                            + "grn_grnNo='"+RawItemPulleyGRN.getText()+"'"
                            + "WidthUnit='"+RawItemPulleyWidthUnit.getSelectedItem().toString()+"',"
                            + "HeightUnit='"+RawItemPulleyHeightUnit.getSelectedItem().toString()+"',"
                            + "LengthUnit='"+RawItemPulleyLengthUnit.getSelectedItem().toString()+"',"
                            + "ThicknessUnit='"+RawItemPulleyThicknessUnit.getSelectedItem().toString()+"'"
                            + "where RawItemCode='"+RawItemCodeCB.getSelectedItem().toString()+"'";
                    s.executeUpdate(path);
                    break;
                case "Spring":
                    path="update rawitem set "
                            + "RawItemName='"+SelectedCat+"',"
                            + "RawItemCost='"+Double.parseDouble(RawItemSpirngCost.getText())+"',"
                            + "RawItemQuantity='"+RawItemSpirngQty.getText()+"',"
                            + "RawItemLength='"+Double.parseDouble(RawItemSpirngLength.getText())+"',"
                            + "RawItemThickness='"+Double.parseDouble(RawItemSpirngThickenss.getText())+"',"
                            + "ROL='"+RawItemSpirngROL.getText()+"',"
                            + "grn_grnNo='"+RawItemSpirngGRN.getText()+"',"
                            + "LengthUnit='"+RawItemPulleyLengthUnit.getSelectedItem().toString()+"' "
                            + "where RawItemCode='"+RawItemCodeCB.getSelectedItem().toString()+"'";
                    s.executeUpdate(path);
                    break;
                case "Down Lock":
                    path="update rawitem set "
                            + "RawItemName='"+SelectedCat+"',"
                            + "RawItemCost='"+Double.parseDouble(RawItemDownLockCost.getText())+"',"
                            + "RawItemQuantity='"+RawItemDownLockQty.getText()+"',"
                            + "RawItemWidth='"+Double.parseDouble(RawItemDownLockWidth.getText())+"',"
                            + "RawItemHeight='"+Double.parseDouble(RawItemDownLockHeight.getText())+"',"
                            + "RawItemLength='"+Double.parseDouble(RawItemDownLockLength.getText())+"',"
                            + "ROL='"+RawItemDownLockROL.getText()+"',"
                            + "grn_grnNo='"+RawItemDownLockGRN.getText()+"',"
                            + "LengthUnit='"+RawItemDownLockLengthUnit.getSelectedItem().toString()+"',"
                            + "where RawItemCode='"+RawItemCodeCB.getSelectedItem().toString()+"'";
                    s.executeUpdate(path);
                    break;
                case "Side Lock":
                    path="update rawitem set "
                            + "RawItemName='"+SelectedCat+"',"
                            + "RawItemCost='"+Double.parseDouble(RawItemSideLockCost.getText())+"',"
                            + "RawItemQuantity='"+RawItemSideLockQty.getText()+"',"
                            + "RawItemWidth='"+Double.parseDouble(RawItemSideLockWidth.getText())+"',"
                            + "RawItemHeight='"+Double.parseDouble(RawItemSideLockHeight.getText())+"',"
                            + "RawItemLength='"+Double.parseDouble(RawItemSideLockLength.getText())+"',"
                            + "ROL='"+RawItemSideLockROL.getText()+"',"
                            + "grn_grnNo='"+RawItemSideLockGRN.getText()+"',"
                            + "LengthUnit='"+RawItemSideLockLengthUnit.getSelectedItem().toString()+"' "
                            + "where RawItemCode='"+RawItemCodeCB.getSelectedItem().toString()+"'";
                    s.executeUpdate(path);
                    break;
                case "Center Lock":
                    path="update rawitem set "
                            + "RawItemName='"+SelectedCat+"',"
                            + "RawItemCost='"+Double.parseDouble(RawItemCenterLockCost.getText())+"',"
                            + "RawItemQuantity='"+RawItemCenterLockQty.getText()+"',"
                            + "RawItemWidth='"+Double.parseDouble(RawItemCenterLockWidth.getText())+"',"
                            + "RawItemHeight='"+Double.parseDouble(RawItemCenterLockHeight.getText())+"',"
                            + "RawItemLength='"+Double.parseDouble(RawItemCenterLockLength.getText())+"',"
                            + "ROL='"+RawItemCenterLockROL.getText()+"',"
                            + "grn_grnNo='"+RawItemCenterLockGRN.getText()+"',"
                            + "LengthUnit='"+RawItemCenterLockLengthUnit.getSelectedItem().toString()+"' "
                            + "where RawItemCode='"+RawItemCodeCB.getSelectedItem().toString()+"'";
                    s.executeUpdate(path);
                    break;
                case "C Perling Coils":
                    path="update rawitem set "
                            + "RawItemName='"+SelectedCat+"',"
                            + "RawItemCost='"+Double.parseDouble(RawItemCPerlingCost.getText())+"',"
                            + "RawItemQuantity='"+RawItemCPerlingQty.getText()+"',"
                            + "RawItemWeight='"+Double.parseDouble(RawItemCPerlingWeight.getText())+"',"
                            + "RawItemWidth='"+Double.parseDouble(RawItemCPerlingWidth.getText())+"',"
                            + "RawItemHeight='"+Double.parseDouble(RawItemCPerlingHeight.getText())+"',"
                            + "RawItemLength='"+Double.parseDouble(RawItemCPerlingLength.getText())+"',"
                            + "RawItemThickness='"+Double.parseDouble(RawItemCPerlingThickness.getText())+"',"
                            + "ROL='"+RawItemCPerlingROL.getText()+"',"
                            + "grn_grnNo'"+RawItemCPerlingGRN.getText()+"',"
                            + "LengthUnit='"+RawItemCPerlingLengthUnit.getSelectedItem().toString()+"' "
                            + "where RawItemCode='"+RawItemCodeCB.getSelectedItem().toString()+"'";
                    s.executeUpdate(path);
                    break;
                case "Roller Shutter Belt":
                    path="update rawitem set "
                            + "RawItemName='"+SelectedCat+"',"
                            + "RawItemCost='"+Double.parseDouble(RawItemRSBeltCost.getText())+"',"
                            + "RawItemQuantity='"+RawItemRSBeltQty.getText()+"',"
                            + "RawItemLength='"+Double.parseDouble(RawItemRSBeltLength.getText())+"',"
                            + "ROL='"+RawItemRSBeltROL.getText()+"',"
                            + "grn_grnNo='"+RawItemRSBeltGRN.getText()+"',"
                            + "LengthUnit='"+RawItemRSBeltLengthUnit.getSelectedItem().toString()+"'"
                            + "where RawItemCode='"+RawItemCodeCB.getSelectedItem().toString()+"'";
                    s.executeUpdate(path);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //_______Raw Item Clear Text Fields_______//
    
    void rawItemClearTextFields(String getCat){
        switch (getCat) {
            case "Plain Sheet":
                //RawItemCodeCB.setSelectedItem("");
                RawItemPlainSheetColour.setText("");
                RawItemPlainSheetCost.setText("");
                RawItemPlainSheetQty.setText("");
                RawItemPlainSheetWeight.setText("");
                RawItemPlainSheetWidth.setText("");
                RawItemPlainSheetHeight.setText("");
                RawItemPlainSheetLength.setText("");
                RawItemPlainSheetThickness.setText("");
                RawItemPlainSheetROL.setText("");
                RawItemPlainSheetGRN.setText("");
                break;
            case "U Bar":
                //RawItemCodeCB.setSelectedItem("");
                RawItemUbarCost.setText("");
                RawItemUbarQty.setText("");
                RawItemUbarWeight.setText("");
                RawItemUbarWidth.setText("");
                RawItemUbarHeight.setText("");
                RawItemUbarLength.setText("");
                RawItemUbarThickness.setText("");
                RawItemUbarROL.setText("");
                RawItemUbarGRN.setText("");
                break;
            case "J Bar":
                //RawItemCodeCB.setSelectedItem("");
                RawItemJbarCost.setText("");
                RawItemJbarQty.setText("");
                RawItemJbarWeight.setText("");
                RawItemJbarWidth.setText("");
                RawItemJbarHeight.setText("");
                RawItemJbarLength.setText("");
                RawItemJbarThickness.setText("");
                RawItemJbarROL.setText("");
                RawItemJbarGRN.setText("");
                break;
            case "U Channel Beading":
                //RawItemCodeCB.setSelectedItem("");
                RawItemUCBCost.setText("");
                RawItemUCBQty.setText("");
                RawItemUCBLength.setText("");
                RawItemUCBROL.setText("");
                RawItemUCBGRN.setText("");
                break;
            case "Bottom Beading":
                //RawItemCodeCB.setSelectedItem("");
                RawItemBottomBleedingCost.setText("");
                RawItemBottomBleedingQty.setText("");
                RawItemBottomBleedingLength.setText("");
                RawItemBottomBleedingROL.setText("");
                RawItemBottomBleedingGRN.setText("");
                break;
            case "Side Beading":
                //RawItemCodeCB.setSelectedItem("");
                RawItemSideBleedingCost.setText("");
                RawItemSideBleedingQty.setText("");
                RawItemSideBleedingLength.setText("");
                RawItemSideBleedingROL.setText("");
                RawItemSideBleedingGRN.setText("");
                break;
            case "Aluminium Bottom Bar":
                //RawItemCodeCB.setSelectedItem("");
                RawItemABBarCost.setText("");
                RawItemABBarQty.setText("");
                RawItemABBarWidth.setText("");
                RawItemABBarHeight.setText("");
                RawItemABBarLength.setText("");
                RawItemABBarThickness.setText("");
                RawItemABBarROL.setText("");
                RawItemABBarGRN.setText("");
                break;
            case "Pulley":
                //RawItemCodeCB.setSelectedItem("");
                RawItemPulleyCost.setText("");
                RawItemPulleyQty.setText("");
                RawItemPulleyWidth.setText("");
                RawItemPulleyHeight.setText("");
                RawItemPulleyLength.setText("");
                RawItemPulleyThickness.setText("");
                RawItemPulleyROL.setText("");
                RawItemPulleyGRN.setText("");
                break;
            case "Spring":
                //RawItemCodeCB.setSelectedItem("");
                RawItemSpirngCost.setText("");
                RawItemSpirngQty.setText("");
                RawItemSpirngLength.setText("");
                RawItemSpirngThickenss.setText("");
                RawItemSpirngROL.setText("");
                RawItemSpirngGRN.setText("");
                break;
            case "Down Lock":
                //RawItemCodeCB.setSelectedItem("");
                RawItemDownLockCost.setText("");
                RawItemDownLockQty.setText("");
                RawItemDownLockWidth.setText("");
                RawItemDownLockHeight.setText("");
                RawItemDownLockLength.setText("");
                RawItemDownLockROL.setText("");
                RawItemDownLockGRN.setText("");
                break;
            case "Side Lock":
                //RawItemCodeCB.setSelectedItem("");
                RawItemSideLockCost.setText("");
                RawItemSideLockQty.setText("");
                RawItemSideLockWidth.setText("");
                RawItemSideLockHeight.setText("");
                RawItemSideLockLength.setText("");
                RawItemSideLockROL.setText("");
                RawItemSideLockGRN.setText("");
                break;
            case "Center Lock":
                //RawItemCodeCB.setSelectedItem("");
                RawItemCenterLockCost.setText("");
                RawItemCenterLockQty.setText("");
                RawItemCenterLockWidth.setText("");
                RawItemCenterLockHeight.setText("");
                RawItemCenterLockLength.setText("");
                RawItemCenterLockROL.setText("");
                RawItemCenterLockGRN.setText("");
                break;
            case "C Perling Coils":
                //RawItemCodeCB.setSelectedItem("");
                RawItemCPerlingCost.setText("");
                RawItemCPerlingQty.setText("");
                RawItemCPerlingWeight.setText("");
                RawItemCPerlingWidth.setText("");
                RawItemCPerlingHeight.setText("");
                RawItemCPerlingLength.setText("");
                RawItemCPerlingThickness.setText("");
                RawItemCPerlingROL.setText("");
                RawItemCPerlingGRN.setText("");
                break;
            case "Roller Shutter Belt":
                //RawItemCodeCB.setSelectedItem("");
                RawItemRSBeltCost.setText("");
                RawItemRSBeltQty.setText("");
                RawItemRSBeltLength.setText("");
                RawItemRSBeltROL.setText("");
                RawItemRSBeltGRN.setText("");
                break;
            default:
                break;
        }
    }
    
    //___________Set RI Editable true/false____________//
    
    void rawItemSetEditableFields(JComboBox getItem,String fuck){
        String getCat=getItem.getSelectedItem().toString();
        Boolean x=Boolean.valueOf(fuck);
        switch (getCat) {
            case "Plain Sheet":
                RawItemPlainSheetColour.setEditable(x);
                RawItemPlainSheetCost.setEditable(x);
                RawItemPlainSheetQty.setEditable(x);
                RawItemPlainSheetWeight.setEditable(x);
                RawItemPlainSheetWidth.setEditable(x);
                RawItemPlainSheetHeight.setEditable(x);
                RawItemPlainSheetLength.setEditable(x);
                RawItemPlainSheetThickness.setEditable(x);
                RawItemPlainSheetROL.setEditable(x);
                RawItemPlainSheetGRN.setEditable(x);
                break;
            case "U Bar":
                RawItemUbarCost.setEditable(x);
                RawItemUbarQty.setEditable(x);
                RawItemUbarWeight.setEditable(x);
                RawItemUbarWidth.setEditable(x);
                RawItemUbarHeight.setEditable(x);
                RawItemUbarLength.setEditable(x);
                RawItemUbarThickness.setEditable(x);
                RawItemUbarROL.setEditable(x);
                RawItemUbarGRN.setEditable(x);
                break;
            case "J Bar":
                RawItemJbarCost.setEditable(x);
                RawItemJbarQty.setEditable(x);
                RawItemJbarWeight.setEditable(x);
                RawItemJbarWidth.setEditable(x);
                RawItemJbarHeight.setEditable(x);
                RawItemJbarLength.setEditable(x);
                RawItemJbarThickness.setEditable(x);
                RawItemJbarROL.setEditable(x);
                RawItemJbarGRN.setEditable(x);
                break;
            case "U Channel Beading":
                RawItemUCBCost.setEditable(x);
                RawItemUCBQty.setEditable(x);
                RawItemUCBLength.setEditable(x);
                RawItemUCBROL.setEditable(x);
                RawItemUCBGRN.setEditable(x);
                break;
            case "Bottom Beading":
                RawItemBottomBleedingCost.setEditable(x);
                RawItemBottomBleedingQty.setEditable(x);
                RawItemBottomBleedingLength.setEditable(x);
                RawItemBottomBleedingROL.setEditable(x);
                RawItemBottomBleedingGRN.setEditable(x);
                break;
            case "Side Beading":
                RawItemSideBleedingCost.setEditable(x);
                RawItemSideBleedingQty.setEditable(x);
                RawItemSideBleedingLength.setEditable(x);
                RawItemSideBleedingROL.setEditable(x);
                RawItemSideBleedingGRN.setEditable(x);
                break;
            case "Aluminium Bottom Bar":
                RawItemABBarCost.setEditable(x);
                RawItemABBarQty.setEditable(x);
                RawItemABBarWidth.setEditable(x);
                RawItemABBarHeight.setEditable(x);
                RawItemABBarLength.setEditable(x);
                RawItemABBarThickness.setEditable(x);
                RawItemABBarROL.setEditable(x);
                RawItemABBarGRN.setEditable(x);
                break;
            case "Pulley":
                RawItemPulleyCost.setEditable(x);
                RawItemPulleyQty.setEditable(x);
                RawItemPulleyWidth.setEditable(x);
                RawItemPulleyHeight.setEditable(x);
                RawItemPulleyLength.setEditable(x);
                RawItemPulleyThickness.setEditable(x);
                RawItemPulleyROL.setEditable(x);
                RawItemPulleyGRN.setEditable(x);
                break;
            case "Spring":
                RawItemSpirngCost.setEditable(x);
                RawItemSpirngQty.setEditable(x);
                RawItemSpirngLength.setEditable(x);
                RawItemSpirngThickenss.setEditable(x);
                RawItemSpirngROL.setEditable(x);
                RawItemSpirngGRN.setEditable(x);
                break;
            case "Down Lock":
                RawItemDownLockCost.setEditable(x);
                RawItemDownLockQty.setEditable(x);
                RawItemDownLockWidth.setEditable(x);
                RawItemDownLockHeight.setEditable(x);
                RawItemDownLockLength.setEditable(x);
                RawItemDownLockROL.setEditable(x);
                RawItemDownLockGRN.setEditable(x);
                break;
            case "Side Lock":
                RawItemSideLockCost.setEditable(x);
                RawItemSideLockQty.setEditable(x);
                RawItemSideLockWidth.setEditable(x);
                RawItemSideLockHeight.setEditable(x);
                RawItemSideLockLength.setEditable(x);
                RawItemSideLockROL.setEditable(x);
                RawItemSideLockGRN.setEditable(x);
                break;
            case "Center Lock":
                RawItemCenterLockCost.setEditable(x);
                RawItemCenterLockQty.setEditable(x);
                RawItemCenterLockWidth.setEditable(x);
                RawItemCenterLockHeight.setEditable(x);
                RawItemCenterLockLength.setEditable(x);
                RawItemCenterLockROL.setEditable(x);
                RawItemCenterLockGRN.setEditable(x);
                break;
            case "C Perling Coils":
                RawItemCPerlingCost.setEditable(x);
                RawItemCPerlingQty.setEditable(x);
                RawItemCPerlingWeight.setEditable(x);
                RawItemCPerlingWidth.setEditable(x);
                RawItemCPerlingHeight.setEditable(x);
                RawItemCPerlingLength.setEditable(x);
                RawItemCPerlingThickness.setEditable(x);
                RawItemCPerlingROL.setEditable(x);
                RawItemCPerlingGRN.setEditable(x);
                break;
            case "Roller Shutter Belt":
                RawItemRSBeltCost.setEditable(x);
                RawItemRSBeltQty.setEditable(x);
                RawItemRSBeltLength.setEditable(x);
                RawItemRSBeltROL.setEditable(x);
                RawItemRSBeltGRN.setEditable(x);
                break;
            default:
                break;
        }
    }
    
    //_______Raw Item Catagory Changer________//
    
    void ChangeRawItemCat(String ChangeCat){
        try {
            switch (ChangeCat) {
                case "Plain Sheet":
                    UBarPnl.setVisible(false);
                    JBarPnl.setVisible(false);
                    UChannelBeadingPnl.setVisible(false);
                    BottomBeadingPnl.setVisible(false);
                    SideBeadingPnl.setVisible(false);
                    AluminiumBottomBarPnl.setVisible(false);
                    PulleyPnl.setVisible(false);
                    SpringPnl.setVisible(false);
                    DownLockPnl.setVisible(false);
                    SideLockPnl.setVisible(false);
                    CenterLockPnl.setVisible(false);
                    CPerlingCoilsPnl.setVisible(false);
                    RollerShutterBeltPnl.setVisible(false);
                    PlainSheetPnl.setVisible(true);
                    break;
                case "U Bar":
                    UBarPnl.setVisible(false);
                    UChannelBeadingPnl.setVisible(false);
                    BottomBeadingPnl.setVisible(false);
                    SideBeadingPnl.setVisible(false);
                    AluminiumBottomBarPnl.setVisible(false);
                    PulleyPnl.setVisible(false);
                    SpringPnl.setVisible(false);
                    DownLockPnl.setVisible(false);
                    SideLockPnl.setVisible(false);
                    CenterLockPnl.setVisible(false);
                    CPerlingCoilsPnl.setVisible(false);
                    RollerShutterBeltPnl.setVisible(false);
                    PlainSheetPnl.setVisible(false);
                    UBarPnl.setVisible(true);
                    break;
                case "J Bar":
                    UBarPnl.setVisible(false);
                    UChannelBeadingPnl.setVisible(false);
                    BottomBeadingPnl.setVisible(false);
                    SideBeadingPnl.setVisible(false);
                    AluminiumBottomBarPnl.setVisible(false);
                    PulleyPnl.setVisible(false);
                    SpringPnl.setVisible(false);
                    DownLockPnl.setVisible(false);
                    SideLockPnl.setVisible(false);
                    CenterLockPnl.setVisible(false);
                    CPerlingCoilsPnl.setVisible(false);
                    RollerShutterBeltPnl.setVisible(false);
                    PlainSheetPnl.setVisible(false);
                    JBarPnl.setVisible(true);
                    break;
                case "U Channel Beading":
                    UBarPnl.setVisible(false);
                    JBarPnl.setVisible(false);
                    BottomBeadingPnl.setVisible(false);
                    SideBeadingPnl.setVisible(false);
                    AluminiumBottomBarPnl.setVisible(false);
                    PulleyPnl.setVisible(false);
                    SpringPnl.setVisible(false);
                    DownLockPnl.setVisible(false);
                    SideLockPnl.setVisible(false);
                    CenterLockPnl.setVisible(false);
                    CPerlingCoilsPnl.setVisible(false);
                    RollerShutterBeltPnl.setVisible(false);
                    PlainSheetPnl.setVisible(false);
                    UChannelBeadingPnl.setVisible(true);
                    break;
                case "Bottom Beading":
                    UBarPnl.setVisible(false);
                    JBarPnl.setVisible(false);
                    UChannelBeadingPnl.setVisible(false);
                    SideBeadingPnl.setVisible(false);
                    AluminiumBottomBarPnl.setVisible(false);
                    PulleyPnl.setVisible(false);
                    SpringPnl.setVisible(false);
                    DownLockPnl.setVisible(false);
                    SideLockPnl.setVisible(false);
                    CenterLockPnl.setVisible(false);
                    CPerlingCoilsPnl.setVisible(false);
                    RollerShutterBeltPnl.setVisible(false);
                    PlainSheetPnl.setVisible(false);
                    BottomBeadingPnl.setVisible(true);
                    break;
                case "Side Beading":
                    UBarPnl.setVisible(false);
                    JBarPnl.setVisible(false);
                    UChannelBeadingPnl.setVisible(false);
                    BottomBeadingPnl.setVisible(false);
                    AluminiumBottomBarPnl.setVisible(false);
                    PulleyPnl.setVisible(false);
                    SpringPnl.setVisible(false);
                    DownLockPnl.setVisible(false);
                    SideLockPnl.setVisible(false);
                    CenterLockPnl.setVisible(false);
                    CPerlingCoilsPnl.setVisible(false);
                    RollerShutterBeltPnl.setVisible(false);
                    PlainSheetPnl.setVisible(false);
                    SideBeadingPnl.setVisible(true);
                    break;
                case "Aluminium Bottom Bar":
                    UBarPnl.setVisible(false);
                    JBarPnl.setVisible(false);
                    UChannelBeadingPnl.setVisible(false);
                    BottomBeadingPnl.setVisible(false);
                    SideBeadingPnl.setVisible(false);
                    PulleyPnl.setVisible(false);
                    SpringPnl.setVisible(false);
                    DownLockPnl.setVisible(false);
                    SideLockPnl.setVisible(false);
                    CenterLockPnl.setVisible(false);
                    CPerlingCoilsPnl.setVisible(false);
                    RollerShutterBeltPnl.setVisible(false);
                    PlainSheetPnl.setVisible(false);
                    AluminiumBottomBarPnl.setVisible(true);
                    break;
                case "Pulley":
                    UBarPnl.setVisible(false);
                    JBarPnl.setVisible(false);
                    UChannelBeadingPnl.setVisible(false);
                    BottomBeadingPnl.setVisible(false);
                    SideBeadingPnl.setVisible(false);
                    AluminiumBottomBarPnl.setVisible(false);
                    SpringPnl.setVisible(false);
                    DownLockPnl.setVisible(false);
                    SideLockPnl.setVisible(false);
                    CenterLockPnl.setVisible(false);
                    CPerlingCoilsPnl.setVisible(false);
                    RollerShutterBeltPnl.setVisible(false);
                    PlainSheetPnl.setVisible(false);
                    PulleyPnl.setVisible(true);
                    break;
                case "Spring":
                    UBarPnl.setVisible(false);
                    JBarPnl.setVisible(false);
                    UChannelBeadingPnl.setVisible(false);
                    BottomBeadingPnl.setVisible(false);
                    SideBeadingPnl.setVisible(false);
                    AluminiumBottomBarPnl.setVisible(false);
                    PulleyPnl.setVisible(false);
                    DownLockPnl.setVisible(false);
                    SideLockPnl.setVisible(false);
                    CenterLockPnl.setVisible(false);
                    CPerlingCoilsPnl.setVisible(false);
                    RollerShutterBeltPnl.setVisible(false);
                    PlainSheetPnl.setVisible(false);
                    SpringPnl.setVisible(true);
                    break;
                case "Down Lock":
                    UBarPnl.setVisible(false);
                    JBarPnl.setVisible(false);
                    UChannelBeadingPnl.setVisible(false);
                    BottomBeadingPnl.setVisible(false);
                    SideBeadingPnl.setVisible(false);
                    AluminiumBottomBarPnl.setVisible(false);
                    PulleyPnl.setVisible(false);
                    SpringPnl.setVisible(false);
                    SideLockPnl.setVisible(false);
                    CenterLockPnl.setVisible(false);
                    CPerlingCoilsPnl.setVisible(false);
                    RollerShutterBeltPnl.setVisible(false);
                    PlainSheetPnl.setVisible(false);
                    DownLockPnl.setVisible(true);
                    break;
                case "Side Lock":
                    UBarPnl.setVisible(false);
                    JBarPnl.setVisible(false);
                    UChannelBeadingPnl.setVisible(false);
                    BottomBeadingPnl.setVisible(false);
                    SideBeadingPnl.setVisible(false);
                    AluminiumBottomBarPnl.setVisible(false);
                    PulleyPnl.setVisible(false);
                    SpringPnl.setVisible(false);
                    DownLockPnl.setVisible(false);
                    CenterLockPnl.setVisible(false);
                    CPerlingCoilsPnl.setVisible(false);
                    RollerShutterBeltPnl.setVisible(false);
                    PlainSheetPnl.setVisible(false);
                    SideLockPnl.setVisible(true);
                    break;
                case "Center Lock":
                    UBarPnl.setVisible(false);
                    JBarPnl.setVisible(false);
                    UChannelBeadingPnl.setVisible(false);
                    BottomBeadingPnl.setVisible(false);
                    SideBeadingPnl.setVisible(false);
                    AluminiumBottomBarPnl.setVisible(false);
                    PulleyPnl.setVisible(false);
                    SpringPnl.setVisible(false);
                    DownLockPnl.setVisible(false);
                    SideLockPnl.setVisible(false);
                    CPerlingCoilsPnl.setVisible(false);
                    RollerShutterBeltPnl.setVisible(false);
                    PlainSheetPnl.setVisible(false);
                    CenterLockPnl.setVisible(true);
                    break;
                case "C Perling Coils":
                    UBarPnl.setVisible(false);
                    JBarPnl.setVisible(false);
                    UChannelBeadingPnl.setVisible(false);
                    BottomBeadingPnl.setVisible(false);
                    SideBeadingPnl.setVisible(false);
                    AluminiumBottomBarPnl.setVisible(false);
                    PulleyPnl.setVisible(false);
                    SpringPnl.setVisible(false);
                    DownLockPnl.setVisible(false);
                    SideLockPnl.setVisible(false);
                    CenterLockPnl.setVisible(false);
                    RollerShutterBeltPnl.setVisible(false);
                    PlainSheetPnl.setVisible(false);
                    CPerlingCoilsPnl.setVisible(true);
                    break;
                case "Roller Shutter Belt":
                    UBarPnl.setVisible(false);
                    JBarPnl.setVisible(false);
                    UChannelBeadingPnl.setVisible(false);
                    BottomBeadingPnl.setVisible(false);
                    SideBeadingPnl.setVisible(false);
                    AluminiumBottomBarPnl.setVisible(false);
                    PulleyPnl.setVisible(false);
                    SpringPnl.setVisible(false);
                    DownLockPnl.setVisible(false);
                    SideLockPnl.setVisible(false);
                    CenterLockPnl.setVisible(false);
                    CPerlingCoilsPnl.setVisible(false);
                    PlainSheetPnl.setVisible(false);
                    RollerShutterBeltPnl.setVisible(true);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //____________Search Raw Item_____________//
    
    void LoadItemCodeToFinishedItemPanel() { // must call from inside the constructor
        JComboBox iCode=RawItemCodeCB;
        iCode.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent x){
                if(x.getKeyCode() != KeyEvent.VK_ENTER && x.getKeyCode() != KeyEvent.VK_UP && x.getKeyCode() != KeyEvent.VK_DOWN && x.getKeyCode() != KeyEvent.VK_SHIFT){
                    String txt=iCode.getEditor().getItem().toString();
                    if(txt.isEmpty()){
                        iCode.hidePopup();
                        iCode.removeAllItems();
                    }else{
                        try {
                            iCode.removeAllItems();
                            int i=0;
                            Statement s=SeldoDB.GetMyConnection().createStatement();
                            ResultSet rs=s.executeQuery("select RawItemCode from rawitem where RawItemCode like '%"+txt+"%'");
                            
                            Vector v=new Vector();
                            
                            while (rs.next()) {
                                if (rs.getString("RawItemCode").toLowerCase().contains(txt.toLowerCase())) {
                                    v.add(rs.getString("RawItemCode"));
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
    
    void LoadRawItemDetailsFromDB(){ // must call from inside the combo box
        try {
            if(RawItemCodeCB.getSelectedIndex() != -1){
                String txt=RawItemCodeCB.getSelectedItem().toString();
                Statement s=SeldoDB.GetMyConnection().createStatement();
                ResultSet rs = s.executeQuery("select * from rawitem where RawItemCode like '%"+txt+"%'");
                rs.next();
                RawItemCatCB.setSelectedItem(rs.getString("RawItemName"));
                getRIData(txt,rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    void getRIData(String txt, ResultSet rs){
        try {
            String getCat=RawItemCatCB.getSelectedItem().toString();
            switch (getCat) {
                case "Plain Sheet":
                    RawItemPlainSheetColour.setText(rs.getString("RawItemColour"));
                    RawItemPlainSheetCost.setText(rs.getString("RawItemCost"));
                    RawItemPlainSheetQty.setText(rs.getString("RawItemQuantity"));
                    RawItemPlainSheetWeight.setText(rs.getString("RawItemWeight"));
                    RawItemPlainSheetWidth.setText(rs.getString("RawItemWidth"));
                    RawItemPlainSheetHeight.setText(rs.getString("RawItemHeight"));
                    RawItemPlainSheetLength.setText(rs.getString("RawItemLength"));
                    RawItemPlainSheetThickness.setText(rs.getString("RawItemThickness"));
                    RawItemPlainSheetROL.setText(rs.getString("ROL"));
                    RawItemPlainSheetGRN.setText(rs.getString("grn_grnNo"));
                    RawItemPlainSheetWeightUnit.setSelectedItem(rs.getString("WeightUnit"));
                    RawItemPlainSheetWidthUnit.setSelectedItem(rs.getString("WidthUnit"));
                    RawItemPlainSheetHeightUnit.setSelectedItem(rs.getString("HeightUnit"));
                    RawItemPlainSheetLengthUnit.setSelectedItem(rs.getString("LengthUnit"));
                    RawItemPlainSheetThicknessUnit.setSelectedItem(rs.getString("ThicknessUnit"));
                    break;
                case "U Bar":
                    RawItemUbarCost.setText(rs.getString("RawItemCost"));
                    RawItemUbarQty.setText(rs.getString("RawItemWidth"));
                    RawItemUbarWeight.setText(rs.getString("RawItemQuantity"));
                    RawItemUbarWidth.setText(rs.getString("RawItemHeight"));
                    RawItemUbarHeight.setText(rs.getString("RawItemWeight"));
                    RawItemUbarLength.setText(rs.getString("RawItemLength"));
                    RawItemUbarThickness.setText(rs.getString("RawItemThickness"));
                    RawItemUbarROL.setText(rs.getString("ROL"));
                    RawItemUbarGRN.setText(rs.getString("grn_grnNo"));
                    RawItemUbarWeightUnit.setSelectedItem(rs.getString("WeightUnit"));
                    RawItemUbarWidthUnit.setSelectedItem(rs.getString("WidthUnit"));
                    RawItemUbarHeightUnit.setSelectedItem(rs.getString("HeightUnit"));
                    RawItemUbarLengthUnit.setSelectedItem(rs.getString("LengthUnit"));
                    RawItemUbarThicknessUnit.setSelectedItem(rs.getString("ThicknessUnit"));
                    break;
                case "J Bar":
                    RawItemJbarCost.setText(rs.getString("RawItemCost"));
                    RawItemJbarQty.setText(rs.getString("RawItemWidth"));
                    RawItemJbarWeight.setText(rs.getString("RawItemQuantity"));
                    RawItemJbarWidth.setText(rs.getString("RawItemHeight"));
                    RawItemJbarHeight.setText(rs.getString("RawItemWeight"));
                    RawItemJbarLength.setText(rs.getString("RawItemLength"));
                    RawItemJbarThickness.setText(rs.getString("RawItemThickness"));
                    RawItemJbarROL.setText(rs.getString("ROL"));
                    RawItemJbarGRN.setText(rs.getString("grn_grnNo"));
                    RawItemJbarWeightUnit.setSelectedItem(rs.getString("WeightUnit"));
                    RawItemJbarWidthUnit.setSelectedItem(rs.getString("WidthUnit"));
                    RawItemJbarHeightUnit.setSelectedItem(rs.getString("HeightUnit"));
                    RawItemJbarLengthUnit.setSelectedItem(rs.getString("LengthUnit"));
                    RawItemJbarThicknessUnit.setSelectedItem(rs.getString("ThicknessUnit"));
                    break;
                case "U Channel Beading":
                    RawItemUCBCost.setText(rs.getString("RawItemCost"));
                    RawItemUCBQty.setText(rs.getString("RawItemQuantity"));
                    RawItemUCBLength.setText(rs.getString("RawItemLength"));
                    RawItemUCBROL.setText(rs.getString("ROL"));
                    RawItemUCBGRN.setText(rs.getString("grn_grnNo"));
                    RawItemUCBLengthUnit.setSelectedItem(rs.getString("LengthUnit"));
                    break;
                case "Bottom Beading":
                    RawItemBottomBleedingCost.setText(rs.getString("RawItemCost"));
                    RawItemBottomBleedingQty.setText(rs.getString("RawItemQuantity"));
                    RawItemBottomBleedingLength.setText(rs.getString("RawItemLength"));
                    RawItemBottomBleedingROL.setText(rs.getString("ROL"));
                    RawItemBottomBleedingGRN.setText(rs.getString("grn_grnNo"));
                    RawItemBottomBleedingLengthUnit.setSelectedItem(rs.getString("LengthUnit"));
                    break;
                case "Side Beading":
                    RawItemSideBleedingCost.setText(rs.getString("RawItemCost"));
                    RawItemSideBleedingQty.setText(rs.getString("RawItemQuantity"));
                    RawItemSideBleedingLength.setText(rs.getString("RawItemLength"));
                    RawItemSideBleedingROL.setText(rs.getString("ROL"));
                    RawItemSideBleedingGRN.setText(rs.getString("grn_grnNo"));
                    RawItemSideBleedingLengthUnit.setSelectedItem(rs.getString("LengthUnit"));
                    break;
                case "Aluminium Bottom Bar":
                    RawItemABBarCost.setText(rs.getString("RawItemCost"));
                    RawItemABBarQty.setText(rs.getString("RawItemQuantity"));
                    RawItemABBarWidth.setText(rs.getString("RawItemWidth"));
                    RawItemABBarHeight.setText(rs.getString("RawItemHeight"));
                    RawItemABBarLength.setText(rs.getString("RawItemLength"));
                    RawItemABBarThickness.setText(rs.getString("RawItemThickness"));
                    RawItemABBarROL.setText(rs.getString("ROL"));
                    RawItemABBarGRN.setText(rs.getString("grn_grnNo"));
                    RawItemABBarWidthUnit.setSelectedItem(rs.getString("WidthUnit"));
                    RawItemABBarHeightUnit.setSelectedItem(rs.getString("HeightUnit"));
                    RawItemABBarLengthUnit.setSelectedItem(rs.getString("LengthUnit"));
                    RawItemABBarThicknessUnit.setSelectedItem(rs.getString("ThicknessUnit"));
                    break;
                case "Pulley":
                    RawItemPulleyCost.setText(rs.getString("RawItemCost"));
                    RawItemPulleyQty.setText(rs.getString("RawItemQuantity"));
                    RawItemPulleyWidth.setText(rs.getString("RawItemWidth"));
                    RawItemPulleyHeight.setText(rs.getString("RawItemHeight"));
                    RawItemPulleyLength.setText(rs.getString("RawItemLength"));
                    RawItemPulleyThickness.setText(rs.getString("RawItemThickness"));
                    RawItemPulleyROL.setText(rs.getString("ROL"));
                    RawItemPulleyGRN.setText(rs.getString("grn_grnNo"));
                    RawItemPulleyWidthUnit.setSelectedItem(rs.getString("WidthUnit"));
                    RawItemPulleyHeightUnit.setSelectedItem(rs.getString("HeightUnit"));
                    RawItemPulleyLengthUnit.setSelectedItem(rs.getString("LengthUnit"));
                    RawItemPulleyThicknessUnit.setSelectedItem(rs.getString("ThicknessUnit"));
                    break;
                case "Spring":
                    RawItemSpirngCost.setText(rs.getString("RawItemCost"));
                    RawItemSpirngQty.setText(rs.getString("RawItemQuantity"));
                    RawItemSpirngLength.setText(rs.getString("RawItemLength"));
                    RawItemSpirngThickenss.setText(rs.getString("RawItemThickness"));
                    RawItemSpirngROL.setText(rs.getString("ROL"));
                    RawItemSpirngGRN.setText(rs.getString("grn_grnNo"));
                    RawItemPulleyLengthUnit.setSelectedItem(rs.getString("LengthUnit"));
                    break;
                case "Down Lock":
                    RawItemDownLockCost.setText(rs.getString("RawItemCost"));
                    RawItemDownLockQty.setText(rs.getString("RawItemQuantity"));
                    RawItemDownLockWidth.setText(rs.getString("RawItemWidth"));
                    RawItemDownLockHeight.setText(rs.getString("RawItemHeight"));
                    RawItemDownLockLength.setText(rs.getString("RawItemLength"));
                    RawItemDownLockROL.setText(rs.getString("ROL"));
                    RawItemDownLockGRN.setText(rs.getString("grn_grnNo"));
                    RawItemDownLockLengthUnit.setSelectedItem(rs.getString("LengthUnit"));
                    break;
                case "Side Lock":
                    RawItemSideLockCost.setText(rs.getString("RawItemCost"));
                    RawItemSideLockQty.setText(rs.getString("RawItemQuantity"));
                    RawItemSideLockWidth.setText(rs.getString("RawItemWidth"));
                    RawItemSideLockHeight.setText(rs.getString("RawItemHeight"));
                    RawItemSideLockLength.setText(rs.getString("RawItemLength"));
                    RawItemSideLockROL.setText(rs.getString("ROL"));
                    RawItemSideLockGRN.setText(rs.getString("grn_grnNo"));
                    RawItemSideLockLengthUnit.setSelectedItem(rs.getString("LengthUnit"));
                    break;
                case "Center Lock":
                    RawItemCenterLockCost.setText(rs.getString("RawItemCost"));
                    RawItemCenterLockQty.setText(rs.getString("RawItemQuantity"));
                    RawItemCenterLockWidth.setText(rs.getString("RawItemWidth"));
                    RawItemCenterLockHeight.setText(rs.getString("RawItemHeight"));
                    RawItemCenterLockLength.setText(rs.getString("RawItemLength"));
                    RawItemCenterLockROL.setText(rs.getString("ROL"));
                    RawItemCenterLockGRN.setText(rs.getString("grn_grnNo"));
                    RawItemCenterLockLengthUnit.setSelectedItem(rs.getString("LengthUnit"));
                    break;
                case "C Perling Coils":
                    RawItemCPerlingCost.setText(rs.getString("RawItemCost"));
                    RawItemCPerlingQty.setText(rs.getString("RawItemQuantity"));
                    RawItemCPerlingWeight.setText(rs.getString("RawItemWeight"));
                    RawItemCPerlingWidth.setText(rs.getString("RawItemWidth"));
                    RawItemCPerlingHeight.setText(rs.getString("RawItemHeight"));
                    RawItemCPerlingLength.setText(rs.getString("RawItemLength"));
                    RawItemCPerlingThickness.setText(rs.getString("RawItemThickness"));
                    RawItemCPerlingROL.setText(rs.getString("ROL"));
                    RawItemCPerlingGRN.setText(rs.getString("grn_grnNo"));
                    RawItemCPerlingLengthUnit.setSelectedItem(rs.getString("LengthUnit"));
                    break;
                case "Roller Shutter Belt":
                    RawItemRSBeltCost.setText(rs.getString("RawItemCost"));
                    RawItemRSBeltQty.setText(rs.getString("RawItemQuantity"));
                    RawItemRSBeltLength.setText(rs.getString("RawItemLength"));
                    RawItemRSBeltROL.setText(rs.getString("ROL"));
                    RawItemRSBeltGRN.setText(rs.getString("grn_grnNo"));
                    RawItemRSBeltLengthUnit.setSelectedItem(rs.getString("LengthUnit"));
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //___________________________________//
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RIMainPanel = new javax.swing.JPanel();
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
        SPChequeBtn1 = new javax.swing.JButton();
        SPSettingsBtn1 = new javax.swing.JButton();
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
        RIContentPanel = new javax.swing.JPanel();
        CPRawItemPanel = new javax.swing.JPanel();
        jLabel176 = new javax.swing.JLabel();
        jLabel186 = new javax.swing.JLabel();
        RawItemCatCB = new javax.swing.JComboBox<>();
        jButton25 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        RawItemCodeCB = new javax.swing.JComboBox<>();
        jLabel329 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        CatPanel2 = new javax.swing.JPanel();
        PlainSheetPnl = new javax.swing.JPanel();
        jLabel271 = new javax.swing.JLabel();
        jLabel272 = new javax.swing.JLabel();
        jLabel273 = new javax.swing.JLabel();
        jLabel274 = new javax.swing.JLabel();
        jLabel275 = new javax.swing.JLabel();
        jLabel276 = new javax.swing.JLabel();
        jLabel277 = new javax.swing.JLabel();
        jLabel278 = new javax.swing.JLabel();
        jLabel431 = new javax.swing.JLabel();
        RawItemPlainSheetColour = new javax.swing.JTextField();
        RawItemPlainSheetThickness = new javax.swing.JTextField();
        RawItemPlainSheetHeight = new javax.swing.JTextField();
        RawItemPlainSheetWidth = new javax.swing.JTextField();
        RawItemPlainSheetWeight = new javax.swing.JTextField();
        RawItemPlainSheetLength = new javax.swing.JTextField();
        RawItemPlainSheetROL = new javax.swing.JTextField();
        RawItemPlainSheetGRN = new javax.swing.JTextField();
        jLabel196 = new javax.swing.JLabel();
        RawItemPlainSheetWidthUnit = new javax.swing.JComboBox<>();
        jLabel206 = new javax.swing.JLabel();
        RawItemPlainSheetLengthUnit = new javax.swing.JComboBox<>();
        RawItemPlainSheetThicknessUnit = new javax.swing.JComboBox<>();
        RawItemPlainSheetHeightUnit = new javax.swing.JComboBox<>();
        jLabel279 = new javax.swing.JLabel();
        jLabel280 = new javax.swing.JLabel();
        jLabel281 = new javax.swing.JLabel();
        RawItemPlainSheetQty = new javax.swing.JTextField();
        RawItemPlainSheetCost = new javax.swing.JTextField();
        jLabel436 = new javax.swing.JLabel();
        RawItemPlainSheetWeightUnit = new javax.swing.JComboBox<>();
        UBarPnl = new javax.swing.JPanel();
        jLabel226 = new javax.swing.JLabel();
        jLabel236 = new javax.swing.JLabel();
        jLabel246 = new javax.swing.JLabel();
        jLabel265 = new javax.swing.JLabel();
        jLabel266 = new javax.swing.JLabel();
        jLabel267 = new javax.swing.JLabel();
        jLabel269 = new javax.swing.JLabel();
        jLabel310 = new javax.swing.JLabel();
        RawItemUbarThickness = new javax.swing.JTextField();
        RawItemUbarHeight = new javax.swing.JTextField();
        RawItemUbarWidth = new javax.swing.JTextField();
        RawItemUbarWeight = new javax.swing.JTextField();
        RawItemUbarLength = new javax.swing.JTextField();
        RawItemUbarROL = new javax.swing.JTextField();
        RawItemUbarGRN = new javax.swing.JTextField();
        RawItemUbarWeightUnit = new javax.swing.JComboBox<>();
        jLabel177 = new javax.swing.JLabel();
        RawItemUbarWidthUnit = new javax.swing.JComboBox<>();
        jLabel178 = new javax.swing.JLabel();
        RawItemUbarLengthUnit = new javax.swing.JComboBox<>();
        RawItemUbarThicknessUnit = new javax.swing.JComboBox<>();
        RawItemUbarHeightUnit = new javax.swing.JComboBox<>();
        jLabel179 = new javax.swing.JLabel();
        jLabel180 = new javax.swing.JLabel();
        jLabel181 = new javax.swing.JLabel();
        RawItemUbarQty = new javax.swing.JTextField();
        jLabel437 = new javax.swing.JLabel();
        RawItemUbarCost = new javax.swing.JTextField();
        JBarPnl = new javax.swing.JPanel();
        jLabel227 = new javax.swing.JLabel();
        jLabel247 = new javax.swing.JLabel();
        jLabel248 = new javax.swing.JLabel();
        jLabel268 = new javax.swing.JLabel();
        jLabel282 = new javax.swing.JLabel();
        jLabel283 = new javax.swing.JLabel();
        jLabel284 = new javax.swing.JLabel();
        jLabel432 = new javax.swing.JLabel();
        RawItemJbarThickness = new javax.swing.JTextField();
        RawItemJbarHeight = new javax.swing.JTextField();
        RawItemJbarWidth = new javax.swing.JTextField();
        RawItemJbarWeight = new javax.swing.JTextField();
        RawItemJbarLength = new javax.swing.JTextField();
        RawItemJbarROL = new javax.swing.JTextField();
        RawItemJbarGRN = new javax.swing.JTextField();
        RawItemJbarWeightUnit = new javax.swing.JComboBox<>();
        jLabel182 = new javax.swing.JLabel();
        RawItemJbarWidthUnit = new javax.swing.JComboBox<>();
        jLabel183 = new javax.swing.JLabel();
        RawItemJbarLengthUnit = new javax.swing.JComboBox<>();
        RawItemJbarThicknessUnit = new javax.swing.JComboBox<>();
        RawItemJbarHeightUnit = new javax.swing.JComboBox<>();
        jLabel184 = new javax.swing.JLabel();
        jLabel185 = new javax.swing.JLabel();
        jLabel187 = new javax.swing.JLabel();
        RawItemJbarQty = new javax.swing.JTextField();
        jLabel438 = new javax.swing.JLabel();
        RawItemJbarCost = new javax.swing.JTextField();
        UChannelBeadingPnl = new javax.swing.JPanel();
        jLabel250 = new javax.swing.JLabel();
        jLabel288 = new javax.swing.JLabel();
        jLabel433 = new javax.swing.JLabel();
        RawItemUCBLength = new javax.swing.JTextField();
        RawItemUCBROL = new javax.swing.JTextField();
        RawItemUCBGRN = new javax.swing.JTextField();
        jLabel188 = new javax.swing.JLabel();
        RawItemUCBLengthUnit = new javax.swing.JComboBox<>();
        jLabel191 = new javax.swing.JLabel();
        RawItemUCBQty = new javax.swing.JTextField();
        jLabel439 = new javax.swing.JLabel();
        RawItemUCBCost = new javax.swing.JTextField();
        BottomBeadingPnl = new javax.swing.JPanel();
        jLabel251 = new javax.swing.JLabel();
        jLabel289 = new javax.swing.JLabel();
        jLabel434 = new javax.swing.JLabel();
        RawItemBottomBleedingLength = new javax.swing.JTextField();
        RawItemBottomBleedingROL = new javax.swing.JTextField();
        RawItemBottomBleedingGRN = new javax.swing.JTextField();
        jLabel189 = new javax.swing.JLabel();
        RawItemBottomBleedingLengthUnit = new javax.swing.JComboBox<>();
        jLabel192 = new javax.swing.JLabel();
        RawItemBottomBleedingQty = new javax.swing.JTextField();
        jLabel440 = new javax.swing.JLabel();
        RawItemBottomBleedingCost = new javax.swing.JTextField();
        SideBeadingPnl = new javax.swing.JPanel();
        jLabel252 = new javax.swing.JLabel();
        jLabel290 = new javax.swing.JLabel();
        jLabel435 = new javax.swing.JLabel();
        RawItemSideBleedingLength = new javax.swing.JTextField();
        RawItemSideBleedingROL = new javax.swing.JTextField();
        RawItemSideBleedingGRN = new javax.swing.JTextField();
        jLabel190 = new javax.swing.JLabel();
        RawItemSideBleedingLengthUnit = new javax.swing.JComboBox<>();
        jLabel193 = new javax.swing.JLabel();
        RawItemSideBleedingQty = new javax.swing.JTextField();
        jLabel441 = new javax.swing.JLabel();
        RawItemSideBleedingCost = new javax.swing.JTextField();
        AluminiumBottomBarPnl = new javax.swing.JPanel();
        jLabel253 = new javax.swing.JLabel();
        jLabel285 = new javax.swing.JLabel();
        jLabel286 = new javax.swing.JLabel();
        jLabel287 = new javax.swing.JLabel();
        jLabel291 = new javax.swing.JLabel();
        jLabel311 = new javax.swing.JLabel();
        RawItemABBarThickness = new javax.swing.JTextField();
        RawItemABBarHeight = new javax.swing.JTextField();
        RawItemABBarWidth = new javax.swing.JTextField();
        RawItemABBarLength = new javax.swing.JTextField();
        RawItemABBarROL = new javax.swing.JTextField();
        RawItemABBarGRN = new javax.swing.JTextField();
        jLabel194 = new javax.swing.JLabel();
        RawItemABBarWidthUnit = new javax.swing.JComboBox<>();
        jLabel195 = new javax.swing.JLabel();
        RawItemABBarLengthUnit = new javax.swing.JComboBox<>();
        RawItemABBarThicknessUnit = new javax.swing.JComboBox<>();
        RawItemABBarHeightUnit = new javax.swing.JComboBox<>();
        jLabel197 = new javax.swing.JLabel();
        jLabel198 = new javax.swing.JLabel();
        jLabel199 = new javax.swing.JLabel();
        RawItemABBarQty = new javax.swing.JTextField();
        jLabel442 = new javax.swing.JLabel();
        RawItemABBarCost = new javax.swing.JTextField();
        PulleyPnl = new javax.swing.JPanel();
        jLabel254 = new javax.swing.JLabel();
        jLabel292 = new javax.swing.JLabel();
        jLabel293 = new javax.swing.JLabel();
        jLabel294 = new javax.swing.JLabel();
        jLabel295 = new javax.swing.JLabel();
        jLabel312 = new javax.swing.JLabel();
        RawItemPulleyThickness = new javax.swing.JTextField();
        RawItemPulleyHeight = new javax.swing.JTextField();
        RawItemPulleyWidth = new javax.swing.JTextField();
        RawItemPulleyLength = new javax.swing.JTextField();
        RawItemPulleyROL = new javax.swing.JTextField();
        RawItemPulleyGRN = new javax.swing.JTextField();
        jLabel200 = new javax.swing.JLabel();
        RawItemPulleyWidthUnit = new javax.swing.JComboBox<>();
        jLabel201 = new javax.swing.JLabel();
        RawItemPulleyLengthUnit = new javax.swing.JComboBox<>();
        RawItemPulleyThicknessUnit = new javax.swing.JComboBox<>();
        RawItemPulleyHeightUnit = new javax.swing.JComboBox<>();
        jLabel202 = new javax.swing.JLabel();
        jLabel203 = new javax.swing.JLabel();
        jLabel204 = new javax.swing.JLabel();
        RawItemPulleyQty = new javax.swing.JTextField();
        jLabel443 = new javax.swing.JLabel();
        RawItemPulleyCost = new javax.swing.JTextField();
        SpringPnl = new javax.swing.JPanel();
        jLabel255 = new javax.swing.JLabel();
        jLabel298 = new javax.swing.JLabel();
        jLabel299 = new javax.swing.JLabel();
        jLabel313 = new javax.swing.JLabel();
        RawItemSpirngThickenss = new javax.swing.JTextField();
        RawItemSpirngLength = new javax.swing.JTextField();
        RawItemSpirngROL = new javax.swing.JTextField();
        RawItemSpirngGRN = new javax.swing.JTextField();
        jLabel205 = new javax.swing.JLabel();
        RawItemSpirngLengthUnit = new javax.swing.JComboBox<>();
        RawItemSpirngThicknessUnit = new javax.swing.JComboBox<>();
        jLabel209 = new javax.swing.JLabel();
        jLabel210 = new javax.swing.JLabel();
        RawItemSpirngQty = new javax.swing.JTextField();
        jLabel444 = new javax.swing.JLabel();
        RawItemSpirngCost = new javax.swing.JTextField();
        DownLockPnl = new javax.swing.JPanel();
        jLabel296 = new javax.swing.JLabel();
        jLabel297 = new javax.swing.JLabel();
        jLabel300 = new javax.swing.JLabel();
        jLabel302 = new javax.swing.JLabel();
        jLabel314 = new javax.swing.JLabel();
        RawItemDownLockHeight = new javax.swing.JTextField();
        RawItemDownLockWidth = new javax.swing.JTextField();
        RawItemDownLockLength = new javax.swing.JTextField();
        RawItemDownLockROL = new javax.swing.JTextField();
        RawItemDownLockGRN = new javax.swing.JTextField();
        jLabel207 = new javax.swing.JLabel();
        RawItemDownLockWidthUnit = new javax.swing.JComboBox<>();
        jLabel208 = new javax.swing.JLabel();
        RawItemDownLockLengthUnit = new javax.swing.JComboBox<>();
        RawItemDownLockHeightUnit = new javax.swing.JComboBox<>();
        jLabel211 = new javax.swing.JLabel();
        jLabel212 = new javax.swing.JLabel();
        RawItemDownLockQty = new javax.swing.JTextField();
        jLabel445 = new javax.swing.JLabel();
        RawItemDownLockCost = new javax.swing.JTextField();
        SideLockPnl = new javax.swing.JPanel();
        jLabel301 = new javax.swing.JLabel();
        jLabel303 = new javax.swing.JLabel();
        jLabel304 = new javax.swing.JLabel();
        jLabel305 = new javax.swing.JLabel();
        jLabel315 = new javax.swing.JLabel();
        RawItemSideLockHeight = new javax.swing.JTextField();
        RawItemSideLockWidth = new javax.swing.JTextField();
        RawItemSideLockLength = new javax.swing.JTextField();
        RawItemSideLockROL = new javax.swing.JTextField();
        RawItemSideLockGRN = new javax.swing.JTextField();
        jLabel213 = new javax.swing.JLabel();
        RawItemSideLockWidthUnit = new javax.swing.JComboBox<>();
        jLabel214 = new javax.swing.JLabel();
        RawItemSideLockLengthUnit = new javax.swing.JComboBox<>();
        RawItemSideLockHeightUnit = new javax.swing.JComboBox<>();
        jLabel215 = new javax.swing.JLabel();
        jLabel228 = new javax.swing.JLabel();
        RawItemSideLockQty = new javax.swing.JTextField();
        jLabel446 = new javax.swing.JLabel();
        RawItemSideLockCost = new javax.swing.JTextField();
        CenterLockPnl = new javax.swing.JPanel();
        jLabel306 = new javax.swing.JLabel();
        jLabel307 = new javax.swing.JLabel();
        jLabel308 = new javax.swing.JLabel();
        jLabel309 = new javax.swing.JLabel();
        jLabel316 = new javax.swing.JLabel();
        RawItemCenterLockHeight = new javax.swing.JTextField();
        RawItemCenterLockWidth = new javax.swing.JTextField();
        RawItemCenterLockLength = new javax.swing.JTextField();
        RawItemCenterLockROL = new javax.swing.JTextField();
        RawItemCenterLockGRN = new javax.swing.JTextField();
        jLabel230 = new javax.swing.JLabel();
        RawItemCenterLockWidthUnit = new javax.swing.JComboBox<>();
        jLabel231 = new javax.swing.JLabel();
        RawItemCenterLockLengthUnit = new javax.swing.JComboBox<>();
        RawItemCenterLockHeightUnit = new javax.swing.JComboBox<>();
        jLabel232 = new javax.swing.JLabel();
        jLabel233 = new javax.swing.JLabel();
        RawItemCenterLockQty = new javax.swing.JTextField();
        jLabel447 = new javax.swing.JLabel();
        RawItemCenterLockCost = new javax.swing.JTextField();
        CPerlingCoilsPnl = new javax.swing.JPanel();
        jLabel235 = new javax.swing.JLabel();
        jLabel249 = new javax.swing.JLabel();
        jLabel317 = new javax.swing.JLabel();
        jLabel318 = new javax.swing.JLabel();
        jLabel319 = new javax.swing.JLabel();
        jLabel320 = new javax.swing.JLabel();
        jLabel321 = new javax.swing.JLabel();
        jLabel322 = new javax.swing.JLabel();
        RawItemCPerlingThickness = new javax.swing.JTextField();
        RawItemCPerlingHeight = new javax.swing.JTextField();
        RawItemCPerlingWidth = new javax.swing.JTextField();
        RawItemCPerlingWeight = new javax.swing.JTextField();
        RawItemCPerlingLength = new javax.swing.JTextField();
        RawItemCPerlingROL = new javax.swing.JTextField();
        RawItemCPerlingGRN = new javax.swing.JTextField();
        RawItemCPerlingWeightUnit = new javax.swing.JComboBox<>();
        jLabel323 = new javax.swing.JLabel();
        RawItemCPerlingWidthUnit = new javax.swing.JComboBox<>();
        jLabel324 = new javax.swing.JLabel();
        RawItemCPerlingLengthUnit = new javax.swing.JComboBox<>();
        RawItemCPerlingThicknessUnit = new javax.swing.JComboBox<>();
        RawItemCPerlingHeightUnit = new javax.swing.JComboBox<>();
        jLabel325 = new javax.swing.JLabel();
        jLabel326 = new javax.swing.JLabel();
        jLabel327 = new javax.swing.JLabel();
        RawItemCPerlingQty = new javax.swing.JTextField();
        jLabel448 = new javax.swing.JLabel();
        RawItemCPerlingCost = new javax.swing.JTextField();
        RollerShutterBeltPnl = new javax.swing.JPanel();
        jLabel331 = new javax.swing.JLabel();
        jLabel335 = new javax.swing.JLabel();
        jLabel336 = new javax.swing.JLabel();
        RawItemRSBeltLength = new javax.swing.JTextField();
        RawItemRSBeltROL = new javax.swing.JTextField();
        RawItemRSBeltGRN = new javax.swing.JTextField();
        jLabel337 = new javax.swing.JLabel();
        RawItemRSBeltLengthUnit = new javax.swing.JComboBox<>();
        jLabel340 = new javax.swing.JLabel();
        RawItemRSBeltQty = new javax.swing.JTextField();
        jLabel449 = new javax.swing.JLabel();
        RawItemRSBeltCost = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        RIMainPanel.setBackground(new java.awt.Color(51, 51, 51));
        RIMainPanel.setPreferredSize(new java.awt.Dimension(1366, 768));
        RIMainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TopicPanel.setBackground(new java.awt.Color(102, 102, 102));
        TopicPanel.setOpaque(false);
        TopicPanel.setPreferredSize(new java.awt.Dimension(230, 710));
        TopicPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SPArrowLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/ArrowSingleBlue.png"))); // NOI18N
        TopicPanel.add(SPArrowLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, -1, -1));

        SPSalesBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/SalesLableIMG01.png"))); // NOI18N
        SPSalesBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/SalesLableIMG02.png")));
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
        SPBranchersBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/BranchesLableIMG02.png"))); // NOI18N
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

        SPChequeBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/ChequeLableIMG01.png"))); // NOI18N
        SPChequeBtn1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/ChequeLableIMG02.png"))); // NOI18N
        SPChequeBtn1.setContentAreaFilled(false);
        SPChequeBtn1.setMaximumSize(new java.awt.Dimension(200, 40));
        SPChequeBtn1.setMinimumSize(new java.awt.Dimension(200, 40));
        SPChequeBtn1.setName(""); // NOI18N
        SPChequeBtn1.setPreferredSize(new java.awt.Dimension(200, 40));
        SPChequeBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SPChequeBtn1ActionPerformed(evt);
            }
        });
        TopicPanel.add(SPChequeBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 470, -1, -1));

        SPSettingsBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/ExpencesIMG1.png"))); // NOI18N
        SPSettingsBtn1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Buttons/ExpencesIMG2.png"))); // NOI18N
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

        RIMainPanel.add(TopicPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 230, 710));

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

        RIMainPanel.add(TopPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 60));

        RIContentPanel.setPreferredSize(new java.awt.Dimension(1140, 710));
        RIContentPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CPRawItemPanel.setBackground(new java.awt.Color(51, 51, 51));
        CPRawItemPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel176.setBackground(new java.awt.Color(255, 255, 255));
        jLabel176.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 24)); // NOI18N
        jLabel176.setForeground(new java.awt.Color(255, 255, 255));
        jLabel176.setText("Raw Items");
        CPRawItemPanel.add(jLabel176, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 190, 38));

        jLabel186.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel186.setForeground(new java.awt.Color(255, 255, 255));
        jLabel186.setText("Item Name");
        CPRawItemPanel.add(jLabel186, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, -1));

        RawItemCatCB.setBackground(new java.awt.Color(102, 102, 102));
        RawItemCatCB.setEditable(true);
        RawItemCatCB.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemCatCB.setForeground(new java.awt.Color(255, 255, 255));
        RawItemCatCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Plain Sheet", "U Bar", "J Bar", "U Channel Beading", "Bottom Beading", "Side Beading", "Aluminium Bottom Bar", "Pulley", "Spring", "Down Lock", "Side Lock", "Center Lock", "C Perling Coils", "Roller Shutter Belt" }));
        RawItemCatCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RawItemCatCBActionPerformed(evt);
            }
        });
        CPRawItemPanel.add(RawItemCatCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 260, -1));

        jButton25.setBackground(new java.awt.Color(0, 0, 0));
        jButton25.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jButton25.setForeground(new java.awt.Color(255, 255, 255));
        jButton25.setText("Add Item ");
        jButton25.setMaximumSize(new java.awt.Dimension(171, 25));
        jButton25.setMinimumSize(new java.awt.Dimension(171, 25));
        jButton25.setPreferredSize(new java.awt.Dimension(171, 25));
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });
        CPRawItemPanel.add(jButton25, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 590, 190, 40));

        jButton17.setBackground(new java.awt.Color(0, 0, 0));
        jButton17.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jButton17.setForeground(new java.awt.Color(255, 255, 255));
        jButton17.setText("Edit Item");
        jButton17.setMaximumSize(new java.awt.Dimension(171, 25));
        jButton17.setMinimumSize(new java.awt.Dimension(171, 25));
        jButton17.setPreferredSize(new java.awt.Dimension(171, 25));
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        CPRawItemPanel.add(jButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 590, 190, 40));

        jButton18.setBackground(new java.awt.Color(0, 0, 0));
        jButton18.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jButton18.setForeground(new java.awt.Color(255, 255, 255));
        jButton18.setText("Update Item");
        jButton18.setMaximumSize(new java.awt.Dimension(171, 25));
        jButton18.setMinimumSize(new java.awt.Dimension(171, 25));
        jButton18.setPreferredSize(new java.awt.Dimension(171, 25));
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        CPRawItemPanel.add(jButton18, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 590, 190, 40));

        jButton23.setBackground(new java.awt.Color(0, 0, 0));
        jButton23.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jButton23.setForeground(new java.awt.Color(255, 255, 255));
        jButton23.setText("Clear Fields");
        jButton23.setMaximumSize(new java.awt.Dimension(171, 25));
        jButton23.setMinimumSize(new java.awt.Dimension(171, 25));
        jButton23.setPreferredSize(new java.awt.Dimension(171, 25));
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });
        CPRawItemPanel.add(jButton23, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 590, 190, 40));

        RawItemCodeCB.setBackground(new java.awt.Color(102, 102, 102));
        RawItemCodeCB.setEditable(true);
        RawItemCodeCB.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemCodeCB.setForeground(new java.awt.Color(255, 255, 255));
        RawItemCodeCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RawItemCodeCBActionPerformed(evt);
            }
        });
        CPRawItemPanel.add(RawItemCodeCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 260, -1));

        jLabel329.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel329.setForeground(new java.awt.Color(255, 255, 255));
        jLabel329.setText("Item Code");
        CPRawItemPanel.add(jLabel329, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 100, 20));

        jLabel28.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Please Type Item Code Here To Search");
        CPRawItemPanel.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 120, -1, -1));

        CatPanel2.setForeground(new java.awt.Color(255, 255, 255));
        CatPanel2.setOpaque(false);
        CatPanel2.setPreferredSize(new java.awt.Dimension(480, 400));
        CatPanel2.setLayout(new java.awt.CardLayout());

        PlainSheetPnl.setBackground(new java.awt.Color(0, 0, 0));
        PlainSheetPnl.setOpaque(false);
        PlainSheetPnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel271.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel271.setForeground(new java.awt.Color(255, 255, 255));
        jLabel271.setText("Unit");
        PlainSheetPnl.add(jLabel271, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 50, 20));

        jLabel272.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel272.setForeground(new java.awt.Color(255, 255, 255));
        jLabel272.setText("Weight");
        PlainSheetPnl.add(jLabel272, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 80, 20));

        jLabel273.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel273.setForeground(new java.awt.Color(255, 255, 255));
        jLabel273.setText("Length");
        PlainSheetPnl.add(jLabel273, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 80, 20));

        jLabel274.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel274.setForeground(new java.awt.Color(255, 255, 255));
        jLabel274.setText("Width");
        PlainSheetPnl.add(jLabel274, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 70, 20));

        jLabel275.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel275.setForeground(new java.awt.Color(255, 255, 255));
        jLabel275.setText("Height");
        PlainSheetPnl.add(jLabel275, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 80, 20));

        jLabel276.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel276.setForeground(new java.awt.Color(255, 255, 255));
        jLabel276.setText("Thickness");
        PlainSheetPnl.add(jLabel276, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 100, 20));

        jLabel277.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel277.setForeground(new java.awt.Color(255, 255, 255));
        jLabel277.setText("Colour");
        PlainSheetPnl.add(jLabel277, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 80, 20));

        jLabel278.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel278.setForeground(new java.awt.Color(255, 255, 255));
        jLabel278.setText("Quantity");
        PlainSheetPnl.add(jLabel278, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 90, 20));

        jLabel431.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel431.setForeground(new java.awt.Color(255, 255, 255));
        jLabel431.setText("GRN Number");
        PlainSheetPnl.add(jLabel431, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 120, 20));

        RawItemPlainSheetColour.setBackground(new java.awt.Color(102, 102, 102));
        RawItemPlainSheetColour.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemPlainSheetColour.setForeground(new java.awt.Color(255, 255, 255));
        PlainSheetPnl.add(RawItemPlainSheetColour, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 260, -1));

        RawItemPlainSheetThickness.setBackground(new java.awt.Color(102, 102, 102));
        RawItemPlainSheetThickness.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemPlainSheetThickness.setForeground(new java.awt.Color(255, 255, 255));
        RawItemPlainSheetThickness.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemPlainSheetThicknessKeyTyped(evt);
            }
        });
        PlainSheetPnl.add(RawItemPlainSheetThickness, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 260, -1));

        RawItemPlainSheetHeight.setBackground(new java.awt.Color(102, 102, 102));
        RawItemPlainSheetHeight.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemPlainSheetHeight.setForeground(new java.awt.Color(255, 255, 255));
        RawItemPlainSheetHeight.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemPlainSheetHeightKeyTyped(evt);
            }
        });
        PlainSheetPnl.add(RawItemPlainSheetHeight, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 260, -1));

        RawItemPlainSheetWidth.setBackground(new java.awt.Color(102, 102, 102));
        RawItemPlainSheetWidth.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemPlainSheetWidth.setForeground(new java.awt.Color(255, 255, 255));
        RawItemPlainSheetWidth.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemPlainSheetWidthKeyTyped(evt);
            }
        });
        PlainSheetPnl.add(RawItemPlainSheetWidth, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 260, -1));

        RawItemPlainSheetWeight.setBackground(new java.awt.Color(102, 102, 102));
        RawItemPlainSheetWeight.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemPlainSheetWeight.setForeground(new java.awt.Color(255, 255, 255));
        RawItemPlainSheetWeight.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemPlainSheetWeightKeyTyped(evt);
            }
        });
        PlainSheetPnl.add(RawItemPlainSheetWeight, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 260, -1));

        RawItemPlainSheetLength.setBackground(new java.awt.Color(102, 102, 102));
        RawItemPlainSheetLength.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemPlainSheetLength.setForeground(new java.awt.Color(255, 255, 255));
        RawItemPlainSheetLength.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RawItemPlainSheetLengthActionPerformed(evt);
            }
        });
        RawItemPlainSheetLength.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemPlainSheetLengthKeyTyped(evt);
            }
        });
        PlainSheetPnl.add(RawItemPlainSheetLength, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 260, -1));

        RawItemPlainSheetROL.setBackground(new java.awt.Color(102, 102, 102));
        RawItemPlainSheetROL.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemPlainSheetROL.setForeground(new java.awt.Color(255, 255, 255));
        RawItemPlainSheetROL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RawItemPlainSheetROLActionPerformed(evt);
            }
        });
        RawItemPlainSheetROL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemPlainSheetROLKeyTyped(evt);
            }
        });
        PlainSheetPnl.add(RawItemPlainSheetROL, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 260, -1));

        RawItemPlainSheetGRN.setBackground(new java.awt.Color(102, 102, 102));
        RawItemPlainSheetGRN.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemPlainSheetGRN.setForeground(new java.awt.Color(255, 255, 255));
        PlainSheetPnl.add(RawItemPlainSheetGRN, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, 260, -1));

        jLabel196.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel196.setForeground(new java.awt.Color(255, 255, 255));
        jLabel196.setText("Unit");
        PlainSheetPnl.add(jLabel196, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, 50, 20));

        RawItemPlainSheetWidthUnit.setBackground(new java.awt.Color(102, 102, 102));
        RawItemPlainSheetWidthUnit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemPlainSheetWidthUnit.setForeground(new java.awt.Color(255, 255, 255));
        RawItemPlainSheetWidthUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Meters", "Centimeters", "Millimeters", "Inches", "Feets" }));
        PlainSheetPnl.add(RawItemPlainSheetWidthUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, 120, -1));

        jLabel206.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel206.setForeground(new java.awt.Color(255, 255, 255));
        jLabel206.setText("Unit");
        PlainSheetPnl.add(jLabel206, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, 50, 20));

        RawItemPlainSheetLengthUnit.setBackground(new java.awt.Color(102, 102, 102));
        RawItemPlainSheetLengthUnit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemPlainSheetLengthUnit.setForeground(new java.awt.Color(255, 255, 255));
        RawItemPlainSheetLengthUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Meters", "Centimeters", "Millimeters", "Inches", "Feets" }));
        PlainSheetPnl.add(RawItemPlainSheetLengthUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 50, 120, -1));

        RawItemPlainSheetThicknessUnit.setBackground(new java.awt.Color(102, 102, 102));
        RawItemPlainSheetThicknessUnit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemPlainSheetThicknessUnit.setForeground(new java.awt.Color(255, 255, 255));
        RawItemPlainSheetThicknessUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Meters", "Centimeters", "Millimeters", "Inches", "Feets" }));
        PlainSheetPnl.add(RawItemPlainSheetThicknessUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 170, 120, -1));

        RawItemPlainSheetHeightUnit.setBackground(new java.awt.Color(102, 102, 102));
        RawItemPlainSheetHeightUnit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemPlainSheetHeightUnit.setForeground(new java.awt.Color(255, 255, 255));
        RawItemPlainSheetHeightUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Meters", "Centimeters", "Millimeters", "Inches", "Feets" }));
        PlainSheetPnl.add(RawItemPlainSheetHeightUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 130, 120, -1));

        jLabel279.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel279.setForeground(new java.awt.Color(255, 255, 255));
        jLabel279.setText("Unit");
        PlainSheetPnl.add(jLabel279, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 130, 50, 20));

        jLabel280.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel280.setForeground(new java.awt.Color(255, 255, 255));
        jLabel280.setText("Re-order Level");
        PlainSheetPnl.add(jLabel280, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 140, 20));

        jLabel281.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel281.setForeground(new java.awt.Color(255, 255, 255));
        jLabel281.setText("Unit");
        PlainSheetPnl.add(jLabel281, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, 50, 20));

        RawItemPlainSheetQty.setBackground(new java.awt.Color(102, 102, 102));
        RawItemPlainSheetQty.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemPlainSheetQty.setForeground(new java.awt.Color(255, 255, 255));
        RawItemPlainSheetQty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemPlainSheetQtyKeyTyped(evt);
            }
        });
        PlainSheetPnl.add(RawItemPlainSheetQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 260, -1));

        RawItemPlainSheetCost.setBackground(new java.awt.Color(102, 102, 102));
        RawItemPlainSheetCost.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemPlainSheetCost.setForeground(new java.awt.Color(255, 255, 255));
        RawItemPlainSheetCost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemPlainSheetCostKeyTyped(evt);
            }
        });
        PlainSheetPnl.add(RawItemPlainSheetCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 370, 260, -1));

        jLabel436.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel436.setForeground(new java.awt.Color(255, 255, 255));
        jLabel436.setText("Item Cost");
        PlainSheetPnl.add(jLabel436, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 120, 20));

        RawItemPlainSheetWeightUnit.setBackground(new java.awt.Color(102, 102, 102));
        RawItemPlainSheetWeightUnit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemPlainSheetWeightUnit.setForeground(new java.awt.Color(255, 255, 255));
        RawItemPlainSheetWeightUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kilograms", "Tons" }));
        PlainSheetPnl.add(RawItemPlainSheetWeightUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 120, -1));

        CatPanel2.add(PlainSheetPnl, "card3");

        UBarPnl.setBackground(new java.awt.Color(0, 0, 0));
        UBarPnl.setForeground(new java.awt.Color(255, 255, 255));
        UBarPnl.setOpaque(false);
        UBarPnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel226.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel226.setForeground(new java.awt.Color(255, 255, 255));
        jLabel226.setText("Unit");
        UBarPnl.add(jLabel226, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 50, 20));

        jLabel236.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel236.setForeground(new java.awt.Color(255, 255, 255));
        jLabel236.setText("Weight");
        UBarPnl.add(jLabel236, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 80, 20));

        jLabel246.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel246.setForeground(new java.awt.Color(255, 255, 255));
        jLabel246.setText("Length");
        UBarPnl.add(jLabel246, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 80, 20));

        jLabel265.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel265.setForeground(new java.awt.Color(255, 255, 255));
        jLabel265.setText("Width");
        UBarPnl.add(jLabel265, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 70, 20));

        jLabel266.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel266.setForeground(new java.awt.Color(255, 255, 255));
        jLabel266.setText("Height");
        UBarPnl.add(jLabel266, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 80, 20));

        jLabel267.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel267.setForeground(new java.awt.Color(255, 255, 255));
        jLabel267.setText("Thickness");
        UBarPnl.add(jLabel267, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 100, 20));

        jLabel269.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel269.setForeground(new java.awt.Color(255, 255, 255));
        jLabel269.setText("Quantity");
        UBarPnl.add(jLabel269, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 90, 20));

        jLabel310.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel310.setForeground(new java.awt.Color(255, 255, 255));
        jLabel310.setText("GRN Number");
        UBarPnl.add(jLabel310, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 120, 20));

        RawItemUbarThickness.setBackground(new java.awt.Color(102, 102, 102));
        RawItemUbarThickness.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemUbarThickness.setForeground(new java.awt.Color(255, 255, 255));
        RawItemUbarThickness.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemUbarThicknessKeyTyped(evt);
            }
        });
        UBarPnl.add(RawItemUbarThickness, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 260, -1));

        RawItemUbarHeight.setBackground(new java.awt.Color(102, 102, 102));
        RawItemUbarHeight.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemUbarHeight.setForeground(new java.awt.Color(255, 255, 255));
        RawItemUbarHeight.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemUbarHeightKeyTyped(evt);
            }
        });
        UBarPnl.add(RawItemUbarHeight, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 260, -1));

        RawItemUbarWidth.setBackground(new java.awt.Color(102, 102, 102));
        RawItemUbarWidth.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemUbarWidth.setForeground(new java.awt.Color(255, 255, 255));
        RawItemUbarWidth.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemUbarWidthKeyTyped(evt);
            }
        });
        UBarPnl.add(RawItemUbarWidth, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 260, -1));

        RawItemUbarWeight.setBackground(new java.awt.Color(102, 102, 102));
        RawItemUbarWeight.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemUbarWeight.setForeground(new java.awt.Color(255, 255, 255));
        RawItemUbarWeight.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemUbarWeightKeyTyped(evt);
            }
        });
        UBarPnl.add(RawItemUbarWeight, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 260, -1));

        RawItemUbarLength.setBackground(new java.awt.Color(102, 102, 102));
        RawItemUbarLength.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemUbarLength.setForeground(new java.awt.Color(255, 255, 255));
        RawItemUbarLength.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RawItemUbarLengthActionPerformed(evt);
            }
        });
        RawItemUbarLength.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemUbarLengthKeyTyped(evt);
            }
        });
        UBarPnl.add(RawItemUbarLength, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 260, -1));

        RawItemUbarROL.setBackground(new java.awt.Color(102, 102, 102));
        RawItemUbarROL.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemUbarROL.setForeground(new java.awt.Color(255, 255, 255));
        RawItemUbarROL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemUbarROLKeyTyped(evt);
            }
        });
        UBarPnl.add(RawItemUbarROL, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 260, -1));

        RawItemUbarGRN.setBackground(new java.awt.Color(102, 102, 102));
        RawItemUbarGRN.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemUbarGRN.setForeground(new java.awt.Color(255, 255, 255));
        UBarPnl.add(RawItemUbarGRN, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 260, -1));

        RawItemUbarWeightUnit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemUbarWeightUnit.setForeground(new java.awt.Color(255, 255, 255));
        RawItemUbarWeightUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kilograms", "Tons" }));
        UBarPnl.add(RawItemUbarWeightUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 120, -1));

        jLabel177.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel177.setForeground(new java.awt.Color(255, 255, 255));
        jLabel177.setText("Unit");
        UBarPnl.add(jLabel177, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, 50, 20));

        RawItemUbarWidthUnit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemUbarWidthUnit.setForeground(new java.awt.Color(255, 255, 255));
        RawItemUbarWidthUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Meters", "Centimeters", "Millimeters", "Inches", "Feets" }));
        UBarPnl.add(RawItemUbarWidthUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, 120, -1));

        jLabel178.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel178.setForeground(new java.awt.Color(255, 255, 255));
        jLabel178.setText("Unit");
        UBarPnl.add(jLabel178, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, 50, 20));

        RawItemUbarLengthUnit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemUbarLengthUnit.setForeground(new java.awt.Color(255, 255, 255));
        RawItemUbarLengthUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Meters", "Centimeters", "Millimeters", "Inches", "Feets" }));
        UBarPnl.add(RawItemUbarLengthUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 50, 120, -1));

        RawItemUbarThicknessUnit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemUbarThicknessUnit.setForeground(new java.awt.Color(255, 255, 255));
        RawItemUbarThicknessUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Meters", "Centimeters", "Millimeters", "Inches", "Feets" }));
        UBarPnl.add(RawItemUbarThicknessUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 170, 120, -1));

        RawItemUbarHeightUnit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemUbarHeightUnit.setForeground(new java.awt.Color(255, 255, 255));
        RawItemUbarHeightUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Meters", "Centimeters", "Millimeters", "Inches", "Feets" }));
        UBarPnl.add(RawItemUbarHeightUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 130, 120, -1));

        jLabel179.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel179.setForeground(new java.awt.Color(255, 255, 255));
        jLabel179.setText("Unit");
        UBarPnl.add(jLabel179, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 130, 50, 20));

        jLabel180.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel180.setForeground(new java.awt.Color(255, 255, 255));
        jLabel180.setText("Re-order Level");
        UBarPnl.add(jLabel180, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 140, 20));

        jLabel181.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel181.setForeground(new java.awt.Color(255, 255, 255));
        jLabel181.setText("Unit");
        UBarPnl.add(jLabel181, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, 50, 20));

        RawItemUbarQty.setBackground(new java.awt.Color(102, 102, 102));
        RawItemUbarQty.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemUbarQty.setForeground(new java.awt.Color(255, 255, 255));
        RawItemUbarQty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemUbarQtyKeyTyped(evt);
            }
        });
        UBarPnl.add(RawItemUbarQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 260, -1));

        jLabel437.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel437.setForeground(new java.awt.Color(255, 255, 255));
        jLabel437.setText("Item Cost");
        UBarPnl.add(jLabel437, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 120, 20));

        RawItemUbarCost.setBackground(new java.awt.Color(102, 102, 102));
        RawItemUbarCost.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemUbarCost.setForeground(new java.awt.Color(255, 255, 255));
        RawItemUbarCost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemUbarCostKeyTyped(evt);
            }
        });
        UBarPnl.add(RawItemUbarCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, 260, -1));

        CatPanel2.add(UBarPnl, "card2");

        JBarPnl.setBackground(new java.awt.Color(0, 0, 0));
        JBarPnl.setOpaque(false);
        JBarPnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel227.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel227.setForeground(new java.awt.Color(255, 255, 255));
        jLabel227.setText("Unit");
        JBarPnl.add(jLabel227, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 50, 20));

        jLabel247.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel247.setForeground(new java.awt.Color(255, 255, 255));
        jLabel247.setText("Weight");
        JBarPnl.add(jLabel247, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 80, 20));

        jLabel248.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel248.setForeground(new java.awt.Color(255, 255, 255));
        jLabel248.setText("Length");
        JBarPnl.add(jLabel248, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 80, 20));

        jLabel268.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel268.setForeground(new java.awt.Color(255, 255, 255));
        jLabel268.setText("Width");
        JBarPnl.add(jLabel268, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 70, 20));

        jLabel282.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel282.setForeground(new java.awt.Color(255, 255, 255));
        jLabel282.setText("Height");
        JBarPnl.add(jLabel282, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 80, 20));

        jLabel283.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel283.setForeground(new java.awt.Color(255, 255, 255));
        jLabel283.setText("Thickness");
        JBarPnl.add(jLabel283, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 100, 20));

        jLabel284.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel284.setForeground(new java.awt.Color(255, 255, 255));
        jLabel284.setText("Quantity");
        JBarPnl.add(jLabel284, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 90, 20));

        jLabel432.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel432.setForeground(new java.awt.Color(255, 255, 255));
        jLabel432.setText("GRN Number");
        JBarPnl.add(jLabel432, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 120, 20));

        RawItemJbarThickness.setBackground(new java.awt.Color(102, 102, 102));
        RawItemJbarThickness.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemJbarThickness.setForeground(new java.awt.Color(255, 255, 255));
        RawItemJbarThickness.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemJbarThicknessKeyTyped(evt);
            }
        });
        JBarPnl.add(RawItemJbarThickness, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 260, -1));

        RawItemJbarHeight.setBackground(new java.awt.Color(102, 102, 102));
        RawItemJbarHeight.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemJbarHeight.setForeground(new java.awt.Color(255, 255, 255));
        RawItemJbarHeight.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemJbarHeightKeyTyped(evt);
            }
        });
        JBarPnl.add(RawItemJbarHeight, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 260, -1));

        RawItemJbarWidth.setBackground(new java.awt.Color(102, 102, 102));
        RawItemJbarWidth.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemJbarWidth.setForeground(new java.awt.Color(255, 255, 255));
        RawItemJbarWidth.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemJbarWidthKeyTyped(evt);
            }
        });
        JBarPnl.add(RawItemJbarWidth, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 260, -1));

        RawItemJbarWeight.setBackground(new java.awt.Color(102, 102, 102));
        RawItemJbarWeight.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemJbarWeight.setForeground(new java.awt.Color(255, 255, 255));
        RawItemJbarWeight.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemJbarWeightKeyTyped(evt);
            }
        });
        JBarPnl.add(RawItemJbarWeight, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 260, -1));

        RawItemJbarLength.setBackground(new java.awt.Color(102, 102, 102));
        RawItemJbarLength.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemJbarLength.setForeground(new java.awt.Color(255, 255, 255));
        RawItemJbarLength.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RawItemJbarLengthActionPerformed(evt);
            }
        });
        RawItemJbarLength.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemJbarLengthKeyTyped(evt);
            }
        });
        JBarPnl.add(RawItemJbarLength, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 260, -1));

        RawItemJbarROL.setBackground(new java.awt.Color(102, 102, 102));
        RawItemJbarROL.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemJbarROL.setForeground(new java.awt.Color(255, 255, 255));
        RawItemJbarROL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemJbarROLKeyTyped(evt);
            }
        });
        JBarPnl.add(RawItemJbarROL, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 260, -1));

        RawItemJbarGRN.setBackground(new java.awt.Color(102, 102, 102));
        RawItemJbarGRN.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemJbarGRN.setForeground(new java.awt.Color(255, 255, 255));
        JBarPnl.add(RawItemJbarGRN, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 260, -1));

        RawItemJbarWeightUnit.setBackground(new java.awt.Color(102, 102, 102));
        RawItemJbarWeightUnit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemJbarWeightUnit.setForeground(new java.awt.Color(255, 255, 255));
        RawItemJbarWeightUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kilograms", "Tons" }));
        JBarPnl.add(RawItemJbarWeightUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 120, -1));

        jLabel182.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel182.setForeground(new java.awt.Color(255, 255, 255));
        jLabel182.setText("Unit");
        JBarPnl.add(jLabel182, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, 50, 20));

        RawItemJbarWidthUnit.setBackground(new java.awt.Color(102, 102, 102));
        RawItemJbarWidthUnit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemJbarWidthUnit.setForeground(new java.awt.Color(255, 255, 255));
        RawItemJbarWidthUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Meters", "Centimeters", "Millimeters", "Inches", "Feets" }));
        JBarPnl.add(RawItemJbarWidthUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, 120, -1));

        jLabel183.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel183.setForeground(new java.awt.Color(255, 255, 255));
        jLabel183.setText("Unit");
        JBarPnl.add(jLabel183, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, 50, 20));

        RawItemJbarLengthUnit.setBackground(new java.awt.Color(102, 102, 102));
        RawItemJbarLengthUnit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemJbarLengthUnit.setForeground(new java.awt.Color(255, 255, 255));
        RawItemJbarLengthUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Meters", "Centimeters", "Millimeters", "Inches", "Feets" }));
        JBarPnl.add(RawItemJbarLengthUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 50, 120, -1));

        RawItemJbarThicknessUnit.setBackground(new java.awt.Color(102, 102, 102));
        RawItemJbarThicknessUnit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemJbarThicknessUnit.setForeground(new java.awt.Color(255, 255, 255));
        RawItemJbarThicknessUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Meters", "Centimeters", "Millimeters", "Inches", "Feets" }));
        JBarPnl.add(RawItemJbarThicknessUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 170, 120, -1));

        RawItemJbarHeightUnit.setBackground(new java.awt.Color(102, 102, 102));
        RawItemJbarHeightUnit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemJbarHeightUnit.setForeground(new java.awt.Color(255, 255, 255));
        RawItemJbarHeightUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Meters", "Centimeters", "Millimeters", "Inches", "Feets" }));
        JBarPnl.add(RawItemJbarHeightUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 130, 120, -1));

        jLabel184.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel184.setForeground(new java.awt.Color(255, 255, 255));
        jLabel184.setText("Unit");
        JBarPnl.add(jLabel184, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 130, 50, 20));

        jLabel185.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel185.setForeground(new java.awt.Color(255, 255, 255));
        jLabel185.setText("Re-order Level");
        JBarPnl.add(jLabel185, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 140, 20));

        jLabel187.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel187.setForeground(new java.awt.Color(255, 255, 255));
        jLabel187.setText("Unit");
        JBarPnl.add(jLabel187, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, 50, 20));

        RawItemJbarQty.setBackground(new java.awt.Color(102, 102, 102));
        RawItemJbarQty.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemJbarQty.setForeground(new java.awt.Color(255, 255, 255));
        RawItemJbarQty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemJbarQtyKeyTyped(evt);
            }
        });
        JBarPnl.add(RawItemJbarQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 260, -1));

        jLabel438.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel438.setForeground(new java.awt.Color(255, 255, 255));
        jLabel438.setText("Item Cost");
        JBarPnl.add(jLabel438, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 120, 20));

        RawItemJbarCost.setBackground(new java.awt.Color(102, 102, 102));
        RawItemJbarCost.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemJbarCost.setForeground(new java.awt.Color(255, 255, 255));
        RawItemJbarCost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemJbarCostKeyTyped(evt);
            }
        });
        JBarPnl.add(RawItemJbarCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, 260, -1));

        CatPanel2.add(JBarPnl, "card4");

        UChannelBeadingPnl.setBackground(new java.awt.Color(0, 0, 0));
        UChannelBeadingPnl.setOpaque(false);
        UChannelBeadingPnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel250.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel250.setForeground(new java.awt.Color(255, 255, 255));
        jLabel250.setText("Length");
        UChannelBeadingPnl.add(jLabel250, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 80, 20));

        jLabel288.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel288.setForeground(new java.awt.Color(255, 255, 255));
        jLabel288.setText("Quantity");
        UChannelBeadingPnl.add(jLabel288, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 90, 20));

        jLabel433.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel433.setForeground(new java.awt.Color(255, 255, 255));
        jLabel433.setText("GRN Number");
        UChannelBeadingPnl.add(jLabel433, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 120, 20));

        RawItemUCBLength.setBackground(new java.awt.Color(102, 102, 102));
        RawItemUCBLength.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemUCBLength.setForeground(new java.awt.Color(255, 255, 255));
        RawItemUCBLength.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RawItemUCBLengthActionPerformed(evt);
            }
        });
        RawItemUCBLength.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemUCBLengthKeyTyped(evt);
            }
        });
        UChannelBeadingPnl.add(RawItemUCBLength, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 260, -1));

        RawItemUCBROL.setBackground(new java.awt.Color(102, 102, 102));
        RawItemUCBROL.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemUCBROL.setForeground(new java.awt.Color(255, 255, 255));
        RawItemUCBROL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemUCBROLKeyTyped(evt);
            }
        });
        UChannelBeadingPnl.add(RawItemUCBROL, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 260, -1));

        RawItemUCBGRN.setBackground(new java.awt.Color(102, 102, 102));
        RawItemUCBGRN.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemUCBGRN.setForeground(new java.awt.Color(255, 255, 255));
        UChannelBeadingPnl.add(RawItemUCBGRN, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 260, -1));

        jLabel188.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel188.setForeground(new java.awt.Color(255, 255, 255));
        jLabel188.setText("Unit");
        UChannelBeadingPnl.add(jLabel188, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 50, 20));

        RawItemUCBLengthUnit.setBackground(new java.awt.Color(102, 102, 102));
        RawItemUCBLengthUnit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemUCBLengthUnit.setForeground(new java.awt.Color(255, 255, 255));
        RawItemUCBLengthUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Meters", "Centimeters", "Millimeters", "Inches", "Feets" }));
        UChannelBeadingPnl.add(RawItemUCBLengthUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 120, -1));

        jLabel191.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel191.setForeground(new java.awt.Color(255, 255, 255));
        jLabel191.setText("Re-order Level");
        UChannelBeadingPnl.add(jLabel191, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 140, 20));

        RawItemUCBQty.setBackground(new java.awt.Color(102, 102, 102));
        RawItemUCBQty.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemUCBQty.setForeground(new java.awt.Color(255, 255, 255));
        RawItemUCBQty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemUCBQtyKeyTyped(evt);
            }
        });
        UChannelBeadingPnl.add(RawItemUCBQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 260, -1));

        jLabel439.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel439.setForeground(new java.awt.Color(255, 255, 255));
        jLabel439.setText("Item Cost");
        UChannelBeadingPnl.add(jLabel439, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 120, 20));

        RawItemUCBCost.setBackground(new java.awt.Color(102, 102, 102));
        RawItemUCBCost.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemUCBCost.setForeground(new java.awt.Color(255, 255, 255));
        RawItemUCBCost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemUCBCostKeyTyped(evt);
            }
        });
        UChannelBeadingPnl.add(RawItemUCBCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 260, -1));

        CatPanel2.add(UChannelBeadingPnl, "card5");

        BottomBeadingPnl.setBackground(new java.awt.Color(0, 0, 0));
        BottomBeadingPnl.setOpaque(false);
        BottomBeadingPnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel251.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel251.setForeground(new java.awt.Color(255, 255, 255));
        jLabel251.setText("Length");
        BottomBeadingPnl.add(jLabel251, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 80, 20));

        jLabel289.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel289.setForeground(new java.awt.Color(255, 255, 255));
        jLabel289.setText("Quantity");
        BottomBeadingPnl.add(jLabel289, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 90, 20));

        jLabel434.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel434.setForeground(new java.awt.Color(255, 255, 255));
        jLabel434.setText("GRN Number");
        BottomBeadingPnl.add(jLabel434, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 120, 20));

        RawItemBottomBleedingLength.setBackground(new java.awt.Color(102, 102, 102));
        RawItemBottomBleedingLength.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemBottomBleedingLength.setForeground(new java.awt.Color(255, 255, 255));
        RawItemBottomBleedingLength.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RawItemBottomBleedingLengthActionPerformed(evt);
            }
        });
        RawItemBottomBleedingLength.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemBottomBleedingLengthKeyTyped(evt);
            }
        });
        BottomBeadingPnl.add(RawItemBottomBleedingLength, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 260, -1));

        RawItemBottomBleedingROL.setBackground(new java.awt.Color(102, 102, 102));
        RawItemBottomBleedingROL.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemBottomBleedingROL.setForeground(new java.awt.Color(255, 255, 255));
        RawItemBottomBleedingROL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemBottomBleedingROLKeyTyped(evt);
            }
        });
        BottomBeadingPnl.add(RawItemBottomBleedingROL, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 260, -1));

        RawItemBottomBleedingGRN.setBackground(new java.awt.Color(102, 102, 102));
        RawItemBottomBleedingGRN.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemBottomBleedingGRN.setForeground(new java.awt.Color(255, 255, 255));
        RawItemBottomBleedingGRN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemBottomBleedingGRNKeyTyped(evt);
            }
        });
        BottomBeadingPnl.add(RawItemBottomBleedingGRN, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 260, -1));

        jLabel189.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel189.setForeground(new java.awt.Color(255, 255, 255));
        jLabel189.setText("Unit");
        BottomBeadingPnl.add(jLabel189, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 50, 20));

        RawItemBottomBleedingLengthUnit.setBackground(new java.awt.Color(102, 102, 102));
        RawItemBottomBleedingLengthUnit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemBottomBleedingLengthUnit.setForeground(new java.awt.Color(255, 255, 255));
        RawItemBottomBleedingLengthUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Meters", "Centimeters", "Millimeters", "Inches", "Feets" }));
        BottomBeadingPnl.add(RawItemBottomBleedingLengthUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 120, -1));

        jLabel192.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel192.setForeground(new java.awt.Color(255, 255, 255));
        jLabel192.setText("Re-order Level");
        BottomBeadingPnl.add(jLabel192, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 140, 20));

        RawItemBottomBleedingQty.setBackground(new java.awt.Color(102, 102, 102));
        RawItemBottomBleedingQty.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemBottomBleedingQty.setForeground(new java.awt.Color(255, 255, 255));
        RawItemBottomBleedingQty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemBottomBleedingQtyKeyTyped(evt);
            }
        });
        BottomBeadingPnl.add(RawItemBottomBleedingQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 260, -1));

        jLabel440.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel440.setForeground(new java.awt.Color(255, 255, 255));
        jLabel440.setText("Item Cost");
        BottomBeadingPnl.add(jLabel440, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 120, 20));

        RawItemBottomBleedingCost.setBackground(new java.awt.Color(102, 102, 102));
        RawItemBottomBleedingCost.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemBottomBleedingCost.setForeground(new java.awt.Color(255, 255, 255));
        RawItemBottomBleedingCost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemBottomBleedingCostKeyTyped(evt);
            }
        });
        BottomBeadingPnl.add(RawItemBottomBleedingCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 260, -1));

        CatPanel2.add(BottomBeadingPnl, "card6");

        SideBeadingPnl.setBackground(new java.awt.Color(0, 0, 0));
        SideBeadingPnl.setOpaque(false);
        SideBeadingPnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel252.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel252.setForeground(new java.awt.Color(255, 255, 255));
        jLabel252.setText("Length");
        SideBeadingPnl.add(jLabel252, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 80, 20));

        jLabel290.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel290.setForeground(new java.awt.Color(255, 255, 255));
        jLabel290.setText("Quantity");
        SideBeadingPnl.add(jLabel290, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 90, 20));

        jLabel435.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel435.setForeground(new java.awt.Color(255, 255, 255));
        jLabel435.setText("GRN Number");
        SideBeadingPnl.add(jLabel435, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 120, 20));

        RawItemSideBleedingLength.setBackground(new java.awt.Color(102, 102, 102));
        RawItemSideBleedingLength.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemSideBleedingLength.setForeground(new java.awt.Color(255, 255, 255));
        RawItemSideBleedingLength.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RawItemSideBleedingLengthActionPerformed(evt);
            }
        });
        RawItemSideBleedingLength.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemSideBleedingLengthKeyTyped(evt);
            }
        });
        SideBeadingPnl.add(RawItemSideBleedingLength, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 260, -1));

        RawItemSideBleedingROL.setBackground(new java.awt.Color(102, 102, 102));
        RawItemSideBleedingROL.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemSideBleedingROL.setForeground(new java.awt.Color(255, 255, 255));
        RawItemSideBleedingROL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemSideBleedingROLKeyTyped(evt);
            }
        });
        SideBeadingPnl.add(RawItemSideBleedingROL, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 260, -1));

        RawItemSideBleedingGRN.setBackground(new java.awt.Color(102, 102, 102));
        RawItemSideBleedingGRN.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemSideBleedingGRN.setForeground(new java.awt.Color(255, 255, 255));
        SideBeadingPnl.add(RawItemSideBleedingGRN, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 260, -1));

        jLabel190.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel190.setForeground(new java.awt.Color(255, 255, 255));
        jLabel190.setText("Unit");
        SideBeadingPnl.add(jLabel190, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 50, 20));

        RawItemSideBleedingLengthUnit.setBackground(new java.awt.Color(102, 102, 102));
        RawItemSideBleedingLengthUnit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemSideBleedingLengthUnit.setForeground(new java.awt.Color(255, 255, 255));
        RawItemSideBleedingLengthUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Meters", "Centimeters", "Millimeters", "Inches", "Feets" }));
        SideBeadingPnl.add(RawItemSideBleedingLengthUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 120, -1));

        jLabel193.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel193.setForeground(new java.awt.Color(255, 255, 255));
        jLabel193.setText("Re-order Level");
        SideBeadingPnl.add(jLabel193, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 140, 20));

        RawItemSideBleedingQty.setBackground(new java.awt.Color(102, 102, 102));
        RawItemSideBleedingQty.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemSideBleedingQty.setForeground(new java.awt.Color(255, 255, 255));
        RawItemSideBleedingQty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemSideBleedingQtyKeyTyped(evt);
            }
        });
        SideBeadingPnl.add(RawItemSideBleedingQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 260, -1));

        jLabel441.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel441.setForeground(new java.awt.Color(255, 255, 255));
        jLabel441.setText("Item Cost");
        SideBeadingPnl.add(jLabel441, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 120, 20));

        RawItemSideBleedingCost.setBackground(new java.awt.Color(102, 102, 102));
        RawItemSideBleedingCost.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemSideBleedingCost.setForeground(new java.awt.Color(255, 255, 255));
        RawItemSideBleedingCost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemSideBleedingCostKeyTyped(evt);
            }
        });
        SideBeadingPnl.add(RawItemSideBleedingCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 260, -1));

        CatPanel2.add(SideBeadingPnl, "card7");

        AluminiumBottomBarPnl.setBackground(new java.awt.Color(0, 0, 0));
        AluminiumBottomBarPnl.setOpaque(false);
        AluminiumBottomBarPnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel253.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel253.setForeground(new java.awt.Color(255, 255, 255));
        jLabel253.setText("Length");
        AluminiumBottomBarPnl.add(jLabel253, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 80, 20));

        jLabel285.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel285.setForeground(new java.awt.Color(255, 255, 255));
        jLabel285.setText("Width");
        AluminiumBottomBarPnl.add(jLabel285, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 70, 20));

        jLabel286.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel286.setForeground(new java.awt.Color(255, 255, 255));
        jLabel286.setText("Height");
        AluminiumBottomBarPnl.add(jLabel286, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 80, 20));

        jLabel287.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel287.setForeground(new java.awt.Color(255, 255, 255));
        jLabel287.setText("Thickness");
        AluminiumBottomBarPnl.add(jLabel287, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 100, 20));

        jLabel291.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel291.setForeground(new java.awt.Color(255, 255, 255));
        jLabel291.setText("Quantity");
        AluminiumBottomBarPnl.add(jLabel291, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 90, 20));

        jLabel311.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel311.setForeground(new java.awt.Color(255, 255, 255));
        jLabel311.setText("GRN Number");
        AluminiumBottomBarPnl.add(jLabel311, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 120, 20));

        RawItemABBarThickness.setBackground(new java.awt.Color(102, 102, 102));
        RawItemABBarThickness.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemABBarThickness.setForeground(new java.awt.Color(255, 255, 255));
        RawItemABBarThickness.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemABBarThicknessKeyTyped(evt);
            }
        });
        AluminiumBottomBarPnl.add(RawItemABBarThickness, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 260, -1));

        RawItemABBarHeight.setBackground(new java.awt.Color(102, 102, 102));
        RawItemABBarHeight.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemABBarHeight.setForeground(new java.awt.Color(255, 255, 255));
        RawItemABBarHeight.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemABBarHeightKeyTyped(evt);
            }
        });
        AluminiumBottomBarPnl.add(RawItemABBarHeight, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 260, -1));

        RawItemABBarWidth.setBackground(new java.awt.Color(102, 102, 102));
        RawItemABBarWidth.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemABBarWidth.setForeground(new java.awt.Color(255, 255, 255));
        RawItemABBarWidth.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemABBarWidthKeyTyped(evt);
            }
        });
        AluminiumBottomBarPnl.add(RawItemABBarWidth, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 260, -1));

        RawItemABBarLength.setBackground(new java.awt.Color(102, 102, 102));
        RawItemABBarLength.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemABBarLength.setForeground(new java.awt.Color(255, 255, 255));
        RawItemABBarLength.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RawItemABBarLengthActionPerformed(evt);
            }
        });
        RawItemABBarLength.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemABBarLengthKeyTyped(evt);
            }
        });
        AluminiumBottomBarPnl.add(RawItemABBarLength, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 260, -1));

        RawItemABBarROL.setBackground(new java.awt.Color(102, 102, 102));
        RawItemABBarROL.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemABBarROL.setForeground(new java.awt.Color(255, 255, 255));
        RawItemABBarROL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemABBarROLKeyTyped(evt);
            }
        });
        AluminiumBottomBarPnl.add(RawItemABBarROL, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 260, -1));

        RawItemABBarGRN.setBackground(new java.awt.Color(102, 102, 102));
        RawItemABBarGRN.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemABBarGRN.setForeground(new java.awt.Color(255, 255, 255));
        AluminiumBottomBarPnl.add(RawItemABBarGRN, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 260, -1));

        jLabel194.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel194.setForeground(new java.awt.Color(255, 255, 255));
        jLabel194.setText("Unit");
        AluminiumBottomBarPnl.add(jLabel194, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 50, 20));

        RawItemABBarWidthUnit.setBackground(new java.awt.Color(102, 102, 102));
        RawItemABBarWidthUnit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemABBarWidthUnit.setForeground(new java.awt.Color(255, 255, 255));
        RawItemABBarWidthUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Meters", "Centimeters", "Millimeters", "Inches", "Feets" }));
        AluminiumBottomBarPnl.add(RawItemABBarWidthUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 50, 120, -1));

        jLabel195.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel195.setForeground(new java.awt.Color(255, 255, 255));
        jLabel195.setText("Unit");
        AluminiumBottomBarPnl.add(jLabel195, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, 50, 20));

        RawItemABBarLengthUnit.setBackground(new java.awt.Color(102, 102, 102));
        RawItemABBarLengthUnit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemABBarLengthUnit.setForeground(new java.awt.Color(255, 255, 255));
        RawItemABBarLengthUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Meters", "Centimeters", "Millimeters", "Inches", "Feets" }));
        AluminiumBottomBarPnl.add(RawItemABBarLengthUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 120, -1));

        RawItemABBarThicknessUnit.setBackground(new java.awt.Color(102, 102, 102));
        RawItemABBarThicknessUnit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemABBarThicknessUnit.setForeground(new java.awt.Color(255, 255, 255));
        RawItemABBarThicknessUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Meters", "Centimeters", "Millimeters", "Inches", "Feets" }));
        AluminiumBottomBarPnl.add(RawItemABBarThicknessUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 130, 120, -1));

        RawItemABBarHeightUnit.setBackground(new java.awt.Color(102, 102, 102));
        RawItemABBarHeightUnit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemABBarHeightUnit.setForeground(new java.awt.Color(255, 255, 255));
        RawItemABBarHeightUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Meters", "Centimeters", "Millimeters", "Inches", "Feets" }));
        AluminiumBottomBarPnl.add(RawItemABBarHeightUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, 120, -1));

        jLabel197.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel197.setForeground(new java.awt.Color(255, 255, 255));
        jLabel197.setText("Unit");
        AluminiumBottomBarPnl.add(jLabel197, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, 50, 20));

        jLabel198.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel198.setForeground(new java.awt.Color(255, 255, 255));
        jLabel198.setText("Re-order Level");
        AluminiumBottomBarPnl.add(jLabel198, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 140, 20));

        jLabel199.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel199.setForeground(new java.awt.Color(255, 255, 255));
        jLabel199.setText("Unit");
        AluminiumBottomBarPnl.add(jLabel199, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 130, 50, 20));

        RawItemABBarQty.setBackground(new java.awt.Color(102, 102, 102));
        RawItemABBarQty.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemABBarQty.setForeground(new java.awt.Color(255, 255, 255));
        RawItemABBarQty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemABBarQtyKeyTyped(evt);
            }
        });
        AluminiumBottomBarPnl.add(RawItemABBarQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 260, -1));

        jLabel442.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel442.setForeground(new java.awt.Color(255, 255, 255));
        jLabel442.setText("Item Cost");
        AluminiumBottomBarPnl.add(jLabel442, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 120, 20));

        RawItemABBarCost.setBackground(new java.awt.Color(102, 102, 102));
        RawItemABBarCost.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemABBarCost.setForeground(new java.awt.Color(255, 255, 255));
        RawItemABBarCost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemABBarCostKeyTyped(evt);
            }
        });
        AluminiumBottomBarPnl.add(RawItemABBarCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 260, -1));

        CatPanel2.add(AluminiumBottomBarPnl, "card8");

        PulleyPnl.setBackground(new java.awt.Color(0, 0, 0));
        PulleyPnl.setOpaque(false);
        PulleyPnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel254.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel254.setForeground(new java.awt.Color(255, 255, 255));
        jLabel254.setText("Length");
        PulleyPnl.add(jLabel254, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 80, 20));

        jLabel292.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel292.setForeground(new java.awt.Color(255, 255, 255));
        jLabel292.setText("Width");
        PulleyPnl.add(jLabel292, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 70, 20));

        jLabel293.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel293.setForeground(new java.awt.Color(255, 255, 255));
        jLabel293.setText("Height");
        PulleyPnl.add(jLabel293, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 80, 20));

        jLabel294.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel294.setForeground(new java.awt.Color(255, 255, 255));
        jLabel294.setText("Thickness");
        PulleyPnl.add(jLabel294, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 100, 20));

        jLabel295.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel295.setForeground(new java.awt.Color(255, 255, 255));
        jLabel295.setText("Quantity");
        PulleyPnl.add(jLabel295, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 90, 20));

        jLabel312.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel312.setForeground(new java.awt.Color(255, 255, 255));
        jLabel312.setText("GRN Number");
        PulleyPnl.add(jLabel312, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 120, 20));

        RawItemPulleyThickness.setBackground(new java.awt.Color(102, 102, 102));
        RawItemPulleyThickness.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemPulleyThickness.setForeground(new java.awt.Color(255, 255, 255));
        RawItemPulleyThickness.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemPulleyThicknessKeyTyped(evt);
            }
        });
        PulleyPnl.add(RawItemPulleyThickness, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 260, -1));

        RawItemPulleyHeight.setBackground(new java.awt.Color(102, 102, 102));
        RawItemPulleyHeight.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemPulleyHeight.setForeground(new java.awt.Color(255, 255, 255));
        RawItemPulleyHeight.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemPulleyHeightKeyTyped(evt);
            }
        });
        PulleyPnl.add(RawItemPulleyHeight, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 260, -1));

        RawItemPulleyWidth.setBackground(new java.awt.Color(102, 102, 102));
        RawItemPulleyWidth.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemPulleyWidth.setForeground(new java.awt.Color(255, 255, 255));
        RawItemPulleyWidth.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemPulleyWidthKeyTyped(evt);
            }
        });
        PulleyPnl.add(RawItemPulleyWidth, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 260, -1));

        RawItemPulleyLength.setBackground(new java.awt.Color(102, 102, 102));
        RawItemPulleyLength.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemPulleyLength.setForeground(new java.awt.Color(255, 255, 255));
        RawItemPulleyLength.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RawItemPulleyLengthActionPerformed(evt);
            }
        });
        RawItemPulleyLength.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemPulleyLengthKeyTyped(evt);
            }
        });
        PulleyPnl.add(RawItemPulleyLength, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 260, -1));

        RawItemPulleyROL.setBackground(new java.awt.Color(102, 102, 102));
        RawItemPulleyROL.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemPulleyROL.setForeground(new java.awt.Color(255, 255, 255));
        RawItemPulleyROL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemPulleyROLKeyTyped(evt);
            }
        });
        PulleyPnl.add(RawItemPulleyROL, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 260, -1));

        RawItemPulleyGRN.setBackground(new java.awt.Color(102, 102, 102));
        RawItemPulleyGRN.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemPulleyGRN.setForeground(new java.awt.Color(255, 255, 255));
        RawItemPulleyGRN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemPulleyGRNKeyTyped(evt);
            }
        });
        PulleyPnl.add(RawItemPulleyGRN, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 260, -1));

        jLabel200.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel200.setForeground(new java.awt.Color(255, 255, 255));
        jLabel200.setText("Unit");
        PulleyPnl.add(jLabel200, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 50, 20));

        RawItemPulleyWidthUnit.setBackground(new java.awt.Color(102, 102, 102));
        RawItemPulleyWidthUnit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemPulleyWidthUnit.setForeground(new java.awt.Color(255, 255, 255));
        RawItemPulleyWidthUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Meters", "Centimeters", "Millimeters", "Inches", "Feets" }));
        PulleyPnl.add(RawItemPulleyWidthUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 50, 120, -1));

        jLabel201.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel201.setForeground(new java.awt.Color(255, 255, 255));
        jLabel201.setText("Unit");
        PulleyPnl.add(jLabel201, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, 50, 20));

        RawItemPulleyLengthUnit.setBackground(new java.awt.Color(102, 102, 102));
        RawItemPulleyLengthUnit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemPulleyLengthUnit.setForeground(new java.awt.Color(255, 255, 255));
        RawItemPulleyLengthUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Meters", "Centimeters", "Millimeters", "Inches", "Feets" }));
        PulleyPnl.add(RawItemPulleyLengthUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 120, -1));

        RawItemPulleyThicknessUnit.setBackground(new java.awt.Color(102, 102, 102));
        RawItemPulleyThicknessUnit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemPulleyThicknessUnit.setForeground(new java.awt.Color(255, 255, 255));
        RawItemPulleyThicknessUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Meters", "Centimeters", "Millimeters", "Inches", "Feets" }));
        PulleyPnl.add(RawItemPulleyThicknessUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 130, 120, -1));

        RawItemPulleyHeightUnit.setBackground(new java.awt.Color(102, 102, 102));
        RawItemPulleyHeightUnit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemPulleyHeightUnit.setForeground(new java.awt.Color(255, 255, 255));
        RawItemPulleyHeightUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Meters", "Centimeters", "Millimeters", "Inches", "Feets" }));
        PulleyPnl.add(RawItemPulleyHeightUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, 120, -1));

        jLabel202.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel202.setForeground(new java.awt.Color(255, 255, 255));
        jLabel202.setText("Unit");
        PulleyPnl.add(jLabel202, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, 50, 20));

        jLabel203.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel203.setForeground(new java.awt.Color(255, 255, 255));
        jLabel203.setText("Re-order Level");
        PulleyPnl.add(jLabel203, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 140, 20));

        jLabel204.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel204.setForeground(new java.awt.Color(255, 255, 255));
        jLabel204.setText("Unit");
        PulleyPnl.add(jLabel204, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 130, 50, 20));

        RawItemPulleyQty.setBackground(new java.awt.Color(102, 102, 102));
        RawItemPulleyQty.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemPulleyQty.setForeground(new java.awt.Color(255, 255, 255));
        RawItemPulleyQty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemPulleyQtyKeyTyped(evt);
            }
        });
        PulleyPnl.add(RawItemPulleyQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 260, -1));

        jLabel443.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel443.setForeground(new java.awt.Color(255, 255, 255));
        jLabel443.setText("Item Cost");
        PulleyPnl.add(jLabel443, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 120, 20));

        RawItemPulleyCost.setBackground(new java.awt.Color(102, 102, 102));
        RawItemPulleyCost.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemPulleyCost.setForeground(new java.awt.Color(255, 255, 255));
        RawItemPulleyCost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemPulleyCostKeyTyped(evt);
            }
        });
        PulleyPnl.add(RawItemPulleyCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 260, -1));

        CatPanel2.add(PulleyPnl, "card9");

        SpringPnl.setBackground(new java.awt.Color(0, 0, 0));
        SpringPnl.setOpaque(false);
        SpringPnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel255.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel255.setForeground(new java.awt.Color(255, 255, 255));
        jLabel255.setText("Length");
        SpringPnl.add(jLabel255, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 80, 20));

        jLabel298.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel298.setForeground(new java.awt.Color(255, 255, 255));
        jLabel298.setText("Thickness");
        SpringPnl.add(jLabel298, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 100, 20));

        jLabel299.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel299.setForeground(new java.awt.Color(255, 255, 255));
        jLabel299.setText("Quantity");
        SpringPnl.add(jLabel299, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 90, 20));

        jLabel313.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel313.setForeground(new java.awt.Color(255, 255, 255));
        jLabel313.setText("GRN Number");
        SpringPnl.add(jLabel313, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 120, 20));

        RawItemSpirngThickenss.setBackground(new java.awt.Color(102, 102, 102));
        RawItemSpirngThickenss.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemSpirngThickenss.setForeground(new java.awt.Color(255, 255, 255));
        RawItemSpirngThickenss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RawItemSpirngThickenssActionPerformed(evt);
            }
        });
        RawItemSpirngThickenss.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemSpirngThickenssKeyTyped(evt);
            }
        });
        SpringPnl.add(RawItemSpirngThickenss, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 260, -1));

        RawItemSpirngLength.setBackground(new java.awt.Color(102, 102, 102));
        RawItemSpirngLength.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemSpirngLength.setForeground(new java.awt.Color(255, 255, 255));
        RawItemSpirngLength.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RawItemSpirngLengthActionPerformed(evt);
            }
        });
        RawItemSpirngLength.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemSpirngLengthKeyTyped(evt);
            }
        });
        SpringPnl.add(RawItemSpirngLength, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 260, -1));

        RawItemSpirngROL.setBackground(new java.awt.Color(102, 102, 102));
        RawItemSpirngROL.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemSpirngROL.setForeground(new java.awt.Color(255, 255, 255));
        RawItemSpirngROL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemSpirngROLKeyTyped(evt);
            }
        });
        SpringPnl.add(RawItemSpirngROL, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 260, -1));

        RawItemSpirngGRN.setBackground(new java.awt.Color(102, 102, 102));
        RawItemSpirngGRN.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemSpirngGRN.setForeground(new java.awt.Color(255, 255, 255));
        SpringPnl.add(RawItemSpirngGRN, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 260, -1));

        jLabel205.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel205.setForeground(new java.awt.Color(255, 255, 255));
        jLabel205.setText("Unit");
        SpringPnl.add(jLabel205, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 50, 20));

        RawItemSpirngLengthUnit.setBackground(new java.awt.Color(102, 102, 102));
        RawItemSpirngLengthUnit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemSpirngLengthUnit.setForeground(new java.awt.Color(255, 255, 255));
        RawItemSpirngLengthUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Meters", "Centimeters", "Millimeters", "Inches", "Feets" }));
        SpringPnl.add(RawItemSpirngLengthUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 120, -1));

        RawItemSpirngThicknessUnit.setBackground(new java.awt.Color(102, 102, 102));
        RawItemSpirngThicknessUnit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemSpirngThicknessUnit.setForeground(new java.awt.Color(255, 255, 255));
        RawItemSpirngThicknessUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Meters", "Centimeters", "Millimeters", "Inches", "Feets" }));
        SpringPnl.add(RawItemSpirngThicknessUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 50, 120, -1));

        jLabel209.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel209.setForeground(new java.awt.Color(255, 255, 255));
        jLabel209.setText("Re-order Level");
        SpringPnl.add(jLabel209, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 140, 20));

        jLabel210.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel210.setForeground(new java.awt.Color(255, 255, 255));
        jLabel210.setText("Unit");
        SpringPnl.add(jLabel210, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, 50, 20));

        RawItemSpirngQty.setBackground(new java.awt.Color(102, 102, 102));
        RawItemSpirngQty.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemSpirngQty.setForeground(new java.awt.Color(255, 255, 255));
        RawItemSpirngQty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemSpirngQtyKeyTyped(evt);
            }
        });
        SpringPnl.add(RawItemSpirngQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 260, -1));

        jLabel444.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel444.setForeground(new java.awt.Color(255, 255, 255));
        jLabel444.setText("Item Cost");
        SpringPnl.add(jLabel444, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 120, 20));

        RawItemSpirngCost.setBackground(new java.awt.Color(102, 102, 102));
        RawItemSpirngCost.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemSpirngCost.setForeground(new java.awt.Color(255, 255, 255));
        RawItemSpirngCost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemSpirngCostKeyTyped(evt);
            }
        });
        SpringPnl.add(RawItemSpirngCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 260, -1));

        CatPanel2.add(SpringPnl, "card11");

        DownLockPnl.setBackground(new java.awt.Color(0, 0, 0));
        DownLockPnl.setOpaque(false);
        DownLockPnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel296.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel296.setForeground(new java.awt.Color(255, 255, 255));
        jLabel296.setText("Length");
        DownLockPnl.add(jLabel296, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 80, 20));

        jLabel297.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel297.setForeground(new java.awt.Color(255, 255, 255));
        jLabel297.setText("Width");
        DownLockPnl.add(jLabel297, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 70, 20));

        jLabel300.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel300.setForeground(new java.awt.Color(255, 255, 255));
        jLabel300.setText("Height");
        DownLockPnl.add(jLabel300, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 80, 20));

        jLabel302.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel302.setForeground(new java.awt.Color(255, 255, 255));
        jLabel302.setText("Quantity");
        DownLockPnl.add(jLabel302, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 90, 20));

        jLabel314.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel314.setForeground(new java.awt.Color(255, 255, 255));
        jLabel314.setText("GRN Number");
        DownLockPnl.add(jLabel314, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 120, 20));

        RawItemDownLockHeight.setBackground(new java.awt.Color(102, 102, 102));
        RawItemDownLockHeight.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemDownLockHeight.setForeground(new java.awt.Color(255, 255, 255));
        RawItemDownLockHeight.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemDownLockHeightKeyTyped(evt);
            }
        });
        DownLockPnl.add(RawItemDownLockHeight, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 260, -1));

        RawItemDownLockWidth.setBackground(new java.awt.Color(102, 102, 102));
        RawItemDownLockWidth.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemDownLockWidth.setForeground(new java.awt.Color(255, 255, 255));
        RawItemDownLockWidth.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemDownLockWidthKeyTyped(evt);
            }
        });
        DownLockPnl.add(RawItemDownLockWidth, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 260, -1));

        RawItemDownLockLength.setBackground(new java.awt.Color(102, 102, 102));
        RawItemDownLockLength.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemDownLockLength.setForeground(new java.awt.Color(255, 255, 255));
        RawItemDownLockLength.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RawItemDownLockLengthActionPerformed(evt);
            }
        });
        RawItemDownLockLength.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemDownLockLengthKeyTyped(evt);
            }
        });
        DownLockPnl.add(RawItemDownLockLength, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 260, -1));

        RawItemDownLockROL.setBackground(new java.awt.Color(102, 102, 102));
        RawItemDownLockROL.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemDownLockROL.setForeground(new java.awt.Color(255, 255, 255));
        RawItemDownLockROL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemDownLockROLKeyTyped(evt);
            }
        });
        DownLockPnl.add(RawItemDownLockROL, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 260, -1));

        RawItemDownLockGRN.setBackground(new java.awt.Color(102, 102, 102));
        RawItemDownLockGRN.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemDownLockGRN.setForeground(new java.awt.Color(255, 255, 255));
        DownLockPnl.add(RawItemDownLockGRN, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 260, -1));

        jLabel207.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel207.setForeground(new java.awt.Color(255, 255, 255));
        jLabel207.setText("Unit");
        DownLockPnl.add(jLabel207, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 50, 20));

        RawItemDownLockWidthUnit.setBackground(new java.awt.Color(102, 102, 102));
        RawItemDownLockWidthUnit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemDownLockWidthUnit.setForeground(new java.awt.Color(255, 255, 255));
        RawItemDownLockWidthUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Meters", "Centimeters", "Millimeters", "Inches", "Feets" }));
        DownLockPnl.add(RawItemDownLockWidthUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 50, 120, -1));

        jLabel208.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel208.setForeground(new java.awt.Color(255, 255, 255));
        jLabel208.setText("Unit");
        DownLockPnl.add(jLabel208, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, 50, 20));

        RawItemDownLockLengthUnit.setBackground(new java.awt.Color(102, 102, 102));
        RawItemDownLockLengthUnit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemDownLockLengthUnit.setForeground(new java.awt.Color(255, 255, 255));
        RawItemDownLockLengthUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Meters", "Centimeters", "Millimeters", "Inches", "Feets" }));
        DownLockPnl.add(RawItemDownLockLengthUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 120, -1));

        RawItemDownLockHeightUnit.setBackground(new java.awt.Color(102, 102, 102));
        RawItemDownLockHeightUnit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemDownLockHeightUnit.setForeground(new java.awt.Color(255, 255, 255));
        RawItemDownLockHeightUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Meters", "Centimeters", "Millimeters", "Inches", "Feets" }));
        DownLockPnl.add(RawItemDownLockHeightUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, 120, -1));

        jLabel211.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel211.setForeground(new java.awt.Color(255, 255, 255));
        jLabel211.setText("Unit");
        DownLockPnl.add(jLabel211, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, 50, 20));

        jLabel212.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel212.setForeground(new java.awt.Color(255, 255, 255));
        jLabel212.setText("Re-order Level");
        DownLockPnl.add(jLabel212, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 140, 20));

        RawItemDownLockQty.setBackground(new java.awt.Color(102, 102, 102));
        RawItemDownLockQty.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemDownLockQty.setForeground(new java.awt.Color(255, 255, 255));
        RawItemDownLockQty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemDownLockQtyKeyTyped(evt);
            }
        });
        DownLockPnl.add(RawItemDownLockQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 260, -1));

        jLabel445.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel445.setForeground(new java.awt.Color(255, 255, 255));
        jLabel445.setText("Item Cost");
        DownLockPnl.add(jLabel445, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 120, 20));

        RawItemDownLockCost.setBackground(new java.awt.Color(102, 102, 102));
        RawItemDownLockCost.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemDownLockCost.setForeground(new java.awt.Color(255, 255, 255));
        RawItemDownLockCost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemDownLockCostKeyTyped(evt);
            }
        });
        DownLockPnl.add(RawItemDownLockCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 260, -1));

        CatPanel2.add(DownLockPnl, "card11");

        SideLockPnl.setBackground(new java.awt.Color(0, 0, 0));
        SideLockPnl.setOpaque(false);
        SideLockPnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel301.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel301.setForeground(new java.awt.Color(255, 255, 255));
        jLabel301.setText("Length");
        SideLockPnl.add(jLabel301, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 80, 20));

        jLabel303.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel303.setForeground(new java.awt.Color(255, 255, 255));
        jLabel303.setText("Width");
        SideLockPnl.add(jLabel303, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 70, 20));

        jLabel304.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel304.setForeground(new java.awt.Color(255, 255, 255));
        jLabel304.setText("Height");
        SideLockPnl.add(jLabel304, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 80, 20));

        jLabel305.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel305.setForeground(new java.awt.Color(255, 255, 255));
        jLabel305.setText("Quantity");
        SideLockPnl.add(jLabel305, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 90, 20));

        jLabel315.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel315.setForeground(new java.awt.Color(255, 255, 255));
        jLabel315.setText("GRN Number");
        SideLockPnl.add(jLabel315, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 120, 20));

        RawItemSideLockHeight.setBackground(new java.awt.Color(102, 102, 102));
        RawItemSideLockHeight.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemSideLockHeight.setForeground(new java.awt.Color(255, 255, 255));
        RawItemSideLockHeight.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemSideLockHeightKeyTyped(evt);
            }
        });
        SideLockPnl.add(RawItemSideLockHeight, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 260, -1));

        RawItemSideLockWidth.setBackground(new java.awt.Color(102, 102, 102));
        RawItemSideLockWidth.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemSideLockWidth.setForeground(new java.awt.Color(255, 255, 255));
        RawItemSideLockWidth.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemSideLockWidthKeyTyped(evt);
            }
        });
        SideLockPnl.add(RawItemSideLockWidth, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 260, -1));

        RawItemSideLockLength.setBackground(new java.awt.Color(102, 102, 102));
        RawItemSideLockLength.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemSideLockLength.setForeground(new java.awt.Color(255, 255, 255));
        RawItemSideLockLength.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RawItemSideLockLengthActionPerformed(evt);
            }
        });
        RawItemSideLockLength.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemSideLockLengthKeyTyped(evt);
            }
        });
        SideLockPnl.add(RawItemSideLockLength, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 260, -1));

        RawItemSideLockROL.setBackground(new java.awt.Color(102, 102, 102));
        RawItemSideLockROL.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemSideLockROL.setForeground(new java.awt.Color(255, 255, 255));
        RawItemSideLockROL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemSideLockROLKeyTyped(evt);
            }
        });
        SideLockPnl.add(RawItemSideLockROL, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 260, -1));

        RawItemSideLockGRN.setBackground(new java.awt.Color(102, 102, 102));
        RawItemSideLockGRN.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemSideLockGRN.setForeground(new java.awt.Color(255, 255, 255));
        SideLockPnl.add(RawItemSideLockGRN, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 260, -1));

        jLabel213.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel213.setForeground(new java.awt.Color(255, 255, 255));
        jLabel213.setText("Unit");
        SideLockPnl.add(jLabel213, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 50, 20));

        RawItemSideLockWidthUnit.setBackground(new java.awt.Color(102, 102, 102));
        RawItemSideLockWidthUnit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemSideLockWidthUnit.setForeground(new java.awt.Color(255, 255, 255));
        RawItemSideLockWidthUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Meters", "Centimeters", "Millimeters", "Inches", "Feets" }));
        SideLockPnl.add(RawItemSideLockWidthUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 50, 120, -1));

        jLabel214.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel214.setForeground(new java.awt.Color(255, 255, 255));
        jLabel214.setText("Unit");
        SideLockPnl.add(jLabel214, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, 50, 20));

        RawItemSideLockLengthUnit.setBackground(new java.awt.Color(102, 102, 102));
        RawItemSideLockLengthUnit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemSideLockLengthUnit.setForeground(new java.awt.Color(255, 255, 255));
        RawItemSideLockLengthUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Meters", "Centimeters", "Millimeters", "Inches", "Feets" }));
        SideLockPnl.add(RawItemSideLockLengthUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 120, -1));

        RawItemSideLockHeightUnit.setBackground(new java.awt.Color(102, 102, 102));
        RawItemSideLockHeightUnit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemSideLockHeightUnit.setForeground(new java.awt.Color(255, 255, 255));
        RawItemSideLockHeightUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Meters", "Centimeters", "Millimeters", "Inches", "Feets" }));
        SideLockPnl.add(RawItemSideLockHeightUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, 120, -1));

        jLabel215.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel215.setForeground(new java.awt.Color(255, 255, 255));
        jLabel215.setText("Unit");
        SideLockPnl.add(jLabel215, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, 50, 20));

        jLabel228.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel228.setForeground(new java.awt.Color(255, 255, 255));
        jLabel228.setText("Re-order Level");
        SideLockPnl.add(jLabel228, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 140, 20));

        RawItemSideLockQty.setBackground(new java.awt.Color(102, 102, 102));
        RawItemSideLockQty.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemSideLockQty.setForeground(new java.awt.Color(255, 255, 255));
        RawItemSideLockQty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemSideLockQtyKeyTyped(evt);
            }
        });
        SideLockPnl.add(RawItemSideLockQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 260, -1));

        jLabel446.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel446.setForeground(new java.awt.Color(255, 255, 255));
        jLabel446.setText("Item Cost");
        SideLockPnl.add(jLabel446, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 120, 20));

        RawItemSideLockCost.setBackground(new java.awt.Color(102, 102, 102));
        RawItemSideLockCost.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemSideLockCost.setForeground(new java.awt.Color(255, 255, 255));
        RawItemSideLockCost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemSideLockCostKeyTyped(evt);
            }
        });
        SideLockPnl.add(RawItemSideLockCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 260, -1));

        CatPanel2.add(SideLockPnl, "card11");

        CenterLockPnl.setBackground(new java.awt.Color(0, 0, 0));
        CenterLockPnl.setOpaque(false);
        CenterLockPnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel306.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel306.setForeground(new java.awt.Color(255, 255, 255));
        jLabel306.setText("Length");
        CenterLockPnl.add(jLabel306, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 80, 20));

        jLabel307.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel307.setForeground(new java.awt.Color(255, 255, 255));
        jLabel307.setText("Width");
        CenterLockPnl.add(jLabel307, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 70, 20));

        jLabel308.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel308.setForeground(new java.awt.Color(255, 255, 255));
        jLabel308.setText("Height");
        CenterLockPnl.add(jLabel308, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 80, 20));

        jLabel309.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel309.setForeground(new java.awt.Color(255, 255, 255));
        jLabel309.setText("Quantity");
        CenterLockPnl.add(jLabel309, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 90, 20));

        jLabel316.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel316.setForeground(new java.awt.Color(255, 255, 255));
        jLabel316.setText("GRN Number");
        CenterLockPnl.add(jLabel316, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 120, 20));

        RawItemCenterLockHeight.setBackground(new java.awt.Color(102, 102, 102));
        RawItemCenterLockHeight.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemCenterLockHeight.setForeground(new java.awt.Color(255, 255, 255));
        RawItemCenterLockHeight.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemCenterLockHeightKeyTyped(evt);
            }
        });
        CenterLockPnl.add(RawItemCenterLockHeight, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 260, -1));

        RawItemCenterLockWidth.setBackground(new java.awt.Color(102, 102, 102));
        RawItemCenterLockWidth.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemCenterLockWidth.setForeground(new java.awt.Color(255, 255, 255));
        RawItemCenterLockWidth.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemCenterLockWidthKeyTyped(evt);
            }
        });
        CenterLockPnl.add(RawItemCenterLockWidth, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 260, -1));

        RawItemCenterLockLength.setBackground(new java.awt.Color(102, 102, 102));
        RawItemCenterLockLength.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemCenterLockLength.setForeground(new java.awt.Color(255, 255, 255));
        RawItemCenterLockLength.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RawItemCenterLockLengthActionPerformed(evt);
            }
        });
        RawItemCenterLockLength.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemCenterLockLengthKeyTyped(evt);
            }
        });
        CenterLockPnl.add(RawItemCenterLockLength, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 260, -1));

        RawItemCenterLockROL.setBackground(new java.awt.Color(102, 102, 102));
        RawItemCenterLockROL.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemCenterLockROL.setForeground(new java.awt.Color(255, 255, 255));
        RawItemCenterLockROL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RawItemCenterLockROLActionPerformed(evt);
            }
        });
        RawItemCenterLockROL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemCenterLockROLKeyTyped(evt);
            }
        });
        CenterLockPnl.add(RawItemCenterLockROL, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 260, -1));

        RawItemCenterLockGRN.setBackground(new java.awt.Color(102, 102, 102));
        RawItemCenterLockGRN.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemCenterLockGRN.setForeground(new java.awt.Color(255, 255, 255));
        CenterLockPnl.add(RawItemCenterLockGRN, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 260, -1));

        jLabel230.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel230.setForeground(new java.awt.Color(255, 255, 255));
        jLabel230.setText("Unit");
        CenterLockPnl.add(jLabel230, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 50, 20));

        RawItemCenterLockWidthUnit.setBackground(new java.awt.Color(102, 102, 102));
        RawItemCenterLockWidthUnit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemCenterLockWidthUnit.setForeground(new java.awt.Color(255, 255, 255));
        RawItemCenterLockWidthUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Meters", "Centimeters", "Millimeters", "Inches", "Feets" }));
        CenterLockPnl.add(RawItemCenterLockWidthUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 50, 120, -1));

        jLabel231.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel231.setForeground(new java.awt.Color(255, 255, 255));
        jLabel231.setText("Unit");
        CenterLockPnl.add(jLabel231, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, 50, 20));

        RawItemCenterLockLengthUnit.setBackground(new java.awt.Color(102, 102, 102));
        RawItemCenterLockLengthUnit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemCenterLockLengthUnit.setForeground(new java.awt.Color(255, 255, 255));
        RawItemCenterLockLengthUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Meters", "Centimeters", "Millimeters", "Inches", "Feets" }));
        CenterLockPnl.add(RawItemCenterLockLengthUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 120, -1));

        RawItemCenterLockHeightUnit.setBackground(new java.awt.Color(102, 102, 102));
        RawItemCenterLockHeightUnit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemCenterLockHeightUnit.setForeground(new java.awt.Color(255, 255, 255));
        RawItemCenterLockHeightUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Meters", "Centimeters", "Millimeters", "Inches", "Feets" }));
        CenterLockPnl.add(RawItemCenterLockHeightUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, 120, -1));

        jLabel232.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel232.setForeground(new java.awt.Color(255, 255, 255));
        jLabel232.setText("Unit");
        CenterLockPnl.add(jLabel232, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, 50, 20));

        jLabel233.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel233.setForeground(new java.awt.Color(255, 255, 255));
        jLabel233.setText("Re-order Level");
        CenterLockPnl.add(jLabel233, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 140, 20));

        RawItemCenterLockQty.setBackground(new java.awt.Color(102, 102, 102));
        RawItemCenterLockQty.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemCenterLockQty.setForeground(new java.awt.Color(255, 255, 255));
        RawItemCenterLockQty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RawItemCenterLockQtyActionPerformed(evt);
            }
        });
        RawItemCenterLockQty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemCenterLockQtyKeyTyped(evt);
            }
        });
        CenterLockPnl.add(RawItemCenterLockQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 260, -1));

        jLabel447.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel447.setForeground(new java.awt.Color(255, 255, 255));
        jLabel447.setText("Item Cost");
        CenterLockPnl.add(jLabel447, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 120, 20));

        RawItemCenterLockCost.setBackground(new java.awt.Color(102, 102, 102));
        RawItemCenterLockCost.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemCenterLockCost.setForeground(new java.awt.Color(255, 255, 255));
        RawItemCenterLockCost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemCenterLockCostKeyTyped(evt);
            }
        });
        CenterLockPnl.add(RawItemCenterLockCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 260, -1));

        CatPanel2.add(CenterLockPnl, "card11");

        CPerlingCoilsPnl.setBackground(new java.awt.Color(0, 0, 0));
        CPerlingCoilsPnl.setOpaque(false);
        CPerlingCoilsPnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel235.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel235.setForeground(new java.awt.Color(255, 255, 255));
        jLabel235.setText("Unit");
        CPerlingCoilsPnl.add(jLabel235, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 50, 20));

        jLabel249.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel249.setForeground(new java.awt.Color(255, 255, 255));
        jLabel249.setText("Weight");
        CPerlingCoilsPnl.add(jLabel249, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 80, 20));

        jLabel317.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel317.setForeground(new java.awt.Color(255, 255, 255));
        jLabel317.setText("Length");
        CPerlingCoilsPnl.add(jLabel317, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 80, 20));

        jLabel318.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel318.setForeground(new java.awt.Color(255, 255, 255));
        jLabel318.setText("Width");
        CPerlingCoilsPnl.add(jLabel318, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 70, 20));

        jLabel319.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel319.setForeground(new java.awt.Color(255, 255, 255));
        jLabel319.setText("Height");
        CPerlingCoilsPnl.add(jLabel319, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 80, 20));

        jLabel320.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel320.setForeground(new java.awt.Color(255, 255, 255));
        jLabel320.setText("Thickness");
        CPerlingCoilsPnl.add(jLabel320, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 100, 20));

        jLabel321.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel321.setForeground(new java.awt.Color(255, 255, 255));
        jLabel321.setText("Quantity");
        CPerlingCoilsPnl.add(jLabel321, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 90, 20));

        jLabel322.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel322.setForeground(new java.awt.Color(255, 255, 255));
        jLabel322.setText("GRN Number");
        CPerlingCoilsPnl.add(jLabel322, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 120, 20));

        RawItemCPerlingThickness.setBackground(new java.awt.Color(102, 102, 102));
        RawItemCPerlingThickness.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemCPerlingThickness.setForeground(new java.awt.Color(255, 255, 255));
        RawItemCPerlingThickness.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemCPerlingThicknessKeyTyped(evt);
            }
        });
        CPerlingCoilsPnl.add(RawItemCPerlingThickness, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 260, -1));

        RawItemCPerlingHeight.setBackground(new java.awt.Color(102, 102, 102));
        RawItemCPerlingHeight.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemCPerlingHeight.setForeground(new java.awt.Color(255, 255, 255));
        RawItemCPerlingHeight.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemCPerlingHeightKeyTyped(evt);
            }
        });
        CPerlingCoilsPnl.add(RawItemCPerlingHeight, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 260, -1));

        RawItemCPerlingWidth.setBackground(new java.awt.Color(102, 102, 102));
        RawItemCPerlingWidth.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemCPerlingWidth.setForeground(new java.awt.Color(255, 255, 255));
        RawItemCPerlingWidth.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemCPerlingWidthKeyTyped(evt);
            }
        });
        CPerlingCoilsPnl.add(RawItemCPerlingWidth, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 260, -1));

        RawItemCPerlingWeight.setBackground(new java.awt.Color(102, 102, 102));
        RawItemCPerlingWeight.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemCPerlingWeight.setForeground(new java.awt.Color(255, 255, 255));
        RawItemCPerlingWeight.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemCPerlingWeightKeyTyped(evt);
            }
        });
        CPerlingCoilsPnl.add(RawItemCPerlingWeight, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 260, -1));

        RawItemCPerlingLength.setBackground(new java.awt.Color(102, 102, 102));
        RawItemCPerlingLength.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemCPerlingLength.setForeground(new java.awt.Color(255, 255, 255));
        RawItemCPerlingLength.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RawItemCPerlingLengthActionPerformed(evt);
            }
        });
        RawItemCPerlingLength.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemCPerlingLengthKeyTyped(evt);
            }
        });
        CPerlingCoilsPnl.add(RawItemCPerlingLength, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 260, -1));

        RawItemCPerlingROL.setBackground(new java.awt.Color(102, 102, 102));
        RawItemCPerlingROL.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemCPerlingROL.setForeground(new java.awt.Color(255, 255, 255));
        RawItemCPerlingROL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemCPerlingROLKeyTyped(evt);
            }
        });
        CPerlingCoilsPnl.add(RawItemCPerlingROL, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 260, -1));

        RawItemCPerlingGRN.setBackground(new java.awt.Color(102, 102, 102));
        RawItemCPerlingGRN.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemCPerlingGRN.setForeground(new java.awt.Color(255, 255, 255));
        CPerlingCoilsPnl.add(RawItemCPerlingGRN, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 260, -1));

        RawItemCPerlingWeightUnit.setBackground(new java.awt.Color(102, 102, 102));
        RawItemCPerlingWeightUnit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemCPerlingWeightUnit.setForeground(new java.awt.Color(255, 255, 255));
        RawItemCPerlingWeightUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kilograms", "Tons" }));
        CPerlingCoilsPnl.add(RawItemCPerlingWeightUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 120, -1));

        jLabel323.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel323.setForeground(new java.awt.Color(255, 255, 255));
        jLabel323.setText("Unit");
        CPerlingCoilsPnl.add(jLabel323, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, 50, 20));

        RawItemCPerlingWidthUnit.setBackground(new java.awt.Color(102, 102, 102));
        RawItemCPerlingWidthUnit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemCPerlingWidthUnit.setForeground(new java.awt.Color(255, 255, 255));
        RawItemCPerlingWidthUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Meters", "Centimeters", "Millimeters", "Inches", "Feets" }));
        CPerlingCoilsPnl.add(RawItemCPerlingWidthUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, 120, -1));

        jLabel324.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel324.setForeground(new java.awt.Color(255, 255, 255));
        jLabel324.setText("Unit");
        CPerlingCoilsPnl.add(jLabel324, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, 50, 20));

        RawItemCPerlingLengthUnit.setBackground(new java.awt.Color(102, 102, 102));
        RawItemCPerlingLengthUnit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemCPerlingLengthUnit.setForeground(new java.awt.Color(255, 255, 255));
        RawItemCPerlingLengthUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Meters", "Centimeters", "Millimeters", "Inches", "Feets" }));
        CPerlingCoilsPnl.add(RawItemCPerlingLengthUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 50, 120, -1));

        RawItemCPerlingThicknessUnit.setBackground(new java.awt.Color(102, 102, 102));
        RawItemCPerlingThicknessUnit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemCPerlingThicknessUnit.setForeground(new java.awt.Color(255, 255, 255));
        RawItemCPerlingThicknessUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Meters", "Centimeters", "Millimeters", "Inches", "Feets" }));
        CPerlingCoilsPnl.add(RawItemCPerlingThicknessUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 170, 120, -1));

        RawItemCPerlingHeightUnit.setBackground(new java.awt.Color(102, 102, 102));
        RawItemCPerlingHeightUnit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemCPerlingHeightUnit.setForeground(new java.awt.Color(255, 255, 255));
        RawItemCPerlingHeightUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Meters", "Centimeters", "Millimeters", "Inches", "Feets" }));
        CPerlingCoilsPnl.add(RawItemCPerlingHeightUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 130, 120, -1));

        jLabel325.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel325.setForeground(new java.awt.Color(255, 255, 255));
        jLabel325.setText("Unit");
        CPerlingCoilsPnl.add(jLabel325, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 130, 50, 20));

        jLabel326.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel326.setForeground(new java.awt.Color(255, 255, 255));
        jLabel326.setText("Re-order Level");
        CPerlingCoilsPnl.add(jLabel326, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 140, 20));

        jLabel327.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel327.setForeground(new java.awt.Color(255, 255, 255));
        jLabel327.setText("Unit");
        CPerlingCoilsPnl.add(jLabel327, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, 50, 20));

        RawItemCPerlingQty.setBackground(new java.awt.Color(102, 102, 102));
        RawItemCPerlingQty.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemCPerlingQty.setForeground(new java.awt.Color(255, 255, 255));
        RawItemCPerlingQty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemCPerlingQtyKeyTyped(evt);
            }
        });
        CPerlingCoilsPnl.add(RawItemCPerlingQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 260, -1));

        jLabel448.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel448.setForeground(new java.awt.Color(255, 255, 255));
        jLabel448.setText("Item Cost");
        CPerlingCoilsPnl.add(jLabel448, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 120, 20));

        RawItemCPerlingCost.setBackground(new java.awt.Color(102, 102, 102));
        RawItemCPerlingCost.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemCPerlingCost.setForeground(new java.awt.Color(255, 255, 255));
        RawItemCPerlingCost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemCPerlingCostKeyTyped(evt);
            }
        });
        CPerlingCoilsPnl.add(RawItemCPerlingCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, 260, -1));

        CatPanel2.add(CPerlingCoilsPnl, "card11");

        RollerShutterBeltPnl.setBackground(new java.awt.Color(0, 0, 0));
        RollerShutterBeltPnl.setOpaque(false);
        RollerShutterBeltPnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel331.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel331.setForeground(new java.awt.Color(255, 255, 255));
        jLabel331.setText("Length");
        RollerShutterBeltPnl.add(jLabel331, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 80, 20));

        jLabel335.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel335.setForeground(new java.awt.Color(255, 255, 255));
        jLabel335.setText("Quantity");
        RollerShutterBeltPnl.add(jLabel335, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 90, 20));

        jLabel336.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel336.setForeground(new java.awt.Color(255, 255, 255));
        jLabel336.setText("GRN Number");
        RollerShutterBeltPnl.add(jLabel336, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 120, 20));

        RawItemRSBeltLength.setBackground(new java.awt.Color(102, 102, 102));
        RawItemRSBeltLength.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemRSBeltLength.setForeground(new java.awt.Color(255, 255, 255));
        RawItemRSBeltLength.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RawItemRSBeltLengthActionPerformed(evt);
            }
        });
        RawItemRSBeltLength.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemRSBeltLengthKeyTyped(evt);
            }
        });
        RollerShutterBeltPnl.add(RawItemRSBeltLength, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 260, -1));

        RawItemRSBeltROL.setBackground(new java.awt.Color(102, 102, 102));
        RawItemRSBeltROL.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemRSBeltROL.setForeground(new java.awt.Color(255, 255, 255));
        RawItemRSBeltROL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemRSBeltROLKeyTyped(evt);
            }
        });
        RollerShutterBeltPnl.add(RawItemRSBeltROL, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 260, -1));

        RawItemRSBeltGRN.setBackground(new java.awt.Color(102, 102, 102));
        RawItemRSBeltGRN.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemRSBeltGRN.setForeground(new java.awt.Color(255, 255, 255));
        RollerShutterBeltPnl.add(RawItemRSBeltGRN, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 260, -1));

        jLabel337.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel337.setForeground(new java.awt.Color(255, 255, 255));
        jLabel337.setText("Unit");
        RollerShutterBeltPnl.add(jLabel337, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 50, 20));

        RawItemRSBeltLengthUnit.setBackground(new java.awt.Color(102, 102, 102));
        RawItemRSBeltLengthUnit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemRSBeltLengthUnit.setForeground(new java.awt.Color(255, 255, 255));
        RawItemRSBeltLengthUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Meters", "Centimeters", "Millimeters", "Inches", "Feets" }));
        RollerShutterBeltPnl.add(RawItemRSBeltLengthUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 120, -1));

        jLabel340.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel340.setForeground(new java.awt.Color(255, 255, 255));
        jLabel340.setText("Re-order Level");
        RollerShutterBeltPnl.add(jLabel340, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 140, 20));

        RawItemRSBeltQty.setBackground(new java.awt.Color(102, 102, 102));
        RawItemRSBeltQty.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemRSBeltQty.setForeground(new java.awt.Color(255, 255, 255));
        RawItemRSBeltQty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemRSBeltQtyKeyTyped(evt);
            }
        });
        RollerShutterBeltPnl.add(RawItemRSBeltQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 260, -1));

        jLabel449.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel449.setForeground(new java.awt.Color(255, 255, 255));
        jLabel449.setText("Item Cost");
        RollerShutterBeltPnl.add(jLabel449, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 120, 20));

        RawItemRSBeltCost.setBackground(new java.awt.Color(102, 102, 102));
        RawItemRSBeltCost.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        RawItemRSBeltCost.setForeground(new java.awt.Color(255, 255, 255));
        RawItemRSBeltCost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RawItemRSBeltCostKeyTyped(evt);
            }
        });
        RollerShutterBeltPnl.add(RawItemRSBeltCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 260, -1));

        CatPanel2.add(RollerShutterBeltPnl, "card11");

        CPRawItemPanel.add(CatPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 940, 430));

        jLabel26.setMaximumSize(new java.awt.Dimension(1140, 710));
        jLabel26.setMinimumSize(new java.awt.Dimension(1140, 710));
        jLabel26.setPreferredSize(new java.awt.Dimension(1140, 710));
        CPRawItemPanel.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 710));

        RIContentPanel.add(CPRawItemPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        RIMainPanel.add(RIContentPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(RIMainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(RIMainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            this.dispose();
        } catch (Exception e) {
            Logger.getLogger(RawItemsJF.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_SPExitBtnActionPerformed

    private void SPMinimizeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPMinimizeBtnActionPerformed
        this.setState(ICONIFIED);        // TODO add your handling code here:
    }//GEN-LAST:event_SPMinimizeBtnActionPerformed

    private void RawItemCatCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RawItemCatCBActionPerformed
        ChangeRawItemCat(RawItemCatCB.getSelectedItem().toString());
    }//GEN-LAST:event_RawItemCatCBActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        AddRawItem(RawItemCatCB.getSelectedItem().toString());
        rawItemClearTextFields(RawItemCatCB.getSelectedItem().toString());
        AutoGenRIcode();
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        rawItemSetEditableFields(RawItemCatCB, "true");
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        UpdateRawItem(RawItemCatCB.getSelectedItem().toString());
        rawItemClearTextFields(RawItemCatCB.getSelectedItem().toString());
        AutoGenRIcode();
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        rawItemClearTextFields(RawItemCatCB.getSelectedItem().toString());
        rawItemSetEditableFields(RawItemCatCB, "true");
        AutoGenRIcode();
    }//GEN-LAST:event_jButton23ActionPerformed

    private void RawItemCodeCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RawItemCodeCBActionPerformed

        Statement s;
        if(RawItemCodeCB.getSelectedIndex() != -1){
            String txt=RawItemCodeCB.getSelectedItem().toString();
            try {
                s = SeldoDB.GetMyConnection().createStatement();
                ResultSet rs = s.executeQuery("select RawItemCode from rawitem where RawItemCode  = '"+txt+"' ");

                if(rs.next()){
                    LoadRawItemDetailsFromDB();
                    rawItemSetEditableFields(RawItemCatCB, "false");
                }else{
                    rawItemSetEditableFields(RawItemCatCB, "true");
                }
            } catch (Exception ex) {
                Logger.getLogger(RawItemsJF.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            rawItemClearTextFields(RawItemCatCB.getSelectedItem().toString());
            rawItemSetEditableFields(RawItemCatCB, "true");
        }
    }//GEN-LAST:event_RawItemCodeCBActionPerformed

    private void RawItemPlainSheetLengthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RawItemPlainSheetLengthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RawItemPlainSheetLengthActionPerformed

    private void RawItemUbarLengthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RawItemUbarLengthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RawItemUbarLengthActionPerformed

    private void RawItemJbarLengthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RawItemJbarLengthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RawItemJbarLengthActionPerformed

    private void RawItemUCBLengthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RawItemUCBLengthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RawItemUCBLengthActionPerformed

    private void RawItemBottomBleedingLengthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RawItemBottomBleedingLengthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RawItemBottomBleedingLengthActionPerformed

    private void RawItemSideBleedingLengthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RawItemSideBleedingLengthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RawItemSideBleedingLengthActionPerformed

    private void RawItemABBarLengthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RawItemABBarLengthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RawItemABBarLengthActionPerformed

    private void RawItemPulleyLengthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RawItemPulleyLengthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RawItemPulleyLengthActionPerformed

    private void RawItemSpirngLengthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RawItemSpirngLengthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RawItemSpirngLengthActionPerformed

    private void RawItemDownLockLengthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RawItemDownLockLengthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RawItemDownLockLengthActionPerformed

    private void RawItemSideLockLengthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RawItemSideLockLengthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RawItemSideLockLengthActionPerformed

    private void RawItemCenterLockLengthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RawItemCenterLockLengthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RawItemCenterLockLengthActionPerformed

    private void RawItemCPerlingLengthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RawItemCPerlingLengthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RawItemCPerlingLengthActionPerformed

    private void RawItemRSBeltLengthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RawItemRSBeltLengthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RawItemRSBeltLengthActionPerformed

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

    private void RawItemPlainSheetROLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RawItemPlainSheetROLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RawItemPlainSheetROLActionPerformed

    private void RawItemPlainSheetWeightKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemPlainSheetWeightKeyTyped
        char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemPlainSheetWeightKeyTyped

    private void RawItemPlainSheetLengthKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemPlainSheetLengthKeyTyped
        char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_RawItemPlainSheetLengthKeyTyped

    private void RawItemPlainSheetWidthKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemPlainSheetWidthKeyTyped
        char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemPlainSheetWidthKeyTyped

    private void RawItemPlainSheetHeightKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemPlainSheetHeightKeyTyped
        char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemPlainSheetHeightKeyTyped

    private void RawItemPlainSheetThicknessKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemPlainSheetThicknessKeyTyped
        char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemPlainSheetThicknessKeyTyped

    private void RawItemPlainSheetQtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemPlainSheetQtyKeyTyped
        char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemPlainSheetQtyKeyTyped

    private void RawItemPlainSheetROLKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemPlainSheetROLKeyTyped
        char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemPlainSheetROLKeyTyped

    private void RawItemPlainSheetCostKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemPlainSheetCostKeyTyped
        char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemPlainSheetCostKeyTyped

    private void RawItemUbarWeightKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemUbarWeightKeyTyped
        char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemUbarWeightKeyTyped

    private void RawItemUbarLengthKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemUbarLengthKeyTyped
        char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemUbarLengthKeyTyped

    private void RawItemUbarWidthKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemUbarWidthKeyTyped
        char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemUbarWidthKeyTyped

    private void RawItemUbarHeightKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemUbarHeightKeyTyped
        char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemUbarHeightKeyTyped

    private void RawItemUbarThicknessKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemUbarThicknessKeyTyped
        char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemUbarThicknessKeyTyped

    private void RawItemUbarQtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemUbarQtyKeyTyped
        char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemUbarQtyKeyTyped

    private void RawItemUbarROLKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemUbarROLKeyTyped
        char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemUbarROLKeyTyped

    private void RawItemUbarCostKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemUbarCostKeyTyped
        char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemUbarCostKeyTyped

    private void RawItemJbarWeightKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemJbarWeightKeyTyped
       char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemJbarWeightKeyTyped

    private void RawItemJbarLengthKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemJbarLengthKeyTyped
        char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemJbarLengthKeyTyped

    private void RawItemJbarWidthKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemJbarWidthKeyTyped
       char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemJbarWidthKeyTyped

    private void RawItemJbarHeightKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemJbarHeightKeyTyped
        char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemJbarHeightKeyTyped

    private void RawItemJbarThicknessKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemJbarThicknessKeyTyped
        char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemJbarThicknessKeyTyped

    private void RawItemJbarQtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemJbarQtyKeyTyped
        char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemJbarQtyKeyTyped

    private void RawItemJbarROLKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemJbarROLKeyTyped
        char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemJbarROLKeyTyped

    private void RawItemJbarCostKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemJbarCostKeyTyped
        char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemJbarCostKeyTyped

    private void RawItemUCBLengthKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemUCBLengthKeyTyped
        char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemUCBLengthKeyTyped

    private void RawItemUCBQtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemUCBQtyKeyTyped
       char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemUCBQtyKeyTyped

    private void RawItemUCBROLKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemUCBROLKeyTyped
        char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemUCBROLKeyTyped

    private void RawItemUCBCostKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemUCBCostKeyTyped
        char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemUCBCostKeyTyped

    private void RawItemBottomBleedingLengthKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemBottomBleedingLengthKeyTyped
        char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemBottomBleedingLengthKeyTyped

    private void RawItemBottomBleedingQtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemBottomBleedingQtyKeyTyped
        char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemBottomBleedingQtyKeyTyped

    private void RawItemBottomBleedingROLKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemBottomBleedingROLKeyTyped
        char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemBottomBleedingROLKeyTyped

    private void RawItemBottomBleedingGRNKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemBottomBleedingGRNKeyTyped
        
    }//GEN-LAST:event_RawItemBottomBleedingGRNKeyTyped

    private void RawItemBottomBleedingCostKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemBottomBleedingCostKeyTyped
        char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemBottomBleedingCostKeyTyped

    private void RawItemSideBleedingLengthKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemSideBleedingLengthKeyTyped
        char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemSideBleedingLengthKeyTyped

    private void RawItemSideBleedingQtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemSideBleedingQtyKeyTyped
        char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemSideBleedingQtyKeyTyped

    private void RawItemSideBleedingROLKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemSideBleedingROLKeyTyped
        char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemSideBleedingROLKeyTyped

    private void RawItemSideBleedingCostKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemSideBleedingCostKeyTyped
        char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemSideBleedingCostKeyTyped

    private void RawItemABBarLengthKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemABBarLengthKeyTyped
        char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemABBarLengthKeyTyped

    private void RawItemABBarWidthKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemABBarWidthKeyTyped
        char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemABBarWidthKeyTyped

    private void RawItemABBarHeightKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemABBarHeightKeyTyped
        char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemABBarHeightKeyTyped

    private void RawItemABBarThicknessKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemABBarThicknessKeyTyped
        char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemABBarThicknessKeyTyped

    private void RawItemABBarQtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemABBarQtyKeyTyped
        char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemABBarQtyKeyTyped

    private void RawItemABBarROLKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemABBarROLKeyTyped
        char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemABBarROLKeyTyped

    private void RawItemABBarCostKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemABBarCostKeyTyped
        char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemABBarCostKeyTyped

    private void RawItemPulleyLengthKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemPulleyLengthKeyTyped
        char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemPulleyLengthKeyTyped

    private void RawItemPulleyWidthKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemPulleyWidthKeyTyped
        char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemPulleyWidthKeyTyped

    private void RawItemPulleyHeightKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemPulleyHeightKeyTyped
        char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemPulleyHeightKeyTyped

    private void RawItemPulleyThicknessKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemPulleyThicknessKeyTyped
        char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemPulleyThicknessKeyTyped

    private void RawItemPulleyQtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemPulleyQtyKeyTyped
        char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemPulleyQtyKeyTyped

    private void RawItemPulleyROLKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemPulleyROLKeyTyped
        char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemPulleyROLKeyTyped

    private void RawItemPulleyGRNKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemPulleyGRNKeyTyped
        
    }//GEN-LAST:event_RawItemPulleyGRNKeyTyped

    private void RawItemPulleyCostKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemPulleyCostKeyTyped
        char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemPulleyCostKeyTyped

    private void RawItemRSBeltLengthKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemRSBeltLengthKeyTyped
        char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemRSBeltLengthKeyTyped

    private void RawItemRSBeltQtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemRSBeltQtyKeyTyped
        char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemRSBeltQtyKeyTyped

    private void RawItemRSBeltROLKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemRSBeltROLKeyTyped
        char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemRSBeltROLKeyTyped

    private void RawItemRSBeltCostKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemRSBeltCostKeyTyped
        char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemRSBeltCostKeyTyped

    private void RawItemSpirngThickenssActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RawItemSpirngThickenssActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RawItemSpirngThickenssActionPerformed

    private void RawItemSpirngLengthKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemSpirngLengthKeyTyped
        char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemSpirngLengthKeyTyped

    private void RawItemSpirngThickenssKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemSpirngThickenssKeyTyped
        char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemSpirngThickenssKeyTyped

    private void RawItemSpirngQtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemSpirngQtyKeyTyped
        char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemSpirngQtyKeyTyped

    private void RawItemSpirngROLKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemSpirngROLKeyTyped
        char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemSpirngROLKeyTyped

    private void RawItemSpirngCostKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemSpirngCostKeyTyped
        char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemSpirngCostKeyTyped

    private void RawItemDownLockLengthKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemDownLockLengthKeyTyped
        char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemDownLockLengthKeyTyped

    private void RawItemDownLockWidthKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemDownLockWidthKeyTyped
        char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemDownLockWidthKeyTyped

    private void RawItemDownLockHeightKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemDownLockHeightKeyTyped
        char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemDownLockHeightKeyTyped

    private void RawItemDownLockQtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemDownLockQtyKeyTyped
        char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemDownLockQtyKeyTyped

    private void RawItemDownLockROLKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemDownLockROLKeyTyped
        char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemDownLockROLKeyTyped

    private void RawItemDownLockCostKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemDownLockCostKeyTyped
        char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemDownLockCostKeyTyped

    private void RawItemSideLockLengthKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemSideLockLengthKeyTyped
        char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemSideLockLengthKeyTyped

    private void RawItemSideLockWidthKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemSideLockWidthKeyTyped
        char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemSideLockWidthKeyTyped

    private void RawItemSideLockHeightKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemSideLockHeightKeyTyped
        char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemSideLockHeightKeyTyped

    private void RawItemSideLockQtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemSideLockQtyKeyTyped
        char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemSideLockQtyKeyTyped

    private void RawItemSideLockROLKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemSideLockROLKeyTyped
        char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemSideLockROLKeyTyped

    private void RawItemSideLockCostKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemSideLockCostKeyTyped
        char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemSideLockCostKeyTyped

    private void RawItemCenterLockLengthKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemCenterLockLengthKeyTyped
         char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemCenterLockLengthKeyTyped

    private void RawItemCenterLockWidthKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemCenterLockWidthKeyTyped
         char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemCenterLockWidthKeyTyped

    private void RawItemCenterLockHeightKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemCenterLockHeightKeyTyped
         char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemCenterLockHeightKeyTyped

    private void RawItemCenterLockQtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RawItemCenterLockQtyActionPerformed
        
    }//GEN-LAST:event_RawItemCenterLockQtyActionPerformed

    private void RawItemCenterLockROLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RawItemCenterLockROLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RawItemCenterLockROLActionPerformed

    private void RawItemCenterLockROLKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemCenterLockROLKeyTyped
         char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemCenterLockROLKeyTyped

    private void RawItemCenterLockQtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemCenterLockQtyKeyTyped
         char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemCenterLockQtyKeyTyped

    private void RawItemCenterLockCostKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemCenterLockCostKeyTyped
         char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemCenterLockCostKeyTyped

    private void RawItemCPerlingWeightKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemCPerlingWeightKeyTyped
         char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemCPerlingWeightKeyTyped

    private void RawItemCPerlingLengthKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemCPerlingLengthKeyTyped
         char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemCPerlingLengthKeyTyped

    private void RawItemCPerlingWidthKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemCPerlingWidthKeyTyped
         char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemCPerlingWidthKeyTyped

    private void RawItemCPerlingHeightKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemCPerlingHeightKeyTyped
         char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemCPerlingHeightKeyTyped

    private void RawItemCPerlingThicknessKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemCPerlingThicknessKeyTyped
         char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemCPerlingThicknessKeyTyped

    private void RawItemCPerlingQtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemCPerlingQtyKeyTyped
        char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemCPerlingQtyKeyTyped

    private void RawItemCPerlingROLKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemCPerlingROLKeyTyped
        char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemCPerlingROLKeyTyped

    private void RawItemCPerlingCostKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RawItemCPerlingCostKeyTyped
         char restrict=evt.getKeyChar();
        if(Character.isWhitespace(restrict)||Character.isLetter(restrict)){
            evt.consume();
             Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RawItemCPerlingCostKeyTyped

    private void SPChequeBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPChequeBtn1ActionPerformed
        try {
            ChequeDetailsJF NewChequeDetailsJF = new ChequeDetailsJF();
            NewChequeDetailsJF.setVisible(true);
            this.setVisible(false);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_SPChequeBtn1ActionPerformed

    private void SPSettingsBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPSettingsBtn1ActionPerformed
        try {
            ExpencesJF newExpencesJF = new ExpencesJF();
            newExpencesJF.setVisible(true);
            this.setVisible(false);
        } catch (Exception e) {
            Logger.getLogger(RawItemsJF.class.getName()).log(Level.SEVERE, null,e);
        }
    }//GEN-LAST:event_SPSettingsBtn1ActionPerformed

    private void SPRawItemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPRawItemBtnActionPerformed
       
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
            java.util.logging.Logger.getLogger(RawItemsJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RawItemsJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RawItemsJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RawItemsJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RawItemsJF().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AluminiumBottomBarPnl;
    private javax.swing.JPanel BottomBeadingPnl;
    private javax.swing.JPanel CPRawItemPanel;
    private javax.swing.JPanel CPerlingCoilsPnl;
    private javax.swing.JPanel CatPanel2;
    private javax.swing.JPanel CenterLockPnl;
    private javax.swing.JLabel Datelbl;
    private javax.swing.JLabel Datelbl1;
    private javax.swing.JPanel DownLockPnl;
    private javax.swing.JPanel JBarPnl;
    private javax.swing.JLabel MainPanelBranchIDLable;
    private javax.swing.JLabel MainPanelBranchNameLable;
    private javax.swing.JPanel PlainSheetPnl;
    private javax.swing.JPanel PulleyPnl;
    private javax.swing.JPanel RIContentPanel;
    private javax.swing.JPanel RIMainPanel;
    private javax.swing.JTextField RawItemABBarCost;
    private javax.swing.JTextField RawItemABBarGRN;
    private javax.swing.JTextField RawItemABBarHeight;
    private javax.swing.JComboBox<String> RawItemABBarHeightUnit;
    private javax.swing.JTextField RawItemABBarLength;
    private javax.swing.JComboBox<String> RawItemABBarLengthUnit;
    private javax.swing.JTextField RawItemABBarQty;
    private javax.swing.JTextField RawItemABBarROL;
    private javax.swing.JTextField RawItemABBarThickness;
    private javax.swing.JComboBox<String> RawItemABBarThicknessUnit;
    private javax.swing.JTextField RawItemABBarWidth;
    private javax.swing.JComboBox<String> RawItemABBarWidthUnit;
    private javax.swing.JTextField RawItemBottomBleedingCost;
    private javax.swing.JTextField RawItemBottomBleedingGRN;
    private javax.swing.JTextField RawItemBottomBleedingLength;
    private javax.swing.JComboBox<String> RawItemBottomBleedingLengthUnit;
    private javax.swing.JTextField RawItemBottomBleedingQty;
    private javax.swing.JTextField RawItemBottomBleedingROL;
    private javax.swing.JTextField RawItemCPerlingCost;
    private javax.swing.JTextField RawItemCPerlingGRN;
    private javax.swing.JTextField RawItemCPerlingHeight;
    private javax.swing.JComboBox<String> RawItemCPerlingHeightUnit;
    private javax.swing.JTextField RawItemCPerlingLength;
    private javax.swing.JComboBox<String> RawItemCPerlingLengthUnit;
    private javax.swing.JTextField RawItemCPerlingQty;
    private javax.swing.JTextField RawItemCPerlingROL;
    private javax.swing.JTextField RawItemCPerlingThickness;
    private javax.swing.JComboBox<String> RawItemCPerlingThicknessUnit;
    private javax.swing.JTextField RawItemCPerlingWeight;
    private javax.swing.JComboBox<String> RawItemCPerlingWeightUnit;
    private javax.swing.JTextField RawItemCPerlingWidth;
    private javax.swing.JComboBox<String> RawItemCPerlingWidthUnit;
    private javax.swing.JComboBox<String> RawItemCatCB;
    private javax.swing.JTextField RawItemCenterLockCost;
    private javax.swing.JTextField RawItemCenterLockGRN;
    private javax.swing.JTextField RawItemCenterLockHeight;
    private javax.swing.JComboBox<String> RawItemCenterLockHeightUnit;
    private javax.swing.JTextField RawItemCenterLockLength;
    private javax.swing.JComboBox<String> RawItemCenterLockLengthUnit;
    private javax.swing.JTextField RawItemCenterLockQty;
    private javax.swing.JTextField RawItemCenterLockROL;
    private javax.swing.JTextField RawItemCenterLockWidth;
    private javax.swing.JComboBox<String> RawItemCenterLockWidthUnit;
    private javax.swing.JComboBox<String> RawItemCodeCB;
    private javax.swing.JTextField RawItemDownLockCost;
    private javax.swing.JTextField RawItemDownLockGRN;
    private javax.swing.JTextField RawItemDownLockHeight;
    private javax.swing.JComboBox<String> RawItemDownLockHeightUnit;
    private javax.swing.JTextField RawItemDownLockLength;
    private javax.swing.JComboBox<String> RawItemDownLockLengthUnit;
    private javax.swing.JTextField RawItemDownLockQty;
    private javax.swing.JTextField RawItemDownLockROL;
    private javax.swing.JTextField RawItemDownLockWidth;
    private javax.swing.JComboBox<String> RawItemDownLockWidthUnit;
    private javax.swing.JTextField RawItemJbarCost;
    private javax.swing.JTextField RawItemJbarGRN;
    private javax.swing.JTextField RawItemJbarHeight;
    private javax.swing.JComboBox<String> RawItemJbarHeightUnit;
    private javax.swing.JTextField RawItemJbarLength;
    private javax.swing.JComboBox<String> RawItemJbarLengthUnit;
    private javax.swing.JTextField RawItemJbarQty;
    private javax.swing.JTextField RawItemJbarROL;
    private javax.swing.JTextField RawItemJbarThickness;
    private javax.swing.JComboBox<String> RawItemJbarThicknessUnit;
    private javax.swing.JTextField RawItemJbarWeight;
    private javax.swing.JComboBox<String> RawItemJbarWeightUnit;
    private javax.swing.JTextField RawItemJbarWidth;
    private javax.swing.JComboBox<String> RawItemJbarWidthUnit;
    private javax.swing.JTextField RawItemPlainSheetColour;
    private javax.swing.JTextField RawItemPlainSheetCost;
    private javax.swing.JTextField RawItemPlainSheetGRN;
    private javax.swing.JTextField RawItemPlainSheetHeight;
    private javax.swing.JComboBox<String> RawItemPlainSheetHeightUnit;
    private javax.swing.JTextField RawItemPlainSheetLength;
    private javax.swing.JComboBox<String> RawItemPlainSheetLengthUnit;
    private javax.swing.JTextField RawItemPlainSheetQty;
    private javax.swing.JTextField RawItemPlainSheetROL;
    private javax.swing.JTextField RawItemPlainSheetThickness;
    private javax.swing.JComboBox<String> RawItemPlainSheetThicknessUnit;
    private javax.swing.JTextField RawItemPlainSheetWeight;
    private javax.swing.JComboBox<String> RawItemPlainSheetWeightUnit;
    private javax.swing.JTextField RawItemPlainSheetWidth;
    private javax.swing.JComboBox<String> RawItemPlainSheetWidthUnit;
    private javax.swing.JTextField RawItemPulleyCost;
    private javax.swing.JTextField RawItemPulleyGRN;
    private javax.swing.JTextField RawItemPulleyHeight;
    private javax.swing.JComboBox<String> RawItemPulleyHeightUnit;
    private javax.swing.JTextField RawItemPulleyLength;
    private javax.swing.JComboBox<String> RawItemPulleyLengthUnit;
    private javax.swing.JTextField RawItemPulleyQty;
    private javax.swing.JTextField RawItemPulleyROL;
    private javax.swing.JTextField RawItemPulleyThickness;
    private javax.swing.JComboBox<String> RawItemPulleyThicknessUnit;
    private javax.swing.JTextField RawItemPulleyWidth;
    private javax.swing.JComboBox<String> RawItemPulleyWidthUnit;
    private javax.swing.JTextField RawItemRSBeltCost;
    private javax.swing.JTextField RawItemRSBeltGRN;
    private javax.swing.JTextField RawItemRSBeltLength;
    private javax.swing.JComboBox<String> RawItemRSBeltLengthUnit;
    private javax.swing.JTextField RawItemRSBeltQty;
    private javax.swing.JTextField RawItemRSBeltROL;
    private javax.swing.JTextField RawItemSideBleedingCost;
    private javax.swing.JTextField RawItemSideBleedingGRN;
    private javax.swing.JTextField RawItemSideBleedingLength;
    private javax.swing.JComboBox<String> RawItemSideBleedingLengthUnit;
    private javax.swing.JTextField RawItemSideBleedingQty;
    private javax.swing.JTextField RawItemSideBleedingROL;
    private javax.swing.JTextField RawItemSideLockCost;
    private javax.swing.JTextField RawItemSideLockGRN;
    private javax.swing.JTextField RawItemSideLockHeight;
    private javax.swing.JComboBox<String> RawItemSideLockHeightUnit;
    private javax.swing.JTextField RawItemSideLockLength;
    private javax.swing.JComboBox<String> RawItemSideLockLengthUnit;
    private javax.swing.JTextField RawItemSideLockQty;
    private javax.swing.JTextField RawItemSideLockROL;
    private javax.swing.JTextField RawItemSideLockWidth;
    private javax.swing.JComboBox<String> RawItemSideLockWidthUnit;
    private javax.swing.JTextField RawItemSpirngCost;
    private javax.swing.JTextField RawItemSpirngGRN;
    private javax.swing.JTextField RawItemSpirngLength;
    private javax.swing.JComboBox<String> RawItemSpirngLengthUnit;
    private javax.swing.JTextField RawItemSpirngQty;
    private javax.swing.JTextField RawItemSpirngROL;
    private javax.swing.JTextField RawItemSpirngThickenss;
    private javax.swing.JComboBox<String> RawItemSpirngThicknessUnit;
    private javax.swing.JTextField RawItemUCBCost;
    private javax.swing.JTextField RawItemUCBGRN;
    private javax.swing.JTextField RawItemUCBLength;
    private javax.swing.JComboBox<String> RawItemUCBLengthUnit;
    private javax.swing.JTextField RawItemUCBQty;
    private javax.swing.JTextField RawItemUCBROL;
    private javax.swing.JTextField RawItemUbarCost;
    private javax.swing.JTextField RawItemUbarGRN;
    private javax.swing.JTextField RawItemUbarHeight;
    private javax.swing.JComboBox<String> RawItemUbarHeightUnit;
    private javax.swing.JTextField RawItemUbarLength;
    private javax.swing.JComboBox<String> RawItemUbarLengthUnit;
    private javax.swing.JTextField RawItemUbarQty;
    private javax.swing.JTextField RawItemUbarROL;
    private javax.swing.JTextField RawItemUbarThickness;
    private javax.swing.JComboBox<String> RawItemUbarThicknessUnit;
    private javax.swing.JTextField RawItemUbarWeight;
    private javax.swing.JComboBox<String> RawItemUbarWeightUnit;
    private javax.swing.JTextField RawItemUbarWidth;
    private javax.swing.JComboBox<String> RawItemUbarWidthUnit;
    private javax.swing.JPanel RollerShutterBeltPnl;
    private javax.swing.JLabel SPArrowLbl;
    private javax.swing.JLabel SPBraIDLabel;
    private javax.swing.JLabel SPBraNameLabel;
    private javax.swing.JButton SPBranchersBtn;
    private javax.swing.JButton SPChequeBtn1;
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
    private javax.swing.JPanel SideBeadingPnl;
    private javax.swing.JPanel SideLockPnl;
    private javax.swing.JPanel SpringPnl;
    private javax.swing.JLabel Timelbl;
    private javax.swing.JLabel Timelbl1;
    private javax.swing.JPanel TopPanel;
    private javax.swing.JPanel TopicPanel;
    private javax.swing.JPanel UBarPnl;
    private javax.swing.JPanel UChannelBeadingPnl;
    private javax.swing.JLabel UserNameDisplayLabel;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton25;
    private javax.swing.JLabel jLabel176;
    private javax.swing.JLabel jLabel177;
    private javax.swing.JLabel jLabel178;
    private javax.swing.JLabel jLabel179;
    private javax.swing.JLabel jLabel180;
    private javax.swing.JLabel jLabel181;
    private javax.swing.JLabel jLabel182;
    private javax.swing.JLabel jLabel183;
    private javax.swing.JLabel jLabel184;
    private javax.swing.JLabel jLabel185;
    private javax.swing.JLabel jLabel186;
    private javax.swing.JLabel jLabel187;
    private javax.swing.JLabel jLabel188;
    private javax.swing.JLabel jLabel189;
    private javax.swing.JLabel jLabel190;
    private javax.swing.JLabel jLabel191;
    private javax.swing.JLabel jLabel192;
    private javax.swing.JLabel jLabel193;
    private javax.swing.JLabel jLabel194;
    private javax.swing.JLabel jLabel195;
    private javax.swing.JLabel jLabel196;
    private javax.swing.JLabel jLabel197;
    private javax.swing.JLabel jLabel198;
    private javax.swing.JLabel jLabel199;
    private javax.swing.JLabel jLabel200;
    private javax.swing.JLabel jLabel201;
    private javax.swing.JLabel jLabel202;
    private javax.swing.JLabel jLabel203;
    private javax.swing.JLabel jLabel204;
    private javax.swing.JLabel jLabel205;
    private javax.swing.JLabel jLabel206;
    private javax.swing.JLabel jLabel207;
    private javax.swing.JLabel jLabel208;
    private javax.swing.JLabel jLabel209;
    private javax.swing.JLabel jLabel210;
    private javax.swing.JLabel jLabel211;
    private javax.swing.JLabel jLabel212;
    private javax.swing.JLabel jLabel213;
    private javax.swing.JLabel jLabel214;
    private javax.swing.JLabel jLabel215;
    private javax.swing.JLabel jLabel226;
    private javax.swing.JLabel jLabel227;
    private javax.swing.JLabel jLabel228;
    private javax.swing.JLabel jLabel230;
    private javax.swing.JLabel jLabel231;
    private javax.swing.JLabel jLabel232;
    private javax.swing.JLabel jLabel233;
    private javax.swing.JLabel jLabel235;
    private javax.swing.JLabel jLabel236;
    private javax.swing.JLabel jLabel246;
    private javax.swing.JLabel jLabel247;
    private javax.swing.JLabel jLabel248;
    private javax.swing.JLabel jLabel249;
    private javax.swing.JLabel jLabel250;
    private javax.swing.JLabel jLabel251;
    private javax.swing.JLabel jLabel252;
    private javax.swing.JLabel jLabel253;
    private javax.swing.JLabel jLabel254;
    private javax.swing.JLabel jLabel255;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel265;
    private javax.swing.JLabel jLabel266;
    private javax.swing.JLabel jLabel267;
    private javax.swing.JLabel jLabel268;
    private javax.swing.JLabel jLabel269;
    private javax.swing.JLabel jLabel271;
    private javax.swing.JLabel jLabel272;
    private javax.swing.JLabel jLabel273;
    private javax.swing.JLabel jLabel274;
    private javax.swing.JLabel jLabel275;
    private javax.swing.JLabel jLabel276;
    private javax.swing.JLabel jLabel277;
    private javax.swing.JLabel jLabel278;
    private javax.swing.JLabel jLabel279;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel280;
    private javax.swing.JLabel jLabel281;
    private javax.swing.JLabel jLabel282;
    private javax.swing.JLabel jLabel283;
    private javax.swing.JLabel jLabel284;
    private javax.swing.JLabel jLabel285;
    private javax.swing.JLabel jLabel286;
    private javax.swing.JLabel jLabel287;
    private javax.swing.JLabel jLabel288;
    private javax.swing.JLabel jLabel289;
    private javax.swing.JLabel jLabel290;
    private javax.swing.JLabel jLabel291;
    private javax.swing.JLabel jLabel292;
    private javax.swing.JLabel jLabel293;
    private javax.swing.JLabel jLabel294;
    private javax.swing.JLabel jLabel295;
    private javax.swing.JLabel jLabel296;
    private javax.swing.JLabel jLabel297;
    private javax.swing.JLabel jLabel298;
    private javax.swing.JLabel jLabel299;
    private javax.swing.JLabel jLabel300;
    private javax.swing.JLabel jLabel301;
    private javax.swing.JLabel jLabel302;
    private javax.swing.JLabel jLabel303;
    private javax.swing.JLabel jLabel304;
    private javax.swing.JLabel jLabel305;
    private javax.swing.JLabel jLabel306;
    private javax.swing.JLabel jLabel307;
    private javax.swing.JLabel jLabel308;
    private javax.swing.JLabel jLabel309;
    private javax.swing.JLabel jLabel310;
    private javax.swing.JLabel jLabel311;
    private javax.swing.JLabel jLabel312;
    private javax.swing.JLabel jLabel313;
    private javax.swing.JLabel jLabel314;
    private javax.swing.JLabel jLabel315;
    private javax.swing.JLabel jLabel316;
    private javax.swing.JLabel jLabel317;
    private javax.swing.JLabel jLabel318;
    private javax.swing.JLabel jLabel319;
    private javax.swing.JLabel jLabel320;
    private javax.swing.JLabel jLabel321;
    private javax.swing.JLabel jLabel322;
    private javax.swing.JLabel jLabel323;
    private javax.swing.JLabel jLabel324;
    private javax.swing.JLabel jLabel325;
    private javax.swing.JLabel jLabel326;
    private javax.swing.JLabel jLabel327;
    private javax.swing.JLabel jLabel329;
    private javax.swing.JLabel jLabel331;
    private javax.swing.JLabel jLabel335;
    private javax.swing.JLabel jLabel336;
    private javax.swing.JLabel jLabel337;
    private javax.swing.JLabel jLabel340;
    private javax.swing.JLabel jLabel431;
    private javax.swing.JLabel jLabel432;
    private javax.swing.JLabel jLabel433;
    private javax.swing.JLabel jLabel434;
    private javax.swing.JLabel jLabel435;
    private javax.swing.JLabel jLabel436;
    private javax.swing.JLabel jLabel437;
    private javax.swing.JLabel jLabel438;
    private javax.swing.JLabel jLabel439;
    private javax.swing.JLabel jLabel440;
    private javax.swing.JLabel jLabel441;
    private javax.swing.JLabel jLabel442;
    private javax.swing.JLabel jLabel443;
    private javax.swing.JLabel jLabel444;
    private javax.swing.JLabel jLabel445;
    private javax.swing.JLabel jLabel446;
    private javax.swing.JLabel jLabel447;
    private javax.swing.JLabel jLabel448;
    private javax.swing.JLabel jLabel449;
    // End of variables declaration//GEN-END:variables
}
