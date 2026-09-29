package com.kamyesm.bitsystembackend.Entity.Auth;

import com.kamyesm.bitsystembackend.Entity.BaseEntity;
import com.kamyesm.bitsystembackend.Utils.Enum.AccountStatus;
import com.kamyesm.bitsystembackend.Utils.Enum.StaffRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;

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

    @Enumerated(EnumType.STRING)
    @JoinColumn(nullable = false)
    private StaffRole role;

    @Column(nullable = false , unique = true)
    private String userName;

    @Column(nullable = false)
    private String passwordHash;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private AccountStatus accountStatus;

    private int failedLoginAttempts;

    private Instant lockedUntil;

    private Instant lastLoginAt;

    private String lastLoginIp;

    @CreatedBy
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by_id")
    private Staff createdBy;

}
