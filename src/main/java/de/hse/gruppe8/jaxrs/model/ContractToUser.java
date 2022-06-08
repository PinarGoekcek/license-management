package de.hse.gruppe8.jaxrs.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ContractToUser implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Contract contract;
    private User user;

}
