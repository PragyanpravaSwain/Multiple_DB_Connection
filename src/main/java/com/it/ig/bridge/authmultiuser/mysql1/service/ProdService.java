package com.it.ig.bridge.authmultiuser.mysql1.service;

import com.it.ig.bridge.authmultiuser.mysql1.entities.Product;

import java.util.List;

public interface ProdService {
    Product createProd(Product product);
    Product updateProduct(Product product, Integer prodId);
    Product getProdById(Integer prodId);
    List<Product> getAllProd();
    void deleteProd(Integer prodId);
}
