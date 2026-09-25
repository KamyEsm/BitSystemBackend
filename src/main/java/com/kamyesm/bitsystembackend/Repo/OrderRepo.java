package com.kamyesm.bitsystembackend.Repo;

import com.kamyesm.bitsystembackend.Entity.Order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<String , Order> {
}
