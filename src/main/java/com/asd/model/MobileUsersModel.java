package com.asd.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table
@Entity(name = "Mobile_Users")
public class MobileUsersModel {
    @Id
    @SequenceGenerator(name = "Mobile_Users_sequence",
            sequenceName = "Mobile_Users_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "Mobile_Users_sequence")
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

    @Column(name = "city",
            columnDefinition = "TEXT")
    private String city;

    @Column(name = "creation_date",
            columnDefinition = "TEXT")
    private Date creation_date;

    @Column(name = "active",
            columnDefinition = "TEXT")
    private boolean active;
}
