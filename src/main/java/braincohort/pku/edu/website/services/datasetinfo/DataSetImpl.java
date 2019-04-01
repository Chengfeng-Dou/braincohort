package braincohort.pku.edu.website.services.datasetinfo;

import braincohort.pku.edu.website.controllers.disease.DataSetService;
import braincohort.pku.edu.website.entity.disease.DataSetDescription;
import braincohort.pku.edu.website.entity.disease.DataSetDetail;
import braincohort.pku.edu.website.services.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service(value = "dataset_impl")
public class DataSetImpl implements DataSetService {
    private final DataSetDao dataSetDao;
    private final DataSetDetailDao dataSetDetailDao;
    private final FileUtils fileUtils;
    private static final int PAGE_SIZE = 6;

    @Autowired
    public DataSetImpl(DataSetDao dataSetDao, DataSetDetailDao dataSetDetailDao, FileUtils fileUtils) {
        this.dataSetDao = dataSetDao;
        this.dataSetDetailDao = dataSetDetailDao;
        this.fileUtils = fileUtils;
    }

    @Override
    public List<DataSetDescription> getDataSetByPage(int page) {
        return dataSetDao.findAll(PageRequest.of(page, PAGE_SIZE)).getContent();
    }

    @Override
    public int getDataSetPageNum() {
        return (int) (dataSetDao.count() / PAGE_SIZE + 1);
    }

    @Override
    public DataSetDetail getDetailByLink(String link) throws IOException {
        System.out.println(link);
        DataSetDetail detail = dataSetDetailDao.findOneById(link);
        detail.content = fileUtils.getMarkDownInfo(detail.markdown);
        return detail;
    }
}
