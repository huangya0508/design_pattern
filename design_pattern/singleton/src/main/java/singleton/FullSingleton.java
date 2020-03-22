package singleton;

/**
 * @author nonpool
 * @version 1.0
 * @since 2020/3/22
 * 饱汉模式
 */
public class FullSingleton {
    private static FullSingleton fullSingleton ;

    private FullSingleton(){};

    public static synchronized FullSingleton getInstance(){
        if (fullSingleton == null){
            fullSingleton = new FullSingleton();
        }
        return fullSingleton;
    }

}
