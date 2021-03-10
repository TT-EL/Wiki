import com.alibaba.fastjson.JSON;
import org.junit.Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xyz.dgel.DAL.ManagerDao;
import xyz.dgel.DAL.UserDao;
import xyz.dgel.Model.EF.StudentEntity;
import xyz.dgel.Model.EF.UserEntity;
import xyz.dgel.Model.ViewModel.ManagerHomepageCourseInfoListView;
import xyz.dgel.Model.ViewModel.UserGetCourseListView;

import java.util.List;

public class UserTest {



    ApplicationContext applicationContext;
    public void init()
    {
        //加载Spring配置文件
        applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
    }

    @Test
    public void adduser() throws Exception{
        StudentEntity userEntity = new StudentEntity();
        userEntity.setUserId("12345df4567");
        userEntity.setWxId("12dfdg2g");
        userEntity.setWxUsername("中文");
        userEntity.setWxStatus((byte)1);
        userEntity.setWxImage("https://ssss");
        userEntity.setPower((byte)0);
        userEntity.setName("中文");
        userEntity.setRegTime(null);

        userEntity.setStudentId("12345df4567");
        userEntity.setClassId("1111");
        userEntity.setEnrolTime(2018);

        init();
        UserDao userDao = (UserDao)applicationContext.getBean("userDao");
        userDao.addUser(userEntity);
        userDao.addStudent(userEntity);
    }

    @Test
    public void getList() throws Exception{
        init();
        UserDao userDao = (UserDao)applicationContext.getBean("userDao");
        List<UserGetCourseListView> listViews = userDao.getcourselist("123456");
        String s = JSON.toJSONString(listViews);
        System.out.println(s);


    }


}
