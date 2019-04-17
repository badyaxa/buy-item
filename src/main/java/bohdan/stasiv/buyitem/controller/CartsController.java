package bohdan.stasiv.buyitem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin
@Controller
@RequestMapping
public class CartsController {

    private String adminPagePath = "admin";

    @GetMapping("/user/cart")
    public String showUserCart() {
        return "/cart";
    }

    @GetMapping("/admin/carts")
    public String showUsersCarts() {
        return "/" + adminPagePath + "/carts-management";
    }
}
