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
import org.springframework.util.CollectionUtils;

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

    public Expense updateExpense(Long expenseId, Expense expense) {
        Expense expenseFromDB =  expenseRepository.findById(expenseId).orElseThrow(() -> new RuntimeException("Expense id "+expenseId+" not found"));
        expense.setId(expenseId);
        Long groupId= expenseFromDB.getGroupId();
        expense.setGroupId(groupId);
        if(Objects.equals(expense, expenseFromDB)){
            throw new RuntimeException("No changes found. Expense details remain the same.");
        }

        ExpenseSharing expenseSharing = expenseSharingRepository.findById(groupId).orElseThrow(() -> new RuntimeException("Expense Sharing group with id " + groupId + " not found"));

        preValidationExpense(expense, expenseSharing);

        expenseFromDB.setTitle(expense.getTitle());
        expenseFromDB.setAmount(expense.getAmount());
        expenseFromDB.setPaidBy(expense.getPaidBy());
        expenseFromDB.getForWhom().addAll(expense.getForWhom());
        expenseFromDB.setPaymentDate(expense.getPaymentDate());
        expenseFromDB.setGroupId(expense.getGroupId());
        return expenseRepository.save(expenseFromDB);
    }


    // Add other methods as per your requirements

    private void preValidationExpense(Expense expense, ExpenseSharing expenseSharing) {
        if (Objects.isNull(expense.getTitle()) || expense.getTitle().isEmpty() || expense.getTitle().isBlank() ) {
            throw new RuntimeException("Title of the group should not be null or blank");
        }
        if (Objects.isNull(expense.getPaidBy()) || expense.getPaidBy().isEmpty() || expense.getPaidBy().isBlank() ) {
            throw new RuntimeException("PaidBy of the group should not be null or blank");
        }
        if(CollectionUtils.isEmpty(expense.getForWhom()) || expense.getForWhom().stream().filter(Objects::nonNull).filter(str -> !str.trim().isBlank()).count() <= 1 ) {
            throw new RuntimeException("Participants list should contain more than 1 non-blank participant");
        }

        if(Objects.nonNull(expenseSharing)) {
            if (!expenseSharing.getParticipants().contains(expense.getPaidBy())) {
                throw new RuntimeException("Paid by participant '" + expense.getPaidBy() + "' is not found in the participants list");
            }

            List<String> participants = expenseSharing.getParticipants();
            participants.replaceAll(String::toLowerCase);

            for(String fromWhom : expense.getForWhom()) {
                if(!participants.contains(fromWhom.toLowerCase())) {
                    throw new RuntimeException("Participant-2 '" + fromWhom + "' is not found in the participants list"+expenseSharing.getParticipants());
                }
            }
        }
    }
}

