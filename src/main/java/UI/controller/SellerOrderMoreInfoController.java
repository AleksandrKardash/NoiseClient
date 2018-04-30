package UI.controller;

import Noise.Noise;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Table.MaterialTable;
import models.Table.SellerTable;
import models.materialFactory.Material;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SellerOrderMoreInfoController implements Initializable {

    private ObservableList<MaterialTable> moreInfo = FXCollections.observableArrayList();

    @FXML
    private TableView<MaterialTable> tableMoreInfo;

    @FXML
    private TableColumn<MaterialTable, String> nameMat;

    @FXML
    private TableColumn<MaterialTable, Double> depthMat;

    @FXML
    private TableColumn<MaterialTable, Double> areaMat;

    @FXML
    private TableColumn<MaterialTable, Double> countMat;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //инициализируем таблицу данными
        initData();

        // устанавливаем тип и значение которое должно хранится в колонке
        nameMat.setCellValueFactory(new PropertyValueFactory<MaterialTable, String>("nameMat"));
        depthMat.setCellValueFactory(new PropertyValueFactory<MaterialTable, Double>("depthMat"));
        areaMat.setCellValueFactory(new PropertyValueFactory<MaterialTable, Double>("areaMat"));
        countMat.setCellValueFactory(new PropertyValueFactory<MaterialTable, Double>("countMat"));

        // заполняем таблицу данными
        tableMoreInfo.setItems(moreInfo);
    }

    //добавляем в ObservableList новый обект, который будет отображен в таблице в виде строки
    private void initData(){

        moreInfo.setAll( Noise.getNavigation().getSellerOrdersController().getListAnswer().getListProduct());
    }
}
