package com.larry.wyj.mapper;

import com.larry.wyj.domain.Article;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleMapper {

    @Select("select * from article limit #{page},#{PAGE_SIZE}")
    List<Article> selectHot(@Param("page") int i, @Param("PAGE_SIZE") int pageSize);

    @Select("select * from article where type=#{type}")
    List<Article> selectByType(Integer type);

    @Select("select * from article where goods_id=#{id}")
    Article selectById(Integer id);

}
