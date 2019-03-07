package braincohort.pku.edu.website.services.datasetinfo;

import braincohort.pku.edu.website.entity.DataSetDescription;
import braincohort.pku.edu.website.entity.DataSetDetail;
import braincohort.pku.edu.website.services.DataManager;
import braincohort.pku.edu.website.controllers.DataSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("dataSetStub")
public class DataSetStub implements DataSetService {
    private DataManager<DataSetDescription> manager;
    private final Map<String, DataSetDetail> dataSetDetailHashMap;

    @Autowired
    public DataSetStub(List<DataSetDescription> dataSetDescriptions,
                       Map<String, DataSetDetail> dataSetDetailHashMap) {
        manager = new DataManager<>(dataSetDescriptions);
        this.dataSetDetailHashMap = dataSetDetailHashMap;
    }

    @Override
    public List<DataSetDescription> getDataSetByPage(int page) {
        return manager.getDataByPage(page);
    }

    @Override
    public int getDataSetPageNum() {
        return manager.getPageNum();
    }

    @Override
    public DataSetDetail getDetailByName(String name) {
        return dataSetDetailHashMap.get(name);
    }
}
