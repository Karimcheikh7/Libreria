package com.karimCheikh.libreria.entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "user_worker")
public class UserWorker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_worker_id")
    private Integer id;
    @Column(name = "username_worker")
    private String userNameWorker;
    @Column(name = "password")
    private String passoword;
    @Column(name = "enable")
    private Boolean enable;

    @OneToMany(mappedBy = "userWorker", fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    private Collection<UserWorkersRoles> userWorkersRoles;

    public UserWorker() {
    }

    public UserWorker(String userNameWorker, String passoword, Boolean enable, Collection<UserWorkersRoles> userWorkersRoles) {
        this.userNameWorker = userNameWorker;
        this.passoword = passoword;
        this.enable = enable;
        this.userWorkersRoles = userWorkersRoles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserNameWorker() {
        return userNameWorker;
    }

    public void setUserNameWorker(String userNameWorker) {
        this.userNameWorker = userNameWorker;
    }

    public String getPassoword() {
        return passoword;
    }

    public void setPassoword(String passoword) {
        this.passoword = passoword;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Collection<UserWorkersRoles> getUserWorkersRoles() {
        return userWorkersRoles;
    }

    public void setUserWorkersRoles(Collection<UserWorkersRoles> userWorkersRoles) {
        this.userWorkersRoles = userWorkersRoles;
    }

    @Override
    public String toString() {
        return "UserWorker{" +
                "id=" + id +
                ", userNameWorker='" + userNameWorker + '\'' +
                ", passoword='" + passoword + '\'' +
                ", enable=" + enable +
                '}';
    }
}
