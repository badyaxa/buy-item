package bohdan.stasiv.buyitem.dto.response;

import bohdan.stasiv.buyitem.entity.Categories;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriesResponse {

    private Long id;
    private String name;

    public CategoriesResponse(Categories category) {
        this.id = category.getId();
        this.name = category.getName();
    }
}
