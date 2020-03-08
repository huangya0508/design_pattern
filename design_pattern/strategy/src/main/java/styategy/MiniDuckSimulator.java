package styategy;

/**
 * @author nonpool
 * @version 1.0
 * @since 2020/3/8
 */
public class MiniDuckSimulator {
    public static void main(String[] args) {
        Duck mallardDuck = new MallardDuck();
        mallardDuck.performFly();
        mallardDuck.performQuack();


        //动态的给模型鸭设置飞行行为
        Duck modelDuck = new ModelDuck();
        modelDuck.performFly();
        modelDuck.setFlyBehavior(new FlyRochetPowered());
        modelDuck.performFly();
    }
}
