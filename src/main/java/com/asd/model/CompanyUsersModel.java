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
@Entity(name = "Company_Users")
public class CompanyUsersModel{

    @Id
    @SequenceGenerator(name = "Company_Users_sequence",
            sequenceName = "Company_Users_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "Company_Users_sequence")
    private long id;

    @Column(name = "code",
            columnDefinition = "TEXT")
    private String code;

    @Column(name = "name",
            columnDefinition = "TEXT")
    private String name;

    @Column(name = "mobile_number",
            columnDefinition = "TEXT")
    private String mobile_number;

    @Column(name = "active",
            columnDefinition = "TEXT")
    private boolean active;
}
