package com.gongyongqin.demo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gongyongqin.demo.service.Equ_maintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("equ")
public class Equ_maintenanceController {
    @Autowired
    private Equ_maintenanceService equ_maintenanceService;

    /**
     * 跳转页面
     * @return
     */
    @RequestMapping("toEqu")
    private String toEqu(){
        return "meikuang/equ";
    }

    /**
     * 获取报修列表
     * @param map
     * @return
     */
    @RequestMapping("toEquList")
    @ResponseBody
    private  Object toEquList(Map map){
        return equ_maintenanceService.getEquList();
    }

    /**
     *通过条件获取部门列表
     * @return
     */
    @RequestMapping("getEquListBy")
    @ResponseBody
    public Object getEquListBy(@RequestBody Map map){
        System.out.println("map："+map);
        //设置当前第几页和每页显示数量
        PageHelper.startPage(Integer.valueOf(map.get("pageNo") + ""), Integer.valueOf(map.get("pageSize") + ""));
        //用PageInfo对结果进行包装
        PageInfo<Map> pageInfo = new PageInfo<Map>(equ_maintenanceService.getEquListBy(map));
        System.out.println("list:"+equ_maintenanceService.getEquListBy(map));
        Map resultMap = new HashMap();

        resultMap.put("total", pageInfo.getTotal());
        resultMap.put("pageData", pageInfo.getList());

        return resultMap;
    }

    /**
     * 添加
     * @param map
     * @return
     */
    @RequestMapping("toAddEqu")
    @ResponseBody
    private Object toAddEqu(@RequestBody Map map){
        return equ_maintenanceService.addEqu(map);
    }


    /**
     * 更改
     * @param map
     * @return
     */
    @RequestMapping("toUpdateEqu")
    @ResponseBody
    private Object toUpdateEqu(@RequestBody Map map){
        return equ_maintenanceService.updateEqu(map);
    }

    /**
     * 员工删除操作
     */
    @RequestMapping("delete")
    @ResponseBody
    public Object delete(@RequestBody Map map){
        return equ_maintenanceService.deleteEqu(Integer.valueOf(map.get("ID")+""));
    }

    /**
     * 批量删除
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("equDel")
    private Object equDel(@RequestBody Map map){
        return equ_maintenanceService.equDel(map);
    }
}
