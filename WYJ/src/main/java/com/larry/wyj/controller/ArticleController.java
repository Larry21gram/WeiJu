package com.larry.wyj.controller;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import com.larry.wyj.domain.Article;
import com.larry.wyj.service.WYJService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

@Controller
public class ArticleController {

    @Autowired
    @Qualifier("wyjService")
    private WYJService wyjService;

    @RequestMapping("/selectByHot")
    @ResponseBody
    public Object selectArticleByHot() throws IOException {
//        获得热门商品
        List<Article> list = wyjService.selectArticleByHot(2);
        return list;
    }

    @RequestMapping("/selectByType")
    @ResponseBody
    public List<Article> pro_list(Integer type){
//        获得指定商品类型的商品
        List<Article> list = wyjService.selectByType(type);
        return list;
    }

    @RequestMapping("/selectById")
    @ResponseBody
    public Article selectById(Integer id){
        return wyjService.selectById(id);
    }

}
