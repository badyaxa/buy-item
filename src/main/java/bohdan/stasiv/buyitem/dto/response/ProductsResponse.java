package bohdan.stasiv.buyitem.dto.response;

import bohdan.stasiv.buyitem.entity.Products;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductsResponse {

    private Long id;

    private String name;

    private String brandName;

    private String categoryName;


//    private Integer year;

//    private Double volume;


    /*
     * or else you can return car with countryResponse
     *
     *
     * private CountryResponse countryResponse;
     */

    public ProductsResponse(Products product/*, Categories category*/) {
        id = product.getId();
        name = product.getName();
//        brandName = product.getBrand().getName();
//        categoryName = product.getCategory().getName();
//        year = product.getYear();
//        volume = product.getVolume();
    }
}