package com.kamyesm.bitsystembackend.Repo;

import com.kamyesm.bitsystembackend.Entity.Product.CampaignProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampaignProductRepo extends JpaRepository<String , CampaignProduct> {
}
