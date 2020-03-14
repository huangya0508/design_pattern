package com.huangya.three;

/**
 * @author nonpool
 * @version 1.0
 * @since 2020/3/14
 * 奶酪披萨
 */
public class CheesePizza extends Pizza {
    PizzaIngredientFactory ingredientFactory;


    /**
     * 要制作的披萨需要工厂提供原料，所以每个披萨类都从构造器参数中得到一个工厂，并把这个工厂存储在实例变量中
     * @param ingredientFactory
     */
    public CheesePizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }


    /**
     * prepare一步一步的创建的披萨 需要的原料跟工厂要
     */
    @Override
    void prepare() {
        System.out.println("Preparing"+name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();

    }
}
