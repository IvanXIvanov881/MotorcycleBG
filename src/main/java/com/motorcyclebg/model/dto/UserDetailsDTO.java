package com.motorcyclebg.model.dto;

public record UserDetailsDTO(
        Long id,
        String email,
        String firstName,
        String lastName
) {
}
