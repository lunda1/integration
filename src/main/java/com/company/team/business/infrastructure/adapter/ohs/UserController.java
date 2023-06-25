package com.company.team.business.infrastructure.adapter.ohs;

import com.company.team.business.application.UserApplicationService;
import com.company.team.business.common.Result;
import com.company.team.business.domain.model.entity.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
@Validated
@RequiredArgsConstructor
@Slf4j
@Tag(name = "UserController")
public class UserController {

    @Resource
    UserApplicationService userApplicationService;

    @GetMapping("/{id}")
    @Operation(summary = "findByPathVariableId")
    public Result<User> findByPathVariableId(@PathVariable Integer id) {
        return Result.success(userApplicationService.findById(id));
    }

    @GetMapping
    @Operation(summary = "findByRequestParamId")
    public Result<User> findByRequestParamId(@RequestParam Integer id) {
        return Result.success(userApplicationService.findById(id));
    }

    @GetMapping("/list")
    @Operation(summary = "findListByRequestParamId")
    public Result<List<User>> findListByRequestParamId(@RequestParam Integer id) {
        return Result.success(Arrays.asList(userApplicationService.findById(id)));
    }

    @PostMapping
    public Result<User> createUser(@RequestBody String name) {
        if ("test".equals(name)) {
            throw new RuntimeException("name is test!");
        }
        return Result.success(userApplicationService.createUser(name));
    }
}
