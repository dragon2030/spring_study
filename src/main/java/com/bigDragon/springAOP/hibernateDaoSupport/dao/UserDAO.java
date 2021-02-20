package com.bigDragon.springAOP.hibernateDaoSupport.dao;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import com.bigDragon.springAOP.hibernateDaoSupport.user.User;

/**
 * @author bigDragon
 * @create 2021-02-02 16:57
 */
public class UserDAO extends HibernateDaoSupport {
    //保存用户的方法
    public void insert(User user){
        this.getHibernateTemplate().save(user);
    }
}
