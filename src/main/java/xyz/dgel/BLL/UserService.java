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
        return userDao.add(userEntity);
    }

    public List<UserEntity> getAlluser() throws Exception{
        return userDao.getAll();
    }

    //接口6 检查微信信息是否已绑定学号、工号等信息
    public boolean getregisterwxinfo() throws Exception{
        return userDao.getregisterwxinfo(null,null);
    }

    //接口7 绑定学号、工号、姓名等信息
    public boolean registerwxinfo() throws Exception{
        return userDao.registerwxinfo(null);
    }

    //接口8 获取课程列表
    public List getcourselist() throws Exception{
        return userDao.getcourselist(null,null);
    }

    //接口9 获取帖子列表
    public List gettielist() throws Exception{
        return userDao.gettielist(null,null,null);
    }

    //接口10 用户发帖提问
    public boolean creattie() throws Exception{
        return userDao.registerwxinfo(null);
    }

    //接口11 获取帖子列表
    public List getremarklist() throws Exception{
        return userDao.getremarklist(null,null);
    }

    //接口12 发出评论
    public boolean postremark() throws Exception{
        return userDao.postremark(null,null,null);
    }

    //接口13 点赞、收藏、转发
    public boolean interaction() throws Exception{
        return userDao.interaction(null,null,null);
    }
}
