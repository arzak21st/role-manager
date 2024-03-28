package dev.arzak21st.rolemanager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {

        System.out.println();
        System.out.println(" ========== login() ========== ");

        return "login";
    }
}
