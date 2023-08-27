package com.Application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Application.entity.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {


    // Add any custom query methods if needed
    List<Expense> findAllExpensesByGroupId(Long groupId);

}
