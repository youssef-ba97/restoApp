package com.example.ordersApp.converter;

import com.example.ordersApp.dto.UserDto;
import com.example.ordersApp.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserConverter {

    public UserDto entityToDto(User user){

        UserDto dto = new UserDto();
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setNum(user.getNum());
        dto.setAdresse(user.getAdresse());
        dto.setIsAdmin(user.getIsAdmin());
      //  dto.setCommande(user.getCommandes(user.getCommandes().size()-1));

        return dto;
    }

    public List<UserDto> entityToDto(List<User> user){
        return user.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
    }

    public User dtoToEntity(UserDto dto){

        User usr = new User();
        usr.setFirstName(dto.getFirstName());
        usr.setLastName(dto.getLastName());
        usr.setNum(dto.getNum());
        usr.setAdresse(dto.getAdresse());
        usr.setIsAdmin(dto.getIsAdmin());
        //  dto.setCommande(user.getCommandes(user.getCommandes().size()-1));

        return usr;
    }

    public List<User> dtoToEntity(List<UserDto> dto){
        return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }



}
