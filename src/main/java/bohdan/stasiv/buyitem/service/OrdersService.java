package bohdan.stasiv.buyitem.service;

import bohdan.stasiv.buyitem.dto.request.OrdersRequest;
import bohdan.stasiv.buyitem.dto.request.PaginationRequest;
import bohdan.stasiv.buyitem.dto.response.DataResponse;
import bohdan.stasiv.buyitem.dto.response.OrdersResponse;
import bohdan.stasiv.buyitem.entity.Customers;
import bohdan.stasiv.buyitem.entity.Orders;
import bohdan.stasiv.buyitem.exception.WrongInputException;
import bohdan.stasiv.buyitem.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private CustomersService customersService;

    public DataResponse<OrdersResponse> findAllByCustomerId(Long customerId, PaginationRequest paginationRequest) throws WrongInputException {
        Customers customer = customersService.findOne(customerId);
        Page<Orders> byCustomer = ordersRepository.findAllByCustomer(customer, paginationRequest.mapToPageRequest());
        return new DataResponse<>(byCustomer.get().map(OrdersResponse::new).collect(Collectors.toList()),
                byCustomer.getTotalPages(), byCustomer.getTotalElements());
    }

    public OrdersResponse create(OrdersRequest ordersRequest) throws WrongInputException {
        return new OrdersResponse(ordersRequestToOrders(null, ordersRequest));
    }

    public Orders findOne(Long id) throws WrongInputException {
        return ordersRepository.findById(id).orElseThrow(() -> new WrongInputException("Order with id " + id + " not exists"));
    }

    public OrdersResponse findOneById(Long id) {
        Optional<Orders> ordersOptional = ordersRepository.findById(id);
        if (ordersOptional.isPresent()) {
            return new OrdersResponse(ordersOptional.get());
        } else {
            throw new IllegalArgumentException("Order with id " + id + " not found");
        }
    }

    public List<OrdersResponse> findAll() {
        return ordersRepository.findAll().stream().map(OrdersResponse::new).collect(Collectors.toList());
    }

    public DataResponse<OrdersResponse> findAll(PaginationRequest pagination) {
        Page<Orders> all = ordersRepository.findAll(pagination.mapToPageRequest());
        return new DataResponse<>(all.get().map(OrdersResponse::new).collect(Collectors.toList()),
                all.getTotalPages(), all.getTotalElements());
    }

    public OrdersResponse update(Long id, OrdersRequest ordersRequest) throws WrongInputException {
        return new OrdersResponse(ordersRequestToOrders(findOne(id), ordersRequest));
    }

    public void delete(Long id) throws WrongInputException {
        ordersRepository.delete(findOne(id));
    }

    private Orders ordersRequestToOrders(Orders orders, OrdersRequest request) throws WrongInputException {
        if (orders == null) {
            orders = new Orders();
        }
        orders.setCustomer(customersService.findOne(request.getCustomerId()));
//        orders.setName(request.getName());
//        orders.setVolume(request.getVolume());
//        orders.setYear(request.getYear());
        return ordersRepository.save(orders);
    }
}
