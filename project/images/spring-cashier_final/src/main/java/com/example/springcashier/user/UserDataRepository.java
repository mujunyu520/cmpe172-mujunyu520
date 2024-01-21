package com.example.springcashier.user;


import com.example.springcashier.user.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDataRepository extends JpaRepository<UserData,Integer> {

    UserData findByUsername(String username);
}
