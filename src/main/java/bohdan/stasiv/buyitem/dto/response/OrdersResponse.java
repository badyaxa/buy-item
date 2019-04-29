package bohdan.stasiv.buyitem.dto.response;

import bohdan.stasiv.buyitem.entity.Customers;
import bohdan.stasiv.buyitem.entity.Orders;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrdersResponse {

    private Long orderId;
    //    private String name;
//    private Integer year;
//    private Double volume;
    private String customerLogin;

    /*
     * or else you can return car with countryResponse
     *
     *
     * private CustomersResponse countryResponse;
     */

    public OrdersResponse(Orders order) {
        orderId = order.getId();
        customerLogin = order.getCustomer().getLogin();
//        name = car.getName();
//        year = car.getYear();
//        volume = car.getVolume();
    }
}
