package com.bigDragon.springAOP.declarativeTransaction;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * @author bigDragon
 * @create 2021-02-01 21:07
 */
public class AddDAO extends JdbcDaoSupport {
    //添加用户的方法
    public void addUser(User user){
        //执行添加方法的sql语句
        String sql="insert into user (name,age,sex_id) values('" +
                user.getName() + "','" + user.getAge()+ "','" + user.getSex_id()+ "')";
        //执行两次添加方法
        getJdbcTemplate().execute(sql);
        int a=0;//制造异常测试事务是否配置成功
        a=9/a;
        getJdbcTemplate().execute(sql);
    }
}