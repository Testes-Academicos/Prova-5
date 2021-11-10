package com.uniamerica.systemstudents.resource;


import com.uniamerica.systemstudents.entity.User;
import com.uniamerica.systemstudents.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class UserResource {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/all")
    public List<User> GetUsers() {
        return userRepository.findAll();
    }
    @GetMapping("/{id}")
    public User GetUser(@PathVariable Long id) {
        return userRepository.findById(id).orElse(null);
    }
    @PostMapping("/created")
    public User PostUser(@RequestBody User user) {
        return userRepository.save(user);
    }
    @PutMapping("/updated")
    public User PutUser(@RequestBody User user) {
        User oldUser = userRepository.findById(user.getId()).orElse(null);
        oldUser.setName(user.getName());
        oldUser.setEmail(user.getEmail());
        oldUser.setPassword(user.getPassword());
        oldUser.setTelefone(user.getTelefone());
        return userRepository.save(oldUser);
    }
    @DeleteMapping("/{id}")
    public Long DeleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return id;
    }


}
