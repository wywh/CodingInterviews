/**
 * 实现单例模式
 *
 * 饿汉式：在类初始化时进行实例化。
 *
 **/
public class Q02Singleton2 {
    /**
     * 私有化构造方法，防止在其他类中创建实例
     */
    private Q02Singleton2(){

    }

    private static final Q02Singleton2 instance = new Q02Singleton2();

    public static Q02Singleton2 getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        Q02Singleton2.getInstance();
    }
}
