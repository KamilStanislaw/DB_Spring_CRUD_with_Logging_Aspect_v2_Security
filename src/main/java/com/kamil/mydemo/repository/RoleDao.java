package com.kamil.mydemo.repository;

import com.kamil.mydemo.entity.Role;

public interface RoleDao {

    public Role findRoleByName(String theRoleName);

}
