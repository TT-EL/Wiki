package xyz.dgel.BLL;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.dgel.DAL.ManagerDao;
import xyz.dgel.DAL.UserDao;
import xyz.dgel.Model.EF.ClassEntity;
import xyz.dgel.Model.EF.StudentEntity;
import xyz.dgel.Model.EF.TeacherEntity;

import java.util.List;

@Service
public class BaseService {

    @Autowired
    public UserDao userDao;

    @Autowired
    public ManagerDao managerDao;

    public boolean addStudent(StudentEntity studentEntity) throws Exception{
        try{
            String studentId = studentEntity.getUserId();
            studentEntity.setStudentId(studentId);
            studentEntity.setWxStatus((byte)1);
            //System.out.println(JSON.toJSONString(studentEntity));
            userDao.addUser(studentEntity);
            userDao.addStudent(studentEntity);
        }catch (Exception e){
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean addTeacher(TeacherEntity teacherEntity) throws Exception{
        try{
            teacherEntity.setPower((byte)1);
            userDao.addTeacher(teacherEntity);
            userDao.addUser(teacherEntity);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    //接口3 根据班级名称获取班级ID
    public String getclassidbyclassname(String class_name) throws Exception{
        return managerDao.getClassIdByClassName(class_name);
    }

    public String getclassidbyclassid(String class_id) throws Exception{
        return managerDao.getClassIdByClassId(class_id);
    }


    //接口4 根据课程名称获取课程ID
    public String getcourseid(String course_name) throws Exception{
        return managerDao.getCourseId(course_name);
    }

    //接口5 根据教师姓名获取教师ID
    public String getteacherid(String teacher_name) throws Exception{
        return managerDao.getTeacherId(teacher_name);
    }





    public List<ClassEntity> getclasslist() throws Exception{
        return managerDao.getClassList();
    }
}
