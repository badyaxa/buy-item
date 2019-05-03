package bohdan.stasiv.buyitem.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
//@ToString(exclude = "products")
@Entity
public class Carts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "cart")
    private Customers customer;

    @ManyToMany
    private List<Products> products = new ArrayList<>();

}
