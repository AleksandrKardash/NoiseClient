package UI.controller;

import Noise.Noise;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import manager.DataManager;
import models.Calculate.CalculatePassengerCar;
import models.Table.MaterialTable;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuContentController implements Initializable {


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    //методы для навигации в меню по элементам
    @FXML
    void selectFloor(ActionEvent event) {

        Navigation.controller.materialData.setAll( Navigation.controller.calculateCar.getFloor());

    }

    @FXML
    void selectDoor(ActionEvent event) {

        Navigation.controller.materialData.setAll( Navigation.controller.calculateCar.getDoor());

    }

    @FXML
    void selectTrunk(ActionEvent event) {

        Navigation.controller.materialData.setAll( Navigation.controller.calculateCar.getTrunk());

    }

    @FXML
    void selectHood(ActionEvent event) {

        Navigation.controller.materialData.setAll( Navigation.controller.calculateCar.getHood());

    }

    @FXML
    void selectRoof(ActionEvent event) {

        Navigation.controller.materialData.setAll( Navigation.controller.calculateCar.getRoof());

    }

    @FXML
    void selectArch(ActionEvent event) {

        Navigation.controller.materialData.setAll( Navigation.controller.calculateCar.getArch());

    }

    @FXML
    void selectWalls(ActionEvent event) {

        Navigation.controller.materialData.setAll( Navigation.controller.calculateCar.getWalls());

    }

    @FXML
    void selectAll(ActionEvent event) {

        Navigation.controller.materialData.setAll( Navigation.controller.calculateCar.getAllElements());

    }

}
