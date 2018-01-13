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

        if (User.reg==true) {

        authorization.setText("Thanks!");
        authorization.setDisable(true);

    }

    }


    @FXML
    void showReg(ActionEvent event) {

        Noise.getNavigation().load("/view/reg.fxml").Show();

    }

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
