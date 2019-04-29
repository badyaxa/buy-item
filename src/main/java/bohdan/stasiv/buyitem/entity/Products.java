package bohdan.stasiv.buyitem.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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

    @NotNull
    @NotBlank(message = "Name must not be empty")
    @Size(min = 2, max = 50)
    @Column(nullable = false, unique = true)
    private String name;

    private Long price;

    @ManyToOne
    private Categories category;

    @ManyToMany(mappedBy = "products")
    @ToString.Exclude
    private List<Carts> carts = new ArrayList<>();

    @ManyToMany(mappedBy = "products")
    @ToString.Exclude
    private List<Orders> orders = new ArrayList<>();

    @Transient
    private MultipartFile productImage;

}
