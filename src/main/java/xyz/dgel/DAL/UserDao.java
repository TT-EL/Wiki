package xyz.dgel.DAL;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xyz.dgel.Model.EF.EmployeeEntity;
import xyz.dgel.Model.EF.UserEntity;

import java.util.List;

@Repository
public class UserDao {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    public int add(UserEntity userEntity) throws Exception
    {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("userNamespace.add",userEntity);
        sqlSession.commit();
        return 1;
    }
    public List<UserEntity> getAll() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession.selectList("userNamespace.getAll");
    }
}
