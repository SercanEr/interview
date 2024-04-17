package dev.sercaner.interview.controllers;

import java.time.LocalDateTime;

public record UserResponse(String firstName,
                           String lastName,
                           LocalDateTime createDate) {
}
