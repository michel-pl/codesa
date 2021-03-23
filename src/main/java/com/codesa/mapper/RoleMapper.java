package com.codesa.mapper;

import com.codesa.entity.Role;
import com.codesa.resource.RoleResource;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoleMapper {

    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    RoleResource roleToRoleResource(Role role);

    Role roleResourceToRole(RoleResource roleResource);
}
