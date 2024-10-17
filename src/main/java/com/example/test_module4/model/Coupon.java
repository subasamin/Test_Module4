package com.example.test_module4.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.DateFormat;
import java.util.Date;

@Entity
@Data
@Table(name = "Coupon")
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String description;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date statTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endTime;
    private Long discount;
}
