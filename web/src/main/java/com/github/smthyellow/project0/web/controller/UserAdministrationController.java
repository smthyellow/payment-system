package com.github.smthyellow.project0.web.controller;

import com.github.smthyellow.project0.model.AuthUser;
import com.github.smthyellow.project0.model.User;
import com.github.smthyellow.project0.service.accountService.AccountService;
import com.github.smthyellow.project0.service.authUserService.AuthUserService;
import com.github.smthyellow.project0.service.userService.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/userAdministration")
public class UserAdministrationController {

    private final UserService userService;
    private final AuthUserService authUserService;

    public UserAdministrationController(UserService userService, AuthUserService authUserService) {
        this.userService= userService;
        this.authUserService = authUserService;
    }

    @GetMapping()
    public String get(HttpServletRequest rq){
        AuthUser authUser = (AuthUser) rq.getSession().getAttribute("authUser");
        User user = userService.getUserByAuthUserId(authUser.getAuthUserId());
        rq.getSession().setAttribute("fullUserName", user.getFullName());
        return "userAdministration";
    }

    @PostMapping()
    public String post(HttpServletRequest rq){
        String email = rq.getParameter("email");
        AuthUser subAuthUser = authUserService.getByEmail(email);
        if (subAuthUser == null){
            rq.setAttribute("error", "No user with this email");
            return "userAdministration";
        } else {
            User user = userService.getUserByAuthUserId(subAuthUser.getAuthUserId());
            String role = subAuthUser.getRole().toString();
            rq.getSession().setAttribute("role", role);
            rq.getSession().setAttribute("user", user);
            rq.getSession().setAttribute("subAuthUser", subAuthUser);
            return "userAdministration";
        }
    }

}
