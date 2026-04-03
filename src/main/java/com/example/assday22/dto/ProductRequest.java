package com.example.assday22.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class ProductRequest {

    @NotBlank(message = "Name wajib diisi")
    private String name;

    @NotNull(message = "Price wajib diisi")
    @Positive(message = "Price harus lebih dari 0")
    private Double price;

    private String description;

    @NotNull(message = "Stock wajib diisi")
    @Min(value = 0, message = "Stock minimal 0")
    private Integer stock;

    // getter setter
}
