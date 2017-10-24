package com.java.hosos.nhso.readcard;

import com.hostos.lib.thaismartcard.cardreader.pcscServices;
import com.hostos.lib.thaismartcard.model.MoiApplet1Info;
import com.java.hosos.nhso.exception.exceptionNHSO;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.smartcardio.*;

public class ReadCard {

    private exceptionNHSO exception;

    private void readCard() {
        try {
            pcscServices pcsc = new pcscServices(); //  Object ที่ใช้ในการ Gen ข้อมูลจากบัตร
            TerminalFactory factory = TerminalFactory.getDefault();
            List<CardTerminal> terminals = factory.terminals().list(); // ตรวจสอบว่ามีเครื่องอ่านบัตรที่เสียบอยู่กับคอมพิวเตอร์กี่เครื่อง

            CardTerminal terminal = terminals.get(0); // เรียกเครื่องอ่านสมาร์ทการ์ดที่มีสถานะ Active อยู่

            Card card = terminal.connect("*"); // เป็นเชื่อต่อกับเครื่องอ่านสมาร์ทการ์ดโดยจะไปหาเครื่องที่ Active อยู่ที่อยู่ในตำแหน่งที่ 0

            pcsc.getAvialableDataInfo(card, true); // เป็นการเรียกเมทธอดจาก Class pcscService หากต้องการรูปให้ใส่ true ลงในเมทธอด

            card.disconnect(true); // เมื่อเครื่องอ่านสมาร์ทการ์ดอ่านเสร็จก็จะทำการ Disconnect
        } catch (CardException ex) {
            exception = new exceptionNHSO();
            exception.ExceptionOfCard(ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
    }

    public MoiApplet1Info callDataFromCard() {
        readCard();
        MoiApplet1Info moi = new MoiApplet1Info();

        return moi;
    }
}
