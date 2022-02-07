package com.aituNet.aituNet.services;

import com.aituNet.aituNet.entity.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    User getUserByEmail(String email);
    User getUser();
    List<User> getUsers();
    void addRoleToUser(String username, String roleName);
    void updateUserPassword(String newPassword);
    void updateUserEmail(String newEmail);
    void updateUserFirstName(String newFirstName);
    void updateUserSecondName(String newSecondName);
    void deleteUser();
    boolean existUser(String username);
}
