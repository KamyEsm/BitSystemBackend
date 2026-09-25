package com.kamyesm.bitsystembackend.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass // اعلام میکند که جدول نیست بلکه یک قالب اماده است برای ارث بری انتیتی های دیگر برای جولوگیری از تکرار بیهوده کد
@EntityListeners(AuditingEntityListener.class) //لیستنر برای صدا کردن این کلاس قبل از ساخته شدن رکورد
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false)
    @JdbcTypeCode(SqlTypes.UUID)
    private UUID id;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private Instant updatedAt;
}