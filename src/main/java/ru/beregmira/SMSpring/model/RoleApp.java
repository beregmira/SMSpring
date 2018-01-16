package ru.beregmira.SMSpring.model;

import javax.persistence.*;

@Entity
@Table(name = "role_app")
public class RoleApp {
    @Id
    @GeneratedValue
    private long roleId;

    @Column
    private String roleName;
}
