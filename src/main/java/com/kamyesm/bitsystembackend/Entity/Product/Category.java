package com.kamyesm.bitsystembackend.Entity.Product;

import com.kamyesm.bitsystembackend.Entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "category")
public class Category extends BaseEntity {

    @Column(unique = true , nullable = false)
    private String name;

    @Column(name = "slug", nullable = false, unique = true, length = 255, updatable = false)
    private String slug;

    @OneToMany(mappedBy = "category")
    private List<Product> productList;

}
