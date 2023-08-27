package com.Application.controller;

import com.Application.entity.Expense;
import com.Application.entity.ExpenseSharing;
import com.Application.repository.ExpenseRepository;
import com.Application.repository.ExpenseSharingRepository;
import com.Application.repository.ExpenseTransactionRepository;
import com.Application.service.ExpenseService;
import com.Application.service.ExpenseSharingService;

import jakarta.transaction.Transactional;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

@RestController
public class ExpenseController {
    private final ExpenseSharingService expenseSharingService;

    private final ExpenseService expenseService;

    @Autowired
    private  ExpenseRepository expenseRepository;

    @Autowired
    private  ExpenseSharingRepository expenseSharingRepository;


    @Autowired
    private  ExpenseTransactionRepository expenseTransactionRepository;

    public ExpenseController(ExpenseSharingService expenseSharingService,ExpenseService expenseService) {
        this.expenseSharingService = expenseSharingService;
        this.expenseService=expenseService;
    }

    //Endpoint 1
    @PostMapping("/expense/group")
    public ResponseEntity<Object> createExpenseSharing(@RequestBody ExpenseSharing expenseSharing) {
        Map<String, Object> response = new HashMap<>();
        try{
            preValidationExpenseSharing(expenseSharing);
            ExpenseSharing savedExpenseSharing = expenseSharingService.createExpenseSharing(expenseSharing);
            return ResponseEntity.ok(savedExpenseSharing);
        }catch (Exception exe) {
            response.put("success", false);
            response.put("message", exe.getMessage());
        }
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }

    //Endpoint 2
    @GetMapping("/expense/groups")
    public ResponseEntity<?> getAllExpenseSharing() {
        return ResponseEntity.ok(expenseSharingRepository.findAll());
    }

    //Endpoint 3
    @GetMapping("/expense/groupById/{id}")
    public ResponseEntity<?> getExpenseSharingById(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            ExpenseSharing expenseSharing =  expenseSharingService.getExpenseSharingById(id);
            return ResponseEntity.ok(expenseSharing);
        } catch (Exception exe) {
            response.put("success", false);
            response.put("message", exe.getMessage());
        }
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }


    //Endpoint 4
    @PostMapping("/expense/group/update/{id}")
    public ResponseEntity<?> updateExpenseSharing(@PathVariable Long id, @RequestBody ExpenseSharing expenseSharing ) {
        Map<String, Object> response = new HashMap<>();
        try{
            ExpenseSharing updatedExpenseSharing = expenseSharingService.updateExpenseSharing(id, expenseSharing);
            return ResponseEntity.ok(expenseSharing);
        } catch (Exception exe) {
            response.put("success", false);
            response.put("message", exe.getMessage());
        }
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }

    //Endpoint 5
    @PostMapping("/expense/group/delete/{id}")
    public ResponseEntity<?> deleteExpenseSharingById(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            expenseSharingService.deleteExpenseSharingById(id);
            response.put("success", true);
            return ResponseEntity.ok(response);
        } catch (Exception exe) {
            response.put("success", false);
            response.put("message", exe.getMessage());
        }
        return new ResponseEntity<>(response,HttpStatus.NOT_MODIFIED);
    }

    //Endpoint 6
    @PostMapping("/expense/group/{groupId}/addExpense")
    public ResponseEntity<?> createExpense(@PathVariable Long groupId, @RequestBody Expense expense) {
        Map<String, Object> response = new HashMap<>();
        try {
            //preValidationExpense(expense, null);
            ExpenseSharing expenseSharing = expenseSharingRepository.findById(groupId).orElseThrow( () -> new RuntimeException("Expense Sharing group with id " + groupId + " not found"));
            preValidationExpense(expense, expenseSharing);
            expense.setGroupId(groupId);
            Expense savedExpense = expenseRepository.save(expense);
            return ResponseEntity.ok(savedExpense);
        } catch (Exception exe) {
            response.put("success", false);
            response.put("message", exe.getMessage());
        }
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }

    //Endpoint 7
    @GetMapping("/expense")
    public ResponseEntity<?> getAllExpenses() {
        Map<String, Object> response = new HashMap<>();
        try{
            return ResponseEntity.ok(expenseRepository.findAll());
        } catch (Exception exe){
            response.put("success", false);
            response.put("message", exe.getMessage());
        }
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }

    //Endpoint 8
    @GetMapping("/expense/group/{groupId}")
    public ResponseEntity<?> getAllExpensesByGroupId(@PathVariable Long groupId) {
        Map<String, Object> response = new HashMap<>();
        try{
            List<Expense> expensesFromDB =  expenseRepository.findAllExpensesByGroupId(groupId);
            return ResponseEntity.ok(expensesFromDB);
        } catch (Exception exe) {
            response.put("success", false);
            response.put("message", exe.getMessage());
        }
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }

    //Endpoint 9
    @GetMapping("/expense/{expenseId}")
    public ResponseEntity<?> getExpenseById(@PathVariable Long expenseId) {
        Map<String, Object> response = new HashMap<>();
        try{
            Expense expenseFromDB =  expenseRepository.findById(expenseId).orElseThrow(() -> new RuntimeException("Expense group with id "+expenseId+" not found"));
            return ResponseEntity.ok(expenseFromDB);
        } catch (Exception exe) {
            response.put("success", false);
            response.put("message", exe.getMessage());
        }
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }


    //Endpoint 10
    @PostMapping("/expense/update/{expense_id}")
    public ResponseEntity<?> updateExpense(@PathVariable("expense_id") Long expenseId) {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Logic for updating expense using expense id");
        return ResponseEntity.ok(response);
    }


    //Endpoint 11
    @PostMapping("/expense/delete/{expenseId}")
    public ResponseEntity<?> deleteExpense(@PathVariable Long expenseId) {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Logic for deleting expense using expense id");
        return ResponseEntity.ok(response);
    }




    //Endpoint 12
    @GetMapping("/expense/transaction/{expenseId}")
    public ResponseEntity<Object> getTransactionEntriesByExpenseId(@PathVariable Long expenseId) {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Logic for retriving individual contribution in expense using expense id");
        return ResponseEntity.ok(response);
    }

    //Endpoint 13
    @GetMapping("/expense/group/{groupId}/balance")
    public ResponseEntity<Object> getGroupBalance(@PathVariable Long groupId) {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Logic for retrieving individual balance combining all expenses using group id");
        return ResponseEntity.ok(response);
    }


    // Add other endpoints as per your requirements
    private void preValidationExpenseSharing(ExpenseSharing expenseSharing) {
        if (Objects.isNull(expenseSharing.getTitle()) || expenseSharing.getTitle().isEmpty() || expenseSharing.getTitle().isBlank() ) {
            throw new RuntimeException("Title of the group should not be null or blank");
        }
        if(CollectionUtils.isEmpty(expenseSharing.getParticipants()) || expenseSharing.getParticipants().stream().filter(Objects::nonNull).filter(str -> !str.trim().isBlank()).count() <= 1 ) {
            throw new RuntimeException("Participants list should contain more than 1 non-blank participant");
        }
    }

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
