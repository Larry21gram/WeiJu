package com.larry.wyj.mapper;

import com.larry.wyj.domain.Article;
import com.larry.wyj.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    @Select("select * from basic_user where phone=#{phone} and password=#{password}")
    User selectUserByLogin(User user);


    @Select("select * from basic_user where phone=#{phone}")
    User selectUserByPhone(User user);

    @Select("select * from basic_user where user_name=#{user_name}")
    User selectUserByName(User user);

    @Insert("insert into basic_user (user_name,phone,password) values(#{user_name},#{phone},#{password})")
    void insertUser(User user);


    @Select("select * from basic_user where user_id=#{user_id}")
    User selectUserAddressById(Integer user_id);
}
