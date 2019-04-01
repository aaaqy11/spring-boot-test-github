package com.gongyongqin.demo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gongyongqin.demo.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private Userservice userservice;

    /**
     * 跳转用户列表
     */
    @RequestMapping("toUser")
    public String toUser() {
        return "meikuang/user";
    }

    /**
     * 用户信息查询
     */
    @RequestMapping("toGetUserList")
    @ResponseBody
    public Object toGetUserList() {
        return userservice.getUserInfo();
    }
    /**
     *通过条件获取部门列表
     * @return
     */
    @RequestMapping("/getDeptListBy")
    @ResponseBody
    public Object getDeptListBy(@RequestBody Map map){
        //设置当前第几页和每页显示数量
        PageHelper.startPage(Integer.valueOf(map.get("pageNo") + ""), Integer.valueOf(map.get("pageSize") + ""));
        //用PageInfo对结果进行包装
        PageInfo<Map> pageInfo = new PageInfo<Map>(userservice.getDeptListBy(map));
        Map resultMap = new HashMap();
        resultMap.put("total", pageInfo.getTotal());
        resultMap.put("pageData", pageInfo.getList());
        return resultMap;
    }
    /**
     * 员工添加操作
     * @param map
     * @return
     */
    @RequestMapping("toAdd")
    @ResponseBody
    public Object toAdd(@RequestBody Map map) {
        return userservice.addUser(map);
    }

    /**
     * 员工更新操作
     */
    @RequestMapping("toUpdate")
    @ResponseBody
    public Object toUpdate(@RequestBody Map map){
        return userservice.updateUser(map);
    }
    /**
     * 员工删除操作
     */
    @RequestMapping("delete")
    @ResponseBody
    public Object delete(@RequestBody Map map){
        return userservice.deleteUser(Integer.valueOf(map.get("ID")+""));
    }

}
