package braincohort.pku.edu.website.services.datasetinfo;

import braincohort.pku.edu.website.entity.disease.DataSetDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DataSetDetailDao extends JpaRepository<DataSetDetail, String> {

    @Query("select d from DataSetDetail d where d.link = :id")
    DataSetDetail findOneById(@Param("id") String id);
}
