package com.example.Fitnes_Club.service;

import com.example.Fitnes_Club.dal.DataAccessLayer;
import com.example.Fitnes_Club.dto.SignupRequest;
import com.example.Fitnes_Club.models.User;
import com.example.Fitnes_Club.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final DataAccessLayer dataAccessLayer;

    @Autowired
    public UserDetailsServiceImpl(DataAccessLayer dataAccessLayer) {
        this.dataAccessLayer = dataAccessLayer;
    }
    public String newUser(SignupRequest signupRequest) {
        User user = new User();
        user.setName(signupRequest.getName());
        user.setEmail(signupRequest.getEmail());
        user.setPassword(signupRequest.getPassword());
        return dataAccessLayer.newUserToDatabase(user);
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = dataAccessLayer.getUserFromDatabaseByUsername(username);
        if (user == null) return null;
        return UserDetailsImpl.build(user);
    }
    public User loadUserEntityByUsername(String username) throws UsernameNotFoundException {
        return dataAccessLayer.getUserFromDatabaseByUsername(username);
    }
}
