package com.assignments.products.categories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.assignments.products.categories.models.Category;
import com.assignments.products.categories.models.Product;
import com.assignments.products.categories.repositories.CategoryRepository;
import com.assignments.products.categories.repositories.ProductRepository;

@Service
public class ProductService {

	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;

	public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}

	public List<Product> allProducts() {
		return productRepository.findAll();
	}

	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	public Product findProduct(Long id) {
		Optional<Product> optionalProduct = productRepository.findById(id);
		if (optionalProduct.isPresent()) {
			return optionalProduct.get();
		} else {
			return null;
		}
	}

	public List<Category> findProductCategories(Product product) {
		return categoryRepository.findByProducts(product);
	}
	public List<Category> findOtherCategories(Product product){
		return categoryRepository.findByProductsNotContains(product);
	
	}
		

    public Product updateProduct(Product product) {
   	 return productRepository.save(product);
}
    
}
