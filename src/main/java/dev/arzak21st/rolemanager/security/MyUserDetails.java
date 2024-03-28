package dev.arzak21st.rolemanager.security;

import dev.arzak21st.rolemanager.models.Role;
import dev.arzak21st.rolemanager.models.User;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails implements UserDetails {

    private User user;

    public MyUserDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        List<Role> roles = user.getRoles();

        for(Role role : roles) {

            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(role.getName()); // Converts an authority of type String into the type GrantedAuthority
            simpleGrantedAuthorities.add(simpleGrantedAuthority); // Adds the converted authority to a Collection of GrantedAuthority
        }

        return simpleGrantedAuthorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return user.isActive();
    }
}
