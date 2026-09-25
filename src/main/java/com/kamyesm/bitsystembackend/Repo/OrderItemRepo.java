package com.kamyesm.bitsystembackend.Repo;

import com.kamyesm.bitsystembackend.Entity.Order.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepo extends JpaRepository<String , OrderItem> {
}
