package com.Application.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Application.entity.ExpenseSharing;

@Repository
public interface ExpenseSharingRepository extends JpaRepository<ExpenseSharing, Long> {


    // Add any custom query methods if needed
}

