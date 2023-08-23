package com.Application.entity;


import java.util.List;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "expense_sharing")
public class ExpenseSharing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private String category;

    @ElementCollection
    @CollectionTable(name = "expense_sharing_participants")
    private List<String> participants;

    // Constructors


    // Getters and Setters

}

