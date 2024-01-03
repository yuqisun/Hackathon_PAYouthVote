package org.hackathon.service;

import org.hackathon.entity.Authentication;
import org.hackathon.repository.AuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private AuthenticationRepository authenticationRepository;

    @Override
    public Authentication findByEmail(String email) {
        return authenticationRepository.findByEmail(email);
    }

    @Override
    public String save(Authentication authentication) {
        if (!ObjectUtils.isEmpty(findByEmail(authentication.getEmail()))) {
            return "email already exists";
        }
        authenticationRepository.save(authentication);
        return "Success";
    }
}
