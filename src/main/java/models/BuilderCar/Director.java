package models.BuilderCar;


public class Director {

    public void makePassengerCar(Builder builder) {
        builder.setBrandAuto(null);
        builder.setModelAuto(null);
        builder.setTypeAuto(TypeAuto.Passenger_Car);
        builder.setClassAuto(new ClassAuto("A"));
        builder.setElements(new ElementsPassenger());
    }

    public void makeTruck(Builder builder) {
        builder.setBrandAuto(null);
        builder.setModelAuto(null);
        builder.setTypeAuto(TypeAuto.Truck);
        builder.setClassAuto(new ClassAuto("AT"));
        builder.setElements(new ElementsTruck());
    }

    public void makeBus(Builder builder) {
        builder.setBrandAuto(null);
        builder.setModelAuto(null);
        builder.setTypeAuto(TypeAuto.Bus);
        builder.setClassAuto(new ClassAuto("AB"));
        builder.setElements(new ElementsBus());
    }
}