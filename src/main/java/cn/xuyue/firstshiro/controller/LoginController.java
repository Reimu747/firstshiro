package cn.xuyue.firstshiro.controller;

import cn.xuyue.firstshiro.service.UserService;
import cn.xuyue.firstshiro.vo.User;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private SecurityManager securityManager;
    @Autowired
    private UserService userService;


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(User u) {
        System.out.println("进入/login");
        System.out.println(u.getUsername());
        System.out.println(u.getPassword());

        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();

        //System.out.println(securityManager);
        System.out.println(userService);


        UsernamePasswordToken usernamePasswordToken =
                new UsernamePasswordToken(u.getUsername(), u.getPassword());

        try {
            subject.login(usernamePasswordToken);
            Session s = subject.getSession();
            s.setAttribute("subject", subject);
        } catch (AuthenticationException e) {
            return "error";
        }

        return "succ1";
    }
}
