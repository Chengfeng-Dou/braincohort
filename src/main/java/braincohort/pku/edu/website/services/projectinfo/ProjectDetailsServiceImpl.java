package braincohort.pku.edu.website.services.projectinfo;

import braincohort.pku.edu.website.controllers.index.ProjectDetailsService;
import braincohort.pku.edu.website.entity.index.ProjectContent;
import braincohort.pku.edu.website.services.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service(value = "project_details_impl")
public class ProjectDetailsServiceImpl implements ProjectDetailsService {
    private final ProjectContentDao projectContentDao;
    private final FileUtils fileUtils;

    @Autowired
    public ProjectDetailsServiceImpl(ProjectContentDao projectContentDao, FileUtils fileUtils) {
        this.projectContentDao = projectContentDao;
        this.fileUtils = fileUtils;
    }

    @Override
    public List<ProjectContent> getProjectContent(String link) {
        return projectContentDao.findAllByBelongOrderByShowOrderDesc(link);
    }

    @Override
    public String getMarkDownInfo(String markdown) throws IOException {
        return fileUtils.getMarkDownInfo(markdown);
    }
}
