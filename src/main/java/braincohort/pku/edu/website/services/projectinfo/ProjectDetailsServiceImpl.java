package braincohort.pku.edu.website.services.projectinfo;

import braincohort.pku.edu.website.controllers.ProjectDetailsService;
import braincohort.pku.edu.website.entity.ProjectContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;

@Service(value = "project_details_impl")
public class ProjectDetailsServiceImpl implements ProjectDetailsService {
    private final ProjectContentDao projectContentDao;
    @Value("${markdown.basePackage}")
    private String markdownBase;

    @Autowired
    public ProjectDetailsServiceImpl(ProjectContentDao projectContentDao) {
        this.projectContentDao = projectContentDao;
    }

    @Override
    public List<ProjectContent> getProjectContent(String link) {
        return projectContentDao.findAllByBelongOrderByShowOrderDesc(link);
    }

    @Override
    @Cacheable(value = "markdown")
    public String getMarkDownInfo(String markdown) throws IOException {
        System.out.println(markdownBase + markdown);
        File file = new File(markdownBase + markdown);
        if (file.exists()) {
            StringBuilder builder = new StringBuilder();
            BufferedReader reader = new BufferedReader(new FileReader(file));
            try {
                String line;
                while ((line = reader.readLine()) != null) {
                    builder.append(line).append("\n");
                }

            } finally {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }

            return builder.toString();
        } else {
            throw new FileNotFoundException("file " + markdown + " is not exists!");
        }
    }
}
