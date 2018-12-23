package braincohort.pku.edu.website;

import braincohort.pku.edu.website.entity.ProjectDescription;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

@Configuration
public class ProjectListGetter {
    @Value("classpath:static/json/project_details.json")
    private Resource projectList;
    private final Gson gson;

    @Autowired
    public ProjectListGetter(Gson gson) {
        this.gson = gson;
    }

    @Bean
    public List<ProjectDescription> getProjectList(){
        List<ProjectDescription> list = new LinkedList<>();
        try {
            String jsonData = jsonRead(projectList.getFile());
            JsonParser jsonParser = new JsonParser();
            JsonArray jsonElements = jsonParser.parse(jsonData).getAsJsonArray();
            for (JsonElement jsonElement : jsonElements) {
                list.add(gson.fromJson(jsonElement, ProjectDescription.class));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
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
