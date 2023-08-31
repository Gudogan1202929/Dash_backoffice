package com.asd.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table
@Entity(name = "Customer_Rating")
public class CustomerRatingModel{

    @Id
    @SequenceGenerator(name = "Customer_Rating_sequence",
            sequenceName = "Customer_Rating_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "Customer_Rating_sequence")
    private long id;

    @Column(name = "code",
            columnDefinition = "TEXT")
    private String code;

    @Column(name = "description",
            columnDefinition = "TEXT")
    private String description;

    @Column(name = "details",
            columnDefinition = "TEXT")
    private String details;
}
