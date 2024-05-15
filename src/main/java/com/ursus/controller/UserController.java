package com.ursus.controller;

import com.ursus.model.User;
import com.ursus.model.dto.UserDto;
import com.ursus.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class UserController {
    private final UserService userService;
    private final UserDetailsService userDetailsService;

    public UserController(UserService userService, UserDetailsService userDetailsService) {
        this.userService = userService;
        this.userDetailsService = userDetailsService;
    }

    @GetMapping("/home")
    public String home(Model model, Principal principal) {
        // we use principal interface to get information about authenticated user
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("userDetail", userDetails); // name of the person who accessed the dashboard
        return "home";
    }

    @GetMapping("/login")
    public String login(Model model,UserDto userDto) {
        model.addAttribute("userDto", userDto);
        return "login";
    }
    @GetMapping("/register")
    public String register(Model model,UserDto userDto) {
        model.addAttribute("userDto", userDto);
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("userDto") UserDto userDto, Model model) {
        User user = userService.findByUsername(userDto.getUsername());
        if(user != null) {
            model.addAttribute("userExists", true);
            return "register";
        }
        userService.save(userDto);
        model.addAttribute("registerSuccess", true);
        return "register";
    }
}
