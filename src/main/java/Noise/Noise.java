package Noise;

import UI.controller.Navigation;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.NetHelper;

import java.net.InetAddress;


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
        //navigate to first view
        Noise.getNavigation().load("/view/mainWindow.fxml").Show();


        //запускаем паралельный поток для соединения с сервером
       Runnable connect = new NetHelper();
        Thread conn = new Thread(connect);
        conn.start();

    }


public static void main(String[] args) throws Exception {

        launch(args);



//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        System.out.print("Введите марку авто: ");
//        String manufacturer = reader.readLine();
//        System.out.print("Введите модель авто: ");
//        String model = reader.readLine();
//        try {
//            System.out.print("Введите год выпуска: ");
//            String y = reader.readLine();
//            int year = Integer.parseInt(y);
//            System.out.print("Введите класс авто (1-5): ");
//            String a = reader.readLine();
//            int a_class = Integer.parseInt(a);
//
//            // создaдим легковой автомобиль и передадим его параметры
//            PassengerCar mycar = new PassengerCar();
//            mycar.SetCar(manufacturer, model, year);
//            // определим класс
//            mycar.SetClass(a_class);
//            // определим элементы для обработки по умолчанию
//            Element element = new Element();
//            // создадим обьект расчета обработки нужного элемента
//            Door door = new Door(element.door);
//
//            System.out.println("Марка: " + mycar.manufacturer + " Модель: " + mycar.model + " Год: " + mycar.year + " Класс: " + mycar.auto_class);
//            // пример вывода количества для дверей
//            System.out.println("Для дверей: " + door.amount(mycar.coeff()));
//
//
//
//
//
//              MaterialCreate one = new MaterialCreate();
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
    }

}