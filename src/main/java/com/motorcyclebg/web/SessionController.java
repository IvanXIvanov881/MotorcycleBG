package com.motorcyclebg.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SessionController {

    private final static String DEFAULT_LANG= "en";

    @GetMapping("/session")
    public String session(Model model){

        model.addAttribute("lang", DEFAULT_LANG);

        return "session";
    }
}
