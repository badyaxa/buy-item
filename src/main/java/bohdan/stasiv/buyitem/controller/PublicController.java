package bohdan.stasiv.buyitem.controller;

import bohdan.stasiv.buyitem.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin
@Controller
@RequestMapping("/")
public class PublicController {

    @Autowired
    private ProductsService productsService;

    @GetMapping
    public String showHomePage(
//            Model model
    ) {

        // Only get the first 8 items for home page to display.
//        model.addAttribute("suggestionList", productsService.getPagedList(1, 8));
        return "index";
    }

    @GetMapping("contact")
    public String showContactPage() {
        return "contact";
    }


//    @GetMapping
//    public String index() {
//        return "index";
//    }

}
