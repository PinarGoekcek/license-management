package de.hse.gruppe8.orm.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ContractsToUsers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContractToUserEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @ManyToOne
    private ContractEntity contract;

    @ManyToOne
    private UserEntity user;

}