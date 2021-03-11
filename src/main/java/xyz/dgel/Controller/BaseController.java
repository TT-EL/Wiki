package xyz.dgel.Controller;

import com.alibaba.fastjson.JSON;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import xyz.dgel.BLL.MaganerService;
import xyz.dgel.BLL.UserService;
import xyz.dgel.Model.EF.ClassEntity;
import xyz.dgel.Model.ViewModel.UserRemarkListView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@CrossOrigin(origins = "*")
@Controller
public class BaseController {

    @Autowired
    public UserService userService;

    @Autowired
    public MaganerService managerService;

    public void BasicJsonResponse(HttpServletResponse resp,String json) throws IOException {
        PrintWriter writer = resp.getWriter();
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=UTF-8");
        writer.write(json);
    }

    @RequestMapping(value = "/getClassList",method = RequestMethod.GET)
    public void getClassList(HttpServletResponse response) throws Exception{
        System.out.println("进入GetClassList方法");
        List<ClassEntity> list = userService.getclasslist();
        BasicJsonResponse(response, JSON.toJSONString(list));
    }
}
