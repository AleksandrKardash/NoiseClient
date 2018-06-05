package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import manager.DataManager;
import models.Table.MaterialTable;
import models.Table.SellerMaterialTable;
import net.MyRequest;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SellerMyProductController extends BaseController implements Initializable {

    private ObservableList<SellerMaterialTable> myMaterialData = FXCollections.observableArrayList();

    @FXML
    private TableView<SellerMaterialTable> tableMyProduct;

    @FXML
    private TableColumn<SellerMaterialTable, String> manufacturedProduct;

    @FXML
    private TableColumn<SellerMaterialTable, String> typeProduct;

    @FXML
    private TableColumn<SellerMaterialTable, String> nameProduct;

    @FXML
    private TableColumn<SellerMaterialTable, String> secondNameProduct;

    @FXML
    private TableColumn<SellerMaterialTable, Double> areaProduct;

    @FXML
    private TableColumn<SellerMaterialTable, Double> depthProduct;

    @FXML
    private TableColumn<SellerMaterialTable, String> classProduct;

    @FXML
    private TableColumn<SellerMaterialTable, Double> costProduct;

    private ArrayList<MaterialTable> myProductList = new ArrayList<>();

    private MyRequest request;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //инициализируем таблицу данными
        initData();

        // устанавливаем тип и значение которое должно хранится в колонке
        manufacturedProduct.setCellValueFactory(new PropertyValueFactory<SellerMaterialTable, String>("manufacturedProduct"));
        typeProduct.setCellValueFactory(new PropertyValueFactory<SellerMaterialTable, String>("typeProduct"));
        nameProduct.setCellValueFactory(new PropertyValueFactory<SellerMaterialTable, String>("nameProduct"));
        secondNameProduct.setCellValueFactory(new PropertyValueFactory<SellerMaterialTable, String>("secondNameProduct"));
        areaProduct.setCellValueFactory(new PropertyValueFactory<SellerMaterialTable, Double>("areaProduct"));
        depthProduct.setCellValueFactory(new PropertyValueFactory<SellerMaterialTable, Double>("depthProduct"));
        classProduct.setCellValueFactory(new PropertyValueFactory<SellerMaterialTable, String>("classProduct"));
        costProduct.setCellValueFactory(new PropertyValueFactory<SellerMaterialTable, Double>("costProduct"));

        // заполняем таблицу данными
        tableMyProduct.setItems(myMaterialData);

    }

    // подготавливаем данные для таблицы
    private void initData(){

        String login = DataManager.getInstance().user.getLogin();
        ArrayList<String> list = new ArrayList<String>();
        list.add(login);

        //запаковываем запрос в виде ArrayList в обьект с инструкциями для его обработки, отправляем на сервер и получаем ответ
        request = DataManager.getInstance().addRequest(new MyRequest(MyRequest.RequestType.READ, MyRequest.RequestTypeB.LIST_MY_PRODUCT, list));

        //ответ приводим к классу ArrayList
        ArrayList<SellerMaterialTable> listAnswer = (ArrayList) request.getData();

        //добавляем в ObservableList новый обект, который будет отображен в таблице в виде строки
        myMaterialData.setAll(listAnswer);

    }

    @FXML
    void moreInfo(ActionEvent event) {

    }

    @FXML
    void refreshProduct(ActionEvent event) {
       initData();
    }

    @FXML
    void delProduct(ActionEvent event) {

        //необходимые данные для формирования запроса
        SellerMaterialTable deleteProduct = tableMyProduct.getSelectionModel().getSelectedItem();

        //запаковываем запрос в виде ArrayList в обьект с инструкциями для его обработки, отправляем на сервер и получаем ответ
        request = DataManager.getInstance().addRequest(new MyRequest(MyRequest.RequestType.DELETE, MyRequest.RequestTypeB.DELETE_PRODUCT, deleteProduct));

        //ответ приводим к классу Integer
        int answer = (Integer) request.getData();

        //проверяем результат добавления нового материала
        if (answer == 0) {
            //удаляем строку из таблицы и обновляем таблицу
            SellerMaterialTable sellerOrders = tableMyProduct.getSelectionModel().getSelectedItem();
            tableMyProduct.getItems().remove(sellerOrders);
            initData();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.getDialogPane().setPrefSize(200, 100);
            alert.setContentText("Продукт удален!");
            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.getDialogPane().setPrefSize(200, 100);
            alert.setContentText("Что-то пошло не так!");
            alert.show();
        }
    }

}
