package com.motorcyclebg.model.dto;

import com.motorcyclebg.vallidation.annotation.FieldsMatch;
import com.motorcyclebg.vallidation.annotation.UniqueEmail;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@FieldsMatch(first = "password",
        second = "confirmPassword")

public class UserRegistrationDTO {

    @Size(message = "{add.first.name.size}", min = 1, max = 50)
    @NotBlank(message = "{add.first.name.cannot.be.not.empty}")
    private String firstName;
    @Size(message = "{add.last.name.size}", min = 1, max = 50)
    @NotBlank(message = "{add.last.name.cannot.be.not.empty}")
    private String lastName;
    @NotBlank(message = "{add.password.cannot.be.not.empty}")
    private String password;
    @NotBlank(message = "{add.password.cannot.be.not.empty}")
    private String confirmPassword;
    @NotBlank(message = "{add.email.cannot.be.not.empty}")
    @Email
    @UniqueEmail
    private String email;

    public String getFirstName() {
        return firstName;
    }

    public UserRegistrationDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserRegistrationDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegistrationDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegistrationDTO setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegistrationDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public String toString() {
        return "UserRegistrationDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + (password != null ? "N/A" : "[PROVIDED]") + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}
