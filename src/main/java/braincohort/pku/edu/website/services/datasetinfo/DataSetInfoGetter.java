package braincohort.pku.edu.website.services.datasetinfo;

import braincohort.pku.edu.website.JsonParser;
import braincohort.pku.edu.website.entity.DataSetDescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class DataSetInfoGetter {
    @Value("classpath:static/json/dataset_info.json")
    private Resource resource;
    private final JsonParser jsonParser;

    @Autowired
    public DataSetInfoGetter(JsonParser jsonParser) {
        this.jsonParser = jsonParser;
    }

    @Bean
    public List<DataSetDescription> getDataSetDes(){
        try {
            return jsonParser.getListFromJson(DataSetDescription.class, resource.getFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
