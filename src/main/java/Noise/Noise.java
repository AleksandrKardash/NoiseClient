package Noise;

import UI.controller.Navigation;
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
        Noise.getNavigation().load("/view/mainWindow.fxml").Show();

    }


public static void main(String[] args) throws Exception {

        launch(args);

}
}


//                MaterialCreate one = new MaterialCreate();
//                one.makeWriteMaterial(0, "SGMe", 0.5, 1);
//                one.makeWriteMaterial(1, "SGMf", 0.5, 2);
//                one.makeWriteMaterial(2, "SGMg", 0.5, 3);
//                one.makeWriteMaterial(1, "SGMh", 0.5, 4);
//                one.makeWriteMaterial(0, "SMj", 0.5, 5);
//
//
//            JsonP.parseMaterial();
//
//            Director director = new Director();
//            CarBuilder builder = new CarBuilder();
//            director.makePassengerCar(builder);
//            models.BuilderCar.Car car = builder.getResult();
//            System.out.println("Car built:\n" + car.printInfo());
//
//
//            (new User.BuilderCar())
//                    .setAdress("aa")
//                    .setCountry("aa")
//                    .setFirstName("aa")
//                    .setLastName("aa")
//                    .setMail("aa")
//                    .build();
//
//            User u = (new User.BuilderCar()).build();
//
//            //сделать еще билдер итератор фасад
//
//
//
//
//
//        } catch (NumberFormatException e) {
//            System.out.print("Введено не число!");
//        }
//
