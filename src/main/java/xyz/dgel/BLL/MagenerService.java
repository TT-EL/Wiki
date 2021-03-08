package xyz.dgel.BLL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.dgel.DAL.ManagerDao;
import xyz.dgel.Model.ViewModel.CourseInfoListView;

import java.util.List;

@Service
public class MagenerService {

    @Autowired
    public ManagerDao managerDao;

    public List<CourseInfoListView> getManagerList() throws Exception{
        return managerDao.getManageHomePageCourseInfo();
    }

}
