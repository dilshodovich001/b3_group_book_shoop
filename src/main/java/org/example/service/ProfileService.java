package org.example.service;

import org.example.dto.ProfileRequest;
import org.example.entity.ProfileEntity;
import org.example.enums.GeneralStatus;
import org.example.enums.ProfileRole;
import org.example.exceptions.ProfileException;
import org.example.repository.ProfileRepository;

import java.util.List;

public class ProfileService {
    public ProfileService(){
        List<ProfileEntity> entities = profileRepository.readData();
        for (ProfileEntity entity : entities) {
            if (entity.getRole().equals(ProfileRole.ADMIN)){
                return;
            }
        }
        ProfileEntity entity = new ProfileEntity();
        entity.setAge(24);
        entity.setName("Admin");
        entity.setRole(ProfileRole.ADMIN);
        entity.setPassword("9999");
        entity.setBalance(0d);
        entity.setPhone("9999");
        profileRepository.save(List.of(entity));
    }
    private final ProfileRepository profileRepository = new ProfileRepository();

    public ProfileEntity login(String phone, String password) {
        ProfileEntity profile = null;
        List<ProfileEntity> entities = profileRepository.readData();
        for (ProfileEntity entity : entities) {
            if (entity.getPhone().equals(phone) && entity.getPassword().equals(password)) {
                profile = entity;
            }
        }
        if (profile != null) {
            if (profile.getStatus().equals(GeneralStatus.NOT_ACTIVE) || profile.getStatus().equals(GeneralStatus.BLOCK)) {
                throw new ProfileException("Profile is blocked or not active");
            }
        }
        return profile;
    }


    public String register(ProfileRequest request) {
        checkProfile(request);
        ProfileEntity entity = new ProfileEntity();
        entity.setAge(request.getAge());
        entity.setName(request.getName());
        entity.setRole(ProfileRole.USER);
        entity.setPassword(request.getPassword());
        entity.setBalance(0d);
        entity.setPhone(request.getPhone());
        profileRepository.save(List.of(entity));
        return "Successfully registered";
    }

    private void checkProfile(ProfileRequest request) {
        if (request.getPhone() == null || request.getPhone().isBlank()){
            throw new ProfileException("Phone error");
        }
        if (request.getPassword() == null || request.getPassword().isBlank()){
            throw new ProfileException("Password error");
        }
        if (request.getName() == null || request.getName().isBlank()){
            throw new ProfileException("Name error");
        }
        if (request.getAge() == 0){
            throw new ProfileException("Age error");
        }
    }
}
