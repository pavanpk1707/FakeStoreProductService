package com.code.FirstSpringAPI.Controllers;

import com.code.FirstSpringAPI.Models.Product;
import com.code.FirstSpringAPI.Services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController // That this controller going to REST Http API's
@RequestMapping("/products")
// localhost:8080/products
public class ProductController
{
    private ProductService productService;

    ProductController(ProductService productService)
    {
        this.productService = productService;
    }

    // Get a Product By Id
    //localhost:8080/products/1
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id)
    {
        // Call FakeStore API Here to get the Product with given id.
        RestTemplate restTemplate = new RestTemplate();
        return productService.getProductById(id);
    }

    // Get All Products
    //localhost:8080/products
    @GetMapping()
    public List<Product> getAllProducts()
    {
        return new ArrayList<>();
    }

    // create a new Product
    // delete a product
    // update a product - Partial Update (PATCH)
    // replace product - Replace (PUT)


}
