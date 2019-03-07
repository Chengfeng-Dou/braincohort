package braincohort.pku.edu.website.controllers;


import braincohort.pku.edu.website.entity.DataSetDescription;
import braincohort.pku.edu.website.entity.DataSetDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/sleep")
public class DiseasePageController {
    private final DataSetService setService;

    @Autowired
    public DiseasePageController(DataSetService setService) {
        this.setService = setService;
    }

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
    public String dataDetails(String title, Model model) {
        DataSetDetail dataSetDetail = setService.getDetailByName(title);
        model.addAttribute("detail", dataSetDetail);
        return "disease/dataDetails";
    }

}
