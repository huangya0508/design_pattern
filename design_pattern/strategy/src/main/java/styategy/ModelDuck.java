package styategy;

/**
 * @author nonpool
 * @version 1.0
 * @since 2020/3/8
 * 模型鸭
 */
public class ModelDuck extends Duck{
    public ModelDuck(){
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }

    public void display(){
        System.out.println("I'm a model duck");
    }
}
