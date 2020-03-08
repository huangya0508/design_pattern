package styategy;

/**
 * @author nonpool
 * @version 1.0
 * @since 2020/3/8
 * 给会吱吱叫的鸭子用的实现类
 */
public class Squeak implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("Squeak");
    }
}
