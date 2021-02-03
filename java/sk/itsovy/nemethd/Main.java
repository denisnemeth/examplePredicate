package sk.itsovy.nemethd;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) throws IOException {

        String urlString = "http://itsovy.sk:5000/data";

        URL url = new URL(urlString);
        URLConnection request = url.openConnection();
        request.connect();

        JsonParser jsonParser = new JsonParser();
        JsonElement jsonElement = jsonParser.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        JsonArray jsonArray = jsonObject.get("world_x").getAsJsonArray();

        List<City> cities = new ArrayList<>();

        for (int i = 0; i < jsonArray.size(); i++) {
            City city = new City(((JsonObject) jsonArray.get(i)).get("pop").getAsInt(), ((JsonObject) jsonArray.get(i)).get("code").getAsString(),
                    ((JsonObject) jsonArray.get(i)).get("district").getAsString(), ((JsonObject) jsonArray.get(i)).get("name").getAsString());
            cities.add(city);
        }

        CityFromNLD<City> cityFromNLD = new CityFromNLD<>();
        Predicate<City> predicate = cityLbd -> cityLbd.getPopulation() > 100000;
        cities.stream().filter(cityFromNLD.and(predicate)).forEach(System.out::println);
    }
}
