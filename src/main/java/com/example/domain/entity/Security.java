package com.example.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name ="security")
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

    @OneToMany(mappedBy = "security")
    private Set<AccountSecurity> accountSecurities;

    @OneToMany(mappedBy = "security")
    private Set<Payment> payments;
}
