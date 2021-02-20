package com.bigDragon.springAOP.programmeTransaction;

/**
 * @author bigDragon
 * @create 2021-02-01 20:28
 */
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

public class TransactionExample {
    DataSource dataSource;//注入数据源
    PlatformTransactionManager transactionManager;//注入事务管理器
    TransactionTemplate transactionTemplate;//注入TransactionTemplate模板
    public DataSource getDataSource() {
        return dataSource;
    }
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    public PlatformTransactionManager getTransactionManager() {
        return transactionManager;
    }
    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }
    public TransactionTemplate getTransactionTemplate() {
        return transactionTemplate;
    }
    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }
    public void transactionOperation() {
        transactionTemplate.execute(new TransactionCallback() {
            public Object doInTransaction(TransactionStatus status) {
                Connection conn = DataSourceUtils.getConnection(dataSource);//获得数据库连接
                try {
                    Statement stmt = conn.createStatement();
                    //执行两次添加方法
                    stmt.execute("insert into user(name,age,sex_id) values('小强','26','1')");
                    int a=0;//制造异常测试事务是否配置成功
                    //a=9/a;
                    stmt.execute("insert into user(name,age,sex_id) values('小红','22','2')");
                    System.out.println("操作执行成功！");
                } catch (Exception e) {
                    transactionManager.rollback(status);//事务回滚
                    System.out.println("操作执行失败，事务回滚！");
                    System.out.println("原因："+e.getMessage());
                    e.printStackTrace();
                }
                return null;
            }
        });
    }
}
