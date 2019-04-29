package bohdan.stasiv.buyitem.controller.api;

import bohdan.stasiv.buyitem.dto.request.CategoriesRequest;
import bohdan.stasiv.buyitem.dto.request.PaginationRequest;
import bohdan.stasiv.buyitem.dto.response.CategoriesResponse;
import bohdan.stasiv.buyitem.dto.response.DataResponse;
import bohdan.stasiv.buyitem.exception.WrongInputException;
import bohdan.stasiv.buyitem.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/categories")
public class ApiCategoriesController {

    @Autowired
    private CategoriesService categoriesService;

    @GetMapping("/all")
    public List<CategoriesResponse> getAll() {
        return categoriesService.findAll();
    }

    @GetMapping("/{id}")
    public CategoriesResponse getById(@PathVariable Long id) {
        if (id > 0) {
            return categoriesService.findOneById(id);
        } else {
            throw new IllegalArgumentException("Id must not be less than one!");
        }
    }

    @PostMapping
    public CategoriesResponse create(@RequestBody @Valid CategoriesRequest categoriesRequest) {
        return categoriesService.create(categoriesRequest);
    }

    @PostMapping("/page")
    public DataResponse<CategoriesResponse> getPage(@RequestBody PaginationRequest paginationRequest) {
        return categoriesService.findAll(paginationRequest);
    }

    @PutMapping
    public CategoriesResponse update(@RequestBody @Valid CategoriesRequest categoriesRequest, @RequestParam Long id) throws WrongInputException {
        if (id > 0) {
            return categoriesService.update(categoriesRequest, id);
        } else {
            throw new IllegalArgumentException("Id must not be less than one!");
        }
    }

    @DeleteMapping
    public void delete(@RequestParam Long id) {
        if (id > 0) {
            categoriesService.delete(id);
        } else {
            throw new IllegalArgumentException("Id must not be less than one!");
        }
    }

}
