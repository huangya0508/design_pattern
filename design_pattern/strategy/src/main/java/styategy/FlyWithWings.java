package styategy;

/**
 * @author nonpool
 * @version 1.0
 * @since 2020/3/8
 * 飞行行为的实现 给真的的会飞的鸭子用
 */
public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I'm flying!!");
    }
}
