package ru.beregmira.SMSpring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "role_app")
public class RoleApp implements Serializable {
    @Id
    @GeneratedValue
    private long roleId;
    private String roleName;

    public RoleApp() {
    }

    public RoleApp(String roleName) {
        this.roleName = roleName;
    }

    public long getRoleId() {
        return roleId;
    }

    public String getRoleName() {
        return roleName;
    }
}
