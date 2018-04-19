package models.Calculate;

import models.Table.MaterialTable;

import java.util.ArrayList;

public interface Calculate {

    public ArrayList<MaterialTable> getFloor();
    public ArrayList<MaterialTable> getDoor();
    public ArrayList<MaterialTable> getRoof();
    public ArrayList<MaterialTable> getArch();
    public ArrayList<MaterialTable> getHood();
    public ArrayList<MaterialTable> getTrunk();
    public ArrayList<MaterialTable> getWalls();
    public ArrayList<MaterialTable> getAllElements();

}


