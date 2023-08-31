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
@Entity(name = "CompanyCountReport")
public class CompanyCountReportModel {
    @Id
    @SequenceGenerator(name = "CompanyCountReport_sequence",
            sequenceName = "CompanyCountReport_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "CompanyCountReport_sequence")
    private long id;

@Column(name = "company_name",
            columnDefinition = "TEXT")
    private String company_name;

@Column(name = "active",
            columnDefinition = "TEXT")
    private boolean active;

@Column(name = "transactions",
            columnDefinition = "TEXT")
    private String transactions;

@Column(name = "combination",
            columnDefinition = "TEXT")
    private String combination;

@Column(name = "total",
            nullable = false)
private int total;
}