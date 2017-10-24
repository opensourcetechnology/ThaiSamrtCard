package com.java.hosos.nhso.readfile;

import com.java.hosos.nhso.exception.exceptionNHSO;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadDataInNHSO {

    private static readFileInterface readFile;

    private static final String PATH_TEXT = "src\\com\\java\\hosos\\nhso\\readfile\\path.txt";

    private exceptionNHSO exception;

    public ReadDataInNHSO() {
        readFile = new ReadTextFileNHSO(PATH_TEXT);
    }

    private String readFileNSHO() {

        String text = null;
        BufferedReader br = null;

        String path = readFile.getSplitText();

        try {

            br = new BufferedReader(new FileReader(path));

            StringBuilder sb = new StringBuilder();
            String readLine = br.readLine();
            while (readLine != null) {
                sb.append(readLine);
                readLine = br.readLine();
            }

            text = sb.toString();

        } catch (FileNotFoundException ex) {
            exception = new exceptionNHSO();
            exception.ExceptionNotFoundFileNHSO(ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return text;
    }

    public Nhso getTokenAndPID() {
        Nhso nhso = null;
        try {
            nhso = new Nhso();
            String tok_pID = readFileNSHO();
            String[] ids = tok_pID.split("#");

            nhso.setID_REQ_TOK(ids[0]);
            nhso.setTOKEN_ID(ids[1]);
        } catch (Exception ex) {
            exception = new exceptionNHSO();
            exception.ExceptionNotFoundFileNHSO(ex.getMessage());
            throw new RuntimeException();
        }
        return nhso;
    }

}
