package com.example.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Data
@Entity
@Table(name="broker_accounts")
public class BrokerAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false, name = "is_IIA")
    private boolean isIIA;

    @ManyToOne
    @JoinColumn(name="person_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Person person;
}
