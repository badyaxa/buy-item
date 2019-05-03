package bohdan.stasiv.buyitem.dto.request;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class ProductsRequest {

    @NotNull
    @Size(min = 3, max = 50)
    private String name;

    @Positive
    private BigDecimal price;

    @NotNull
    @Positive
    private Long categoryId;

//    @Positive
//    private Long brandId;

}
