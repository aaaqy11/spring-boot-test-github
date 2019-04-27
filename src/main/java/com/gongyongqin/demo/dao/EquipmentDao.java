package com.gongyongqin.demo.dao;

import java.util.List;
import java.util.Map;

public interface EquipmentDao {
    /**
     * 查
     * @return
     */
    List<Map> EquipmentList();
    /**
     * 查询购买设备表
     */
    List<Map> EquipmentListBy(Map map);

    /**
     * 添加设备购买表
     * @param map
     * @return
     */
    int EquipmentAdd(Map map);

    /**
     * 更新设备购买表
     * @param map
     * @return
     */
    int EquipmentUpdate(Map map);


    /**
     * 删除数据
     * @param
     * @return
     */
    int EquipmentDelete(Integer ID);

    /**
     * 批量删除
     * @param IDs
     * @return
     */
    int EquipmentDel(List IDs);
}
