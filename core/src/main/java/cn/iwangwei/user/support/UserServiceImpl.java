package cn.iwangwei.user.support;

import cn.iwangwei.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

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
}
