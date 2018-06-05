package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


public class Navigation {

    private final Stage stage;
    private final Scene scene;
    private Controller findController = null;

    private List<Controller> controllers = new ArrayList<>();


    public Navigation(Stage stage)
    {
        this.stage = stage;
        scene = new Scene(new Pane(),800, 550);
        stage.setScene(scene);
        stage.setResizable(false);

    }

    public Controller load(String sUrl)
    {
        try {

            //loads the fxml file
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(sUrl));
            Node root = (Node) fxmlLoader.load();

            Controller controller = fxmlLoader.getController();

            controller.setView(root);

            return controller;

        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void Show(Controller controller)
    {
        try {
            scene.setRoot((Parent) controller.getView());

            //добавляем созданный Controller в коллекцию
            setController(controller);

        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void GoBack()
    {
        if (controllers.size() > 1)
        {
            controllers.remove(controllers.get(controllers.size() - 1));
            scene.setRoot((Parent) controllers.get(controllers.size() - 1).getView());
        }

        System.out.println("GoBack: " + controllers.get(controllers.size() - 1).toString() + ". Total scenes: " + controllers.size());
    }


    public void ClearHistory()
    {
        while (controllers.size() > 1)
            controllers.remove(0);

        System.out.println("ClearHistory. Total scenes: " + controllers.size());
    }

    //загрузить Controller в коллекцию
    public void setController(Controller controller){
        controllers.add(controller);

        System.out.println("Add to history: " + controller.toString() + ". Total scenes: " + controllers.size());
    }

    //метод для получения ссылки на CalculatingCarController
    public CalculatingCarController getCalculatingCarController(){
        for (Controller c: controllers) {
            if (c instanceof CalculatingCarController){
                findController = c;
            }
        }
        return (CalculatingCarController) findController;
    }

    //метод для получения ссылки на FindSellerController
    public FindSellerController getFindSellerController (){
        for (Controller c: controllers) {
            if (c instanceof FindSellerController){
                findController = c;
            }
        }
        return (FindSellerController) findController;
    }

    //метод для получения ссылки на SellerOrdersController
    public SellerOrdersController getSellerOrdersController (){
        for (Controller c: controllers) {
            if (c instanceof SellerOrdersController){
                findController = c;
            }
        }
        return (SellerOrdersController) findController;
    }

    //метод для получения ссылки на OptionsCarController
    public OptionsCarController getOptionsCarController (){
        for (Controller c: controllers) {
            if (c instanceof OptionsCarController){
                findController = c;
            }
        }
        return (OptionsCarController) findController;
    }
}