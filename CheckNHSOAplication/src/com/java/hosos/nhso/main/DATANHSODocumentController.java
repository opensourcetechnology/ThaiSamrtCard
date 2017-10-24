/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.hosos.nhso.main;

import com.java.hosos.nhso.readfile.DateFormat;
import com.java.hosos.nhso.readfile.ReadDataInNHSO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import th.go.nhso.ucws.tokenws.NhsoDataSetC1;

/**
 * FXML Controller class
 *
 * @author KhonDee
 */
public class DATANHSODocumentController implements Initializable {

//  Call object to show data nhso
    private ReadDataInNHSO readData = new ReadDataInNHSO();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Hyperlink backForm;

    @FXML
    private Label dateTxt;

    @FXML
    private Label fnameTxt;

    @FXML
    private Label hmainTxt;

    @FXML
    private Label hsubTxt;

    @FXML
    private Label lnameTxt;

    @FXML
    private Hyperlink logoutForm;

    @FXML
    private Label mainRightTxt;

    @FXML
    private Label pidTxt;

    @FXML
    private Label provinceTxt;

    private CheckNHSOAplication main;
    private DateFormat date;

    public void setMain(CheckNHSOAplication main) {
        this.main = main;
    }

    @FXML
    void backEvent(ActionEvent event) {
        if (main == null) {
            return;
        }
//      กลับไปยังหน้าแรกของโปรแกรม
        main.userBack();
    }

    @FXML
    void logoutEvent(ActionEvent event) {
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        getData();
    }

    private void getData() {
//      read data in nhso
        try {
//          สร้าง object สำหรับเรียกข้อมูลของ เดือนและปี ในรูปแบบภาษาไทย
            date = new DateFormat();
//          เรียก Service ของ NHSO
            NhsoDataSetC1 nhso
                    = main.searchCurrentByPID(readData.getTokenAndPID().getID_REQ_TOK(),
                            readData.getTokenAndPID().getTOKEN_ID(),
                            readData.getTokenAndPID().getID_REQ_INFOR());

            date.setMonth(nhso.getWsDateRequest().getMonth());
            date.setYear(nhso.getWsDateRequest().getYear());
//          เซ็ตค่าที่ได้จาก Service ลงใน Label ที่สร้างไว้
            pidTxt.setText(nhso.getPersonId());
            fnameTxt.setText(nhso.getFname());
            lnameTxt.setText(nhso.getLname());
            dateTxt.setText(nhso.getWsDateRequest().getDay() + " "
                    + date.thaiOfMonth() + " "
                    + date.thaiOfYear());
            mainRightTxt.setText(nhso.getMaininsclName());
            hsubTxt.setText(nhso.getHsubName());
            hmainTxt.setText(nhso.getHmainName());
            provinceTxt.setText(nhso.getPurchaseprovinceName());
        } catch (Exception ex) {
            System.out.println("Error : " + ex.getMessage());
        }
    }
}
