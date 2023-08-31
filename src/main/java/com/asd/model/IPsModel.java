package com.asd.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table
@Entity(name = "ip_model")
public class IPsModel {

    @Id
    @SequenceGenerator(name = "ip_model_sequence",
            sequenceName = "ip_model_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "ip_model_sequence")
    private long IPsId;

    @Column(name = "time",
            nullable = false,
            columnDefinition = "TEXT")
    private String Time;

    @Column(name = "ip",
            nullable = false,
            columnDefinition = "TEXT")
    private String ip;

    @Column(name = "URL",
            columnDefinition = "TEXT")
    private String URL;

    public IPsModel(String time, String ip, String URL) {
        Time = time;
        this.ip = ip;
        this.URL = URL;
    }
}
