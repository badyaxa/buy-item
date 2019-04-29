package bohdan.stasiv.buyitem.controller.api;

import bohdan.stasiv.buyitem.dto.request.PaginationRequest;
import bohdan.stasiv.buyitem.dto.request.ProductsRequest;
import bohdan.stasiv.buyitem.dto.response.DataResponse;
import bohdan.stasiv.buyitem.dto.response.ProductsResponse;
import bohdan.stasiv.buyitem.exception.WrongInputException;
import bohdan.stasiv.buyitem.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/product")
public class ApiProductsController {

    @Autowired
    private ProductsService productsService;

    @GetMapping("/all")
    public List<ProductsResponse> getAll() {
        return productsService.findAll();
    }

    @GetMapping("/{id}")
    public ProductsResponse getById(@PathVariable Long id) {
        if (id > 0) {
            return productsService.findOneById(id);
        } else {
            throw new IllegalArgumentException("Id must not be less than one!");
        }
    }

    @PostMapping
    public ProductsResponse create(@RequestBody @Valid ProductsRequest productsRequest) throws WrongInputException {
        return productsService.create(productsRequest);
    }

    @PostMapping("/page/byCategoryId")
    public DataResponse<ProductsResponse> findAllByCategoryId(@RequestParam Long categoryId, @RequestBody PaginationRequest paginationRequest) throws WrongInputException {
        return productsService.findAllByCategoryId(categoryId, paginationRequest);
    }

    @PostMapping("/page")
    public DataResponse<ProductsResponse> getPage(@RequestBody PaginationRequest paginationRequest) {
        return productsService.findAll(paginationRequest);
    }

    @PutMapping
    public ProductsResponse update(@RequestBody @Valid ProductsRequest productsRequest, @RequestParam Long id) throws WrongInputException {
        if (id > 0) {
            return productsService.update(id, productsRequest);
        } else {
            throw new IllegalArgumentException("Id must not be less than one!");
        }
    }

    @DeleteMapping
    public void delete(@RequestParam Long id) throws WrongInputException {
        if (id > 0) {
            productsService.delete(id);
        } else {
            throw new IllegalArgumentException("Id must not be less than one!");
        }
    }

}
