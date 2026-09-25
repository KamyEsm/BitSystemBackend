package com.kamyesm.bitsystembackend.Repo;

import com.kamyesm.bitsystembackend.Entity.Product.CampaignProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CampaignProductRepo extends JpaRepository<UUID, CampaignProduct> {
}
