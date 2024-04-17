package dev.sercaner.interview.controllers;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateUserRequest(@NotBlank @Size(max = 6) String firstName,
                                @NotBlank String lastName) {
}
