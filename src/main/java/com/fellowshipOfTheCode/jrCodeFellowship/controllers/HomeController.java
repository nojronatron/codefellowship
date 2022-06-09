package com.fellowshipOfTheCode.jrCodeFellowship.controllers;

import com.fellowshipOfTheCode.jrCodeFellowship.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.fellowshipOfTheCode.jrCodeFellowship.repository.AppRepository;
import java.security.Principal;

@Controller
public class HomeController {

    @Autowired
    AppRepository appRepository;

    @GetMapping("/") public String getHomepage(Principal principal, Model springModel) {
        if (principal != null) {
            String username = principal.getName();

            ApplicationUser applicationUser = appRepository.findByUsername(username);

            // add attributes that thymeleaf can use to use on the redirectview template
            springModel.addAttribute("appuser", applicationUser);
        }

        return "index";
    }
}
