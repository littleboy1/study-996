package com.lzq.cart;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CartServiceTest {

    @Test
    public void filterElectionsSkus() {
        List<Sku> cartSkuList = CartService.getCartSkuList();
        List<Sku> result = CartService.filterElectionsSkus(cartSkuList);
        //第二个参数是是否标记
        System.out.println(JSON.toJSONString(result,true));
    }

    @Test
    public void filterSkusByCategory() {
        List<Sku> cartSkuList = CartService.getCartSkuList();
        List<Sku> result = CartService.filterSkusByCategory(cartSkuList,SkuCategoryEnum.BOOKS);
        //第二个参数是是否标记
        System.out.println(JSON.toJSONString(result,true));

    }

    @Test
    public void filterSkus() {
        List<Sku> cartSkuList = CartService.getCartSkuList();
        List<Sku> result = CartService.filterSkus(cartSkuList, null,2000.00,false);
        //第二个参数是是否标记
        System.out.println(JSON.toJSONString(result,true));
    }

    @Test
    public void filterSkus1() {
        List<Sku> cartSkuList = CartService.getCartSkuList();
        List<Sku> result = CartService.filterSkus(cartSkuList, new SkuTotalPricePredicate());
        System.out.println(JSON.toJSONString(result,true));
    }

    @Test
    public void useAnonymousClassReplaceTheImplementationClass() {
        List<Sku> cartSkuList = CartService.getCartSkuList();
        List<Sku> result = CartService.filterSkus(cartSkuList, new SkuPredicate() {
            @Override
            public boolean test(Sku sku) {
                return sku.getTotalPrice() >1000;
            }
        });
        System.out.println(JSON.toJSONString(result,true));
    }
        //lambda可以理解为一种匿名函数的代替，将行为参数化传递

    /**2-11
     * lambda的几中形式
     * 1.没有参数的方法()->
     * 2.只有一个参数name->
     * 3.没有参数逻辑复杂
     * ()->{
     * ......
     * ......
     * 如果有返回值需要显示的返回
     * }
     * 4.包含多个参数的方法(x,y) ->...
     * 5.显示声明参数的形式(long x,long y)->
     *2-12
     *
     * 函数式接口：只有一个抽象方法
     * 函数式接口的注解：@functionInterface
     * 函数式接口的抽象方法签名：函数描述符
     *
     *
     */
    @Test
    public void useLambdaReplaceTheImplementationClass() {
        List<Sku> cartSkuList = CartService.getCartSkuList();
        List<Sku> result = CartService.filterSkus(cartSkuList, sku -> sku.getTotalPrice() > 1000);
        System.out.println(JSON.toJSONString(result,true));
    }

}