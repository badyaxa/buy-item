package bohdan.stasiv.buyitem.service;

import bohdan.stasiv.buyitem.dto.request.CategoriesRequest;
import bohdan.stasiv.buyitem.dto.request.PaginationRequest;
import bohdan.stasiv.buyitem.dto.response.CategoriesResponse;
import bohdan.stasiv.buyitem.dto.response.DataResponse;
import bohdan.stasiv.buyitem.entity.Categories;
import bohdan.stasiv.buyitem.exception.WrongInputException;
import bohdan.stasiv.buyitem.repository.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriesService {

    @Autowired
    private CategoriesRepository categoriesRepository;

    public CategoriesResponse create(CategoriesRequest request) {
        return new CategoriesResponse(categoryRequestToCategories(request, null));
    }

    private Categories categoryRequestToCategories(CategoriesRequest request, Categories category) {
        if (category == null) {
            category = new Categories();
        }
        category.setName(request.getName());
        return categoriesRepository.save(category);
    }

    public CategoriesResponse update(CategoriesRequest request, Long id) throws WrongInputException {
        return new CategoriesResponse(categoryRequestToCategories(request, findOne(id)));
    }

    public Categories findOne(Long id) throws WrongInputException {
        return categoriesRepository
                .findById(id)
                .orElseThrow(() -> new WrongInputException("Categories with id " + id + " not exists"));
    }

    public void delete(Long id) {
        categoriesRepository.deleteById(id);
    }

    public CategoriesResponse findOneById(Long id) {
        Optional<Categories> categoriesOptional = categoriesRepository.findById(id);
        if (categoriesOptional.isPresent()) {
            return new CategoriesResponse(categoriesOptional.get());
        } else {
            throw new IllegalArgumentException("Category with id " + id + " not found");
        }
    }

    public List<CategoriesResponse> findAll() {
        return categoriesRepository
                .findAll()
                .stream()
                .map(CategoriesResponse::new)
                .collect(Collectors.toList());
    }

    public DataResponse<CategoriesResponse> findAll(PaginationRequest pagination) {
        Page<Categories> all = categoriesRepository.findAll(pagination.mapToPageRequest());
        return new DataResponse<>(all.get().map(CategoriesResponse::new).collect(Collectors.toList()), all.getTotalPages(), all.getTotalElements());
    }
}
