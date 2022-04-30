package de.hse.gruppe8.orm.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "Companies")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length=50)
    private String name;

    @Column(name = "department", length=50)
    private String department;

    @Column(name = "street", length=50)
    private String street;

    @Column(name = "zip_code", length=50)
    private String zipCode;

    @Column(name = "city", length=50)
    private String city;

    @Column(name = "country", length=50)
    private String country;

    @Column(name = "active")
    private Boolean active = true;

}