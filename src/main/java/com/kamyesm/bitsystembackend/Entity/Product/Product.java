package com.kamyesm.bitsystembackend.Entity.Product;

import com.kamyesm.bitsystembackend.Entity.BaseEntity;
import com.kamyesm.bitsystembackend.Entity.Order.CartItem;
import com.kamyesm.bitsystembackend.Entity.Order.OrderItem;
import com.kamyesm.bitsystembackend.Utils.Converters.StringListConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(indexes = @Index(name = "idx_product_slug", columnList = "slug"))
public class Product extends BaseEntity {

    @Column(nullable = false , unique = true)
    private String title;

    @Column(name = "slug", nullable = false, unique = true, length = 255, updatable = false)
    private String slug;

    @Column(nullable = false)
    private Long price;

    @Column(nullable = false)
    private int stock;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "specs", columnDefinition = "jsonb")
    private Map<String, Object> specs;

    @Convert(converter = StringListConverter.class)
    @Column(columnDefinition = "TEXT")
    private List<String> images = new ArrayList<>();

    private Long discounted_price;
}
