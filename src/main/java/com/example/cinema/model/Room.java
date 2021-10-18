package com.example.cinema.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity //to create and save a table on DB
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  //it's creating an ID by itself and not giving me a certain value
    private int id;
    @Column(unique = true)
    private String type;
    private String time;

}
