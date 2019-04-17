package bohdan.stasiv.buyitem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin
@Controller
@RequestMapping
public class OrdersController {

    private String adminPagePath = "admin";

    @GetMapping("/user/orders")
    public String showUserOrders() {
        return "/orders-list";
    }

    @GetMapping("/admin/orders")
    public String showUsersOrders() {
        return "/" + adminPagePath + "/orders-management";
    }
}
