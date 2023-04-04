package com.bumblebee.heshan.repository;

import com.bumblebee.heshan.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository  extends JpaRepository<Product,Long> {
}
