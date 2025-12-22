package com.code.FirstSpringAPI.Services;

import com.code.FirstSpringAPI.Models.Category;
import com.code.FirstSpringAPI.Models.Product;
import com.code.FirstSpringAPI.dtos.FakeStoreProductDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreProductService implements ProductService
{
    private final RestTemplate restTemplate;

    FakeStoreProductService(RestTemplate restTemplate)
    {
        this.restTemplate = restTemplate;
    }

    private Product convertFakeStoreDtoToProduct(FakeStoreProductDto dto)
    {
        Product product = new Product();
        product.setId(dto.getId());
        product.setTitle(dto.getTitle());
        product.setImage(dto.getImage());
        product.setPrice(dto.getPrice());
        product.setDescription(dto.getDesc());

        Category category = new Category();
        category.setDesc(dto.getCategory());
        product.setCategory(category);

        return product;

    }
    @Override
    public Product getProductById(Long id) {

        // 1st param -> url
        // 2nd param -> Response
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);
        // Covert DTO into product Object

        if(fakeStoreProductDto == null)
        {
            return null;
        }

        return convertFakeStoreDtoToProduct(fakeStoreProductDto);
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }
}
