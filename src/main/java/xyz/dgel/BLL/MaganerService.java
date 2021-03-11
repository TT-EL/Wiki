package xyz.dgel.BLL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.dgel.DAL.ManagerDao;
import xyz.dgel.Model.EF.*;
import xyz.dgel.Model.ViewModel.ManagerHomepageCourseInfoListView;

import java.util.List;

@Service("MaganerService")
public class MaganerService extends BaseService{



    //接口1 管理员首页，获取已存在的内容列表
    public List<ManagerHomepageCourseInfoListView> getManagerList() throws Exception{
        return managerDao.getManageHomePageCourseInfo();
    }

    //接口2 管理员增加排课
    public boolean addcourseplaninfo(CotoClEntity cotoClEntity) throws Exception{
        return managerDao.addCoursePlanInfo(cotoClEntity);
    }

    //接口2 管理员增加单课程信息
    public boolean addcourseinfo(CourseEntity courseEntity) throws Exception{
        return managerDao.addCourseInfo(courseEntity);
    }

    public List<TeacherEntity> getteacherlist() throws Exception{
        return managerDao.getTeacherList();
    }

    public List<StudentEntity> getstudentlist(String class_id){
        return managerDao.getStudentList(class_id);
    }
}
