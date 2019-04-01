package braincohort.pku.edu.website.services.projectinfo;

import braincohort.pku.edu.website.entity.index.ProjectContent;
import braincohort.pku.edu.website.entity.index.ProjectContentId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjectContentDao extends JpaRepository<ProjectContent, ProjectContentId> {

    List<ProjectContent> findAllByBelongOrderByShowOrderDesc(@Param(value = "belong") String belong);
}
