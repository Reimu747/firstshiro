package cn.xuyue.firstshiro.shiro;

import cn.xuyue.firstshiro.realm.MyRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfiguration {
    @Bean
    public static LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    public static SecurityManager getSecurityManager(){
        DefaultWebSecurityManager defaultWebSecurityManager =
                new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(getRealm());
        return defaultWebSecurityManager;
    }

    @Bean
    public static MyRealm getRealm(){
        MyRealm myRealm = new MyRealm();
        myRealm.setCredentialsMatcher(getHashedCredentialsMatcher());
        return myRealm;
    }

    @Bean
    public static HashedCredentialsMatcher getHashedCredentialsMatcher(){
        HashedCredentialsMatcher h = new HashedCredentialsMatcher();
        h.setHashAlgorithmName("md5");
        h.setHashIterations(2);
        return h;
    }
}
