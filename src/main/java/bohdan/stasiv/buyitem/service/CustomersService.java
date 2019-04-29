package bohdan.stasiv.buyitem.service;

import bohdan.stasiv.buyitem.dto.request.CustomersRequest;
import bohdan.stasiv.buyitem.dto.request.PaginationRequest;
import bohdan.stasiv.buyitem.dto.response.CustomersResponse;
import bohdan.stasiv.buyitem.dto.response.DataResponse;
import bohdan.stasiv.buyitem.entity.Carts;
import bohdan.stasiv.buyitem.entity.Customers;
import bohdan.stasiv.buyitem.entity.Role;
import bohdan.stasiv.buyitem.exception.WrongInputException;
import bohdan.stasiv.buyitem.repository.CartsRepository;
import bohdan.stasiv.buyitem.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomersService {

    @Autowired
    private CustomersRepository customersRepository;

    @Autowired
    private CartsRepository cartsRepository;

    public CustomersResponse create(CustomersRequest request) {
        return new CustomersResponse(customersRequestToCustomers(request, null));
    }

    public Customers findOne(Long id) throws WrongInputException {
        return customersRepository.findById(id)
                .orElseThrow(() -> new WrongInputException("Customer with id " + id + " not exists"));
    }

    public CustomersResponse findOneById(Long id) {
        Optional<Customers> categoriesOptional = customersRepository.findById(id);
        if (categoriesOptional.isPresent()) {
            return new CustomersResponse(categoriesOptional.get());
        } else {
            throw new IllegalArgumentException("Customer with id " + id + " not found");
        }
    }

    public List<CustomersResponse> findAll() {
        return customersRepository.findAll().stream()
                .map(CustomersResponse::new)
                .collect(Collectors.toList());
    }

    public DataResponse<CustomersResponse> findAll(PaginationRequest pagination) {
        Page<Customers> all = customersRepository.findAll(pagination.mapToPageRequest());
        return new DataResponse<>(all.get().map(CustomersResponse::new).collect(Collectors.toList()),
                all.getTotalPages(), all.getTotalElements());
    }

    public CustomersResponse update(CustomersRequest request, Long id) throws WrongInputException {
        return new CustomersResponse(customersRequestToCustomers(request, findOne(id)));
    }

    public void delete(Long id) throws WrongInputException {
        customersRepository.delete(findOne(id));
    }

    private Customers customersRequestToCustomers(CustomersRequest request, Customers customer) {
        if (customer == null) {
            customer = new Customers();
            Carts cart = new Carts();
            cartsRepository.save(cart);
            customer.setCart(cart);
        }
        customer.setLogin(request.getLogin());
        customer.setPassword(request.getLogin());
        customer.setRole(Role.USER);
        return customersRepository.save(customer);
    }
}
