package com.lagou.test;

import com.lagou.dao.IUserDao;
import com.lagou.io.Resources;
import com.lagou.pojo.User;
import com.lagou.sqlSession.SqlSession;
import com.lagou.sqlSession.SqlSessionFactory;
import com.lagou.sqlSession.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class IPersistenceTest {

    @Test
    public void test() throws Exception {
        InputStream resourceAsSteam = Resources.getResourceAsSteam("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsSteam);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //调用
        User user = new User();
        user.setId(7);
//        user.setId(0);
        user.setUsername("巩俐");

      /*  User user2 = sqlSession.selectOne("user.selectOne", user);

        System.out.println(user2);*/

       /* List<User> users = sqlSession.selectList("user.selectList");
        for (User user1 : users) {
            System.out.println(user1);
        }*/

        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        /*int delete = userDao.delete(user);
        System.out.println("delete操作返回值---"+delete);*/

        /*int insert = userDao.insert(user);
        System.out.println("insert操作返回值---"+insert);*/
        /*int update = userDao.update(user);
        System.out.println("update的值为---"+update);*/


        /*User dao = userDao.findByCondition(user);
        System.out.println(dao);*/



        List<User> all = userDao.findAll();
        for (User user1 : all) {
            System.out.println(user1);
        }
//        userDao.insert(user);

    }

    @Test
    public void test000(){
        System.out.println("fdjfghdsagdsa");
    }

}
