package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.exception.UserAlreadyExistsException;
import com.stackroute.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceimpl implements UserService {
    UserRepository userRepository;

    @Autowired
    public  UserServiceimpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public User saveUser(User user) throws UserAlreadyExistsException {
        if(userRepository.existsById(user.getId())){
            throw new UserAlreadyExistsException("user already exists exception");
        }
        User saveduser=userRepository.save(user);
        if(saveduser==null){
            throw new UserAlreadyExistsException("user already exists exception");
        }
        return saveduser;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
