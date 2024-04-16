package dev.sercaner.interview.dataAccess;

import dev.sercaner.interview.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
