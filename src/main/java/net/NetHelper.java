package net;

import models.UserBuilder.User;

import java.io.*;
import java.net.*;

public class NetHelper implements Runnable {

    @Override
    public void run() {

        Socket fromserver = null;

        System.out.println("Connecting to... "+"127.0.0.1");

        try{
            fromserver = new Socket(InetAddress.getByName("127.0.0.1"), 4444);
        }catch (Exception e) {
            try {
                fromserver = new Socket("127.0.0.1", 4444);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        BufferedReader in  = null;
        try {
            in = new
                    BufferedReader(new
                    InputStreamReader(fromserver.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter    out = null;
        try {
            out = new
                    PrintWriter(fromserver.getOutputStream(),true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedReader inu = new
                BufferedReader(new InputStreamReader(System.in));

        String fuser,fserver;

        try {
            while ((fuser = inu.readLine())!=null) {
                out.println(fuser);
                fserver = in.readLine();
                System.out.println(fserver);
                if (fuser.equalsIgnoreCase("close")) break;
                if (fuser.equalsIgnoreCase("exit")) break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
        while ((fserver = in.readLine())!=null) {
            out.println(fuser);
            System.out.println(fserver);
            if (fuser.equalsIgnoreCase("close")) break;
            if (fuser.equalsIgnoreCase("exit")) break;
        }
        */

        //все закрываем
        out.close();
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            inu.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fromserver.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}



