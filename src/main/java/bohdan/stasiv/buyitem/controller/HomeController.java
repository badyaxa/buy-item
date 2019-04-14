package bohdan.stasiv.buyitem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin
@Controller
@RequestMapping
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

}