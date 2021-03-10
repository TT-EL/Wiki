package xyz.dgel.BLL;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.dgel.DAL.UserDao;
import xyz.dgel.Model.EF.StudentEntity;
import xyz.dgel.Model.EF.TeacherEntity;
import xyz.dgel.Model.EF.TieEntity;
import xyz.dgel.Model.EF.UserEntity;

import java.util.List;

@Service
public class UserService {

    @Autowired
    public UserDao userDao;



    public boolean addStudent(StudentEntity studentEntity) throws Exception{
        try{
            String studentId = studentEntity.getUserId();
            studentEntity.setStudentId(studentId);
            studentEntity.setWxStatus((byte)1);
            System.out.println(JSON.toJSONString(studentEntity));
            userDao.addUser(studentEntity);
            userDao.addStudent(studentEntity);
        }catch (Exception e){
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

    public List<UserEntity> getAllUserByClassId() throws Exception{
        return userDao.getAllUserByClassId(null);
    }

    //接口6 检查微信信息是否已绑定学号、工号等信息
    public boolean getregisterwxinfo(String wx_id) throws Exception{
        return userDao.getRegisterWxInfo(wx_id);
    }

    //接口7 绑定学号、工号、姓名等信息
    public boolean registerwxinfo(UserEntity userEntity) throws Exception{
        return userDao.registerwxinfo(userEntity);
    }

    //接口8 获取课程列表
    public List getcourselist(String student_id) throws Exception{
        return userDao.getcourselist(student_id);
    }

    //接口9 获取帖子列表
    public List gettielist(Integer cotocl_num) throws Exception{
        return userDao.gettielist(cotocl_num);
    }

    //接口10 用户发帖提问
    public boolean creattie(TieEntity tieEntity) throws Exception{
        return userDao.creattie(tieEntity);
    }

    //接口11 获取帖子列表
    public List getremarklist() throws Exception{
        return userDao.getremarklist(null);
    }

    //接口12 发出评论
    public boolean postremark() throws Exception{
        return userDao.postremark(null);
    }

    //接口13 点赞、收藏、转发
    public boolean postup() throws Exception{
        return userDao.postup(null);
    }
    public boolean postcollection() throws Exception{
        return userDao.postcollection(null);
    }
    public boolean posttrans() throws Exception{
        return userDao.posttrans(null);
    }

}
