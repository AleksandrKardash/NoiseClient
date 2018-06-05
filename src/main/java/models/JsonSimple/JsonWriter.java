package models.JsonSimple;

import models.Table.MaterialTable;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JsonWriter {

    private JSONArray listMain = new JSONArray();

    public JsonWriter (ArrayList<MaterialTable> list){

        for (MaterialTable material: list) {

            JSONObject object = new JSONObject();

            object.put("name", material.getNameMat());
            object.put("area", material.getAreaMat());
            object.put("depth", material.getDepthMat());
            object.put("count", material.getCountMat());

            listMain.add(object);

        }
                //выбор папки и запись в файл
                FileNameExtensionFilter filter = new FileNameExtensionFilter("*.json","*.*");
                JFileChooser fc = new JFileChooser();
                fc.setFileFilter(filter);
                if ( fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION ) {
                    try ( FileWriter writer = new FileWriter(fc.getSelectedFile(), true) ) {
                        writer.write(listMain.toJSONString());
                        writer.flush();
                        writer.close();
                    }
                    catch ( IOException e ) {

                    }
            }
    }

}



