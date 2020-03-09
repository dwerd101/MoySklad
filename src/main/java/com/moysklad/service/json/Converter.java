package com.moysklad.service.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.moysklad.model.ArrivalOrSaleOfProduct;
import com.moysklad.view.GeneralListOfProductViewImpl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Converter {
    private final static String baseFile = "../webapps/root/uploads/json/";
    private final static String baseDownloadFile = "../webapps/root/downloads/json"+File.separator;

    public static List<ArrivalOrSaleOfProduct> toJavaObjectList() throws IOException {


        List<ArrivalOrSaleOfProduct>jsonToObjectList = new ArrayList<>();
        File dir = new File(baseFile);
        for (File file: dir.listFiles()
             ) {
            ObjectMapper mapper = new ObjectMapper();
            ArrivalOrSaleOfProduct jsonToObject = mapper.readValue(file, ArrivalOrSaleOfProduct.class);
            jsonToObjectList.add(jsonToObject);
            if(file.delete()) {
                System.out.println("Успешно");
            }
        }
        return jsonToObjectList;
    }
    public static void toJsonListOfProduct(List<GeneralListOfProductViewImpl> list) {
        try{
            String name = "generalListOfProduct";
            int count = 0;
            String typeFile = ".json";

        for (GeneralListOfProductViewImpl product : list
        ) {
            String countString = Integer.toString(count);
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File(baseDownloadFile,name+countString+typeFile), product);
            count++;
        }
    }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
