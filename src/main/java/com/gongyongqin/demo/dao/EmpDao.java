package com.gongyongqin.demo.dao;

import java.util.List;
import java.util.Map;

public interface EmpDao {

    /**
     * 获取列表
     * @return
     */
    List<Map> getEmpList(Map map);

    /**
     * 获取角色列表
     * @return
     */
    List<Map> getRoleList();

    /**
     * 更改emp
     * @param map
     * @return
     */
    int updateEmp(Map map);
    /**
     * 新增emp
     * @param map
     * @return
     */
    int insertEmp(Map map);

    /**
     * 前台注册新增
     * @param map
     * @return
     */
    int inUserEmp(Map map);

    /**
     * 删除员工
     * @param
     * @return
     */
    int deleteEmp(Integer ID);

    /**
     * 通过姓名查询
     * @param
     * @return
     */
    List<Map> selectEmp(String username);


    /**
     * 批量删除
     * @param idList
     * @return
     */
    int batchDel(List idList);

    /**
     * 更改密码
     * @param password
     * @param
     * @return
     */
    int updatepassword(String password,String username);

}
