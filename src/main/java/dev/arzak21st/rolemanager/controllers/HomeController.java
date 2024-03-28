package dev.arzak21st.rolemanager.controllers;

import dev.arzak21st.rolemanager.services.HomeService;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    HomeService homeService;

    @GetMapping(path = {"/", "/home"})
    public String home(Principal principal, Model model) {

        System.out.println();
        System.out.println(" ========== home() ========== ");

        homeService.createRoles();
        homeService.createAdminUser();

        if(principal != null) {
            model.addAttribute("principal", principal);
        }

        return "home";
    }
}
