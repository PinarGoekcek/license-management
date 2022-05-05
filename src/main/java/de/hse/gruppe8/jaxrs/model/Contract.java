package de.hse.gruppe8.jaxrs.model;

import de.hse.gruppe8.orm.model.CompanyEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Contract implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Date dateStart;
    private Date dateStop;
    private String version;
    private String licenseKey;
    private CompanyEntity company;

}
