package org.example.Controller;

import org.example.Service.UserService;
import org.example.domain.Task;
import org.example.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class UserController {
	private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/users")
    public List<User> getAllUsers() {
        List<User> users = userService.getAllUser();
        return users;
    }
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable int id) {
        User user= userService.findUserById(id);
        return user;
    }
    @PostMapping("/user")
    public User createUser(@RequestBody User user) {

        userService.addUser(user);

        return user;
    }
    @DeleteMapping("/user/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return new ResponseEntity<User>(HttpStatus.OK);
    }
    @PutMapping("/user/{id}")
    public String updateCountry(@RequestBody User user ) {
        try {
            userService.updateUser(user);
            return "UPDATED";
        } catch (Exception e) {
            return "ID NOT EXIST";
        }
    }
    
    @GetMapping("/task/{id}")
    public ResponseEntity<List<Task>> getTaskByUserId(@PathVariable long id){
    		return new ResponseEntity<List<Task>>(userService.getTasksByUserId(id), HttpStatus.OK) ;
    }
    

    }
