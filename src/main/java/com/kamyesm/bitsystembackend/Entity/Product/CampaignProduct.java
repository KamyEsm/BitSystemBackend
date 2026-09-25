package com.kamyesm.bitsystembackend.Entity.Product;

import com.kamyesm.bitsystembackend.Entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(
        name = "campaign_product",
        uniqueConstraints = {
                // جلوگیری از ثبت تکراری یک محصول در یک کمپین یکسان
                @UniqueConstraint(name = "uk_campaign_product", columnNames = {"campaign_id", "product_id"})
        }
)
@Getter
@Setter
@NoArgsConstructor
public class CampaignProduct extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "campaign_id", nullable = false)
    private Campaign campaign;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "discount_percentage")
    private Integer discountPercentage;

}