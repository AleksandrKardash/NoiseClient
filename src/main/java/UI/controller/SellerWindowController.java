package UI.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SellerWindowController extends BaseController implements Initializable {

    @FXML
    private JFXButton showMyOrders;

    @FXML
    private JFXButton exitSellerWindow;

    @FXML
    private JFXButton showAddNewProduct;

    @FXML
    private JFXButton showMyProduct;

    @FXML
    private Pane contentArea;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    void showMyOrders(ActionEvent event) throws IOException {

        Parent fxml = FXMLLoader.load(getClass().getResource("/view/sellerOrders.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);

    }

    @FXML
    void showAddNewProduct(ActionEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("/view/sellerAddNewProduct.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    @FXML
    void showMyProduct(ActionEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("/view/sellerMyProduct.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);

    }

    @FXML
    void exitSellerWindow(ActionEvent event) {
        System.exit(0);
    }




}
