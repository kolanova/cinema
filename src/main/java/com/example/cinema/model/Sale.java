package com.example.cinema.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private BigDecimal salePrice;
    private BigDecimal cost;
    private String time;
    @ManyToOne
    @MapsId("roomId")
    @JoinColumn(name = "room_id") private Room room; // for one room lot's of sales
    @MapsId("foodId")
    @ManyToOne
    @JoinColumn(name = "food_id") private Food food;
    @MapsId("ticketId")
    @ManyToOne
    @JoinColumn(name = "ticket_id") private Ticket ticket;
}
