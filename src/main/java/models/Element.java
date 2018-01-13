package models;
import models.materialFactory.*;

// элементы авто участвующие в расчете расхода
public class Element {
    public int door; //двери
    public int arch; // арки
    public boolean floor; // пол
    public boolean trunk; // багажник
    public boolean roof; // крыша
    public boolean hood; // капот

    // конструктор
   public Element (int d, int a, boolean f, boolean t, boolean r, boolean h) {
        door = d;
        arch = a;
        floor = f;
        trunk = t;
        roof = r;
        hood = h;
    }
  public Element () {
        door = 4;
        arch = 4;
        floor = true;
        trunk = true;
        roof = true;
        hood = false;
    }

   public void SetElement (int d, int a, boolean f, boolean t, boolean r, boolean h) {
        door = d;
        arch = a;
        floor = f;
        trunk = t;
        roof = r;
        hood = h;
    }
}