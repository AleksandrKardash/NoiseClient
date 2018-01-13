package models.JsonSimple;

import com.google.gson.Gson;
import models.materialFactory.Material;
import models.materialFactory.MaterialCreate;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.Iterator;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JsonP {

    public static void parseMaterial() {
        final String FILENAME = "c:\\file.json";
        JSONParser parser = new JSONParser();
        int t=0;


        try {
           JSONObject obj;
           obj = (JSONObject) parser.parse(new FileReader(FILENAME));
           JSONObject a = (JSONObject) obj;
           JSONArray items = (JSONArray) a.get("mat");


            for (Object item : items) {
                JSONObject values = (JSONObject) item;
                double area = (double) values.get("area");
                String brand = (String) values.get("brand");
                String name = (String) values.get("name");


                if (Objects.equals(name, "Виброизоляция")) {
                    t = 0;
                } else if (Objects.equals(name, "Звукоизоляция")) {
                    t = 1;
                } else if (Objects.equals(name, "Шумопоглотитель")) {
                    t = 2;
                }
                MaterialCreate two = new MaterialCreate();
                two.makeMaterial(t, brand, area, area);
            }

        } catch (IOException | ParseException ex) {
            Logger.getLogger(JsonP.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }
}