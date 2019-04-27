package com.gongyongqin.demo.service;

import java.util.List;
import java.util.Map;

public interface Equ_maintenanceService {
    /**
     * 获取用户列表
     * @return
     */
    Map getEquList();

    /**
     * 添加
     * @param map
     * @return
     */
    int addEqu(Map map);

    /**
     * 维修完毕添加到历史表
     * @param map
     * @return
     */

    /**
     * 通过条件获取员工列表
     */
    List<Map> getEquListBy(Map map);

    /**
     * 更改
     * @param map
     * @return
     */
    int updateEqu(Map map);

    /**
     * 删除
     * @param ID
     * @return
     */
    int deleteEqu(Integer ID);

    /**
     * 批量删除
     * @param map
     * @return
     */
    int equDel(Map map);
}
