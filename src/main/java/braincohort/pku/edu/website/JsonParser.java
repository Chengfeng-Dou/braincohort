package braincohort.pku.edu.website;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JsonParser {
    private final Gson gson = new Gson();


    public <T> List<T> getListFromJson(Class<T> beanClass, File jsonFile) {
        List<T> resultList = new ArrayList<>();
        try {
            String jsonString = jsonRead(jsonFile);
            com.google.gson.JsonParser jsonParser = new com.google.gson.JsonParser();
            JsonArray jsonElements = jsonParser.parse(jsonString).getAsJsonArray();
            for (JsonElement jsonElement : jsonElements) {
                resultList.add(gson.fromJson(jsonElement, beanClass));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return resultList;
    }

    private String jsonRead(File file) throws IOException {
        StringBuilder buffer = new StringBuilder();
        Scanner scanner = new Scanner(file, StandardCharsets.UTF_8);
        while (scanner.hasNextLine()) {
            buffer.append(scanner.nextLine());
        }
        return buffer.toString();
    }
}
