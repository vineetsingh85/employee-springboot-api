package com.company.employee.employeespringbootapi.controller;

import com.company.employee.employeespringbootapi.entity.User;
import com.company.employee.employeespringbootapi.exception.UserNotFoundException;
import com.company.employee.employeespringbootapi.service.UserDaoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
public class UserResource {

    @Autowired
    private UserDaoService userDaoService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userDaoService.findAll();
    }

    @GetMapping("/users/{id}")
    public User getAllUsersById(@PathVariable Integer id) {
        User response = userDaoService
                .findAll()
                .stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
        if(response == null){
            throw new UserNotFoundException("id:" + id);
        }else return response;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = userDaoService.saveUser(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();

    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userDaoService.deleteUserById(id);
    }
}