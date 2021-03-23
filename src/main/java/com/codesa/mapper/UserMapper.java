package com.codesa.mapper;

import com.codesa.entity.User;
import com.codesa.resource.UserResource;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserResource userToUserResource(User user);

    User userResourceToUser(UserResource userResource);
}
