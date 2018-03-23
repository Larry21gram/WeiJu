package com.larry.wyj.controller;

import com.larry.wyj.domain.Order;
import com.larry.wyj.service.WYJService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private WYJService wyjService;

    @RequestMapping("/insertOrder")
    @ResponseBody
    public boolean insertOrder(Order order){
        return wyjService.insertOrder(order);
    }

    @RequestMapping("/selectOrderByUid")
    @ResponseBody
    public List<Order> selectOrderByUid(Integer uid){
        System.out.println("uid:"+uid);
       return wyjService.selectOrderByUid(uid);
    }

    @RequestMapping("/removed")
    @ResponseBody
    public boolean remove(Integer oid){
        System.out.println("remove"+oid);
        return wyjService.remove(oid);
    }

    @RequestMapping("/updataOrder")
    @ResponseBody // 将返回结果作为json数据传输
    public boolean updataOrder(Integer count,Integer oid){
       return wyjService.updateOrder(count, oid);
    }
}
