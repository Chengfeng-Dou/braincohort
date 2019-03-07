package braincohort.pku.edu.website.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ProjectContentId implements Serializable {
    @Column(name = "belong")
    public String belong;
    @Column(name = "name")
    public String name;
}
