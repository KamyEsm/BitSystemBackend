package com.kamyesm.bitsystembackend.DTO.Product;

import jakarta.validation.constraints.*;
import lombok.*;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ProductUpdateRequest {

    @Max(100)
    private String title;

    private Long price;

    @Min(0)
    private int stock;

    private String categoryName;

    private Map<String , Object> specs;

    private List<String> images;

    @Min(0)
    private Long discounted_price;
}
