package styategy;

/**
 * @author nonpool
 * @version 1.0
 * @since 2020/3/8
 * 绿头鸭子
 */
public class MallardDuck extends Duck {
    public MallardDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }
}

