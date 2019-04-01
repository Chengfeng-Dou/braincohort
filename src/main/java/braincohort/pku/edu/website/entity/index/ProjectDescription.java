package braincohort.pku.edu.website.entity.index;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "website_index")
public class ProjectDescription {
    @Id
    @Column(name = "name")
    public String title;
    @Column(name = "source")
    public String source;
    @Column(name = "person")
    public String personInCharge;
    @Column(name = "description")
    public String description;
    @Column(name = "link")
    public String link;


}
