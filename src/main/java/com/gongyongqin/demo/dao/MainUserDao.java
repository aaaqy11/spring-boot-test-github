package com.gongyongqin.demo.dao;

import java.util.List;
import java.util.Map;

public interface MainUserDao {
    /**
     * 按姓名查询维修员工信息
     */
    List<Map> selectMainuser(Map map);



}
