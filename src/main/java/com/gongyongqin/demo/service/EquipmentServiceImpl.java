package com.gongyongqin.demo.service;

import com.gongyongqin.demo.dao.EquipmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class EquipmentServiceImpl implements EquipmentService {

    @Autowired
    private EquipmentDao equipmentDao;

    @Override
    public List<Map> EquipmentList() {
        return equipmentDao.EquipmentList();
    }

    @Override
    public List<Map> EquipmentListBy(Map map) {
        return equipmentDao.EquipmentListBy(map);
    }

    @Override
    public int EquipmentAdd(Map map) {
        return equipmentDao.EquipmentAdd(map);
    }

    @Override
    public int EquipmentUpdate(Map map) {
        return equipmentDao.EquipmentUpdate(map);
    }

    @Override
    public int EquipmentDelete(Integer ID) {
        return equipmentDao.EquipmentDelete(ID);
    }

    @Override
    public int EquipmentDel(Map ids) {
        String ides = ids.get("ids") + "";
        String[] idArr = ides.split(",");
        List idList=new ArrayList();
        for (int i = 0; i < idArr.length; i++) {
            idList.add(Integer.valueOf(idArr[i]));
        }
        int i = equipmentDao.EquipmentDel(idList);
        return i;
    }


}
