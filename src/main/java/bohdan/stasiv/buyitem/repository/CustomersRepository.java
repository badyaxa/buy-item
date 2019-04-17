package bohdan.stasiv.buyitem.repository;

import bohdan.stasiv.buyitem.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomersRepository extends JpaRepository<Customers, Long> {
}
