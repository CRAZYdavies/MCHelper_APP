package com.dabludger.mchelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Brandon Davies on 6/1/2016.
 */
public class ClientThread implements Runnable{

    ServerConnect serverConnect = null;

    @Override
    public void run() {
        this.serverConnect = new ServerConnect("192.168.1.53", 8787);
        PrintWriter out = serverConnect.getPrintWriter();
        out.println("GET FAVORITES");
        BufferedReader in = serverConnect.getBufferedReader();
        String test = null;
        try {
            test = in.readLine();
            while(test != null){
                test.length();
                test = in.readLine();
            }
            test = "END";
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
