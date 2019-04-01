package com.gongyongqin.demo.service;

import java.util.List;
import java.util.Map;

public interface DeptService {
    /**
     * 获取部门列表
     * @return
     */
    Map getDeptList();

    /**
     *  通过条件获取部门列表
     * @return
     */

    List<Map> getDeptListBy(Map map);

    /**
     * 部门添加
     * @param map
     * @return
     */
    int dpetAdd(Map map);

    /**
     * 更新
     * @return
     */
    int deptUpdate(Map map);

    /**
     * 删除
     * @param
     * @return
     */
    int deptDelete(Integer dept_id);

    /**
     * 批量删除
     * @param
     * @return
     */
    int deptDel(Map map);
}
