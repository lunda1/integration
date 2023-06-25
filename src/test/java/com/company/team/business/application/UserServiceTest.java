package com.company.team.business.application;

import com.company.team.business.domain.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    UserApplicationService userApplicationService;

    @Test
    void createUser() {
        User user1 = userApplicationService.createUser("name1");
        System.out.println("id: " + user1.getId());
        User byName1 = userApplicationService.findByName(user1.getName());
        assertEquals("name1", byName1.getName());

        User user2 = userApplicationService.createUser("name2");
        System.out.println("id: " + user2.getId());
        User byName2 = userApplicationService.findByName(user2.getName());
        assertEquals("name2", byName2.getName());
    }
}