package com.assignments.products.categories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assignments.products.categories.models.Category;
import com.assignments.products.categories.models.Product;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
	List<Category> findAll();

	List<Category> findByProducts(Product product);

	List<Category> findByProductsIdIsNull();
	
	List<Category> findByProductsNotContains(Product product);
}
