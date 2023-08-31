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
@Entity(name = "General_Settings")
public class GeneralSettingsModel{

    @Id
    @SequenceGenerator(name = "General_Settings_sequence",
            sequenceName = "General_Settings_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "General_Settings_sequence")
    private long id;

    @Column(name = "invalid_login_number")
    private static int invalid_login_number;

    @Column(name = "token_expire")
    private static int token_expire;

    @Column(name = "number_of_invalid_token")
    private static int number_of_invalid_token;

    @Column(name = "number_of_valid_token")
    private static int number_of_valid_token;
}
