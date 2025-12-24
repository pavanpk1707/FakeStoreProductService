package com.code.FirstSpringAPI.Services;

import com.code.FirstSpringAPI.Models.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService
{
    Product getProductById(Long id);
    List<Product> getAllProducts();
    Product replaceProduct(long id, Product product);



}
