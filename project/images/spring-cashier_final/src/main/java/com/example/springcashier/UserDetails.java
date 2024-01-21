package com.example.springcashier;

import com.example.springcashier.user.UserData;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class UserDetails implements org.springframework.security.core.userdetails.UserDetails {

    private UserData userData;
    public UserDetails(UserData userData) {
        this.userData = userData;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return userData.getPassword();
    }

    @Override
    public String getUsername() {
        return userData.getUsername();
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
        return true;
    }

}
