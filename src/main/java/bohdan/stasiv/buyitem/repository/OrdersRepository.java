package bohdan.stasiv.buyitem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import bohdan.stasiv.buyitem.entity.Orders;

@Repository
public interface OrdersRepository extends CrudRepository<Orders, Long> {
}
