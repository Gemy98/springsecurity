package com.spring.springsecurity.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;



    @Column(name ="role_name")
    private String roleName ;




    @ManyToMany( mappedBy = "roles")
    private Set<User> users ;



}
