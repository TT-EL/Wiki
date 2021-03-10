package xyz.dgel.BLL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.dgel.DAL.ManagerDao;
import xyz.dgel.Model.EF.*;
import xyz.dgel.Model.ViewModel.ManagerHomepageCourseInfoListView;

import java.util.List;

@Service("MaganerService")
public class MaganerService {

    @Autowired
    public ManagerDao managerDao;

    //接口1 管理员首页，获取已存在的内容列表
    public List<ManagerHomepageCourseInfoListView> getManagerList() throws Exception{
        return managerDao.getManageHomePageCourseInfo();
    }

    //接口2 管理员增加课程
    public boolean addcourseplaninfo(CotoClEntity cotoClEntity) throws Exception{
        return managerDao.addCoursePlanInfo(cotoClEntity);
    }

    //接口3 根据班级名称获取班级ID
    public String getclassid(String class_name) throws Exception{
        return managerDao.getClassId(class_name);
    }

    //接口4 根据课程名称获取课程ID
    public String getcourseid(String course_name) throws Exception{
        return managerDao.getCourseId(course_name);
    }

    //接口5 根据教师姓名获取教师ID
    public String getteacherid(String teacher_name) throws Exception{
        return managerDao.getTeacherId(teacher_name);
    }

    public List<TeacherEntity> getteacherlist() throws Exception{
        return managerDao.getTeacherList();
    }

    public List<ClassEntity> getclasslist() throws Exception{
        return managerDao.getClassList();
    }

    public boolean addcourseinfo(CourseEntity courseEntity) throws Exception{
        return managerDao.addCourseInfo(courseEntity);
    }

    public List<StudentEntity> getstudentlist(String class_id){
        return managerDao.getStudentList(class_id);
    }
}
