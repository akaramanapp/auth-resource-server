package com.abacus.project.authserver.dao;

import com.abacus.project.authserver.model.UserEntity;

public interface OAuthDAOService {

    public UserEntity getUserDetails(String emailId);
}
