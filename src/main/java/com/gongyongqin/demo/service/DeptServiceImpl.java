package com.gongyongqin.demo.service;

import com.gongyongqin.demo.dao.DeptDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DeptServiceImpl implements DeptService{
    @Autowired
    private DeptDao deptDao;

    /**
     * 部门查询列表
     * @return
     */
    @Override
    public List<Map> getDeptList() {
        List<Map> deptList = deptDao.getDeptList();
        return deptList;
    }

    /**
     * 部门按条件查询
     * @return
     */
    @Override
    public List<Map> getDeptListBy(Map map) {
        return deptDao.getDeptListBy(map);
    }

    /**
     * 部门添加列表
     * @param map
     * @return
     */
    @Override
    public int dpetAdd(Map map) {
        return deptDao.dpetAdd(map);
    }

    /**
     * 部门更新列表
     * @param map
     * @return
     */
    @Override
    public int deptUpdate(Map map) {
        return deptDao.deptUpdate(map);
    }

    /**
     * 部门删除列表
     * @param
     * @return
     */
    @Override
    public int deptDelete(Integer dept_id) {
        return deptDao.deptDelete(dept_id);
    }

    /**
     * 部门批量删除列表
     * @param
     * @return
     */
    @Override
    public int deptDel(Map ids) {
        String ides = ids.get("ids") + "";
        String[] idArr = ides.split(",");
        List IDs = new ArrayList();
        for (int i = 0; i< idArr.length;i++) {
            IDs.add(Integer.valueOf(idArr[i]));
        }
        int i =deptDao.deptDel(IDs);
        return  i;
    }
}
