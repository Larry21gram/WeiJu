package com.larry.wyj.controller;

import com.larry.wyj.domain.User;
import com.larry.wyj.service.WYJService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
public class UserController {

    @Autowired
    @Qualifier("wyjService")
    private WYJService wyjService;

    @RequestMapping(value="/selectUserByLogin")
    public User selectUserByLogin(User user){
        User user1 = wyjService.selectUserByLogin(user);
        return user1;
    }

    @RequestMapping("/isExit")
    public User isExit(User user){
        return wyjService.selectUserByPhone(user);
    }

    @RequestMapping("/selectUser")
    public User selectUser(User user){
        return wyjService.selectUserByName(user);
    }

    @RequestMapping("/insertUser")
    public String insertUser(User user){
        wyjService.insetUser(user);
        return "login";
    }

    @RequestMapping("/selectUserAddressById")
    @ResponseBody
    public User selectUserAddressById(Integer user_id){
        return wyjService.selectUserAddressById(user_id);
    }

}
