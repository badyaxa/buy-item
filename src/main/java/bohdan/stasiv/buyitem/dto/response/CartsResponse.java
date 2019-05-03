package bohdan.stasiv.buyitem.dto.response;

import bohdan.stasiv.buyitem.entity.Carts;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CartsResponse {

    private Long id;
    private String login;
//    private ProductsResponse products;

    public CartsResponse(Carts cart) {
        id = cart.getId();
        login = cart.getCustomer().getLogin();
//        products = cart.getProducts().indexOf(Products);
    }
}
