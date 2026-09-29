package com.kamyesm.bitsystembackend.Controller;


import com.kamyesm.bitsystembackend.DTO.Category.CategoryRequest;
import com.kamyesm.bitsystembackend.DTO.Category.CategoryResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/shop/category")
public class CategoryController {

    @PostMapping
    public ResponseEntity<CategoryResponse> createCategory(@RequestBody @Valid CategoryRequest category){
        //////////////////
        return null;
    }

    @GetMapping("/{name}")
    public ResponseEntity<CategoryResponse> getCategoryByName(@PathVariable String name) {
        return null;
    }

    @GetMapping()
    public ResponseEntity<List<CategoryResponse>> getAll() {
        return null;
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<?> deleteCategoryByName(@PathVariable String name) {
        return null;
    }

    @PutMapping("/{name}")
    public ResponseEntity<CategoryRequest> putCategory(@RequestBody CategoryRequest category ,
                                                          @PathVariable String name) {
        return null;
    }

    @GetMapping("/{slug}")
    public ResponseEntity<CategoryResponse> getBySlug(@PathVariable String slug) {
        return null;
    }



}
