package com.gongyongqin.demo.service;

import java.util.List;
import java.util.Map;

public interface MainUserService {
    /**
     * 按姓名查询维修员工信息
     */
    List<Map> selectMainuser(Map map);
}
