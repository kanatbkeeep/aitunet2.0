package com.aituNet.aituNet.service;

import com.aituNet.aituNet.entities.Role;
import com.aituNet.aituNet.entities.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUserByUsername(String username);
    List<User> getUsers();
    void updateAboutMe(String username, String aboutMe);
}
