package braincohort.pku.edu.website.services.projectinfo;

import braincohort.pku.edu.website.JsonParser;
import braincohort.pku.edu.website.entity.ProjectDescription;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class ProjectListGetter {
    @Value("classpath:static/json/project_details.json")
    private Resource projectList;

    private final JsonParser jsonParser;

    @Autowired
    public ProjectListGetter(JsonParser jsonParser) {
        this.jsonParser = jsonParser;
    }


    @Bean
    public List<ProjectDescription> getProjectList(){
        try {
            return jsonParser.getListFromJson(ProjectDescription.class, projectList.getFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

}
