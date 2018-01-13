package models;
import models.materialFactory.*;

// грузовой авто
public class Truck extends Car {

    // конструкторы
    Truck(String m, String md, int y, int a) {
        super(m, md, y);
    }
    Truck() {
        super();
    }

    boolean body;
    boolean cabin;
    double yardage;
    double k;

    // переключатель да/нет на конкретный элемент
    void SetBody(boolean a){
        body=a;
    }
    void SetCabin(boolean a){
        cabin=a;
    }
    // установка значения площади
    void SetYardage(double a){
        if(a>1) {
            yardage=a;
        } else  {
            System.out.println("неверные данные!");
        }
    }
    // определение коэффициента для грузовых авто
    double coeff(){
        if(body=true&&cabin==true) {
            k=2.4;
        } else if (cabin==true) {
            k=0.9;
        } else if (body=true) {
            k=1.5;
        } else if (yardage>0) {
            k=yardage/3.2;
        }
        return k;
    }

}