package com.gongyongqin.demo.service;

import java.util.List;
import java.util.Map;

public interface EmpService {
    /**
     * 获取员工列表
     * @return
     */
    List<Map> getEmpList(Map map);

    /**
     * 获取账号
     * @param
     * @return
     */
    List<Map> selectEmp(String username);

    /**
     * 更改员工
     * @param map
     * @return
     */
    int updateEmp(Map map);
    /**
     * 新增员工
     * @param map
     * @return
     */
    int insertEmp(Map map);

    /**
     * 删除员工
     * @param
     * @return
     */
    int deleteEmp(Integer ID);


    /**
     * 批量删除
     * @param map
     * @return
     */
    int batchDel(Map map);
    /**
     * 更改密码
     * @param passWord
     * @param userName
     * @return
     */
    int updatepassword(String passWord,String userName);

}
