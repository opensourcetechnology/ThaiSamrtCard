package com.java.hosos.nhso.readfile;

import com.java.hosos.nhso.exception.exceptionNHSO;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.StringTokenizer;

public class CheckDate {

    private static final String PATH_TEXT = "src\\com\\java\\hosos\\nhso\\readfile\\path.txt";
    private ReadTextFileNHSO read;

    private DateTimeFormatter dateFormat, timeFormat;
    private LocalDateTime Local_Date_Now, Local_Time_Now;

    private exceptionNHSO exception;

    public CheckDate() {
        read = new ReadTextFileNHSO(PATH_TEXT);
    }

    private Date showDateAndTime() {
        Date date_time = new Date();
        String date = null;
        String time = null;
        try {

            Process proc = Runtime.getRuntime()
                    .exec("cmd /c dir " + read.getSplitText() + " /tc");

            BufferedReader br
                    = new BufferedReader(
                            new InputStreamReader(proc.getInputStream()));

            String data = "";

            for (int i = 0; i < 6; i++) {
                data = br.readLine();
            }

            //split by space
            StringTokenizer st = new StringTokenizer(data);

            date = st.nextToken();//Get date
            time = st.nextToken();//Get time

            date_time.setDate(date);
            date_time.setTime(time);
        } catch (Exception ex) {
            throw new RuntimeException();
        }
        return date_time;
    }

    public boolean checkDateInFile() {
        try {
//call method date of file
            String date = showDateAndTime().getDate();

//Current Date 
            dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            Local_Date_Now = LocalDateTime.now();

            String current_date = dateFormat.format(Local_Date_Now);

            if (current_date.equals(date)) {
                return true;
            } else {
                exception = new exceptionNHSO();
                exception.ExceptionCreateNewFile("ไฟล์ของคุณอาจหมดอายุ หรือ มีการใช้งาน Token ID ของผู้อื่นอยู่");
                return false;
            }
        } catch (Exception ex) {
            exception = new exceptionNHSO();
            exception.ExceptionNotFoundFileNHSO(ex.getMessage());
            System.out.println("Error : " + ex.getMessage());
            throw new RuntimeException();
        }
    }

    public boolean deleteFile() {
        try {
            boolean check = true;

            File file = new File(read.getSplitText());
            if (check) {
                file.delete();
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }
}
