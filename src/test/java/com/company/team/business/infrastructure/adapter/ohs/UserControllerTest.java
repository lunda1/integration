package com.company.team.business.infrastructure.adapter.ohs;

import com.company.team.business.application.UserApplicationService;
import com.company.team.business.domain.model.entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserApplicationService userApplicationService;

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findByPathVariableId() throws Exception {
        int id = 1;
        String name = "name1";

        when(userApplicationService.findById(anyInt())).thenReturn(User.builder().id(id).name(name).build());

        mockMvc.perform(MockMvcRequestBuilders.get("/users/{id}", id).accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(jsonPath("$.data.id").value(id)).andExpect(jsonPath("$.data.name").value(name)).andReturn();
    }

    @Test
    void findByRequestParamId() throws Exception {
        int id = 1;
        String name = "name1";

        when(userApplicationService.findById(anyInt())).thenReturn(User.builder().id(id).name(name).build());

        mockMvc.perform(MockMvcRequestBuilders.get("/users").accept(MediaType.APPLICATION_JSON_VALUE).param("id", String.valueOf(id))).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(jsonPath("$.data.id").value(id)).andExpect(jsonPath("$.data.name").value(name)).andReturn();
    }

    @Test
    void findListByRequestParamId() throws Exception {
        int id = 1;
        String name = "name1";

        when(userApplicationService.findById(anyInt())).thenReturn(User.builder().id(id).name(name).build());

        String result = mockMvc.perform(MockMvcRequestBuilders.get("/users/list").accept(MediaType.APPLICATION_JSON_VALUE).param("id", String.valueOf(id))).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(jsonPath("$.data.length()").value(1)).andExpect(jsonPath("$.data[0].id").value(id)).andExpect(jsonPath("$.data[0].name").value(name)).andReturn().getResponse().getContentAsString();

        System.out.println("result: " + result);
    }

}