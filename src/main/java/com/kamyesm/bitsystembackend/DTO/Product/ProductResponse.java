package com.kamyesm.bitsystembackend.DTO.Product;

import java.util.List;
import java.util.Map;

public class ProductResponse {

    private String title;
    private String slug;
    private Long price;
    private int stock;
    private String categoryName;
    private Map<String , Object> specs;
    private List<String> images;
    private Long discountedPrice;
}
