package bohdan.stasiv.buyitem.dto.response;

import bohdan.stasiv.buyitem.entity.Customers;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CustomersResponse {

    private Long id;
    private String login;
    private String role;

    public CustomersResponse(Customers customer) {
        id = customer.getId();
        login = customer.getLogin();
        role = customer.getRole().name();
    }
}
