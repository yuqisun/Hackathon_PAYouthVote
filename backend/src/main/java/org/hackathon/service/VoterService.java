package org.hackathon.service;

import org.hackathon.vo.VoterInfo;

public interface VoterService {
    VoterInfo registerToVote(VoterInfo info);
    VoterInfo update(VoterInfo info);
    VoterInfo findById(Long i);
    String updateStatusById(String status, Long id);
}
