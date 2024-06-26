package com.example.backend.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(name = "sdi_permission")
public class Permission implements HasId, Serializable {

    @Id
    @GeneratedValue
    @Column(name = "p_id")
    private UUID id;

    @Column(name = "p_name", unique = true, nullable = false)
    private String name;

    @SuppressWarnings("unused")
    @OneToMany(mappedBy = "permission")
    private Set<RolePermission> rolePermissions;

    public Permission() {

    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public void setId(UUID newId) {
        id = newId;
    }

    public String getName() {
        return name;
    }

    @SuppressWarnings("unused")
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return ("""
                {"id"="%s","name"="%s"}
                """).formatted(id, name);
    }

    @SuppressWarnings("unused")
    public boolean validationFails() {
        return name == null
                || name.isEmpty()
                || id == null;
    }
}