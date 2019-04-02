package com.gongyongqin.demo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gongyongqin.demo.service.DeptService;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("dept")
public class DeptController {
    @Autowired
    private DeptService deptService;

    /**
     * 跳转dept页面
     * @return
     */
    @RequestMapping("toDept")
    public String toDept (){
        return "meikuang/dept";
    }

    /**
     * 获取部门列表
     * @param map
     * @return
     */
    @RequestMapping("getDeptList")
    @ResponseBody
    private Object getDeptList(Map map){
        return deptService.getDeptList();
    }

    @RequestMapping("getDeptListBy")
    @ResponseBody
    private Object getDeptListBy(Map map){
        //设置当前第几页和每页显示数量
        PageHelper.startPage(Integer.valueOf(map.get("pageNo") + ""), Integer.valueOf(map.get("pageSize") + ""));
        //用PageInfo对结果进行包装
        PageInfo<Map> pageInfo = new PageInfo<Map>(deptService.getDeptListBy(map));
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
    @RequestMapping("deptAdd")
    @ResponseBody
    private Object deptAdd(@RequestBody Map map){
        return deptService.dpetAdd(map);
    }

    /**
     * 更新
     * @param map
     * @return
     */
    @RequestMapping("updateDept")
    @ResponseBody
    private Object updateDept(@RequestBody Map map){
        return deptService.deptUpdate(map);
    }

    /**
     * 删除
     * @param map
     * @return
     */
    @RequestMapping("deleteDept")
    @ResponseBody
    private Object deleteDept(@RequestBody Map map){
        return deptService.deptDelete(Integer.valueOf(map.get("dept_id")+""));
    }

    /**
     * 批量删除
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("batchDel")
    private Object batDel(@RequestBody Map map){
        return deptService.deptDel(map);
    }
}
