package com.gongyongqin.demo.service;

import com.gongyongqin.demo.dao.MainUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class MainUserServiceImpl implements MainUserService{

    @Autowired
    private MainUserDao mainUserDao;

    @Override
    public List<Map> selectMainuser(Map map) {
        return mainUserDao.selectMainuser(map);
    }
}
