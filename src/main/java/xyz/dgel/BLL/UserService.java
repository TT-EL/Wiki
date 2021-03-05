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
}
