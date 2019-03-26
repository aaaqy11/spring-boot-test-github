package com.gongyongqin.demo.service;

import java.util.List;
import java.util.Map;

public interface Userservice {

    /**
     * 获取用户信息
     */
    Map getUserInfo();

    /**
     * 用户添加
     * @param map
     * @return
     */
    int addUser(Map map);

    /**
     * 通过条件获取员工列表
     */
    List<Map> getDeptListBy(Map map);

    /**
     * 更改
     */
    int updateUser(Map map);

    /**
     * 删除
     * @param
     * @return
     */
    int deleteUser(Integer ID);

    /**
     * 批量删除
     * @param
     * @return
     */
    int batchDel(Map map);
}
