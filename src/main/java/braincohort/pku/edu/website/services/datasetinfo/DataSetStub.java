package braincohort.pku.edu.website.services.datasetinfo;

import braincohort.pku.edu.website.entity.DataSetDescription;
import braincohort.pku.edu.website.services.DataManager;
import braincohort.pku.edu.website.services.DataSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("dataSetStub")
public class DataSetStub implements DataSetService {
    private DataManager<DataSetDescription> manager;

    @Autowired
    public DataSetStub(List<DataSetDescription> dataSetDescriptions) {
        manager = new DataManager<>(dataSetDescriptions);
    }

    @Override
    public List<DataSetDescription> getDataSetByPage(int page) {
        return manager.getDataByPage(page);
    }

    @Override
    public int getDataSetPageNum() {
        return manager.getPageNum();
    }
}
