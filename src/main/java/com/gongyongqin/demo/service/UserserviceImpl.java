package com.gongyongqin.demo.service;

import com.gongyongqin.demo.dao.Userdao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return userdao.addUser(map);
    }

    @Override
    public List<Map> getListBy(Map map) {
        return userdao.getListBy(map);
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
    public int userExist(String username) {
        List<Map> mapList = userdao.userExist(username);
        return mapList.size();
    }


}
