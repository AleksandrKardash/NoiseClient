package models.materialFactory;

import models.JsonSimple.JsonW;

public class MaterialCreate {


    public void makeWriteMaterial(int type, String b, double w, double h){
        Material material = MaterialFactory.createMaterial(type);
        material.setBrand(b);
        material.setSize(w,h);
        info(material);
        JsonW.writeMaterial(material);

    }
    public void makeMaterial(int type, String b, double w, double h){
        Material material = MaterialFactory.createMaterial(type);
        material.setBrand(b);
        material.setSize(w,h);
        info(material);

    }


    private void info(Material material){
        System.out.println(material.getName());
        System.out.println(material.getBrand());
        System.out.println(material.getArea());
        System.out.println();
    }

    }


