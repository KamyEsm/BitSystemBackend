package com.kamyesm.bitsystembackend.Repo;

import com.kamyesm.bitsystembackend.Entity.Auth.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<String , Role> {
}
