package com.example.ordersApp.Controller;

import com.example.ordersApp.Service.UserService;
import com.example.ordersApp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){  //<----Constructor of this Service (userService)
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<?> findAllUsers() {
        return new ResponseEntity<List<User>>(userService.findAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<User> userOpt = userService.findUserById(id);

        if (userOpt.isPresent()) {
            return new ResponseEntity<User>(userOpt.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND) ;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Validated @RequestBody User user){
        userService.add(user);

        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<User> optionalUser = userService.deleteUser(id);

        if (optionalUser.isPresent()){
            return new ResponseEntity<User>(optionalUser.get(), HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody User user){
        Optional<User> optionalUser = userService.updateUser(user);

        if (optionalUser.isPresent()){
            return new ResponseEntity<User>(optionalUser.get(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }
}
