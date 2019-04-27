package com.gongyongqin.demo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gongyongqin.demo.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("his")
public class HistoryController {
    @Autowired
    private HistoryService historyService;

    /**
     * 跳转页面
     * @returnHis
     */
    @RequestMapping("toHis")
    private String toEqu(){
        return "meikuang/history";
    }

    /**
     * 获取报修列表
     * @param map
     * @return
     */
    @RequestMapping("toHistoryList")
    @ResponseBody
    private  Object toEquList(Map map){
        return historyService.HistoryList();
    }

    /**
     *通过条件获取部门列表
     * @return
     */
    @RequestMapping("toHistoryListBy")
    @ResponseBody
    public Object getEquListBy(@RequestBody Map map){
        System.out.println("map："+map);
        //设置当前第几页和每页显示数量
        PageHelper.startPage(Integer.valueOf(map.get("pageNo") + ""), Integer.valueOf(map.get("pageSize") + ""));
        //用PageInfo对结果进行包装
        PageInfo<Map> pageInfo = new PageInfo<Map>(historyService.HistoryListBy(map));
        Map resultMap = new HashMap();

        resultMap.put("total", pageInfo.getTotal());
        resultMap.put("pageData", pageInfo.getList());

        return resultMap;
    }
}
