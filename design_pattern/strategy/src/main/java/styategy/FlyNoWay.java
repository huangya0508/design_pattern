package styategy;

/**
 * @author nonpool
 * @version 1.0
 * @since 2020/3/8
 * 飞行行为的实现 给不会飞的鸭子用
 */
public class FlyNoWay implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println(" I can't fly");
    }
}
