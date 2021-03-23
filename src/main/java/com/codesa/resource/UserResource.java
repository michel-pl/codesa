package com.codesa.resource;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class UserResource implements Serializable {

    private long id;
    private RoleResource role;
    private String name;
    private char active;
}
