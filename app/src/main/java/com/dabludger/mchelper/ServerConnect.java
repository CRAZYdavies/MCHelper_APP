package com.dabludger.mchelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Brandon Davies on 5/25/2016.
 */
public class ServerConnect {

    private String host;
    private int port;
    private Socket socket;

    ServerConnect(String _host, int _port){
        this.host = _host;
        this.port = _port;
        this.socket = getSocket();
    }

    private Socket getSocket(){
        if(this.host != null && this.port > 0){
            try {
                Socket theSocket = new Socket(host,port);
                return theSocket;
            } catch (IOException e) {
                e.printStackTrace();
                //TODO: add exception handling.
            }
        }
        return null;
    }

    public BufferedReader getBufferedReader(){
        try {
            return new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
            //TODO: add exception handling.
        }
        return null;
    }

    public PrintWriter getPrintWriter(){
        try {
            return new PrintWriter(this.socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
            //TODO: add exception handling.
        }
        return null;
    }
}
