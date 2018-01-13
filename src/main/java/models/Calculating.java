package models;
import models.materialFactory.*;

// расчет расхода по элементам (пока примитивный)
abstract public class Calculating {

    double k;
    int l;

    Calculating(double k) {
        k = this.k;
    }

    abstract double amount(double k);
}

