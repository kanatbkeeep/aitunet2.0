package com.aituNet.aituNet.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name = "usr")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    @Column(columnDefinition = "TEXT", unique = true)
    private String email;
    @Column(columnDefinition = "TEXT")
    private String password;
    private String firstName;
    private String secondName;
    private String gender;
    @Column()
    private String image;
    @Column()
    private String date_of_birth;
    @OneToMany
    private Collection<Post> posts = new ArrayList<>();
    @ManyToMany(fetch = EAGER)
    private Collection<Role> roles = new ArrayList<>();
    @ManyToMany
    private Collection<User> users = new ArrayList<>();

    public User(Long id, String email, String password, String firstName, String secondName, String gender, String image) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.secondName = secondName;
        this.gender = gender;
        this.image = image;
//        this.posts = posts;
//        this.roles = roles;
    }
}
