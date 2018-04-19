package models.Calculate;

import models.BuilderCar.Car;
import models.Table.MaterialTable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

//класс для рассчета необходимого материала по элементам
public class CalculatePassengerCar implements Calculate {

    private ArrayList<MaterialTable> floor = new ArrayList<>();   //пол
    private ArrayList<MaterialTable> door = new ArrayList<>();    //двери
    private ArrayList<MaterialTable> roof = new ArrayList<>();    //крыша
    private ArrayList<MaterialTable> arch = new ArrayList<>();    //арки
    private ArrayList<MaterialTable> hood = new ArrayList<>();    //капот
    private ArrayList<MaterialTable> trunk = new ArrayList<>();   //багажник
    private ArrayList<MaterialTable> allElements = new ArrayList<>(); //все вместе



    public CalculatePassengerCar(Car car) {

        //проверяем какие элементы необходимо обработать
        if (car.getElements().getFloor()){

            //добавляем необходимые материалы, в зависимости от класса авто, в коллекцию
            switch (car.getC().getC()) {

                case "A":
                    floor.add(new MaterialTable("Виброизоляция", 0.35,3, 7));
                    floor.add(new MaterialTable("Звукоизоляция", 0.75,4, 3.5));

                    break;

                case "B":
                case "C":
                    floor.add(new MaterialTable("Виброизоляция", 0.35,3, 9));
                    floor.add(new MaterialTable("Звукоизоляция", 0.75,4, 4.5));

                    break;

                case "D":
                case "E":
                    floor.add(new MaterialTable("Виброизоляция", 0.35,3, 10));
                    floor.add(new MaterialTable("Звукоизоляция", 0.75,4, 5));

                    break;

                case "F":
                case "M":
                    floor.add(new MaterialTable("Виброизоляция", 0.35,3, 12));
                    floor.add(new MaterialTable("Звукоизоляция", 0.75,4, 6));

                    break;

                case "J":
                    floor.add(new MaterialTable("Виброизоляция", 0.35,3, 10));
                    floor.add(new MaterialTable("Звукоизоляция", 0.75,4, 5));

                    break;
            }
        }

        if (car.getElements().getDoor()!=0){

            //в зависимости от количества дверей, добавляем в цикле необходимое количество материала в коллекцию
            for (int i=0; i<car.getElements().getDoor(); i++) {
                switch (car.getC().getC()) {

                    case "A":
                        door.add(new MaterialTable("Виброизоляция", 0.35, 2, 1.5));
                        door.add(new MaterialTable("Звукоизоляция", 0.75, 4, 0.5));
                        door.add(new MaterialTable("Шумопоглотитель", 0.75, 5, 0.5));

                        break;

                    case "B":
                    case "C":
                        door.add(new MaterialTable("Виброизоляция", 0.35, 2, 2));
                        door.add(new MaterialTable("Звукоизоляция", 0.75, 4, 0.5));
                        door.add(new MaterialTable("Шумопоглотитель", 0.75, 5, 0.5));

                        break;

                    case "D":
                    case "E":
                        door.add(new MaterialTable("Виброизоляция", 0.35, 2, 2.5));
                        door.add(new MaterialTable("Звукоизоляция", 0.75, 4, 0.75));
                        door.add(new MaterialTable("Шумопоглотитель", 0.75, 5, 0.75));

                        break;

                    case "F":
                    case "M":
                    case "J":
                        door.add(new MaterialTable("Виброизоляция", 0.35, 2, 2.5));
                        door.add(new MaterialTable("Звукоизоляция", 0.75, 4, 0.75));
                        door.add(new MaterialTable("Шумопоглотитель", 0.75, 5, 0.75));

                        break;

                }
            }
            //суммируем и удаляем дубли созданные в цикле
            door = delDouble(door);
        }

        if (car.getElements().getRoof()){

            switch (car.getC().getC()) {

                case "A":
                    roof.add(new MaterialTable("Виброизоляция", 0.35,2, 3));
                    roof.add(new MaterialTable("Звукоизоляция", 0.75,4, 1.5));

                    break;

                case "B":
                case "C":
                    roof.add(new MaterialTable("Виброизоляция", 0.35,2, 4));
                    roof.add(new MaterialTable("Звукоизоляция", 0.75,4, 2));

                    break;

                case "D":
                case "E":
                    roof.add(new MaterialTable("Виброизоляция", 0.35,2, 5));
                    roof.add(new MaterialTable("Звукоизоляция", 0.75,4, 2.5));

                    break;

                case "F":
                case "M":
                    roof.add(new MaterialTable("Виброизоляция", 0.35,2, 6));
                    roof.add(new MaterialTable("Звукоизоляция", 0.75,4, 3));

                    break;

                case "J":
                    roof.add(new MaterialTable("Виброизоляция", 0.35,2, 5.5));
                    roof.add(new MaterialTable("Звукоизоляция", 0.75,4, 3));

                    break;

            }

        }

        if (car.getElements().getArch()!=0){

            switch (car.getC().getC()) {

                case "A":
                    arch.add(new MaterialTable("Виброизоляция", 0.35,3, 3));
                    arch.add(new MaterialTable("Звукоизоляция", 0.75,8, 1.5));

                    break;

                case "B":
                case "C":
                    arch.add(new MaterialTable("Виброизоляция", 0.35,3, 4));
                    arch.add(new MaterialTable("Звукоизоляция", 0.75,8, 2));

                    break;

                case "D":
                case "E":
                    arch.add(new MaterialTable("Виброизоляция", 0.35,3, 4.5));
                    arch.add(new MaterialTable("Звукоизоляция", 0.75,8, 2.5));

                    break;

                case "F":
                case "M":
                case "J":
                    arch.add(new MaterialTable("Виброизоляция", 0.35,3, 5));
                    arch.add(new MaterialTable("Звукоизоляция", 0.75,8, 3));

                    break;

            }

        }

        if (car.getElements().getHood()){

            switch (car.getC().getC()) {

                case "A":
                    hood.add(new MaterialTable("Виброизоляция", 0.35,2, 2));
                    hood.add(new MaterialTable("Звукоизоляция", 0.75,4, 1));

                    break;

                case "B":
                case "C":
                    hood.add(new MaterialTable("Виброизоляция", 0.35,2, 2.5));
                    hood.add(new MaterialTable("Звукоизоляция", 0.75,4, 1.5));

                    break;

                case "D":
                case "E":
                    hood.add(new MaterialTable("Виброизоляция", 0.35,2, 3));
                    hood.add(new MaterialTable("Звукоизоляция", 0.75,4, 2));

                    break;

                case "F":
                case "M":
                    hood.add(new MaterialTable("Виброизоляция", 0.35,2, 3));
                    hood.add(new MaterialTable("Звукоизоляция", 0.75,4, 2));

                    break;

                case "J":
                    hood.add(new MaterialTable("Виброизоляция", 0.35,2, 2.5));
                    hood.add(new MaterialTable("Звукоизоляция", 0.75,4, 1.5));

                    break;

            }

        }

        if (car.getElements().getTrunk()){

            switch (car.getC().getC()) {

                case "A":
                    trunk.add(new MaterialTable("Виброизоляция", 0.35,3, 4));
                    trunk.add(new MaterialTable("Звукоизоляция", 0.75,4, 2));

                    break;

                case "B":
                case "C":
                    trunk.add(new MaterialTable("Виброизоляция", 0.35,3, 5));
                    trunk.add(new MaterialTable("Звукоизоляция", 0.75,4, 2.5));

                    break;

                case "D":
                case "E":
                    trunk.add(new MaterialTable("Виброизоляция", 0.35,3, 6));
                    trunk.add(new MaterialTable("Звукоизоляция", 0.75,4, 3));

                    break;

                case "F":
                case "M":
                    trunk.add(new MaterialTable("Виброизоляция", 0.35,3, 6));
                    trunk.add(new MaterialTable("Звукоизоляция", 0.75,4, 3));

                    break;

                case "J":
                    trunk.add(new MaterialTable("Виброизоляция", 0.35,3, 5));
                    trunk.add(new MaterialTable("Звукоизоляция", 0.75,4, 2.5));

                    break;

            }

        }

        //обьединение всех материалов в одну коллекцию с исключением и суммированием одинаковых позиций
        //создаем новую коллекцию содержащую копии(а не ссылки на те же обьекты!) обьектов всех материалов из имеющихся коллекций
        ArrayList<MaterialTable> allElementsD  = new ArrayList<>();

        for (MaterialTable i: floor) {allElementsD.add(new MaterialTable(i.getNameMat(), i.getAreaMat(), i.getDepthMat(), i.getCountMat()));}
        for (MaterialTable i: door) {allElementsD.add(new MaterialTable(i.getNameMat(), i.getAreaMat(), i.getDepthMat(), i.getCountMat()));}
        for (MaterialTable i: roof) {allElementsD.add(new MaterialTable(i.getNameMat(), i.getAreaMat(), i.getDepthMat(), i.getCountMat()));}
        for (MaterialTable i: arch) {allElementsD.add(new MaterialTable(i.getNameMat(), i.getAreaMat(), i.getDepthMat(), i.getCountMat()));}
        for (MaterialTable i: hood) {allElementsD.add(new MaterialTable(i.getNameMat(), i.getAreaMat(), i.getDepthMat(), i.getCountMat()));}
        for (MaterialTable i: trunk) {allElementsD.add(new MaterialTable(i.getNameMat(), i.getAreaMat(), i.getDepthMat(), i.getCountMat()));}

        allElements = delDouble(allElementsD);

    }

    //метод удаляет одинаковые материалы, предварительно суммируя их количество
    public ArrayList<MaterialTable> delDouble(ArrayList<MaterialTable> list){

        ArrayList<MaterialTable> notDoubleList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {

            if (!list.get(i).getNameMat().equals("delete")) {

                for (int a = 1 + i; a < list.size(); a++) {
                    if (Objects.equals(list.get(i).getNameMat(), list.get(a).getNameMat()) && list.get(i).getAreaMat() == list.get(a).getAreaMat() && list.get(i).getDepthMat() == list.get(a).getDepthMat() && !list.get(a).getNameMat().equals("delete")) {

                        list.get(i).setCountMat(list.get(i).getCountMat() + list.get(a).getCountMat());
                        list.get(a).setNameMat("delete");

                    }
                }
                notDoubleList.add(list.get(i));
            }
        }
        return notDoubleList;
    }
    @Override
    public ArrayList<MaterialTable> getFloor() {
        return floor;
    }
    @Override
    public ArrayList<MaterialTable> getDoor() {
        return door;
    }
    @Override
    public ArrayList<MaterialTable> getRoof() {
        return roof;
    }
    @Override
    public ArrayList<MaterialTable> getArch() {
        return arch;
    }
    @Override
    public ArrayList<MaterialTable> getHood() {
        return hood;
    }
    @Override
    public ArrayList<MaterialTable> getTrunk() {
        return trunk;
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
