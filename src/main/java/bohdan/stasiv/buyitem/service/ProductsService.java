package bohdan.stasiv.buyitem.service;

import bohdan.stasiv.buyitem.dto.request.PaginationRequest;
import bohdan.stasiv.buyitem.dto.request.ProductsRequest;
import bohdan.stasiv.buyitem.dto.response.DataResponse;
import bohdan.stasiv.buyitem.dto.response.ProductsResponse;
import bohdan.stasiv.buyitem.entity.Categories;
import bohdan.stasiv.buyitem.entity.Products;
import bohdan.stasiv.buyitem.exception.WrongInputException;
import bohdan.stasiv.buyitem.repository.CategoriesRepository;
import bohdan.stasiv.buyitem.repository.ProductsRepository;
import bohdan.stasiv.buyitem.specification.ProductsSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private CategoriesService categoriesService;

    public DataResponse<ProductsResponse> findAllByCategoryId(Long categoryId, PaginationRequest paginationRequest) throws WrongInputException {
        Categories category = categoriesService.findOne(categoryId);
        Page<Products> byCategory = productsRepository.findAllByCategory(category, paginationRequest.mapToPageRequest());
        return new DataResponse<>(byCategory.get().map(ProductsResponse::new).collect(Collectors.toList()),
                byCategory.getTotalPages(), byCategory.getTotalElements());
    }

//    public DataResponse<ProductsResponse> findAllByCategoryId(Long categoryId, PaginationRequest paginationRequest) throws WrongInputException {
//        Categories category = categoriesService.findOne(categoryId);
//        Page<Products> byCategory = productsRepository.findAllByCategory(category, paginationRequest.mapToPageRequest());
//        return new DataResponse<>(byCategory.get().map(ProductsResponse::new).collect(Collectors.toList()),
//                byCategory.getTotalPages(), byCategory.getTotalElements());
//    }
//    @Autowired
//    private BrandsService brandsService;


    //create
    public ProductsResponse create(ProductsRequest productRequest) throws WrongInputException {
//        Products product = new Products();
//        product.setName(productRequest.getName());
//        product.setBrand(brandsService.findOne(productRequest.getBrandId()));

//        Products savedProduct = ;
//        product.setCategory(categoriesService.findOne(productRequest.getCategoryId()));
//        productsCategoriesRepository.getOne()
//
//        ProductsCategories productsCategories = new ProductsCategories();
//        productsCategories.seteeeee(productRequest.getCategoryId(),productRequest.);
//        productsCategories.setCategory(categoriesRepository.getOne());
//        return new ProductsResponse(productsRepository.save(product));

        return new ProductsResponse(productRequestToProducts(null, productRequest));
    }


    //read
    public Products findOne(Long id) throws WrongInputException {
        return productsRepository
                .findById(id)
                .orElseThrow(() -> new WrongInputException("Products with id " + id + " not exists"));
    }

    //    @Transactional
    public ProductsResponse findOneById(Long id) {
        Optional<Products> productsOptional = productsRepository.findById(id);
        if (productsOptional.isPresent()) {
            return new ProductsResponse(productsOptional.get());
        } else {
            //          return new ProductsResponse(HttpStatus.NOT_FOUND);
            throw new IllegalArgumentException("Products with id " + id + " not found");
        }
    }

    public List<ProductsResponse> findAll() {
        return productsRepository
                .findAll()
                .stream()
                .map(ProductsResponse::new)
                .collect(Collectors.toList());
    }

    public DataResponse<ProductsResponse> findAll(PaginationRequest pagination) {
        Page<Products> all = productsRepository.findAll(pagination.mapToPageRequest());
        return new DataResponse<>(all.get().map(ProductsResponse::new).collect(Collectors.toList()), all.getTotalPages(), all.getTotalElements());
    }

//    public DataResponse<ProductsResponse> findAllByBrandId(Long brandId, PaginationRequest paginationRequest) throws WrongInputException {
//        Brand brand = brandsService.findOne(brandId);
//        Page<Products> byBrand = productRepository.findAllByBrand(brand, paginationRequest.mapToPageRequest());
//        return new DataResponse<>(byBrand.get().map(ProductsResponse::new).collect(Collectors.toList()),
//                byBrand.getTotalPages(), byBrand.getTotalElements());
//    }

//    public DataResponse<ProductsResponse> findAllByCategoryId(Long categoryId, PaginationRequest paginationRequest) throws WrongInputException {
//        Categories category = categoriesService.findOne(categoryId);
//        Page<Products> byCategory = productsRepository.findAllByCategories(category, paginationRequest.mapToPageRequest());
//        return new DataResponse<>(byCategory.get().map(ProductsResponse::new).collect(Collectors.toList()), byCategory.getTotalPages(), byCategory.getTotalElements());
////    return new DataResponse<>(byCategory.stream().map(ProductsResponse::new).collect(Collectors.toList()), byCategory.getTotalPages(), byCategory.getTotalElements());
//    }
//    public DataResponse<OrdersResponse> findAllByCountryId(Long countryId, PaginationRequest paginationRequest) throws WrongInputException {
//        Country country = countryService.findOne(countryId);
//        Page<Car> byCountry = carRepository.findAllByCountry(country, paginationRequest.mapToPageRequest());
//        return new DataResponse<>(byCountry.get().map(OrdersResponse::new).collect(Collectors.toList()),byCountry.getTotalPages(), byCountry.getTotalElements());
//    }

    //update
    public ProductsResponse update(Long id, ProductsRequest productsRequest) throws WrongInputException {
        return new ProductsResponse(productRequestToProducts(findOne(id), productsRequest));
    }

    //delete
    public void delete(Long id) throws WrongInputException {
        productsRepository.delete(findOne(id));
    }

    private Products productRequestToProducts(Products product, ProductsRequest request) throws WrongInputException {
        if (product == null) {
            product = new Products();
        }
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setCategory(categoriesService.findOne(request.getCategoryId()));
//        product.setYear(request.getYear());
        return productsRepository.save(product);
    }


//    public DataResponse<ProductsResponse> findAllByCategoryId(String value, Long categoryId, Integer page, Integer size, String fieldName, Sort.Direction direction) {
//        Sort sort = Sort.by(direction, fieldName);
//        PageRequest pageRequest = PageRequest.of(page, size, sort);
//        Page<Products> productsPage;
//        if (value != null && !value.equals("")) {
//            ProductsSpecification specification = new ProductsSpecification(value);
//            productsPage = productsRepository.findAll(specification, pageRequest);
//        } else {
//            productsPage = productsRepository.findAll(pageRequest);
//        }
//        return new DataResponse<ProductsResponse>(productsPage.stream().map(ProductsResponse::new).collect(Collectors.toList()), productsPage);
//    }
//    public DataResponse<ProductsResponse> findAll(String value,/* String category,*/ Integer page, Integer size, String fieldName, Sort.Direction direction) {
//        Sort sort = Sort.by(direction, fieldName);
//        PageRequest pageRequest = PageRequest.of(page, size, sort);
//        Page<Products> productsPage;
//        if (value != null && !value.equals("")) {
////            ProductsSpecification specification = new ProductsSpecification(value);
//            productsPage = productsRepository.findAll(specification, pageRequest);
//        } else {
//            productsPage = productsRepository.findAll(pageRequest);
//        }
//        return new DataResponse<ProductsResponse>(productsPage.stream().map(ProductsResponse::new).collect(Collectors.toList()), productsPage);
//    }
    

//    @GetMapping("/products")
//    public List<ProductResponse> findAllProducts() {
//        return productService.findAll();
//    }
//    @GetMapping("/products")
//    public Iterable<Products> getAllP() {
//        return productsRepository.findAll();
//    }


//    @GetMapping("/data")
//    public List<String> getOneByName(@RequestParam(required = false) Integer count) {
//        List<String> data = new ArrayList<>();
//        count = count != null ? count : 3;
//        for (int i = 0; i < count; i++) {
//            data.add(String.format("%.2f", Math.random() * 100));
//        }
//        return data;
//    }
//
//    @PostMapping("/data")
//    public List<Car> findByVolume(@RequestBody CarFindByVolumeRequest request) {
//        System.out.println(request.getFrom());
//        System.out.println(request.getTo());
//        return carRepository.findByVolume(request.getFrom(), request.getTo());
//    }


//    public DataResponse<ProductsResponse> findByFilter(ProductsFilterRequest filterRequest) {
//        Page<Products> page = productRepository.findAll(
//                new ProductsSpecification(filterRequest),
//                filterRequest.getPagination().mapToPageRequest());
//
//        return new DataResponse<>(page.get().map(ProductsResponse::new).collect(Collectors.toList()), page.getTotalPages(), page.getTotalElements());
//
//    }

//    public DataResponse<ProductsResponse> findAllByBrandId(Long brandId, PaginationRequest paginationRequest) throws WrongInputException {
//        Brand brand = brandsService.findOne(brandId);
//        Page<Products> byBrand = productRepository.findAllByBrand(brand, paginationRequest.mapToPageRequest());
//        return new DataResponse<>(byBrand.get().map(ProductsResponse::new).collect(Collectors.toList()),
//                byBrand.getTotalPages(), byBrand.getTotalElements());
//    }

}
