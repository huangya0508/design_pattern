package singleton;

/**
 * @author nonpool
 * @version 1.0
 * @since 2020/3/22
 * 饿汉模式
 */
public class HungrySingleton {
    private static HungrySingleton hungrySingleton = new HungrySingleton();

    private HungrySingleton(){

    }
    public static HungrySingleton getInstance(){
        return hungrySingleton;
    }
}
