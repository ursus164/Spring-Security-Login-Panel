package com.ursus.service;


import com.ursus.model.User;
import com.ursus.model.dto.UserDto;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    User findByUsername(String username);
    User save(UserDto userDto);
}
