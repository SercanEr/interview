package dev.sercaner.interview.services;

import dev.sercaner.interview.controllers.CreateUserRequest;
import dev.sercaner.interview.controllers.UpdateUserRequest;
import dev.sercaner.interview.dataAccess.UserRepository;
import dev.sercaner.interview.entities.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    public User createUser(CreateUserRequest createUserRequest) {

        User user = new User();
        user.setId(null);
        user.setFirstName(createUserRequest.firstName().trim());
        user.setLastName(createUserRequest.lastName().trim());
        user.setRegisterDate(LocalDateTime.now());

        return userRepository.save(user);
    }


    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        return null;
    }

    public User update(Long id, UpdateUserRequest updateUserRequest) {
        Optional<User> resultUser = userRepository.findById(id);

        if (resultUser.isEmpty()) {
            log.info("User not found with id: {}", id);
            return null;
        }

        resultUser.get().setLastName(updateUserRequest.lastName());

        return userRepository.save(resultUser.get());
    }

    public Boolean deleteUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
