package com.codesa.mapper;

import com.codesa.entity.Role;
import com.codesa.resource.RoleResource;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-03-22T18:54:34-0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_241 (Oracle Corporation)"
)
public class RoleMapperImpl implements RoleMapper {

    @Override
    public RoleResource roleToRoleResource(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleResource roleResource = new RoleResource();

        roleResource.setId( role.getId() );
        roleResource.setName( role.getName() );

        return roleResource;
    }

    @Override
    public Role roleResourceToRole(RoleResource roleResource) {
        if ( roleResource == null ) {
            return null;
        }

        Role role = new Role();

        role.setId( roleResource.getId() );
        role.setName( roleResource.getName() );

        return role;
    }
}
