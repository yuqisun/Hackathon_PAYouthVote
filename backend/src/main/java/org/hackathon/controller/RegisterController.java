package org.hackathon.controller;

import org.hackathon.entity.Achievement;
import org.hackathon.entity.Authentication;
import org.hackathon.response.ListResponse;
import org.hackathon.response.SingleResponse;
import org.hackathon.service.AchievementService;
import org.hackathon.service.AuthenticationService;
import org.hackathon.service.VoterService;
import org.hackathon.vo.VoterInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/voter")
@CrossOrigin
@RestController
public class RegisterController {
    @Autowired
    private VoterService voterService;
    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private AchievementService achievementService;

    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SingleResponse<VoterInfo>> register(@RequestBody VoterInfo info) {
        if (StringUtils.hasText(info.getEmail()) && StringUtils.hasText(info.getPassword())) {
            return ResponseEntity.ok(SingleResponse.success(voterService.registerToVote(info)));
        } else {
            return ResponseEntity.badRequest().body(SingleResponse.failure("Email is empty"));
        }
    }

    @PostMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SingleResponse<VoterInfo>> update(@RequestBody VoterInfo info) {
        if (info.getId() == null) {
            return ResponseEntity.badRequest().body(SingleResponse.failure("User not found"));
        } else {
            return ResponseEntity.ok(SingleResponse.success(voterService.update(info)));
        }
    }

    @GetMapping(value = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SingleResponse<VoterInfo>> findVoterByPhone(@PathVariable("id") String id) {
        VoterInfo result = voterService.findById(Long.valueOf(id));
        if (ObjectUtils.isEmpty(result)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(SingleResponse.failure("User Not Found"));
        }
        return ResponseEntity.ok(SingleResponse.success(result));
    }

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SingleResponse<VoterInfo>> login(@RequestParam("email") String email, @RequestParam("password") String password) {
        if (StringUtils.hasText(email) && StringUtils.hasText(password)) {
            Authentication authentication = authenticationService.findByEmail(email);
            if (ObjectUtils.isEmpty(authentication)) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(SingleResponse.failure("User not exists"));
            }
            if (password.equals(authentication.getPassword())) {
                VoterInfo result = voterService.findById(authentication.getId());
                return ResponseEntity.ok(SingleResponse.success(result));
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(SingleResponse.failure("Login Failed"));
    }

    @PostMapping(value = "/status/update/{id}/{status}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SingleResponse<String>> updateStatus(@PathVariable("id") String id, @PathVariable("status") String status) {
        return ResponseEntity.ok(SingleResponse.success(voterService.updateStatusById(status, Long.valueOf(id))));
    }

    @GetMapping(value = "/achievement/query/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ListResponse<Achievement>> findAchievementByEmail(@PathVariable("id") String id) {
        return ResponseEntity.ok(ListResponse.success(achievementService.findById(Long.valueOf(id))));
    }
}
