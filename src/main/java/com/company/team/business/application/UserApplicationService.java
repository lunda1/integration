package com.company.team.business.application;

import com.company.team.business.domain.model.entity.User;
import com.company.team.business.domain.repository.UserRepository;
import com.company.team.business.domain.service.UserDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * application的服务负责编排服务调用（例如通过acl调用外部服务，调用领域服务）
 */
@Service
public class UserApplicationService {

    @Autowired
    UserDomainService userDomainService;

    @Autowired
    UserRepository userRepository;

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

