package com.bigDragon.anonymousInnerClass;

/**
 * 匿名内部类
 *  匿名内部类格式
 *  new 父类构造器（参数列表）|实现接口（）
 *     {
 *      //匿名内部类的类体部分
 *     }
 * @author bigDragon
 * @create 2020-09-14 17:20
 */
public class Test {

    public void test(Bird bird){
        System.out.println(bird.getName() + "能够飞 " + bird.fly() + "米");
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.test(new Bird() {

            public int fly() {
                return 10000;
            }

            public String getName() {
                return "大雁";
            }
        });
    }
}