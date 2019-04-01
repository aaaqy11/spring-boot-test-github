package com.gongyongqin.demo.dao;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface DeptDao {
    /**
     * 获取部门列表
     * @return
     */
    //@Select("select * from dept")
    List<Map> getDeptList();

    /**
     *  通过条件获取部门列表
     * @return
     */
    //@Select(value = "select * from dept where d_name=#{d_name}")
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
     * @param IDs
     * @return
     */
    int deptDel(List IDs);
}
