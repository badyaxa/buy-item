package bohdan.stasiv.buyitem.repository;

import bohdan.stasiv.buyitem.entity.Carts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartsRepository extends JpaRepository<Carts, Long> {
}
