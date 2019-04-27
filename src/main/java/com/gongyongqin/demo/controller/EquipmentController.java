package com.gongyongqin.demo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gongyongqin.demo.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("equip")
public class EquipmentController {
    @Autowired
    private EquipmentService equipmentService;

    /**
     * 跳转到设备页面
     * @return
     */
    @RequestMapping("toEquip")
    private String toEquip(){
        return "meikuang/equipment";
    }

    @RequestMapping("getEquipList")
    @ResponseBody
    private Object getBuylist(Map map){
        return equipmentService.EquipmentList();
    }
    /**
     * 按条件查询
     * @param map
     * @return
     */
    @RequestMapping("getEquipListBy")
    @ResponseBody
    private Object getBuyListBy(@RequestBody Map map){
        System.out.println("map："+map);
        //设置当前第几页和每页显示数量
        PageHelper.startPage(Integer.valueOf(map.get("pageNo") + ""), Integer.valueOf(map.get("pageSize") + ""));
        //用PageInfo对结果进行包装
        PageInfo<Map> pageInfo = new PageInfo<Map>(equipmentService.EquipmentListBy(map));
        System.out.println("list:"+equipmentService.EquipmentListBy(map));
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
    @RequestMapping("toEquipAdd")
    @ResponseBody
    private Object toBuyAdd(@RequestBody Map map){
        return equipmentService.EquipmentAdd(map);
    }

    /**
     * 更新
     * @param map
     * @return
     */
    @RequestMapping("toEquipUpdate")
    @ResponseBody
    private Object toBuyUpdate(@RequestBody Map map){
        return equipmentService.EquipmentUpdate(map);
    }

    /**
     * 删除
     * @param map
     * @return
     */
    @RequestMapping("toEquipDelete")
    @ResponseBody
    private Object toBuyDelete(@RequestBody Map map){
        return equipmentService.EquipmentDelete(Integer.valueOf(map.get("ID")+""));
    }

    /**
     * 批量删除
     * @param map
     * @return
     */
    @RequestMapping("batchDel")
    @ResponseBody
    private Object batchDel(@RequestBody Map map){
        return equipmentService.EquipmentDel(map);
    }
}
