package com.kamyesm.bitsystembackend.DTO.Category;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class CategoryResponse {

    private String name;

    private String slug;

    private List<String> productTitle;
}
