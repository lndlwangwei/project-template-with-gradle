package cn.iwangwei.user.support;

import cn.iwangwei.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor {

    //    @NamedNativeQuery(name = "UserRepository.getAllByCondition")
//    @Query(value = "select * FROM user u WHERE u.user_name = :#{#params.userName}", nativeQuery = true)
    List<User> getAllByCondition(@Param("params") User params);
}
