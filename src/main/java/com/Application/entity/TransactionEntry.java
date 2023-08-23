package com.Application.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "transaction_entries")
public class TransactionEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "expense_transaction_id")
    private ExpenseTransaction expenseTransaction;

    @Column(name = "debtor_name")
    private String debtorName;

    @Column(name = "creditor_name")
    private String creditorName;

    private BigDecimal amount;


    // constructor,Getters and Setters
}

