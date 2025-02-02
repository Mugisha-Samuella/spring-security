package com.jetbrains.springsecurityapp;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class AppUser {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "username")
    private String username;

    @Column (name = "password")
    private String password;

}
