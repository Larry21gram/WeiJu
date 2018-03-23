package com.larry.wyj.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/***
 * 本类用作跳转不含数据的网页使用
 */
@Configuration
public class HtmlConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/toRegiste").setViewName("/regest");
        registry.addViewController("/login").setViewName("/login");
        registry.addViewController("/xzdp").setViewName("/xzdp");
        registry.addViewController("/fenlei").setViewName("/fenlei");
        registry.addViewController("/grzx").setViewName("/grzx");
        registry.addViewController("/pro_list").setViewName("/pro_list");
        registry.addViewController("/wddd").setViewName("/wddd");

        registry.addViewController("/xzdp1").setViewName("/xzdp1");

        registry.addViewController("/qhcs").setViewName("/qhcs");
        registry.addViewController("/xzsq").setViewName("/xzsq");
        registry.addViewController("/xzdpx").setViewName("/xzdpx");
//        定向:指定类型商品页
        registry.addViewController("/pro_list").setViewName("/pro_list");
//        定向:商品详情页
        registry.addViewController("/pro_detail").setViewName("/pro_detail");
//        定向:购物车
        registry.addViewController("/gwc").setViewName("/gwc");
//        定向:商品详情
        registry.addViewController("/pro_detailc_").setViewName("/pro_detailc_");
//        定向:商品评价
        registry.addViewController("/pro_pj").setViewName("/pro_pj");

        registry.addViewController("/dzwh").setViewName("/dzwh");
        registry.addViewController("/xzdz").setViewName("/xzdz");

        registry.addViewController("/grzx").setViewName("/grzx");



    }


}
