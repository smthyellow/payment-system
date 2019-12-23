package com.github.smthyellow.project0.web.controller;

import com.github.smthyellow.project0.service.authUserService.AuthUserService;
import com.github.smthyellow.project0.service.offerService.OfferService;
import com.github.smthyellow.project0.service.userService.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/offer")
public class OfferController {
    private final OfferService offerService;
    private final AuthUserService authUserService;

    public OfferController(OfferService offerService, AuthUserService authUserService) {
        this.offerService = offerService;
        this.authUserService = authUserService;
    }
}
