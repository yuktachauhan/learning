package com.example.learning.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotEmpty;


@Entity
@Data
@NoArgsConstructor
public class BookModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String author;

    @NotEmpty
    private String publication;

    @NotEmpty
    private String price;

    @NotEmpty
    private String pages;
}
