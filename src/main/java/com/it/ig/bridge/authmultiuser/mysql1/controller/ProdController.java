package com.it.ig.bridge.authmultiuser.mysql1.controller;

import com.it.ig.bridge.authmultiuser.mysql1.entities.Product;
import com.it.ig.bridge.authmultiuser.mysql1.service.ProdService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProdController {

    private final ProdService prodService;

    @PostMapping("/")
    public ResponseEntity<Product> createdProduct(@RequestBody Product product) {
        Product prod = prodService.createProd(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(prod);
    }

    @PutMapping("/{prodId} ")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable Integer prodId){
        Product updateProducts = prodService.updateProduct(product, prodId);
        return ResponseEntity.ok(updateProducts);
    }
    @GetMapping("/{prodId}")
    public ResponseEntity<Product> getProdById(@PathVariable Integer prodId){
        return ResponseEntity.ok(prodService)
    }
}
