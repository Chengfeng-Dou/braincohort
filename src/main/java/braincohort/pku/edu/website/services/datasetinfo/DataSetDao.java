package braincohort.pku.edu.website.services.datasetinfo;

import braincohort.pku.edu.website.entity.disease.DataSetDescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataSetDao extends JpaRepository<DataSetDescription, String> {
}
