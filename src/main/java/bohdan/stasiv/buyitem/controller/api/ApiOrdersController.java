package bohdan.stasiv.buyitem.controller.api;

import bohdan.stasiv.buyitem.dto.request.OrdersRequest;
import bohdan.stasiv.buyitem.dto.request.PaginationRequest;
import bohdan.stasiv.buyitem.dto.response.DataResponse;
import bohdan.stasiv.buyitem.dto.response.OrdersResponse;
import bohdan.stasiv.buyitem.exception.WrongInputException;
import bohdan.stasiv.buyitem.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/orders")
public class ApiOrdersController {

    @Autowired
    private OrdersService ordersService;

    @GetMapping("/all")
    public List<OrdersResponse> getAll() {
        return ordersService.findAll();
    }

    @GetMapping("/{id}")
    public OrdersResponse getById(@PathVariable Long id) {
        if (id > 0) {
            return ordersService.findOneById(id);
        } else {
            throw new IllegalArgumentException("Id must not be less than one!");
        }
    }

    @PostMapping
    public OrdersResponse create(@RequestBody OrdersRequest ordersRequest) throws WrongInputException {
        return ordersService.create(ordersRequest);
    }

    @PostMapping("/page/byCustomerId")
    public DataResponse<OrdersResponse> findAllByCustomerId(@RequestParam Long customerId, @RequestBody PaginationRequest paginationRequest) throws WrongInputException {
        return ordersService.findAllByCustomerId(customerId, paginationRequest);
    }

    @PutMapping
    public OrdersResponse update(@RequestParam Long id, @RequestBody OrdersRequest ordersRequest) throws WrongInputException {
        return ordersService.update(id, ordersRequest);
    }

    @DeleteMapping
    public void delete(@RequestParam Long id) throws WrongInputException {
        ordersService.delete(id);
    }
}
