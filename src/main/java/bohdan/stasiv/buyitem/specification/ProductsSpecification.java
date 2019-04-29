package bohdan.stasiv.buyitem.specification;

import bohdan.stasiv.buyitem.entity.Products;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ProductsSpecification implements Specification<Products> {

    private String value;

    public ProductsSpecification(String value) {
        this.value = value;
    }

    private Predicate findByName(Root<Products> root, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.like(root.get("name"), value);
    }

//    private Predicate findByCategory (Root<Products> root, CriteriaBuilder criteriaBuilder) {
//        return criteriaBuilder.equal(root.)
//    }

//    private Predicate findByFirstName(Root<Products> root, CriteriaBuilder criteriaBuilder){
//        return criteriaBuilder.like(root.get("firstName"), value);
//    }

//    private Predicate findByLastName(Root<Products> root, CriteriaBuilder criteriaBuilder){
//        return criteriaBuilder.like(root.get("lastName"), value);
//    }


    @Override
    public Predicate toPredicate(Root<Products> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.or(
//                findByFirstName(root, criteriaBuilder),
//                findByLastName(root,criteriaBuilder)
                findByName(root, criteriaBuilder)
        );
    }
}
