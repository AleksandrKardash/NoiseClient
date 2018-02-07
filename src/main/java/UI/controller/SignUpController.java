package UI.controller;

import BD.DBHandler;
import Noise.Noise;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import models.UserBuilder.User;
import manager.DataManager;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SignUpController extends BaseController implements Initializable {

    @FXML
    private PasswordField password;

    @FXML
    private TextField mail;

    @FXML
    private TextField city;

    @FXML
    private TextField phone;

    @FXML
    private TextField name;

    @FXML
    private TextField adress;

    @FXML
    private TextField login;

    @FXML
    private Label labelError;

    private Connection connection;
    private DBHandler handler;
    private PreparedStatement pst;
    private DataManager manager;
    private User user;


    //иницилизация подключения к БД
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        handler = DBHandler.getInstance();

    }

    //действие "регистрация"
    @FXML
    void register(ActionEvent event) {

        //создание User с помощью фабрики
        user = new User.Builder()
                .setName(name.getText())
                .setCity(city.getText())
                .setAdress(adress.getText())
                .setMail(mail.getText())
                .setPhone(phone.getText())
                .setLogin(login.getText())
                .setPassword(password.getText())
                .build();
        //добавляем User в DataManager
        int reg =  DataManager.getInstance().addUser(user);
        //запись User в базу с помощью метода Create  в DBHandler(c проверкой совпадения)
        //int reg = handler.Create(user);

        //основевя логика "регистрации"
        if (reg==1){
            labelError.setText("Выберите другой Логин!");

        } else if (reg==2){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.getDialogPane().setPrefSize(300, 100);
            alert.setContentText("Вы успешно зарегистрированы");
            alert.show();
            Noise.getNavigation().load("/view/mainWindow.fxml").Show();

        } else {
            labelError.setText("Введены некорректные данные!");
        }
    }
        //переход на предыдущую страницу
        @FXML
        void cancelSignUp(ActionEvent event) {

            Noise.getNavigation().GoBack();
    }

}
