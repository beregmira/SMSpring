package ru.beregmira.SMSpring.model;

import javax.persistence.*;

@Entity
@Table(name = "user_app")
public class UserApp {

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

        public long getId() {
                return id;
        }

        public void setId(long id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
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

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }
}
