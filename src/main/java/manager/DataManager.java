package manager;

import BD.DBHandler;
import Noise.Noise;
import models.BuilderCar.Car;
import models.UserBuilder.User;
import net.NetHelper;
import net.NetHelperB;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//singlton сделать в этом классе!!!!
//использовать builder для заполнения моделей
// пользовательский ввод через паттерн Слушатель

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

    public int addUser(User u){

        user = u;
        int reg = NetHelperB.Seril(u);
        return reg;

    }

    public void addCar(Car c){

        car = c;

    }

}