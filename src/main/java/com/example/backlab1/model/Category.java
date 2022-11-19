package com.example.backlab1.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
public class Category {
    @EqualsAndHashCode.Exclude
    private Long id;
    @NotEmpty(message = "Can`t be empty")
    private String name;
}
