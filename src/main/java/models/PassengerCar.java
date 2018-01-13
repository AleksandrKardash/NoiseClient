package models;
import models.materialFactory.*;

// легковой авто
public class PassengerCar extends Car {

    public int auto_class;
    private double k;

    // конструкторы
    public PassengerCar(String m, String md, int y, int a) {
        super(m, md, y);
        auto_class = a;
    }
    public PassengerCar() {
        super();
        auto_class = 2;
    }


    // устанавливаем значение класса авто
    public void SetClass(int a) {
        if(a>0&&a<6) {
            auto_class=a;
        } else {
            System.out.println("неверные данные!");
        }
    }

    // коэффицент в зависимости от класса авто
    public double coeff() {
        switch (auto_class) {
            case 1:  k = 1;  // 1-малый класс авто (A,B)
                break;
            case 2:  k=1.1;  // 2-средний класс
                break;
            case 3:  k=1.1;  // 3-большой и бизнес класс
                break;
            case 4:  k=1.1;  // 4-минивены, кроссоверы
                break;
            case 5:  k=1.1;  // 5-микроавтобусы
                break;
            default:   k=1;
                break;
        }
        return k;
    }
}