package bohdan.stasiv.buyitem.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;

    @OneToOne
    private Carts carts;

    @OneToMany(mappedBy = "users")
    private Set<Orders> orders = new HashSet<>();

}

