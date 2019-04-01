package com.gongyongqin.demo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gongyongqin.demo.service.BuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("buy")
public class BuyController {
    @Autowired
    private BuyService buyService;

    /**
     * 跳转到设备购买页面
     * @return
     */
    @RequestMapping("toBuy")
    public String toBuy(){
        return "meikuang/buy";
    }

    /**
     * 按条件查询
     * @param map
     * @return
     */
    @RequestMapping("getBuyListBy")
    @ResponseBody
    private Object getBuyList(Map map){
        //设置当前第几页和每页显示数量
        PageHelper.startPage(Integer.valueOf(map.get("pageNo") + ""), Integer.valueOf(map.get("pageSize") + ""));
        //用PageInfo对结果进行包装
        PageInfo<Map> pageInfo = new PageInfo<Map>(buyService.buyListBy(map));
        Map resultMap = new HashMap();
        resultMap.put("total", pageInfo.getTotal());
        resultMap.put("pageData", pageInfo.getList());
        System.out.println(pageInfo.getTotal());
        System.out.println(pageInfo.getList());
        return resultMap;
    }

    /**
     * 添加
     * @param map
     * @return
     */
    @RequestMapping("toBuyAdd")
    @ResponseBody
    private Object toBuyAdd(@RequestBody Map map){
        return buyService.buyAdd(map);
    }

    /**
     * 更新
     * @param map
     * @return
     */
    @RequestMapping("toBuyUpdate")
    @ResponseBody
    private Object toBuyUpdate(@RequestBody Map map){
        return buyService.buyUpdate(map);
    }

    /**
     * 删除
     * @param map
     * @return
     */
    @RequestMapping("toBuyDelete")
    @ResponseBody
    private Object toBuyDelete(@RequestBody Map map){
        return buyService.buyDelete(Integer.valueOf(map.get("id")+""));
    }

    /**
     * 批量删除
     * @param map
     * @return
     */
    @RequestMapping("batchDel")
    @ResponseBody
    private Object batchDel(@RequestBody Map map){
        return buyService.buyDel(map);
    }
}
