package cn.iwangwei.user.support;

import cn.iwangwei.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findByCondition() {
        return null;
    }

    @Override
    public User addUser() {
        User user = new User(null, "wangwei02");
        userRepository.save(user);
        return user;
    }

    @Override
    public List<User> getByCondition(String username) {
        Map<String, String> params = new HashMap<>();
        params.put("userName", "wangwei02");

        User user = new User();
        user.setUserName(username);
        return userRepository.getAllByCondition(user);
    }
}
