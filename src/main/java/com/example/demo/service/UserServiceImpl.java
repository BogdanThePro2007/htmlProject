package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDTO getUser(Long userId) {
        User user = repository.findById(userId).get();

        return UserDTO.builder()
                .id(user.getId())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        boolean isUserExisting = repository.existsById(userDTO.getId());
        if (isUserExisting) {
            User user = User.builder()
                    .id(userDTO.getId())
                    .email(userDTO.getEmail())
                    .password(userDTO.getPassword())
                    .build();

            User updatedUser = repository.save(user);

            return UserDTO.builder()
                    .id(updatedUser.getId())
                    .email(updatedUser.getEmail())
                    .password(updatedUser.getPassword())
                    .build();
        }
        else throw new RuntimeException("Пользователь не найден");
    }

    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        User newUser = User.builder()
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .build();
        System.out.println("Маппинг в пользователя " + newUser);
        User savedUser = repository.save(newUser);

        return UserDTO.builder()
                .id(savedUser.getId())
                .email(savedUser.getEmail())
                .password(savedUser.getPassword())
                .build();
    }

    @Override
    public void deleteUser(Long userId) {
        boolean isUserExisting = repository.existsById(userId);
        if (isUserExisting) {
            repository.deleteById(userId);
        }
    }
}
