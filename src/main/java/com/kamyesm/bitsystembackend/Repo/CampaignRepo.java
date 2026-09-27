package com.kamyesm.bitsystembackend.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface CampaignRepo extends JpaRepository<CampaignRepo, UUID> {
}
