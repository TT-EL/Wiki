package xyz.dgel.BLL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.dgel.DAL.ManagerDao;
import xyz.dgel.Model.EF.*;
import xyz.dgel.Model.ViewModel.ManagerAddCoursePlan;
import xyz.dgel.Model.ViewModel.ManagerHomepageCourseInfoListView;

import java.util.List;

@Service("MaganerService")
public class MaganerService extends BaseService{



    //接口1 管理员首页，获取已存在的内容列表
    public List<ManagerHomepageCourseInfoListView> getManagerList() throws Exception{
        return managerDao.getManageHomePageCourseInfo();
    }

    //接口2 管理员增加排课
    public boolean addcourseplaninfo(ManagerAddCoursePlan managerAddCoursePlan) throws Exception{
        return managerDao.addCoursePlanInfo(managerAddCoursePlan);
    }

//    public boolean addcourseplantimeinfo(ManagerAddCoursePlan managerAddCoursePlan) throws Exception{
//        return managerDao.addCoursePlanTimeInfo(managerAddCoursePlan);
//    }

    //接口2 管理员增加单课程信息
    public boolean addcourseinfo(CourseEntity courseEntity) throws Exception{
        return managerDao.addCourseInfo(courseEntity);
    }

    //获取课程详情
    public List<CotoClEntity> getCotoclDetial(String cotocl_num) throws Exception{
        return managerDao.getCotoclDetial(cotocl_num);
    }

    public boolean addclassinfo(ClassEntity classEntity) throws Exception{
        return managerDao.addClassInfo(classEntity);
    }

    public List<TeacherEntity> getteacherlist() throws Exception{
        return managerDao.getTeacherList();
    }

    public List<StudentEntity> getstudentlist(String class_id){
        return managerDao.getStudentList(class_id);
    }
}
