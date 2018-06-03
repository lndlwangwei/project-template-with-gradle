package cn.iwangwei.controller;

import cn.iwangwei.user.User;
import cn.iwangwei.user.support.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class TestController {

    @Autowired
    private UserService userService;

    @RequestMapping
    public List<User> getAll() {

        return userService.getAll();
    }

    @PostMapping
    public User addUser() {
        return userService.addUser();
    }
}
