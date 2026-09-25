package com.kamyesm.bitsystembackend.Repo;

import com.kamyesm.bitsystembackend.Entity.Order.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepo extends JpaRepository<String , Cart> {
}
