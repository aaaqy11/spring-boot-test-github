package com.gongyongqin.demo.service;

import com.gongyongqin.demo.dao.Equ_maintenanceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class Equ_maintenanceServiceImpl implements Equ_maintenanceService{

    @Autowired
    private Equ_maintenanceDao equ_maintenanceDao;

    @Override
    public Map getEquList() {
        List<Map> equInfo = equ_maintenanceDao.getEquList();
        Map map = new HashMap();
        map.put("equInfo",equInfo);
        return map;
    }

    @Override
    public int addEqu(Map map) {
        return equ_maintenanceDao.addEqu(map);
    }

    @Override
    public List<Map> getEquListBy(Map map) {
        return equ_maintenanceDao.getEquListBy(map);
    }

    @Override
    public int updateEqu(Map map) {
        return equ_maintenanceDao.updateEqu(map);
    }

    @Override
    public int deleteEqu(Integer ID) {
        return equ_maintenanceDao.deleteEqu(ID);
    }

    @Override
    public int equDel(Map ids) {
        String ides = ids.get("ids") + "";
        String[] idArr = ides.split(",");
        List IDs = new ArrayList();
        for (int i = 0; i< idArr.length;i++) {
            IDs.add(Integer.valueOf(idArr[i]));
        }
        int i = equ_maintenanceDao.equDel(IDs);
        return  i;
    }
}
