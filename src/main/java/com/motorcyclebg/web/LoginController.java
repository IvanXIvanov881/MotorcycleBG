package com.motorcyclebg.web;

import com.motorcyclebg.model.UserLoginDTO;
import com.motorcyclebg.service.UserService;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class LoginController {

    public final UserService userService;
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "auth-login";
    }

    @PostMapping("/login")
    public String login(UserLoginDTO userLoginDTO) {
        userService.login(userLoginDTO);
        return "redirect:/";
    }

    @PostMapping("/logout")
    public String logout(){
        userService.logout();
        return "redirect:/";
    }

}
