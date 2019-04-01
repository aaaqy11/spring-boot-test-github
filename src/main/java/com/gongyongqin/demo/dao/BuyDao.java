package com.gongyongqin.demo.dao;

import java.util.List;
import java.util.Map;

public interface BuyDao {
    /**
     * 查询购买设备表
     */
    List<Map> buyListBy(Map map);

    /**
     * 添加设备购买表
     * @param map
     * @return
     */
    int buyAdd(Map map);

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
