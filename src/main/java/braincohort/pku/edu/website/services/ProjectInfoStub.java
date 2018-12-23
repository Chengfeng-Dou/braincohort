package braincohort.pku.edu.website.services;

import braincohort.pku.edu.website.entity.ProjectDescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("stub")
public class ProjectInfoStub implements ProjectInfoService {

    private final List<ProjectDescription> projectDescriptions;

    @Autowired
    public ProjectInfoStub(List<ProjectDescription> projectDescriptions) {
        this.projectDescriptions = projectDescriptions;
    }


    @Override
    public List<ProjectDescription> getProjectListByPage(int pageNum) {
        int start = 6 * pageNum;
        int end = start + 6;
        if (end > projectDescriptions.size()) {
            end = projectDescriptions.size();
        }
        return projectDescriptions.subList(start, end);
    }

    @Override
    public int getProjectPageNum() {
        return projectDescriptions.size() / 6 + 1;
    }





}
