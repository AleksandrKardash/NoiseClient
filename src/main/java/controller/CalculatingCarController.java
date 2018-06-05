package controller;

import Noise.Noise;
import com.jfoenix.controls.*;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import manager.DataManager;
import models.Calculate.*;
import models.JsonSimple.JsonWriter;
import models.Table.MaterialTable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

//Controller окна с перечнем материалов
public class CalculatingCarController extends BaseController implements Initializable {

    public ObservableList<MaterialTable> materialData = FXCollections.observableArrayList();

    @FXML
    private TableView<MaterialTable> materialTable;

    @FXML
    private TableColumn<MaterialTable, String> nameMat;

    @FXML
    private TableColumn<MaterialTable, Double> areaMat;

    @FXML
    private TableColumn<MaterialTable, Double> depthMat;

    @FXML
    private TableColumn<MaterialTable, Integer> countMat;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private JFXHamburger hamburger;

    @FXML
    private JFXDrawer leftMenu;

    @FXML
    private Label weight;

    Calculate calculateCar;


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        //подгружаем меню в Drawer в виде отдельного fxml-представления
        try {
            VBox box = FXMLLoader.load(getClass().getResource("/fxml/menuContent.fxml"));
            leftMenu.setSidePane(box);
        } catch (IOException ex) {
        }

        //настройка кнопки вызова бокового меню (Drawer)
        HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(hamburger);
        transition.setRate(-1);
        hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED,(e)->{
            transition.setRate(transition.getRate()*-1);
            transition.play();

            if(leftMenu.isShown())
            {
                leftMenu.close();
                materialData.setAll(calculateCar.getAllElements());
            }else
                leftMenu.open();
        });

        //инициализируем таблицу данными
        initData();

        // устанавливаем тип и значение которое должно хранится в колонке
        nameMat.setCellValueFactory(new PropertyValueFactory<MaterialTable, String>("nameMat"));
        areaMat.setCellValueFactory(new PropertyValueFactory<MaterialTable, Double>("areaMat"));
        depthMat.setCellValueFactory(new PropertyValueFactory<MaterialTable, Double>("depthMat"));
        countMat.setCellValueFactory(new PropertyValueFactory<MaterialTable, Integer>("countMat"));

        // заполняем таблицу данными
        materialTable.setItems(materialData);

        //рассчитаем примерный вес материала
        Double w = 0.0;
        Double c = 0.0;
        for (MaterialTable m: materialData) {
            if (m.getNameMat().equals("Виброизоляция")){
                c = 2.0 * m.getAreaMat() * m.getDepthMat() * m.getCountMat();

                w+=c;
            }
        }
        weight.setText(String.valueOf(w));

    }

    //подготавливаем данные для таблицы
    private void initData(){

        //рассчет по элементам либо по площади
        if (!Noise.getNavigation().getOptionsCarController().calculateByArea.isSelected()){

            //создаем обьект Calculate в зависимости от типа обрабатываемого авто
            switch (DataManager.getInstance().car.getType()){

                case Passenger_Car:
                    calculateCar = new CalculatePassengerCar(DataManager.getInstance().car);
                    break;

                case Bus:
                    calculateCar = new CalculateBus (DataManager.getInstance().car);
                    break;

                case Truck:
                    calculateCar = new CalculateTruck(DataManager.getInstance().car);
                    break;
            }

        } else {

            calculateCar = new CalculateByArea(Double.parseDouble(Noise.getNavigation().getOptionsCarController()
                    .elementArea.getText()));
            //отключаем возможность навигации по элементам
            hamburger.setDisable(true);
        }


        //добавляем в ObservableList новый обект, который будет отображен в таблице в виде строки
        materialData.addAll(calculateCar.getAllElements());

        //добавляем подобранные материалы в DataManager для последующей работы с ними
        DataManager.getInstance().addSelectedMaterials(calculateCar.getAllElements());

    }

    @FXML
    void goBack(ActionEvent event) {

        Noise.getNavigation().GoBack();
    }

    @FXML
    void findSeller(ActionEvent event) {

        Noise.getNavigation().load("/fxml/findSeller.fxml").Show();

    }

    //сохраняем список материалов в файл
    @FXML
    void saveList(ActionEvent event) {

        new JsonWriter(calculateCar.getAllElements());

    }

}