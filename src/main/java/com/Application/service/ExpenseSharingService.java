package com.Application.service;

import java.util.*;

import org.springframework.stereotype.Service;

import com.Application.entity.ExpenseSharing;
import com.Application.repository.ExpenseSharingRepository;

@Service
public class ExpenseSharingService {
    private final ExpenseSharingRepository expenseSharingRepository;

    public ExpenseSharingService(ExpenseSharingRepository expenseSharingRepository) {
        this.expenseSharingRepository = expenseSharingRepository;
    }

    public ExpenseSharing createExpenseSharing(ExpenseSharing expenseSharing) {
        return expenseSharingRepository.save(expenseSharing);
    }


    // Add other methods as per your requirements
}
