package braincohort.pku.edu.website.entity.index;

import javax.persistence.*;

@Entity
@Table(name = "website_details")
@IdClass(ProjectContentId.class)
public class ProjectContent {
    @Id
    @Column(name = "belong")
    public String belong;

    @Id
    @Column(name = "name")
    public String name;

    @Column(name = "markdown")
    public String markdown;

    @Column(name = "show_order")
    public int showOrder;
}
