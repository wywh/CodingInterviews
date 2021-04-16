/**
 * 实现单例模式
 *
 *
 * 懒汉式：在第一次调用的时候才进行实例化。
 * 使用静态内部类方式
 *
**/
public class Q02Singleton1 {


    /**
     * 私有化构造方法，防止在其他类中创建实例
     */
    private Q02Singleton1(){

    }

    /**
     * 使用私有静态内部类初始化静态final实例
     */
    private static class StaticSingletonHolder {
        private static final Q02Singleton1 instance = new Q02Singleton1();
    }

    /**
     * 获取实例的方法
     */
    public static Q02Singleton1 getInstance() {
        return StaticSingletonHolder.instance;
    }

    public static void main(String[] args) {
        Q02Singleton1.getInstance();
    }



}
