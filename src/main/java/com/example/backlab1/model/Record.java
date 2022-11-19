package com.example.backlab1.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springdoc.core.converters.models.MonetaryAmount;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class Record {
    @EqualsAndHashCode.Exclude
    private Long id;
    @NotNull(message = "Can't be null")
    private Long userId;
    @NotNull(message = "Can't be null")
    private Long categoryId;
    @NotNull(message = "Can't be null")
    private LocalDateTime creationTime;
    @EqualsAndHashCode.Exclude
    private MonetaryAmount money;
}
