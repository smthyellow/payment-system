package com.github.smthyellow.project0.web.controller;

import com.github.smthyellow.project0.model.AuthUser;
import com.github.smthyellow.project0.model.User;
import com.github.smthyellow.project0.service.authUserService.AuthUserService;
import com.github.smthyellow.project0.service.userService.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping
public class RegistrationController {
    private static final Logger log = LoggerFactory.getLogger(RegistrationController.class);
    private final AuthUserService authUserService;
    private final UserService userService;

    public RegistrationController(AuthUserService authUserService, UserService userService) {
        this.authUserService = authUserService;
        this.userService = userService;
    }


    @GetMapping("/registration")
    public String registration(HttpSession session){
        Object authUser = session.getAttribute("authUser");
        if (authUser != null) {
            return "personalPage";
        }
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(HttpServletRequest rq) {
        AuthUser authUser = new AuthUser();
        User user = new User();
        String firstName = rq.getParameter("firstName");
        String lastName = rq.getParameter("lastName");
        String email = rq.getParameter("email");
        String phone = rq.getParameter("phone");
        String password = rq.getParameter("password");
        String confirmPassword = rq.getParameter("confirmPassword");
        Boolean passwordMatch = password.equals(confirmPassword);
        AuthUser checkAuthUser = authUserService.checkExistence(email);

        if (checkAuthUser != null) {
            rq.setAttribute("error", "A user with this email already exists.");
            return "registration";
        } else if (passwordMatch == false){
            rq.setAttribute("error", "Passwords don't match");
            return "registration";
        }

        Long id  = authUserService.totalSaveAuthUser(firstName, lastName, email, phone, password);
        log.info("user {} logged", authUser.getEmail());
        rq.getSession().setAttribute("authUser", authUser);

        return "personalPage";
    }
}
