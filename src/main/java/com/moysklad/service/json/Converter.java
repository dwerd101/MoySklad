package com.moysklad.service.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.moysklad.model.ArrivalOrSaleOfProduct;
import com.moysklad.view.ArrivalProductView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Converter {
    private final static String baseFile = "../webapps/root/uploads/json/";

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
        return  jsonToObjectList;
    }

}
