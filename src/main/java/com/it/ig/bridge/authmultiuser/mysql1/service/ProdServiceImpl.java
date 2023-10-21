package com.it.ig.bridge.authmultiuser.mysql1.service;

import com.it.ig.bridge.authmultiuser.mysql1.entities.Product;
import com.it.ig.bridge.authmultiuser.mysql1.repo.ProductRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProdServiceImpl implements ProdService {

    private final ProductRepo productRepo;

    @Override
    public Product createProd(Product product) {
        Product savedProduct = this.productRepo.save(product);
        return savedProduct;
    }

    @Override
    public Product updateProduct(Product product, Integer prodId) {
        Optional<Product> existingProduct = this.productRepo.findById(prodId);
        if (existingProduct.isPresent()) {
            Product updatedProduct = existingProduct.get();
            updatedProduct.setFirstName(product.getFirstName());
            updatedProduct.setLastName(product.getLastName());
            updatedProduct.setPassword(product.getPassword());
            updatedProduct.setEmail(product.getEmail());
            updatedProduct.setAbout(product.getAbout());

            return productRepo.save(updatedProduct);
        } else {
            return null;
        }
    }

    @Override
    public Product getProdById(Integer prodId) {
        Product product = this.productRepo.findById(prodId).orElse(null);
        return product;
    }

    @Override
    public List<Product> getAllProd() {
        List<Product> products = this .productRepo.findAll();
        return products;
    }

    @Override
    public void deleteProd(Integer prodId) {
        this.productRepo.deleteById(prodId);
    }
}
