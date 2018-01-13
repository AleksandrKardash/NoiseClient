package models;
import models.materialFactory.*;

// родительский класс автомобиль
public class Car {

   public String manufacturer;
   public String model;
   public int year;

    // конструкторы
    Car () {
        manufacturer = "none";
        model = "none";
        year = 0;
    }

    Car (String m, String md, int y) {
        manufacturer = m;
        model = md;
        year = y;
    }

    public void SetCar(String m, String md, int y) {
        manufacturer = m;
        model = md;
        year = y;
    }
}