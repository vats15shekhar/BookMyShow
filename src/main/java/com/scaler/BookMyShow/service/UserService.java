package com.scaler.BookMyShow.service;

import com.scaler.BookMyShow.model.User;
import com.scaler.BookMyShow.repository.UserRepository;

public class UserService {

    UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }
}
