package braincohort.pku.edu.website.service.projectinfo;

import braincohort.pku.edu.website.controllers.ProjectDetailsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectInfoImplTests {
    @Autowired
    public ProjectDetailsService service;

    @Test
    public void testLoadMarkDown(){
        try {
            String content = service.getMarkDownInfo("DONATIONS.md");
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
