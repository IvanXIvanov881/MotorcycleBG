package com.motorcyclebg.web;

import com.motorcyclebg.model.user.MotorcyclebgUserDetails;
import com.motorcyclebg.service.HomeService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final HomeService homeService;

    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping("/")
    public String home(@AuthenticationPrincipal UserDetails userDetails,
                       Model model ) {

        if(userDetails instanceof MotorcyclebgUserDetails motorcyclebgUserDetails) {
            model.addAttribute("welcomeMessage", motorcyclebgUserDetails.getFullName());
        } else {
            model.addAttribute("welcomeMessage", "Guest");
        }

        model.addAttribute("allSummaries", homeService.getAllLastSummaries());
        return "index";
    }

}

//TODO Not use for now.
//        int someNumber = new Random().nextInt();
//        ModelAndView mnv = new ModelAndView();
//        mnv.setViewName("index");
//        mnv.addObject("TheNumber", someNumber);
//        //<span th:text="${TheNumber}"></span>