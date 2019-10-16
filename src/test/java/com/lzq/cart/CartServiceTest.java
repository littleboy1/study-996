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
}