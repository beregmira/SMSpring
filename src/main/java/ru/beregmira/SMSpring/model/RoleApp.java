package ru.beregmira.SMSpring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role_app")
public class RoleApp{
    @Id
    @GeneratedValue
    private long roleId;
    private String roleName;

    public long getRoleId() {
        return roleId;
    }

    public String getRoleName() {
        return roleName;
    }
}
