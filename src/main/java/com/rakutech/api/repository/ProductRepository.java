package com.rakutech.api.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.rakutech.api.model.Product;

public interface ProductRepository extends JpaRepositoryImplementation<Product, Long> {

}
