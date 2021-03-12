package xyz.dgel.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xyz.dgel.Model.EF.*;
import xyz.dgel.Model.ViewModel.ManagerAddCoursePlan;
import xyz.dgel.Model.ViewModel.ManagerHomepageCourseInfoListView;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@CrossOrigin(value = "*")
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
    public void addCoursePlanInfo(HttpServletResponse response, ManagerAddCoursePlan managerAddCoursePlan) throws Exception{
        JSONObject o = new JSONObject();

        boolean result = managerService.addcourseplaninfo(managerAddCoursePlan);

        if (result){
            o.put("code",1);
        }
        else{
            o.put("code",0);
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

    //根据班级名称获取班级信息
    @RequestMapping(value = "/searchClassByClassName",method = {RequestMethod.GET})
    public void getClassInfoByClassName(HttpServletResponse response,@RequestParam("class_name") String class_name) throws Exception{
        JSONObject o = new JSONObject();

        String class_id = managerService.getclassidbyclassname(class_name);
        if (class_id != null){
            o.put("code",1);
            o.put("class_id",class_id);
            o.put("class_name",class_name);
        }
        else{
            o.put("code",0);
        }
        BasicJsonResponse(response,o.toJSONString());
    }

    //根据班级ID搜索班级信息
    @RequestMapping(value = "/searchClassByClassId",method = {RequestMethod.GET})
    public void getClassInfoByClassId(HttpServletResponse response,@RequestParam("class_id") String class_id) throws Exception{
        JSONObject o = new JSONObject();

        String result = managerService.getclassidbyclassid(class_id);
        if (result != null){
            o.put("code",1);
        }
        else{
            o.put("code",0);
        }
        BasicJsonResponse(response,o.toJSONString());
    }

    //根据课程名称搜索课程信息
    @RequestMapping(value = "/searchCourseInfoByCourseName",method = {RequestMethod.GET})
    public void searchCourseInfoByCourseName(HttpServletResponse response,@RequestParam("course_name") String course_name) throws Exception{
        JSONObject o = new JSONObject();

        String course_id = managerService.getcourseid(course_name);
        if (course_id != null){
            o.put("code",1);
            o.put("course_id",course_id);

        }
        else{
            o.put("code",0);
        }
        BasicJsonResponse(response,o.toJSONString());
    }

    //根据教师姓名搜索教师信息
    @RequestMapping(value = "/searchTeacherInfoByTeacherName",method = {RequestMethod.GET})
    public void searchTeacherInfoByTeacherName(HttpServletResponse response,@RequestParam("teacher_name") String teacher_name) throws Exception{
        JSONObject o = new JSONObject();

        String teacher_id = managerService.getteacherid(teacher_name);
        if (teacher_id != null){
            o.put("code",1);
            o.put("teacher_id",teacher_id);
        }
        else{
            o.put("code",0);
        }
        BasicJsonResponse(response,o.toJSONString());
    }
    //endregion


    //增加课程信息
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

    //增加班级信息
    @RequestMapping(value = "addClassInfo",method = RequestMethod.POST)
    public void addClassInfo(HttpServletResponse response, ClassEntity classEntity) throws Exception{
        JSONObject o = new JSONObject();
        try{
            managerService.addclassinfo(classEntity);
        }catch (Exception e){
            o.put("error_code",0);
        }
        o.put("error_code",1);
        BasicJsonResponse(response,o.toJSONString());
    }

}
