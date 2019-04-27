package com.gongyongqin.demo.controller;

import com.gongyongqin.demo.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("fowardUser")
public class FowardUserController {
    @Autowired
    private Userservice userservice;
    @RequestMapping("toFowardUser")
    public String toFowardUser(){
        return "meikuang/forwardUserrreg";
    }
    /**
     * 用户名唯一性校验
     * @param username
     * @return
     */
    @ResponseBody
    @RequestMapping("/userExist")
    public int userExist(String username) {
        return userservice.userExist(username);
    }
    /**
     * 添加操作
     * @param map
     * @return
     */
    @RequestMapping( "toAdd")
    @ResponseBody
    public Object toAdd(@RequestParam Map map) {
        return userservice.addUser(map);
    }
}
