package dev.arzak21st.rolemanager.controllers;

import dev.arzak21st.rolemanager.models.Role;
import dev.arzak21st.rolemanager.models.User;
import dev.arzak21st.rolemanager.services.ManagerService;
import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ManagerController {

    @Autowired
    ManagerService managerService;

    @GetMapping("/manager")
    public String manager(Principal principal, Model model) {

        System.out.println();
        System.out.println(" ========== manager() ========== ");

        // Make sure that the USER is loggedin
        if(principal != null) {

            User loggedUser = managerService.findUserByUsername(principal.getName());
            if(loggedUser != null) {
                model.addAttribute("loggedUser", loggedUser);
            }
        }

        List<User> listUsers = managerService.findAllUsers();
        List<Role> listRoles = managerService.findAllRoles();

        model.addAttribute("listUsers", listUsers);
        model.addAttribute("listRoles", listRoles);

        return "manager";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute User user, Principal principal) {

        System.out.println();
        System.out.println(" ========== create() ========== ");

        // Make sure that the CREATOR is loggedin
        if(principal != null) {
            managerService.createUser(user);
        }
        return "redirect:/manager";
    }

    @GetMapping("/delete/{userId}")
    public String delete(@PathVariable int userId, Principal principal) {

        System.out.println();
        System.out.println(" ========== delete() ========== ");

        // Make sure that the DELETER is loggedin
        if(principal != null) {

            String username = principal.getName();
            managerService.deleteUser(userId, username);
        }
        return "redirect:/manager";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute User user, Principal principal) {

        System.out.println();
        System.out.println(" ========== update() ========== ");

        // Make sure that the UPDATOR is loggedin
        if(principal != null) {
            managerService.updateUser(user);
        }
        return "redirect:/manager";
    }
}