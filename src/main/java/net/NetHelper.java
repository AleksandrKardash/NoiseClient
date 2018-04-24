package net;

import models.UserBuilder.User;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

//класс (singleton) для соединения и обмена данными с сервером с помощью Socket (можно заменить на SocketChannel)
public class NetHelper {

    private static NetHelper instance;

    private NetHelper(){};

    public static NetHelper getInstance() {

        if(instance==null)
            instance = new NetHelper();

        return instance;
    }

    private Socket fromserver = null;
    private BufferedOutputStream bos = null;
    private ObjectOutputStream oos = null;
    private MyRequest answer;

    //метод для передачи обьекта MyRequest на сервер и получение ответа в виде такого же обьекта
    public MyRequest Serial(MyRequest r) throws Exception {

        try{
            //создаем соединение с сервером
            fromserver = new Socket(InetAddress.getByName("127.0.0.1"), 4444);

            //определяем выходной поток сокета и конвертируем поток в другой тип для работы с обьектом
            bos = new BufferedOutputStream(fromserver.getOutputStream());
            oos = new ObjectOutputStream(bos);

            //записываем обьект и заставляем поток закончить передачу данных
            oos.writeObject(r);
            oos.flush();

            //определяем входной поток сокета и считываем ответ, приводя его к классу MyRequest
            BufferedInputStream bis = new BufferedInputStream(fromserver.getInputStream());
            ObjectInputStream ois = new ObjectInputStream(bis);
            answer = (MyRequest)ois.readObject();

            //закрываем потоки и соединение
            bis.close();
            ois.close();
            oos.close();
            bos.close();
            fromserver.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        //возвращаем результат с сервера
        return answer;
    }

}
