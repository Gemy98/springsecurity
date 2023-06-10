package com.spring.springsecurity.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role {
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    public Role() {
    }

    public Role(String roleName) {
        this.roleName = roleName;
    }

    @Column(name ="role_name")
    private String roleName ;




    @ManyToMany( mappedBy = "roles")
    private List<User> users ;



}
