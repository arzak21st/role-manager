
package dev.arzak21st.rolemanager.security;

import dev.arzak21st.rolemanager.models.User;
import dev.arzak21st.rolemanager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException("Could not find a user with the username: " + username);
        }

        MyUserDetails myUserDetails = new MyUserDetails(user); // Converts our User object into a UserDetails object that Spring Security can recognize
        return myUserDetails;
    }
}
