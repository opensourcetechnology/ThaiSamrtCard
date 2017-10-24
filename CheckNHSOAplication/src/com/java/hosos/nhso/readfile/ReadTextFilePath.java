package com.java.hosos.nhso.readfile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadTextFilePath implements readFileInterface {

    private String path_text;

    public ReadTextFilePath(String path_text) {
        this.path_text = path_text;
    }

    @Override
    public String getFile() {
        String text = null;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(path_text));
            StringBuilder sb = new StringBuilder();
            String readLine = br.readLine();
            while (readLine != null) {
                sb.append(readLine);
                sb.append(System.lineSeparator());
                readLine = br.readLine();
            }

            String path = sb.toString();
            String[] paths = path.split("\n");

            for (int i = 0; i < paths.length; i++) {
                text = paths[0];
            }

        } catch (FileNotFoundException ex) {
            throw new RuntimeException();
        } catch (IOException ex) {
            throw new RuntimeException();
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                ex.getMessage();
            }
        }
        return text;
    }

    @Override
    public String getSplitText() {
        String text = null;
        String split = getFile();
        String[] splits = split.split("=");

        for (int i = 0; i < splits.length; i++) {
            text = splits[1];
        }
        return text;
    }
}
