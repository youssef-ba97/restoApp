package com.example.ordersApp.Controller;

import com.example.ordersApp.Service.UserService;
import com.example.ordersApp.converter.UserConverter;
import com.example.ordersApp.dto.UserDto;
import com.example.ordersApp.model.User;
import com.example.ordersApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserConverter converter;

    @GetMapping("/findAll")
    public List<UserDto> findAll() {
        List<User> findAll = userRepository.findAll();
        return converter.entityToDto(findAll);
    }

    @GetMapping("/find/{ID}")
    public UserDto findById(@PathVariable(value = "ID") Long id) {
        User orElse = userRepository.findById(id).orElse(null);
        return converter.entityToDto(orElse);

    }

    @PostMapping("/add")
    public UserDto add(@RequestBody UserDto dto) {

        User user = converter.dtoToEntity(dto);
        user=  userRepository.save(user);
        return converter.entityToDto(user);
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
