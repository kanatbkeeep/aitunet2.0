package com.aituNet.aituNet.controllers;

import com.aituNet.aituNet.services.UserService;
import com.aituNet.aituNet.entity.User;
import com.aituNet.aituNet.requests.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    @GetMapping("/admin/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @GetMapping("/admin/getUserByUsername")
    public ResponseEntity<User>getUserByEmail(@RequestParam String email) {
        return ResponseEntity.ok().body(userService.getUserByEmail(email));
    }

    @GetMapping("/user/getUser")
    public ResponseEntity<User>getUserByUsername() {
        return ResponseEntity.ok().body(userService.getUser());
    }

    @PostMapping("/user/save")
    public ResponseEntity saveUser(@RequestBody User user) {
        if(userService.existUser(user.getEmail())) {
            return ResponseEntity.badRequest().body("User with this username already exist");
        }
        userService.saveUser(user);
        userService.addRoleToUser(user.getEmail(), "user");
        return new ResponseEntity("user created", HttpStatus.CREATED);
    }

    @PostMapping("/user/update")
    public ResponseEntity updateUser(@RequestBody UserRequest updateUserRequest) {
        if(updateUserRequest.getParameter().equals("name")) {
            if(userService.existUser(updateUserRequest.getNewValue())) return ResponseEntity.badRequest().body("User with this nickname already exist");
            userService.updateUserEmail(updateUserRequest.getNewValue());
            return ResponseEntity.ok().body("Updated");
        } else if(updateUserRequest.getParameter().equals("password")) {
            userService.updateUserPassword(updateUserRequest.getNewValue());
            return ResponseEntity.ok().body("Updated");
        }else if(updateUserRequest.getParameter().equals("email")) {
            userService.updateUserEmail(updateUserRequest.getNewValue());
            return ResponseEntity.ok().body("Updated");
        }
        else if(updateUserRequest.getParameter().equals("firstName")) {
            userService.updateUserFirstName(updateUserRequest.getNewValue());
            return ResponseEntity.ok().body("Updated");
        }
        else if(updateUserRequest.getParameter().equals("secondName")) {
            userService.updateUserSecondName(updateUserRequest.getNewValue());
            return ResponseEntity.ok().body("Updated");
        }
        else {
            return ResponseEntity.badRequest().body("Incorrect parameter");
        }
    }

//    @PostMapping("/editUser")
//    public ResponseEntity updateUserById(@RequestBody UpdateUserRequest updateUserRequest) {
//        boolean result = userService.updateUserById(userRequest);
//        if (result) {
//            return new ResponseEntity("user updated", HttpStatus.OK);
//        }
//        return ResponseEntity.badRequest().body("bad request");
//    }
//    @PostMapping("/user/delete")
//    public ResponseEntity deleteUser() {
//        userService.deleteUser();
//        return ResponseEntity.ok().body("User deleted");
//    }


/*
    @GetMapping("/token/refresh")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authorizationHeader = request.getHeader(AUTHORIZATION);
        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            try {
                String refresh_token = authorizationHeader.substring("Bearer ".length());
                Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
                JWTVerifier verifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = verifier.verify(refresh_token);
                String username = decodedJWT.getSubject();
                User user = userService.getUserByUsername(username);
                String access_token = JWT.create()
                        .withSubject(user.getUsername())
                        .withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 1000))
                        .withIssuer(request.getRequestURL().toString())
                        .withClaim("roles", user.getRoles().stream().map(Role::getName).collect(Collectors.toList()))
                        .sign(algorithm);
                Map<String, String> tokens = new HashMap<>();
                tokens.put("access_toke", access_token);
                tokens.put("refresh_toke", refresh_token);
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), tokens);
            } catch (Exception exception) {
                response.setHeader("error", exception.getMessage());
                response.setStatus(FORBIDDEN.value());
//                    response.sendError(FORBIDDEN.value());
                Map<String, String> error = new HashMap<>();
                error.put("error", exception.getMessage());
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), error);
            }
        } else {
            throw new RuntimeException("Refresh token is missed");
        }
    }

 */
}
