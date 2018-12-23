package braincohort.pku.edu.website.services;

import braincohort.pku.edu.website.entity.ProjectDescription;

import java.util.List;

public interface ProjectInfoService {

    /**
     *  用于获取每一页的数据
     * @param pageNum 页码，从 0 开始
     * @return 项目的简述
     */
    List<ProjectDescription> getProjectListByPage(int pageNum);

    /**
     * 获取一共有多少页
     * @return 页数 = 项目数 / 6 + 1
     */
    int getProjectPageNum();
}
