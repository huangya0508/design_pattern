package styategy;

/**
 * @author nonpool
 * @version 1.0
 * @since 2020/3/8
 * 鸭子超类
 */
public abstract class Duck {
    //为行为接口类型声明两个引用变量，所有鸭子子类(在同一个package中)都集成了他们
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public Duck() {
    }

    //委托给行为类
    public void  performFly(){
        flyBehavior.fly();
    }

    //委托给行为类
    public void performQuack(){
        quackBehavior.quack();
    }

    public void swim(){
        System.out.println("All ducks float,enen decoys");
    }

    //设定鸭子的行为
    public void setFlyBehavior(FlyBehavior fb){
        flyBehavior = fb;
    }

    public void setQuackBehavior(QuackBehavior qb){
        quackBehavior = qb;
    }
}
