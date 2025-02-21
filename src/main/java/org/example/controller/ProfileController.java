package org.example.controller;

import org.example.dto.ProfileRequest;
import org.example.entity.ProfileEntity;
import org.example.service.ProfileService;

public class ProfileController {
    private final ProfileService profileService = new ProfileService();
    public ProfileEntity login(String phone, String password) {
        return profileService.login(phone,password);
    }

    public String register(ProfileRequest request) {
        return profileService.register(request);
    }
}
