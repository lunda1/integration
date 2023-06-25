package com.company.team.business.domain.service;

import com.company.team.business.domain.model.entity.User;
import com.company.team.business.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 领域服务用于处理不适合在领域对象上处理的逻辑，或者跨领域对象和值对象的处理
 */
@Service
public class UserDomainService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(String name) {
        User user = new User();
        user.setName(name);
        return userRepository.save(user);
    }

    public User findByName(String name) {
        return userRepository.findByName(name);
    }

    public User findById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }
}

