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

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

        //Проверка соответствия логина и пароля
        connection = handler.getConnection();
        String q1 = "SELECT * from users where login=? and password=?";

        try {
            pst = (com.mysql.jdbc.PreparedStatement) connection.prepareStatement(q1);

            pst.setString(1, login.getText());
            pst.setString(2, password.getText());
            ResultSet rs = pst.executeQuery();

            int count = 0;

            while (rs.next()) {
                count++;
            }

            if (count == 1) {
                //вернуться к найденой записи с логином и паролем  и загрузить данные User в программу
                rs.previous();
                user =  new User.Builder()
                        .setName(rs.getString(2))
                        .setCity(rs.getString(3))
                        .setAdress(rs.getString(4))
                        .setMail(rs.getString(5))
                        .setPhone(rs.getString(6))
                        .setLogin(rs.getString(7))
                        .setPassword(rs.getString(8))
                        .build();
                //добавляем User в DataManager
                DataManager.getInstance().addUser(user);
                //переход на главную страницу
                Noise.getNavigation().load("/view/mainWindow.fxml").Show();
            //в случае отсутствия совпадений логин/пароль
            } else {
                labelError.setText("Введены некорректные данные!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        //закрываем соединение с БД
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //переход к регистрации
    @FXML
    void showSignUp(ActionEvent event) {

        Noise.getNavigation().load("/view/signUp.fxml").Show();
    }

}
