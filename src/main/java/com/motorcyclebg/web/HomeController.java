package com.motorcyclebg.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.Random;

@Controller
public class HomeController {

    @GetMapping("/")
    public ModelAndView home() {

        //TODO Not use for now.
        int someNumber = new Random().nextInt();
        ModelAndView mnv = new ModelAndView();
        mnv.setViewName("index");
        mnv.addObject("TheNumber", someNumber);
        //<span th:text="${TheNumber}"></span>
        return mnv;
    }

}
