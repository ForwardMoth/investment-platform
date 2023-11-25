package com.example.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name ="securities")
public class Security {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "ticker", nullable = false, length = 15)
    private String ticker;

    @Column(name = "type_of_investment", nullable = false, length = 16)
    private String typeOfInvestment;

    @Column(name = "price", nullable = false)
    private long price;
}
