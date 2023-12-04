package com.example.P_P_3._spring_boot.service;


import com.example.P_P_3._spring_boot.model.User;

import java.util.List;

public interface UserService {
    User getUser(Integer id);

    List<User> getUsers();

    void createUser(User user);

    void updateUser(User user);

    void deleteUser(User user);
}