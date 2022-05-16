package de.hse.gruppe8.orm.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Features")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FeatureEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "value")
    private int value;

    @ManyToOne
    private ContractEntity contract;
}