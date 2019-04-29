package bohdan.stasiv.buyitem.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
@ToString(exclude = "orders")
@Entity
//@Table(name = "users")
public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank(message = "Name must not be empty")
    @Size(min = 2, max = 50)
    @Column(nullable = false, unique = true)
    private String login;

    @GeneratedValue(strategy = GenerationType.AUTO)
    private String password;

//    private String firstName;

//    private String lastName;

//    @Email
//    @NotBlank
//    @Column(nullable = false, updatable = false)
//    private String email;

//    private String phone;

    //    @NotNull
    private Role role;

    @OneToOne
    private Carts cart;

    @OneToMany(mappedBy = "customer")
//    private Set<Orders> orders = new HashSet<>();
    private List<Orders> orders = new ArrayList<>();

}

