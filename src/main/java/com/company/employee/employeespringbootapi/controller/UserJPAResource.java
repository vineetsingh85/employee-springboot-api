package com.company.employee.employeespringbootapi.controller;

import com.company.employee.employeespringbootapi.entity.Post;
import com.company.employee.employeespringbootapi.entity.User;
import com.company.employee.employeespringbootapi.exception.UserNotFoundException;
import com.company.employee.employeespringbootapi.repository.PostRepository;
import com.company.employee.employeespringbootapi.repository.UserRepository;
import com.company.employee.employeespringbootapi.service.UserDaoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class UserJPAResource {

//    @Autowired
//    private UserDaoService userDaoService;

    private UserRepository userRepository;

    private PostRepository postRepository;

    @GetMapping("/jpa/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/jpa/users/{id}")
    public User getAllUsersById(@PathVariable Integer id) {
        Optional<User> response = userRepository.findById(id);
        if(!response.isPresent()){
            throw new UserNotFoundException("id:" + id);
        }else {
            return response.get();
        }
    }

    @PostMapping("/jpa/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = userRepository.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();

    }

    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userRepository.deleteById(id);
    }

    @GetMapping("/jpa/users/{id}/posts")
    public List<Post> getAllPostsForUser(@PathVariable Integer id) {
        Optional<User> response = userRepository.findById(id);
        if(!response.isPresent()){
            throw new UserNotFoundException("id:" + id);
        }
        return response.get().getPosts();
    }

    @GetMapping("/jpa/posts")
    public List<Post> getAllPosts() {
        List <Post> response = postRepository.findAll();
        if(response.isEmpty()){
            throw new UserNotFoundException("id:" + 1);
        }
        return response;
    }

    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity<Post> createPostForUser(@PathVariable int id, @Valid @RequestBody Post post) {
        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent()){
            throw new UserNotFoundException("id:" +id);
        }
        post.setUser(user.get());
        postRepository.save(post);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(post.getId())
                .toUri();
        return ResponseEntity.created(location).build();

    }
}