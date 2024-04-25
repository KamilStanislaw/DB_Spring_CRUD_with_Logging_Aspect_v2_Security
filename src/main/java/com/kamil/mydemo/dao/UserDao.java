package com.kamil.mydemo.dao;

import com.kamil.mydemo.entity.User;

public interface UserDao {

    User findByUserName(String userName);

}
