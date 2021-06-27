package com.assignments.products.categories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assignments.products.categories.models.Category;
import com.assignments.products.categories.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	List<Product> findAll();

	List<Product> findByCategories(Category category);

	List<Product> findByCategoriesIdIsNull();

	List<Product> findByCategoriesNotContains(Category category);
}
