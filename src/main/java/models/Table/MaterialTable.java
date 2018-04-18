package models.Table;

//класс для формирования таблицы
public class MaterialTable {

    private String nameMat;
    private double areaMat;
    private double depthMat;
    private int countMat;

    public MaterialTable(String nameMat, double areaMat, double depthMat, int countMat) {
        this.nameMat = nameMat;
        this.areaMat = areaMat;
        this.depthMat = depthMat;
        this.countMat = countMat;
    }

    public MaterialTable() {
    }

    public void setNameMat(String nameMat) {
        this.nameMat = nameMat;
    }

    public void setAreaMat(double areaMat) {
        this.areaMat = areaMat;
    }

    public void setDepthMat(double depthMat) {
        this.depthMat = depthMat;
    }

    public void setCountMat(int countMat) {
        this.countMat = countMat;
    }

    public String getNameMat() {
        return nameMat;
    }

    public double getAreaMat() {
        return areaMat;
    }

    public double getDepthMat() {
        return depthMat;
    }

    public int getCountMat() {
        return countMat;
    }
}
