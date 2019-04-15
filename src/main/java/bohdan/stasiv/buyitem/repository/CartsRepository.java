package bohdan.stasiv.buyitem.repository;

import bohdan.stasiv.buyitem.entity.Carts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartsRepository extends CrudRepository<Carts, Long> {
}
