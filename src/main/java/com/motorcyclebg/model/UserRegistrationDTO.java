package com.motorcyclebg.model;

public record UserRegistrationDTO(String firstName,
                                  String lastName,
                                  String password,
                                  String email) {
}
