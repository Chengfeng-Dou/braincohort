package braincohort.pku.edu.website.services.projectinfo;

import braincohort.pku.edu.website.entity.ProjectDescription;
import braincohort.pku.edu.website.services.DataManager;
import braincohort.pku.edu.website.services.ProjectInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("stub")
public class ProjectInfoStub implements ProjectInfoService {

    private DataManager<ProjectDescription> manager;

    @Autowired
    public ProjectInfoStub(List<ProjectDescription> projectDescriptions) {
        manager = new DataManager<>(projectDescriptions);
    }


    @Override
    public List<ProjectDescription> getProjectListByPage(int pageNum) {
        return manager.getDataByPage(pageNum);
    }

    @Override
    public int getProjectPageNum() {
        return manager.getPageNum();
    }





}
