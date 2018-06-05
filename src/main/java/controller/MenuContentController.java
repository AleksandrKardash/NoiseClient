package controller;

import Noise.Noise;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuContentController implements Initializable {


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    //методы для навигации в меню по элементам
    @FXML
    void selectFloor(ActionEvent event) {

        Noise.getNavigation().getCalculatingCarController().materialData.setAll(Noise.getNavigation()
                .getCalculatingCarController().calculateCar.getFloor());

    }

    @FXML
    void selectDoor(ActionEvent event) {

        Noise.getNavigation().getCalculatingCarController().materialData.setAll(Noise.getNavigation()
                .getCalculatingCarController().calculateCar.getDoor());

    }

    @FXML
    void selectTrunk(ActionEvent event) {

        Noise.getNavigation().getCalculatingCarController().materialData.setAll(Noise.getNavigation()
                .getCalculatingCarController().calculateCar.getTrunk());

    }

    @FXML
    void selectHood(ActionEvent event) {

        Noise.getNavigation().getCalculatingCarController().materialData.setAll(Noise.getNavigation()
                .getCalculatingCarController().calculateCar.getHood());

    }

    @FXML
    void selectRoof(ActionEvent event) {

        Noise.getNavigation().getCalculatingCarController().materialData.setAll(Noise.getNavigation()
                .getCalculatingCarController().calculateCar.getRoof());

    }

    @FXML
    void selectArch(ActionEvent event) {

        Noise.getNavigation().getCalculatingCarController().materialData.setAll(Noise.getNavigation()
                .getCalculatingCarController().calculateCar.getArch());

    }

    @FXML
    void selectWalls(ActionEvent event) {

        Noise.getNavigation().getCalculatingCarController().materialData.setAll(Noise.getNavigation()
                .getCalculatingCarController().calculateCar.getWalls());

    }

    @FXML
    void selectAll(ActionEvent event) {

        Noise.getNavigation().getCalculatingCarController().materialData.setAll(Noise.getNavigation()
                .getCalculatingCarController().calculateCar.getAllElements());

    }

}
