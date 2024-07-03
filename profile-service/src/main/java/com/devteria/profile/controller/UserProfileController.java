package com.devteria.profile.controller;

import com.devteria.profile.mapper.UserProfileMapper;
import com.devteria.profile.service.UserProfileService;
import dto.request.ProfileCreationRequest;
import dto.request.ProfileUpdateRequest;
import dto.response.ApiResponse;
import dto.response.UserProfileResponse;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
public class UserProfileController {
    UserProfileService userProfileService;
    UserProfileMapper userProfileMapper;


    @GetMapping("/users/{profileId}")
    public ApiResponse<UserProfileResponse> getUserProfile(@PathVariable String profileId) {
        UserProfileResponse response = userProfileService.getUserProfile(profileId);
        return ApiResponse.<UserProfileResponse>builder().result(response).build();
    }
    @DeleteMapping("/users/{profileId}")
    public ApiResponse<Void> deleteUserProfile(@PathVariable String profileId) {
        userProfileService.deleteUserProfile(profileId);
        return ApiResponse.<Void>builder().result(null).build();
    }
    @PutMapping("/users/{profileId}")
    public ApiResponse<UserProfileResponse> updateUserProfile(@PathVariable String profileId, @RequestBody ProfileUpdateRequest request) {
        UserProfileResponse response = userProfileService.updateUserProfile(profileId, request);
        return ApiResponse.<UserProfileResponse>builder().result(response).build();
    }

}
