package xyz.dgel.BLL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.dgel.DAL.ManagerDao;
import xyz.dgel.Model.EF.CourseEntity;
import xyz.dgel.Model.ViewModel.CourseInfoListView;

import java.util.List;

@Service
public class MagenerService {

    @Autowired
    public ManagerDao managerDao;

    //接口1 管理员首页，获取已存在的内容列表
    public List<CourseInfoListView> getManagerList() throws Exception{
        return managerDao.getManageHomePageCourseInfo();
    }

    //接口2 管理员增加课程
    public boolean addcourseinfo() throws Exception{
        return managerDao.addcourseinfo(null);
    }

    //接口3 根据班级名称获取班级ID
    public String getclassid() throws Exception{
        return managerDao.getclassid(null);
    }

    //接口4 根据课程名称获取课程ID
    public String getcourseid() throws Exception{
        return managerDao.getclassid(null);
    }

    //接口5 根据教师姓名获取教师ID
    public String getteacherid() throws Exception{
        return managerDao.getclassid(null);
    }
}
