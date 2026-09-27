package com.kamyesm.bitsystembackend.DTO.Category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class CategoryRequest {

    @Size(min = 3 , max = 30)
    @NotBlank
    private String name;

    private List<String> productList;
}

