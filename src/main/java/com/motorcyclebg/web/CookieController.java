package com.motorcyclebg.web;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


//Not using for now
@Controller
public class CookieController {

    private final static String LANG_COOKIE_NAME = "lang";
    private final static String DEFAULT_LANG = "en";

    @GetMapping("/cookies")
    public String cookies(@CookieValue(
            name = LANG_COOKIE_NAME,
            defaultValue = DEFAULT_LANG
    ) String lang, Model model) {

        model.addAttribute("lang", lang);

        return "cookies";
    }

    @PostMapping("/cookies")
    public String cookies(
            @RequestParam("language") String lang,
            HttpServletResponse response
    ){
        Cookie langCookie = new Cookie(LANG_COOKIE_NAME, lang);
        response.addCookie(langCookie);

        return "redirect:/cookies";
    }

}
