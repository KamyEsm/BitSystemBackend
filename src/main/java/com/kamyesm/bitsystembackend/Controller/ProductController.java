package com.kamyesm.bitsystembackend.Controller;

import com.kamyesm.bitsystembackend.DTO.Category.CategoryResponse;
import com.kamyesm.bitsystembackend.DTO.Product.ProductCreateRequest;
import com.kamyesm.bitsystembackend.DTO.Product.ProductResponse;
import com.kamyesm.bitsystembackend.DTO.Product.ProductUpdateRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController {

    @PostMapping("/")
    public ResponseEntity<ProductResponse> createProduct(@RequestBody @Valid ProductCreateRequest value) {
        return null;
    }

    @GetMapping("/")
    public ResponseEntity<List<ProductResponse>> getAll() {
        return null;
    }

    @GetMapping("/{title}")
    public ResponseEntity<ProductResponse> getByTitle(@PathVariable String title) {
        return null;
    }

    @PutMapping("/{title}")
    public ResponseEntity<?> putByTitle(@RequestBody @Valid ProductCreateRequest value ,@PathVariable String title) {
        return null;
    }

    @PatchMapping("/{title}")
    public ResponseEntity<ProductResponse> patch(@RequestBody ProductUpdateRequest value
            , String title) {
        return null;
    }
    @DeleteMapping("/{name}")
    public ResponseEntity<?> deleteProductByName(@PathVariable String name) {
        return null;
    }

    @GetMapping("/{categoryName}")
    public ResponseEntity<ProductResponse> getByCategory(@PathVariable String categoryName) {
        return null;
    }

    @GetMapping("/discounted-product")
    public ResponseEntity<List<ProductResponse>> getDiscountedProduct() {
        return null;
    }

    @GetMapping("/{slug}")
    public ResponseEntity<ProductResponse> getBySlug(@PathVariable String slug) {
        return null;
    }
}
