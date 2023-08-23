package com.Application.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Application.entity.ExpenseSharing;
import com.Application.entity.ExpenseTransaction;
import com.Application.entity.TransactionEntry;

public interface ExpenseTransactionRepository extends JpaRepository<ExpenseTransaction, Long>{

    // Add any custom query methods if needed




}
