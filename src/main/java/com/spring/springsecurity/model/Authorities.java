package com.spring.springsecurity.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="authorities")
public class Authorities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    @Column(name ="authorities_name")
    private String authoritiesName ;



    @ManyToMany(mappedBy = "authorities")
    private Set<User> users ;


}
