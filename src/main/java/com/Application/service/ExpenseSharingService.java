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

    public ExpenseSharing getExpenseSharingById(Long id) {
        return expenseSharingRepository.findById(id).orElseThrow(() -> new RuntimeException("Expense sharing group with id "+id+" not found"));
    }

    public ExpenseSharing updateExpenseSharing(Long id, ExpenseSharing expenseSharing) {
        ExpenseSharing expenseSharingFromDB =  expenseSharingRepository.findById(id).orElseThrow(() -> new RuntimeException("Expense sharing group with id "+id+" not found"));
        expenseSharing.setId(id);
        if(Objects.equals(expenseSharing, expenseSharingFromDB)) {
            throw new RuntimeException("Expense Sharing details are the same. No updation required.");
        }
        expenseSharingFromDB.setTitle(expenseSharing.getTitle());
        expenseSharingFromDB.setCategory(expenseSharing.getCategory());
        expenseSharingFromDB.setDescription(expenseSharing.getDescription());
        expenseSharingFromDB.getParticipants().addAll(expenseSharing.getParticipants());

        return expenseSharingRepository.save(expenseSharingFromDB);
    }

    public void deleteExpenseSharingById(Long id) {
        ExpenseSharing expenseSharingFromDB =  expenseSharingRepository.findById(id).orElseThrow(() -> new RuntimeException("Expense sharing group with id "+id+" not found"));
        expenseSharingRepository.delete(expenseSharingFromDB);
    }


    // Add other methods as per your requirements
}
