package bohdan.stasiv.buyitem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin
@Controller
@RequestMapping("/admin")
public class AdminController {

    private String adminPagePath = "admin";

//    @Autowired
//    private ProductService productService;
//
//    @Autowired
//    private CustomerOrderService customerOrderService;

    @GetMapping
    public String showAdminHomepage() {
        return adminPagePath + "/index";
    }

//    /**
//     * Show product inventory list.
//     *
//     * @param model
//     * @return
//     */
//    @GetMapping("/products")
//    public String showProductInventoryPage(/*Model model*/) {
////        model.addAttribute("productList", productService.list());
//        return "/" + adminPagePath + "/product-inventory";
//    }
//
//    @GetMapping("/product-form")
//    public String showProductForm(/*Model model*/) {
//        return "/" + adminPagePath + "/product-form";
//    }

//    /**
//     * Show product inventory list.
//     *
//     * @param model
//     * @return
//     */
//    @GetMapping("/orders")
//    public String showCustomerOrderPage(/*Model model*/) {
////        model.addAttribute("customerOrderList", customerOrderService.list());
//        return "/" + adminPagePath + "/order-management";
//    }
//
//    @GetMapping("/customers")
//    public String showCustomerManagementPage(/*Model model*/) {
//        // TODO
//        return "/" + adminPagePath + "/customer-management";
//    }



}
