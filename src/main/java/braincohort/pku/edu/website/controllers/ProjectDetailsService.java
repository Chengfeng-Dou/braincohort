package braincohort.pku.edu.website.controllers;

import braincohort.pku.edu.website.entity.ProjectContent;

import java.io.IOException;
import java.util.List;

public interface ProjectDetailsService {

    List<ProjectContent> getProjectContent(String link);

    String getMarkDownInfo(String markdown) throws IOException;
}
