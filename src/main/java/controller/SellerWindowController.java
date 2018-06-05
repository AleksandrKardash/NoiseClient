package controller;

import Noise.Noise;
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

        //для получения далее ссылки на контроллер создаем обьект FMXLoader, а не используем статический метод
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/fxml/sellerOrders.fxml"));
        Parent fxml = (Parent) fxmlLoader.load();
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);

        //получение ссылки на контроллер и передача в класс Navigation!
        Noise.getNavigation().setController(fxmlLoader.getController());

    }

    @FXML
    void showAddNewProduct(ActionEvent event) throws IOException {

        //для получения далее ссылки на контроллер создаем обьект FMXLoader, а не используем статический метод
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/fxml/sellerAddNewProduct.fxml"));
        Parent fxml = (Parent) fxmlLoader.load();
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);

        //получение ссылки на контроллер и передача в класс Navigation!
        Noise.getNavigation().setController(fxmlLoader.getController());

    }

    @FXML
    void showMyProduct(ActionEvent event) throws IOException {

        //для получения далее ссылки на контроллер создаем обьект FMXLoader, а не используем статический метод
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/fxml/sellerMyProduct.fxml"));
        Parent fxml = (Parent) fxmlLoader.load();
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);

        //получение ссылки на контроллер и передача в класс Navigation!
        Noise.getNavigation().setController(fxmlLoader.getController());

    }

    @FXML
    void exitSellerWindow(ActionEvent event) {
        System.exit(0);
    }


}
