package dev.arzak21st.rolemanager.services;

import dev.arzak21st.rolemanager.models.Role;
import dev.arzak21st.rolemanager.models.User;
import dev.arzak21st.rolemanager.repositories.RoleRepository;
import dev.arzak21st.rolemanager.repositories.UserRepository;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    public void createRoles() {

        System.out.println();
        List<Role> savedRoles = roleRepository.findAll();
        if(savedRoles.size() == 0) {

            Role role1 = new Role();
            role1.setName("ROLE_ADMIN");

            Role role2 = new Role();
            role2.setName("ROLE_CREATOR");

            Role role3 = new Role();
            role3.setName("ROLE_UPDATER");

            Role role4 = new Role();
            role4.setName("ROLE_DELETER");

            List<Role> roles = Arrays.asList(role1, role2, role3, role4);
            roles.forEach((role) -> roleRepository.save(role));
        }
    }

    public void createAdminUser() {

        System.out.println();
        List<Role> savedRoles = roleRepository.findRolesByName("ROLE_ADMIN");
        if(savedRoles != null) {

            User savedUser = userRepository.findByUsername("admin");
            if(savedUser == null) {

                User user = new User();
                user.setFirstName("Wassim");
                user.setLastName("Arzak");
                user.setUsername("admin");
                user.setPassword("4869");
                user.setActive(true);
                user.setRoles(savedRoles);

                System.out.println();
                userRepository.save(user);
            }
        }
    }

}
