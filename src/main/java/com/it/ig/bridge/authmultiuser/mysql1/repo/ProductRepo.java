package com.it.ig.bridge.authmultiuser.mysql1.repo;

import com.it.ig.bridge.authmultiuser.mysql1.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Integer> {
    Product findByName(String name);
}
