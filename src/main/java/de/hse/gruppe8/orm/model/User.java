package de.hse.gruppe8.orm.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "Users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "username", length=50, unique = true)
    private String username;

    @Column(name = "password", length=50)
    private String password;

    @Column(name = "is_admin")
    private Boolean isAdmin = false;

    @Column(name = "first_name", length=50)
    private String firstName;

    @Column(name = "last_name", length=50)
    private String lastName;

    @Column(name = "email", length=50)
    private String email;

    @Column(name = "phone", length=50)
    private String phone;

    @Column(name = "mobile", length=50)
    private String mobile;

    @Column(name = "active")
    private Boolean active = true;

}