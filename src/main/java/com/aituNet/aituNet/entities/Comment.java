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
@Table(name="cms")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String text;
    private String username;
    private Long postId;
    private Long userId;

    public Comment(String text, String username, Long userId, Long postId) {
        this.text = text;
        this.username = username;
        this.userId = userId;
        this.postId = postId;
    }
}
