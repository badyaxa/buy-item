package bohdan.stasiv.buyitem.repository;

import bohdan.stasiv.buyitem.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
