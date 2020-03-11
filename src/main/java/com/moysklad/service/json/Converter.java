package com.moysklad.service.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.moysklad.model.ArrivalOfProduct;
import com.moysklad.model.interfaceModel.Model;
import com.moysklad.view.interfaceView.View;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Converter {
    private final static String baseFile = "../webapps/root/uploads/json/";
    private final static String baseDownloadFile = "../webapps/root/downloads/json" + File.separator;

    public static List<Model> toJavaObjectList(String requestPath) throws IOException {
        List<Model> jsonToObjectList = new ArrayList<>();
        File dir = new File(baseFile);
        try {
            for (File file : dir.listFiles()
            ) {
                ObjectMapper mapper = new ObjectMapper();
                switch (requestPath) {
                    case "/window/arrival/view_all_documents":
                        ArrivalOfProduct jsonToObject = mapper.readValue(file, ArrivalOfProduct.class);
                        jsonToObjectList.add(jsonToObject);
                        break;
                }
                if (file.delete()) {
                    System.out.println("Успешно");
                }
            }
            return jsonToObjectList;

        } catch (UnrecognizedPropertyException e) {
            for (File file : dir.listFiles()
            ) {
                if (file.delete()) {
                    System.out.println("Успешно");
                }
            }
        }
        return null;
    }

    public static void toJsonListOfProduct(List<View> list) {
        try {
            String name = "generalListOfProduct";
            int count = 0;
            String typeFile = ".json";

            for (View product : list
            ) {
                String countString = Integer.toString(count);
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.writeValue(new File(baseDownloadFile, name + countString + typeFile), product);
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
