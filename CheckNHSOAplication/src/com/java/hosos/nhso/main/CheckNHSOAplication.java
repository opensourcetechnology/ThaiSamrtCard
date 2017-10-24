package com.java.hosos.nhso.main;

import com.java.hosos.nhso.exception.exceptionNHSO;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import th.go.nhso.ucws.tokenws.NhsoDataSetC1;
import th.go.nhso.ucws.tokenws.UCWSTokenP1;
import th.go.nhso.ucws.tokenws.UCWSTokenP1_Service;

public class CheckNHSOAplication extends Application {

    private Stage stage;

    private NhsoDataSetC1 nhso_data_set;

    private exceptionNHSO exception;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            stage = primaryStage;
            stage.setTitle("NHSO V.1.0");
            stage.centerOnScreen();
            stage.setResizable(false);
            //gotoDataForm();
            gotoFormNhso();
            primaryStage.show();
        } catch (Exception ex) {
            ex.getMessage();
        }
    }

// ถ้าค่าที่รับมาไม่เท่ากับค่าว่างจะมีการเข้าสู่ฟอร์มสำหรับดูข้อมูล สปสช
    public boolean gotoNextForm(String ID_REQ_TOK, String TOKEN_ID, String ID_REQ_INFOR) {
        if ((ID_REQ_TOK != null) && (TOKEN_ID != null) && (ID_REQ_INFOR != null)) {

            nhso_data_set = searchCurrentByPID(ID_REQ_TOK, TOKEN_ID, ID_REQ_INFOR);

            if (nhso_data_set.getWsStatus().equals("NHSO-00003")) {
                exception = new exceptionNHSO();
                exception.ExceptionToken(nhso_data_set.getWsStatusDesc());
                //gotoDataForm();
            } else {
                gotoDataForm();
            }
            return true;
        } else {
            System.out.println("Value is Null");
            return false;
        }
    }

// กลับสู่ฟอร์มหลัก
    void userBack() {
        gotoFormNhso();
    }

//  ไปยังฟอร์มแรก
    private void gotoFormNhso() {
        try {
            FXMLDocumentController mainForm = (FXMLDocumentController) replaceSceneContent("FXMLDocument.fxml");
            mainForm.setMain(this);
        } catch (Exception ex) {
            Logger.getLogger(CheckNHSOAplication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//  ไปยังฟอร์มสำหรับดูข้อมูล
    private void gotoDataForm() {
        try {
            DATANHSODocumentController dataForm = (DATANHSODocumentController) replaceSceneContent("DATANHSODocument.fxml");
            dataForm.setMain(this);
        } catch (Exception ex) {
            Logger.getLogger(CheckNHSOAplication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

// เว็บเซอร์วิชสำหรับดูข้อมูล สปสช
    public static NhsoDataSetC1 searchCurrentByPID(String userPersonId, String smctoken, String personId) {
        UCWSTokenP1_Service service = new UCWSTokenP1_Service();
        UCWSTokenP1 port = service.getUCWSTokenP1Port();
        return port.searchCurrentByPID(userPersonId, smctoken, personId);
    }

//  ใช้สำหรับอ่านไฟล์ .fxml
    private Initializable replaceSceneContent(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        InputStream in = CheckNHSOAplication.class.getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(CheckNHSOAplication.class.getResource(fxml));

        Parent root = loader.load(in);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.sizeToScene();

        return (Initializable) loader.getController();
    }
}
