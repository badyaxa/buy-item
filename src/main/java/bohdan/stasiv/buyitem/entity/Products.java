package bohdan.stasiv.buyitem.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Products {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer price;

    @ManyToOne
    private Categories categories;

    @ManyToMany(mappedBy = "products")
    private List<Carts> carts = new ArrayList<>();

    @ManyToMany(mappedBy = "products")
    private List<Orders> orders = new ArrayList<>();

}
