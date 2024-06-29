package com.devteria.profile.mapper;

import com.devteria.profile.entity.UserProfile;
import dto.request.ProfileCreationRequest;
import dto.request.ProfileUpdateRequest;
import dto.response.UserProfileResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserProfileMapper {
    UserProfile toUserProfile(ProfileCreationRequest request);

    UserProfileResponse toUserProfileReponse(UserProfile entity);
    void updateUserProfile(@MappingTarget UserProfile userProfile, ProfileUpdateRequest request);

}
