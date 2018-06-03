package cn.iwangwei.auth;

import cn.iwangwei.support.MdService;
import com.xkw.mdm.dto.UserInfo;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class RestUserAuthRealm extends AuthorizingRealm {

    @Autowired
    private MdService mdService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {


        String userName = (String) principals.getPrimaryPrincipal();
        if (!StringUtils.isEmpty(userName)) {
            UserInfo userInfo = mdService.getUserInfo(userName);
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            info.addRoles(userInfo.getInfo().getAuthz().getRoles());
            info.addStringPermissions(userInfo.getInfo().getAuthz().getPermissions());
            return info;
        }
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        return new SimpleAuthenticationInfo(usernamePasswordToken.getUsername(), usernamePasswordToken.getPassword(), usernamePasswordToken.getUsername());
//        return new RestAuthenticationInfo(((UsernamePasswordToken)token).getUsername(), getName());
    }
}
