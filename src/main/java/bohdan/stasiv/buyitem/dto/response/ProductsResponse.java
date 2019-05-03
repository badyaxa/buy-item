package bohdan.stasiv.buyitem.dto.response;

import bohdan.stasiv.buyitem.entity.Products;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class ProductsResponse {

    private Long id;
    private String name;
    private BigDecimal price;
    private String categoryName;
//    private String brandName;
//    private Double volume;

    /*
     * or else you can return car with countryResponse
     *
     *
     * private CustomersResponse countryResponse;
     */

    public ProductsResponse(Products product/*, Categories category*/) {
        id = product.getId();
        name = product.getName();
        price = product.getPrice();
        categoryName = product.getCategory().getName();
//        brandName = product.getBrand().getName();
//        year = product.getYear();
    }
}
