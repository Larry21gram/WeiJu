package com.larry.wyj.mapper;

import com.larry.wyj.domain.Comment;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentMapper {

    @Select("select * from store_comment where store_id=#{id}")
    List<Comment> selectCommentById(Integer id);
}
