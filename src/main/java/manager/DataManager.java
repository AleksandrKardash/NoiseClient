package manager;

import models.BuilderCar.Car;
import models.UserBuilder.User;
import net.MyRequest;
import net.NetHelper;

import java.util.ArrayList;

//singleton в этом классе!!!!
//использовать builder для заполнения моделей
//пользовательский ввод через паттерн Слушатель

//хранит экзэмпляры классов
public class DataManager {

    private static DataManager instance;

    private DataManager(){
    };

    public static DataManager getInstance() {

        if(instance==null)
            instance = new DataManager();

        return instance;
    }

//заменить на коллекции
public User user;
public Car car;
private MyRequest request;
private NetHelper netHelper;

    public void addExistUser(User u){
    user = u;
};

    public int addUser(User u){

        user = u;
        netHelper = NetHelper.getInstance();
        int reg = 0;
        MyRequest r=null;

        //запаковываем обьект User в обьект с инструкциями для его обработки на сервере
        MyRequest us = new MyRequest(MyRequest.RequestType.USER, user);

        //передаем обект MyRequest на сервер с помощью метода Serial класса NetHelper и получаем ответ в виде обьекта MyRequest
        try {
            r = netHelper.Serial(us);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //записываем результат приводя к типу Integer
        reg = (Integer) r.getData();

        //ответ с сервера о результате обработки обьекта User
        return reg;
    }

    public void addCar(Car c){

        car = c;

    }

    public MyRequest addRequest(ArrayList list){

        MyRequest r=null;

        netHelper = NetHelper.getInstance();

        //запаковываем запрос в виде ArrayList в обьект с инструкциями для его обработки на сервере
        request = new MyRequest(MyRequest.RequestType.LIST, list);

        //передаем обект MyRequest на сервер с помощью метода Serial класса NetHelper и получаем ответ
        try {
            r = netHelper.Serial(request);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //ответ с сервера о результате обработки обьекта Request
        return r;
    }

}