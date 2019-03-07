package braincohort.pku.edu.website.controllers;

import braincohort.pku.edu.website.entity.ProjectContent;
import braincohort.pku.edu.website.entity.ProjectDescription;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@Controller
public class IndexPageController {

    @Resource(name = "project_info_impl")
    private ProjectInfoService infoService;

    @Resource(name = "project_details_impl")
    private ProjectDetailsService detailsService;

    @RequestMapping("/")
    public String index() {
        return "index/index";
    }

    @RequestMapping("/projectList")
    public String showProjectList(int pageNumber, Model model) {
        List<ProjectDescription> descriptionList = infoService.getProjectListByPage(pageNumber);
        int pageNum = infoService.getProjectPageNum();

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
    public String projectDetails(String link, Model model) {
        List<ProjectContent> contents = detailsService.getProjectContent(link);
        model.addAttribute("contents", contents);
        model.addAttribute("hasFirst", "no");
        if(!contents.isEmpty()){
            ProjectContent content = contents.get(0);
            model.addAttribute("firstShow", content.markdown);
            model.addAttribute("hasFirst", "yes");
        }
        return "index/projectDetails";
    }

    @ResponseBody
    @RequestMapping("/markdown")
    public Markdown getMarkdown(String md) throws IOException {
        String ret = detailsService.getMarkDownInfo(md);
        return new Markdown(ret);
    }

    @RequestMapping("/diseaseList")
    public String diseaseList(){
        return "index/diseaseList";
    }

    private class Markdown{
        String content;

        Markdown(String content) {
            this.content = content;
        }
    }
}
