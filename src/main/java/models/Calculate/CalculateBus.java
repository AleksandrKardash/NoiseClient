package models.Calculate;

import models.BuilderCar.Car;
import models.Table.MaterialTable;

import java.util.ArrayList;

public class CalculateBus implements Calculate {

    private ArrayList<MaterialTable> floor;   //пол
    private ArrayList<MaterialTable> floorS;  //пол
    private ArrayList<MaterialTable> door;        //двери
    private ArrayList<MaterialTable> roof;    //крыша
    private ArrayList<MaterialTable> arch;        //арки
    private ArrayList<MaterialTable> hood;    //капот
    private ArrayList<MaterialTable> trunk;  //багажник
    private ArrayList<MaterialTable> walls;  //стенки

    public CalculateBus(Car car) {
    }


    public ArrayList<MaterialTable> delDouble() {
        return null;
    }

    @Override
    public ArrayList<MaterialTable> getFloor() {
        return null;
    }

    @Override
    public ArrayList<MaterialTable> getDoor() {
        return null;
    }

    @Override
    public ArrayList<MaterialTable> getRoof() {
        return null;
    }

    @Override
    public ArrayList<MaterialTable> getArch() {
        return null;
    }

    @Override
    public ArrayList<MaterialTable> getHood() {
        return null;
    }

    @Override
    public ArrayList<MaterialTable> getTrunk() {
        return null;
    }

    @Override
    public ArrayList<MaterialTable> getWalls() {
        return null;
    }

    @Override
    public ArrayList<MaterialTable> getAllElements() {
        return null;
    }
}
