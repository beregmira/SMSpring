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

        public Long getId() {
                return id;
        }

        public String getName() {
                return name;
        }

        public String getPassword() {
                return password;
        }

        public String getRole() {
                return role;
        }

        public String getEmail() {
                return email;
        }

        public short getEnabled() {
                return enabled;
        }
}
