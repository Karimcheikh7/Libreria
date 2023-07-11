package com.karimCheikh.libreria.entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "role", cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    private Collection<UserWorkersRoles> userWorkersRoles;

    public Role() {
    }

    public Role(String name, Collection<UserWorkersRoles> usersRoles) {
        this.name = name;
        this.userWorkersRoles = usersRoles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<UserWorkersRoles> getUserWorkersRoles() {
        return userWorkersRoles;
    }

    public void setUserWorkersRoles(Collection<UserWorkersRoles> userWorkersRoles) {
        this.userWorkersRoles = userWorkersRoles;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}