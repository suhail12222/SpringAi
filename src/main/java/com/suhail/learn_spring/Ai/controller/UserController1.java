package com.suhail.learn_spring.Ai.controller;

import com.suhail.learn_spring.Ai.SERVICE.UserService;
import com.suhail.learn_spring.Ai.dto.User1dto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import javax.validation.Valid;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/user1")
//@RequiredArgsConstructor
public class UserController1 {
    private final UserService userService;

    public UserController1(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    public ResponseEntity<User1dto> createUser(@Valid @RequestBody User1dto user1dto){
//    User1dto user=userService.createUser(user1dto);
//    return new ResponseEntity<>(user,HttpStatus.CREATED);

    return ResponseEntity.ok(userService.createUser(user1dto) );
    }

@GetMapping("/{id}")
    public ResponseEntity<User1dto> getUserById(@PathVariable Long id){
    User1dto saved=userService.getUserById(id);
    return new ResponseEntity<>(saved,HttpStatus.NOT_FOUND);
    
}
}
