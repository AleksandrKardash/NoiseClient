package net;

import models.UserBuilder.User;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class NetHelperB {

    public static int Seril(User u) {
        Socket fromserver = null;

        try{
            fromserver = new Socket(InetAddress.getByName("127.0.0.1"), 4444);
        }catch (Exception e) {
            try {
                fromserver = new Socket("127.0.0.1", 4444);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }


        BufferedOutputStream bos = null;
        try {
            bos = new BufferedOutputStream(fromserver.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(bos);
        } catch (IOException e) {
            e.printStackTrace();
        }



        try {
            oos.writeObject(u);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }



        BufferedReader in  = null;
        try {
            in = new
                    BufferedReader(new
                    InputStreamReader(fromserver.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }


        String answer="0";

        try {
            answer = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fromserver.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        return Integer.parseInt(answer);
    }

}
