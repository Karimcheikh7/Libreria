package com.karimCheikh.libreria.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class UserWorkersRolesKey implements Serializable {

    @Column(name = "user_worker_id")
    Integer userWorkerId;

    @Column(name = "role_id")
    Integer roleId;

    public UserWorkersRolesKey() {
    }

    public UserWorkersRolesKey(Integer userWorkerId, Integer roleId) {
        this.userWorkerId = userWorkerId;
        this.roleId = roleId;
    }

    public Integer getUserWorkerId() {
        return userWorkerId;
    }

    public void setUserWorkerId(Integer userWorkerId) {
        this.userWorkerId = userWorkerId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "UsersRolesKey{" +
                "userId=" + userWorkerId +
                ", roleId=" + roleId +
                '}';
    }
}
