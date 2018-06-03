package cn.iwangwei.controller;

import cn.iwangwei.user.User;
import cn.iwangwei.user.support.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{name}")
    public List<User> getUsers(@PathVariable String name) {
        return userService.getByCondition(name);
    }
}
