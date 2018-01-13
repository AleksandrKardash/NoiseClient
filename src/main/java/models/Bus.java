package models;
import models.materialFactory.*;

// автобус
public class Bus extends Car {
    public int bus_class;
    private double k;

    // конструкторы
    Bus(String m, String md, int y, int a) {
        super(m, md, y);
    }
    Bus() {
        super();
    }

        // устанавливаем значение класса буса
    public void SetClass(int a) {
        if(a>0&&a<5) {
            bus_class=a;
        } else {
            System.out.println("неверные данные!");
        }
    }

    // коэффицент в зависимости от класса буса
    public double coeff() {
        switch (bus_class) {
            case 1:  k = 1;  // особо малый (микроавтобус)
                break;
            case 2:  k=1.1;  // малый (6-7,5 м)
                break;
            case 3:  k=1.1;  // средний (8-9,5 м)
                break;
            case 4:  k=1.1;  // большой (10,5-12 м)
                break;
            default:   k=1;
                break;
        }
        return k;
    }

}