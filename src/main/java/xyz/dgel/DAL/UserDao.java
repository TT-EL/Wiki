package xyz.dgel.DAL;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xyz.dgel.Model.EF.*;
import xyz.dgel.Model.ViewModel.UserGetCourseListView;
import xyz.dgel.Model.ViewModel.UserGetTieListView;
import xyz.dgel.Model.ViewModel.UserRemarkListView;

import java.util.List;

@Repository
public class UserDao {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    public boolean addUser(UserEntity userEntity) throws Exception
    {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int result = sqlSession.insert("userNamespace.addUser",userEntity);
        sqlSession.commit();
        sqlSession.close();
        return result==1;
    }
    public boolean addStudent(StudentEntity studentEntity) throws Exception
    {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int result = sqlSession.insert("userNamespace.addStudent",studentEntity);
        sqlSession.commit();
        sqlSession.close();
        return result==1;
    }
    public boolean addTeacher(TeacherEntity teacherEntity) throws Exception
    {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int result = sqlSession.insert("userNamespace.addTeacher",teacherEntity);
        sqlSession.commit();
        sqlSession.close();
        return result==1;
    }


    public List<UserEntity> getAllUserByClassId(String class_id) throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession.selectList("userNamespace.getAll",class_id);
    }

    //接口6 检查微信信息是否已绑定学号、工号等信息
    public boolean getRegisterWxInfo(String wx_id){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession.selectOne("userNamespace.getRegisterWxInfo") != null;
    }

    //接口7 绑定学号、工号、姓名等信息
    public boolean registerwxinfo(UserEntity userEntity){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int result = sqlSession.insert("userNamespace.addStudent",userEntity);
        sqlSession.commit();
        sqlSession.close();
        return result==1;
    }

    public boolean registerstudentinfo(StudentEntity studentEntity){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int result = sqlSession.insert("userNamespace.addStudent",studentEntity);
        sqlSession.commit();
        sqlSession.close();
        return result==1;
    }

    public boolean registerteacherinfo(StudentEntity studentEntity){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int result = sqlSession.insert("userNamespace.addStudent",studentEntity);
        sqlSession.commit();
        sqlSession.close();
        return result==1;
    }

    //接口8 获取课程列表（通过student_id获取属于该学生的课程列表）
    public List<UserGetCourseListView> getcourselist(String student_id){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession.selectList("userNamespace.getStudentCourseList",student_id);
    }

    //接口9 获取帖子列表
    public List<UserGetTieListView> gettielist(Integer cotocl_num){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession.selectList("userNamespace.getTieList",cotocl_num);
    }

    //接口10 用户发帖提问--
    public boolean creattie(TieEntity tieEntity){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int result = sqlSession.insert("userNamespace.addTieInfo",tieEntity);
        sqlSession.commit();
        sqlSession.close();
        return result==1;
    }

    //接口11 获取评论列表--
    public List<UserRemarkListView> getremarklist(String t_id){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession.selectList("userNamespace.getRemarkList",t_id);
    }


    //互动基方法
    public boolean creatinteraction(InteractionEntity interactionEntity){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int result = sqlSession.insert("userNamespace.addInteractionBase",interactionEntity);
        sqlSession.commit();
        sqlSession.close();
        return result==1;
    }

    //接口12 发出评论
    public boolean postremark(InterRemarkEntity interRemarkEntity){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int result = sqlSession.insert("userNamespace.addInterRemark",interRemarkEntity);
        sqlSession.commit();
        sqlSession.close();
        return result==1;
    }

    //接口13 点赞、收藏、转发
    public boolean postup(InterUpEntity interUpEntity){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int result = sqlSession.insert("userNamespace.addInterUp",interUpEntity);
        sqlSession.commit();
        sqlSession.close();
        return result==1;
    }
    public boolean postcollection(InterCollectionEntity interCollectionEntity){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int result = sqlSession.insert("userNamespace.addInterCollection",interCollectionEntity);
        sqlSession.commit();
        sqlSession.close();
        return result==1;
    }
    public boolean posttrans(InterTransoutEntity interRemarkEntity){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int result = sqlSession.insert("userNamespace.addInterTransout",interRemarkEntity);
        sqlSession.commit();
        sqlSession.close();
        return result==1;
    }
}
