package items.handlers;

import com.google.gson.Gson;

public class JsonHandler {

    private static Gson gson = new Gson();

    public static String convertObjectToJsonString(Object obj) {
        return gson.toJson(obj);
    }

    public static<T> T convertJsonStringToObject(String json, Class<T> type) {
        return gson.fromJson(json, type);
    }

}
