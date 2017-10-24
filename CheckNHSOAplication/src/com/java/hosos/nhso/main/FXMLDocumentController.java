/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.hosos.nhso.main;

import com.java.hosos.nhso.exception.exceptionNHSO;
import com.java.hosos.nhso.readcard.ReadCard;
import com.java.hosos.nhso.readfile.CheckDate;
import com.java.hosos.nhso.readfile.ReadDataInNHSO;
import com.java.hosos.nhso.readfile.ReadTextFilePath;
import com.java.hosos.nhso.readfile.readFileInterface;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class FXMLDocumentController implements Initializable {

    private static final String PATH_TEXT = "src\\com\\java\\hosos\\nhso\\readfile\\path.txt";

    private readFileInterface readFile;

    private ReadDataInNHSO readData = new ReadDataInNHSO();

    private CheckDate check = new CheckDate();

//  เรียกข้อมูลจากบัตรประชาชน
    private ReadCard readCard;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button checkBtn;

    @FXML
    private Button tokenBtn;

    private CheckNHSOAplication main;

    private exceptionNHSO exception;

    public void setMain(CheckNHSOAplication mainnhso) {
        this.main = mainnhso;
    }

    public CheckNHSOAplication getMain() {
        return main;
    }

//  ปุ่มสำหรับ ตรวจสอบสิทธิ์
    @FXML
    void checkBtnAction(ActionEvent event) {

        if (main == null) {
            System.err.println("Main has Null value!!!");
        } else {
            try {
                /**
                 * เป็นการตรวจสอบค่าวันที่ของไฟล์ nhso_token
                 * เปรียบเทียบกับวันที่ปัจจุบัน ถ้าวันที่ที่เปรียบกันแล้วค่าเป็น
                 * true จะเข้าไปทำงานต่อไป ถ้าค่าที่เปรียบเทียบเป็น false
                 * จะทำการลบไฟล์ nhso_token
                 */
                if (check.checkDateInFile()) {
//                  สร้าง object สำหรับสั่งให้เครื่องอ่านสมาร์ทการ์ดทำงาน
                    readCard = new ReadCard();
//                  เรียกเมธอดสหรับเรียก Token ID และ Personal ID
                    readData.getTokenAndPID();
                    String card = readCard.callDataFromCard().getPid();
//                  รับค่าเลขบัตรประชาชนจากเครื่องอ่านการ์ด และเซ้ตค่าสำหรับนำไปใช้ในคลาสอื่นๆ
                    readData.getTokenAndPID().setID_REQ_INFOR(card);
                    System.out.println("Personal ID : " + card);
//                  ส่งค่าไปยัง Main Class ที่เมธอด gotoNextForm() เพื่อทำให้ระบบสามารถดูค่า สปสช ได้

                    main.gotoNextForm(readData.getTokenAndPID().getID_REQ_TOK(),
                            readData.getTokenAndPID().getTOKEN_ID(),
                            card);

                } else if (check.deleteFile() == true) {
                    //exception = new exceptionNHSO();
                    //exception.DeleteFileSuccess();
                    System.err.println("Delete file Success!!!");
                }
            } catch (Exception ex) {
                System.err.println("Error : " + ex.getMessage());
            }
        }
    }

// ปุ่มขอ  Token ID
    @FXML
    void tokenBtnAction(ActionEvent event) {
        try {
            readFile = new ReadTextFilePath(PATH_TEXT);
            String path = readFile.getSplitText();
            Runtime rn = Runtime.getRuntime();
            Process pr = rn.exec(path);
        } catch (Exception ex) {
            System.err.println("Error : " + ex.getMessage());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
