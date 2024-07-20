package com.motorcyclebg.web;

import com.motorcyclebg.model.dto.UserDetailsDTO;
import com.motorcyclebg.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {


    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }



    @GetMapping("/users/{id}")
    public String userDetails(@PathVariable("id") Long id,
                                   Model model) {

       UserDetailsDTO userDetailsDTO = adminService.getUserDetails(id);
        model.addAttribute("userDetails", userDetailsDTO);

        return "user-details";
    }

    @DeleteMapping("/users/{id}")
    public String deleteParts(@PathVariable("id") Long id) {

        adminService.deleteUser(id);

        return "redirect:/admin/users";
    }

    @GetMapping("/users")
    public String getAllUsers(Model model) {

        model.addAttribute("allUsers", adminService.getAllUsersSummary());
        return "users";
    }


}
