package com.SijibimiAol.BlogApp.service;

import com.SijibimiAol.BlogApp.entity.User;

public interface UserService {
    User registerUser(User user);

    String verify(User user);

    User getUserByUsername(String username);

    User getUserById(int id);
}
