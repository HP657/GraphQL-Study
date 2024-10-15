package com.GraphQL.HP657.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @MutationMapping
    public User createUser(@Argument(name = "username") String username, @Argument(name = "email") String email) {
        return userService.createUser(username, email);
    }

    @QueryMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @QueryMapping
    public User getUserById(@Argument(name = "id") Long id) {
        return userService.getUserById(id).orElse(null);
    }

    @MutationMapping
    public void deleteUser(@Argument(name = "id") Long id) {
        userService.deleteUser(id);
    }
}
