package com.kamyesm.bitsystembackend.Entity.Auth;


import com.kamyesm.bitsystembackend.Entity.BaseEntity;
import com.kamyesm.bitsystembackend.Entity.Order.Cart;
import com.kamyesm.bitsystembackend.Entity.Order.Order;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.kamyesm.bitsystembackend.Utils.Converters.StringListConverter;
import org.hibernate.annotations.Check;
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
@Table(name = "users")
@Check(
        name = "chk_phone_iranian_format",
        constraints = "phone ~ '^(\\+98|0098|98|0)?9[0-9]{9}$'"
)
public class User  extends BaseEntity {

    @Column(nullable = false)
    private String firstName;

    private String lastName;

    @Column(name = "phone", length = 15, nullable = false, unique = true)
    private String phone;

    @ManyToOne
    @JoinColumn(name = "role_id" , nullable = false)
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<Order> orderList;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Cart cart;

    private String hashedPassword;

}
