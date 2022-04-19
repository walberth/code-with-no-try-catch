package com.wgutierrez.logger.controllers;

import java.util.List;
import com.wgutierrez.logger.transversal.Response;
import com.wgutierrez.logger.service.IProfileService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/v1/profile")
public class ProfileController {
    private IProfileService profileService;

    @Autowired
    public ProfileController(IProfileService profileService){
        this.profileService = profileService;
    }

    @GetMapping("/queries")
    public Response<List<String>> getQueries(@RequestParam int limit) {
        return profileService.getQueries(limit);
    }
}
