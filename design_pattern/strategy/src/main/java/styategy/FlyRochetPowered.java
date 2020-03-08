package styategy;

/**
 * @author nonpool
 * @version 1.0
 * @since 2020/3/8
 * 火箭动力的飞行行为
 */
public class FlyRochetPowered implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I'm flying with a rocket");
    }
}
