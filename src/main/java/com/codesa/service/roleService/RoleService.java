package com.codesa.service.roleService;

import com.codesa.entity.Role;

import java.util.List;

public interface RoleService {

    List<Role> findAll();

    Role findById(Long id);

    Role save(Role role);

    void deleteById(Long id);
}
