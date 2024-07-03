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
public class InternalUserProfileController {
    UserProfileService userProfileService;
    UserProfileMapper userProfileMapper;

    @PostMapping("/internal/users")
    public ApiResponse<UserProfileResponse> createUserProfile(@RequestBody ProfileCreationRequest request) {
        UserProfileResponse response = userProfileService.createUserProfile(request);
        return ApiResponse.<UserProfileResponse>builder().result(response).build();
    }


}
