package com.larry.wyj.service;

import com.larry.wyj.domain.Article;
import com.larry.wyj.domain.Comment;
import com.larry.wyj.domain.Order;
import com.larry.wyj.domain.User;

import java.util.List;

public interface WYJService {


    User selectUserByLogin(User user);

    User selectUserByPhone(User user);

    User selectUserByName(User user);

    void insetUser(User user);

    List<Article> selectArticleByHot(int page);

    List<Article> selectByType(Integer type);

    Article selectById(Integer id);


    List<Comment> selectCommentById(Integer id);

    boolean insertOrder(Order order);

    List<Order> selectOrderByUid(Integer uid);

    boolean remove(Integer oid);

    boolean updateOrder(Integer count,Integer oid);

    User selectUserAddressById(Integer user_id);
}
