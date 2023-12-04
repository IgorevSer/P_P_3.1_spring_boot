package com.example.P_P_3._spring_boot.controller;

import com.example.P_P_3._spring_boot.model.User;
import com.example.P_P_3._spring_boot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/create")
    public String createUser(@RequestParam(value = "name") String name,
                             @RequestParam(value = "surname") String surname,
                             @RequestParam(value = "age") Integer age,
                             ModelMap model) {
        userService.createUser(new User(name, surname, age));
        model.addAttribute("name", name);
        model.addAttribute("surname", surname);
        model.addAttribute("age", age);
        return "usercreated";
    }

    @GetMapping(value = "/get")
    public String getUserById(@RequestParam(value = "id") Integer id, ModelMap model) {
        User user = userService.getUser(id);
        if (user == null) {
            return "notfound";
        }
        model.addAttribute("user", user);
        return "userinfo";
    }

    @GetMapping(value = "/getall")
    public String getUsers(ModelMap model) {
        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        return "allusers";
    }

    @GetMapping(value = "/")
    public String home() {
        return "forward:/getall";
    }

    @PostMapping(value = "/update")
    public String updateUser(@RequestParam(value = "id") Integer id,
                             @RequestParam(value = "name") String name,
                             @RequestParam(value = "surname") String surname,
                             @RequestParam(value = "age") Integer age) {
        User user = userService.getUser(id);
        if (user == null) {
            return "notfound";
        }
        user.setName(name);
        user.setSurname(surname);
        user.setAge(age);
        userService.updateUser(user);
        return "userupdated";
    }

    @PostMapping(value = "/delete")
    public String deleteUser(@RequestParam(value = "id") Integer id) {
        User user = userService.getUser(id);
        if (user == null) {
            return "notfound";
        }
        userService.deleteUser(user);
        return "userdeleted";
    }
}
