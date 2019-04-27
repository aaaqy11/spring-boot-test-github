package com.gongyongqin.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.gongyongqin.demo.dao.Userdao;
import com.gongyongqin.demo.entity.TreeNode;
import com.gongyongqin.demo.service.EmpService;
import com.gongyongqin.demo.service.PowerService;
import com.gongyongqin.demo.service.Userservice;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
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
    @Autowired
    private EmpService empService;

    /**
     * 后台登陆
     */
    @RequestMapping("/userLogin")
    @ResponseBody
    public Object toLogin(@RequestBody Map user, Model model, HttpSession session) {
        String username = user.get("username")+"";
        String password = user.get("password")+"";
        if (username != null && !"".equals(username)) {
            //将用户放到session中
            session.setAttribute("username", username);
            System.out.println(username);
            //String ipAddress = GetIpUtil.getIpAddress(request);
            //session.setAttribute("ip",ipAddress);

            //session.setMaxInactiveInterval(60*60);//以秒为单位，即在没有活动60分钟后，session将失效
            List<Map> maps = empService.selectEmp(username);

            System.out.println(maps);
            if (maps != null && !"".equals(maps) && maps.size() != 0)
                session.setAttribute("emp", maps.get(0));//通过用户名登陆的emp信息放到session中

            //shiro的关键代码，执行认证功能
            // 1.获取subject
            Subject subject = SecurityUtils.getSubject();
            //2.封装用户数据
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
            //3.执行登陆方法
            try {
                //登陆成功
                subject.login(usernamePasswordToken);

                //跳到欢迎页面"/meikuang/dept"
                return 1;
            } catch (UnknownAccountException e) {
                //用户名不存在的异常
                return 2;
            } catch (IncorrectCredentialsException e) {
                //用户名不存在的异常
                return 3;
            }

        }
        return 1;
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
     * 获取权限菜单树
     * @return
     */
    @RequestMapping("toLogin")
    public String toLogin(){
        return "/meikuang/userLogin";
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
        return httpSession.getAttribute("username");
    }

    /**
     * 跳转后台首页
     *
     * @return
     */
    @RequestMapping("/wel")
    public String wel() {
        return "meikuang/tree/index";
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
