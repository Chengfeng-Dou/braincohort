package braincohort.pku.edu.website.services.projectinfo;

import braincohort.pku.edu.website.entity.index.ProjectDescription;
import braincohort.pku.edu.website.controllers.index.ProjectInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "project_info_impl")
public class ProjectInfoImpl implements ProjectInfoService {
    private final ProjectInfoDao projectInfoDao;
    private final int PAGE_SIZE = 6;

    @Autowired
    public ProjectInfoImpl(ProjectInfoDao projectInfoDao) {
        this.projectInfoDao = projectInfoDao;

    }

    @Override
    public List<ProjectDescription> getProjectListByPage(int page) {
        return projectInfoDao.findAll(PageRequest.of(page, PAGE_SIZE)).getContent();
    }

    @Override
    public int getProjectPageNum() {
        return (int) projectInfoDao.count() / PAGE_SIZE + 1;
    }
}
