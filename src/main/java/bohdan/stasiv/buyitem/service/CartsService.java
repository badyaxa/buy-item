package bohdan.stasiv.buyitem.service;

import bohdan.stasiv.buyitem.dto.request.CartsRequest;
import bohdan.stasiv.buyitem.dto.request.PaginationRequest;
import bohdan.stasiv.buyitem.dto.response.CartsResponse;
import bohdan.stasiv.buyitem.dto.response.DataResponse;
import bohdan.stasiv.buyitem.entity.Carts;
import bohdan.stasiv.buyitem.entity.Customers;
import bohdan.stasiv.buyitem.entity.Products;
import bohdan.stasiv.buyitem.exception.WrongInputException;
import bohdan.stasiv.buyitem.repository.CartsRepository;
import bohdan.stasiv.buyitem.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CartsService {

//    @Autowired
//    private CustomersService customersService;

    @Autowired
    private ProductsService productsService;

    @Autowired
    private CartsRepository cartsRepository;

    private Map<Products, Integer> products = new HashMap<>();

    public void addProduct(Products product) {
        if (products.containsKey(product)) {
            products.replace(product, products.get(product) + 1);
        } else {
            products.put(product, 1);
        }
    }

    public void removeProduct(Products product) {
        if (products.containsKey(product)) {
            if (products.get(product) > 1)
                products.replace(product, products.get(product) - 1);
            else if (products.get(product) == 1) {
                products.remove(product);
            }
        }
    }

//    public Map<Products, Integer> getProductsInCart() {
//        return Collections.unmodifiableMap(products);
//    }
//    public void checkout() throws NotEnoughProductsInStockException {
//        Product product;
//        for (Map.Entry<Products, Integer> entry : products.entrySet()) {
//            // Refresh quantity for every product before checking
//            product = productsRepository.findOne(entry.getKey().getId());
//            if (product.getQuantity() < entry.getValue())
//                throw new NotEnoughProductsInStockException(product);
//            entry.getKey().setQuantity(product.getQuantity() - entry.getValue());
//        }
//        productsRepository.save(products.keySet());
//        productsRepository.flush();
//        products.clear();
//    }

//    public BigDecimal getTotal() {
//        return products.entrySet().stream()
//                .map(entry -> entry.getKey().getPrice().multiply(BigDecimal.valueOf(entry.getValue())))
//                .reduce(BigDecimal::add)
//                .orElse(BigDecimal.ZERO);
//    }


//    public DataResponse<CartsResponse> findAllByCustomerId(Long customerId, PaginationRequest paginationRequest) throws WrongInputException {
//        Customers customer = customersService.findOne(customerId);
//        Page<Carts> byCustomer = cartsRepository.findAllByCustomer(customer, paginationRequest.mapToPageRequest());
//        return new DataResponse<>(byCustomer.get().map(CartsResponse::new).collect(Collectors.toList()),
//                byCustomer.getTotalPages(), byCustomer.getTotalElements());
//    }
//
//    public CartsResponse create(CartsRequest cartsRequest) throws WrongInputException {
//        return new CartsResponse(cartsRequestToCarts(null, cartsRequest));
//    }
//
//    public Carts findOne(Long id) throws WrongInputException {
//        return cartsRepository.findById(id).orElseThrow(() -> new WrongInputException("Order with id " + id + " not exists"));
//    }
//
//    public CartsResponse findOneById(Long id) {
//        Optional<Carts> cartsOptional = cartsRepository.findById(id);
//        if (cartsOptional.isPresent()) {
//            return new CartsResponse(cartsOptional.get());
//        } else {
//            throw new IllegalArgumentException("Order with id " + id + " not found");
//        }
//    }
//
//    public List<CartsResponse> findAll() {
//        return cartsRepository.findAll().stream().map(CartsResponse::new).collect(Collectors.toList());
//    }
//
//    public DataResponse<CartsResponse> findAll(PaginationRequest pagination) {
//        Page<Carts> all = cartsRepository.findAll(pagination.mapToPageRequest());
//        return new DataResponse<>(all.get().map(CartsResponse::new).collect(Collectors.toList()),
//                all.getTotalPages(), all.getTotalElements());
//    }
//
//    public CartsResponse update(Long id, CartsRequest cartsRequest) throws WrongInputException {
//        return new CartsResponse(cartsRequestToCarts(findOne(id), cartsRequest));
//    }
//
//    public void delete(Long id) throws WrongInputException {
//        cartsRepository.delete(findOne(id));
//    }
//
//    private Carts cartsRequestToCarts(Carts carts, CartsRequest request) throws WrongInputException {
//        if (carts == null) {
//            carts = new Carts();
//        }
//        carts.setCustomer(customersService.findOne(request.getCustomerId()));
////        carts.setName(request.getName());
////        carts.setVolume(request.getVolume());
////        carts.setYear(request.getYear());
//        return cartsRepository.save(carts);
//    }
}
