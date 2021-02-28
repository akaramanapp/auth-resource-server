package com.abacus.project.authserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.abacus.project.authserver.dao.OAuthDAOService;
import com.abacus.project.authserver.model.CustomUser;
import com.abacus.project.authserver.model.UserEntity;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    OAuthDAOService oauthDAOService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity userEntity = null;

        try {
            userEntity = oauthDAOService.getUserDetails(username);

            if (userEntity != null && userEntity.getId() != null && !"".equalsIgnoreCase(userEntity.getId())) {
                CustomUser customUser = new CustomUser(userEntity);
                return customUser;
            } else {
                throw new UsernameNotFoundException("User " + username + " was not found in the database");
            }
        } catch (Exception e) {
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }

    }

}
