package cn.iwangwei.user.support;

import cn.iwangwei.user.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    List<User> findByCondition();

    User addUser();

    List<User> getByCondition(String username);
}
