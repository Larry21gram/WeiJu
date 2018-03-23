package com.larry.wyj.service.impl;

import com.larry.wyj.domain.Article;
import com.larry.wyj.domain.Comment;
import com.larry.wyj.domain.Order;
import com.larry.wyj.domain.User;
import com.larry.wyj.mapper.ArticleMapper;
import com.larry.wyj.mapper.CommentMapper;
import com.larry.wyj.mapper.OrderMapper;
import com.larry.wyj.mapper.UserMapper;
import com.larry.wyj.service.WYJService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("wyjService")
public class WYJServiceImpl implements WYJService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public User selectUserByLogin(User user) {
//        System.out.println(user);
        return userMapper.selectUserByLogin(user);
    }

    @Override
    public User selectUserByPhone(User user) {
        return userMapper.selectUserByPhone(user);
    }

    @Override
    public User selectUserByName(User user) {
        return userMapper.selectUserByName(user);
    }

    @Override
    public void insetUser(User user) {
        userMapper.insertUser(user);
    }

    public List<Article> selectArticleByHot(int page) {
        return articleMapper.selectHot((page-1)*Article.PAGE_SIZE,Article.PAGE_SIZE);
    }

    @Override
    public List<Article> selectByType(Integer type) {
        return articleMapper.selectByType(type);
    }

    @Override
    public Article selectById(Integer id) {
        return articleMapper.selectById(id);
    }

    @Override
    public List<Comment> selectCommentById(Integer id) {
        return commentMapper.selectCommentById(id);
    }

    @Override
    public boolean insertOrder(Order order) {
       return orderMapper.insertOrder(order);
    }

    @Override
    public List<Order> selectOrderByUid(Integer uid) {
        return orderMapper.selectOrderByUid(uid);
    }

    @Override
    public boolean remove(Integer oid) {
       return orderMapper.remove(oid);
    }

    @Override
    public boolean updateOrder(Integer count,Integer oid) {
        return orderMapper.updateOrder(count,oid);
    }

    @Override
    public User selectUserAddressById(Integer user_id) {
        return userMapper.selectUserAddressById(user_id);
    }


}
