package com.gongyongqin.demo.dao;

import java.util.List;
import java.util.Map;

public interface HistoryDao {
    /**
     * 查
     * @return
     */
    List<Map> HistoryList();
    /**
     * 按条件查询表
     */
    List<Map> HistoryListBy(Map map);
}
