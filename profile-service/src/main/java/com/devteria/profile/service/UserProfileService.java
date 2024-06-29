package com.devteria.profile.service;

import com.devteria.profile.entity.UserProfile;
import com.devteria.profile.mapper.UserProfileMapper;
import com.devteria.profile.repository.UserRepository;
import dto.request.ProfileCreationRequest;
import dto.request.ProfileUpdateRequest;
import dto.response.UserProfileResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserProfileService {
    UserRepository userRepository;
    UserProfileMapper userProfileMapper;

    public UserProfileResponse createUserProfile(ProfileCreationRequest request) {
        UserProfile userProfile = userProfileMapper.toUserProfile(request);
        userProfile = userRepository.save(userProfile);
        return userProfileMapper.toUserProfileReponse(userProfile);
    }
    public UserProfileResponse getUserProfile(String id) {
        UserProfile userProfile = userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Profile not found")
        );
        return userProfileMapper.toUserProfileReponse(userProfile);
    }
    public void deleteUserProfile(String id) {
        UserProfile userProfile = userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Profile not found")
        );

        userRepository.deleteById(id);
    }
    public UserProfileResponse updateUserProfile(String id, ProfileUpdateRequest request) {
        UserProfile userProfile = userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Profile not found")
        );
        userProfileMapper.updateUserProfile(userProfile, request);
        return userProfileMapper.toUserProfileReponse(userRepository.save(userProfile));
        }
}
