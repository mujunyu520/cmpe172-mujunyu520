package com.example.springcashier;

import com.example.springcashier.user.UserData;
import com.example.springcashier.user.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserDataRepository userDataRepository;



    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserData userData = userDataRepository.findByUsername(username);

        if (userData == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new UserDetails(userData);
    }

}