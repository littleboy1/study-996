package com.lzq.cart;

/**
 * 函数式接口可以包含非抽象方法，但是只可以有一个抽象的方法
 */
@FunctionalInterface
public interface CustomerInterFace {

    void testFunc();


    default void HelloWorld(){
        System.out.println("hello_world");
    }

}
