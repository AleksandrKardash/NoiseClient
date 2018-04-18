package models.BuilderCar;

public abstract class Elements{
    private boolean floor;   //пол
    private boolean floorS;  //пол
    private int door;        //двери
    private boolean roof;    //крыша
    private int arch;        //арки
    private boolean hood;    //капот
    private boolean trunk;  //багажник
    private boolean walls;  //стенки


    public abstract void floorOn();
    public abstract void floorOff();
    public abstract boolean getFloor();

    public abstract void doorOn(int door);
    public abstract void doorOff();
    public abstract int getDoor();

    public abstract void roofOn();
    public abstract void roofOff();
    public abstract boolean getRoof();

    public abstract void archOn();
    public abstract void archOff();
    public abstract int getArch();

    public abstract void hoodOn();
    public abstract void hoodOff();
    public abstract boolean getHood();

    public abstract void trunkOn();
    public abstract void trunkOff();
    public abstract boolean getTrunk();

    public abstract void floorSOn();
    public abstract void floorSOff();
    public abstract boolean getFloorS();

    public abstract void wallsOn();
    public abstract void wallsOff();
    public abstract boolean getWalls();

}

class ElementsPassenger extends Elements {

    private boolean floor = false; //пол
    private boolean floorS = false;  //пол
    private int door = 0;  //двери
    private boolean roof = false;  //крыша
    private int arch = 0;  //арки
    private boolean hood = false;  //капот
    private boolean trunk = false;  //багажник
    private boolean walls = false;  //стенки

    @Override
    public void floorOn() {
        floor = true;
    }
    @Override
    public void floorOff(){
        floor = false;
    }
    @Override
    public boolean getFloor(){
        return floor;
    }

    @Override
    public void doorOn(int door){
        this.door = door;
    }
    @Override
    public void doorOff(){
        door = 0;
    }
    @Override
    public int getDoor(){
        return door;
    }

    @Override
    public void roofOn(){
        roof = true;
    }
    @Override
    public void roofOff(){
        roof = false;
    }
    @Override
    public boolean getRoof(){
        return roof;
    }

    @Override
    public void archOn(){
        arch = 4;
    }
    @Override
    public void archOff(){
        arch = 0;
    }
    @Override
    public int getArch(){
        return arch;
    }

    @Override
    public void hoodOn(){
        hood = true;
    }
    @Override
    public void hoodOff(){
        hood = false;
    }
    @Override
    public boolean getHood(){
        return hood;
    }

    @Override
    public void trunkOn(){
        trunk = true;
    }
    @Override
    public void trunkOff(){
        trunk = false;
    }
    @Override
    public boolean getTrunk(){
        return trunk;
    }

    @Override
    public void floorSOn(){
        floorS = true;
    }
    @Override
    public void floorSOff(){
        floorS = false;
    }
    @Override
    public boolean getFloorS(){
        return floorS;
    }

    @Override
    public void wallsOn(){
            walls = true;
        }
    @Override
    public void wallsOff(){
            walls = false;
        }
    @Override
    public boolean getWalls(){
            return walls;
        }

}

class ElementsTruck extends Elements {

    private boolean floor = false; //пол
    private boolean floorS = false;  //пол
    private int door = 0;  //двери
    private boolean roof = false;  //крыша
    private int arch = 0;  //арки
    private boolean hood = false;  //капот
    private boolean trunk = false;  //багажник
    private boolean walls = false;  //стенки

    @Override
    public void floorOn() {
        floor = true;
    }
    @Override
    public void floorOff(){
        floor = false;
    }
    @Override
    public boolean getFloor(){
        return floor;
    }

    @Override
    public void doorOn(int door){
        this.door = door;
    }
    @Override
    public void doorOff(){
        door = 0;
    }
    @Override
    public int getDoor(){
        return door;
    }

    @Override
    public void roofOn(){
        roof = true;
    }
    @Override
    public void roofOff(){
        roof = false;
    }
    @Override
    public boolean getRoof(){
        return roof;
    }

    @Override
    public void archOn(){
        arch = 4;
    }
    @Override
    public void archOff(){
        arch = 0;
    }
    @Override
    public int getArch(){
        return arch;
    }

    @Override
    public void hoodOn(){
        hood = true;
    }
    @Override
    public void hoodOff(){
        hood = false;
    }
    @Override
    public boolean getHood(){
        return hood;
    }

    @Override
    public void trunkOn(){
        trunk = true;
    }
    @Override
    public void trunkOff(){
        trunk = false;
    }
    @Override
    public boolean getTrunk(){
        return trunk;
    }

    @Override
    public void floorSOn(){
        floorS = true;
    }
    @Override
    public void floorSOff(){
        floorS = false;
    }
    @Override
    public boolean getFloorS(){
        return floorS;
    }

    @Override
    public void wallsOn(){
        walls = true;
    }
    @Override
    public void wallsOff(){
        walls = false;
    }
    @Override
    public boolean getWalls(){
        return walls;
    }

}

class ElementsBus extends Elements {

    private boolean floor = false; //пол
    private boolean floorS = false;  //пол
    private int door = 0;  //двери
    private boolean roof = false;  //крыша
    private int arch = 0;  //арки
    private boolean hood = false;  //капот
    private boolean trunk = false;  //багажник
    private boolean walls = false;  //стенки

    @Override
    public void floorOn() {
        floor = true;
    }
    @Override
    public void floorOff(){
        floor = false;
    }
    @Override
    public boolean getFloor(){
        return floor;
    }

    @Override
    public void doorOn(int door){
        this.door = door;
    }
    @Override
    public void doorOff(){
        door = 0;
    }
    @Override
    public int getDoor(){
        return door;
    }

    @Override
    public void roofOn(){
        roof = true;
    }
    @Override
    public void roofOff(){
        roof = false;
    }
    @Override
    public boolean getRoof(){
        return roof;
    }

    @Override
    public void archOn(){
        arch = 4;
    }
    @Override
    public void archOff(){
        arch = 0;
    }
    @Override
    public int getArch(){
        return arch;
    }

    @Override
    public void hoodOn(){
        hood = true;
    }
    @Override
    public void hoodOff(){
        hood = false;
    }
    @Override
    public boolean getHood(){
        return hood;
    }

    @Override
    public void trunkOn(){
        trunk = true;
    }
    @Override
    public void trunkOff(){
        trunk = false;
    }
    @Override
    public boolean getTrunk(){
        return trunk;
    }

    @Override
    public void floorSOn(){
        floorS = true;
    }
    @Override
    public void floorSOff(){
        floorS = false;
    }
    @Override
    public boolean getFloorS(){
        return floorS;
    }

    @Override
    public void wallsOn(){
        walls = true;
    }
    @Override
    public void wallsOff(){
        walls = false;
    }
    @Override
    public boolean getWalls(){
        return walls;
    }

}