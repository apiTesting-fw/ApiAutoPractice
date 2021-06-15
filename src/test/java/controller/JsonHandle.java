package controller;

import io.restassured.response.ResponseBody;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class JsonHandle {

    public String readOrUpdateJsonBodyFromFile(String key, boolean isArray, String[] keyUpdate, String[] valueUpdate) {
        JSONParser parser = new JSONParser();
        String apiValue = null;

        try {
            Object obj = parser.parse(new FileReader("src/test/resources/Json/JsonBody.json"));
            JSONObject jsonObject = (JSONObject) obj;
            Object tempValue = jsonObject.get(key);
            if(isArray = false){
                apiValue = tempValue.toString();
            } else if(keyUpdate == null || valueUpdate == null){
                apiValue = tempValue.toString();
            } else {
                JSONObject json = (JSONObject) parser.parse(tempValue.toString());
                for(int i = 0; i < keyUpdate.length; i++){
                    json.put(keyUpdate[i],valueUpdate[i]);
                }
                apiValue = json.toString();
            }
//            System.out.println(apiValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return apiValue;
    }

    public String readOrUpdateJsonBody(ResponseBody response, String key, boolean isArray, String[] keyUpdate, String[] valueUpdate) {
        JSONParser parser = new JSONParser();
        String apiValue = null;

        try {
            Object obj = parser.parse(response.asString());
            JSONObject jsonObject = (JSONObject) obj;
            Object tempValue = jsonObject.get(key);
            if(isArray = false){
                apiValue = tempValue.toString();
            } else if(keyUpdate == null || valueUpdate == null){
                apiValue = tempValue.toString();
            } else {
                JSONObject json = (JSONObject) parser.parse(tempValue.toString());
                for(int i = 0; i < keyUpdate.length; i++){
                    json.put(keyUpdate[i],valueUpdate[i]);
                }
                apiValue = json.toString();
            }
//            System.out.println(apiValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return apiValue;
    }
}
