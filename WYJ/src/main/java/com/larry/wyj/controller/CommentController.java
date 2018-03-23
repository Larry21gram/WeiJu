package com.larry.wyj.controller;

import com.larry.wyj.domain.Comment;
import com.larry.wyj.service.WYJService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CommentController {

    @Autowired
    private WYJService wyjService;

    @RequestMapping("/selectCommentById")
    @ResponseBody
    public List<Comment> selectCommentById(Integer id){
        List<Comment> list = wyjService.selectCommentById(id);
        System.out.println("selectCommentById");
        return list;
    }
}
