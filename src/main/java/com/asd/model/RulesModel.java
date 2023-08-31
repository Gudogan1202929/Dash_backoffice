package com.asd.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table
@Entity(name = "Rules")
public class RulesModel {

    @Id
    @SequenceGenerator(name = "Rules_sequence",
            sequenceName = "Rules_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "Rules_sequence")
    private long id;

    @Column(name = "length")
    private int length;

    @Column(name = "number")
    private int number;

    @Column(name = "special_num",
    unique = true)
    private int special_num;

    @Column(name = "days")
    private int days;

    @Column(name = "has_capit",
            columnDefinition = "TEXT")
    private boolean has_capit;
}
