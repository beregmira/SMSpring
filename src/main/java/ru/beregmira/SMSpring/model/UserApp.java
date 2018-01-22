package ru.beregmira.SMSpring.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "user_app")
public class UserApp implements Serializable {

        @Id
        @GeneratedValue
        private Long id;

        @Column(nullable = false, unique = true)
        private String name;

        @Column(nullable = false)
        private String password;

        @Column
        private String role = "ROLE_USER";

        @Column
        private String email;

        @Column
        private short enabled = 1;

    @OneToMany(mappedBy = "userApp", cascade = CascadeType.ALL)
    private List<Article> articleList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public short getEnabled() {
        return enabled;
    }

    public void setEnabled(short enabled) {
        this.enabled = enabled;
    }
}
