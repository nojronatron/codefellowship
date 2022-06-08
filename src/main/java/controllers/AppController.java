package controllers;

import com.fellowshipOfTheCode.jrCodeFellowship.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;
import repository.AppRepository;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Controller
public class AppController {

 @Autowired
 AppRepository appRepository;

 @Autowired PasswordEncoder passwordEncoder;

 @Autowired private HttpServletRequest request;

    // get signup
    @GetMapping("/signup") public String getSignUpPage(){ return "signup";}

    // post signup
    @PostMapping("/signup") public RedirectView createUser(String username, String password) {
        String hashedPasswd = passwordEncoder.encode(password);
        ApplicationUser newUser = new ApplicationUser(username, hashedPasswd);
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
