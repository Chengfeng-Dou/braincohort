package braincohort.pku.edu.website.entity.disease;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dataset_index")
public class DataSetDescription {
    @Id
    @Column(name = "title")
    public String title;
    @Column(name = "logo_pic")
    public String logoPic;
    @Column(name = "sample_num")
    public String sampleNum;
    @Column(name = "age_range")
    public String ageRange;
    @Column(name = "state")
    public String state;
    @Column(name = "data_type")
    public String dataType;
    @Column(name = "link")
    public String link;
}
