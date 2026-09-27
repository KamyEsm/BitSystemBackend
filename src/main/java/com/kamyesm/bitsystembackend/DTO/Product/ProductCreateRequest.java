package com.kamyesm.bitsystembackend.DTO.Product;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ProductCreateRequest {
    @NotBlank
    @Size(min = 3 , max = 100)
    private String title;

    @NotNull
    private Long price;

    @NotNull
    @Min(0)
    private int stock;

    @NotBlank
    private String categoryName;

    @NotNull
    private Map<String , Object> specs;

    @NotNull
    private List<String> images;

    @Min(0)
    private Long discounted_price;
}
