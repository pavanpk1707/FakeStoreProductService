package com.code.FirstSpringAPI.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto
{
    private long id;
    private String title;
    private double price;
    private String desc;
    private String image;
    private String category;
}
