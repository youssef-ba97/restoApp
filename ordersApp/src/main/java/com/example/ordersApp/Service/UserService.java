package com.example.ordersApp.Service;

import com.example.ordersApp.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

    public List<User> findAllUsers();

    public Optional<User> findUserById(Long id);

    public Optional<User> deleteUser(Long id);

    public Optional<User> updateUser(User user);

    public void add(User user);
}
