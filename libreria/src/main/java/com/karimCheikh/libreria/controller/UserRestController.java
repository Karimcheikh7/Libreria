package com.karimCheikh.libreria.controller;
;
import com.karimCheikh.libreria.entity.User;
import com.karimCheikh.libreria.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class UserRestController {

    private UserServiceImpl userServiceImpl;

    @Autowired
    public UserRestController(UserServiceImpl userService) {
        userServiceImpl = userService;
    }

    @GetMapping("/users")
    public List<User> findAll(){
        return userServiceImpl.findAll();
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        User userDb = userServiceImpl.save(user);
        return user;
    }

    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable int userId) {
        User user = userServiceImpl.findById(userId);

        if (user == null) {
            throw new RuntimeException("L'id dello user che hai messo non è presente: " + userId);
        }return user;
    }

    @GetMapping("/user/{userName}")
    public User getUserByName(@PathVariable String userName) {
        User user = userServiceImpl.findByUserName(userName);

        if (user == null) {
            throw new RuntimeException("Il nome dello user che hai messo non è corretto: " + userName);
        }return user;
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {
        User userDb = userServiceImpl.save(user);
        return userDb;
    }

    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable int userId){
        User userTemp = userServiceImpl.findById(userId);

        if (userTemp == null){
            throw new RuntimeException("L'id che hai ,esso non è presente: " + userId);
        }else userServiceImpl.deleteById(userId);

        return "Eliminato il libro con l'id: " + userId;

    }
}
