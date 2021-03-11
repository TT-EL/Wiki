package xyz.dgel.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.dgel.BLL.MaganerService;
import xyz.dgel.Model.EF.*;
import xyz.dgel.Model.ViewModel.ManagerHomepageCourseInfoListView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@Controller
@RequestMapping(value = "/Manager",method = {RequestMethod.GET,RequestMethod.POST})
public class ManagerController extends BaseController{



    @RequestMapping(value = "/getHomePage",method = {RequestMethod.GET})
    @ResponseBody
    public void getHomePageList(HttpServletResponse response) throws Exception{
        List<ManagerHomepageCourseInfoListView> listViews = managerService.getManagerList();
        //String listData = JSON.toJSONString(listViews);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",0);
        jsonObject.put("msg","");
        jsonObject.put("count",1000);
        jsonObject.put("list",listViews);
        BasicJsonResponse(response,jsonObject.toJSONString());
    }

    @RequestMapping(value = "/getStudentList",method = RequestMethod.GET)
    public void getStudentList(HttpServletResponse response,@RequestParam(value = "class_id")String class_id) throws Exception{
        List<StudentEntity> list = managerService.getstudentlist(class_id);
        BasicJsonResponse(response,JSON.toJSONString(list));
    }


    //region 管理员增加排课信息
    @RequestMapping(value = "/addCoursePlanInfo",method = {RequestMethod.POST})
    public void addCoursePlanInfo(HttpServletResponse response, CotoClEntity cotoClEntity) throws Exception{
        JSONObject o = new JSONObject();
        boolean result = managerService.addcourseplaninfo(cotoClEntity);
        if (result){
            o.put("error_code",1);
        }
        else{
            o.put("error_code",0);
        }
        BasicJsonResponse(response,o.toJSONString());

    }

    //ajax响应获取列表

    @RequestMapping(value = "/getTeacherList",method = {RequestMethod.GET})
    public void getTeacherList(HttpServletResponse response) throws Exception{

        List<TeacherEntity> list = managerService.getteacherlist();
        BasicJsonResponse(response,JSON.toJSONString(list));

    }

    @RequestMapping(value = "/getClassList",method = {RequestMethod.GET})
    public void getClassList(HttpServletResponse response) throws Exception{

        List<ClassEntity> list = managerService.getclasslist();
        BasicJsonResponse(response,JSON.toJSONString(list));

    }

    //ajax获取通过名字搜索的老师信息
    //ajax获取通过搜索班级名称的班级信息
    @RequestMapping(value = "/searchTeacher",method = {RequestMethod.GET})
    public void getTeacherInfo(HttpServletResponse response,@RequestParam("teacher_name") String teacher_name) throws Exception{
        JSONObject o = new JSONObject();

        String teacher_id = managerService.getteacherid(teacher_name);
        if (teacher_id != null){
            o.put("error_code",1);
            o.put("teacher_id",teacher_id);
            o.put("teacher_name",teacher_name);
        }
        else{
            o.put("error_code",0);
        }
        BasicJsonResponse(response,o.toJSONString());
    }

    @RequestMapping(value = "/searchClass",method = {RequestMethod.GET})
    public void getClassInfo(HttpServletResponse response,@RequestParam("class_name") String class_name) throws Exception{
        JSONObject o = new JSONObject();

        String class_id = managerService.getclassid(class_name);
        if (class_id != null){
            o.put("error_code",1);
            o.put("class_id",class_id);
            o.put("class_name",class_name);
        }
        else{
            o.put("error_code",0);
        }
        BasicJsonResponse(response,o.toJSONString());
    }
    //endregion


    @RequestMapping(value = "addCourseInfo",method = RequestMethod.POST)
    public void addCourseInfo(HttpServletResponse response, CourseEntity courseEntity) throws Exception{
        JSONObject o = new JSONObject();
        try{
            managerService.addcourseinfo(courseEntity);
        }catch (Exception e){
            o.put("error_code",0);
        }
        o.put("error_code",1);
        BasicJsonResponse(response,o.toJSONString());
    }

}
