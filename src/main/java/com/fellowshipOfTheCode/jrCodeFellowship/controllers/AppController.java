package com.fellowshipOfTheCode.jrCodeFellowship.controllers;

import com.fellowshipOfTheCode.jrCodeFellowship.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;
import com.fellowshipOfTheCode.jrCodeFellowship.repository.AppRepository;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.Date;

@Controller
public class AppController {

 @Autowired
 AppRepository appRepository;

 @Autowired
 PasswordEncoder passwordEncoder;

 @Autowired
 private HttpServletRequest request;

    // get signup
    @GetMapping("/signup") public String getSignUpPage(){ return "signup";}

    // post signup
    @PostMapping("/signup") public RedirectView createUser(
            String username,
            String password,
            String firstname,
            String lastname,
            String dateofbirth,
            String bio) {
        String hashedPasswd = passwordEncoder.encode(password);

        // https://www.baeldung.com/java-string-to-date
        LocalDate localDataDOB = LocalDate.parse(dateofbirth);

        ApplicationUser newUser = new ApplicationUser(
                username,
                hashedPasswd,
                firstname,
                lastname,
                localDataDOB,
                bio);
        appRepository.save(newUser);
        authWithHttpServletRequest(username, password);

        return new RedirectView("/");
    }

    // get login
    @GetMapping("/login") public String getLoginPage(){ return "login";}

    // post login

    public void authWithHttpServletRequest(String username, String password) {
        try {
            request.login(username, password);
        } catch (ServletException se) {
            System.out.println("Error: Unable to login this user.");
            // from the codefellows class repo
            se.printStackTrace();
        }
    }
}
