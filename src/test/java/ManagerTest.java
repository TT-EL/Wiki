import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xyz.dgel.DAL.ManagerDao;
import xyz.dgel.Model.ViewModel.CourseInfoListView;

import java.util.List;

public class ManagerTest {
    ApplicationContext applicationContext;
    public void init()
    {
        //加载Spring配置文件
        applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
    }

    @Test
    public void getList() throws Exception{
        init();

        ManagerDao managerDao = (ManagerDao)applicationContext.getBean("managerDao");
        List<CourseInfoListView> listViews = managerDao.getManageHomePageCourseInfo();
        String s = JSON.toJSONString(listViews);
        System.out.println(s);


    }
}
