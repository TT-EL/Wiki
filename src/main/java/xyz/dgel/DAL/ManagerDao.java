package xyz.dgel.DAL;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xyz.dgel.Model.EF.CourseEntity;
import xyz.dgel.Model.ViewModel.CourseInfoListView;

import java.util.List;

@Repository
public class ManagerDao {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    //接口1 管理员首页，获取已存在的内容列表
    public List<CourseInfoListView> getManageHomePageCourseInfo() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession.selectList("managerNamespace.getManagerList");
    }

    //接口2 管理员增加课程
    public boolean addcourseinfo(CourseEntity courseEntity){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("managerNamespace.addCourseInfo");
        sqlSession.commit();
        sqlSession.close();
        return true;
    }

    //接口3 根据班级名称获取班级ID
    public String getclassid(String class_name){
        SqlSession sqlSession = sqlSessionFactory.openSession();


        return null;
    }

    //接口4 根据课程名称获取课程ID
    public String getcourseid(String course_name){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return null;
    }

    //接口5 根据教师姓名获取教师ID
    public String getteacherid(String teacher_name){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return null;
    }

}
