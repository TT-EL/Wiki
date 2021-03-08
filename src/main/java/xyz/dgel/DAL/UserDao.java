package xyz.dgel.DAL;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xyz.dgel.Model.EF.EmployeeEntity;
import xyz.dgel.Model.EF.UserEntity;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class UserDao {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    public int add(UserEntity userEntity) throws Exception
    {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("userNamespace.add",userEntity);
        sqlSession.commit();
        return 1;
    }
    public List<UserEntity> getAll() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession.selectList("userNamespace.getAll");
    }

    //接口6 检查微信信息是否已绑定学号、工号等信息
    public boolean getregisterwxinfo(String wx_id,String wx_name){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return true;
    }

    //接口7 绑定学号、工号、姓名等信息
    public boolean registerwxinfo(UserEntity userEntity){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return true;
    }

    //接口8 获取课程列表
    public List getcourselist(String student_id, Timestamp current_time){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return null;
    }

    //接口9 获取帖子列表
    public List gettielist(String student_id,String course_id,Timestamp current_time){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return null;
    }

    //接口10 用户发帖提问--
    public boolean creattie(UserEntity userEntity){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return true;
    }

    //接口11 获取帖子列表--
    public List getremarklist(String tie_id,Timestamp current_time){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return null;
    }

    //接口12 发出评论
    public boolean postremark(String tie_id,String user_id,String remark_text){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return true;
    }

    //接口13 点赞、收藏、转发
    public boolean interaction(String tie_id,String user_id,String i_classify){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return true;
    }
}
