package braincohort.pku.edu.website.controllers.disease;

import braincohort.pku.edu.website.entity.disease.DataSetDescription;
import braincohort.pku.edu.website.entity.disease.DataSetDetail;

import java.io.IOException;
import java.util.List;

public interface DataSetService {

    List<DataSetDescription> getDataSetByPage(int page);

    int getDataSetPageNum();

    DataSetDetail getDetailByLink(String link) throws IOException;
}
