package org.hackathon.service;

import org.hackathon.constants.Constant;
import org.hackathon.entity.Authentication;
import org.hackathon.entity.RegisterStatus;
import org.hackathon.entity.Voter;
import org.hackathon.repository.AuthenticationRepository;
import org.hackathon.repository.RegisterStatusRepository;
import org.hackathon.repository.VoterRepository;
import org.hackathon.utils.BeanCopyUtils;
import org.hackathon.vo.VoterInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VoterServiceImpl implements VoterService {

    @Autowired
    private VoterRepository voterRepository;

    @Autowired
    private AuthenticationRepository authenticationRepository;

    @Autowired
    private RegisterStatusRepository registerStatusRepository;

    @Override
    public VoterInfo registerToVote(VoterInfo info) {
        Voter voter = new Voter();
        BeanUtils.copyProperties(info, voter);
        voter = voterRepository.save(voter);

        Authentication authentication = new Authentication();
        authentication.setId(voter.getId());
        authentication.setEmail(info.getEmail());
        authentication.setPassword(info.getPassword());
        authenticationRepository.save(authentication);

        RegisterStatus status = new RegisterStatus();
        status.setId(voter.getId());
        status.setStatus(Constant.REGISTER_STATUS_INPROGRESS);
        registerStatusRepository.save(status);

        info.setId(voter.getId());
        info.setRegisterStatus(Constant.REGISTER_STATUS_INPROGRESS);
        return info;
    }

    @Override
    public VoterInfo update(VoterInfo info) {
        if (info.getId() == null) {
            throw new RuntimeException("could not found user");
        }
        Optional<Voter> optional = voterRepository.findById(info.getId());
        Voter voter = optional.orElse(null);
        if (voter != null) {
            BeanUtils.copyProperties(info, voter, BeanCopyUtils.getNullPropertyNames(info));
            voterRepository.save(voter);
            BeanUtils.copyProperties(voter, info);
            Optional<RegisterStatus> optionalStatus = registerStatusRepository.findById(voter.getId());
            RegisterStatus registerStatus = optionalStatus.orElse(null);
            info.setRegisterStatus(registerStatus == null ? null : registerStatus.getStatus());
        }
        return info;
    }

    @Override
    public VoterInfo findById(Long id) {
        Optional<Voter> optionalVoter = voterRepository.findById(id);
        Voter voter = optionalVoter.orElse(null);
        if (voter != null) {
            VoterInfo info = new VoterInfo();
            BeanUtils.copyProperties(voter, info);
            Optional<RegisterStatus> optionalStatus = registerStatusRepository.findById(voter.getId());
            RegisterStatus registerStatus = optionalStatus.orElse(null);
            info.setRegisterStatus(registerStatus == null ? null : registerStatus.getStatus());
            return info;
        } else {
            return null;
        }
    }

    @Override
    public String updateStatusById(String status, Long id) {
        switch (status) {
            case "completed":
                status = Constant.REGISTER_STATUS_SUCCEED;
                break;
            case "rejected":
                status = Constant.REGISTER_STATUS_FAILED;
                break;
            case "inprogress":
                status = Constant.REGISTER_STATUS_INPROGRESS;
                break;
            default:
                status = Constant.REGISTER_STATUS_SUCCEED;
        }
        Optional<RegisterStatus> optional = registerStatusRepository.findById(id);
        final String toBeSavedStatus = status;
        optional.ifPresent(value -> {
            value.setStatus(toBeSavedStatus);
            registerStatusRepository.save(value);
        });
        return "success";
    }

}
