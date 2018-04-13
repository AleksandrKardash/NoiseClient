package UI.controller;


import BD.DBHandler;
import Noise.Noise;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import manager.DataManager;
import models.UserBuilder.User;
import net.MyRequest;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class RegController extends BaseController implements Initializable {

    @FXML
    private TextField login;

    @FXML
    private Label labelError;

    @FXML
    private PasswordField password;

    private DBHandler handler;
    private Connection connection;
    private PreparedStatement pst;
    private User user;

    //иницилизация подключения к БД
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        handler = DBHandler.getInstance();

    }

    //переход на предыдущую страницу
    @FXML
    void cancelReg(ActionEvent event) {

        Noise.getNavigation().GoBack();
    }

    //действие "войти"
    @FXML
    void logIn(ActionEvent event) {

        //ArrayList с логином и паролем для формирования запроса на сервер
        ArrayList<String> list = new ArrayList<String>();
        list.add(login.getText());
        list.add(password.getText());

        //отправляем запрос на сервер и получаем ответ, приводим к классу User
        MyRequest request = DataManager.getInstance().addRequest(list);
        User user = (User)request.getData();


        //Проверяем ответ на наличие не пустого класса User
        if (user != null) {
            //добавляем обьект User в DataManager
            User.reg = true;
            DataManager.getInstance().addExistUser(user);
            //переход на главную страницу
            Noise.getNavigation().load("/view/mainWindow.fxml").Show();

          //в случае отсутствия совпадений логин/пароль
        } else {
            labelError.setText("Введены некорректные данные!");
        }
    }

    //переход к регистрации
    @FXML
    void showSignUp(ActionEvent event) {

        Noise.getNavigation().load("/view/signUp.fxml").Show();
    }

}
