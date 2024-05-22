package com.kamil.mydemo.repository;

import com.kamil.mydemo.entity.User;

public interface UserDao {

    User findByUserName(String userName);

}
