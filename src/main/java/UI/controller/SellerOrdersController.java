package UI.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class SellerOrdersController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private TableView<?> tableNewOrders;

    @FXML
    private TableView<?> tableCompletedOrders;

    @FXML
    void moreInfo(ActionEvent event) {

    }

    @FXML
    void refreshOrders(ActionEvent event) {

    }

    @FXML
    void confirmOrder(ActionEvent event) {

    }

    @FXML
    void delOrder(ActionEvent event) {

    }

}
