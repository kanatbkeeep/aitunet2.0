package com.aituNet.aituNet.entities;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="\"user\"")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "varchar(128)", nullable = false, unique = true)
    private String username;
    private String password;
    private String aboutMe;
    @OneToMany(fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private Collection<Role> roles = new ArrayList<>();
    @OneToMany(fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private Collection<Post> posts = new ArrayList<>();

    public User(String username, String password, String aboutMe, Collection<Role> roles, Collection<Post> posts) {
        this.username = username;
        this.password = password;
        this.aboutMe = aboutMe;
        this.roles = roles;
        this.posts = posts;
    }

}
