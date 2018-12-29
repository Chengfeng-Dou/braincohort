package braincohort.pku.edu.website.services;

import braincohort.pku.edu.website.entity.DataSetDescription;
import braincohort.pku.edu.website.entity.DataSetDetail;

import java.util.List;

public interface DataSetService {

    List<DataSetDescription> getDataSetByPage(int page);

    int getDataSetPageNum();

    DataSetDetail getDetailByName(String name);
}
