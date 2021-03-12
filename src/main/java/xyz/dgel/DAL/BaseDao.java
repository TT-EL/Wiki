package xyz.dgel.DAL;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xyz.dgel.Model.EF.ClassEntity;
import xyz.dgel.Model.EF.StudentEntity;
import xyz.dgel.Model.EF.TeacherEntity;
import xyz.dgel.Model.EF.UserEntity;

import java.util.List;

@Repository
public class BaseDao {

    @Autowired
    public SqlSessionFactory sqlSessionFactory;


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

    //接口3 根据班级名称获取班级ID
    public String getClassIdByClassName(String class_name){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession.selectOne("managerNamespace.getClassIdByClassName",class_name);
    }

    public String getClassIdByClassId(String class_name){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession.selectOne("managerNamespace.getClassIdByClassId",class_name);
    }

    //接口4 根据课程名称获取课程ID
    public String getCourseId(String course_name){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession.selectOne("managerNamespace.getCourseId",course_name);
    }

    //接口5 根据教师姓名获取教师ID
    public String getTeacherId(String teacher_name){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession.selectOne("managerNamespace.getTeacherId",teacher_name);
    }


    public List<ClassEntity> getClassList(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession.selectList("managerNamespace.getClassList");
    }


}
