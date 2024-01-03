package org.hackathon.service;

import org.hackathon.entity.Authentication;

public interface AuthenticationService {
    Authentication findByEmail(String email);

    String save(Authentication authentication);
}
