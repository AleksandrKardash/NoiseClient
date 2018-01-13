package models.materialFactory;

public class Noiseisol implements Material {
    private String b;
    private double a;
    private double c;
    private double s;

    public String getName() {
        return "Звукоизоляция";
    }
    public String getBrand() {
        return b;
    }
    public double getArea() {
        return s;
    }
    public void setBrand(String b) {
        this.b = b;
    }
    public void setSize(double a, double c) {
        s = a*c;
    }

}
