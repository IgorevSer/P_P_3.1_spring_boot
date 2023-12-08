package com.example.P_P_3._spring_boot.dao;


import com.example.P_P_3._spring_boot.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUser(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> getAll() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void delete(long id) {
        Query q = entityManager.createQuery("delete from User where id=:id");
        q.setParameter("id", id);
        q.executeUpdate();
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }
}

