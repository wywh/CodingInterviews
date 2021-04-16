/**
 * 实现单例模式
 *
 * 枚举方式：可以实现反序列化
 *
 **/
public class Q02Singleton3 {
    public enum Singleton{
        instance;
    }

    public static void main(String[] args) {
        Singleton instance = Singleton.instance;
    }
}
