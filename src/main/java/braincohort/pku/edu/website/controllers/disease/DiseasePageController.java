package braincohort.pku.edu.website.controllers.disease;


import braincohort.pku.edu.website.entity.disease.DataSetDescription;
import braincohort.pku.edu.website.entity.disease.DataSetDetail;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/sleep")
public class DiseasePageController {
    @Resource(name = "dataset_impl")
    private DataSetService setService;

    @RequestMapping("/diseaseResource")
    public String diseaseSource() {
        return "disease/diseaseResource";
    }


    @RequestMapping("/dataSet")
    public String dataSet(int pageNumber, Model model) {
        List<DataSetDescription> list = setService.getDataSetByPage(pageNumber);
        int pageNum = setService.getDataSetPageNum();

        model.addAttribute("list", list);

        model.addAttribute("pageNum", pageNum);
        model.addAttribute("curPage", pageNumber + 1);

        return "disease/dataSet";
    }

    @RequestMapping("/dataDetails")
    public String dataDetails(String link, Model model) throws IOException {
        DataSetDetail dataSetDetail = setService.getDetailByLink(link);
        model.addAttribute("detail", dataSetDetail);
        return "disease/dataDetails";
    }

}
