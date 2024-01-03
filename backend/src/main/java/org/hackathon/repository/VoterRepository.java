package org.hackathon.repository;

import org.hackathon.entity.Voter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoterRepository extends JpaRepository<Voter, Long> {
    Voter findByPhone(String phone);

    Voter findByEmail(String email);

    void deleteByPhone(String phone);

    void deleteByEmail(String email);
}
