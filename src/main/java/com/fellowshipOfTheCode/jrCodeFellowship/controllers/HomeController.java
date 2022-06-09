package com.fellowshipOfTheCode.jrCodeFellowship.controllers;

import com.fellowshipOfTheCode.jrCodeFellowship.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.fellowshipOfTheCode.jrCodeFellowship.repository.AppRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

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

    @GetMapping("/user/{id}")
    public String getUserInfo(Principal principal, Model springModel, @PathVariable Long id) {
        // session info ??
        if (principal != null) {
            String username = principal.getName();
            ApplicationUser applicationUser = appRepository.findByUsername(username);

            // store authenticated username for thymeleaf
            springModel.addAttribute("username",username);
        }

        // get user info from DB
        ApplicationUser applicationUser = appRepository.findById(id).orElseThrow();

        // set thymeleaf attributes for an authenticated user's display data (for a null user??)
        springModel.addAttribute("appUsername", applicationUser.getUsername());
        springModel.addAttribute("appUserId", applicationUser.getId());

        // return the name of the template to load
        return "/userprofile"; // alex used user-info
    }

    // custom http 404 response code
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public class ResourceNotFoundException extends RuntimeException {
        ResourceNotFoundException(String message) { super(message); }
    }
}
