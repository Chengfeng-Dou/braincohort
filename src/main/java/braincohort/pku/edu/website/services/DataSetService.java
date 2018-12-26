package braincohort.pku.edu.website.services;

import braincohort.pku.edu.website.entity.DataSetDescription;

import java.util.List;

public interface DataSetService {

    List<DataSetDescription> getDataSetByPage(int page);

    int getDataSetPageNum();
}
