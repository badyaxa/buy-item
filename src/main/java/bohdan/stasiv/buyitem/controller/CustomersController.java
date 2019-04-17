package bohdan.stasiv.buyitem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Controller
@RequestMapping
//@SessionAttributes("sessionUsername")
public class CustomersController {

    private String adminPagePath = "admin";

    @GetMapping("/admin/customers")
    public String showCustomersTable() {
        return "/" + adminPagePath + "/customers-management";
    }

//	@Autowired
//	private UsersService usersService;
//
//	@Autowired
//	private CustomersService customerService;
//
//	@Autowired
//	private CredentialService credentialService;

    // Add the session attribute before every request.
//	@ModelAttribute("sessionUsername")
//	public String getSessionUsername(Authentication auth) {
//		return credentialService.getUsername(auth);
//	}

    @GetMapping("/user")
    public String showCustomerHomepage(
//			@ModelAttribute("sessionUsername") String username,
//			Model model
    ) {

//		/*
//		 * If no customer is bound to the user, simply redirect to customer
//		 * register wizard flow.
//		 */
//		if (!userService.isCustomerBoundToUser(username)) {
//			return "redirect:/customer/register-wizard";
//		}
//
//		model.addAttribute("customer", userService.getCustomer(username));
//
//		// Add order list and its status to model.
//		List<CustomerOrder> orderList = userService.getCustomer(username).getOrderList();
//		boolean orderListEmpty = false;
//
//		if (orderList.isEmpty()) {
//			orderListEmpty = true;
//		}
//
//		model.addAttribute("orderList", orderList);
//		model.addAttribute("orderListEmpty", orderListEmpty);

        return "/customer-home-page";
    }

}
