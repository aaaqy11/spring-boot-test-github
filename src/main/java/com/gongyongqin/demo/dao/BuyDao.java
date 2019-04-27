package com.gongyongqin.demo.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface BuyDao {
    /**
     * 查
     * @return
     */
    //@Select("select * from buy")
    List<Map> buyList();
    /**
     * 查询购买设备表
     */
    //@Select("select * from buy")
    List<Map> buyListBy(Map map);

    /**
     * 添加设备购买表
     * @param map
     * @return
     */
    int buyAdd(Map map);

    /**
     * 一键导入设备表并将状态改为 1
     * @param map
     * @return
     */
    int insertBuy_Equ(Map map);
    int updateBuy_Equ(Map map);
    /**
     * 更新设备购买表
     * @param map
     * @return
     */
    int buyUpdate(Map map);

    /**
     * 删除数据
     * @param id
     * @return
     */
    int buyDelete(Integer id);

    /**
     * 批量删除
     * @param IDs
     * @return
     */
    int buyDel(List IDs);
}
