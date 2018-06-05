package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import manager.DataManager;
import models.Table.SellerOrders;
import net.MyRequest;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SellerOrdersController extends BaseController implements Initializable {

    private ObservableList<SellerOrders> myOrders = FXCollections.observableArrayList();

    private ObservableList<SellerOrders> myOrdersCompleted = FXCollections.observableArrayList();

    @FXML
    private TableView<SellerOrders> tableNewOrders;

    @FXML
    private TableView<SellerOrders> tableCompletedOrders;

    @FXML
    private TableColumn<SellerOrders, Integer> idOrder;

    @FXML
    private TableColumn<SellerOrders, String> adress;

    @FXML
    private TableColumn<SellerOrders, String> telNumber;

    @FXML
    private TableColumn<SellerOrders, Double> value;

    @FXML
    private TableColumn<SellerOrders, Date> dateOrder;

    @FXML
    private TableColumn<SellerOrders, Integer> idOrderCompleted;

    @FXML
    private TableColumn<SellerOrders, String> adressCompleted;

    @FXML
    private TableColumn<SellerOrders, String> telNumberCompleted;

    @FXML
    private TableColumn<SellerOrders, Double> valueCompleted;

    @FXML
    private TableColumn<SellerOrders, Date> dateOrderCompleted;

    private MyRequest request;

    private ArrayList<SellerOrders> listAnswer = new ArrayList<SellerOrders>();


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //инициализируем таблицы данными (новые и обработанные заказы)
        initData();

        // устанавливаем тип и значение которое должно хранится в колонке
        idOrder.setCellValueFactory(new PropertyValueFactory<SellerOrders, Integer>("idOrder"));
        adress.setCellValueFactory(new PropertyValueFactory<SellerOrders, String>("adress"));
        telNumber.setCellValueFactory(new PropertyValueFactory<SellerOrders, String>("telNumber"));
        value.setCellValueFactory(new PropertyValueFactory<SellerOrders, Double>("value"));
        idOrder.setCellValueFactory(new PropertyValueFactory<SellerOrders, Integer>("idOrder"));
        dateOrder.setCellValueFactory(new PropertyValueFactory<SellerOrders, Date>("dateOrder"));

        idOrderCompleted.setCellValueFactory(new PropertyValueFactory<SellerOrders, Integer>("idOrder"));
        adressCompleted.setCellValueFactory(new PropertyValueFactory<SellerOrders, String>("adress"));
        telNumberCompleted.setCellValueFactory(new PropertyValueFactory<SellerOrders, String>("telNumber"));
        valueCompleted.setCellValueFactory(new PropertyValueFactory<SellerOrders, Double>("value"));
        idOrderCompleted.setCellValueFactory(new PropertyValueFactory<SellerOrders, Integer>("idOrder"));
        dateOrderCompleted.setCellValueFactory(new PropertyValueFactory<SellerOrders, Date>("dateOrder"));


        // заполняем таблицу данными
        tableNewOrders.setItems(myOrders);
        tableCompletedOrders.setItems(myOrdersCompleted);

    }

    // подготавливаем данные для таблицы
    private void initData(){

        //необходимые данные для формирования запроса
        ArrayList<String> list = new ArrayList<>();
        list.add(DataManager.getInstance().user.getLogin());

        //запаковываем запрос в виде ArrayList в обьект с инструкциями для его обработки, отправляем на сервер и получаем ответ
        request = DataManager.getInstance().addRequest(new MyRequest(MyRequest.RequestType.READ, MyRequest.RequestTypeB.LIST_MY_ORDERS, list));

        //ответ приводим к классу ArrayList
        listAnswer = (ArrayList<SellerOrders>) request.getData();

        ArrayList<SellerOrders> newOrders = new ArrayList<SellerOrders>();
        ArrayList<SellerOrders> completedOrders = new ArrayList<SellerOrders>();

        //разделяем заказы на новые и обработанные
        for (SellerOrders so: listAnswer){

            if(so.getProcessed().equals("no")){
                newOrders.add(so);
            } else if(so.getProcessed().equals("yes")){
                completedOrders.add(so);
            }
        }

        //добавляем в ObservableList новый обект, который будет отображен в таблице в виде строки
        myOrders.setAll(newOrders);
        myOrdersCompleted.setAll(completedOrders);

    }


    //показывает модальное окно с перечнем материалов отнссящихся к выбранному продавцу
    @FXML
    void moreInfo(ActionEvent event) {

        try {
            // Загружаем fxml-файл и создаём новую сцену для всплывающего диалогового окна.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/sellerOrdersMoreInfo.fxml"));
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

    @FXML
    void refreshOrders(ActionEvent event) {
        initData();
    }

    @FXML
    void confirmOrder(ActionEvent event) {

        //необходимые данные для формирования запроса
        SellerOrders confirmOrder = getListAnswer();

        //запаковываем запрос в виде ArrayList в обьект с инструкциями для его обработки, отправляем на сервер и получаем ответ
        request = DataManager.getInstance().addRequest(new MyRequest(MyRequest.RequestType.UPDATE, MyRequest.RequestTypeB.CONFIRM_ORDER, confirmOrder));

        //ответ приводим к классу Integer
        int answer = (Integer) request.getData();

        //проверяем результат добавления нового материала
        if (answer == 0) {
            //удаляем строку из таблицы и обновляем таблицу
            SellerOrders sellerOrders = tableNewOrders.getSelectionModel().getSelectedItem();
            tableNewOrders.getItems().remove(sellerOrders);
            initData();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.getDialogPane().setPrefSize(200, 100);
            alert.setContentText("Заявка обработана!");
            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.getDialogPane().setPrefSize(200, 100);
            alert.setContentText("Что-то пошло не так!");
            alert.show();
        }

    }

    @FXML
    void delOrder(ActionEvent event) {

        //необходимые данные для формирования запроса
        SellerOrders deleteOrder = getListAnswerCompleted();

        //запаковываем запрос в виде ArrayList в обьект с инструкциями для его обработки, отправляем на сервер и получаем ответ
        request = DataManager.getInstance().addRequest(new MyRequest(MyRequest.RequestType.DELETE, MyRequest.RequestTypeB.DELETE_ORDER, deleteOrder));

        //ответ приводим к классу Integer
        int answer = (Integer) request.getData();

        //проверяем результат добавления нового материала
        if (answer == 0) {
            //удаляем строку из таблицы и обновляем таблицу
            SellerOrders sellerOrders = tableCompletedOrders.getSelectionModel().getSelectedItem();
            tableCompletedOrders.getItems().remove(sellerOrders);
            initData();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.getDialogPane().setPrefSize(200, 100);
            alert.setContentText("Заявка удалена!");
            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.getDialogPane().setPrefSize(200, 100);
            alert.setContentText("Что-то пошло не так!");
            alert.show();
        }
    }

    //возвращает обьект из выбранной строки TableView
    public SellerOrders getListAnswer() {
        return tableNewOrders.getSelectionModel().getSelectedItem();
    }

    public SellerOrders getListAnswerCompleted() {
        return tableCompletedOrders.getSelectionModel().getSelectedItem();
    }

}
