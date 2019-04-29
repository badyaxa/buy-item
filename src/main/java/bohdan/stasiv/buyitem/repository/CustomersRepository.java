package bohdan.stasiv.buyitem.repository;

import bohdan.stasiv.buyitem.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomersRepository extends JpaRepository<Customers, Long> {
//    @Query("select c from users c join fetch c.orders where c.name=:cName")
//    Customers findByNameWithFetch(@Param("cName") String name);
}
