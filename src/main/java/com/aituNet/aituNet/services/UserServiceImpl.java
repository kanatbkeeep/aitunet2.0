package com.aituNet.aituNet.services;

import com.aituNet.aituNet.entity.Role;
import com.aituNet.aituNet.entity.User;
import com.aituNet.aituNet.repositories.RoleRepository;
import com.aituNet.aituNet.repositories.UserRepository;
import com.auth0.jwt.JWT;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private static Map<String, String> tokens = new HashMap<>();

    public static void addToken(String access_token, String refresh_token) {
        tokens.put("access_token", access_token);
        tokens.put("refresh_token", refresh_token);
    }

    public static Map<String, String> getTokenMap() {
        return tokens;
    }

    @Override
    public User saveUser(User user) {
        log.info("User {} added", user.getEmail());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User getUserByEmail(String email) {
        log.info("Fetching user {}", email);
        return userRepository.findByEmail(email);
    }

    @Override
    public User getUser() {
        String token = tokens.get("access_token");
        String username = JWT.decode(token).getSubject();
        return userRepository.findByEmail(username);
    }

    @Override
    public boolean existUser(String email) {
        User user = userRepository.findByEmail(email);
        return user != null;
    }

    @Override
    public List<User> getUsers() {
        log.info("Fetching all users");
        return userRepository.findAll();
    }

    @Override
    public void addRoleToUser(String email, String roleName) {
        log.info("Role {} added to user {}", roleName, email);
        User user = userRepository.findByEmail(email);
        Role role = roleRepository.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public void updateUserEmail(String newNickname) {
        String token = tokens.get("access_token");
        String email = JWT.decode(token).getSubject();
        User user = userRepository.findByEmail(email);
        user.setEmail(newNickname);
        userRepository.save(user);
    }

    @Override
    public void updateUserPassword(String newPassword) {
        String token = tokens.get("access_token");
        String email = JWT.decode(token).getSubject();
        User user = userRepository.findByEmail(email);
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
    }
    @Override
    public void updateUserFirstName(String newFirstName) {
        String token = tokens.get("access_token");
        String email = JWT.decode(token).getSubject();
        User user = userRepository.findByEmail(email);
        user.setFirstName((newFirstName));
        userRepository.save(user);
    }
    @Override
    public void updateUserSecondName(String newSecondName) {
        String token = tokens.get("access_token");
        String email = JWT.decode(token).getSubject();
        User user = userRepository.findByEmail(email);
        user.setSecondName((newSecondName));
        userRepository.save(user);
    }

    @Override
    public void deleteUser() {
        String token = tokens.get("access_token");
        String email = JWT.decode(token).getSubject();
        User user = userRepository.findByEmail(email);
        userRepository.delete(user);
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if(user == null) {
            log.error("User not found!");
            throw new UsernameNotFoundException("User not found!");
        } else {
            log.info("User found in the database: {}", email);
        }

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {authorities.add(new SimpleGrantedAuthority(role.getName()));});
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
    }
}
