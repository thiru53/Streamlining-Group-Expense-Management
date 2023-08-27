package com.Application.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "expenses")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(name = "group_id")
    private Long groupId;

    private BigDecimal amount;

    @Column(name = "paid_by")
    private String paidBy;

    @ElementCollection
    @CollectionTable(name = "expense_for_whom")
    private List<String> forWhom;

    @Column(name = "payment_date")
    private LocalDate paymentDate;

    // Constructors


    // Getters and Setters

}

