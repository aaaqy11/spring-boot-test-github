package com.gongyongqin.demo.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gongyongqin.demo.dao.Userdao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class UserserviceImpl implements Userservice {
    @Autowired
    private Userdao userdao;

    @Override
    public Map getUserInfo() {
        List<Map> userInfo = userdao.getUserList();
        Map map = new HashMap();
        map.put("userInfo",userInfo);
        return map;
    }

    @Override
    public int addUser(Map map) {
        return userdao.addCar(map);
    }

    @Override
    public List<Map> getDeptListBy(Map map) {
        return userdao.getDeptListBy(map);
    }

    @Override
    public int updateUser(Map map) {
        return userdao.updateUser(map);
    }

    @Override
    public int deleteUser(Integer ID) {
        return userdao.deleteUser(ID);
    }

    @Override
    public int batchDel(Map ids) {
        String ides = ids.get("ids") + "";
        String[] idArr = ides.split(",");
        List IDs = new ArrayList();
        for (int i = 0; i< idArr.length;i++) {
            IDs.add(Integer.valueOf(idArr[i]));
        }
        int i =userdao.batchDel(IDs);
        return  i;
    }


}
