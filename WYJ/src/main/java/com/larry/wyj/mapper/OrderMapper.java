package com.larry.wyj.mapper;

import com.larry.wyj.domain.Order;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {

    @Insert("insert into `order`(aname,acount,price,uid,count) values (#{aname},#{acount},#{price},#{uid},#{count})")
    boolean insertOrder(Order order);

    @Select("select * from `order` where uid=#{uid}")
    List<Order> selectOrderByUid(Integer uid);

    @Delete("delete from `order` where oid=#{oid}")
    boolean remove(Integer oid);

//    添加@Param()是为了分辨count与oid,没有添加会不知道哪个是哪个
    @Update("update (`order`) set count=#{count} where oid=#{oid}")
    boolean updateOrder(@Param("count")Integer  count, @Param("oid") Integer oid);
}
