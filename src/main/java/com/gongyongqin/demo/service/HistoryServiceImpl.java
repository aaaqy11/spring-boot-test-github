package com.gongyongqin.demo.service;

import com.gongyongqin.demo.dao.HistoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class HistoryServiceImpl implements HistoryService {
    @Autowired
    private HistoryDao historyDao;

    @Override
    public List<Map> HistoryList() {
        List<Map> historyInfo = historyDao.HistoryList();
        return historyInfo;
    }

    @Override
    public List<Map> HistoryListBy(Map map) {
        return historyDao.HistoryListBy(map);
    }
}
