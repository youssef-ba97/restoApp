package com.example.ordersApp.Service.serviceImpl;

import com.example.ordersApp.Service.UserService;
import com.example.ordersApp.enums.Role;
import com.example.ordersApp.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    public static List<User> usersList = new ArrayList();

    private static Long COUNTER = 1L;

    static {
        User user = new User(COUNTER++, "Youssef", "ben abdallah", "ret3i@hotmail.com", Role.admin , 25333444, "25 rue xxxxxx ariana", "155azerty",null);
        usersList.add(user);


    }
    @Override
    public List<User> findAllUsers() {
        return usersList.stream().sorted(Comparator.comparing(User::getId)).collect(Collectors.toList());
    }


    @Override
    public Optional<User> findUserById(Long id) {
        return usersList.stream().filter(user -> user.getId() == id).findFirst();
    }

    @Override
    public Optional<User> deleteUser(Long id) {
        Optional<User> userOptional = usersList.stream().filter(user -> user.getId() == id).findFirst();

        if (userOptional.isPresent()){
            usersList = usersList.stream().filter(user -> user.getId() != userOptional.get().getId()).collect(Collectors.toList());
            return userOptional;
        }

        return Optional.empty();
    }

    @Override
    public Optional<User> updateUser(User user) {
        Optional<User> userOptional = usersList.stream().filter(u -> u.getId() == user.getId()).findFirst();

        if (userOptional.isPresent()){
            User existingUser = userOptional.get();

            if (user.getFirstName() != null){
                existingUser.setFirstName(user.getFirstName());
            }

            if (user.getLastName() != null){
                existingUser.setLastName(user.getLastName());
            }

            if (user.getEmail() != null){
                existingUser.setEmail(user.getEmail());
            }

            if (user.getRole() != null){
                existingUser.setRole(user.getRole());
            }

            if (user.getPassword() != null){
                existingUser.setPassword(user.getPassword());
            }



            usersList = usersList
                    .stream()
                    .filter(u -> u.getId() != existingUser.getId())
                    .collect(Collectors.toList());
            usersList.add(existingUser);

            return Optional.of(existingUser);
        }
        return Optional.empty();
    }

    @Override
    public void add(User user) {
        user.setId(COUNTER++);
        usersList.add(user);
    }


}
