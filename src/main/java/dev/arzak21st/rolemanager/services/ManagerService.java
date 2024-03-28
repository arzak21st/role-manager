package dev.arzak21st.rolemanager.services;

import dev.arzak21st.rolemanager.models.Role;
import dev.arzak21st.rolemanager.models.User;
import dev.arzak21st.rolemanager.repositories.RoleRepository;
import dev.arzak21st.rolemanager.repositories.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    public User findUserByUsername(String username) {

        System.out.println();
        User user = userRepository.findByUsername(username);
        return user;
    }

    public List<User> findAllUsers() {

        System.out.println();
        List<User> users = userRepository.findAll();
        return users;
    }

    public List<Role> findAllRoles() {

        System.out.println();
        List<Role> roles = roleRepository.findAll();
        return roles;
    }

    public boolean createUser(User user) {

        System.out.println();
        User savedUser = userRepository.findByUsername(user.getUsername());
        if(savedUser == null) { // If the USER NOT exists

            System.out.println();
            userRepository.save(user);
            return true;
        }
        return false;
    }

    public boolean deleteUser(int userId, String username) {

        System.out.println();
        User savedUser = userRepository.findByUserId(userId);
        if(savedUser != null) { // If the USER exists

            if(!savedUser.getUsername().equals(username)) { // If the DELETER is NOT attemting to delete him/her self

                boolean savedUserIsAdmin = userIsAdmin(savedUser);
                if(!savedUserIsAdmin) { // If the USER to be deleted is NOT an ADMIN

                    userRepository.delete(savedUser);
                    return true;
                }
                else { // If the USER to be deleted is an ADMIN

                    boolean adminIsLonely = adminIsLonely();
                    if(!adminIsLonely) { // If this ADMIN is NOT the only remaining ADMIN (The application must haveat least 1 ADMIN)

                        userRepository.delete(savedUser);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean userIsAdmin(User savedUser) {

        List<Role> savedUserRoles = savedUser.getRoles();
        for(Role savedUserRole : savedUserRoles) {
            if(savedUserRole.getName().equals("ROLE_ADMIN")) {
                return true;
            }
        }
        return false;
    }

    private boolean adminIsLonely() {

        int adminsCount = userRepository.countByRolesName("ROLE_ADMIN");
        if(adminsCount > 1) {
            return false;
        }
        return true; // Sadly :(
    }

    public boolean updateUser(User user) {

        System.out.println();
        User savedUser = userRepository.findByUserId(user.getUserId());
        if(savedUser != null) { // If the USER exists

            savedUser.setFirstName(user.getFirstName());
            savedUser.setLastName(user.getLastName());
            savedUser.setActive(user.isActive());
            savedUser.setRoles(user.getRoles());

            System.out.println();
            userRepository.save(savedUser);
            return true;
        }
        return false;
    }
}
