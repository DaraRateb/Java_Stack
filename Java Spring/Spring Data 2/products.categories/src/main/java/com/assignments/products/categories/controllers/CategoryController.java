package com.assignments.products.categories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.assignments.products.categories.models.Category;
import com.assignments.products.categories.models.Product;
import com.assignments.products.categories.services.CategoryService;
import com.assignments.products.categories.services.ProductService;

@Controller
public class CategoryController {
	private final CategoryService categoryService;
	private final ProductService productService;

	public CategoryController(CategoryService categoryService, ProductService productService) {
		this.categoryService = categoryService;
		this.productService = productService;
	}

	@RequestMapping("/categories/new")
	public String newProduct(@ModelAttribute("category") Category category) {

		return "newcategory.jsp";
	}

	@RequestMapping(value = "/categories/new/create", method = RequestMethod.POST)
	public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if (result.hasErrors()) {
			return "newcategory.jsp";
		} else {
			categoryService.createCategory(category);
			return "redirect:/categories/new";
		}
	}

	@RequestMapping("/categories/{id}")
	public String detailsCategory(@PathVariable("id") Long id, Model model) {
		Category category = categoryService.findCategory(id);
		List<Product> otherproducts = categoryService.findOtherProducts(category);
		model.addAttribute("category", category);
		model.addAttribute("other", otherproducts);
		return ("detailscategory.jsp");
	}

	@RequestMapping(value = "/add/{id}/product", method = RequestMethod.POST)
	public String addProduct(@PathVariable("id") Long category_id, @RequestParam("products") Long product_id) {
		Category category = categoryService.findCategory(category_id);
		List<Product> products = categoryService.findCategoryProducts(category);
		products.add(productService.findProduct(product_id));
		category.setProducts(products);
		category = categoryService.updateCategory(category);
		return "redirect:/categories/{id}";
	}

}
