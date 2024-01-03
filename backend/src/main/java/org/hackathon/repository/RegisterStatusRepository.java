package org.hackathon.repository;

import org.hackathon.entity.Authentication;
import org.hackathon.entity.RegisterStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterStatusRepository extends JpaRepository<RegisterStatus, Long> {
}
