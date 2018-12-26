package braincohort.pku.edu.website.controllers;

import braincohort.pku.edu.website.entity.ProjectDescription;
import braincohort.pku.edu.website.services.ProjectInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class IndexPageController {

    @Resource(name = "stub")
    private ProjectInfoService service;

    @RequestMapping("/")
    public String index() {
        return "index/index";
    }

    @RequestMapping("/projectList")
    public String showProjectList(int pageNumber, Model model) {
        List<ProjectDescription> descriptionList = service.getProjectListByPage(pageNumber);
        int pageNum = service.getProjectPageNum();

        model.addAttribute("list", descriptionList);

        model.addAttribute("pageNum", pageNum);
        model.addAttribute("curPage", pageNumber + 1);


        return "index/projectList";
    }

    @RequestMapping("/edc")
    public String edcPage() {
        return "index/edc";
    }

    @RequestMapping("/projectDetails")
    public String projectDetails() {
        return "index/projectDetails";
    }

    @RequestMapping("/diseaseList")
    public String diseaseList(){
        return "index/diseaseList";
    }
}
