package bohdan.stasiv.buyitem.controller;

import bohdan.stasiv.buyitem.exception.WrongInputException;
import bohdan.stasiv.buyitem.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@Controller
@RequestMapping
public class CategoriesController {

    private String adminPagePath = "admin";

    @Autowired
    private CategoriesService categoriesService;

//	@Autowired
//	private FileStorageService fileStorageService;

    //	/**
//	 * Adds new category.
//	 *
//	 * @param model
//	 * @return
//	 */
    @GetMapping("/admin/category/create")
    public String showCategoryAddingForm(/*Model model*/) {
//		model.addAttribute("categoryList", categoryService.getCategoryCategoryList());
//		model.addAttribute("category", new Category());
        return "/" + adminPagePath + "/categories-management";
    }

    @GetMapping("/admin/categories")
    public String showCategoriesTable(/*Model model*/) {
//		model.addAttribute("categoryList", categoryService.getCategoryCategoryList());
//		model.addAttribute("category", new Category());
//        return "/" + adminPagePath + "/category-management";
        return "/" + adminPagePath + "/categories-management";
    }


    //	/**
//	 * Updates existing category.
//	 *
//	 * @param categoryId
//	 * @param model
//	 * @return
//	 */
    @GetMapping("/admin/category/update/{id}")
    public String showCategoryUpdatingForm(@PathVariable("id") long id
            /*, Model model*/
    ) {
//		model.addAttribute("categoryList", categoryService.getCategoryCategoryList());
//		model.addAttribute("category", categoryService.find(categoryId));
        return "/" + adminPagePath + "/categories-management";
    }

    //	/**
//	 * Adds a new or updates an existing category. Also saves the static category
//	 * image if present.
//	 *
//	 * @param request
//	 * @param category
//	 * @param result
//	 * @return
//	 */
//    @PostMapping(/*value = {"/submit", "/admin/category-form-update/submit"}*/)
//    public String addOrUpdateCategory(
            /*HttpServletRequest request,
			@Valid @ModelAttribute("category") Category category,
			BindingResult result*/
//            ) {

    // Validate form data
//		if (result.hasErrors()) {
//			return "/" + adminPagePath + "/category-form";
//		}
//
//		if (category.getCategoryId() == null) {
//			categoryService.add(category);
//		} else {
//			categoryService.update(category);
//		}
//
//		// Get root directory
//		String rootDir = request.getSession().getServletContext().getRealPath("/");
//		// Save category image
//		fileStorageService.storeCategoryImage(category, rootDir);

//        return "redirect:/" + adminPagePath + "/categories-inventory";
//    }

    //	/**
//	 * Deletes category image if present. Then removes the category.
//	 *
//	 * @param request
//	 * @param categoryId
//	 * @return
//	 */
    @GetMapping("/admin/category/delete/{id}")
    public String deleteCategory(
            /*HttpServletRequest request,*/
            @PathVariable("id") long id) throws WrongInputException {
//		categoriesService.delete(id);

//		Categories categories = categoriesService.find(id);
//
//		// Get root directory
//		String rootDir = request.getSession().getServletContext().getRealPath("/");
//		// Delete image if exists
//		fileStorageService.deleteCategoryImage(category, rootDir);
//
//		// Then delete category from persistence layer
//		categoryService.remove(category);
//		return "redirect:/categories/list/page/1";
//		return "redirect:/" + adminPagePath + "/categories-inventory";
        return "redirect:/admin/categories";
    }

//    private final int PAGE_SIZE = 10;

    ////////////////////user/////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/categories")
    public String showCategoriesListPage(@RequestParam("page") Optional<Integer> page) {
        return "/categories-list";
    }

    @GetMapping("/category/detail/{id}")
//    @ResponseBody
    public String showCategoryDetail(@PathVariable("id")  /*Long*/ long id
//                                    ,
//                                    @RequestParam(value = "backToHome", required = false) boolean backToHome,
//                                    @RequestParam(value = "backLinkPageNumber", required = false) Integer backLinkPageNumber,
//                                    @RequestParam(value = "onSearch", required = false) boolean onSearch,
//                                    @RequestParam(value = "keyword", required = false) String keyword,
//                                    Model model
    ) {

//        model.addAttribute("categories", categoriesService.find(categoriesId));
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

        String categoryDetail = null;
        if (id > 0) {
            categoryDetail = "/category-detail";
        } else {
            categoryDetail = "/bad-request-page";
        }
        return categoryDetail;
    }

    @GetMapping("/categories/list/search/{pageNumber}")
    public String searchCategories(@PathVariable("pageNumber") int pageNumber,
                                   @RequestParam("keyword") String keyword/*, Model model*/) {

//        List<Categories> categoriesList = null;

//        try {
//            categoriesList = categoriesService.getPagedSearchList(keyword, pageNumber, PAGE_SIZE);
//        } catch (IllegalArgumentException e) {
//            // When invalid page number is supplied, view redirects to error page, with
//            // back button linked to categories list.
//            model.addAttribute("backLink", "/categories/list");
//            return "error/page-not-exist";
//        }

//        model.addAttribute("categoriesList", categoriesList);
////		model.addAttribute("categoriesTotalCount", categoriesService.getTotalCount());
//        model.addAttribute("pageCount", categoriesService.getSearchPageCount(keyword, PAGE_SIZE));
//        model.addAttribute("currentPageNumber", pageNumber);
//        model.addAttribute("keyword", keyword);

//        String categorieslist = null;
//        if (pageNumber > 0) {
//            categorieslist = "/categories-list";
//        } else {
//            categorieslist = "/bad-request-page";
//        }
//        return categorieslist;
        return "/categories-list";
    }
}
