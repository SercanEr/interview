package dev.sercaner.interview.controllers;

import jakarta.validation.constraints.NotBlank;

public record UpdateUserRequest(@NotBlank String lastName) {
}
