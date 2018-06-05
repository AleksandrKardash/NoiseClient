package controller;


import Noise.Noise;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import manager.DataManager;
import models.BuilderCar.ClassAuto;
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
    public JFXCheckBox calculateByArea;

    @FXML
    public JFXComboBox<String> depthElement;

    @FXML
    public JFXTextField elementArea;

    @FXML
    public JFXCheckBox layerBlock;

    @FXML
    public JFXCheckBox layerVibro;

    @FXML
    public JFXCheckBox layerNoise;

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

        //узнаем тип авто выбраного пользователем для загрузки в меню возможных опций
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

        depthElement.getItems().addAll("Минимум", "Стандарт", "Максимум");

        //дезактивируем некоторые поля
        elementArea.setDisable(true);
        depthElement.setDisable(true);
        layerBlock.setDisable(true);
        layerNoise.setDisable(true);
        layerVibro.setDisable(true);

        //если выбран тип "грузовик", то дезактивируем выбор по элементам
        if (t.equals(TypeAuto.Truck)){
            elementArea.setDisable(false);
            depthElement.setDisable(false);
            layerBlock.setDisable(false);
            layerNoise.setDisable(false);
            layerVibro.setDisable(false);

            comboBoxClass.setDisable(true);
            comboBoxDoor.setDisable(true);
            toggleArch.setDisable(true);
            toggleFloor.setDisable(true);
            toggleHood.setDisable(true);
            toggleRoof.setDisable(true);
            toggleTrunk.setDisable(true);
            toggleWalls.setDisable(true);

            calculateByArea.setSelected(true);
            calculateByArea.setDisable(true);
        }

    }

    @FXML
    void showMainWindow(ActionEvent event) {

        Noise.getNavigation().load("/fxml/mainWindow.fxml").Show();

    }

    @FXML
    void nextStep(ActionEvent event) {

        //условие перехода к окну расчета
        if(!manufacturerCar.getText().trim().isEmpty() && !modelCar.getText().trim().isEmpty() && !calculateByArea.isSelected()) {

           Noise.getNavigation().load("/fxml/calculatingCar.fxml").Show();
           //записываем данные о модели и марке авто в уже созданный обьект Car
           DataManager.getInstance().car.setBrand(manufacturerCar.getText());
           DataManager.getInstance().car.setModel(modelCar.getText());

        } else if (!manufacturerCar.getText().trim().isEmpty() && !modelCar.getText().trim().isEmpty() &&
                calculateByArea.isSelected()&& !elementArea.getText().trim().isEmpty() && !depthElement.getValue().isEmpty()){

            Noise.getNavigation().load("/fxml/calculatingCar.fxml").Show();
            //записываем данные о модели и марке авто в уже созданный обьект Car
            DataManager.getInstance().car.setBrand(manufacturerCar.getText());
            DataManager.getInstance().car.setModel(modelCar.getText());

        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.getDialogPane().setPrefSize(200, 100);
            alert.setContentText("Введите данные!");
            alert.show();
        }

    }


    //определяем действия для всех возможных опций
    //также добавлям слои на изображение и устанавливаем значение элемента в обьекте Car, если опция активна
    @FXML
    void selectRoof(ActionEvent event) {
       if (toggleRoof.isSelected()){
           Image img = new Image("/image/logA.png");
           logoA.setImage(img);
           DataManager.getInstance().car.getElements().roofOn();} else {
           logoA.setImage(null);
           DataManager.getInstance().car.getElements().roofOff();

       }

    }

    @FXML
    void selectHood(ActionEvent event) {
        if (toggleHood.isSelected()){
            Image img = new Image("/image/logB.png");
            logoB.setImage(img);
            DataManager.getInstance().car.getElements().hoodOn();} else {
            logoB.setImage(null);
            DataManager.getInstance().car.getElements().hoodOff();
        }

    }

    @FXML
    void selectDoor(ActionEvent event) {
       if (comboBoxDoor.getValue()!=null){

           switch (comboBoxDoor.getValue()){

               case 1:
                   DataManager.getInstance().car.getElements().doorOn(1);
                   break;

               case 2:
                   DataManager.getInstance().car.getElements().doorOn(2);
                   break;

               case 3:
                   DataManager.getInstance().car.getElements().doorOn(3);
                   break;

               case 4:
                   DataManager.getInstance().car.getElements().doorOn(4);
                   break;

               case 5:
                   DataManager.getInstance().car.getElements().doorOn(5);
                   break;
           }

           Image img = new Image("/image/logC.png");
           logoC.setImage(img);} else {
           logoC.setImage(null);
           DataManager.getInstance().car.getElements().roofOff();
       }

    }

    @FXML
    void selectFloor(ActionEvent event) {
        if (toggleFloor.isSelected()){
            Image img = new Image("/image/logD.png");
            logoD.setImage(img);
            DataManager.getInstance().car.getElements().floorOn();} else {
            logoD.setImage(null);
            DataManager.getInstance().car.getElements().floorOff();
        }

    }

    @FXML
    void selectTrunk(ActionEvent event) {
        if (toggleTrunk.isSelected()){
            Image img = new Image("/image/logE.png");
            logoE.setImage(img);
            DataManager.getInstance().car.getElements().trunkOn();} else {
            logoE.setImage(null);
            DataManager.getInstance().car.getElements().trunkOff();
        }

    }

    @FXML
    void selectWalls(ActionEvent event) {
        if (toggleWalls.isSelected()){
            Image img = new Image("/image/logF.png");
            logoF.setImage(img);
            DataManager.getInstance().car.getElements().wallsOn();} else {
            logoF.setImage(null);
            DataManager.getInstance().car.getElements().wallsOff();
        }

    }

    @FXML
    void selectArch(ActionEvent event) {
        if (toggleWalls.isSelected()){
            DataManager.getInstance().car.getElements().archOn();} else {
            DataManager.getInstance().car.getElements().archOff();
        }

    }

    @FXML
    void selectClass(ActionEvent event) {

        if (comboBoxClass.getValue()!=null) {

            switch (comboBoxClass.getValue()) {

                case "A":
                    DataManager.getInstance().car.setC(new ClassAuto("A"));
                    break;

                case "B":
                    DataManager.getInstance().car.setC(new ClassAuto("B"));
                    break;

                case "C":
                    DataManager.getInstance().car.setC(new ClassAuto("C"));
                    break;

                case "D":
                    DataManager.getInstance().car.setC(new ClassAuto("D"));
                    break;

                case "E":
                    DataManager.getInstance().car.setC(new ClassAuto("E"));
                    break;

                case "F":
                    DataManager.getInstance().car.setC(new ClassAuto("F"));
                    break;

                case "M - минивен":
                    DataManager.getInstance().car.setC(new ClassAuto("M"));
                    break;

                case "J - кроссовер":
                    DataManager.getInstance().car.setC(new ClassAuto("J"));
                    break;

                case "особо малый (микроавтобус)":
                    DataManager.getInstance().car.setC(new ClassAuto("AB"));
                    break;

                case "малый (6-7,5 м)":
                    DataManager.getInstance().car.setC(new ClassAuto("BB"));
                    break;

                case "средний (8-9,5 м)":
                    DataManager.getInstance().car.setC(new ClassAuto("CB"));
                    break;

                case "большой (10,5-12 м)":
                    DataManager.getInstance().car.setC(new ClassAuto("DB"));
                    break;
            }

        } else {
            DataManager.getInstance().car.setC(new ClassAuto("A"));
        }
    }

    //при выборе "рассчет по площади", дезактивируем "рассчет по элементам"
    @FXML
    void calculateByArea(ActionEvent event) {

        if(calculateByArea.isSelected()){
            elementArea.setDisable(false);
            depthElement.setDisable(false);
            layerBlock.setDisable(false);
            layerNoise.setDisable(false);
            layerVibro.setDisable(false);

            comboBoxClass.setDisable(true);
            comboBoxDoor.setDisable(true);
            toggleArch.setDisable(true);
            toggleFloor.setDisable(true);
            toggleHood.setDisable(true);
            toggleRoof.setDisable(true);
            toggleTrunk.setDisable(true);
            toggleWalls.setDisable(true);

        } else {
            elementArea.setDisable(true);
            depthElement.setDisable(true);
            layerBlock.setDisable(true);
            layerNoise.setDisable(true);
            layerVibro.setDisable(true);

            comboBoxClass.setDisable(false);
            comboBoxDoor.setDisable(false);
            toggleArch.setDisable(false);
            toggleFloor.setDisable(false);
            toggleHood.setDisable(false);
            toggleRoof.setDisable(false);
            toggleTrunk.setDisable(false);
            toggleWalls.setDisable(false);
        }

    }
}