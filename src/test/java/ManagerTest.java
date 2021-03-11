import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xyz.dgel.DAL.ManagerDao;
import xyz.dgel.Model.EF.CotoClEntity;
import xyz.dgel.Model.EF.StudentEntity;
import xyz.dgel.Model.ViewModel.ManagerHomepageCourseInfoListView;

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
        List<ManagerHomepageCourseInfoListView> listViews = managerDao.getManageHomePageCourseInfo();
        String s = JSON.toJSONString(listViews);
        System.out.println(s);


    }
    @Test
    public void getStudentList() throws Exception{
        init();

        ManagerDao managerDao = (ManagerDao)applicationContext.getBean("managerDao");
        List<StudentEntity> listViews = managerDao.getStudentList("1111");
        String s = JSON.toJSONString(listViews);
        System.out.println(s);


    }

    @Test
    public void insert() throws Exception{
        CotoClEntity cotoClEntity = new CotoClEntity();
        cotoClEntity.setClassId("1111");
        cotoClEntity.setCourseId("2222");
        cotoClEntity.setTeacherId("3333");

        init();
        ManagerDao managerDao = (ManagerDao)applicationContext.getBean("managerDao");
        managerDao.addCoursePlanInfo(cotoClEntity);
    }

    @Test
    public void getClassIdByName() throws Exception{

        init();
        ManagerDao managerDao = (ManagerDao)applicationContext.getBean("managerDao");
        System.out.println(managerDao.getClassId("软件一班"));
    }
}
