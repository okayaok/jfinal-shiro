package com.jfinal.shiro.realm;

import com.jfinal.shiro.doman.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @author hang_xiao
 * @date 2016/11/29
 */
public class ShiroRealm extends AuthorizingRealm {

    /**
     * 验证用户的权限
     *
     * @param principal
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {

        String authentication = (String) principal.getPrimaryPrincipal();
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addStringPermission(authentication);
        return simpleAuthorizationInfo;
    }

    /**
     * 验证用户的登陆信息
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取登陆的用户名
        String username = (String) token.getPrincipal();
        User user = User.user.findByUsername(username);
        if (user == null) {
            throw new UnknownAccountException();
        }
        return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
    }
}
