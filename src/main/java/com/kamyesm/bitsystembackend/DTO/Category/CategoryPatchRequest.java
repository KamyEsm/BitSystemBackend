package com.kamyesm.bitsystembackend.DTO.Category;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class CategoryPatchRequest {

    @NotEmpty
    @NotNull
    private List<String> productList;
}
