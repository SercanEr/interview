package dev.sercaner.interview.controllers;

import dev.sercaner.interview.entities.User;
import dev.sercaner.interview.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UsersController {
    private UserService userService;
@PostMapping()
    public User createUser(@RequestBody User user){
    return this.userService.createUser(user);
    }
@GetMapping()
    public List<User> getUsers(){
    return this.userService.getUsers();
    }
@GetMapping("/{id}")
    public User getUser(@PathVariable() Long id){
    return this.userService.getUser(id);
    }
    @PutMapping("/{id}")
    public User update(@PathVariable() Long id,@RequestBody User user){
    return this.userService.update(id, user);
    }


}
        /* @get id
        public ResponseEntity<User> getUser(@PathVariable() Long id){
        User user = userService.getUser(id);
        return ResponseEntity.ok(user);
        */

        /*  @get
        public ResponseEntity<List<User>> getUsers(){
        List<User> users = userService.getUsers();
        return ResponseEntity.ok(users);
        */

        /*
        public ResponseEntity<User> createUser(@RequestBody User user){
        User resultUser = userService.createUser(user);
        return ResponseEntity.ok(resultUser);
         */