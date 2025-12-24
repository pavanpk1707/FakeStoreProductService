package com.code.FirstSpringAPI.Controllers;

import com.code.FirstSpringAPI.Models.Product;
import com.code.FirstSpringAPI.Services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id)
    {
        // Call FakeStore API Here to get the Product with given id.
        Product product = productService.getProductById(id);

        ResponseEntity<Product> responseEntity;

        if(product == null)
        {
            responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            return responseEntity;
        }
        return new ResponseEntity<>(product, HttpStatus.OK);

    }

    // Get All Products
    //localhost:8080/products
    @GetMapping()
    public List<Product> getAllProducts()
    {

        return productService.getAllProducts();
    }

    // create a new Product
    // delete a product
    // update a product - Partial Update (PATCH)
    // replace product - Replace (PUT)

    @PutMapping("{id}")
    public Product replaceProduct(@PathVariable("id")  long id, @RequestBody Product product)
    {
        return replaceProduct(id,product);
    }


}
