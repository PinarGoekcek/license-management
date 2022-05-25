package de.hse.gruppe8.jaxrs.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
    private Company company;
    private List<String> ipAddresses;
    private List<Integer> features;

}
