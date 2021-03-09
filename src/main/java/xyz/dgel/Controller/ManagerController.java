package xyz.dgel.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.dgel.BLL.MaganerService;
import xyz.dgel.Model.ViewModel.ManagerHomepageCourseInfoListView;

import java.util.List;


@Controller
@RequestMapping("/Manager")
public class ManagerController {

    @Autowired
    public MaganerService managerService;


    @RequestMapping("/getHomePage")
    @ResponseBody
    public List<ManagerHomepageCourseInfoListView> getHomePageList() throws Exception{

        return managerService.getManagerList();
    }
}
