package com.karimCheikh.libreria.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_workers_roles")
public class UserWorkersRoles {

    @EmbeddedId
    UserWorkersRolesKey id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userWorkerId")
    @JoinColumn(name = "user_worker_id")
    private UserWorker userWorker;

    @ManyToOne
    @MapsId("roleId")
    @JoinColumn(name = "role_id")
    private Role role;

    public UserWorkersRoles() {
    }

    public UserWorkersRoles(UserWorkersRolesKey id, UserWorker userWorker, Role role) {
        this.id = id;
        this.userWorker = userWorker;
        this.role = role;
    }

    public UserWorkersRolesKey getId() {
        return id;
    }

    public UserWorker getUserWorker() {
        return userWorker;
    }

    public Role getRole() {
        return role;
    }


}
