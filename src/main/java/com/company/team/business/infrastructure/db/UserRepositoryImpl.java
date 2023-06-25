package com.company.team.business.infrastructure.db;

import com.company.team.business.domain.model.entity.User;
import com.company.team.business.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * 仓储实现类需要依赖于具体实现，所以放到 infrastructure 目录下，此处引入了 JPA 默认实现
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    UserJpaRepository userJpaRepository;

    public User findByName(String name) {
        return userJpaRepository.findByName(name);
    }

    @Override
    public User save(User user) {
        return userJpaRepository.save(user);
    }

    @Override
    public Optional<User> findById(Integer id) {
        return userJpaRepository.findById(id);
    }
}
