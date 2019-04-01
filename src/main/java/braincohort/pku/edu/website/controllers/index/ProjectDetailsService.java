package braincohort.pku.edu.website.controllers.index;

import braincohort.pku.edu.website.entity.index.ProjectContent;

import java.io.IOException;
import java.util.List;

public interface ProjectDetailsService {

    List<ProjectContent> getProjectContent(String link);

    String getMarkDownInfo(String markdown) throws IOException;
}
