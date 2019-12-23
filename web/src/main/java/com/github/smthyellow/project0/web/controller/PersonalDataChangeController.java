package com.github.smthyellow.project0.web.controller;

import com.github.smthyellow.project0.model.AuthUser;
import com.github.smthyellow.project0.model.User;
import com.github.smthyellow.project0.service.authUserService.AuthUserService;
import com.github.smthyellow.project0.service.userService.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/personalDataChange")
public class PersonalDataChangeController {
    private final AuthUserService authUserService;
    private final UserService userService;

    public PersonalDataChangeController(AuthUserService authUserService, UserService userService) {
        this.authUserService = authUserService;
        this.userService = userService;
    }
    @GetMapping()
    public String get(HttpServletRequest rq) {
        AuthUser authUser = (AuthUser) rq.getSession().getAttribute("authUser");
        User user = userService.getUserByAuthUserId(authUser.getAuthUserId());
        rq.getSession().setAttribute("name", user.getFirstName());

        return "personalDataChange";
    }

    @PostMapping()
    public String post(HttpServletRequest rq){
        AuthUser authUser = (AuthUser) rq.getSession().getAttribute("authUser");
        String firstName = rq.getParameter("firstName");
        String lastName = rq.getParameter("lastName");
        String email = rq.getParameter("email");
        String phone = rq.getParameter("phone");
        String password = rq.getParameter("password");
        String confirmPassword = rq.getParameter("confirmPassword");
        String currentPassword = rq.getParameter("currentPassword");
        if(currentPassword.equals(authUser.getPassword())){
                if (password.equals(confirmPassword)){
                    authUserService.updateAuthUser(authUser.getAuthUserId(), firstName, lastName, email, phone, password);
                    rq.setAttribute("message", "Data saved successfully.");
                    return "personalDataChange";
                } else {
                    rq.setAttribute("message", "Passwords don't match.");
                    return "personalDataChange";
                }
        } else {
            rq.setAttribute("message", "Current password is incorrect.");
            return "personalDataChange";
        }
    }
}
