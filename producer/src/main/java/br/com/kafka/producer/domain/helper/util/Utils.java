package br.com.kafka.producer.domain.helper.util;

import com.google.gson.Gson;

public class Utils {

    private static Gson gson = new Gson();

    public Utils(){
        throw new IllegalStateException("Utility class");
    }

    public static String objectToJson(Object object){
        return gson.toJson(object);
    }

}
