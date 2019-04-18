package bohdan.stasiv.buyitem.controller;

import bohdan.stasiv.buyitem.exception.WrongInputException;
import bohdan.stasiv.buyitem.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Controller
@RequestMapping
public class ProductsController {

    private String adminPagePath = "admin";

    @Autowired
    private ProductsService productsService;

//	@Autowired
//	private FileStorageService fileStorageService;

    //	/**
//	 * Adds new product.
//	 *
//	 * @param model
//	 * @return
//	 */
    @GetMapping("/admin/product/create")
    public String showProductAddingForm(/*Model model*/) {
//		model.addAttribute("productList", productService.getProductProductList());
//		model.addAttribute("product", new Product());
        return "/" + adminPagePath + "/products-management";
    }

    @GetMapping("/admin/products")
    public String showProductsTable(/*Model model*/) {
//		model.addAttribute("productList", productService.getProductProductList());
//		model.addAttribute("product", new Product());
//        return "/" + adminPagePath + "/product-management";
        return "/" + adminPagePath + "/products-management";
    }


    //	/**
//	 * Updates existing product.
//	 *
//	 * @param productId
//	 * @param model
//	 * @return
//	 */
    @GetMapping("/admin/product/update/{id}")
    public String showProductUpdatingForm(@PathVariable("id") long id
            /*, Model model*/
    ) {
//		model.addAttribute("productList", productService.getProductProductList());
//		model.addAttribute("product", productService.find(productId));
        return "/" + adminPagePath + "/products-management";
    }

    //	/**
//	 * Adds a new or updates an existing product. Also saves the static product
//	 * image if present.
//	 *
//	 * @param request
//	 * @param product
//	 * @param result
//	 * @return
//	 */
//    @PostMapping(/*value = {"/submit", "/admin/product-form-update/submit"}*/)
//    public String addOrUpdateProduct(
            /*HttpServletRequest request,
			@Valid @ModelAttribute("product") Product product,
			BindingResult result*/
//            ) {

    // Validate form data
//		if (result.hasErrors()) {
//			return "/" + adminPagePath + "/product-form";
//		}
//
//		if (product.getProductId() == null) {
//			productService.add(product);
//		} else {
//			productService.update(product);
//		}
//
//		// Get root directory
//		String rootDir = request.getSession().getServletContext().getRealPath("/");
//		// Save product image
//		fileStorageService.storeProductImage(product, rootDir);

//        return "redirect:/" + adminPagePath + "/products-inventory";
//    }

    //	/**
//	 * Deletes product image if present. Then removes the product.
//	 *
//	 * @param request
//	 * @param productId
//	 * @return
//	 */
    @GetMapping("/admin/product/delete/{id}")
    public String deleteProduct(
            /*HttpServletRequest request,*/
            @PathVariable("id") long id) throws WrongInputException {
//		productsService.delete(id);

//		Products products = productsService.find(id);
//
//		// Get root directory
//		String rootDir = request.getSession().getServletContext().getRealPath("/");
//		// Delete image if exists
//		fileStorageService.deleteProductImage(product, rootDir);
//
//		// Then delete product from persistence layer
//		productService.remove(product);
//		return "redirect:/products/list/page/1";
//		return "redirect:/" + adminPagePath + "/products-inventory";
        return "redirect:/admin/products";
    }

//    private final int PAGE_SIZE = 10;

    ////////////////////user/////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping("/products")
    public String showProducts() {
        return "redirect:/products/list/page/1";
    }

    @GetMapping("/products/list")
    public String showProductsList() {
        return "redirect:/products/list/page/1";
    }

    @GetMapping("/products/list/page/{pageNumber}")
    public String showProductsListPage(@PathVariable("pageNumber") int pageNumber/*, Model model*/) {

//        List<Products> productsList = null;
//        try {
//            productsList = productsService.getPagedList(pageNumber, PAGE_SIZE);
//        } catch (IllegalArgumentException e) {
//            // When invalid page number is supplied, view redirects to error page, with
//            // back button linked to products list.
//            model.addAttribute("backLink", "/products/list");
//            return "error/page-not-exist";
//        }

//        model.addAttribute("productsList", productsList);
//        model.addAttribute("productsTotalCount", productsService.getTotalCount());
//        model.addAttribute("pageCount", productsService.getPageCount(PAGE_SIZE));
//        model.addAttribute("currentPageNumber", pageNumber);

        String productslist = null;
        if (pageNumber > 0) {
            productslist = "/products-list";
        } else {
            productslist = "/bad-request-page";
        }
        return productslist;
    }

    @GetMapping("/product/detail/{id}")
//    @ResponseBody
    public String showProductDetail(@PathVariable("id")  /*Long*/ long id
//                                    ,
//                                    @RequestParam(value = "backToHome", required = false) boolean backToHome,
//                                    @RequestParam(value = "backLinkPageNumber", required = false) Integer backLinkPageNumber,
//                                    @RequestParam(value = "onSearch", required = false) boolean onSearch,
//                                    @RequestParam(value = "keyword", required = false) String keyword,
//                                    Model model
    ) {

//        model.addAttribute("products", productsService.find(productsId));
//
//        if (backLinkPageNumber == null) {
//            // Set to 1 if not provided.
//            backLinkPageNumber = 1;
//        }
//
//        model.addAttribute("backToHome", backToHome);
//        model.addAttribute("backLinkPageNumber", backLinkPageNumber);
//        model.addAttribute("onSearch", onSearch);
//        model.addAttribute("keyword", keyword);

        String productDetail = null;
        if (id > 0) {
            productDetail = "/product-detail";
        } else {
            productDetail = "/bad-request-page";
        }
        return productDetail;
    }

    @GetMapping("/products/list/search/{pageNumber}")
    public String searchProducts(@PathVariable("pageNumber") int pageNumber,
                                 @RequestParam("keyword") String keyword/*, Model model*/) {

//        List<Products> productsList = null;

//        try {
//            productsList = productsService.getPagedSearchList(keyword, pageNumber, PAGE_SIZE);
//        } catch (IllegalArgumentException e) {
//            // When invalid page number is supplied, view redirects to error page, with
//            // back button linked to products list.
//            model.addAttribute("backLink", "/products/list");
//            return "error/page-not-exist";
//        }

//        model.addAttribute("productsList", productsList);
////		model.addAttribute("productsTotalCount", productsService.getTotalCount());
//        model.addAttribute("pageCount", productsService.getSearchPageCount(keyword, PAGE_SIZE));
//        model.addAttribute("currentPageNumber", pageNumber);
//        model.addAttribute("keyword", keyword);

        String productslist = null;
        if (pageNumber > 0) {
            productslist = "/products-list";
        } else {
            productslist = "/bad-request-page";
        }
        return productslist;
    }
}
