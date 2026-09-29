package com.kamyesm.bitsystembackend.Entity.Auth;

import com.kamyesm.bitsystembackend.Entity.BaseEntity;
import com.kamyesm.bitsystembackend.Utils.Enum.StaffAccountStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Staff extends BaseEntity {

    @Column(nullable = false)
    private String firstName;

    private String lastName;

    @Column(name = "phone", length = 15, unique = true)
    private String phone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id" , nullable = false)
    private Role role;

    @Column(nullable = false , unique = true)
    private String userName;

    @Column(nullable = false)
    private String passwordHash;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private StaffAccountStatus accountStatus;

    private int failedLoginAttempts;

    private Instant lockedUntil;

    private Instant lastLoginAt;

    private String lastLoginIp;

    @CreatedBy
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by_id")
    private Staff createdBy;

}
