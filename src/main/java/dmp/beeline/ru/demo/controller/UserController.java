package dmp.beeline.ru.demo.controller;

import dmp.beeline.ru.demo.model.User;
import dmp.beeline.ru.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    ResponseEntity<User> getUser(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.getUser(userId));
    }
    @GetMapping("")
    ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping("/")
    ResponseEntity<User> saveUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @PutMapping("/{userId}")
    ResponseEntity<User> updateUser(@PathVariable Long userId,@RequestBody User user) {
        return ResponseEntity.ok(userService.update(userId, user));
    }

    @DeleteMapping("/{userId}")
    void deleteUser(@PathVariable Long userId) {
        userService.delete(userId);
    }

}
