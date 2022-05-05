package de.hse.gruppe8.orm.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "Contracts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Contract implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "date_start")
    private Date dateStart;

    @Column(name = "date_stop")
    private Date dateStop;

    @Column(name = "version", length=50)
    private String version;

    @Column(name = "license_key", length=50)
    private String licenseKey;

    @Column(name = "active")
    private Boolean active = true;

}