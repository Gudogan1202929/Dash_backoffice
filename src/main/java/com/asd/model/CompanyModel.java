package com.asd.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.*;
import java.net.URL;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Table
@Entity(name = "Company")
public class CompanyModel{
    @Id
    @SequenceGenerator(name = "Company_sequence",
            sequenceName = "Company_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "Company_sequence")
    private long id;

    @Column(name = "number")
    private int number;

    @Column(name = "name",
            columnDefinition = "TEXT")
    private String name;

    @Column(name = "ip",
            columnDefinition = "TEXT")
    private String ip;

    @Column(name = "link",
            columnDefinition = "TEXT")
    private URL link;

    @Column(name = "active",
            columnDefinition = "TEXT")
    private boolean active;
}
