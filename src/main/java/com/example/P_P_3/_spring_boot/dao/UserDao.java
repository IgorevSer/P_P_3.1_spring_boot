package com.example.P_P_3._spring_boot.dao;


import com.example.P_P_3._spring_boot.model.User;

import java.util.List;

public interface UserDao {
        public User getUser(Integer id);

        public List<User> getUsers();

        public void createUser(User user);

        public void updateUser(User user);

        public void deleteUser(User user);
}
