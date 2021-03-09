package xyz.dgel.DAL;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xyz.dgel.Model.EF.CotoClEntity;
import xyz.dgel.Model.ViewModel.ManagerHomepageCourseInfoListView;

import java.util.List;

@Repository
public class ManagerDao {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    //接口1 管理员首页，获取已存在的内容列表
    public List<ManagerHomepageCourseInfoListView> getManageHomePageCourseInfo() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession.selectList("managerNamespace.getManagerList");
    }

    //接口2 管理员增加课程
    public boolean addcourseinfo(CotoClEntity cotoClEntity) throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("managerNamespace.addCourseInfo",cotoClEntity);
        sqlSession.commit();
        sqlSession.close();
        return true;
    }

    //接口3 根据班级名称获取班级ID
    public String getclassid(String class_name){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession.selectOne("managerNamespace.getClassId",class_name);
    }

    //接口4 根据课程名称获取课程ID
    public String getcourseid(String course_name){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession.selectOne("managerNamespace.getCourseId",course_name);
    }

    //接口5 根据教师姓名获取教师ID
    public String getteacherid(String teacher_name){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession.selectOne("managerNamespace.getTeacherId",teacher_name);
    }

}
