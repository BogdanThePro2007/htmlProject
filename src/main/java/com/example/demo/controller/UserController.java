package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        System.out.println("Метод контроллера createUser получает userDTO: " + userDTO);
        UserDTO createdUser = userService.saveUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
        System.out.println("Метод контроллера getUser получает id: " + id);
        UserDTO user = userService.getUser(id);
        return ResponseEntity.ok(user);
    }

    @PutMapping
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO) {
        System.out.println("Метод контроллера updateUser получает userDTO: " + userDTO);
        UserDTO updatedUser = userService.updateUser(userDTO);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        System.out.println("Метод контроллера deleteUser получает id: " + id);
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
