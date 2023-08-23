package com.Application.entity;


import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "expense_transactions")
public class ExpenseTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "expense_id")
    private Long expenseId;

    @Column(name = "group_id")
    private Long groupId;
    @OneToMany(cascade = CascadeType.ALL)

    @JoinColumn(name = "expense_transaction_id")
    private List<TransactionEntry> transactions;



    // constructor,Getters and Setters


}
