package com.capgemini.project.microsevice_apigateway.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.project.microsevice_apigateway.models.CommonMan;
@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private User1Service us;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        CommonMan c=us.getDetails(s);
        List<SimpleGrantedAuthority> aa= new ArrayList<>();
        aa.add(new SimpleGrantedAuthority(c.getRole()));
        return new User(c.getUser_id(), c.getPassword(), aa);
    }
}