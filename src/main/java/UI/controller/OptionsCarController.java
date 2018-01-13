package UI.controller;


import BD.DBHandler;
import Noise.Noise;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import manager.DataManager;
import models.BuilderCar.TypeAuto;

import java.net.URL;
import java.util.ResourceBundle;

public class OptionsCarController extends BaseController implements Initializable {

    @FXML
    private JFXTextField manufacturerCar;

    @FXML
    private JFXTextField modelCar;

    @FXML
    private JFXComboBox<String> comboBoxClass;

    @FXML
    private JFXToggleButton toggleArch;

    @FXML
    private JFXToggleButton toggleRoof;

    @FXML
    private JFXToggleButton toggleWalls;

    @FXML
    private JFXToggleButton toggleFloor;

    @FXML
    private JFXToggleButton toggleTrunk;

    @FXML
    private JFXToggleButton toggleHood;

    @FXML
    private JFXComboBox<Integer> comboBoxDoor;

    @FXML
    private ImageView logo;

    @FXML
    private ImageView logoA;

    @FXML
    private ImageView logoB;

    @FXML
    private ImageView logoC;

    @FXML
    private ImageView logoD;

    @FXML
    private ImageView logoE;

    @FXML
    private ImageView logoF;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

    TypeAuto t = DataManager.getInstance().car.getType();

        if (t.equals(TypeAuto.Passenger_Car)) {
            comboBoxClass.getItems().addAll("A", "B", "C", "D", "E", "F", "M - минивен", "J - кроссовер");
            comboBoxDoor.getItems().addAll(1, 2, 3, 4, 5);
        } else if (t.equals(TypeAuto.Bus)){
            comboBoxClass.getItems().addAll("особо малый (микроавтобус)", "малый (6-7,5 м)", "средний (8-9,5 м)", "большой (10,5-12 м)");
            comboBoxDoor.getItems().addAll(1, 2, 3, 4, 5);
        } else if (t.equals(TypeAuto.Truck)){
            comboBoxClass.setDisable(true);
            comboBoxDoor.getItems().addAll(1, 2, 3, 4, 5);
        }

    }

    @FXML
    void showMainWindow(ActionEvent event) {

        Noise.getNavigation().load("/view/mainWindow.fxml").Show();

    }

    @FXML
    void nextStep(ActionEvent event) {

    }

    @FXML
    void selectRoof(ActionEvent event) {
       if (toggleRoof.isSelected()){
        Image img = new Image("/image/logA.png");
        logoA.setImage(img);} else {
           logoA.setImage(null);
       }

    }

    @FXML
    void selectHood(ActionEvent event) {
        if (toggleHood.isSelected()){
            Image img = new Image("/image/logB.png");
            logoB.setImage(img);} else {
            logoB.setImage(null);
        }

    }

    @FXML
    void selectDoor(ActionEvent event) {
       if (comboBoxDoor.getValue()!=null){
           Image img = new Image("/image/logC.png");
           logoC.setImage(img);} else {
           logoC.setImage(null);
       }

    }

    @FXML
    void selectFloor(ActionEvent event) {
        if (toggleFloor.isSelected()){
            Image img = new Image("/image/logD.png");
            logoD.setImage(img);} else {
            logoD.setImage(null);
        }

    }

    @FXML
    void selectTrunk(ActionEvent event) {
        if (toggleTrunk.isSelected()){
            Image img = new Image("/image/logE.png");
            logoE.setImage(img);} else {
            logoE.setImage(null);
        }

    }

    @FXML
    void selectWalls(ActionEvent event) {
        if (toggleWalls.isSelected()){
            Image img = new Image("/image/logF.png");
            logoF.setImage(img);} else {
            logoF.setImage(null);
        }

    }

    @FXML
    void selectArch(ActionEvent event) {

    }


}

