package com.example.P_P_3._spring_boot.controller;

import com.example.P_P_3._spring_boot.model.User;
import com.example.P_P_3._spring_boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String getAllUsers(ModelMap modelMap) {
        modelMap.addAttribute("users", userService.getAll());
        return "users";
    }


    @GetMapping("/newUser")
    public String getCreationUserForm(ModelMap modelMap) {
        User user = new User();
        modelMap.addAttribute("user", user);
        return "new";
    }

    @PostMapping("/saveUser")
    public String saveNewUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/";
    }

    @PostMapping("/updateUser")
    public String getUpdateUserForm(ModelMap modelMap, @RequestParam("userId") long id) {
        modelMap.addAttribute("user", userService.getUser(id));
        return "update";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user, @RequestParam("userId") long id) {
        user.setId(id);
        userService.update(user);
        return "redirect:/";
    }

    @PostMapping("/deleteUser")
    public String deleteUserById(@RequestParam("userId") long id) {
        userService.delete(id);
        return "redirect:/";
    }
}
