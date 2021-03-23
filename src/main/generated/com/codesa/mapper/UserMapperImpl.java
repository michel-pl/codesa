package com.codesa.mapper;

import com.codesa.entity.Role;
import com.codesa.entity.User;
import com.codesa.resource.RoleResource;
import com.codesa.resource.UserResource;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-03-22T18:54:34-0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_241 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserResource userToUserResource(User user) {
        if ( user == null ) {
            return null;
        }

        UserResource userResource = new UserResource();

        userResource.setId( user.getId() );
        userResource.setRole( roleToRoleResource( user.getRole() ) );
        userResource.setName( user.getName() );
        userResource.setActive( user.getActive() );

        return userResource;
    }

    @Override
    public User userResourceToUser(UserResource userResource) {
        if ( userResource == null ) {
            return null;
        }

        User user = new User();

        user.setId( userResource.getId() );
        user.setRole( roleResourceToRole( userResource.getRole() ) );
        user.setName( userResource.getName() );
        user.setActive( userResource.getActive() );

        return user;
    }

    protected RoleResource roleToRoleResource(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleResource roleResource = new RoleResource();

        roleResource.setId( role.getId() );
        roleResource.setName( role.getName() );

        return roleResource;
    }

    protected Role roleResourceToRole(RoleResource roleResource) {
        if ( roleResource == null ) {
            return null;
        }

        Role role = new Role();

        role.setId( roleResource.getId() );
        role.setName( roleResource.getName() );

        return role;
    }
}
