package bohdan.stasiv.buyitem.controller.api;


import bohdan.stasiv.buyitem.dto.request.CartsRequest;
import bohdan.stasiv.buyitem.dto.request.PaginationRequest;
import bohdan.stasiv.buyitem.dto.response.CartsResponse;
import bohdan.stasiv.buyitem.dto.response.DataResponse;
import bohdan.stasiv.buyitem.exception.WrongInputException;
import bohdan.stasiv.buyitem.service.CartsService;
import bohdan.stasiv.buyitem.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/carts")
public class ApiCartsController {

    @Autowired
    private CartsService cartsService;

//    @GetMapping("/all")
//    public List<CartsResponse> getAll() {
//        return cartsService.findAll();
//    }

//    @GetMapping("/{id}")
//    public CartsResponse getById(@PathVariable Long id) {
//        if (id > 0) {
//            return cartsService.findOneById(id);
//        } else {
//            throw new IllegalArgumentException("Id must not be less than one!");
//        }
//    }

//    @PostMapping
//    public CartsResponse create(@RequestBody CartsRequest cartsRequest) throws WrongInputException {
//        return cartsService.create(cartsRequest);
//    }

//    @PostMapping("/page/byCustomerId")
//    public DataResponse<CartsResponse> findAllByCustomerId(@RequestParam Long customerId, @RequestBody PaginationRequest paginationRequest) throws WrongInputException {
//        return cartsService.findAllByCustomerId(customerId, paginationRequest);
//    }
//
//    @PostMapping("/page")
//    public DataResponse<CartsResponse> getPage(@RequestBody PaginationRequest paginationRequest) {
//        return cartsService.findAll(paginationRequest);
//    }
//
//    @PutMapping
//    public CartsResponse update(@RequestParam Long id, @RequestBody CartsRequest cartsRequest) throws WrongInputException {
//        return cartsService.update(id, cartsRequest);
//    }

//    @DeleteMapping
//    public void delete(@RequestParam Long id) throws WrongInputException {
//        cartsService.delete(id);
//    }
}
