package com.kamyesm.bitsystembackend.Entity.Product;

import com.kamyesm.bitsystembackend.Entity.BaseEntity;
import com.kamyesm.bitsystembackend.Utils.Converters.StringListConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Campaign extends BaseEntity {

    @Column(unique = true , nullable = false)
    private String title;

    private String description;

    private String link;

    @Convert(converter = StringListConverter.class)
    @Column(columnDefinition = "TEXT")
    private List<String> images = new ArrayList<>();

    @Column(nullable = false)
    private Instant startDate;

    @Column(nullable = false)
    private Instant endDate;



}
