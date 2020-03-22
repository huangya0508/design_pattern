package singleton;

/**
 * @author nonpool
 * @version 1.0
 * @since 2020/3/22
 * 双重加锁
 */
public class DualSingleton {
    private volatile static DualSingleton dualSingleton;

    private DualSingleton(){

    }

    public static DualSingleton getInstance(){
        if (dualSingleton == null){
            synchronized (DualSingleton.class){
                if (dualSingleton == null){
                    dualSingleton = new DualSingleton();
                }
            }
        }
        return dualSingleton;
    }
}
