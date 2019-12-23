package com.jkoss.framejui.shiro;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jkoss.common.constant.Constant;
import com.jkoss.common.util.CommonMethod;
import com.jkoss.common.util.CommonUtil;
import com.jkoss.framejui.system.entity.Permission;
import com.jkoss.framejui.system.entity.User;
import com.jkoss.framejui.system.service.IPermissionService;
import com.jkoss.framejui.system.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/*
 * 添加shiro安全框架
 * */
@Component("AuthRealm")
public class AuthRealm extends AuthorizingRealm {
    @Autowired
    private IUserService iUserService;
    @Autowired
    private IPermissionService iPermissionService;

    //授权的方法
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //将这些字符串授予权限。
        simpleAuthorizationInfo.addStringPermissions((Collection<String>) SecurityUtils.getSubject().getSession().getAttribute(Constant.SESSION_URLS_KEY));
        return simpleAuthorizationInfo;
    }

    //认证，登录的方法
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取用户名和密码
        UsernamePasswordToken token1 = (UsernamePasswordToken) token;
        String username = token1.getUsername();
        //这个方法返回的类型是char[]数组，token1.getPassword();
        String pwd = new String(token1.getPassword());
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("name", username).or().eq("phone", username);
        User user = iUserService.getOne(userQueryWrapper);
        if (CommonUtil.isBlank(user)) {
            throw new UnknownAccountException();
        }
        if (!CommonUtil.isEquals(user.getPwd(), pwd)) {
            throw new IncorrectCredentialsException();
        }
        //验证成功了
        //根据用户查找权限
        List<Permission> permissions = iPermissionService.listByUid(user.getId());
        ArrayList<Permission> menus = new ArrayList<>();
        ArrayList<String> urls = new ArrayList<>();
        if (!CommonUtil.isBlank(permissions)) {
            for (Permission permission : permissions) {
                //树形结构中的，如果是一级或者二级，都是做动态菜单的，因为数据库中的一级的数据是0，所以，一级菜单是0
                if (CommonUtil.isEquals(permission.getLevel(), 0) || CommonUtil.isEquals(permission.getLevel(), 1)) {
                    menus.add(permission);
                }
                //获取树形1,2级的菜单的URL
                if (CommonUtil.isEquals(permission.getLevel(), 1) || CommonUtil.isEquals(permission.getLevel(), 2)) {
                    urls.add(permission.getUrl());
                }
            }
        }
        //将树形1,2级的菜单的URL的集合添加session域中
        SecurityUtils.getSubject().getSession().setAttribute(Constant.SESSION_URLS_KEY,urls);
        //将动态的菜单传到session域中
        SecurityUtils.getSubject().getSession().setAttribute(Constant.SESSION_MENUS_KEY,menus);
        //验证成功，将用户的信息传递到session域中
        SecurityUtils.getSubject().getSession().setAttribute(Constant.SESSION_USER_KEY, user);
        //返回shiro用户信息
        //token传递过来的密码，一定要跟验证信息传递进去的密码一致，这说明了密码要在传进这个来的时候就要进行加密
        return new SimpleAuthenticationInfo(user, user.getPwd(), getName());
    }
}
