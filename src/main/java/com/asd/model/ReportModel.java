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
@Entity(name = "Report")
public class ReportModel{
    @Id
    @SequenceGenerator(name = "Report_sequence",
            sequenceName = "Report_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "Report_sequence")
    private long id;

    @Column(name = "user_code",
            columnDefinition = "TEXT")
    private String user_code;

    @Column(name = "date_of_request",
            columnDefinition = "TEXT")
    private Date date_of_request;

    @Column(name = "response_time",
            columnDefinition = "TEXT")
    private Date response_time;
}
