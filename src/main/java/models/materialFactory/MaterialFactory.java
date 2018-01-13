package models.materialFactory;


public class MaterialFactory {
    public static Material createMaterial(int type){
        switch (type){
            case 0: return new Vibroizol();
            case 1: return new Noiseisol();
            case 2: return new Noiseabsorber();
            default: return null;
        }
    }
}



