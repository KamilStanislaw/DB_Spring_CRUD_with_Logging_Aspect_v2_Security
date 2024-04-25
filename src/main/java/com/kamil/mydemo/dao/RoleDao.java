package com.kamil.mydemo.dao;

import com.kamil.mydemo.entity.Role;

public interface RoleDao {

    public Role findRoleByName(String theRoleName);

}
