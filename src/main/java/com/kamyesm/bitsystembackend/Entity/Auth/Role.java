package com.kamyesm.bitsystembackend.Entity.Auth;

import com.kamyesm.bitsystembackend.Entity.BaseEntity;
import jakarta.persistence.*;
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
@Table(name = "role")
public class Role  extends BaseEntity {


    @Column(nullable = false , unique = true)
    private String name;

    private String description;

    @OneToMany(mappedBy = "role")
    private List<User> userList;


}
