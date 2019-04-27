package com.gongyongqin.demo.service;

import com.gongyongqin.demo.dao.BuyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BuyServiceImpl implements BuyService{
    @Autowired
    private BuyDao buyDao;

    @Override
    public List<Map> buyList() {
        List<Map> buyList = buyDao.buyList();
        return buyList;
    }

    @Override
    public List<Map> buyListBy(Map map) {
        return buyDao.buyListBy(map);
    }

    @Override
    public int buyAdd(Map map) {
        return buyDao.buyAdd(map);
    }

    @Override
    public int insertBuy_Equ(Map map) {
        buyDao.updateBuy_Equ(map);
        return buyDao.insertBuy_Equ(map);
    }

    @Override
    public int buyUpdate(Map map) {
        return buyDao.buyUpdate(map);
    }

    @Override
    public int buyDelete(Integer id) {
        return buyDao.buyDelete(id);
    }

    @Override
    public int buyDel(Map ids) {
        String ides = ids.get("ids") + "";
        String[] idArr = ides.split(",");
        List IDs = new ArrayList();
        for (int i = 0; i< idArr.length;i++) {
            IDs.add(Integer.valueOf(idArr[i]));
        }
        int i =buyDao.buyDel(IDs);
        return  i;
    }
}
