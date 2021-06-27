package com.assignments.products.categories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.assignments.products.categories.models.Category;
import com.assignments.products.categories.models.Product;
import com.assignments.products.categories.repositories.CategoryRepository;
import com.assignments.products.categories.repositories.ProductRepository;

@Service
public class CategoryService {

	private final CategoryRepository categoryRepository;
	private final ProductRepository productRepository;

	public CategoryService(CategoryRepository categoryRepository, ProductRepository productRepository) {
		this.categoryRepository = categoryRepository;
		this.productRepository = productRepository;
	}

	public List<Category> allCategories() {
		return categoryRepository.findAll();
	}

	public Category createCategory(Category category) {
		return categoryRepository.save(category);
	}

	public Category findCategory(Long id) {
		Optional<Category> optionalCategory = categoryRepository.findById(id);
		if (optionalCategory.isPresent()) {
			return optionalCategory.get();
		} else {
			return null;
		}
	}
	public List<Product> findCategoryProducts(Category category) {
		return productRepository.findByCategories(category);
	}

	
	public List<Product> findOtherProducts(Category category) {
			return productRepository.findByCategoriesNotContains(category);
		
		}
	public Category updateCategory(Category category) {
		return categoryRepository.save(category);
	}

}