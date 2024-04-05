package dev.sercaner.interview.controllers;

import dev.sercaner.interview.entities.User;
import dev.sercaner.interview.services.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UsersController {

    @Autowired
    private UserService userService;

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User resultUser = userService.createUser(user);
        return ResponseEntity.ok(resultUser);
    }

    @GetMapping()
    public List<User> getUsers() {
        return this.userService.getUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable() Long id) {
        return this.userService.getUser(id);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable() Long id, @RequestBody User user) {
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

        /*@post
        public ResponseEntity<User> createUser(@RequestBody User user){
        User resultUser = userService.createUser(user);
        return ResponseEntity.ok(resultUser);
         */

        /*@post
        @PostMapping()
        @ResponseStatus(code = HttpStatus.CREATED)
       ResponseEntity<String> createUser(@Valid @RequestBody User user) {
            userService.createUser(user);
            return ResponseEntity.ok("");
         */
        /* @post
        public User createUser(@RequestBody User user) {
        return this.userService.createUser(user);
         */