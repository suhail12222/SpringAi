package com.suhail.learn_spring.Ai.SERVICE;

import com.suhail.learn_spring.Ai.Eceptions.UserNotFoundException;
import com.suhail.learn_spring.Ai.dto.User1dto;
import com.suhail.learn_spring.Ai.entities.User1;
import com.suhail.learn_spring.Ai.repositories.UserRepository1;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor
public class UserService {
    private final UserRepository1 userRepository1;
    private final ModelMapper modelMapper;

    public UserService(UserRepository1 userRepository1, ModelMapper modelMapper) {
        this.userRepository1 = userRepository1;
        this.modelMapper = modelMapper;
    }

    public User1dto createUser(User1dto user1dto) {
        User1 user=modelMapper.map(user1dto,User1.class);
User1 savedUser=userRepository1.save(user);
User1dto recivedOne=modelMapper.map(savedUser,User1dto.class);
return recivedOne;




    }

    public User1dto getUserById(Long id) {
      User1 saved=  userRepository1.findById(id).orElseThrow(()->new UserNotFoundException("user with this id is not present"+id));
      User1dto refversed=modelMapper.map(saved,User1dto.class);
      return refversed;
    }
}
