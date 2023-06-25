package com.company.team.business.domain.repository;

import com.company.team.business.domain.model.entity.User;

import java.util.Optional;

/**
 * 此处的repository为领域模型中的仓储概念，领域模型面向仓储接口变成，仓储具体实现在infrastructure目录下
 */
public interface UserRepository {
    User findByName(String name);

    User save(User user);

    Optional<User> findById(Integer id);
}
