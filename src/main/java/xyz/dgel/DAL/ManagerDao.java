package xyz.dgel.DAL;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xyz.dgel.Model.ViewModel.CourseInfoListView;

import java.util.List;

@Repository
public class ManagerDao {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    public List<CourseInfoListView> getManageHomePageCourseInfo() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession.selectList("managerNamespace.getManagerList");
    }
}
