package com.gongyongqin.demo.shiro;


import com.gongyongqin.demo.service.EmpService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;


public class UserRealm extends AuthorizingRealm {

    @Autowired
    private EmpService empService;
    /**
     * 执行授权逻辑
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //获取当前登陆的用户
        Subject subject = SecurityUtils.getSubject();
        //获取用户名
        String usernmae = subject.getPrincipal()+"";
        //通过用户名查当前用户
        List<Map> maps = empService.selectEmp(usernmae);
        //获取当前的权限字符
        String roleId = maps.get(0).get("id")+"";
        //设置只有是这个字符才可以访问
        info.addStringPermission(roleId);


        return info;
    }

    /**
     * 执行认证逻辑
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        //编写shiro判断逻辑，判断用户名密码是否正确
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        String username = token.getUsername();
        //1.判断用户名
        List<Map> mapList = empService.selectEmp(token.getUsername());
        if (mapList.size() == 0) {
            return null;
        } else {
            return new SimpleAuthenticationInfo(username, mapList.get(0).get("password"),"");
        }
    }
}
