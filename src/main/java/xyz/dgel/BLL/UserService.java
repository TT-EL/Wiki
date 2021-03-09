package xyz.dgel.BLL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.dgel.DAL.UserDao;
import xyz.dgel.Model.EF.UserEntity;

import java.util.List;

@Service
public class UserService {

    @Autowired
    public UserDao userDao;


    @Transactional
    public int addUser(UserEntity userEntity) throws Exception{
        return userDao.addUser(userEntity);
    }

    public List<UserEntity> getAlluser() throws Exception{
        return userDao.getAllUser();
    }

    //接口6 检查微信信息是否已绑定学号、工号等信息
    public boolean getregisterwxinfo() throws Exception{
        return userDao.getRegisterWxInfo(null);
    }

    //接口7 绑定学号、工号、姓名等信息
    public boolean registerwxinfo() throws Exception{
        return userDao.registerwxinfo(null);
    }

    //接口8 获取课程列表
    public List getcourselist() throws Exception{
        return userDao.getcourselist(null);
    }

    //接口9 获取帖子列表
    public List gettielist() throws Exception{
        return userDao.gettielist(null);
    }

    //接口10 用户发帖提问
    public boolean creattie() throws Exception{
        return userDao.creattie(null);
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
