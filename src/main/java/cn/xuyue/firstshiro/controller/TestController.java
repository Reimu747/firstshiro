package cn.xuyue.firstshiro.controller;

import cn.xuyue.firstshiro.realm.MyRealm;
import cn.xuyue.firstshiro.service.UserService;
import cn.xuyue.firstshiro.util.SpringContextUtils;
import cn.xuyue.firstshiro.vo.User;
import org.apache.shiro.mgt.SecurityManager;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping("/test")
    public String testSpringUtil1() {
        //return SpringUtil.getBean("testDemo");
        String str = SpringContextUtils.getBean(UserService.class).toString();
        str += "\r\n";
        str += SpringContextUtils.getBean(JdbcTemplate.class);
        str += "\r\n";
        str += SpringContextUtils.getBean(TestController.class);
        str += "\r\n";
        str += SpringContextUtils.getBean(MyRealm.class);
        str += "\r\n";
        str += SpringContextUtils.getBean(SecurityManager.class);

        return str;
    }
}
