package com.asd.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.net.URL;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table
@Entity(name = "CompanyTransReport")
public class CompanyTransReportModel{
    @Id
    @SequenceGenerator(name = "CompanyTransReport_sequence",
            sequenceName = "CompanyTransReport_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "CompanyTransReport_sequence")
    private long id;

@Column(name = "company_name",
            columnDefinition = "TEXT")
    private String company_name;

@Column(name = "company_code",
            columnDefinition = "TEXT")
    private String company_code;

@Column(name = "company_user_number",
            nullable = false)
        private int company_user_number;

@Column(name = "company_mobile_user_number",
            nullable = false)
    private int company_mobile_user_number;

@Column(name = "company_active_users")
    private int company_active_users;

@Column(name = "creation_date",
            columnDefinition = "TEXT")
    private Date creation_date;

@Column(name = "creation_time",
            columnDefinition = "TEXT")
    private Date creation_time;

@Column(name = "company_city",
            nullable = false,
            columnDefinition = "TEXT")
    private String company_city;

@Column(name = "company_active",
            columnDefinition = "TEXT")
    private boolean company_active;

@Column(name = "company_ip",
            nullable = false,
            columnDefinition = "TEXT")
    private String company_ip;

@Column(name = "company_link",
            nullable = false,
            columnDefinition = "TEXT")
    private URL company_link;
}
