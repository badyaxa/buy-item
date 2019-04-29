package bohdan.stasiv.buyitem.repository;

import bohdan.stasiv.buyitem.entity.Customers;
import bohdan.stasiv.buyitem.entity.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {

//    List<Orders> findByVolume(Double from, Double to);

//    List<Orders> findAllByNameLike(String name);

    Page<Orders> findAllByCustomer(Customers customer, Pageable pageable);

}
