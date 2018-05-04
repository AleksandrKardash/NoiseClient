package models.Calculate;

import Noise.Noise;
import models.Table.MaterialTable;

import java.util.ArrayList;

public class CalculateByArea implements Calculate {

    private ArrayList<MaterialTable> allElements = new ArrayList<>();


    public CalculateByArea(Double area) {

        Double count = Math.ceil(area / 0.35);

        if (Noise.getNavigation().getOptionsCarController().layerVibro.isSelected()){

            switch (Noise.getNavigation().getOptionsCarController().depthElement.getValue()){

                case "Минимум" :
                    allElements.add(new MaterialTable("Виброизоляция", 0.35,2, count));
                    break;

                case "Стандарт" :
                    allElements.add(new MaterialTable("Виброизоляция", 0.35,3, count));
                    break;

                case "Максимум":
                    allElements.add(new MaterialTable("Виброизоляция", 0.35,4, count));
                    break;

            }


        }

        if (Noise.getNavigation().getOptionsCarController().layerNoise.isSelected()){

            switch (Noise.getNavigation().getOptionsCarController().depthElement.getValue()){

                case "Минимум" :
                    allElements.add(new MaterialTable("Звукоизоляция", 0.75,4, count/2));
                    break;

                case "Стандарт" :
                    allElements.add(new MaterialTable("Звукоизоляция", 0.75,4, count/2));
                    break;

                case "Максимум" :
                    allElements.add(new MaterialTable("Звукоизоляция", 0.75,8, count/2));
                    break;

            }


        }

        if (Noise.getNavigation().getOptionsCarController().layerBlock.isSelected()){

            switch (Noise.getNavigation().getOptionsCarController().depthElement.getValue()){

                case "Минимум" :
                    allElements.add(new MaterialTable("Блокатор", 0.35,2, count));
                    break;

                case "Стандарт" :
                    allElements.add(new MaterialTable("Блокатор", 0.35,2, count));
                    break;

                case "Максимум" :
                    allElements.add(new MaterialTable("Блокатор", 0.35,3, count));
                    break;

            }

        }

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
        return allElements;
    }
}
