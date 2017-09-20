package com.java.client;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import javax.smartcardio.CardException;
import org.json.JSONException;

public class Main {
    public static void main(String[] args) throws IOException, CardException, JSONException, URISyntaxException {

        if (args.length == 1) {
            if (args[0].startsWith("nirs:")) {
                URI uri = new URI(args[0]);
                ArrayList<String> adds = new ArrayList<>();
                for (String gen : args) {
                    adds.add(gen);
                }
                for (int i = 0; i < adds.size(); i++) {
                    new HTTP_Client(uri);
                }
            }
        }
        //URI uri = new URI("http://localhost:8888/?identify=1");
        //URI uri = new URI("http://172.16.4.182:8800/?identify=1");
        //new HTTP_Client(uri);
    }
}
