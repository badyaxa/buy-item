package bohdan.stasiv.buyitem.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CategoriesRequest {

    @NotBlank
    @Size(min = 2, max = 50)
    private String name;

}
