package cn.xuyue.firstshiro.service;

import org.springframework.stereotype.Component;

@Component
public interface UserService {
    String getPassword(String username);

    String getSalt(String username);
}
