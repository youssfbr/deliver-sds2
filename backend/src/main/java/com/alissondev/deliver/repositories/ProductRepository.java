package com.alissondev.deliver.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alissondev.deliver.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	List<Product> findAllByOrderByNameAsc();
}
