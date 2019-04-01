package com.gongyongqin.demo.service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public interface PowerService {

    /**
     * 直接给roleid
     * @param roleId
     * @return
     */
    List<com.gongyongqin.demo.entity.TreeNode> getBackPowerList(Integer roleId);

    /**
     * 获取权限列表
     * @param session
     * @return
     */
    List<com.gongyongqin.demo.entity.TreeNode> getPowerList(HttpSession session);

    /**
     * 毫无理由的查权限树
     * @return
     */
    List<com.gongyongqin.demo.entity.TreeNode> getPList();
    List<com.gongyongqin.demo.entity.TreeNode> getPPowerList();

    /**
     * 通过pid获取权限列表
     * @return
     */
    List<Map> selectTreeByPid(Map map);
    /**
     * 添加节点
     * @param map
     * @return
     */
    int insertTree(Map map);
    /**
     * 更改节点
     * @param map
     * @return
     */
    int updateTree(Map map);
    /**
     * 删除节点
     */
    int deleteTree(Map map);
}
