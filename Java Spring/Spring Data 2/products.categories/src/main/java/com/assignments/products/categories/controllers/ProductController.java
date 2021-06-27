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
public class ProductController {

	private final ProductService productService;
	private final CategoryService categoryService;

	

	public ProductController(ProductService productService, CategoryService categoryService) {
		this.productService = productService;
		this.categoryService = categoryService;
	}

	@RequestMapping("/products/new")
	public String newProduct(@ModelAttribute("product") Product product) {

		return "newproduct.jsp";
	}

	@RequestMapping(value = "/products/new/create", method = RequestMethod.POST)
	public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if (result.hasErrors()) {
			return "newproduct.jsp";
		} else {
			productService.createProduct(product);
			return "redirect:/products/new";
		}
	}

	@RequestMapping("/products/{id}")
	public String detailsProduct(@PathVariable("id") Long id, Model model) {
		Product product = productService.findProduct(id);
		List<Category> othercategories=productService.findOtherCategories(product);
		model.addAttribute("product", product);
		model.addAttribute("other", othercategories);
		return ("detailsproduct.jsp");
	}
	
	@RequestMapping(value="/add/{id}/category", method = RequestMethod.POST )
	public String addCategory(@PathVariable("id") Long product_id,@RequestParam("categories") Long category_id) {
		Product product = productService.findProduct(product_id);
		List<Category> categories = productService.findProductCategories(product);
		categories.add(categoryService.findCategory(category_id));
		product.setCategories(categories);
		product=productService.updateProduct(product);
		return "redirect:/products/{id}";
	}

}
