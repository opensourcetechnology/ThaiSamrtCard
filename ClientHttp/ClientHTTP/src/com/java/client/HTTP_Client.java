package com.java.client;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import com.hostos.lib.thaismartcard.model.MoiApplet1Info;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import javax.smartcardio.CardException;

public class HTTP_Client {

    private static DataFromCard data ;
    private DataServices service;
    private String setURL;
    private String id;
    private JSONObject json;
    private static DataErrorSevices dataError;
    private MoiApplet1Info moi;
    
    public URL url;
    public URI uri;
    public HttpURLConnection conn;
    public OutputStreamWriter out;

    public HTTP_Client(URI uri) throws IOException, CardException, JSONException, URISyntaxException {
        this.uri = uri;
        
        data = new DataFromCard();
        moi = new MoiApplet1Info();
        service = new DataServices();
        dataError = new DataErrorSevices();
        json = new JSONObject();
        
        connectToServer();
    }
    
    public String putDataJSON() throws CardException, IOException, JSONException {

// gen byte array to base64 to show image in HTML
        String encoded = Base64.getEncoder().encodeToString(moi.getFacesImage());

// Split query             
        String query = new String(uri.getQuery());
        String[] splitQuery = query.split("=");
// input data to json
        for (int i = 0; i < splitQuery.length; i++) {
            json.put("identify", splitQuery[1]);
        }
        json.put("pid", moi.getPid());
        json.put("prefix", moi.getThaiName().getTitle());
        json.put("firstname", moi.getThaiName().getFirstName());
        json.put("lastname", moi.getThaiName().getLastName());
        json.put("house", service.getHouse());
        json.put("moo", service.getMoo());
        json.put("tambon", service.getTambon());
        json.put("amphur", service.getAmphur());
        json.put("changwat", service.getChangwat());
        json.put("gender", service.getGender());
        json.put("birthdate", service.getFormatBOD());
        json.put("faces_image", encoded);
        
        return json.toString();
    }
    
    public String ErrorDataJSON() throws JSONException {
        String query = new String(uri.getQuery());
        String[] splitQuery = query.split("=");
        for (int i = 0; i < splitQuery.length; i++) {
            json.put("identify", splitQuery[1]);
        }
        System.out.println("test : " + dataError.getErrorCard());
        json.put("ErrorCardMessage", "กรุณาตรวจสอบเครื่องอ่านบัตรสมาร์ทการ์ด และลองใหม่อีกครั้ง");
        
        return json.toString();
    }
    
    private void connectToServer() throws MalformedURLException, IOException, CardException, JSONException {
        try {
            url = new URL("http://" + uri.getHost() + ":" + uri.getPort() + "/?" + uri.getQuery());
            conn = (HttpURLConnection) url.openConnection();

            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");

            out = new OutputStreamWriter(
                    conn.getOutputStream(), "UTF-8");

            out.write(putDataJSON());
            out.flush();
            out.close();
            System.err.println(conn.getResponseCode());
            System.err.println(conn.getResponseMessage());
            
        } catch (Exception ex) {

            url = new URL("http://" + uri.getHost() + ":" + uri.getPort() + "/?" + uri.getQuery());
            conn = (HttpURLConnection) url.openConnection();
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");

            out = new OutputStreamWriter(
                    conn.getOutputStream(), "UTF-8");

            out.write(ErrorDataJSON());

            out.close();
            conn.getInputStream();
        }
    }
}
