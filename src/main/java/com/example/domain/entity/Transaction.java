package com.example.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(name = "date", nullable = false, columnDefinition = "DATE")
    private Date date;

    @Column(name = "quantity", nullable = false)
    private Long quantity;

    @Column(name = "price_for_one", nullable = false)
    private Long priceForOne;

    @Column(name = "fee", nullable = false)
    private Long fee;

    @Column(name = "is_buying", nullable = false)
    private Boolean isBuying;

    @ManyToOne
    @JoinColumn(name = "account_security_id")
    AccountSecurity accountSecurity;
}
