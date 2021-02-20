package com.bigDragon.springAOP.springDaoSimpleDemo.dao;

import com.bigDragon.springAOP.springDaoSimpleDemo.model.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Dao层的实现类
 * @author bigDragon
 * @create 2021-01-28 16:57
 */
public class UserDAOImpl implements UserDAO {
    private DataSource dataSource;//注入DataSource
    public DataSource getDataSource() {
        return dataSource;
    }
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    //向数据表tb_user中添加数据
    public void inserUser(User user) {
        String name = user.getName();//获取姓名
        String age = user.getAge();//获取年龄
        String peopleDes = user.getPeople_des();//获取人物描述
        String sexId = user.getSex_id();//获取性别id
        Connection conn = null;//定义Connection
        Statement stmt = null;//定义Statement
        try {
            conn = dataSource.getConnection();//获取数据库连接
            stmt = conn.createStatement();
            stmt.execute("INSERT INTO user (name,age,people_des,sex_id) "
                    + "VALUES('"+name+"','" + age + "','" + peopleDes + "','" + sexId + "')");//添加数据的SQL语句
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if(stmt != null) {
                try {
                    stmt.close();//关闭Statement对象
                }
                catch(SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn != null) {
                try {
                    conn.close();//关闭数据库连接
                }
                catch(SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
