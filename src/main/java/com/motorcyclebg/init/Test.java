//package com.motorcyclebg.init;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//@Component
//public class Test implements CommandLineRunner {
//
//    private final PasswordEncoder passwordEncoder;
//
//    public Test(PasswordEncoder passwordEncoder){
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Override
//    public void run(String... args) throws Exception{
//        String rawPassword = "topsecret";
//
//
//        String encodedPassword = passwordEncoder.encode(rawPassword);
//
//        System.out.println("PWD: " + encodedPassword);
//        System.out.println("Test password matches: " + passwordEncoder.matches("topsecret",encodedPassword));
//
//    }
//TODO Delete that test class
//}
