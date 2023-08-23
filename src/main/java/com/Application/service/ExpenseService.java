package com.Application.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

import org.springframework.stereotype.Service;

import com.Application.entity.Expense;
import com.Application.entity.ExpenseSharing;
import com.Application.entity.ExpenseTransaction;
import com.Application.entity.TransactionEntry;
import com.Application.repository.ExpenseRepository;
import com.Application.repository.ExpenseSharingRepository;
import com.Application.repository.ExpenseTransactionRepository;

import jakarta.transaction.Transactional;

@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;
    private final ExpenseSharingRepository expenseSharingRepository;
    private final ExpenseTransactionRepository expenseTransactionRepository;

    public ExpenseService(ExpenseRepository expenseRepository, ExpenseSharingRepository expenseSharingRepository, ExpenseTransactionRepository expenseTransactionRepository) {
        this.expenseRepository = expenseRepository;
        this.expenseSharingRepository = expenseSharingRepository;
        this.expenseTransactionRepository = expenseTransactionRepository;
    }






    // Add other methods as per your requirements
}

