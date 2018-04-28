package UI.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import manager.DataManager;
import models.UserBuilder.User;
import net.MyRequest;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SellerAddNewProductController implements Initializable {


    @FXML
    private JFXComboBox<String> typeProduct2;

    @FXML
    private JFXTextField secondNameProduct;

    @FXML
    private JFXTextField secondNameProduct2;

    @FXML
    private JFXTextField depthProduct2;

    @FXML
    private JFXTextField nameProduct2;

    @FXML
    private JFXTextField costProduct2;

    @FXML
    private JFXTextField depthProduct;

    @FXML
    private JFXComboBox<String> typeProduct;

    @FXML
    private JFXTextField manufacturedProduct2;

    @FXML
    private JFXTextField areaProduct;

    @FXML
    private JFXTextField costProduct;

    @FXML
    private JFXComboBox<String> classProduct;

    @FXML
    private JFXTextField areaProduct2;

    @FXML
    private JFXTextField manufacturedProduct;

    @FXML
    private JFXComboBox<String> classProduct2;

    @FXML
    private JFXTextField nameProduct;

    private ArrayList<String> list = new ArrayList<>();

    //Инициализируем поля "тип" и "класс" материала
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        typeProduct.getItems().addAll("Виброизоляция", "Шумоизоляция", "Звукоизоляция", "Антискрип");
        classProduct.getItems().addAll("Эконом", "Стандарт", "Премиум");
        typeProduct2.getItems().addAll("Виброизоляция", "Шумоизоляция", "Звукоизоляция", "Антискрип");
        classProduct2.getItems().addAll("Эконом", "Стандарт", "Премиум");

    }

    @FXML
    void addNewProduct(ActionEvent event) {

        //проверяем заполнены ли все поля
        if(!nameProduct.getText().trim().isEmpty() && !secondNameProduct.getText().trim().isEmpty() &&
                !typeProduct.getValue().trim().isEmpty() && !depthProduct.getText().trim().isEmpty() &&
                !classProduct.getValue().trim().isEmpty() && !manufacturedProduct.getText().trim().isEmpty() &&
                !costProduct.getText().trim().isEmpty() && !areaProduct.getText().trim().isEmpty()) {

            //добавляем все данные в коллекцию
            list.add(manufacturedProduct.getText());
            list.add(typeProduct.getValue());
            list.add(nameProduct.getText());
            list.add(secondNameProduct.getText());
            list.add(areaProduct.getText());
            list.add(depthProduct.getText());
            list.add(classProduct.getValue());
            list.add(costProduct.getText());
            list.add(DataManager.getInstance().user.getLogin());//добавляем также Login для привязки материала поставщику

            //запаковываем запрос в виде ArrayList в обьект с инструкциями для его обработки, отправляем на сервер и получаем ответ
            MyRequest request = DataManager.getInstance().addRequest(new MyRequest(MyRequest.RequestType.CREATE, MyRequest.RequestTypeB.LIST_NEW_PRODUCT, list));

            //отправляем запрос через DataManager на сервер и получаем ответ, приводим к классу Integer
            int answer = (Integer) request.getData();

            //проверяем результат добавления нового материала
            if (answer == 0){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.getDialogPane().setPrefSize(200, 100);
                alert.setContentText("Материал успешно загружен!");
                alert.show();
                //очищаем поля и список
                manufacturedProduct.clear();
                nameProduct.clear();
                secondNameProduct.clear();
                areaProduct.clear();
                depthProduct.clear();
                costProduct.clear();
                list.clear();

            } else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.getDialogPane().setPrefSize(200, 100);
                alert.setContentText("Что-то пошло не так!");
                alert.show();
            }


        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.getDialogPane().setPrefSize(200, 100);
            alert.setContentText("Введите данные!");
            alert.show();
        }
    }

    @FXML
    void addNewProductD(ActionEvent event) {

        //проверяем заполнены ли все поля
        if(!nameProduct2.getText().trim().isEmpty() && !secondNameProduct2.getText().trim().isEmpty() &&
                !typeProduct2.getValue().trim().isEmpty() && !depthProduct2.getText().trim().isEmpty() &&
                !classProduct2.getValue().trim().isEmpty() && !manufacturedProduct2.getText().trim().isEmpty() &&
                !costProduct2.getText().trim().isEmpty() && !areaProduct2.getText().trim().isEmpty()) {

            //добавляем все данные в коллекцию
            list.add(manufacturedProduct.getText());
            list.add(typeProduct.getValue());
            list.add(nameProduct.getText());
            list.add(secondNameProduct.getText());
            list.add(areaProduct.getText());
            list.add(depthProduct.getText());
            list.add(classProduct.getValue());
            list.add(costProduct.getText());
            list.add(DataManager.getInstance().user.getLogin());//добавляем также Login для привязки материала поставщику

            //запаковываем запрос в виде ArrayList в обьект с инструкциями для его обработки, отправляем на сервер и получаем ответ
            MyRequest request = DataManager.getInstance().addRequest(new MyRequest(MyRequest.RequestType.CREATE, MyRequest.RequestTypeB.LIST_NEW_PRODUCT, list));

            //отправляем запрос через DataManager на сервер и получаем ответ, приводим к классу Integer
            int answer = (Integer) request.getData();

            //проверяем результат добавления нового материала
            if (answer == 0){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.getDialogPane().setPrefSize(200, 100);
                alert.setContentText("Материал успешно загружен!");
                alert.show();
                //очищаем поля
                manufacturedProduct2.clear();
                nameProduct2.clear();
                secondNameProduct2.clear();
                areaProduct2.clear();
                depthProduct2.clear();
                costProduct2.clear();

            } else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.getDialogPane().setPrefSize(200, 100);
                alert.setContentText("Что-то пошло не так!");
                alert.show();
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.getDialogPane().setPrefSize(200, 100);
            alert.setContentText("Введите данные!");
            alert.show();
        }
    }
}
