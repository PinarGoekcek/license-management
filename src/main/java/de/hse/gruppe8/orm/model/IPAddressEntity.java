package de.hse.gruppe8.orm.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "IPAddresses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IPAddressEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "value", length = 16)
    private String value;

    @ManyToOne
    private ContractEntity contract;

}