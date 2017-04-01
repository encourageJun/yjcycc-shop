package org.yjcycc.shop.goods.impl;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.yjcycc.shop.goods.entity.Goods;
import org.yjcycc.shop.goods.service.GoodsService;

import com.github.pagehelper.Page;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/spring-context.xml"}); 
        BeanFactory factory = (BeanFactory) context;  
        GoodsService goodsService = (GoodsService) factory.getBean("goodsServiceImpl");
        
        Page<Goods> pager = goodsService.findPager("aa");
        for (Goods goods : pager) {
        	System.out.println(goods.getName());
        }
        System.out.println(pager.getEndRow());
        
    }
}
