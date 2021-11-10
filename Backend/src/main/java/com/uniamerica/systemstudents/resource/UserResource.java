package com.uniamerica.systemstudents.resource;


import com.uniamerica.systemstudents.entity.User;
import com.uniamerica.systemstudents.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class UserResource {

    @Autowired
    private UserRepository eRepo;

    @GetMapping("/contactos")
    public List<User> getAllUsers() {
        return eRepo.findAll();
    }

    @GetMapping("/contactos/{id}")
    public User getUserById(@PathVariable Long id) {
        return eRepo.findById(id).get();

    }

    @PostMapping("/contactos")
    public User saveUserDetails(@RequestBody User user) {
        return eRepo.save(user);
    }

    @PutMapping("/contactos")
    public User updateUser(@RequestBody User user) {
        return eRepo.save(user);
    }

    @DeleteMapping("/contactos/{id}")
    public ResponseEntity<HttpStatus> deleteUserById(@PathVariable Long id) {
        eRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
