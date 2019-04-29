package bohdan.stasiv.buyitem.controller.api;

import bohdan.stasiv.buyitem.dto.request.CustomersRequest;
import bohdan.stasiv.buyitem.dto.request.PaginationRequest;
import bohdan.stasiv.buyitem.dto.response.CustomersResponse;
import bohdan.stasiv.buyitem.dto.response.DataResponse;
import bohdan.stasiv.buyitem.exception.WrongInputException;
import bohdan.stasiv.buyitem.service.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/customers")
public class ApiCustomersController {

    @Autowired
    private CustomersService customersService;

    @GetMapping("/all")
    public List<CustomersResponse> getAll() {
        return customersService.findAll();
    }

    @GetMapping("/{id}")
    public CustomersResponse getById(@PathVariable Long id) {
        if (id > 0) {
            return customersService.findOneById(id);
        } else {
            throw new IllegalArgumentException("Id must not be less than one!");
        }
    }

    @PostMapping
    public CustomersResponse create(@RequestBody CustomersRequest customerRequest) {
        return customersService.create(customerRequest);
    }

    @PostMapping("/page")
    public DataResponse<CustomersResponse> getPage(@RequestBody PaginationRequest paginationRequest) {
        return customersService.findAll(paginationRequest);
    }

    @PutMapping
    public CustomersResponse update(@RequestBody CustomersRequest customerRequest, @RequestParam Long id) throws WrongInputException {
        return customersService.update(customerRequest, id);
    }

    @DeleteMapping
    public void delete(@RequestParam Long id) throws WrongInputException {
        customersService.delete(id);
    }
}
