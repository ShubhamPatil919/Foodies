package com.food.config;


import com.food.entity.Admin;
import com.food.repo.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomAdminDetailsImpl implements UserDetailsService {

    @Autowired
    private AdminRepo adminRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Admin adminStyle=adminRepo.getUserByEmail(email);
        if(adminStyle==null) {
            throw new UsernameNotFoundException("User Not Found!");
        }
         CustomAdminDetails customAdminDetails=new CustomAdminDetails(adminStyle);
        return customAdminDetails;
    }
}

