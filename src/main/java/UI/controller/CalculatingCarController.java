package UI.controller;

import com.jfoenix.controls.*;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import models.Table.MaterialTable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

//Controller окна с перечнем материалов
public class CalculatingCarController extends BaseController implements Initializable {

    private ObservableList<MaterialTable> materialData = FXCollections.observableArrayList();

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


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        //подгружаем меню в Drawer в виде отдельного fxml-представления
        try {
            VBox box = FXMLLoader.load(getClass().getResource("/view/menuContent.fxml"));
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
    }

    // подготавливаем данные для таблицы
    private void initData(){

        //добавляем в ObservableList новый обект, который будет отображен в таблице в виде строки
        materialData.add(new MaterialTable("виброизол",0.4,2.1,24));

    }

}