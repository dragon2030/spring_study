package com.bigDragon.hibernateTest.dao;

import com.bigDragon.hibernateTest.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author bigDragon
 * @create 2021-02-03 14:06
 */
//@Repository
public class UserDaoImpl implements UserDao{
   // @Autowired
    private SessionFactory sessionFactory;

    //获取和当前线程绑定的Seesion
    private Session getSession()
    {
        return sessionFactory.getCurrentSession();
    }
    public String findUserById(int id)
    {
        String hql="SELECT name from user where userId=?";
        Query query=getSession().createQuery(hql).setInteger(1, id);
        String str= query.uniqueResult().toString();
        return str;
    }
    public void saveBook(User user)
    {
        getSession().save(user);
    }
}
