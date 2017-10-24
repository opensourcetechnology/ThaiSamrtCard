package com.java.hosos.nhso.exception;

import javafx.scene.control.Alert;

public class exceptionNHSO {
//  เป็นข้อผิดพลาดจาก Token ของ Service

    public void ExceptionToken(String error) {
        Alert alert = new Alert(Alert.AlertType.WARNING);

        alert.setTitle("ข้อผิดพลาด");
        alert.setHeaderText("Error Token ID or Request Personal ID");
        alert.setContentText(error);

        alert.showAndWait();
    }
//  เป็นข้อผิดพลาดจากการหาไฟล์ nhso_token ในโฟลเดอร์ NHSO

    public void ExceptionNotFoundFileNHSO(String error) {
        Alert alert = new Alert(Alert.AlertType.ERROR);

        alert.setTitle("ข้อผิดพลาด");
        alert.setHeaderText("Error file not found");
        alert.setContentText("ไม่พบไฟล์ nhso_token.txt ในเครื่องคอมพิวเตอร์ของคุณ"
                + "\n\nกรุณาคลิ๊กปุ่ม 'ขอใช้งาน Token' ใหม่อีกครั้ง");

        alert.showAndWait();
    }
//  เป็นข้อผิดพลาดแสดงให้ user สร้างไฟล์ใหม่จากโปรแกรม nhso(สปสช)

    public void ExceptionCreateNewFile(String error) {
        Alert alert = new Alert(Alert.AlertType.WARNING);

        alert.setTitle("ข้อผิดพลาด");
        alert.setHeaderText("Error create new file");
        alert.setContentText(error
                + "\n\nกรุณาคลิ๊กปุ่ม 'ขอใช้งาน Token' เพื่อสร้างไฟล์ใหม่อีกครั้ง");

        alert.showAndWait();
    }

//  เป็นข้อผิดพลาดเกี่ยวกับการอ่านสมาร์ทการ์ด
    public void ExceptionOfCard(String error) {
        Alert alert = new Alert(Alert.AlertType.ERROR);

        alert.setTitle("ข้อผิดพลาด");
        alert.setHeaderText("Error Device or Smartcard");
        alert.setContentText(error
                + "\n\nกรุณาตรวจสอบสมาร์ทการ์ดและเครื่องอ่านการ์ดอีกครั้ง");

        alert.showAndWait();
    }

//  เป็นแจ้งเกี่ยวกับการลบไฟล์ nhso_token
    public void DeleteFileSuccess() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

        alert.setTitle("คุณจะลบไฟล์หรือไม่");
        alert.setHeaderText("Delete file nhso_token.txt");
        alert.setContentText("\n\nคุณได้ทำการลบไฟล์ nhso_token.txt เรียบร้อยแล้ว");

        alert.showAndWait();
    }
}
