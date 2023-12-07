package com.example.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(name = "started_date", nullable = false, columnDefinition = "DATE")
    private Date startedDate;

    @Column(name = "finished_date", nullable = false, columnDefinition = "DATE")
    private Date finishedDate;

    @Column(name = "payment_date", columnDefinition = "DATE")
    private Date paymentDate;

    @Column(name = "amount_pay", nullable = false)
    private Long amountPay;

    @Column(name = "description", nullable = false, length = 64)
    private String description;

    @ManyToOne
    @JoinColumn(name = "security_id")
    Security security;
}
