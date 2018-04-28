package UI.controller;

import Noise.Noise;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import jdk.internal.dynalink.linker.LinkerServices;
import manager.DataManager;
import models.Table.MaterialTable;
import models.Table.SellerMaterialTable;
import models.Table.SellerTable;
import models.UserBuilder.User;
import net.MyRequest;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class FindSellerController extends BaseController implements Initializable {

    private ObservableList<SellerTable> sellers = FXCollections.observableArrayList();

    @FXML
    private JFXButton sendOrder;

    @FXML
    private TableView<SellerTable> tableSeller;

    @FXML
    private TableColumn<SellerTable, String> seller;

    @FXML
    private TableColumn<SellerTable, String> delivery;

    @FXML
    private TableColumn<SellerTable, Double> cost;

    @FXML
    private TableColumn<SellerTable, String> adress;

    @FXML
    private JFXComboBox<String> sitySeller;

    @FXML
    private JFXComboBox<String> gradeProduct;

    @FXML
    private JFXCheckBox deliveryPossibility;

    private MyRequest request;

    private ArrayList<SellerTable> listAnswer = new ArrayList<SellerTable>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //если пользователь не авторизован, то дизактивируем кнопку "Отправить заявку"
        if (!User.reg) {
            sendOrder.setText("Отправить заявку (авторизируйтесь!)");
            sendOrder.setDisable(true);
        }


        //заполняем ComboBox
        sitySeller.getItems().addAll("Минск");
        gradeProduct.getItems().addAll("Эконом" , "Стандарт" , "Премиум");


        // устанавливаем тип и значение которое должно хранится в колонке
        seller.setCellValueFactory(new PropertyValueFactory<SellerTable, String>("seller"));
        delivery.setCellValueFactory(new PropertyValueFactory<SellerTable, String>("delivery"));
        cost.setCellValueFactory(new PropertyValueFactory<SellerTable, Double>("cost"));
        adress.setCellValueFactory(new PropertyValueFactory<SellerTable, String>("adress"));

        // заполняем таблицу данными
        tableSeller.setItems(sellers);

    }

    @FXML
    void findSeller(ActionEvent event) {

        //необходимые данные для формирования запроса
        ArrayList<String> listA = new ArrayList<>();
        listA.add(sitySeller.getValue());
        listA.add(gradeProduct.getValue());
        ArrayList<MaterialTable> listB = DataManager.getInstance().selectedMaterials;

        //запаковываем запрос в виде ArrayList в обьект с инструкциями для его обработки, отправляем на сервер и получаем ответ
        request = DataManager.getInstance().addRequest(new MyRequest(MyRequest.RequestType.READ, MyRequest.RequestTypeB.LIST_FIND_SELLER, listA, listB));

        //ответ приводим к классу ArrayList
        listAnswer = (ArrayList<SellerTable>) request.getData();

        //добавляем в ObservableList новый обект, который будет отображен в таблице в виде строки
        sellers.setAll(listAnswer);

    }

    @FXML
    void goBack(ActionEvent event) {
        Noise.getNavigation().GoBack();
    }

    //отправить заявку
    @FXML
    void sendOrder(ActionEvent event) {

        //необходимые данные для формирования запроса
        SellerTable order = getListAnswer();

        //запаковываем запрос в виде ArrayList в обьект с инструкциями для его обработки, отправляем на сервер и получаем ответ
        request = DataManager.getInstance().addRequest(new MyRequest(MyRequest.RequestType.CREATE, MyRequest.RequestTypeB.ORDER, order, DataManager.getInstance().user));

        //ответ приводим к классу Integer
        int answer = (Integer) request.getData();

        //проверяем результат добавления нового материала
        if (answer == 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.getDialogPane().setPrefSize(200, 100);
            alert.setContentText("Заявка отправлена!");
            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.getDialogPane().setPrefSize(200, 100);
            alert.setContentText("Попробуйте позже!");
            alert.show();
        }

    }

    //показывает модальное окно с перечнем материалов отнссящихся к выбранному продавцу
    @FXML
    void moreInfo(ActionEvent event) {

        try {
            // Загружаем fxml-файл и создаём новую сцену для всплывающего диалогового окна.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/findSellerMoreInfo.fxml"));
            VBox box = (VBox) loader.load();

            // Создаём диалоговое окно Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("MoreInfo");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            Scene scene = new Scene(box);
            dialogStage.setScene(scene);

            // Отображаем диалоговое окно и ждём, пока пользователь его не закроет
            dialogStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //возвращает обьект из выбранной строки TableView
    public SellerTable getListAnswer() {
        return tableSeller.getSelectionModel().getSelectedItem();
    }

}