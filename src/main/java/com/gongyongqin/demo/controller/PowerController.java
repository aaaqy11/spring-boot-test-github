package com.gongyongqin.demo.controller;

import com.gongyongqin.demo.entity.TreeNode;
import com.gongyongqin.demo.service.PowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/power")
public class PowerController {
    @Autowired
    private PowerService powerService;
        /**
         * 后台登陆
         */
        @RequestMapping("/toLogin")
        public String toLogin(String userName, String password, Model model, HttpSession session, HttpServletRequest request){
        return  "/meikuang/userLogin";
        }

        /**
         * 获取权限菜单树
          * @param session
         * @return
         */
        @ResponseBody
        @RequestMapping("tree")
        public Object getTree(HttpSession session){
                List<TreeNode> powerList = powerService.getPowerList(session);
                return powerList;
        }
    /**
     * 回显权限菜单
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/backTree")
    public Object backTree(@RequestBody Map map) {
        Integer roleId = Integer.valueOf(map.get("roleId")+"");
        List<TreeNode> powerList = powerService.getBackPowerList(roleId);
        List list = new ArrayList();
        for (TreeNode treeNode : powerList) {
            if (treeNode.getChildren()!=null&&treeNode.getChildren().size()!=0){
                List<TreeNode> list1 = treeNode.getChildren();
                for (TreeNode node : list1) {
                    int id = node.getId();
                    list.add(id);
                }
            }
        }
        return list;
    }
    /**
     * 毫无理由获取权限菜单树
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/getPList")
    public Object getPList() {
        List<TreeNode> powerList = powerService.getPPowerList();
        return powerList;
    }

    /**
     * 在session中获取用户
     * @param httpSession
     * @return
     */
    @ResponseBody
    @RequestMapping("/user")
    public Object getUser(HttpSession httpSession){
        return httpSession.getAttribute("userName");
    }

    /**
     * 跳转后台首页
     *
     * @return
     */
    @RequestMapping("/wel")
    public String wel() {
        return "back/wel";
    }
    /**
     * 跳转登陆页面
     *
     * @return
     */
    @RequestMapping("/login")
    public String login() {
        return "back/login";
    }

}
