package xyz.dgel.DAL;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xyz.dgel.Model.EF.*;
import xyz.dgel.Model.ViewModel.ManagerHomepageCourseInfoListView;

import java.util.List;

@Repository
public class ManagerDao extends BaseDao{


    //接口1 管理员首页，获取已存在的内容列表
    public List<ManagerHomepageCourseInfoListView> getManageHomePageCourseInfo() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession.selectList("managerNamespace.getManagerList");
    }

    //接口2 管理员增加排课表
    public boolean addCoursePlanInfo(CotoClEntity cotoClEntity) throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("managerNamespace.addCoursePlanInfo",cotoClEntity);
        sqlSession.commit();
        sqlSession.close();
        return true;
    }

    public boolean addCourseInfo(CourseEntity courseEntity){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("managerNamespace.addCourseInfo",courseEntity);
        sqlSession.commit();
        sqlSession.close();
        return true;
    }

    public List<TeacherEntity> getTeacherList(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession.selectList("managerNamespace.getTeacherList");
    }

    //根据班级号获取班级学生列表
    public List<StudentEntity> getStudentList(String class_id){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession.selectList("managerNamespace.getStudentList",class_id);
    }





}
