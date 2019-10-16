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
    @Test
    public void useLambdaReplaceTheImplementationClass() {
        List<Sku> cartSkuList = CartService.getCartSkuList();
        List<Sku> result = CartService.filterSkus(cartSkuList, sku -> sku.getTotalPrice() > 1000);
        System.out.println(JSON.toJSONString(result,true));
    }

}