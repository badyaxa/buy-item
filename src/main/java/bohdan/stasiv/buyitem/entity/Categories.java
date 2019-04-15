package bohdan.stasiv.buyitem.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
//@NoArgsConstructor
//@ToString(exclude = "products")
@Entity
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank(message = "Name must not be empty")
    @Size(min = 2, max = 50)
    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "categories")
    private List<Products> products = new ArrayList<>();

}
