package com.example.demo.service;

import com.example.demo.dto.UserDTO;

public interface UserService {
    UserDTO getUser(Long userId);
    UserDTO updateUser(UserDTO userDTO);
    UserDTO saveUser(UserDTO userDTO);
    void deleteUser(Long userId);
}
