package braincohort.pku.edu.website;

import braincohort.pku.edu.website.entity.ProjectDescription;
import braincohort.pku.edu.website.services.ProjectInfoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@SpringBootApplication
@Controller
public class WebsiteApplication {
    @Resource(name = "stub")
    private ProjectInfoService service;

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/projectList")
    public String showProjectList(int pageNumber, Model model){
        List<ProjectDescription> descriptionList = service.getProjectListByPage(pageNumber);
        int pageNum = service.getProjectPageNum();

        model.addAttribute("list", descriptionList);

        model.addAttribute("pageNum", pageNum);
        model.addAttribute("curPage", pageNumber + 1);


        return "projectList";
    }


    @RequestMapping("/projectDetails")
    public String projectDetails(){
        return "projectDetails";
    }



    @RequestMapping("/edc")
    public String edcPage(){
        return "edc";
    }

    public static void main(String[] args) {
        SpringApplication.run(WebsiteApplication.class, args);
    }

}

