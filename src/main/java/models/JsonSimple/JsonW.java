package models.JsonSimple;

import models.materialFactory.Material;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JsonW {


    public static void writeMaterial(Material material) {
        final String FILENAME = "c:\\file.json";
        final File file = new File(FILENAME);
        JSONObject obj = new JSONObject();
        JSONArray ar = new JSONArray();


        if (file.length() != 0) {
            final String FILENAME2 = "c:\\file.json";
            JSONParser parser = new JSONParser();
            JSONObject obj2 = null;
            JSONObject a = null;
            try {
                obj2 = (JSONObject) parser.parse(new FileReader(FILENAME2));
                a = (JSONObject) obj2;
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }


            JSONArray it = (JSONArray) a.get("mat");
            JSONArray mat = new JSONArray();
            JSONObject obj3 = new JSONObject();


            for (Object anIt : it) {
                System.out.println((JSONObject) anIt);
                mat.add(anIt);
            }

            obj.put("name", material.getName());
            obj.put("brand", material.getBrand());
            obj.put("area", material.getArea());
            mat.add(obj);
            obj3.put("mat", mat);

            try (FileWriter writer = new FileWriter(FILENAME, false)) {
                BufferedWriter bufferWriter = new BufferedWriter(writer);
                bufferWriter.write(obj3.toJSONString());
                bufferWriter.close();
            } catch (IOException ex) {
                Logger.getLogger(JsonW.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        }


        else {
            JSONArray mat = new JSONArray();
            JSONObject obj3 = new JSONObject();
            obj.put("name", material.getName());
            obj.put("brand", material.getBrand());
            obj.put("area", material.getArea());
            mat.add(obj);
            obj3.put("mat", mat);


            try (FileWriter writer = new FileWriter(FILENAME, true)) {
                BufferedWriter bufferWriter = new BufferedWriter(writer);
                bufferWriter.write(obj3.toJSONString());
                bufferWriter.close();
            } catch (IOException ex) {
                Logger.getLogger(JsonW.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        }
    }
}