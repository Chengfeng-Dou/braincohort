package braincohort.pku.edu.website.entity.disease;

import javax.persistence.*;

@Entity
@Table(name = "dataset_details")
public class DataSetDetail {
    @Id
    @Column
    public String link;
    @Column(name = "title")
    public String title;
    @Column(name = "what")
    public String what;
    @Column(name = "who")
    public String who;
    @Column(name = "_when")
    public String when;
    @Column(name = "sources")
    public String sources;
    @Column(name = "markdown")
    public String markdown;
    @Transient
    public String content;
}
