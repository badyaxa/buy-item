package bohdan.stasiv.buyitem.repository;

import bohdan.stasiv.buyitem.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends
//        CrudRepository<Products, Long>,
        JpaRepository<Products, Long>, JpaSpecificationExecutor<Products> {
    List<Products> findAllByNameLike(String name);
    List<Products> findByPriceIsBetween(Integer priceFrom, Integer priceTo);

}

//    List<Car> findByVolume(Double from, Double to);
// List<Engine> findByVolume(Double from, Double to);


//    @Query("select c from Car c where c.engine.power between :starts and :to")
//    List<Car> findAllByEnginePower(@Param("starts") Integer from, @Param("to") Integer to);


//    @Query("select c from Country c join fetch c.cars crs where c.name=:cName")
//    Country findByName(@Param("cName") String name);

//@Repository
//public interface ProductsRepository extends JpaRepository<Products, Long>, JpaSpecificationExecutor<Products> {}
//public interface CarRepository extends CrudRepository<Car, Long> {}
