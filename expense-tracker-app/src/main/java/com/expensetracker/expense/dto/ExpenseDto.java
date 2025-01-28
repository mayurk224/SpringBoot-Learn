package com.expensetracker.expense.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.time.LocalDate;

@Schema(
        description = "Expense DTO (Data Transfer Object) to transfer the data between client and server"
)
public record ExpenseDto(Long id,
                         @Schema(
                                 description = "Expense amount"
                         )
                         BigDecimal amount,
                         @Schema(
                                 description = "Expense Created Date"
                         )
                         LocalDate expenseDate,
                         @Schema(
                                 description = "Associated Expense Category"
                         )
                         CategoryDto categoryDto) {
}
