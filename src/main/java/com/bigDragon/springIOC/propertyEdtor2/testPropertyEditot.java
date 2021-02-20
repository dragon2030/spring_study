package com.bigDragon.springIOC.propertyEdtor2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试类
 * @author bigDragon
 * @create 2021-01-18 16:32
 */
public class testPropertyEditot  {
    @Test
    public void testPrintProperty() {
        System.out.println("测试springPropertyUtil  start");

        // 可以同时配置多个xml配置文件，如果多个配置具有一定规则情况下可以采用匹配方式进行读取
        // 例如有两个xml 文件。既：beans-1.xml，beans-2.xml，beans-3.xml
        // 采用匹配方式进行读取
        // ApplicationContext ctx = new
        // ClassPathXmlApplicationContext("beans-*.xml");

        // 废弃方法不建议使用
        // BeanFactory factory=new XmlBeanFactory(new
        // ClassPathResource("beans.xml"));

        ApplicationContext ctx = new ClassPathXmlApplicationContext("springIocTestXml/propertyEditor2.xml");
        Person person = (Person) ctx.getBean("person");

        System.out.println("学生ID：" + person.getId());
        System.out.println("名称:" + person.getName());
        System.out.println("毕业时间：" + person.getDataValue());
        System.out.println("学生就读国别：" + person.getEducation().getCountry());
        System.out.println("学生就读地址:" + person.getEducation().getDirectory());

/*        assertEquals(person.getId(),1003);
        assertEquals(person.getName(),"东北大亨");

        System.out.println("测试springPropertyUtil  end");*/
    }
}