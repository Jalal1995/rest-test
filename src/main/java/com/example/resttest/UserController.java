package com.example.resttest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PostMapping("/update/{id}")
    public User updateUser(@PathVariable long id,
                           @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @PostMapping("delete/{id}")
    public OperationStatusModel deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
        return OperationStatusModel.builder()
                .operationName("delete")
                .operationResult("success")
                .build();
    }

}
