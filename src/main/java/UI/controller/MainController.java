package UI.controller;


import Noise.Noise;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import manager.DataManager;
import models.BuilderCar.CarBuilder;
import models.BuilderCar.Director;
import models.UserBuilder.User;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController extends BaseController implements Initializable  {

    @FXML
    private Button authorization;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //деактивируем кнопку "залогиниться", если пользователь уже вошел в систему
        if (User.reg==true) {

        authorization.setText("Thanks!");
        authorization.setDisable(true);

    }

    }


    @FXML
    void showReg(ActionEvent event) {

        Noise.getNavigation().load("/view/reg.fxml").Show();

    }


    //actions отвечающие за выбор пользователем типа автомобиля
    //в каждом из них создается обьект Car с помощью CarBuilder и записывается в DataManager
    @FXML
    void buildPassengerCar(ActionEvent event) {
        Director director = new Director();
        CarBuilder builder = new CarBuilder();
        director.makePassengerCar(builder);
        models.BuilderCar.Car car = builder.getResult();
        DataManager.getInstance().addCar(car);

        Noise.getNavigation().load("/view/optionsCar.fxml").Show();

    }

    @FXML
    void buildBusCar(ActionEvent event) {
        Director director = new Director();
        CarBuilder builder = new CarBuilder();
        director.makeBus(builder);
        models.BuilderCar.Car car = builder.getResult();
        DataManager.getInstance().addCar(car);

        Noise.getNavigation().load("/view/optionsCar.fxml").Show();

    }

    @FXML
    void buildTruckCar(ActionEvent event) {
        Director director = new Director();
        CarBuilder builder = new CarBuilder();
        director.makeTruck(builder);
        models.BuilderCar.Car car = builder.getResult();
        DataManager.getInstance().addCar(car);

        Noise.getNavigation().load("/view/optionsCar.fxml").Show();

    }

}
