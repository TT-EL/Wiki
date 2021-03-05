import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xyz.dgel.DAL.UserDao;
import xyz.dgel.Model.EF.UserEntity;

public class UserTest {

    ApplicationContext applicationContext;
    public void init()
    {
        //加载Spring配置文件
        applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
    }

    @Test
    public void adduser() throws Exception{
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId("123456");
        userEntity.setWxId("12dfdg2g");
        userEntity.setWxUsername("Tom");
        userEntity.setWxStatus((byte)1);
        userEntity.setWxImage("https://ssss");
        userEntity.setPower((byte)1);
        userEntity.setWxUsername("slfklsfk");
        userEntity.setRegTime(null);

        init();
        UserDao userDao = (UserDao)applicationContext.getBean("userDao");
        userDao.add(userEntity);
    }
}
