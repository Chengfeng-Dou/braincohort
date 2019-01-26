package braincohort.pku.edu.website.services.datasetinfo;

import braincohort.pku.edu.website.JsonParser;
import braincohort.pku.edu.website.entity.DataSetDescription;
import braincohort.pku.edu.website.entity.DataSetDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class DataSetInfoGetter {
    @Value("classpath:static/json/dataset_info.json")
    private Resource datasetInfo;
    @Value("classpath:static/json/dataset_details.json")
    private Resource datasetDetails;

    private final JsonParser jsonParser;

    @Autowired
    public DataSetInfoGetter(JsonParser jsonParser) {
        this.jsonParser = jsonParser;
    }

    @Bean
    public List<DataSetDescription> getDataSetDes() {
        try {
            return jsonParser.getListFromJson(DataSetDescription.class, datasetInfo.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Bean
    public Map<String, DataSetDetail> getDataSetDetails() {
        Map<String, DataSetDetail> dataSetDetailMap = new HashMap<>();
        try {
            List<DataSetDetail> dataSetDetails = jsonParser.getListFromJson(DataSetDetail.class, datasetDetails.getInputStream());
            for (DataSetDetail dataSetDetail : dataSetDetails) {
                dataSetDetailMap.put(dataSetDetail.title, dataSetDetail);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dataSetDetailMap;
    }


}
