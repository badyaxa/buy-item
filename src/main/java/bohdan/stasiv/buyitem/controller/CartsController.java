package bohdan.stasiv.buyitem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin
@Controller
@RequestMapping
public class CartsController {

    @GetMapping("/user/cart")
    public String showUserCart() {
        return "/cart";
    }
}
