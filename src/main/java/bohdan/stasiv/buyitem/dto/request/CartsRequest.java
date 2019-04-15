package bohdan.stasiv.buyitem.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CartsRequest {

    @NotNull
    @Min(1)
    private Long id;

}
