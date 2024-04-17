package dev.sercaner.interview.controllers;

import dev.sercaner.interview.entities.User;
import dev.sercaner.interview.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse createUser(@RequestBody @Valid CreateUserRequest createUserRequest) {
        User savedUser = userService.createUser(createUserRequest);

        return new UserResponse(
                savedUser.getFirstName(),
                savedUser.getLastName(),
                savedUser.getRegisterDate()
        );
    }

    @GetMapping()
    public List<User> getUsers() {
        return this.userService.getUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return this.userService.getUser(id);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody UpdateUserRequest user) {
        return this.userService.update(id, user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable Long id) {
        Boolean status = userService.deleteUser(id);
        return ResponseEntity.ok(status);
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