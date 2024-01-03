package org.hackathon.repository;

import org.hackathon.entity.Authentication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthenticationRepository extends JpaRepository<Authentication, Long> {

    Authentication findByEmail(String email);
}
