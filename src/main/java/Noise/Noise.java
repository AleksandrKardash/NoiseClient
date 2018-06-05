package Noise;

import controller.Navigation;
import javafx.application.Application;
import javafx.stage.Stage;


// точка входа
public class Noise extends Application {

    private static Navigation navigation;
    public static Navigation getNavigation()
    {
        return navigation;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        navigation = new Navigation(primaryStage);
        primaryStage.setTitle("Noise");
        primaryStage.show();
        //загрузка первого окна
        Noise.getNavigation().load("/fxml/mainWindow.fxml").Show();

    }


public static void main(String[] args) throws Exception {

        launch(args);

}
}

