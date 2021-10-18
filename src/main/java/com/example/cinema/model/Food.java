package com.example.cinema.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity //to create and save a table on DB
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Food {
    private String name;
    @Id  // the annotation works with this atribute со it suppose to be above it
    private int id; // go to sales
    private BigDecimal price;
    private BigDecimal cost;
    }
