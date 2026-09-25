package com.kamyesm.bitsystembackend.Repo;

import com.kamyesm.bitsystembackend.Entity.Product.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<String , Category> {
}
