package com.example.P_P_3._spring_boot.service;


import com.example.P_P_3._spring_boot.model.User;

import java.util.List;

public interface UserService {
    void add(User user);

    User getUser(long id);

    List<User> getAll();


    void delete(long id);

    void update(User user);
}